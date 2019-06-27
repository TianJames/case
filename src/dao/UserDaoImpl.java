package dao;

import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JdbcUtil;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static JdbcTemplate template = new JdbcTemplate(JdbcUtil.getDataSource());
    @Override
    public List<User> findAll() {
        String s = "select * from caseuser";
        List<User> users = null;
        try {
            users = template.query(s, new BeanPropertyRowMapper<User>(User.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return users;
    }

    @Override
    public User login(User LoginUser) {
        String s = "select * from caseuser where username = ? and password = ?";
        User user = null;
        try {
            user = template.queryForObject(s, new BeanPropertyRowMapper<User>(User.class), LoginUser.getUsername(), LoginUser.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return user;

    }

    @Override
    public void add(User user) {
        String s = "insert into caseuser values(null,?,?,?,?,?,?,null,null)";
        template.update(s,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void delete(int id) {
        String s = "delete from caseuser where id = ?";
        template.update(s,id);
    }

    @Override
    public User find(int id) {
        String s = "select * from caseuser where id = ?";
        return template.queryForObject(s,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void uqdate(User user) {
        String s = "uqdate caseuser set name = ?,gender = ?,age = ?,address =?,qq = ?,email = ? where id= ?";
        template.update(s,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public int findTotalCount() {
        String s = "select count(*) from caseuser";
        return template.queryForObject(s,Integer.class);
    }

    @Override
    public List<User> findByPage(int start, int rows) {
        String s = "select * from caseuser limit ?,?";
        return template.query(s,new BeanPropertyRowMapper<User>(User.class),start,rows);
    }
}
