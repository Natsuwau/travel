package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;

public interface UserService {
    public boolean regist(User user);
    public User findUser(String username);
    public User loginUser(String username,String password);
}
