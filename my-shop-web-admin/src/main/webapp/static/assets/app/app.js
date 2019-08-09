var App = function () {

    // iCheck
    var _icheck_master;
    var _checkbox;

    // 用于存放 ID 的数组
    var _idArray;
    // 默认的 Dropzone 参数
    var defaultDropzoneOpts = {
        url: "",
        paramName: "dropFile",
        maxFiles: 1, // 一次性上传的文件数量上限
        maxFilesize: 2, // 文件大小，单位：MB
        acceptedFiles: ".jpg,.gif,.png,.jpeg", // 上传的类型
        addRemoveLinks: true,
        parallelUploads: 1, // 一次上传的文件数量
        dictDefaultMessage: '拖动文件至此或者点击上传',
        dictMaxFilesExceeded: "您最多只能上传 1 个文件！",
        dictResponseError: '文件上传失败!',
        dictInvalidFileType: "文件类型只能是*.jpg,*.gif,*.png,*.jpeg",
        dictFallbackMessage: "浏览器不受支持",
        dictFileTooBig: "文件过大上传文件最大支持",
        dictRemoveLinks: "删除",
        dictCancelUpload: "取消"
    };

    /**
     * 初始化 Dropzone
     * @param opts
     */

    var handlerInitDropzone = function (opts) {
        // 关闭 Dropzone 的自动发现功能
        Dropzone.autoDiscover = false;
        // 继承
        $.extend(defaultDropzoneOpts, opts);
        new Dropzone(defaultDropzoneOpts.id, defaultDropzoneOpts);
    };


    /**
     * zTree数组的调用
     * 初始化zTree
     */
    var handlerZtree=function (url,param,callback) {
        var setting = {
            view: {
                // 禁止多选
                selectedMulti: false
            },
            async: {
                // 开启异步加载功能
                enable: true,
                // 远程访问地址
                url: url,
                // 选择父节点时会自动将节点中的参数传回服务器再重新取结果
                autoParam: param,

            }
        };



        /**
         *
         * 初始化 zTree 控件
         *
         */
        $.fn.zTree.init($("#myTree"), setting);
        $("#btnModel").bind("click",function () {
            var Ztree=$.fn.zTree.getZTreeObj("myTree");
            var nodes=Ztree.getSelectedNodes();

            //未选择
            if(nodes.length==0){
                alert("请选择一个节点")
            }else {
                callback(nodes);

            }
        })
    }


    /**
     * 私有方法，初始化 ICheck
     */
    var handlerInitCheckbox = function () {
        // 激活
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        });

        // 获取控制端 Checkbox
        _masterCheckbox = $('input[type="checkbox"].minimal.icheck_master');

        // 获取全部 Checkbox 集合
        _checkbox = $('input[type="checkbox"].minimal');
    };
    /**
     * 实现展示效果
     *
     */
    var handleShowDetall=function (url) {
        $.ajax({
            url:url,
            type:"get",
            dataType:"html",
            success:function (data) {
                $("#modal-message").html(data);
                $("#modal-detail").modal("show");
            }
        })
    }


    /**
     * Checkbox 全选功能
     */
    var handlerCheckboxAll = function () {
        _masterCheckbox.on("ifClicked", function (e) {
            // 返回 true 表示未选中
            if (e.target.checked) {
                _checkbox.iCheck("uncheck");
            }

            // 选中状态
            else {
                _checkbox.iCheck("check");
            }
        });

    };
    /**
     * 分页功能
     */
    function  handlerInitDataTables (url,columns) {
      var _dataTable =$("#dataTable").DataTable({
          "paging": true,
          "info": true,
          "lengthChange": false,
          "ordering": false,
          "processing": true,
          "searching": false,
          "serverSide": true,
          "deferRender": true,
            "ajax": {
                "url":url,
            },
           "columns":columns,
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "drawCallback": function( settings ) {
                handlerInitCheckbox();
                handlerCheckboxAll();
            }
        });
      return _dataTable;
    }

    /**
     * 删除单笔数据
     */
   var handlerDeleteSingle=function(url, id, msg){
       console.log("删除单笔数据开始");
        console.log(url);
        console.log(id);
        console.log(msg);
       //可选参数
        if(!msg) msg=null;
        //将ID放入数组中,以便和批量删除通用
        _idArray=new Array();
        _idArray.push(id);

        $("#modal-messages").html(msg == null? "您确定要删除数据项吗?" : msg);
        $("#modal-default").modal("show");
        //绑定删除事件
        $("#btnModel").bind("click",function () {
            handlerDeleteData(url);
            console.log("调用AJAX");
        });

    };

    /**
     * 批量删除
     */
    var handlerDeleteMulti = function (url) {
        _idArray = new Array();
        console.log("掉用批量删除开始");

        // 将选中元素的 ID 放入数组中

        _checkbox.each(function () {
            var _id = $(this).attr("id");
            if (_id != null && _id != "undefine" && $(this).is(":checked")) {
                _idArray.push(_id);
                console.log("id放进去array");
                console.log(_id);
            }
        });

        // 判断用户是否选择了数据项
        if (_idArray.length === 0) {

            $("#modal-messages").html("您还没有选择任何数据项，请至少选择一项");

        } else {
            $("#modal-messages").html("您确定删除数据项吗？");
        }

        // 点击删除按钮时弹出模态框
        $("#modal-default").modal("show");

        // 如果用户选择了数据项则调用删除方法
        $("#btnModel").bind("click", function () {

            handlerDeleteData(url);
            console.log("调用ajax删除");
        });
    };



    /**
     * AJAX的异步删除
     * @param url
     */
   var handlerDeleteData=function(url){

        console.log("调用ajax");
        //如果没有选择数据项关闭
        $("#modal-default").modal("hide");

        if (_idArray.length > 0) {
            // AJAX 异步删除操作
            setTimeout(function () {
                $.ajax({
                    "url": url,
                    "type": "POST",
                    "data": {"ids" : _idArray.toString()},
                    "dataType": "JSON",
                    "success": function (data) {
                        // 请求成功后，无论是成功或是失败都需要弹出模态框进行提示，所以这里需要先解绑原来的 click 事件
                        $("#btnModel").unbind("click");

                        // 请求成功
                        if (data.status === 200) {
                            // 刷新页面
                           // $("##btnModel").bind("click", function () {
                                window.location.reload();
                                console.log("调用200");
                                console.log(data);
                            //});
                        }

                        // 请求失败
                        else {
                            $("#btnModel").unbind("click");
                            // 确定按钮的事件改为隐藏模态框
                            $("#btnModel").bind("click", function () {
                                console.log(data);
                                $("#modal-default").modal("hide");
                            });
                        }
                        // 因为无论如何都需要提示信息，所以这里的模态框是必须调用的
                        $("#modal-messages").html(data.message);
                        $("#modal-default").modal("show");
                        console.log(data);
                    }
                });
            }, 500)
        }
    };





    return {
        /**
         * 初始化
         */
        init: function() {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },

        /**
         * 初始化 Dropzone
         * @param opts
         */
        initDropzone: function(opts) {
            handlerInitDropzone(opts);
        },
        /**
         * 初始化Ztree
         * @param url
         * @param params
         * @param callback
         */
        initZtree:function(url,params,callback){
           return handlerZtree(url,params,callback);
        },
        /**
         * 删除单笔数据
         * @param url
         */
        deleteSingle: function(url, id, msg) {
            handlerDeleteSingle(url, id, msg);
            console.log("删除单笔数据");
        },

        /**
         * 批量删除
         * @param url
         */
        deleteMulti: function (url) {

            handlerDeleteMulti(url);
            console.log("调用开始");
        },
        /**
         * 实现查看功能
         *
         */

        showDatall:function(url){
            handleShowDetall(url);
         },

        /**
         * 初始化 DataTables
         * @param url
         * @param columns
         * @returns {*|jQuery}
         */
        initDataTables: function (url, columns) {
            return handlerInitDataTables(url, columns);
        },
        getCheckbox:function(){
            return _checkbox;
        },
    }
}();

$(document).ready(function () {
   App.init();
});