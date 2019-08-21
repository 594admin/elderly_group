<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>工程小组列表</title>
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <style type="text/css">
        .lab {
            width: 95px;
            margin-left: -6px;
        }

        .fu {
            margin-left: -18px;
        }

        .fu_div {
            width: 120px;
            display: inline-block;
        }
        .fu_empty{
            width: 400px;
            height: 30px;
            margin: 10px 0 10px 20px;
        }
    </style>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <div style="float: right;margin-right: 1%;margin-bottom: 20px;">
                        <a href="" class="btn btn-primary" data-toggle="modal" data-target="#myModal">新增工程小组</a>
                        <div class="modal inmodal" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content animated fadeIn">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"><span
                                                    aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                                        </button>
                                        <h4 class="modal-title">新增工程小组</h4>
                                    </div>
                                    <form action="/addTeam" method="post" class="form-horizontal">
                                        <div class="modal-body" style="height: 400px;">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label"><i class="fa fa-asterisk"></i>小组名</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" class="form-control"
                                                               placeholder="仅支持3-10个中文字符"
                                                               pattern="[\u4e00-\u9fa5]{3,10}" title="只能输入3-10个中文字符" name="teamName">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label lab">请选择组长</label>
                                                    <div class="col-sm-10">
                                                        <select class="form-control m-b" name="teamLeader">
                                                            <option value="-1">请选择</option>
                                                            <#list leaderList as l>
                                                                <option value="${l.preId}">${l.preName}</option>
                                                            </#list>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label lab">选择信息员</label>
                                                    <div class="col-sm-10">
                                                        <#list Informationers as i>
                                                            <div class="checkbox i-checks fu_div">
                                                                <label class="fu">
                                                                    <input type="checkbox" value="${i.preId}" name="informationer"> <i></i> ${i.preName}</label>
                                                            </div>
                                                        </#list>

                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label lab">选择库管员</label>
                                                    <div class="col-sm-10">
                                                        <#list WarehouseManagers as m>
                                                            <div class="checkbox i-checks fu_div">
                                                                <label class="fu">
                                                                    <input type="checkbox" value="${m.preId}" name="warehousemanager"> <i></i> ${m.preName}</label>
                                                            </div>
                                                        </#list>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label lab">选择安装工</label>
                                                    <div class="col-sm-10">
                                                        <#list Installers as s>
                                                            <div class="checkbox i-checks fu_div">
                                                                <label class="fu">
                                                                    <input type="checkbox" value="${s.preId}" name="installer"> <i></i> ${s.preName}</label>
                                                            </div>
                                                        </#list>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer" style="text-align: center;">
                                            <button type="submit" class="btn btn-primary">新增</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <button type="reset" class="btn btn-white">重置</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>小组名称</th>
                            <th>组长</th>
                            <th>组员</th>
                            <th>创建日期</th>
                            <th>创建人</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list TeamList as t>
                            <tr>
                                <td>${t.tname}</td>
                                <td>${t.leader}</td>
                                <td>
                                    <#list t.member as m>
                                        ${m.preName}&nbsp;&nbsp;
                                    </#list>
                                </td>
                                <td>${t.createTime?string("yyyy-MM-dd")}</td>
                                <td>${t.creator}</td>
                                <td>
                                    <a href="" class="btn btn-success btn-sm" data-toggle="modal" data-target="#myModal2" onclick="edtTeam(${t.tid})" ">
                                        编辑
                                    </a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <div class="modal inmodal" id="myModal2" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content animated fadeIn">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"><span
                                                aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                                    </button>
                                    <h4 class="modal-title">编辑工程小组</h4>
                                </div>
                                <form action="/edtTeamById" method="post" class="form-horizontal">
                                    <input type="hidden" name="edt_teamId">
                                    <div class="modal-body" style="height: 400px;">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label"><i class="fa fa-asterisk"></i>小组名</label>
                                                <div class="col-sm-10">
                                                    <input name="edt_teamName" type="text" class="form-control"
                                                           placeholder="仅支持3-10个中文字符"
                                                           pattern="[\u4e00-\u9fa5]{3,10}" title="只能输入3-10个中文字符">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label lab">请选择组长</label>
                                                <div class="col-sm-10">
                                                    <select name="edt_teamLeader" class="form-control m-b">
                                                        <option value="-1">请选择</option>
                                                        <#list leaderList as l>
                                                            <option value="${l.preId}">${l.preName}</option>
                                                        </#list>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label lab">选择信息员</label>
                                                <div class="col-sm-10">
                                                    <#list Informationers as i>
                                                        <div class="checkbox i-checks fu_div">
                                                            <label class="fu">
                                                                <input name="edt_informationer" type="checkbox" value="${i.preId}"> <i></i> ${i.preName}</label>
                                                        </div>
                                                    </#list>
                                                    <div class="fu_empty" name="xinDiv"></div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label lab">选择库管员</label>
                                                <div class="col-sm-10">
                                                    <#list WarehouseManagers as m>
                                                        <div class="checkbox i-checks fu_div">
                                                            <label class="fu">
                                                                <input name="edt_warehousemanger" type="checkbox" value="${m.preId}"> <i></i> ${m.preName}</label>
                                                        </div>
                                                    </#list>
                                                    <div class="fu_empty" name="kuDiv"></div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label lab">选择安装工</label>
                                                <div class="col-sm-10">
                                                    <#list Installers as s>
                                                        <div class="checkbox i-checks fu_div">
                                                            <label class="fu">
                                                                <input name="edt_installer" type="checkbox" value="${s.preId}"> <i></i> ${s.preName}</label>
                                                        </div>
                                                    </#list>
                                                    <div class="fu_empty" name="anDiv"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer" style="text-align: center;">
                                        <button type="submit" class="btn btn-primary" >保存</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <button type="button" class="btn btn-white" data-dismiss="modal">取消</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>


<!-- Peity -->
<script src="js/plugins/peity/jquery.peity.min.js"></script>

<!-- 自定义js -->
<script src="js/content.js?v=1.0.0"></script>


<!-- iCheck -->
<script src="js/plugins/iCheck/icheck.min.js"></script>

<!-- Peity -->
<script src="js/demo/peity-demo.js"></script>


<script>
    $(document).ready(function () {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });

    function edtTeam(tid) {
        // 组ID 组名 组长ID
        $.post("/getTeamById",{"tid":tid},function (data) {
            $("[name='edt_teamId']").val(data.temId);
            $("[name='edt_teamName']").val(data.temName);
            $("[name='edt_teamLeader'] option[value="+data.temLead+"]").attr("selected","selected");
        },"json");
        // 本组信息员ID 姓名
        $.post("/getInformationerByTeamId",{"tid":tid},function (data) {
            $("[name='xinDiv']").empty();
            for (let i = 0; i <data.length; i++) {
                let obj="<div class=\"checkbox i-checks fu_div\">\n" +
                    "<label class=\"fu\">\n" +
                    "<input name=\"edt_informationer\"  checked=\"checked\" type=\"checkbox\" value=\""+data[i].preId+"\"> <i></i> "+data[i].preName+"\n" +
                    "</label>\n" +
                    "</div>";
                $("[name='xinDiv']").append(obj);

            }

        },"json");
        // 本组库管员ID 姓名
        $.post("/getWarehouseManagerByTeamId",{"tid":tid},function (data) {
            $("[name='kuDiv']").empty();
            for (let i = 0; i <data.length; i++) {
                let obj="<div class=\"checkbox i-checks fu_div\">\n" +
                    "<label class=\"fu\">\n" +
                    "<input name=\"edt_warehousemanger\"  checked=\"checked\" type=\"checkbox\" value=\""+data[i].preId+"\"> <i></i> "+data[i].preName+"\n" +
                    "</label>\n" +
                    "</div>";
                $("[name='kuDiv']").append(obj);

            }
        },"json");
        // 本组安装工ID 姓名
        $.post("/getInstallerByTeamId",{"tid":tid},function (data) {
            $("[name='anDiv']").empty();
            for (let i = 0; i <data.length; i++) {
                let obj="<div class=\"checkbox i-checks fu_div\">\n" +
                    "<label class=\"fu\">\n" +
                    "<input name=\"edt_installer\"  checked=\"checked\" type=\"checkbox\" value=\""+data[i].preId+"\"> <i></i> "+data[i].preName+"\n" +
                    "</label>\n" +
                    "</div>";
                $("[name='anDiv']").append(obj);

            }
        },"json");
    }
</script>

</body>

</html>