package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.RouteImgDao;
import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.dao.impl.RouteImgDaoImpl;
import cn.itcast.travel.dao.impl.SellerDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao = new RouteDaoImpl();
    private RouteImgDao routeImgDao=new RouteImgDaoImpl();
    private SellerDao sellerDao=new SellerDaoImpl();

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

    /**
     * 根据id查询
     *
     * @param rid
     * @return
     */
    @Override
    public Route findOne(String rid) {
        //1.根据rid去route表中查询route对象
        Route route = routeDao.findOne(Integer.parseInt(rid));
        //2.根据routed的rid 查询图片集合信息
        List<RouteImg> routeImgList = routeImgDao.findByRid(route.getRid());
        //3.将集合设置到route对象中
        route.setRouteImgList(routeImgList);
        //4.根据route的sid查询卖家信息
        Seller seller = sellerDao.findById(route.getSid());
        route.setSeller(seller);
        return route;
    }


}

