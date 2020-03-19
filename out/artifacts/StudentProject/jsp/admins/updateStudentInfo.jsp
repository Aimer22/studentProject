<%--
  Created by IntelliJ IDEA.
  User: sousui
  Date: 2020/3/10
  Time: 15:04
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
    <title>更新学生信息</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>hui/css/H-ui.min.css"/>
</head>
<body>
<article class="page-container">
    <form action="<%=basePath%>updateStudentInfoServlet" method="post" class="form form-horizontal" id="form-member-add">
        <input type="hidden" name="trainId" value="">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>性别：</label>
            <div class="formControls col-xs-8 col-sm-9" style="width:300px;">
                <input type="text" class="input-text" value="${studentInfo.sex}" placeholder="" id="sex" name="sex">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>年龄：</label>
            <div class="formControls col-xs-8 col-sm-9" style="width:300px;">
                <input type="text" class="input-text" value="${studentInfo.age}" placeholder="" id="age" name="age">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>户籍：</label>
            <div class="formControls col-xs-8 col-sm-9" style="width:300px;">
                <input type="datetime-local" class="input-text" value="${studentInfo.birthPlace}" placeholder="" id="home" name="home">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>民族：</label>
            <div class="formControls col-xs-8 col-sm-9" style="width:300px;">
                <input type="datetime-local" class="input-text" value="${studentInfo.national}" placeholder="" id="national" name="national">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>学院：</label>
            <div class="formControls col-xs-8 col-sm-9" style="width:300px;">
                <input type="text" class="input-text" value="${studentInfo.campus}" placeholder="" id="campus" name="campus">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>专业：</label>
            <div class="formControls col-xs-8 col-sm-9" style="width:300px;">
                <input type="text" class="input-text" value="${studentInfo.major}" placeholder="" id="major" name="major">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>班级：</label>
            <div class="formControls col-xs-8 col-sm-9" style="width:300px;">
                <input type="text" class="input-text" value="${studentInfo.stuClass}" placeholder="" id="stuClass" name="stuClass">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>宿舍：</label>
            <div class="formControls col-xs-8 col-sm-9" style="width:300px;">
                <input type="text" class="input-text" value="${studentInfo.dorm}" placeholder="" id="dorm" name="dorm">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系电话：</label>
            <div class="formControls col-xs-8 col-sm-9" style="width:300px;">
                <input type="text" class="input-text" value="${studentInfo.phone}" placeholder="" id="phone" name="phone">
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=basePath%>lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=basePath%>lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="<%=basePath%>lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=basePath%>lib/jquery.validation/1.14.0/messages_zh.js"></script>

<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
