package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void addUser(User user) {

        try {
            String addsql = "insert into tab_user(username,password,name,birthday,sex,telephone,email)" +
                    " values (?,?,?,?,?,?,?)";

            template.update(addsql,user.getUsername(), user.getPassword(), user.getName(), user.getBirthday(),
                    user.getSex(), user.getTelephone(), user.getEmail());

        } catch (DataAccessException e) {
            System.out.println("添加失败！");
        }

    }

    @Override
    public User findUser(String username) {
        User user = null;
        try {
            String findsql = "select * from tab_user where username = ?";
            user = template.queryForObject(findsql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (DataAccessException e) {
            return null;
        }
        return user;
    }
    @Override
    public User loginUser(String username,String password) {
        User user = null;
        String loginsql = "select * from tab_user where username = ? and password = ?";
        try {
            user = template.queryForObject(loginsql,new BeanPropertyRowMapper<User>(User.class),username,password);
        } catch (DataAccessException e) {
            return null;
        }
        System.out.println(user);
        return user;
    }
}
