package com.zr.servlet;

import com.zr.dao.ItemsDao;
import com.zr.entity.Items;
import com.zr.util.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ItemsServlet",urlPatterns="/ItemsServlet")
public class ItemsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageIndex = 1;
        int pageCount = 10;
        if(request.getParameter("pageIndex")!=null){
            String strPageIndex= request.getParameter("pageIndex");
            pageIndex = Integer.parseInt(strPageIndex);
        }
        ItemsDao dao = new ItemsDao();
        PageBean<Items> pageBean = dao.queryPageBean(pageIndex, pageCount);
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/mall/query.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
