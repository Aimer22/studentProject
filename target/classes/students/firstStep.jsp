<%@ page import="java.util.ArrayList" %>
<%@ page import="com.cn.domain.Dorm" %>
<%@ page import="com.cn.domain.StuClass" %><%--
  Created by IntelliJ IDEA.
  User: sousui
  Date: 2020/2/27
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>报到第一步</title>

    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/registerStatus.css"/>
    <link href="<%=basePath%>hui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>iconfont-cn/iconfont.css" rel="stylesheet" type="text/css" />
</head>
<body background="#F0FFFF">
<form action="<%=basePath%>firstStepServlet" method="post" class="form form-horizontal" id="form-member-add">
    <div class="d1">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>年龄 :</label>
            <div class="formControls col-xs-8 col-sm-9" style="width:300px;">
                <input type="text" class="input-text" value="" placeholder="" id="age" name="age">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>性别 :</label>
            <div class="formControls col-xs-8" style="width:300px;" >
                <svg class="icon s1" aria-hidden="true">
                    <use xlink:href="#icon-xingbienan"></use>
                </svg>
                <input type="radio" value="男" name="sex" class="r1">
                <svg class="icon s2" aria-hidden="true">
                    <use xlink:href="#icon-xingbienv"></use>
                </svg>
                <input type="radio" value="女" name="sex" class="r2">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>籍贯 :</label>
            <div class="formControls col-xs-8 col-sm-9" style="width:300px;">
                <input type="text" class="input-text" value="" placeholder="" id="birthPlace" name="birthPlace">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>民族  :</label>
            <div class="formControls col-xs-8 col-sm-9" style="width:300px;">
                <input type="text"  class="input-text" value="" placeholder="" id="stuNational" name="stuNational">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>校区  :</label>
            <div class="formControls col-5"><span class="select-box">
                <select class="select" name="campus">
                    <option value="共青城校区">共青城校区</option>
                    <option value="青山湖校区">青山湖校区</option>
                    <option value="瑶湖校区">瑶湖校区</option>
                </select>
            </span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>专业  :</label>
            <div class="formControls col-xs-8 col-sm-9" style="width:300px;">
                <input type="text"  class="input-text" value="" placeholder="" id="major" name="major">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">班级：</label>
            <div class="formControls col-5"><span class="select-box">
	        <select class="select" name="stuClass">
                    <option value="" selected>请选择您的班级</option>
                <c:forEach items="${stuClasses}" var="stuClasses">
                    <option value="${stuClasses.class_Id}">${stuClasses.class_Id}</option>
                </c:forEach>
	        </select>
	        </span>
            </div>
            <div class="col-4"> </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">宿舍：</label>
            <div class="formControls col-5"><span class="select-box">
	        <select class="select" name="dorm">
                    <option value="" selected>请选择您的宿舍</option>
                <c:forEach items="${dorms}" var="dorms">
                    <option value="${dorms.dorm_Num}">${dorms.dorm_Num}</option>
                </c:forEach>
	        </select>
	        </span>
            </div>
            <div class="col-4"> </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>联系电话  :</label>
            <div class="formControls col-xs-8 col-sm-9" style="width:300px;">
                <input type="text"  class="input-text" value="" placeholder="" id="phone" name="phone">
            </div>
        </div>
        <div class="row cl">
            <div class="">
                <input type="submit" value="下一步" class="btn btn-primary radius" id="sub"></input>
            </div>
        </div>
    </div>
    </div>
</form>
<script type="text/javascript" src="<%=basePath%>iconfont-cn/iconfont.js"></script>

</body>
</html>
