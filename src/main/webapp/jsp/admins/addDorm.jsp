<%--
  Created by IntelliJ IDEA.
  User: sousui
  Date: 2020/3/13
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>添加宿舍</title>
    <link href="<%=basePath%>hui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="pd-20">
    <form action="<%=basePath%>addDormServlet" method="post" class="form form-horizontal" id="form-admin-add">
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>宿舍号：</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" value="" placeholder="" id="dorm_num" name="dorm_num" datatype="*2-16" style="width: 300px">
            </div>
            <div class="col-4"> </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">宿舍性别：</label>
            <div class="formControls col-5"><span class="select-box" style="width: 200px">
	        <select class="select" name="dorm_sex">
                    <option value="" selected>请选择宿舍性别</option>
                    <option value="男生宿舍">男生宿舍</option>
                    <option value="女生宿舍">女生宿舍</option>
	        </select></span></div>
            <div class="col-4"> </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">最大人数：</label>
            <div class="formControls col-5"><span class="select-box" style="width: 200px">
	        <select class="select" name="max_num">
                    <option value="" selected>请选择宿舍人数</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
	        </select></span></div>
            <div class="col-4"> </div>
        </div>
        <div class="row cl">
            <div class="col-9 col-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
</form>
</div>
</body>
</html>
