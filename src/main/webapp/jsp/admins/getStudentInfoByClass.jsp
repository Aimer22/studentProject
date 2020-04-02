<%--
  Created by IntelliJ IDEA.
  User: sousui
  Date: 2020/3/25
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path=request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link href="<%=basePath%>hui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>hui/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<html>
<head>
    <title>班级学生信息</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 用户管理 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
    <div class="text-c">
        <input type="text" class="input-text" style="width:250px" placeholder="请输入学生学号" id="" name="">
        <button type="submit" class="btn btn-success radius"  name=""><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a href="javascript:;" onclick="member_add('添加学生','','','510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加学生</a></span> <span class="r">共有数据：<strong>${studentInfoList.size()}</strong> 条</span> </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th width="25"><input type="checkbox" name="" value=""></th>
                <th width="30">序号</th>
                <th width="70">学生姓名</th>
                <th width="100">学号</th>
                <th width="40">性别</th>
                <th width="40">年龄</th>
                <th width="100">户籍</th>
                <th width="70">民族</th>
                <th width="130">学院</th>
                <th width="70">专业</th>
                <th width="100">班级</th>
                <th width="70">宿舍</th>
                <th width="70">联系方式</th>
                <th width="70">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${studentInfoList}" var="stuInfos" varStatus="status">
                <tr class="text-c">
                    <td><input type="checkbox" value="1" name=""></td>
                    <td>${status.index+1}</td>
                    <td>${stuInfos.stuName}</td>
                    <td>${stuInfos.stuNo}</td>
                    <td>${stuInfos.sex}</td>
                    <td>${stuInfos.age}</td>
                    <td>${stuInfos.birthPlace}</td>
                    <td>${stuInfos.national}</td>
                    <td>${stuInfos.campus}</td>
                    <td>${stuInfos.major}</td>
                    <td>${stuInfos.stuClass}</td>
                    <td>${stuInfos.dorm}</td>
                    <td>${stuInfos.phone}</td>
                    <td class="td-manage">
                        <a title="编辑" onclick="member_edit('编辑','<%=basePath%>updateStudentInfoServlet?stuId=${stuInfos.stuId}','4','','510')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
                        <a title="删除" href="<%=basePath%>deleteStudentInfoServlet?stuId=${stuInfos.stuId}" onclick="member_del('this','1')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="<%=basePath%>lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/H-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>static/H-ui.admin.js"></script>
<script type="text/javascript">
    $(function(){
        $('.table-sort').dataTable({
            "aaSorting": [[ 1, "desc" ]],//默认第几个排序
            "bStateSave": true,//状态保存
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
            ]
        });
        $('.table-sort tbody').on( 'click', 'tr', function () {
            if ( $(this).hasClass('selected') ) {
                $(this).removeClass('selected');
            }
            else {
                table.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
        });
    });
    /*用户-添加*/
    function member_add(title,url,w,h){
        layer_show(title,url,w,h);
    }
    /*用户-查看*/
    function member_show(title,url,id,w,h){
        layer_show(title,url,w,h);
    }
    /*用户-停用*/
    function member_stop(obj,id){
        layer.confirm('确认要停用吗？',function(index){
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
            $(obj).remove();
            layer.msg('已停用!',{icon: 5,time:1000});
        });
    }

    /*用户-启用*/
    /* function member_start(obj,id){
         layer.confirm('确认要启用吗？',function(index){
             $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
             $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
             $(obj).remove();
             layer.msg('已启用!',{icon: 6,time:1000});
         });
     }*/
    /*用户-编辑*/
    function member_edit(title,url,id,w,h){
        layer_show(title,url,w,h);
    }
    /*密码-修改*/
    function change_password(title,url,id,w,h){
        layer_show(title,url,w,h);
    }
    /*用户-删除*/
    function member_del(obj,id){
           layer.confirm('确认要删除吗？',function(index){
                $(obj).parents("tr").remove();
                layer.msg('已删除!',{icon:1,time:1000});
        });

    }
</script>
</body>
</html>
