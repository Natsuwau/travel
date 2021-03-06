package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RouteDaoImpl implements RouteDao {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Route> getByPage(int cid, int start, int pageSize) {

        String sql="select * from tab_route where cid=? limit ? , ?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Route>(Route.class),cid,start,pageSize);
    }

    @Override
    public int getTotalCount(int cid) {
        String sql="select count(*) from tab_route where cid=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,cid);
    }

    /**
     * 根据id查询
     *
     * @param rid
     * @return
     */
    @Override
    public Route findOne(int rid) {
        String sql = "select * from tab_route where rid = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);
    }



}
