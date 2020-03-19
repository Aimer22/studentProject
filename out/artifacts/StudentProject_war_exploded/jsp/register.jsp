<%--
  Created by IntelliJ IDEA.
  User: sousui
  Date: 2020/2/25
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>注册界面</title>
    <link href="<%=basePath %>css/font.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath %>hui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form action="<%=basePath%>registrationServlet" method="post" class="form form-horizontal" id="">
    <div class="cl pd-20" style=" background-color:#5bacb6">
        <font class="f1">注册界面</font>
    </div>
    <div class="row cl">
        <label class="form-label col-3"><span class="c-red">*</span>姓名 :</label>
        <div class="formControls col-5">
            <input type="text" class="input-text" id="thename" name="thename">
        </div>
    </div>
    <div class="row cl">
        <label class="form-label col-3"><span class="c-red">*</span>用户名 :</label>
        <div class="formControls col-5">
            <input type="text" class="input-text" id="username" name="username">
        </div>
    </div>
    <div class="row cl">
        <label class="form-label col-3"><span class="c-red">*</span>密码 :</label>
        <div class="formControls col-5">
            <input type="password" class="input-text" id="password" name="password">
        </div>
    </div>
    <div class="row cl">
        <label class="form-label col-3"><span class="c-red">*</span>确认密码 :</label>
        <div class="formControls col-5">
            <input type="password" class="input-text" id="repassword" name="repassword">
        </div>
    </div>

    <div class="row cl">
        <label class="form-label col-3">身份 :</label>
        <div class="formControls col-5"> <span class="select-box">
        <select class="select" size="1" name="flag" id="flag">
          <option value="" selected>请选择您的身份</option>
          <option value="1">教师</option>
          <option value="2">学生</option>
        </select>
        </span> </div>
        <div class="col-4"> </div>
    </div>
    <div class="row cl">
        <div class="col-9 col-offset-3">
            <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
        </div>
    </div>

</form>
</body>
</html>
