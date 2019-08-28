<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>账号管理</title>
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
                    <h5>账户 <small>列表</small></h5>
                    <#if "addmsg??">
                        <p style="color:blue;">${addmsg}</p>
                    </#if>
                </div>
                <div class="ibox-content">
                    <div class="text-left">
                        <a data-toggle="modal"  class="btn btn-primary" href="#modal-form">新增账户</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>账户/<small>列表</small></h5>
                    </div>
                    <div class="ibox-content">

                        <table class="table table-striped table-bordered table-hover dataTables-example">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>手机号</th>
                                    <th>姓名</th>
                                    <th>邮箱</th>
                                    <th>性别</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                            <#list listPersonnel as personnel >
                            <tr class="gradeX">
                                <td>${personnel.preId}</td>
                                <td>${personnel.prePhone}</td>
                                <td>${personnel.preName}
                                </td>
                                <td>${personnel.preEmail}</td>
                                <td class="center">
                                   <#if personnel.preGender ==1>
                                       男
                                       <#else >
                                         女
                                   </#if>
                                </td>
                                <td class="center">
                                     <#if personnel.preStatus ==1>
                                       正常
                                     <#else >
                                        注销
                                     </#if>
                                </td>
                                <td class="center">
                                    <a data-toggle="modal"  class="btn btn-info btn-xs" href="/toUpdatePersonnel?preId=${personnel.preId}">编辑</a>
                                   &nbsp;&nbsp;&nbsp;<a data-toggle="modal"  class="btn btn-info btn-xs"
                                                        onclick="addPerRole(${personnel.preId}, ${personnel.preRoleId});"
                                                        href="#modal-form-role">用户角色</a>
                                </td>
                            </tr>
                            </#list>

                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>ID</th>
                                    <th>手机号</th>
                                    <th>姓名</th>
                                    <th>邮箱</th>
                                    <th>性别</th>
                                    <th>状态</th>
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
                    <h1>新增用户</h1>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal m-t" id="commentForm" action="/doAddPersonnels" method="post">
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color: red">*</span>手机号：</label>
                            <div class="col-sm-8">
                                <input name="prePhone" minlength="2" type="text" class="form-control" pattern="0?(13|14|15|18|17)[0-9]{9}" required="" aria-required="true">
                            </div>
                        </div>
                        <p align="center"  style="color: red" id="prePhones"></p>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color: red">*</span>密码：</label>
                            <div class="col-sm-8">
                                <input name="prePassword" minlength="2" type="text" class="form-control"  required="" aria-required="true">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color: red">*</span>姓名：</label>
                            <div class="col-sm-8">
                                <input name="preName" minlength="2" type="text" class="form-control" required="" aria-required="true">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">E-mail：</label>
                            <div class="col-sm-8">
                                <input id="cemail" type="email" class="form-control" name="preEmail"  aria-required="true">
                            </div>
                        </div>
                        <p align="center"  style="color: red" id="preEmails"></p>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">性别：</label>
                            <div class="col-sm-8">
                                <div class="radio">
                                    <label><input type="radio" checked  value="1"  name="preGender">男</label>
                                    <label><input type="radio" value="0" name="preGender">女</label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">状态：</label>
                            <div class="col-sm-8">
                                <div class="radio">
                                    <label><input type="radio" checked  value="1" name="preStatus">正常</label>
                                    <label><input type="radio" value="0"  name="preStatus">注销</label>
                                </div>

                            </div>
                        </div>

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



    <div id="modal-form-role" class="modal fade" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <h1>用户角色设置: <small id="userroles"></small></h1>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal m-t"  action="/doAddPerRole" method="post">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">请选择角色
                            </label>
                            <input type="hidden" name="preId" value="">

                            <div class="col-sm-10">
                                <#list listRole as role>
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="radio" name="roleId" value="${role.roleId}" > ${role.roleName}</label>
                                    </div>
                                </#list>

                            </div>
                        </div>

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
                //验证手机号
                $("[name='prePhone']").focus(function(){
                    $("#prePhones").html('');
                }).blur(function(){
                    var prePhone = $("[name='prePhone']").val();
                    if(prePhone !='' && prePhone !=null){
                        var a = /0?(13|14|15|18|17)[0-9]{9}/;
                       if(!a.test(prePhone)){
                           $("#prePhones").append("请输入正确格式的手机号");
                           $("[name='prePhone']").val('');
                       }else {
                           $.post("/ajaxCheckPhone",{"prePhone":prePhone},
                                   function(prePhone){
                                       if(prePhone){
                                           $("#prePhones").append("手机号重复");
                                           $("[name='prePhone']").val('');
                                       }else{
                                           $("#prePhones").append("手机号可以使用");
                                       }
                                   }
                           )
                       }
                    }
                });
            //验证邮箱
            $("[name='preEmail']").focus(function(){
                $("#preEmails").html('');
            }).blur(function(){
                var preEmail = $("[name='preEmail']").val();
                if(preEmail !='' && preEmail !=null){
                    var a = /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/;
                    if(!a.test(preEmail)){
                        $("#preEmails").append("请输入正确格式的邮箱");
                        $("[name='preEmail']").val('');
                    }else {
                        $.post("/ajaxCheckEmail",{"preEmail":preEmail},
                                function(preEmail){
                                    if(preEmail){
                                        $("#preEmails").append("邮箱重复");
                                        $("[name='preEmail']").val('');
                                    }else{
                                        $("#preEmails").append("邮箱可以使用");
                                    }
                                }
                        )
                    }
                }
            });
        })
    </script>
    <script type="text/javascript">
      function addPerRole(preId,preRoleId){
          $("input[name='preId']").val(preId);
          $("#userroles").html('');
          if(preRoleId!=null && preRoleId!=""){
              $.post("/ajaxGetRole",{"preRoleId":preRoleId},function (result) {
                  $("input[name='roleId'][value="+result+"]").attr("checked",true);
              })
          }else {
              $("#userroles").append("当前用户没用分配角色");
              $("input[name='roleId'][value='0']").attr("checked",true);
          }
      }
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
