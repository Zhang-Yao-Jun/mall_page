<%--
  Created by IntelliJ IDEA.
  User: 张尧俊
  Date: 2019/3/17
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table width="100%">
    <tr>
        <td>序号</td>
        <td>名字</td>
        <td>城市</td>
        <td>价格</td>
        <td>数量</td>
        <td>图片</td>
        <td>操作</td>
    </tr>
    <c:forEach var="items" items="${pageBean.list}" varStatus="i">
        <tr>
            <td> ${i.index+1}</td>
            <td> ${items.name}</td>
            <td> ${items.city}</td>
            <td> ${items.price}</td>
            <td> ${items.number}</td>
            <td> ${items.picture}</td>
            <td><a href="#?${items.id}">查看</a></td>
        </tr>
    </c:forEach>

    <tr>
        <td colspan="7">

            <c:if test="${pageBean.pageIndex>1}">
                <a href="ItemsServlet?pageIndex=${pageBean.pageIndex-1}">上一页</a>
            </c:if>
            <%--
                如果不够10页
                    开始页 1
                     结束页pages

                否则
                开始页 = 当前页-5
                结束页 = 当前页+4

                如果头超了，
                    开始页为1
                    结束页为10

                如果尾超了
                    开始页  pages-9
                    结束页为 pages
            --%>

            <c:choose>
                <c:when test="${pageBean.pages<=10}">
                    <c:set var="start" value="1"></c:set>
                    <c:set var="end" value="${pageBean.pages}"></c:set>
                </c:when>
                <c:otherwise>
                    <c:set var="start" value="${pageBean.pageIndex-5}"></c:set>
                    <c:set var="end" value="${pageBean.pageIndex+4}"></c:set>
                    <c:if test="${pageBean.pageIndex-5 < 1}">
                        <c:set var="start" value="1"></c:set>
                        <c:set var="end" value="10"></c:set>
                    </c:if>
                    <c:if test="${pageBean.pageIndex+4>pageBean.pages}">
                        <c:set var="start" value="${pageBean.pages-9}"></c:set>
                        <c:set var="end" value="${pageBean.pages}"></c:set>
                    </c:if>
                </c:otherwise>
            </c:choose>


            <c:forEach var="i" begin="${start}"  end="${end}" step="1">
                <c:if test="${pageBean.pageIndex==i}">
                    【${i}】
                </c:if>
                <c:if test="${pageBean.pageIndex!=i}">
                    <a href="ItemsServlet?pageIndex=${i}">【${i}】</a>
                </c:if>
            </c:forEach>
            <c:if test="${pageBean.pageIndex<pageBean.pages}">
                <a href="ItemsServlet?pageIndex=${pageBean.pageIndex+1}">下一页</a>
            </c:if>
        </td>
    </tr>
    
</table>
</body>
</html>
