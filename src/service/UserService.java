package service;

import domain.PageBean;
import domain.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User Login(User LoginUser);

    void addUser(User user);

    void deleteUser(String id);

    User findUser(String id);

    void uqdateUser(User user);

    void delSelected(String[] uids);


    PageBean<User> findUserByPage(String currentPage, String rows);
}
