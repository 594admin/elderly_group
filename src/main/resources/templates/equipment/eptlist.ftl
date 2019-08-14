<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - 数据表格</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">

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
                    <h5>系统管理
                        <small>设备管理</small>
                    </h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="familylist.ftl#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#">选项1</a>
                            </li>
                            <li><a href="#">选项2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <a href="#" class="btn btn-primary">新增设备</a>
                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>设备型号</th>
                            <th>类型</th>
                            <th>厂商</th>
                            <th>单价(元)</th>
                            <th>总库存(台)</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                            <#list elist as ept>
                            <tr class="gradeX">
                                <input type="hidden" value="${ept.eptId}" id="eptid">
                                <td>${ept.eptModel}</td>
                                <td>${ept.eptType}</td>
                                <td>${ept.eptFacty}</td>
                                <td>${ept.eptPrice}</td>
                                <td>${ept.eptStock}</td>
                                <td>
                                    <a href="#modal-form" data-toggle="modal" id="stockMagr"
                                       onclick="stockMgr(${ept.eptId}, ${ept.eptStock});">库存管理</a>
                                </td>
                            </tr>
                            </#list>
                        </tbody>
                        <tfoot>
                        <tr>
                            <th>设备型号</th>
                            <th>类型</th>
                            <th>厂商</th>
                            <th>单价(元)</th>
                            <th>总库存(台)</th>
                            <th>操作</th>
                        </tr>
                        </tfoot>
                    </table>

                </div>
            </div>
        </div>
    </div>

    <div id="modal-form" class="modal fade" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins" style="width: 289px;">
                        <div class="ibox-title">
                            <h5>库存管理</h5>
                        </div>
                        <div class="ibox-content">
                            <form id="upform" action="/upstock" method="post">
                                <input type="hidden" name="eptId">
                                <input type="hidden" name="eptStock">
                                <div>
                                    <span><b>操作: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></span>
                                    <div class="radio radio-info radio-inline">
                                        <input type="radio" id="inlineRadio1" value="1" name="libType"
                                               checked="">
                                        <label for="inlineRadio1"> 出库 </label>
                                    </div>
                                    <div class="radio radio-inline">
                                        <input type="radio" id="inlineRadio2" value="2" name="libType">
                                        <label for="inlineRadio2"> 入库 </label>
                                    </div>
                                </div>
                                <br>
                                <div>
                                    <span><b>数量: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></span>
                                    <div class="m-r-md inline" style="position: absolute; top: 90px;">
                                        <input type="text" value="0" class="dial m-r-sm" data-fgColor="#1AB394"
                                               data-width="40" data-height="40" name="libNum"/>
                                        <span id="infos" class="help-block m-b-none"></span>
                                    </div>
                                </div>
                                <br>
                                <div>
                                    <button id="cloze" onclick="cloze();" class="btn btn-sm btn-primary pull-right m-t-n-xs" type="button"
                                            style="margin-left: 30px;">
                                        <strong>关闭</strong></button>

                                    <button id="sub" onclick="sub();" class="btn btn-sm btn-primary pull-right m-t-n-xs" type="submit">
                                        <strong>保存</strong></button>
                                </div>
                                <br>
                            </form>
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
<script>
    function stockMgr(eptid, eptstock) {
        $("input[name='eptId']").val(eptid)
        $("input[name='eptStock']").val(eptstock)
    }

    function cloze() {
        $("#cloze").attr("display", "none")
    }

    function sub() {
        $("#upform").submit()
    }
</script>

<!-- Chosen -->
<script src="js/plugins/chosen/chosen.jquery.js"></script>
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
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<!--统计代码，可删除-->

</body>

</html>
