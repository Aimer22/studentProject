<%--
  Created by IntelliJ IDEA.
  User: sousui
  Date: 2020/2/28
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>报到第二步</title>
    <link href="<%=basePath%>hui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>iconfont-cn/iconfont.css" rel="stylesheet" type="text/css" />
<%--    <link href="<%=basePath%>lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />--%>
</head>
<body>
<div class="mt-20">
    <table class="table table-border table-bordered table-bg table-hover table-sort">
        <thead>
        <tr class="text-c">
            <th width="80">学号</th>
            <th width="80">姓名</th>
            <th width="80">专业</th>
            <th width="60">学杂费（元）</th>
            <th width="60">书费（元）</th>
            <th width="60">住宿费（元）</th>
            <th width="60">保险费（元）</th>
            <th width="120">总计（元）</th>
        </tr>
        </thead>
        <tbody>
        <tr class="text-c">
            <td>${studentInfo.stuId}</td>
            <td>${tuition.payer}</td>
            <td>${studentInfo.major}</td>
            <td>${tuition.fees}</td>
            <td>${tuition.spendOnBook}</td>
            <td>${tuition.accommodation}</td>
            <td>${tuition.insurance}</td>
            <td>${tuition.amount}</td>
        </tr>
        </tbody>
        <tfoot>
        <tr class="text-c">
            <th colspan="2">支付方式</th>
            <th colspan="2"><input type="checkbox" name="" value="">
                <svg class="icon" aria-hidden="true">
                    <use xlink:href="#icon-zhifubao"></use>
                </svg>
            </th>
            <th colspan="2"><input type="checkbox" name="" value="">
                <svg class="icon" aria-hidden="true">
                <use xlink:href="#icon-weixin"></use>
            </svg></th>
            <th colspan="2"><input type="checkbox" name="" value="">
                <svg class="icon" aria-hidden="true">
                    <use xlink:href="#icon-zhifupingtai-yinlian"></use>
                </svg></th>
        </tr>
        <tr>
            <th colspan="8" style="text-align: center;">
                <button class="btn btn-primary radius" type="submit">确认缴费</button>
            </th>
        </tr>
        </tfoot>
    </table>
</div>
<script type="text/javascript" src="<%=basePath%>iconfont-cn/iconfont.js"></script>
</body>
</html>
