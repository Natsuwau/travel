
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

public class test {
    public static void main(String[] args) throws SQLException {
        System.out.println(JDBCUtils.getConnection());
//        JdbcTemplate template= new JdbcTemplate(JDBCUtils.getDataSource());
//        List<User> users = template.query("select * from tab_user", new BeanPropertyRowMapper<User>(User.class));
//        System.out.println(users);
    }
}
