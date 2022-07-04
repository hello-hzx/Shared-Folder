<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚书城会员注册页面</title>
    <%-- 静态包含base，css，jQuery --%>
    <%@include file="/pages/common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.jpg">
    <%-- 顾客信息 --%>
    <%@include file="/pages/common/login_succeed_menu.jsp" %>
</div>

<div id="main">

    <h1>欢迎回来 <a href="../client/index.jsp">转到主页</a></h1>

</div>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>