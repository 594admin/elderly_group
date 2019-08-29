<#--noinspection ALL-->
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
            <h3>设备采购信息</h3>
        </div>
        <div class="ibox-content">
            <form action="/doAddPurchase" name="caigou" method="post" onsubmit="return check()" class="form-horizontal m-t" id="signupForm">
                <table id="caigou"></table>
                <table id="price"></table>
                <div class="form-group">
                    <div class="form-group" style="margin-left: 80px">
                        <div class="col-sm-12">
                            &nbsp;
                            <select class="chosen-select" style="width:120px;height: 34px" id="leixing" name="ept_type">
                                <option value="" hassubinfo="true">请选择产品类型</option>
                                <option value="热风机" hassubinfo="true">热风机</option>
                                <option value="生物质炉具" hassubinfo="true">生物质炉具</option>
                                <option value="水机" hassubinfo="true">水机</option>
                            </select>
                            &nbsp;
                            <select class="chosen-select" style="width:120px;height: 34px" id="changjia" name="ept_facty">
                                <option value="" hassubinfo="true">请选择厂家</option>
                                <option value="长虹" hassubinfo="true">长虹</option>
                                <option value="格力" hassubinfo="true">格力</option>
                                <option value="美的" hassubinfo="true">美的</option>
                                <option value="中能北方" hassubinfo="true">中能北方</option>
                            </select>
                            &nbsp;
                            <select class="chosen-select" style="width:120px;height: 34px" name="ept_model" id="xinghao">
                                <option value="" hassubinfo="true">请选择型号</option>
                                <option value="DZW40" hassubinfo="true">DZW40</option>
                                <option value="DZW39" hassubinfo="true">DZW39</option>
                            </select>
                            &nbsp;
                        </div>
                    </div>
                    <div class="ibox-content">
                        <div class="">
                            <a onclick="fnClickAddRow();" href="javascript:void(0);" class="btn btn-primary ">添加所选设备</a>
                        </div>
                        <table class="table table-striped table-bordered table-hover " id="editable">
                            <thead>
                            <tr>
                                <th>设备Id</th>
                                <th>类型</th>
                                <th>厂家</th>
                                <th>型号</th>
                                <th>单价</th>
                                <th>数量</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                    <h3>付款及协议信息</h3>
                    <div class="ibox-content">
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color: red">*</span>付款方式：</label>
                            <div class="radio radio-info radio-inline">
                                <input required type="radio" id="inlineRadio1" value="0" name="pursePayMethod" >
                                <label for="inlineRadio1"> 现金 </label>
                            </div>
                            <div class="radio radio-inline">
                                <input required type="radio" id="inlineRadio2" value="1" name="pursePayMethod">
                                <label for="inlineRadio2"> 转账 </label>
                            </div>
                            <div class="radio radio-inline">
                                <input  required type="radio" id="inlineRadio2" value="2" name="pursePayMethod">
                                <label for="inlineRadio2"> 支付宝 </label>
                            </div>
                        </div>
                        <div class="form-group" id="data_1">
                            <label class="col-sm-3 control-label"><span style="color: red">*</span>付款时间：</label>
                            <div class="input-group date">
                                &nbsp;<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                <input required type="text" name="pursePayDate" class="form-control" style="width: auto">


                            </div>
                            <input type="hidden" name="purseFlyId" value="${fly_id}">
                            <input type="hidden" name="purseNum" value="${purse_num}">
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color: red">*</span>收据编号：</label>
                            <div class="col-sm-8">
                                <input id="username" name="purseReceipt" required class="form-control" type="text" aria-required="true" aria-invalid="true" class="error">

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><span style="color: red">*</span>安装协议：</label>
                            <div class="col-sm-8">
                                <input id="username" name="purseInstPtl" required class="form-control" type="text" aria-required="true" aria-invalid="true" class="error">
                            </div>
                        </div>
                    </div>
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-3">
                        <button class="btn btn-primary" type="submit" id="tijiao"><保存，下一步></button>
                        <a href="/initfamilylist"> <button class="btn btn-primary"  type="button"><返回列表></button></a>
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
    </script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    <!--统计代码，可删除-->
    <script>
        $("#xinghao,#leixing,#changjia").change(function() {
            $("#price").empty()
            var ept_type=$("select[name=ept_type]").val()
            var ept_facty=$("select[name=ept_facty]").val()
            var ept_model=$("select[name=ept_model]").val()
            $.ajax({
                type:"post",
                url:"/ajax",
                data:{"ept_type":ept_type,"ept_facty":ept_facty,"ept_model":ept_model},
                success:function(returnData){
                    $("#price").append("<tr><td><input type='hidden' name='ept_price' value='"+returnData.eptPrice+"'/></td></tr>")
                    $("#price").append("<tr><td><input type='hidden' name='ept_id' value='"+returnData.eptId+"'/></td></tr>")
                }
            })
        })
    </script>

    <script>
    function fnClickAddRow() {

        var ept_type=$("select[name=ept_type]").val()
        var ept_facty=$("select[name=ept_facty]").val()
        var ept_model=$("select[name=ept_model]").val()
        var table = $('#editable').dataTable
        var ept_price=$("input[name=ept_price]").val()
        var ept_id=$("input[name=ept_id]").val()
       if(ept_price!=null){
        $('#editable').dataTable().fnAddData([

            '<input style="border: 0;background-color: #f5f5f5" disabled type="text" name="orEptId" value="'+ept_id+'"/>',
            '<input  style="border: 0;background-color: #f5f5f5" disabled type="text" name="ept_type" value="'+ept_type+'"/>',
            '<input  style="border: 0;background-color: #f5f5f5" disabled type="text" name="ept_facty" value="'+ept_facty+'"/>',
            '<input  style="border: 0;background-color: #f5f5f5" disabled type="text" name="ept_model" value="'+ept_model+'"/>',
            '<input  style="border: 0;background-color: #f5f5f5" disabled type="text" name="orEptPrice" value="'+ept_price+'"/>',
            '<input  style="border: 0.5;background-color: #f5f5f5" type="number" name="orEptNum"/>',
            '<a  data-toggle="modal" class="btn btn-info btn-xs" onclick="shanchu($(this).parents(\'tr\').index())" href="javascript:void(0)">删除</a>']);
       }
    }

        function shanchu(rows){
            if(confirm('确定要删除该设备吗?')){
            $('#editable').dataTable().fnDeleteRow(rows)
            }else{
                return false
            }
        }
</script>

<script>
   function check() {

       if($("input[name=orEptId]").size()==0){
           alert("请选择设备")
           return false;
       }
   }



</script>





</body>

</html>
