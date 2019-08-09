<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>


<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/10
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>

    <title>AdminLTE 2 | 管理控制台</title>
    <!-- Tell the browser to be responsive to screen width -->
    <jsp:include page="../include/header.jsp"/>



</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

<![endif]-->
<div class="wrapper">
    <jsp:include page="../include/nav.jsp"/>

    <!-- sidebar: style can be found in sidebar.less -->
    <jsp:include page="../include/meau.jsp"/>
    <link rel="stylesheet" href="/static/assets/plugins/dropzone/min/dropzone.min.css" />
    <link rel="stylesheet" href="/static/assets/plugins/dropzone/min/basic.min.css" />
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active">用户管理</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <c:if test="${baseResult != null}" >
                <div class="alert alert-${baseResult.status == 200 ? "success" : "danger"} alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        ${baseResult.message}
                </div>
            </c:if>
                <div class="box box-info box-info-search" style="display: none">
                    <div class="box-header">
                        <h3 class="box-title">高级搜索</h3>
                    </div>


                        <div class="box-body">
                            <div class="row form-horizontal">
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group ">
                                        <label for="username" class="col-sm-4 control-label" >姓名</label>

                                        <div class="col-sm-8 ">
                                            <input id="username" class="form-control" placeholder="姓名" >
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="email" class="col-sm-4 control-label" >邮箱</label>
                                        <div class="col-sm-8 ">
                                            <input id="email" class="form-control" placeholder="邮箱" >
                                       </div>
                                    </div>
                              </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="phone" class="col-sm-4 control-label" >手机</label>
                                        <div class="col-sm-8">
                                            <input id="phone" class="form-control" placeholder="手机" >
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                            <div class="box-footer">
                                <button type="submit" class="btn btn-info pull-right" onclick="search()" >搜索</button>
                            </div>
                      </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>

                                <div class="row" style="padding-left: 12px;margin-top: 20px">
                                    <div class="col-xs-12">
                                        <a href="/user/form" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i> 新增</a>&nbsp;&nbsp;&nbsp;
                                        <button  type="button" class="btn btn-sm btn-default"  onclick="App.deleteMulti('/user/delete')"><i class="fa fa-trash-o" ></i> 删除</button>&nbsp;&nbsp;&nbsp;
                                        <a href="/user/form" type="button" class="btn btn-sm btn-default"><i class="fa fa-download"></i> 导入</a>&nbsp;&nbsp;&nbsp;
                                        <a href="/user/form" type="button" class="btn btn-sm btn-default"><i class="fa fa-upload"></i> 导出</a>&nbsp;&nbsp;&nbsp;
                                        <button  type="submit" class="btn btn-sm btn-primary" onclick="$('.box-info-search').css('display')=='none'?$('.box-info-search').show('fast'):$('.box-info-search').hide('fast')"><i class="fa fa-search"></i> 搜索</button>&nbsp;&nbsp;&nbsp;
                                    </div>
                                   </div>



                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table id="dataTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input   type="checkbox" class="minimal icheck_master" /></th>
                                    <th>ID</th>
                                    <th>用户名</th>
                                    <th>手机号</th>
                                    <th>邮箱</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <%--<tbody>--%>
                                <%--<c:forEach items="${tbUsers}" var="TbUser">--%>
                                    <%--<tr>--%>
                                        <%--<td>  <input id="${TbUser.id}"  type="checkbox" class="minimal" /></td>--%>
                                        <%--<td>${TbUser.id}</td>--%>
                                        <%--<td>${TbUser.username}</td>--%>
                                        <%--<td>${TbUser.phone}</td>--%>
                                        <%--<td><span class="label label-success">${TbUser.email}</span></td>--%>
                                        <%--<td><fmt:formatDate value="${TbUser.created}" pattern="yyyy-MM-dd HH:mm:ss"/></td>--%>
                                        <%--<td><button type="button" class="btn btn-sm btn-default"><i class="fa fa-search"></i>查看</button>--%>
                                        <%--<a href="/user/form" type="button" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i> 编辑</a>--%>
                                        <%--<button type="button" class="btn btn-sm btn-danger"><i class="fa fa-trash-o"></i> 删除</button></td>--%>



                                    <%--</tr>--%>
                                <%--</c:forEach>--%>

                                <%--</tbody>--%>

                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../include/copyright.jsp" />
</div>
<jsp:include page="../include/footer.jsp"/>
<!--自定义模态框-->
<sys:modal/>
<script>
    var _dataTable;
  $(function(){
      var columns=[
          {
              "data":function (row,type,val,meta) {
                  return '<input id="'+row.id+'"type="checkbox" class="minimal" />';
              }
          },
          { "data": "id" },
          { "data": "username" },
          { "data": "phone" },
          { "data": "email" },
          { "data": function (row,type,val,meta) {
                  return DateTime.format(row.update,"yyyy-MM-dd HH:mm:ss");
              }
          },
          {
              "data":function (row,type,val,meta) {
                  var detailUrl="/user/deliter?id="+row.id;
                  var deleteUrl = "/user/delete";
                  return  '<button  type="button" class="btn btn-sm btn-default" onclick="App.showDatall(\''+detailUrl+'\')"><i class="fa fa-search"></i>查看</button >&nbsp;&nbsp;&nbsp;'+
                      '<a href="/user/form?id='+row.id+'"type="button" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;&nbsp;'+
                      '<button type="button" class="btn btn-sm btn-danger" onclick="App.deleteSingle(\'' + deleteUrl + '\',\''+ row.id + '\')"><i class="fa fa-trash-o"></i> 删除</button >';
              }
          }

      ];
      _dataTable=App.initDataTables("/user/page",columns);
    });

    function search() {

       var username=$("#username").val();
       var phone=$("#phone").val();
       var email=$("#email").val();

       var param={
        "username":username,
           "phone":phone,
           "email":email
       };
        _dataTable.settings()[0].ajax.data=param;
        _dataTable.ajax.reload();

   }


</script>



</body>
</html>
