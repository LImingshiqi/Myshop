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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>AdminLTE 2 | 管理控制台</title>
    <!--树形Ztre-->
    <link rel="stylesheet" href="/static/assets/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.min.css" />
    <!-- Tell the browser to be responsive to screen width -->
    <jsp:include page="../include/header.jsp"/>






</head>
<body class="hold-transition skin-blue sidebar-mini">
<link rel="stylesheet" href="/static/assets/plugins/wangEditor/wangEditor.min.css" />
<link rel="stylesheet" href="/static/assets/plugins/dropzone/min/dropzone.min.css" />
<link rel="stylesheet" href="/static/assets/plugins/dropzone/min/basic.min.css" />
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
             管理内容
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
                        <h3 class="box-title">${tbContent.id == null ? "新增" : "编辑"}内容</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
            <form:form id="inputForm" cssClass="form-horizontal" action="/content/save" method="post" modelAttribute="tbContent">
                <form:hidden path="id" />


                    <div class="box-body">
                        <div class="form-group">
                        <label class="col-sm-2 control-label">父级类目</label>
                        <div class="col-sm-10 ">
                            <form:hidden id="categoryId" path="tbContentCategory.id" />
                            <input id="categoryName" class="form-control required"  placeholder="请选择" readonly="true" data-toggle="modal" data-target="#modal-default" value="${tbContent.tbContentCategory.name}" />
                        </div>
                    </div>


                        <div class="form-group">
                            <label for="title" class="col-sm-2 control-label">标题</label>
                            <div class="col-sm-10 ">
                                <form:input path="title" class="form-control required" placeholder="标题" />
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="subTitle" class="col-sm-2 control-label">子标题</label>
                            <div class="col-sm-10 ">
                                <form:input path="subTitle" class="form-control required" placeholder="子标题" />
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="titleDesc" class="col-sm-2 control-label">标题描述</label>
                            <div class="col-sm-10 ">
                                <form:input path="titleDesc" class="form-control required" placeholder="标题描述" />
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="url" class="col-sm-2 control-label">链接</label>
                            <div class="col-sm-10 ">
                                <form:input path="url" class="form-control required" placeholder="链接" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="url" class="col-sm-2 control-label">图片1</label>
                            <div class="col-sm-10 ">
                                <form:input path="pic" class="form-control" placeholder="图片1" />
                                <div id="dropz" class="dropzone"></div>
                            </div>
                        </div>



                        <div class="form-group">
                            <label for="url" class="col-sm-2 control-label">图片2</label>
                            <div class="col-sm-10 ">
                                <form:input path="pic2" class="form-control" placeholder="图片2" />
                                <div id="dropz2" class="dropzone"></div>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-2 control-label">详情</label>
                            <div class="col-sm-10 ">
                                <form:hidden path="content" />
                                <div id="editor">${tbContent.content}</div>
                            </div>
                        </div>


                    <div class="box-footer">
                        <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                        <button id="submitWang" type="submit" class="btn btn-info pull-right" onclick="">提交</button>
                    </div>
            </form:form>

                </div>

            </div>
       </section>
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../include/copyright.jsp" />
</div>
<jsp:include page="../include/footer.jsp"/>
<!--ZTree树形菜单-->
<script src="/static/assets/plugins/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
<!--图片上传-->
<script src="/static/assets/plugins/dropzone/min/dropzone.min.js"></script>
<!--Wang富文本编辑器-->
<script src="/static/assets/plugins/wangEditor/wangEditor.min.js"></script>

<!--自定义模态框-->
<sys:modal title="请选择父级类目" message="<ul id='myTree' class='ztree'></ul>"/>

<script>

    $(function () {
        App.initZtree("/content/category/tree/data", ["id"], function (nodes){

            var node=nodes[0];
            $("#categoryId").val(node.id);
            $("#categoryName").val(node.name);
            $("#modal-default").modal("hide");
        })
        initWangEditor();
    });
    /**
     * 初始化富文本编辑器
     */
    function  initWangEditor () {
        var E = window.wangEditor;
        var editor = new E('#editor');

        editor.customConfig.uploadImgServer = '/upload';
        editor.customConfig.uploadFileName = 'editorFiles';
        editor.create();
        $("#submitWang").bind("click",function () {
            var contentHtml = editor.txt.html();
            $("#content").val(contentHtml);
        });

    }
    /**
     * 图片上传
     */
    App.initDropzone({
        id: "#dropz",
        url: "/upload",
        init: function () {
            this.on("success", function (file, data) {
                $("#pic").val(data.fileName);
            });
        }
    });


    App.initDropzone({
        id: "#dropz2",
        url: "/upload",
        init: function () {
            this.on("success", function (file, data) {
                $("#pic2").val(data.fileName);
            });
        }
    });




</script>

</body>
</html>
