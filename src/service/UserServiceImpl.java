package service;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.PageBean;
import domain.User;


import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao ud = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        try {
            return ud.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User Login(User LoginUser) {

            return ud.login(LoginUser);

    }

    @Override
    public void addUser(User user) {
        ud.add(user);
    }

    @Override
    public void deleteUser(String id) {
        ud.delete(Integer.parseInt(id));
    }

    @Override
    public User findUser(String id) {
        return ud.find(Integer.parseInt(id));
    }

    @Override
    public void uqdateUser(User user) {
        ud.uqdate(user);
    }

    @Override
    public void delSelected(String[] uids) {
        if (uids!=null && uids.length>0){
            for (String id:uids
            ) {
                ud.delete(Integer.parseInt(id));
            }
        }

    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        //优化
        if(currentPage<=0){
            currentPage=1;
        }

        //创建空的PageBean对象
        PageBean<User> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //调用Dao方法查询总记录数
        int totalCount = ud.findTotalCount();
        pb.setTotalCount(totalCount);
        //调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage-1)*rows;
        List<User> list = ud.findByPage(start,rows);
        pb.setList(list);
        //计算总页码
        int totalPage = (totalCount%rows) == 0 ? totalCount/rows:(totalCount/rows)+1;
        pb.setTotalPage(totalPage);

        return pb;
    }


}
