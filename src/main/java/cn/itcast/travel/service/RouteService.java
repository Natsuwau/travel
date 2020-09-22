package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

//线路
//根据类别分页查询
public interface RouteService {
    default public PageBean<Route>pageQuery(int cid,int currentPage,int pageSize)
    {
        return null;
    }
}
