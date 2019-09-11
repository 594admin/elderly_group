<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>统计</title>

    <!-- Data Tables -->
    <link href="css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <link rel="stylesheet" href="/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeIn">
    <div class="row">
        <div class="col-sm-12">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-content">
                            <br>
                            <form class="form-horizontal m-t" action="/report" method="post">
                                <div class="form-group">
                                    <label class="col-sm-1 control-label">开关编号</label>
                                    <div class="col-sm-2">
                                        <input id="start" name="equNo" class="form-control">
                                    </div>
                                    <label class="col-sm-1 control-label">设备编号</label>
                                    <div class="col-sm-2">
                                        <input id="end" name="eptNo" class=" form-control">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-1 control-label">绑定状态：</label>
                                    <div class="col-sm-11">
                                        <select placeholder="选择省份..."  style="width: 129px;height: 31px;margin-right: 25px;"  id="sheng">
                                            <option value="-1">全部</option>
                                            <option value="-1">未绑定</option>
                                            <option value="-1">已绑定</option>
                                        </select>

                                        <div class="radio radio-info radio-inline" style="margin-left: 15px;">
                                            <button type="submit" class="btn btn-outline btn-info" style="height: 30px;">
                                                查询
                                            </button>
                                        </div>
                                    </div>
                                </div>

                            </form>
                            <br><br>
                            <table class="table table-striped table-bordered table-hover dataTables-example">
                                <thead>
                                <tr>
                                    <th>智能开关编号</th>
                                    <th>接入时间</th>
                                    <th>绑定户编号</th>
                                    <th>绑定户设备</th>
                                    <th>设备类型</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>

                                </tbody>

                            </table>
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



<!-- ECharts -->
<script src="js/plugins/echarts/echarts-all.js"></script>


<!-- 自定义js -->
<script src="js/content.js?v=1.0.0"></script>


<!-- layerDate plugin javascript -->
<script src="js/plugins/layer/laydate/laydate.js"></script>

<script src="js/area.js"></script>


<script src="js/plugins/jeditable/jquery.jeditable.js"></script>

<!-- Data Tables -->
<script src="js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="js/plugins/dataTables/dataTables.bootstrap.js"></script>

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



</body>

</html>
