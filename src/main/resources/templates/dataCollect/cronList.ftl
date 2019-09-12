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
                            <form class="form-horizontal m-t" action="/setPinCi" method="post">

                                <div class="form-group">
                                    <label class="col-sm-1 control-label">采集频次：</label>
                                    <div class="col-sm-11">
                                        <select   style="width: 129px;height: 31px;margin-right: 25px;"  id="pinci" name="pinci">
                                            <#list crons?keys as key>
                                                <option value="${key}">${key}分钟</option>
                                            </#list>
                                        </select>

                                        <div class="radio radio-info radio-inline" style="margin-left: 15px;">
                                            <button type="submit" class="btn btn-outline btn-info" style="height: 30px;text-align: center;">
                                                保存
                                            </button>
                                        </div>
                                    </div>
                                </div>

                            </form>
                            <br><br>
                            <table class="table table-striped table-bordered table-hover dataTables-example">
                                <thead>
                                <tr>
                                    <th>操作时间</th>
                                    <th>设置前频次</th>
                                    <th>设置后频次</th>
                                    <th>操作账号</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <#list rateupdalogs as r>
                                        <tr>
                                            <td>${r.uplogOperaDate?string('yyyy-MM-dd hh:mm:ss')}</td>
                                            <td>

                                                <#if r.uplogBefore == null>
                                                    无
                                                    <#else >
                                                        ${r.uplogBefore}分钟
                                                </#if>
                                            </td>
                                            <td>${r.uplogAfter}分钟</td>
                                            <td>${r.uplogPreId}</td>
                                        </tr>
                                    </#list>
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
