<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <base href="http://localhost:8080/BookProject/">
    <%-- 静态包含base，css，jQuery --%>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            // 为删除商品得提示
            $("a.deleteItem").click(function () {
                return confirm("确定删除商品【" + $(this).parent().parent().find("td:first").text() + "】吗？")
            })
            // 为清空购物车得提示
            $("#clearCart").click(function () {
                return confirm("确定删除清空购物车吗？")
            })
            // 修改商品数量的提示
            $(".updateCount").change(function () {
                // 获取商品名称
                var name = $(this).parent().parent().find("td:first").text();
                var id = $(this).attr('bookId');
                // 获取商品数量
                var count = this.value;
                if ( confirm("你确定要将【" + name + "】商品修改数量为：" + count + " 吗?") ) {
                    //发起请求。给服务器保存修改
                    location.href = "cartServlet?action=updateCount&count="+count+"&id="+id;
                } else {
                    // defaultValue属性是表单项Dom对象的属性。它表示默认的value属性值。
                    this.value = this.defaultValue;
                }
            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.jpg">
    <span class="wel_word">购物车</span>
    <%@include file="/pages/common/login_succeed_menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <%-- 购物车为空 --%>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5">购物车为空。<a href="index.jsp">去购物。</a></td>
            </tr>
        </c:if>
        <%-- 购物车非空 --%>
        <c:if test="${not empty sessionScope.cart.items}">
            <%--  遍历商品--%>
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td>
                        <input bookId="${entry.value.id}" class="updateCount" style="width: 60px" type="text" value="${entry.value.count}">
                    </td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <%-- 购物车中存在商品时显示 --%>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去支付</a></span>
        </div>
    </c:if>
</div>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>