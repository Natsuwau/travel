package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    RouteService routeService=new RouteServiceImpl();
   //分页查询你获取数据
    public void  pageQuery(HttpServletRequest request, HttpServletResponse response) throws IOException {

       String currentPageStr=request.getParameter("currentPage");
       String pageSizeStr=request.getParameter("pageSize");
       String cidStr=request.getParameter("cid");

       int cid=0;
       if (cidStr!=null&&cidStr.length()>0)
       {
           cid=Integer.parseInt(cidStr);
       }

        int currentPage=0;//不传递 默认第一页
        if (currentPageStr!=null&&currentPageStr.length()>0)
        {
            currentPage=Integer.parseInt(currentPageStr);
        }
        else {
            currentPage=1;
        }

        int pageSize=0;//每页显示条数 不传递默认显示五条
        if (pageSizeStr!=null&&pageSizeStr.length()>0)
        {
            pageSize=Integer.parseInt(pageSizeStr);
        }
        else {
            pageSize=5;
        }


        PageBean<Route> pb= routeService.pageQuery(cid,currentPage,pageSize);
        writeValue(pb,response);
    }

}
