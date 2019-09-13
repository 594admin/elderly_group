<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>工程统计</title>

    <!-- Data Tables -->
    <link href="css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
    <link rel="shortcut icon" href="favicon.ico">
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <link rel="stylesheet" href="/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css">
    <style type="text/css">
        #start {
            background-color: white;
        }

        #end {
            background-color: white;
        }
    </style>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeIn">
    <div class="row">
        <div class="col-sm-12">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-content">
                            <form class="form-horizontal m-t" action="/getTeamReport" method="post">
                                <div class="form-group">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label"
                                               style="height: 36px;width: 120px;padding-right: 0;padding-top: 9px;">开始日期：</label>
                                        <div class="col-sm-2">
                                            <input readonly class="laydate-icon form-control layer-date" id="start"
                                                   name="start">
                                        </div>
                                        <label class="col-sm-2 control-label"
                                               style="width: 100px;height: 36px;padding-right: 0;padding-top: 9px;">结束日期：</label>
                                        <div class="col-sm-2">
                                            <input readonly class="laydate-icon form-control layer-date" id="end"
                                                   name="end">
                                        </div>
                                        <div class="radio radio-info radio-inline"
                                             style="margin-left: 15px;padding-top: 0.5px;">
                                            <button type="submit" class="btn btn-outline btn-info"
                                                    style="width: 120px;height: 35.5px;margin-bottom: 0;">
                                                统计
                                            </button>
                                        </div>
                                    </div>

                                </div>
                            </form>
                            <br>
                            <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="echarts" id="echarts-pie-chart" align="center"></div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="ibox float-e-margins">
                                        <div class="ibox-content" style="border-style: none">
                                            <table class="table table-bordered" id="ReportTable">
                                                <thead>
                                                <tr>
                                                    <th>小组名称</th>
                                                    <th>组长</th>
                                                    <th>登记量</th>
                                                    <th>缴费量</th>
                                                    <th>出库量</th>
                                                    <th>安装量</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <#list t as o>
                                                    <tr>
                                                        <td>${o.teamName}</td>
                                                        <td>${o.leaderName}</td>
                                                        <td>${o.recordCount}</td>
                                                        <td>${o.payCount}</td>
                                                        <td>${o.outCount}</td>
                                                        <td>${o.installCount}</td>
                                                    </tr>
                                                </#list>
                                                </tbody>
                                                <tfoot>
                                                <tr class="count">

                                                </tr>
                                                </tfoot>
                                            </table>

                                        </div>
                                    </div>
                                </div>
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

    var start = {
        elem: '#start', //选择ID为START的input
        format: 'YYYY-MM-DD 00:00:00', //自动生成的时间格式
        min: '2000-01-01', //设定最小日期为当前日期
        max: laydate.now(), //最大日期
        istime: false, //必须填入时间
        istoday: false,  //是否是当天
        start: laydate.now(0, "YYYY-MM-DD"),  //设置开始时间为当前时间
        choose: function (datas) {
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };
    var end = {
        elem: '#end',
        format: 'YYYY-MM-DD 23:59:59',
        min: laydate.now(),
        max: laydate.now(),
        istime: false,
        istoday: false,
        start: laydate.now(0, "YYYY-MM-DD"),
        choose: function (datas) {
            start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };
    laydate(start);
    laydate(end);

    $(document).ready(function () {

        var table = document.getElementById("ReportTable");//获取table对象
        var rows = table.rows;//获取行对象
        var cells = table.cells;//获取列对象
        var colums = table.rows[0].cells.length;//获取列数
        $(".count").empty();//每次加载时清空最后一列，防止二次加载数据时出现多行合计
        $(".count").append("<th>合计</th><th>—</th>");
        //这里从列开始遍历，得到的就是每一列的数据
        //如果从行开始遍历，得到的就是每行的数据
        for (var j = 2; j < colums; j++) {
            var sum = 0;
            for (var i = 1; i < rows.length - 1; i++) {//从i=1第二行开始去掉表头，rows.length-1结束，去掉合计行
                var a = parseInt(rows[i].cells[j].innerHTML.trim());//获取每一列的值
                sum = sum + a; //计算
            }
            $(".count").append("<th>" + sum + "</th>");//给最后一行添加计算结果列
        }


        var obj = eval('${jd}');
        var series1 = new Array();
        var datas = new Array();
        for (var i = 0; i < obj.length;i++){
            datas[i] = obj[i].name
            series1[i] = obj[i]
        }

        var pieChart = echarts.init(document.getElementById("echarts-pie-chart"));
        var pieoption = {
            title: {
                text: '工程小组完成占比',
                subtext: '${start}~${end}',
                x: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data: datas
            },
            calculable: true,
            series: [
                {
                    name: '完成占比',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    cursor: 'pointer',
                    data: series1
                }
            ]
        };
        pieChart.setOption(pieoption);
        $(window).resize(pieChart.resize);

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