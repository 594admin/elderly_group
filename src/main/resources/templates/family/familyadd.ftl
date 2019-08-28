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
        <div align="center"><span style="color: red"><#if addmsg??><h3>${addmsg}</h3></#if></span></div>
        <div class="ibox-title">
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
            <h5>户基础信息</h5>
            <form class="form-horizontal m-t" id="signupForm" action="/doaddfamilyfirst" method="post">

                <div class="form-group">
                   <label class="col-sm-3 control-label"><span style="color: red">*</span>区域：</label>
                    <div class="col-sm-8">
                        &nbsp;
                        <select class="chosen-select" style="width:80px;height: 34px">
                            <option value="370882" hassubinfo="true">河南省</option>
                        </select>
                        &nbsp;
                        <select class="chosen-select" style="width:80px;height: 34px">
                            <option value="386709" hassubinfo="true">鹤壁市</option>
                        </select>
                        &nbsp;
                        <select required class="chosen-select" style="width:80px;height: 34px" id="qu" >
                            <option value="" hassubinfo="true" >--请选择--</option>
                            <#list areas as a>
                                <option value="${a.areaId?c}" name="qu" quname="${a.areaId?c}" hassubinfo="true">${a.areaName}</option>
                            </#list>
                        </select>
                        &nbsp;
                        <select  id='jiedao'class="chosen-select" style="width:80px;height: 34px" required>
                            <option value="" hassubinfo="true">--请选择--</option>

                        </select>
                        &nbsp;
                        <select id='juweihui'class="chosen-select" name="fly_area_id" style="width:80px;height: 34px" required>
                            <option value="" hassubinfo="true">--请选择--</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                   <label class="col-sm-3 control-label"><span style="color: red">*</span>住址：</label>
                    <div class="col-sm-8">
                        <input required id="fly_address" name="fly_address" class="form-control" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">门牌号：</label>
                    <div class="col-sm-8">
                        <input id="fly_doorNum" name="fly_doorNum" class="form-control" type="text">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label"><span style="color: red">*</span>户主姓名：</label>
                    <div class="col-sm-8">
                        <input id="fly_name" name="fly_name" class="form-control" type="text" required class="valid">
                    </div>
                </div>
                <p align="center"  style="color: red" id="preFlyName"></p>
                <div class="form-group">
                   <label class="col-sm-3 control-label"><span style="color: red">*</span>身份证号：</label>
                    <div class="col-sm-8">
                        <input id="fly_IDcard" placeholder="18位身份证号"  title="身份证号码格式错误" pattern="/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;" name="fly_IDcard" required class="form-control" type="text" aria-required="true" aria-invalid="true" class="error">
                    </div>
                </div>


                <div class="form-group" id="data_1">
                  <label class="col-sm-3 control-label"><span style="color: red">*</span>出生日期：</label>
                    <div class="input-group date">
                        &nbsp;<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                        <input type="text" id="fly_birthday" name="fly_birthday" class="form-control" style="width: auto">
                    </div>
                </div>

                <div class="form-group">
                     <label class="col-sm-3 control-label"><span style="color: red">*</span>联系电话：</label>
                    <div class="col-sm-8">
                        <input id="fly_phone" name="fly_phone"  title="手机号码格式错误" pattern="(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)" class="form-control" required type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"><span style="color: red">*</span>建筑面积：</label>
                    <div class="col-sm-8">
                        <input required id="confirm_password" placeholder="平方米" name="fly_buldArea" class="form-control" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"><span style="color: red">*</span>采暖面积：</label>
                    <div class="col-sm-8">
                        <input required id="confirm_password" placeholder="平方米" name="fly_heatArea" class="form-control" type="text">
                    </div>
                </div>
                <div class="form-group">
                        <label class="col-sm-3 control-label">是否贫困：</label>
                    <div class="radio radio-info radio-inline">
                        <input type="radio" id="inlineRadio1" value="0" name="fly_ispoor" checked="">
                        <label for="inlineRadio1"> 否 </label>
                    </div>
                    <div class="radio radio-inline">
                        <input type="radio" id="inlineRadio2" value="1" name="fly_ispoor">
                        <label for="inlineRadio2"> 是 </label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"><span style="color: red">*</span>工程小组：</label>
                    <div class="col-sm-8">
                        &nbsp;
                        <select required class="chosen-select" style="width:160px;height: 34px" name="fly_tem_id"">
                            <option value="" hassubinfo="true">--请选择小组--</option>
                            <#list teams as t>
                                <option value="${t.temId}" hassubinfo="true">${t.temName}</option>
                            </#list>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">备注：</label>
                    <div class="col-sm-8">
                        <input id="email" name="fly_notes" class="form-control" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-3">
                        <button class="btn btn-primary" type="submit"><保存,下一步></button>
                        <a href="/initfamilylist"> <button class="btn btn-primary" type="button"><返回列表></button></a>
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
        $("#jiedao").change(function() {
            $("#juweihui").empty()
            $("#juweihui").append("<option hassubinfo='true'>--请选择--</option>")
            var area_id= this.options[this.selectedIndex].value
            if(area_id!=""){
                $.ajax({
                    type:"post",
                    url:"/ajax",
                    data:{"area_id":area_id},
                    success:function(returnData){
                        //把获取的数据通过dom方式添加到下拉选择框中
                        var province = $("#juweihui").first();
                        $.each(returnData,function(index,a){
                            province.append("<option value='"+a.areaId+"'>"+a.areaName+"</option>");
                        });

                    }
                })
            }
        })
        $("input[name=fly_name]").blur(function () {
            $("#preFlyName").html("")
            var fly_name=this.value
            $.ajax({
                type:"post",
                url:"/ajax",
                data:{"fly_name":fly_name},
                success:function(returnData){
                    if(returnData){
                        $("#preFlyName").append("该用户已添加")
                        $("[name=fly_name]").val("")
                    }
                }
            })

        })
    </script>

<script>
    $("#qu").change(function() {
        $("#jiedao").empty()
        $("#juweihui").empty()
        $("#jiedao").append("<option hassubinfo='true'>--请选择--</option>")
        $("#juweihui").append("<option hassubinfo='true'>--请选择--</option>")
        var area_id= this.options[this.selectedIndex].value
        if(area_id!=""){
            $.ajax({
                type:"post",
                url:"/ajax",
                data:{"area_id":area_id},
                success:function(returnData){
                    //把获取的数据通过dom方式添加到下拉选择框中
                    var province = $("#jiedao").first();
                    $.each(returnData,function(index,a){
                        province.append("<option value='"+a.areaId+"'>"+a.areaName+"</option>");
                    });

                }
            })
        }
    })
</script>

<script>
    $("#fly_IDcard").blur(function () {

            var birthdayno,birthdaytemp
            var fly_birthday=this.value
            if(fly_birthday.length==18){
                birthdayno=fly_birthday.substring(6,14)
            }else if(fly_birthday.length==15){
                birthdaytemp=fly_birthday.substring(6,12)
                birthdayno="19"+birthdaytemp
            }
            var birthday=birthdayno.substring(0,4)+"-"+birthdayno.substring(4,6)+"-"+birthdayno.substring(6,8)

           $("#fly_birthday").val(birthday)
    })

</script>
</body>

</html>
