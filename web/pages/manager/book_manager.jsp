<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%-- 静态包含base，css，jQuery --%>
    <%@include file="/pages/common/head.jsp" %>

    <script type="text/javascript">

        // 删除图书是的提示
        $(function () {
            // 绑定单击事件
            $("a.deleteClass").click(function () {
                // 去两次父元素，再取其 子元素的第一个元素 得到书名
                return confirm("确定要删除图书：" + $(this).parent().parent().find("td:first").text());
            })
        })

        // 跳转到指定页码
        $(function () {
            $("#searchPageBtn").click(function () {
                let pageNo = $("#pn_input").val();

                <%--边界检查--%>
                <%--var pageTotal = ${requestscope.page.pageTotal};--%>
                <%--alert(pageTotal);--%>

                // location地址栏对象
                location.href = "${requestScope.basePath}manager/bookServlet?action=page&pageNo=" + pageNo;
            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.jpg">
    <span class="wel_word">图书管理系统</span>
    <%--静态包含manager菜单--%>
    <%@include file="/pages/common/order_manager.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>

        <%-- 使用JSPL遍历 --%>
        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/bookServlet?action=getBook&id=${book.id}&method=update&pageNo=${requestScope.page.pageNo}">修改</a></td>
                <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?method=add&pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
        </tr>
    </table>
    <%--页码--%>
    <%-- 静态包含分页条 --%>
    <%@include file="/pages/common/page_nav.jsp" %>
</div>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>