<%--
  Created by IntelliJ IDEA.
  User: sousui
  Date: 2020/2/25
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>登陆界面</title>
    <style>
        body{
            background-image:url(../img/img3.jpg);
            background-size:100%;
        }

        .xian{
            width: 50%;
            height: 1px;
            border-top: solid #ACC0D8 1px;
        }
        .d1{
            display: block;
            position: fixed;
            _position: absolute;
            top: 55%;
            left: 60%;
            width: 400px;
            height:270px;
            margin-left: -333px;
            margin-top: -200px;
            z-index: 10001;
            box-shadow: 2px 2px 4px #A0A0A0, -2px -2px 4px #A0A0A0;
            background-color:#000; opacity:0.5;

        }
        .f1{
            position:absolute;
            color:white;
            font-size:30px;
            left:10%;
        }
        .f2{
            position:absolute;
            color:white;
            font-size:30px;
            right:10%;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>hui/css/H-ui.min.css"/>
    <link href="<%=basePath%>lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form class="form form-horizontal" action="<%=basePath%>loginServlet" method="post" id="formrules">
    <font class="f1">UPCOMING欢迎</font><font class="f2">加入我们UPCOMING</font><br>
    <hr size=1 style="COLOR:white;border-style:double;width:80%; margin-top:3%">
    <div class="d1">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3" style="color:white"><i class="Hui-iconfont">&#xe60d;</i>账号：</label>
            <div class="formControls col-xs-8 col-sm-9" style="width:200px">
                <input type="text" class="input-text" style="width:200px" value="" placeholder="" id="username" name="username"></input>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3" style="color:white"><i class="Hui-iconfont">&#xe60e;</i>密码：</label>
            <div class="formControls col-xs-8 col-sm-9" style="width:200px">
                <input type="password" class="input-text" style="width:200px" value="" placeholder="" id="password" name="password"></input>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3" style="color:white">身份：</label>
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
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input type="submit" value="提交" class="btn btn-primary radius" id="sub"></input>
            </div>
        </div>

        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <span style="color:#E8E8E8">纳尼？你还没有注册，赶紧注册吧！</span>
                <a href="<%=basePath%>jsp/register.jsp" style="text-decoration: underline;color:#6699FF">点击注册</a>
            </div>
        </div>
    </div>
</form>
</body>

</html>
