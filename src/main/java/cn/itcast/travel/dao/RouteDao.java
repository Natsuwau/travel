package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;

import java.util.List;

public interface RouteDao {
    default public int getTotalCount(int cid){return 0;}
    default List<Route> getByPage(int cid,int start,int pageSize){return null;}
}
