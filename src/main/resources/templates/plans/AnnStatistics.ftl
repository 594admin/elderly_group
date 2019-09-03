<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>计划任务分配</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- Data Tables -->
    <link href="css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">


</head>

<body class="gray-bg">
    <div  style="margin: 1% 2%;padding-right: 2%;height: 20%">
        <div  style="width: 100%">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>区进度完成情况</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <form role="form" class="form-inline">
                        <div class="checkbox m-l m-r-xs">
                            <label class="i-checks">
                                <#--<div class="icheckbox_square-green" style="position: relative;">
                                    <ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins>
                                </div>-->
                                统计区域
                            </label>
                        </div>
                        <div class="form-group">
                            <#--<label  class="sr-only">省</label>-->
                            <div class="col-sm-10">
                                <select class="form-control " name="province" >
                                    <option value="河南省" >河南省</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group" >
                            <#--<label  class="sr-only">市</label>-->
                            <div class="col-sm-10">
                                <select class="form-control" name="city" >
                                    <option value="鹤壁市" >鹤壁市</option>
                                </select>
                            </div>
                        </div>

                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <div class="checkbox m-l m-r-xs">
                            <label class="i-checks">
                                <#--<div class="icheckbox_square-green" style="position: relative;">
                                    <ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins>
                                </div>-->
                                统计年度
                            </label>
                        </div>

                        <div class="form-group">
                            <#--<label  class="sr-only">年度</label>-->
                            <div class="col-sm-10" >
                                <select class="form-control " name="anp_year">
                                    <option value="2019">2019</option>
                                    <option value="2020">2020</option>
                                    <option value="2021">2021</option>
                                    <option value="2022">2022</option>
                                    <option value="2023">2023</option>
                                </select>
                            </div>
                        </div>

                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <div class="checkbox m-l m-r-xs">
                            <label class="i-checks">
                                <#--<div class="icheckbox_square-green" style="position: relative;">
                                    <input type="button" style="position: absolute; opacity: 0;" value="统计">
                                    <ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins>
                                </div>-->
                                <input type="button" value="统计" name="tongji" style="font-family: 楷体 ;"/>
                                <input type="button" value="查询"  name="cha" style="display: none"/>
                            </label>
                        </div>
                        <#--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button class="btn btn-white" type="submit">统计</button>-->
                    </form>
                </div>
            </div>
        </div>

    </div>
    <#--<div class="row  border-bottom white-bg dashboard-header">
        <div class="col-sm-12">
            <p>ECharts开源来自百度商业前端数据可视化团队，基于html5 Canvas，是一个纯Javascript图表库，提供直观，生动，可交互，可个性化定制的数据可视化图表。创新的拖拽重计算、数据视图、值域漫游等特性大大增强了用户体验，赋予了用户对数据进行挖掘、整合的能力。 <a href="http://echarts.baidu.com/doc/about.html" target="_blank">了解更多</a>
            </p>
            <p>ECharts官网：<a href="http://echarts.baidu.com/" target="_blank">http://echarts.baidu.com/</a>
            </p>

        </div>

    </div>-->
    <div class="wrapper wrapper-content animated fadeInRight" style="width: 100%;padding: 2.1%;height: 100%;margin-bottom: 10%" >
        <div class="row" style="width: 100%">
            <div class="col-sm-6" style="width: 100%;">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>折线图</h5>
                        <div class="ibox-tools">

                        </div>
                    </div>
                    <div class="ibox-content">
                        <div class="echarts" id="echarts-line-chart"></div>
                    </div>
                </div>
            </div>

        </div>

    </div>

    <!-- echars的数据-->
   <#-- <script src="js/demo/echarts-demo.js"></script>-->
    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script type="text/javascript">
        $(function () {
             $("[name='tongji']") .click(function () {
                 var tongjinian=$("[name='anp_year']").val();
                 //alert(tongjinian);
                 $.post("/checkPlan",{"cann_year":tongjinian},
                     function (shuzi) {
                        //alert(shuzi);
                        if(shuzi=="-1"){
                            alert("该年度还未设置年度计划！");
                        }else if(shuzi=="0"){
                            alert("各区还未设置月度计划！");
                        }else{
                            $("[name='cha']").click();
                        }
                    },"json"
                 );
             });

            $("[name='cha']").click(function () {
                var tongjinian=$("[name='anp_year']").val();
                $.post("/ecAnnMonPlans",{"cann_year":tongjinian},
                    function (infomap) {
                        var datas=new Array();
                        var myseries=new Array();
                        for(var key in infomap) {
                            datas.push(key);
                        }
                        var lineChart = echarts.init(document.getElementById("echarts-line-chart"));
                        var seriess=[];
                        for(var key in infomap) {
                            seriess.push({
                                name:key,
                                type:'line',
                                data:infomap[key],
                                markPoint : {
                                    data : [
                                        {type : 'max', name: '最大值'},
                                        {type : 'min', name: '最小值'}
                                    ]
                                },
                                markLine : {
                                    data : [
                                        {type : 'average', name: '平均值'}
                                    ]
                                }
                            });
                        }
                        var lineoption = {
                            title : {
                                text: '各区月度计划进度'
                            },
                            tooltip : {
                                trigger: 'axis'
                            },
                            legend: {
                                data:datas
                            },
                            grid:{
                                x:40,
                                x2:40,
                                y2:24
                            },
                            calculable : true,
                            xAxis : [
                                {
                                    type : 'category',
                                    boundaryGap : false,
                                    data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
                                }
                            ],
                            yAxis : [
                                {
                                    type : 'value',
                                    axisLabel : {
                                        formatter: '{value} '
                                    }
                                }
                            ],
                            series :seriess
                        };
                        lineChart.setOption(lineoption);
                        $(window).resize(lineChart.resize);
                    },"json"
                );
            });
        });
    </script>

    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>
    <!-- ECharts  -->
    <script src="js/plugins/echarts/echarts-all.js"></script>
    <script type="text/javascript">
    </script>
    <script type="text/javascript">
        $(function(){
            var lineChart = echarts.init(document.getElementById("echarts-line-chart"));
            var lineoption = {
                title : {
                    text: '某年各区月度计划进度'
                },
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['鹤壁市','淇县','浚县']
                },
                grid:{
                    x:40,
                    x2:40,
                    y2:24
                },
                calculable : true,
                xAxis : [
                    {
                        type : 'category',
                        boundaryGap : false,
                        data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
                    }
                ],
                yAxis : [
                    {
                        type : 'value',
                        axisLabel : {
                            formatter: '{value} '
                        }
                    }
                ],
                series : [
                    {
                        name:'鹤壁市',
                        type:'line',
                        data:[11, 11, 15, 13, 12, 13, 10, 11, 25, 13, 12, 13],
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        },
                        markLine : {
                            data : [
                                {type : 'average', name: '平均值'}
                            ]
                        }
                    },
                    {
                        name:'淇县',
                        type:'line',
                        data:[1, 2, 2, 5, 3, 2, 0, 2, 2, 5, 3, 2],
                        markPoint : {
                            data : [
                                {name : '周最低', value : -2, xAxis: 1, yAxis: -1.5}
                            ]
                        },
                        markLine : {
                            data : [
                                {type : 'average', name : '平均值'}
                            ]
                        }
                    }
                    ,
                    {
                        name:'浚县',
                        type:'line',
                        data:[1, 6, 8, 5, 15, 2, 4, 8, 9, 14, 3, 12],
                        markPoint : {
                            data : [
                                {name : '周最低', value : -2, xAxis: 1, yAxis: -1.5}
                            ]
                        },
                        markLine : {
                            data : [
                                {type : 'average', name : '平均值'}
                            ]
                        }
                    }
                ]
            };
            lineChart.setOption(lineoption);
            $(window).resize(lineChart.resize);
        })

        /*function checkAnnp() {
            var anp_area_id=$("[name='anp_area_id']").val();
            var anp_year=$("[name='anp_year']").val();
            //alert(anp_area_id+"--"+anp_year);
            $.post("/checkIsExistsAnnPlan",{"anp_area_id":anp_area_id,"anp_year":anp_year},
                function(num){
                    if(num == "0"){
                        $("#ams").html("");
                        $("[name='tijiao']").click();
                        //$("form #commentFormaa").submit();
                    }else{
                        $("#ams").html("该计划已存在");
                    }
                },"json"
            );
        }*/


    </script>

    <script src="js/plugins/jeditable/jquery.jeditable.js"></script>

    <!-- Data Tables -->
    <script src="js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="js/plugins/dataTables/dataTables.bootstrap.js"></script>

    <!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>


    <!-- Page-Level Scripts -->
   <#-- <script>
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
    </script>-->

    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    <!--统计代码，可删除-->

</body>

</html>
