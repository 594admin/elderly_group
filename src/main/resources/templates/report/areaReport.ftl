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
<style>
    .echarts{height: 400px;}
</style>

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
                                    <label class="col-sm-1 control-label">开始日期：</label>
                                    <div class="col-sm-2">
                                        <input id="start" name="start" class="laydate-icon form-control layer-date">
                                    </div>
                                    <label class="col-sm-1 control-label">结束日期：</label>
                                    <div class="col-sm-2">
                                        <input id="end" name="end" class="laydate-icon form-control layer-date">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-1 control-label">统计区域：</label>
                                    <div class="col-sm-11">
                                        <select placeholder="选择省份..."  style="width: 129px;height: 31px;margin-right: 25px;"  id="sheng">
                                            <option value="-1">请选择省份</option>
                                            <#list areas as a>
                                                <option value="${a.areaId?c}">${a.areaName}</option>
                                            </#list>
                                        </select>

                                        <select placeholder="请选择..."  style="width: 129px;height: 31px;margin-right: 25px;"  id="shi">
                                            <option value="-1">请选择</option>
                                        </select name=>

                                        <select placeholder="请选择..."  style="width: 129px;height: 31px;margin-right: 25px;"  id="qv">
                                            <option value="-1">请选择</option>

                                        </select>

                                        <select placeholder="请选择..."  style="width: 129px;height: 31px;margin-right: 25px;"  id="jie">
                                            <option value="-1">请选择</option>

                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-1 control-label">统计范围：</label>
                                    <div class="radio radio-info radio-inline" style="margin-left: 15px;">
                                        <input type="radio"  value="qv" name="area">
                                        <label for="inlineRadio1">区县</label>
                                    </div>
                                    <div class="radio radio-info radio-inline" style="margin-left: 15px;">
                                        <input type="radio"  value="jie" name="area" >
                                        <label for="inlineRadio1"> 乡镇/街道 </label>
                                    </div>
                                    <div class="radio radio-info radio-inline" style="margin-left: 15px;">
                                        <input type="radio"  value="cun" name="area" >
                                        <label for="inlineRadio1"> 村 </label>
                                    </div>

                                    <div class="radio radio-info radio-inline" style="margin-left: 15px;">
                                        <button type="submit" class="btn btn-outline btn-info" style="height: 30px;">
                                            统计
                                        </button>
                                    </div>

                                </div>
                                <input type="hidden" name="areaType">
                                <input type="hidden" name="areaId" id="areaId">

                            </form>
                            <br><br>

                            <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
                            <div class="echarts" id="echarts-pie-chart" align="center"></div>

                            <br>
                            <table class="table table-striped table-bordered table-hover dataTables-example">
                                <thead>
                                <tr>
                                    <th>区县</th>
                                    <th>安装户数</th>
                                    <th>安装台数</th>
                                    <th>热风机户数</th>
                                    <th>热风机台数</th>
                                    <th>生物质炉具户数</th>
                                    <th>生物质炉具台数</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <#list areaReports as a>
                                        <tr>
                                            <td>${a.area}</td>
                                            <td>${a.hCount}</td>
                                            <td>${a.tCount}</td>
                                            <td>${a.rhCount}</td>
                                            <td>${a.rtCount}</td>
                                            <td>${a.shCount}</td>
                                            <td>${a.stCount}</td>
                                        </tr>
                                    </#list>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th>总计</th>
                                        <th>${tongji.hCount}</th>
                                        <th>${tongji.tCount}</th>
                                        <th>${tongji.rhCount}</th>
                                        <th>${tongji.rtCount}</th>
                                        <th>${tongji.shCount}</th>
                                        <th>${tongji.stCount}</th>
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
    //外部js调用
    laydate({
        elem: '#start', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        elem: '#end',
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });

    //日期范围限制
    var start = {
        elem: '#start',
        format: 'YYYY-MM-DD',
        //min: laydate.now(), //设定最小日期为当前日期
        max: '2099-06-16 23:59:59', //最大日期
        istime: true,
        istoday: false,
        choose: function (datas) {
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };
    var end = {
        elem: '#end',
        format: 'YYYY/MM/DD hh:mm:ss',
        min: laydate.now(),
        max: '2099-06-16 23:59:59',
        istime: true,
        istoday: false,
        choose: function (datas) {
            start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };
    laydate(start);
    laydate(end);

    $(document).ready(function () {



        $("[name='area']").click(function () {
            var areaType = $("[name='area']:checked").val();
            $("[name='areaType']").val(areaType);
            if (areaType == "qv"){
                $("#areaId").val($("#shi").val());
            } else if (areaType == "jie") {
                $("#areaId").val($("#qv").val());
            } else if (areaType == "cun"){
                $("#areaId").val($("#jie").val());
            }
        });

        [
            {value:335, name:'祁县'},
            {value:310, name:'淇滨区'},
            {value:234, name:'市辖区'},
            {value:135, name:'赫山区'},
            {value:1548, name:'山城区'}
        ]

        var obj = eval('${jsondata}');
        var series1 = new Array();
        var datas = new Array();
        for (var i = 0; i < obj.length;i++){
            datas[i] = obj[i].name
            series1[i] = obj[i]
        }


        var pieChart = echarts.init(document.getElementById("echarts-pie-chart"));
        var pieoption = {
            title : {
                text: '鹤壁市清洁能源统计',
                subtext: '统计视图',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient : 'vertical',
                x : 'left',
                data: datas
            },
            calculable : true,
            series : [
                {
                    name:'统计来源',
                    type:'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    cursor: 'pointer',
                    data:series1
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
</script>

<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<!--统计代码，可删除-->

</body>

</html>
