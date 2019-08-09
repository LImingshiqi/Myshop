<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/10
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
             管理用户
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- Horizontal Form -->
            <div class="col-md-12">
                <c:if test="${baseResult != null}" >
                <div class="alert alert-${baseResult.status == 200 ? "success" : "danger"} alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    ${baseResult.message}
                </div>
                </c:if>
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">${tbUser.id == null ? "新增" : "编辑"}用户</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
            <form:form id="inputForm" cssClass="form-horizontal" action="/user/save" method="post" modelAttribute="tbUser">
                <form:hidden path="id" />
                    <div class="box-body">
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">邮箱</label>
                                <div class="col-sm-10 ">
                                <form:input class="form-control required email"  path="email"  placeholder="请输入邮箱"/>

                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label " >密码</label>

                            <div class="col-sm-10">
                                <form:password class="form-control required" path="password" placeholder="请输入您的密码"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="username" class="col-sm-2 control-label"  >姓名</label>

                            <div class="col-sm-10">
                                <form:input path="username" type="text" class="form-control required" placeholder="请输入您的用户名"/>

                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label" >手机</label>

                            <div class="col-sm-10">
                                <form:input path="phone" type="text" class="form-control required mobile" placeholder="请输入您的手机"/>

                            </div>
                        </div>
                    </div>
                    <!-- /.box-body -->
                    <div class="box-footer">
                        <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                        <button type="submit" class="btn btn-info pull-right">提交</button>
                    </div>
                    <!-- /.box-footer -->


            </form:form>

                </div>

            </div>
       </section>
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../include/copyright.jsp" />




</div>
<jsp:include page="../include/footer.jsp"/>

</body>
</html>
