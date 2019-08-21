<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - 数据表格</title>
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
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>基本 <small>分类，查找</small></h5>
                        <div align="center"><span style="color: red"><#if deletemsg??><h3>${deletemsg}</h3></#if></span></div>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="familylist.ftl#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="familylist.ftl#">选项1</a>
                                </li>
                                <li><a href="familylist.ftl#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">

                        <table class="table table-striped table-bordered table-hover dataTables-example">
                            <a href="/toaddfamily"><button type="button" class="btn btn-w-m btn-primary">添加用户</button></a>
                            <thead>
                            <tr>
                                <th>户主</th>
                                <th>村</th>
                                <th>乡镇/街道</th>
                                <th>区县</th>
                                <th>手机号</th>
                                <th>身份证</th>
                                <th>工程组名</th>
                                <th>状态</th>
                                <th >操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list flist as fl>
                            <tr class="gradeX">

                                <td>${fl.fly_name}</td>
                                <td>${fl.cunweihui}</td>
                                <td>${fl.jiedao}</td>
                                <td>${fl.qu}</td>
                                <td >${fl.fly_phone}</td>
                                <td >${fl.fly_IDcard}</td>
                                <td>${fl.tem_name}</td>
                                <td><#if fl.fly_status==1><span style="color: green">完成</span>
                                    <#elseif fl.fly_status==2><span style="color: red">已录入户基本信息</span>
                                    <#elseif fl.fly_status==3><span style="color: red">已录入采购信息</span>
                                </#if>
                                </td>
                                <td>
                                    <a data-toggle="modal" class="btn btn-info btn-xs" href="/tosecond?fly_status=${fl.fly_status}&&fly_id=${fl.fly_id}">
                                        <#if fl.fly_status==1>查看
                                        <#else >继续录入
                                        </#if></a>
                                    <#--<a data-toggle="modal" class="btn btn-info btn-xs"  href="/deletefamily?fly_id=${fl.fly_id}">删除</a>-->

                                </td>
                            </tr>
                            </#list>
                            </tbody>
                            <tfoot>
                            <tr>
                                <th>户主</th>
                                <th>村</th>
                                <th>乡镇/街道</th>
                                <th>区县</th>
                                <th>手机号</th>
                                <th>身份证</th>
                                <th>工程组名</th>
                                <th>状态</th>
                                <th >操作</th>
                            </tr>
                            </tfoot>
                        </table>

                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>



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
