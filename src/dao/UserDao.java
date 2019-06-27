package dao;

import domain.User;

import java.util.List;

public interface UserDao {

    public List<User> findAll();
    public User login(User LoginUser);

    void add(User user);

    void delete(int id);

    User find(int id);

    void uqdate(User user);

    /**
     *查询总记录数
     * @return
     */
    int findTotalCount();

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @return
     */
    List<User> findByPage(int start, int rows);
}
