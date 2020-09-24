package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();

    @Override
    public boolean regist(User user) {
        User u = dao.findUser(user.getUsername());
        if (u != null) {
            return false;
        } else {
            dao.addUser(user);
            return true;
        }
    }

    @Override
    public User findUser(String username) {
        return dao.findUser(username);
    }

    @Override
    public User loginUser(String username, String password) {
        return dao.loginUser(username, password);
    }

}
