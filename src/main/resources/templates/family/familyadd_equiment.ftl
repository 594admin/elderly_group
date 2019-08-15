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
    <div class="col-sm-12">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <div align="center"><span style="color: red"><#if addmsg??><h3>${addmsg}</h3></#if></span></div>
            <div class="ibox-tools">
                <a class="collapse-link">
                    <i class="fa fa-chevron-up"></i>
                </a>
                <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                    <i class="fa fa-wrench"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="form_basic.html#">选项1</a>
                    </li>
                    <li><a href="form_basic.html#">选项2</a>
                    </li>
                </ul>
                <a class="close-link">
                    <i class="fa fa-times"></i>
                </a>
            </div>
        </div>

        <div class="ibox-content">
            <h5>设备采购信息</h5>
            <form class="form-horizontal m-t" id="signupForm">
                <div class="form-group">
                    <div class="form-group" style="margin-left: 80px">
                        <div class="col-sm-12">
                            &nbsp;
                            <select class="chosen-select" style="width:120px;height: 34px">
                                <option value="" hassubinfo="true">请选择产品类型</option>
                                <option value="热风机" hassubinfo="true">热风机</option>
                                <option value="生物质炉具" hassubinfo="true">生物质炉具</option>
                                <option value="水机" hassubinfo="true">水机</option>
                            </select>
                            &nbsp;
                            <select class="chosen-select" style="width:120px;height: 34px">
                                <option value="" hassubinfo="true">请选择厂家</option>
                                <option value="海尔" hassubinfo="true">海尔</option>
                                <option value="格力" hassubinfo="true">格力</option>
                                <option value="美的" hassubinfo="true">美的</option>
                                <option value="中能北方" hassubinfo="true">中能北方</option>
                            </select>
                            &nbsp;
                            <select class="chosen-select" style="width:120px;height: 34px">
                                <option value="" hassubinfo="true">请选择型号</option>
                                <option value="DZW39" hassubinfo="true">DZW39</option>
                                <option value="DZW40" hassubinfo="true">DZW40</option>
                            </select>
                            &nbsp;
                            <button  onclick="add()">确定</button>
                        </div>
                    </div>
                    <table class="footable table table-stripped footable-loaded" data-page-size="8" data-filter="#filter">
                        <thead>
                        <tr>
                            <th class="footable-sortable">产品类型<span class="footable-sort-indicator"></span></th>
                            <th class="footable-sortable">厂家<span class="footable-sort-indicator"></span></th>
                            <th class="footable-sortable">型号<span class="footable-sort-indicator"></span></th>
                            <th class="footable-sortable">单价<span class="footable-sort-indicator"></span></th>
                            <th class="footable-sortable">数量<span class="footable-sort-indicator"></span></th>
                            <th class="footable-sortable">操作<span class="footable-sort-indicator"></span></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr class="gradeX footable-even" style="display: table-row;">
                            <td><span class="footable-toggle"></span>Trident</td>
                            <td>Internet Explorer 4.0
                            </td>
                            <td>Win 95+</td>
                            <td class="center">4</td>
                            <td class="center">X</td>
                        </tr>
                        </tbody>
                    </table>

                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-3">
                        <button class="btn btn-primary" type="submit"><下一步></button>
                    </div>
                </div>
            </form>
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
    <!-- JSKnob -->
    <script src="js/plugins/jsKnob/jquery.knob.js"></script>

    <!-- Input Mask-->
    <script src="js/plugins/jasny/jasny-bootstrap.min.js"></script>

    <!-- Data picker -->
    <script src="js/plugins/datapicker/bootstrap-datepicker.js"></script>

    <!-- Prettyfile -->
    <script src="js/plugins/prettyfile/bootstrap-prettyfile.js"></script>

    <!-- NouSlider -->
    <script src="js/plugins/nouslider/jquery.nouislider.min.js"></script>

    <!-- Switchery -->
    <script src="js/plugins/switchery/switchery.js"></script>

    <!-- IonRangeSlider -->
    <script src="js/plugins/ionRangeSlider/ion.rangeSlider.min.js"></script>

    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>

    <!-- MENU -->
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>

    <!-- Color picker -->
    <script src="js/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>

    <!-- Clock picker -->
    <script src="js/plugins/clockpicker/clockpicker.js"></script>

    <!-- Image cropper -->
    <script src="js/plugins/cropper/cropper.min.js"></script>

    <script src="js/demo/form-advanced-demo.js"></script>

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
<script>
    function add() {

    }
</script>

</body>

</html>
