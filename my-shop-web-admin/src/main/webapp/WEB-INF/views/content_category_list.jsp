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
    <!--treeTable-->
    <link rel="stylesheet" href="/static/assets/plugins/treeTable/themes/vsStyle/treeTable.min.css" />
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
                内容管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active">内容管理</li>
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


        <div class="box">
        <div class="box-header">
            <h3 class="box-title">分类列表</h3>
        </div>

                    <div class="box-body">
                        <a href="/content/category/form"  type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i> 新增</a>&nbsp;&nbsp;&nbsp;

                        <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-download"></i> 导入</a>&nbsp;&nbsp;&nbsp;
                        <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-upload"></i> 导出</a>&nbsp;&nbsp;&nbsp;
                    </div>



            <div class="box-body table-responsive">
                <table id="treeTable" class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>名称</th>
                        <th>排序</th>
                        <th>操作</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${tbContentCategories}" var="content">
                        <tr id="${content.id}" pId="${content.parent.id}">
                            <td>${content.id}</td>
                            <td>${content.name}</td>
                            <td>${content.sortOrder}</td>
                            <td>
                                <a href="/content/category/form?id=${content.id}" type="button" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-sm btn-danger" onclick="App.deleteSingle('/content/category/delete', '${content.id}', '警告：该删除操作会将包括选中类目在内的全部子类目及属于类目的内容一并删除，请谨慎操作！您还确定继续吗？')"><i class="fa fa-trash-o"></i> 删除</button >&nbsp;&nbsp;&nbsp;
                                <a href="/content/category/form?parent.id=${content.id}&parent.name=${content.name}" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i> 添加下级菜单</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <!--box-body-->
                </div>
            <!--box-->
        </div>
            </div>
        </section>
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../include/copyright.jsp" />
</div>
<jsp:include page="../include/footer.jsp"/>

<script src="/static/assets/plugins/treeTable/jquery.treeTable.min.js"></script>
<!--自定义模板-->
<sys:modal/>
<script>
    $(function () {
        $('#treeTable').treeTable({
            column: 1,
            expandLevel: 2
        });
    });
</script>


</body>
</html>
