<%--
  Created by IntelliJ IDEA.
  User: sousui
  Date: 2020/2/27
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>报名状态</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/registerStatus.css"/>
</head>
<body>
<div class="d1">
    <font size="20px" color="" class="f1">OH MY GOD!</font><br>
    <font size="4" color="">亲爱的同学,您还没有开始报到。</font><br>
    <font size="5" color="">赶紧报到吧。</font><br>
    <button type="button" value="" class="button" onclick="javascrtpt:window.location.href='<%=basePath%>firstStepServlet'"><span>点击此处开始报到</span></button>
</div>
<img src="<%=basePath%>img/bilibili1.png" >
</body>
</html>
