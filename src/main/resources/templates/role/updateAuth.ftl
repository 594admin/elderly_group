<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>权限及菜单配置</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="/favicon.ico"> <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css?v=4.1.0" rel="stylesheet">

    <link href="css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">

</head>
<style>
    .table4_9 table {
        width:100%;
        margin:15px 0;
        border:0;
    }
    .table4_9 th {
        background-color:#13C7A3;
        color:#FFFFFF
    }
    .table4_9,.table4_9 th,.table4_9 td {
        font-size:15px;
        text-align:center;
        padding:4px;
        border-collapse:collapse;
    }
    .table4_9 th,.table4_9 td {
        border: 1px solid #78dfca;
    }
    .table4_9 tr {
        border: 1px solid #78dfca;
    }

    .table4_9 tr:nth-child(even){
        background-color:#fdfdfd;
    }
</style>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h1>系统管理/ <small>菜单及权限配置</small></h1>
                    </div>
                    <div class="ibox-content">
                        <div class="ibox-title">
                            <h1>当前角色：${rlName}</h1>
                            <h3 style="color: red">请选择操作后！务必选中模块以及菜单！！否则权限无效</h3>
                        </div>
                            <form method="post" class="form-horizontal" id="doUpdateAuth" action="/doUpdateAuth">
                                <input type="hidden" name="roleId" value="${rlId}">
                                <input type="hidden" name="rlName" value="${rlName}">
                                <div class="hr-line-dashed" align="center"></div>
                                <table align="center" width="95%" class="table4_9">

                                    <tr align="center">
                                        <th align="center" width="20%"><h1>模块</h1></th>
                                        <th align="center" width="40%"><h1>菜单</h1></th>
                                        <th align="center" width="40%"><h1>操作</h1></th>
                                    </tr>

                                    <tr>
                                        <td rowspan="11" style="font-size: 30px" align="center">
                                            <label class="checkbox-primary">
                                            移动端&nbsp;
                                            <input type="checkbox" name="authId" value="52"></label></td>
                                        <td>
                                                <div class="col-sm-10">
                                                    <label class="checkbox-primary">
                                                        <input type="checkbox" name="authId" value="1">&nbsp;户信息</label>
                                                </div>
                                        </td>
                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="2">&nbsp;编辑</label>&nbsp;
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="3">&nbsp;修改</label>&nbsp;
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="4">&nbsp;查看</label>&nbsp;
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>

                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="5">&nbsp;新增户</label>&nbsp;
                                            </div>
                                        </td>
                                        <td>
                                        </td>
                                    </tr>
                                    <tr>

                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="6">&nbsp;出库</label>&nbsp;
                                            </div>
                                        </td>
                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="21">&nbsp;出库</label>&nbsp;
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="7">&nbsp;查看</label>&nbsp;
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>

                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="8">&nbsp;设备</label>&nbsp;
                                            </div>
                                        </td>
                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="9">&nbsp;入库</label>&nbsp;
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>

                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="10">&nbsp;分配</label>&nbsp;
                                            </div>
                                        </td>
                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="11">&nbsp;分配</label>&nbsp;
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="12">&nbsp;查看</label>&nbsp;
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="13">&nbsp;修改</label>&nbsp;
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>

                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="14">&nbsp;安装</label>&nbsp;
                                            </div>
                                        </td>
                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="15">&nbsp;安装</label>&nbsp;
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="16">&nbsp;查看</label>&nbsp;
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>

                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="17">&nbsp;区域统计</label>&nbsp;
                                            </div>
                                        </td><td>

                                        </td>
                                    </tr>
                                    <tr>

                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="18">&nbsp;厂家统计</label>&nbsp;
                                            </div>
                                        </td>
                                        <td>
                                        </td>
                                    </tr>
                                    <tr>

                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="19">&nbsp;工程统计</label>&nbsp;
                                            </div>
                                        </td>
                                        <td>
                                        </td>
                                    </tr>
                                    <tr>

                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="20">&nbsp;我的</label>&nbsp;
                                            </div>
                                        </td>
                                        <td>
                                        </td>
                                    </tr>
                                </table>

                                <br>
                                <br>
                                <br>
                                <table align="center" width="95%" class="table4_9">

                                    <tr align="center">
                                        <th align="center" width="20%"><h1>管理端模块</h1></th>
                                        <th align="center" width="40%"><h1>菜单</h1></th>
                                        <th align="center" width="40%"><h1>操作</h1></th>
                                    </tr>

                                    <tr>
                                        <td rowspan="2" style="font-size: 15px" align="center">
                                            <label class="checkbox-primary">户信息管理&nbsp;
                                                <input type="checkbox" name="authId" value="46"></label></td>
                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="22">&nbsp;户信息列表</label>&nbsp;
                                            </div>
                                        </td>
                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="23">&nbsp;编辑</label>&nbsp;
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="24">&nbsp;删除</label>&nbsp;
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="44">&nbsp;查看</label>&nbsp;
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>

                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="25">&nbsp;新增户信息</label>&nbsp;
                                            </div>
                                        </td>
                                        <td>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-size: 15px" align="center">
                                            <label class="checkbox-primary">设备管理&nbsp;
                                                <input type="checkbox" name="authId" value="47"></label></td>
                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="26">&nbsp;设备列表</label>&nbsp;
                                            </div>
                                        </td>
                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="29">&nbsp;新增设备</label>&nbsp;
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="27">&nbsp;入库</label>&nbsp;
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="28">&nbsp;删除</label>&nbsp;
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td rowspan="3" style="font-size: 15px" align="center">
                                            <label class="checkbox-primary">统计&nbsp;
                                                <input type="checkbox" name="authId" value="48"></label></td>
                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="30">&nbsp;区域统计</label>&nbsp;
                                            </div>
                                        </td>
                                        <td></td>
                                    </tr>
                                    <tr>

                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="31">&nbsp;工程小组统计</label>&nbsp;
                                            </div>
                                        </td>
                                        <td></td>
                                    </tr>
                                    <tr>

                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="32">&nbsp;厂家统计</label>&nbsp;
                                            </div>
                                        </td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td rowspan="2" style="font-size: 15px" align="center">
                                            <label class="checkbox-primary">账号管理&nbsp;
                                                <input type="checkbox" name="authId" value="49"></label></td>

                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="33">&nbsp;账号列表</label>&nbsp;
                                            </div>
                                        </td>
                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="36">&nbsp;新增账户</label>&nbsp;
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="34">&nbsp;编辑</label>&nbsp;
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="35">&nbsp;账户角色分配</label>&nbsp;
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>

                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="37">&nbsp;角色列表</label>&nbsp;
                                            </div>
                                        </td>
                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="38">&nbsp;菜单及权限配置</label>&nbsp;
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="39">&nbsp;新增角色</label>&nbsp;
                                            </div>

                                        </td>
                                    </tr>
                                    <tr>
                                        <td  style="font-size: 15px" align="center">
                                            <label class="checkbox-primary">工程小组管理&nbsp;
                                                <input type="checkbox" name="authId" value="50"></label></td>
                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="40">&nbsp;工程小组列表</label>&nbsp;
                                            </div>
                                        </td>
                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="42">&nbsp;新增小组</label>&nbsp;
                                                <label class="checkbox-primary">
                                                    <input type="checkbox" name="authId" value="41">&nbsp;编辑</label>&nbsp;
                                            </div>

                                        </td>
                                    </tr>
                                    <tr>
                                        <td  style="font-size: 15px" align="center"><label class="checkbox-primary">意见反馈&nbsp;
                                            <input type="checkbox"  name="authId" value="51"></label>
                                        </td>
                                        <td>
                                            <div class="col-sm-10">
                                                <label class="checkbox-primary">
                                                    <input  type="checkbox"  name="authId" value="43">&nbsp;意见反馈列表</label>&nbsp;
                                            </div>
                                        </td>
                                        <td>
                                        </td>
                                    </tr>
                                </table>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <div class="col-sm-4 col-sm-offset-2">
                                        <button class="btn btn-primary" onclick="up();" type="button">保存内容</button>
                                        <a class="btn btn-white"  href="/tolistrole">取消</a>
                                    </div>
                                </div>
                            </form>
                        </div>


                </div>
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="/js/jquery.min.js?v=2.1.4"></script>
    <script src="/js/bootstrap.min.js?v=3.3.6"></script>
    <script>
        function up(){
            if($("input[type='checkbox']").is(':checked')){
                $("#doUpdateAuth").submit();
            }else {
                alert("请至少选中一个权限");
                return  false;
            }
        }

    </script>
    <!-- 自定义js -->
    <script src="/js/content.js?v=1.0.0"></script>

    <script type="text/javascript">
        $(function() {
            var rlId = '${rlId}';
            //document.getElementById(43).setAttribute("checked","checked");
            $.post("/ajaxgetSysRoleAuthByRoleId", {"rlId": rlId}, function (s) {
                        for (var p in s){
                            var a  = s[p].authId;
                            $("input[value='"+a+"']").attr("checked","checked");
                        }
                    }, "json"
            );
        });
    </script>

    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    <!--统计代码，可删除-->

</body>

</html>
