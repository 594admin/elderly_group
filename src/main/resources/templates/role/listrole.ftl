<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>角色列表</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- Data Tables -->
    <link href="css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">


</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="col-sm-4">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h1>角色 <small>列表</small></h1>
                    <#if "addmsg??">
                        <p style="color:blue;">${addmsg}</p>
                    </#if>

                      <#if "addauthmsg??">
                        <h3>角色:${rlName}</h3>
                        <p style="color:blue;">新增${addauthmsg}个权限</p>
                          <p style="color:red;">删除${delauthmsg}个权限</p>
                      </#if>
                </div>
                <div class="ibox-content">
                    <div class="text-left">
                        <a data-toggle="modal"  class="btn btn-primary" href="#modal-form">新增角色</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>系统管理/<small>角色列表</small></h5>
                    </div>
                    <div class="ibox-content">

                        <table class="table table-striped table-bordered table-hover dataTables-example">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>角色名</th>
                                    <th>显示菜单</th>
                                    <th>管理端菜单</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                            <#list roles as role >
                            <tr class="gradeX">
                                <td>${role.rlId}</td>
                                <td>${role.rlName}</td>
                                <td>
                                    <span style="color: rebeccapurple;">
                                        <#if role.mobileMenu??&&(role.mobileMenu?size>0)>
                                            <#assign var = 0/>
                                             <#list role.mobileMenu as m  >
                                                <#if var % 4 = 0>
                                                    <br>
                                                </#if>
                                                 ${m}
                                                 <#assign var = var + 1/>
                                             </#list>
                                            <#else >
                                              无
                                        </#if>
                                    </span>
                                </td>
                                <td>
                                     <span style="color: blue">
                                    <#if role.clientMenu??&&(role.clientMenu?size>0)>
                                          <#assign var = 0/>
                                         <#list role.clientMenu as c >
                                             <#if var % 4 = 0>
                                                    <br>
                                             </#if>
                                                ${c}
                                             <#assign var = var + 1/>
                                         </#list>
                                        <#else >
                                         无
                                    </#if>
                                    </span>
                                </td>
                                <td class="center">
                                    <a data-toggle="modal"  class="btn btn-info btn-xs" href="#">编辑</a>
                                   &nbsp;&nbsp;&nbsp;<a data-toggle="modal"  class="btn btn-info btn-xs" href="/toUpdateAuth?rlId=${role.rlId}&rlName=${role.rlName}">菜单及权限配置</a>
                                </td>
                            </tr>
                            </#list>

                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>ID</th>
                                    <th>角色名</th>
                                    <th>显示菜单</th>
                                    <th>管理端菜单</th>
                                    <th>操作</th>
                                </tr>
                            </tfoot>
                        </table>

                    </div>
                </div>
            </div>
        </div>

    </div>
    <div id="modal-form" class="modal fade" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <h1>新增角色</h1>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal m-t" id="commentForm" action="/doAddRole" method="post">
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color: red">*</span>角色名称：</label>
                            <div class="col-sm-8">
                                <input name="roleName" minlength="2" placeholder="请输入中文名称" type="text" class="form-control" pattern="^[\u4e00-\u9fa5]{0,}$" required="" aria-required="true">
                            </div>
                        </div>
                        <p align="center"  style="color: red" id="preRoleName"></p>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-3">
                                <button class="btn btn-primary" type="submit">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script type="text/javascript">
        $(function(){
            $("input[name='roleName']").blur(function () {
               var roleName = $("input[name='roleName']").val();
                $("#preRoleName").html('');
                if(roleName!=null && roleName!=''){
                    $.post("/ajaxGetRoleByRoleName",{"roleName":roleName},function (flag) {
                        if(flag){
                            $("#preRoleName").append("系统内已存在相同的角色");
                            $("input[name='roleName']").val('');
                        }else{
                            $("#preRoleName").append("角色名可以使用");
                        }
                    })
                }
            })
        })
    </script>

    <script src="js/plugins/jeditable/jquery.jeditable.js"></script>

    <!-- Data Tables -->
    <script src="js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="js/plugins/dataTables/dataTables.bootstrap.js"></script>

    <!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>


    <!-- Page-Level Scripts -->
    <script>
        $(document).ready(function () {
            $('.dataTables-example').dataTable();

            /* Init DataTables */
            var oTable = $('#editable').dataTable();

            /* Apply the jEditable handlers to the table */
            oTable.$('td').editable('../example_ajax.php', {
                "callback": function (sValue, y) {
                    var aPos = oTable.fnGetPosition(this);
                    oTable.fnUpdate(sValue, aPos[0], aPos[1]);
                },
                "submitdata": function (value, settings) {
                    return {
                        "row_id": this.parentNode.getAttribute('id'),
                        "column": oTable.fnGetPosition(this)[2]
                    };
                },

                "width": "90%",
                "height": "100%"
            });


        });

        function fnClickAddRow() {
            $('#editable').dataTable().fnAddData([
                "Custom row",
                "New row",
                "New row",
                "New row",
                "New row"]);

        }
    </script>

    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    <!--统计代码，可删除-->

</body>

</html>
