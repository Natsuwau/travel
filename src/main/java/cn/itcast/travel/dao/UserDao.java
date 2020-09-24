package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface UserDao {
    default void addUser(User user) {
    }

    default User findUser(String username) {
        return null;
    }

    default User loginUser(String username, String password) {
        return null;
    }
}
