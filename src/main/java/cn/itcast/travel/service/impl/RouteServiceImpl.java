package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao = new RouteDaoImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize) {
        PageBean<Route>pb=new PageBean<Route>();

        pb.setCurrentPage(currentPage);//当前页数
        pb.setPageSize(pageSize);//每页数量

        int totalCount=routeDao.getTotalCount(cid);
        pb.setTotalCount(totalCount);//总条数

        int start=(currentPage-1)*pageSize;
        List<Route> list=routeDao.getByPage(cid,start,pageSize);
        pb.setList(list);

        //有余+1
        int totalPage=totalCount % pageSize==0 ? totalCount/pageSize:(totalCount/pageSize)+1;
        pb.setTotalPage(totalPage);//总页数
        return pb;
    }
}
