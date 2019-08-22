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


</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="col-sm-4">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>年度计划 <small>列表</small></h5>
                    <#if "addmsg??">
                        <p style="color:blue;">${addmsg}</p>
                    </#if>
                </div>
                <div class="ibox-content">
                    <div class="text-left">
                        <a data-toggle="modal"  class="btn btn-primary" href="#modal-form">新增区计划</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>基本 <small>分类，查找</small></h5>
                    </div>
                    <div class="ibox-content">

                        <table class="table table-striped table-bordered table-hover dataTables-example">
                            <thead>
                                <tr>
                                    <th>区</th>
                                    <th>市</th>
                                    <th>省</th>
                                    <th>计划年度</th>
                                    <th>生物质炉具计划量</th>
                                    <th>热风机计划量</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                            <#list annPlanList as annPlan >
                            <tr class="gradeX">
                                <td>${annPlan.anp_area}</td>
                                <td>鹤壁市</td>
                                <td>河南省</td>
                                <td>${annPlan.anp_year}</td>
                                <td>${annPlan.anp_Sept_num}</td>
                                <td>${annPlan.anp_Rept_num}</td>
                                <td class="center">
                                    <a data-toggle="modal"  class="btn btn-info btn-xs" name="yuejihua" annYear="${annPlan.anp_year}" monAreaId="${annPlan.anp_area_id?c}" href="#modal-form2">月计划</a>
                                   &nbsp;&nbsp;&nbsp;
                                    <a data-toggle="modal"  class="btn btn-info btn-xs" name="xiugai" anpId="${annPlan.anp_id}" href="#modal-form1">编辑</a>
                                    &nbsp;&nbsp;&nbsp;
                                    <a data-toggle="modal"  class="btn btn-info btn-xs" name="shanchu" nian="${annPlan.anp_year}" qu="${annPlan.anp_area_id?c}" href="javascript:void(0)">删除</a>
                                </td>
                            </tr>
                            </#list>

                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>区</th>
                                    <th>市</th>
                                    <th>省</th>
                                    <th>计划年度</th>
                                    <th>生物质炉具计划量</th>
                                    <th>热风机计划量</th>
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
                    <div class="ibox-tools">
                        <#--<a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>-->
                        <#--  <a class="close-link" id="guanbi">
                              <i class="fa fa-times"></i>
                          </a>-->
                        <button type="button" class="close" data-dismiss="modal"><span
                                    aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                        </button>
                    </div>
                    <h3>新增区计划</h3>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal m-t" id="commentFormaa" action="/doAddAnnPlan" method="post" >
                        <div align="center">
                            <p id="ams" style="color: red"></p>
                            <input type="hidden" name="ccc" value="0"/>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">省</label>
                            <div class="col-sm-10">
                                <select class="form-control m-b" name="province">
                                    <option >河南省</option>
                                </select>
                            </div>
                        </div>
                        <#--<div class="hr-line-dashed"></div>-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">市</label>
                            <div class="col-sm-10">
                                <select class="form-control m-b" name="city">
                                    <option>鹤壁市</option>
                                </select>
                            </div>
                        </div>
                        <#--<div class="hr-line-dashed"></div>-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">区</label>
                            <div class="col-sm-10">
                                <select class="form-control m-b" name="anp_area_id">
                                    <#list arealist as area >
                                        <option value="${area.areaId?c}">${area.areaName}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <#--<div class="hr-line-dashed"></div>-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">年度</label>
                            <div class="col-sm-10">
                                <select class="form-control m-b" name="anp_year">
                                    <option value="2019">2019</option>
                                    <option value="2020">2020</option>
                                    <option value="2021">2021</option>
                                    <option value="2022">2022</option>
                                    <option value="2023">2023</option>
                                </select>
                            </div>
                        </div>
                        <#--<div class="hr-line-dashed"></div>-->
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color: red">*</span>生物质炉具计划：</label>
                            <div class="col-sm-8">
                                <input name="anp_Sept_num" minlength="2" type="text" class="form-control" pattern="^\+?[1-9][0-9]*$" required="" aria-required="true">
                            </div>
                        </div>
                        <p align="center"  style="color: red" id="prePhones"></p>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color: red">*</span>热风机计划：</label>
                            <div class="col-sm-8">
                                <input name="anp_Rept_num" minlength="2" type="text" class="form-control" pattern="^\+?[1-9][0-9]*$" required="" aria-required="true">
                            </div>
                        </div>

                        <div align="center">
                            <#--<div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">-->
                            <button class="btn btn-primary" type="button" onclick="checkAnnp()">提交</button>
                            <button class="btn btn-primary" type="reset">重置</button>
                            <input type="submit" class="hidden" name="tijiao">
                            <#--    </div>
                            </div>-->
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div id="modal-form1" class="modal fade" aria-hidden="true" >
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">

                    <div class="ibox-tools">
                        <#--<a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>-->
                        <#--  <a class="close-link" id="guanbi">
                              <i class="fa fa-times"></i>
                          </a>-->
                        <button type="button" class="close" data-dismiss="modal"><span
                                    aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                        </button>
                    </div>
                    <h3>更新区计划</h3>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal m-t" id="commentForm" action="/UpdateAnnPlan" method="post">
                        <input type="hidden" name="xanp_id">
                        <input type="hidden" name="oldareaid">
                        <input type="hidden" name="oldyear"/>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">省</label>
                            <div class="col-sm-10">
                                <select class="form-control m-b" name="province"  disabled="disabled">
                                    <option >河南省</option>
                                </select>
                            </div>
                        </div>
                        <#--<div class="hr-line-dashed"></div>-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">市</label>
                            <div class="col-sm-10">
                                <select class="form-control m-b" name="city"  disabled="disabled">
                                    <option>鹤壁市</option>
                                </select>
                            </div>
                        </div>
                        <#--<div class="hr-line-dashed"></div>-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">区</label>
                            <div class="col-sm-10">
                                <input type="hidden" name="xanp_area_id">
                                <select class="form-control m-b" name="xanp_area_id1" disabled="disabled">
                                    <#list arealist as area >
                                        <option value="${area.areaId?c}">${area.areaName}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <#--<div class="hr-line-dashed"></div>-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">年度</label>
                            <div class="col-sm-10">
                                <input type="hidden" name="xanp_year">
                                <select class="form-control m-b" name="xanp_year1" disabled="disabled">
                                    <option value="2019">2019</option>
                                    <option value="2020">2020</option>
                                    <option value="2021">2021</option>
                                    <option value="2022">2022</option>
                                    <option value="2023">2023</option>
                                </select>
                            </div>
                        </div>
                        <#--<div class="hr-line-dashed"></div>-->
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color: red">*</span>生物质炉具计划：</label>
                            <div class="col-sm-8">
                                <input name="xanp_Sept_num" minlength="2" type="text" class="form-control" pattern="^\+?[1-9][0-9]*$" required="" aria-required="true">
                            </div>
                        </div>
                        <p align="center"  style="color: red" id="prePhones"></p>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color: red">*</span>热风机计划：</label>
                            <div class="col-sm-8">
                                <input name="xanp_Rept_num" minlength="2" type="text" class="form-control" pattern="^\+?[1-9][0-9]*$" required="" aria-required="true">
                            </div>
                        </div>

                        <div align="center">
                            <#--<div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">-->
                            <button class="btn btn-primary" type="submit"">提交</button>
                            <button class="btn btn-primary" type="reset">重置</button>
                            <#--    </div>
                            </div>-->
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div id="modal-form2" class="modal fade" aria-hidden="true" align="center" >
        <div align="center" style="padding-left: 28%">
        <div class="col-sm-6" style="width: auto" >
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>月度计划</h5>
                    <div class="ibox-tools">
                        <#--<a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>-->
                      <#--  <a class="close-link" id="guanbi">
                            <i class="fa fa-times"></i>
                        </a>-->
                        <button type="button" class="close" data-dismiss="modal"><span
                                    aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                        </button>
                    </div>
                </div>
                <input type="hidden" ="quxiao" />
                <div class="ibox-content"  style="text-align: center">
                    <form class="form-horizontal m-t" id="commentForm" action="/UpdateMonPlan" method="post">
                        <input type="hidden" name="annYear">
                        <input type="hidden" name="monAreaId">
                        <table class="table table-bordered" style="text-align: center">
                        <thead>
                        <tr  style="text-align: center">
                            <th>#</th>
                            <th>月计划</th>
                            <th>生物质炉具</th>
                            <th>热风机</th>
                        </tr>
                        </thead>
                        <tbody name="yuemain">

                        </tbody>
                    </table>
                        <div align="center">
                            <#--<div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">-->
                            <button class="btn btn-primary" type="submit">提交</button>
                            <button class="btn btn-primary" type="reset">重置</button>
                            <#--    </div>
                            </div>-->
                        </div>
                    </form>
                </div>
            </div>
        </div>
        </div>
    </div>


    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script type="text/javascript">
        $(function(){
            $("#guanbi").click(function(){
                alert("关闭");
                $("#quxiao").click();$("#quxiao").click();
            });
            $("[name ='shanchu']").click(function(){
                if(confirm("确定要取消该年度计划吗?")){
                    var nian =$(this).attr("nian");
                    var qu =$(this).attr("qu");
                    window.location.href="/delAnnPlan?nian="+nian+"&qu="+qu;
                }
            });
            $("[name ='xiugai']").click(function(){
                //alert("dddddd");
                var anpId =$(this).attr("anpId");
                //alert(anpId);
                $.post("/toUpdateAnnPlan",{"anp_id":anpId},
                    function (xiugai) {
                    //alert(1);
                        $("[name='xanp_area_id']").val(xiugai.anp_area_id);
                        $("[name='xanp_year']").val(xiugai.anp_year);
                        $("[name='xanp_area_id1']").val(xiugai.anp_area_id);
                        $("[name='xanp_year1']").val(xiugai.anp_year);
                        $("[name='xanp_Sept_num']").val(xiugai.anp_Sept_num);
                        $("[name='xanp_Rept_num']").val(xiugai.anp_Rept_num);
                        $("[name='xanp_id']").val(xiugai.anp_id);

                        $("[name='oldareaid']").val(xiugai.anp_area_id);
                        $("[name='oldyear']").val(xiugai.anp_year);
                    },"json"
                );
            });

            $("[name ='yuejihua']").click(function(){
                var annYear =$(this).attr("annYear");
                var monAreaId =$(this).attr("monAreaId");
                $("[name='annYear']").val(annYear);
                $("[name='monAreaId']").val(monAreaId);
                $.post("/toUpdateMonPlan",{"anp_year":annYear,"mon_area_id":monAreaId},
                    function (yuejihua) {
                        //alert(yuejihua.length);
                        var str="";
                      for(var i=0;i<yuejihua.length;i++){
                            //alert(yuejihua[i].mon_count);
                          str+=("<tr><input type='hidden' name='mon_id"+(i+1)+"' value='"+yuejihua[i].mon_id+"'>");
                          str+=("<td>"+(i+1)+"</td>");
                          str+="<td>"+annYear+"年"+yuejihua[i].mon_count+"月</td>";
                          str+="<td><input type='text' name='mon_Sept_num"+(i+1)+"' value='"+yuejihua[i].mon_Sept_num+"'>台</td>";
                          str+="<td><input type='text' name='mon_Rept_num"+(i+1)+"' value='"+yuejihua[i].mon_Rept_num+"'>台</td>";
                          str+="</tr>";
                          //alert(str);
                       }
                        $("[name='yuemain']").append(str);
                    },"json"
                );
            });

        })


    </script>
    <script type="text/javascript">
        function checkAnnp() {
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
