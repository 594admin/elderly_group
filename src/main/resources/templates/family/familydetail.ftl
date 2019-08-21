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
<style type="text/css">
    body {
        background: #efd;
    }
    section {
        width: 900px;
        /*margin: 10px auto;*/
    }
    article {
        border: 1px solid #ccc;
        padding: 20px;
    }
    .icon {
        width: 2em;
        height: 2em;
        vertical-align: -0.15em;
        fill: currentColor;
        overflow: hidden;
    }
    .item {
        float: left;
        position: relative;
        margin: 20px;
    }
    .addImg {
        width: 190px;
        height: 190px;
    }
    .upload_input {
        display: none;
    }
    .preview {
        position: absolute;
        width: 190px;
        height: 190px;
        left: 0;
        top: 0;
    }
    .click {
        position: absolute;
        width: 190px;
        height: 190px;
        left: 0;
        top: 0;
        z-index: 1;
        cursor: pointer;
    }
    .delete {
        position: absolute;
        right: -2rem;
        top: -1rem;
        cursor: pointer;
        display: none;
    }
    .preview img {
        width: 100%;
        height: 100%;
    }
</style>
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
            <h3>户基础信息</h3>
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
                        <select class="chosen-select" style="width:80px;height: 34px" >
                            <option value="386910" hassubinfo="true" >淇滨区</option>
                        </select>
                        &nbsp;
                        <select  id='jiedao'class="chosen-select" style="width:80px;height: 34px" required>
                            <option value="" hassubinfo="true">${family_team.jiedao}</option>
                            <#list areas as a>
                                <option value="${a.areaId?c}" name="jiedao" jiedaoname="${a.areaId?c}" hassubinfo="true">${a.areaName}</option>
                            </#list>
                        </select>
                        &nbsp;
                        <select id='juweihui'class="chosen-select" name="fly_area_id" style="width:80px;height: 34px" required>
                            <option value="" hassubinfo="true">${family_team.cunweihui}</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"><span style="color: red">*</span>住址：</label>
                    <div class="col-sm-8">
                        <input id="firstname" value="${family.fly_address}" name="fly_address" class="form-control" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">门牌号：</label>
                    <div class="col-sm-8">
                        <input value="${family.fly_doorNum}" id="firstname" name="fly_doorNum" class="form-control" type="text">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label"><span style="color: red">*</span>户主姓名：</label>
                    <div class="col-sm-8">
                        <input id="lastname" value="${family.fly_name}" name="fly_name" class="form-control" type="text" required class="valid">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"><span style="color: red">*</span>身份证号：</label>
                    <div class="col-sm-8">
                        <input id="username" value="${family.fly_IDcard}" name="fly_IDcard" required class="form-control" type="text" aria-required="true" aria-invalid="true" class="error">
                    </div>
                </div>


                <div class="form-group" id="data_1">
                    <label class="col-sm-3 control-label"><span style="color: red">*</span>出生日期：</label>
                    <div class="input-group date">
                        &nbsp;<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                        <input type="text" value="${family.fly_birthday?string('yyyy-MM-dd')}" name="fly_birthday" class="form-control" style="width: auto">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label"><span style="color: red">*</span>联系电话：</label>
                    <div class="col-sm-8">
                        <input id="confirm_password" value="${family.fly_phone}" name="fly_phone" class="form-control" required type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"><span style="color: red">*</span>建筑面积：</label>
                    <div class="col-sm-8">
                        <input required value="${family.fly_buldArea}" id="confirm_password" placeholder="平方米" name="fly_buldArea" class="form-control" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"><span style="color: red">*</span>采暖面积：</label>
                    <div class="col-sm-8">
                        <input required value="${family.fly_heatArea}" id="confirm_password" placeholder="平方米" name="fly_heatArea" class="form-control" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">是否贫困：</label>
                    <div class="radio radio-info radio-inline">
                        <input type="radio" id="inlineRadio1" value="0" name="fly_ispoor" <#if family.fly_ispoor==0>checked</#if>>
                        <label for="inlineRadio1"> 否 </label>
                    </div>
                    <div class="radio radio-inline">
                        <input type="radio" id="inlineRadio2" value="1" name="fly_ispoor" <#if family.fly_ispoor==1>checked</#if>>
                        <label for="inlineRadio2"> 是 </label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"><span style="color: red">*</span>工程小组：</label>
                    <div class="col-sm-8">
                        &nbsp;
                        <select class="chosen-select" style="width:160px;height: 34px"  name="fly_tem_id"">
                        <option value="" hassubinfo="true">--请选择小组--</option>
                            <#list teams as t>
                                <option value="${t.temId}" hassubinfo="true" >${t.temName}</option>
                            </#list>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">备注：</label>
                    <div class="col-sm-8">
                        <input value="${family.fly_notes}" id="email" name="fly_notes" class="form-control" type="text">
                    </div>
                </div>
                <div class="ibox-content">
                    <h3>采购信息</h3>
                    <table id="caigou"></table>
                    <table id="price"></table>
                    <div class="form-group">
                        <div class="form-group" style="margin-left: 80px">
                            <div class="col-sm-12">
                                &nbsp;
                                <select class="chosen-select" style="width:120px;height: 34px" name="ept_type">
                                    <option value="" hassubinfo="true">请选择产品类型</option>
                                    <option value="热风机" hassubinfo="true">热风机</option>
                                    <option value="生物质炉具" hassubinfo="true">生物质炉具</option>
                                </select>
                                &nbsp;
                                <select class="chosen-select" style="width:120px;height: 34px" name="ept_facty">
                                    <option value="" hassubinfo="true">请选择厂家</option>
                                    <option value="长虹" hassubinfo="true">长虹</option>
                                    <option value="格力" hassubinfo="true">格力</option>
                                    <option value="美的" hassubinfo="true">美的</option>
                                </select>
                                &nbsp;
                                <select class="chosen-select" style="width:120px;height: 34px" name="ept_model" id="xinghao">
                                    <option value="" hassubinfo="true">请选择型号</option>
                                    <option value="DZW40(大)" hassubinfo="true">DZW40(大)</option>
                                    <option value="DZW40(小)" hassubinfo="true">DZW40(小)</option>
                                    <option value="DZW39(小)" hassubinfo="true">DZW39(小)</option>
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
                                <#list listorder as lo>
                                    <tr>
                                        <th>${lo.oreptid}</th>
                                        <th>${lo.epttype}</th>
                                        <th>${lo.eptfacty}</th>
                                        <th>${lo.eptmodel}</th>
                                        <th>${lo.eptprice}</th>
                                        <th>${lo.oreptnum}</th>
                                        <th><a onclick= "" href="javascript:void(0);" class="btn btn-primary ">删除</a></th>

                                    </tr>
                                </#list>
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
                                    <input type="radio" id="inlineRadio1" value="0" name="purse_payMethod"<#if purchase.pursePayMethod==0>checked</#if>>
                                    <label for="inlineRadio1"> 现金 </label>
                                </div>
                                <div class="radio radio-inline">
                                    <input type="radio" id="inlineRadio2" value="1" name="purse_payMethod" <#if purchase.pursePayMethod==1>checked</#if>>
                                    <label for="inlineRadio2"> 转账 </label>
                                </div>
                                <div class="radio radio-inline">
                                    <input type="radio" id="inlineRadio2" value="2 name="purse_payMethod" <#if purchase.pursePayMethod==2>checked</#if>>
                                    <label for="inlineRadio2"> 支付宝 </label>
                                </div>
                            </div>
                            <div class="form-group" id="data_1">
                                <label class="col-sm-3 control-label"><span style="color: red">*</span>付款时间：</label>
                                <div class="input-group date">
                                    &nbsp;<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                    <input type="text" name="purse_payDate" class="form-control" value="${purchase.pursePayDate?string('yyyy-MM-dd')}" style="width: auto">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><span style="color: red">*</span>收据编号：</label>
                                <div class="col-sm-8">
                                    <input id="username" name="purse_receipt" required class="form-control" value="${purchase.purseReceipt}" type="text" aria-required="true" aria-invalid="true" class="error">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><span style="color: red">*</span>安装协议：</label>
                                <div class="col-sm-8">
                                    <input id="username" name="purse_instPtl" required class="form-control" value="${purchase.purseInstPtl}" type="text" aria-required="true" aria-invalid="true" class="error">
                                </div>
                            </div>
                        </div>
            </form>
        </div>
        <form action="dofamilyadd_img" method="post" enctype="multipart/form-data">

            <div class="wrapper wrapper-content animated fadeInRight"><div class="ibox-content">
                <h3>资料上传</h3>
                <table class="table table-striped table-bordered table-hover " id="editable">

                    <th>资料上传</th>
                    <td>
                        <section>
                        <#--<h2>svg制作多图上传</h2>-->
                            <article>
                                <div class="item">
                                    <svg class="icon addImg" aria-hidden="true">
                                        <use xlink:href="#icon-tianjiatupian"></use>
                                    </svg>
                                    <input required  style="display: none" name="fly_data1" type="file" class="upload_input" id="url1"   onChange="preview(this)" >
                                    <input type="hidden" name="fly_id" value="${fly_id}">
                                    <div class="preview"><img src="${family.fly_data1}" ></div>
                                    <div class="click" onClick="loadImg(this)"></div>
                                    <div class="delete" onClick="deleteImg(this)">
                                        <svg class="icon" aria-hidden="true">
                                            <use xlink:href="#icon-shanchu4"></use>
                                        </svg>
                                    </div>
                                    <div align="center">身份证正面</div>
                                </div>
                                <div class="item">
                                    <svg class="icon addImg" aria-hidden="true">
                                        <use xlink:href="#icon-tianjiatupian"></use>
                                    </svg>
                                    <input required  style="display: none" name="fly_data2" type="file" id="url2" class="upload_input" onChange="preview(this)" >
                                    <div class="preview"><img src="${family.fly_data2}" ></div>
                                    <div class="click" onClick="loadImg(this)"></div>
                                    <div class="delete" onClick="deleteImg(this)">
                                        <svg class="icon" aria-hidden="true">
                                            <use xlink:href="#icon-shanchu4"></use>
                                        </svg>
                                    </div>
                                    <div align="center">身份证反面</div>
                                </div>
                                <div class="item">
                                    <svg class="icon addImg" aria-hidden="true">
                                        <use xlink:href="#icon-tianjiatupian"></use>
                                    </svg>
                                    <input required  style="display: none" name="fly_data3" type="file" id="url3" class="upload_input" onChange="preview(this)" >

                                    <div class="preview"><img src="${family.fly_data3}" ></div>
                                    <div class="click" onClick="loadImg(this)"></div>
                                    <div class="delete" onClick="deleteImg(this)">
                                        <svg class="icon" aria-hidden="true">
                                            <use xlink:href="#icon-shanchu4"></use>
                                        </svg>
                                    </div>
                                    <div align="center">户口本其他业</div>
                                </div>
                                <div class="item">
                                    <svg class="icon addImg" aria-hidden="true">
                                        <use xlink:href="#icon-tianjiatupian"></use>
                                    </svg>
                                    <input required  style="display: none" name="fly_data4" type="file" id="url4" class="upload_input" onChange="preview(this)" >
                                    <div class="preview"><img src="${family.fly_data4}" ></div>
                                    <div class="click" onClick="loadImg(this)"></div>
                                    <div class="delete" onClick="deleteImg(this)">
                                        <svg class="icon" aria-hidden="true">
                                            <use xlink:href="#icon-shanchu4"></use>
                                        </svg>
                                    </div>
                                    <div align="center">户口本主页</div>
                                </div>
                                <div class="item">
                                    <svg class="icon addImg" aria-hidden="true">
                                        <use xlink:href="#icon-tianjiatupian"></use>
                                    </svg>
                                    <input required  style="display: none" name="fly_data5" type="file" id="url5" class="upload_input" onChange="preview(this)" >
                                    <div class="preview"><img src="${family.fly_data5}" ></div>
                                    <div class="click" onClick="loadImg(this)"></div>
                                    <div class="delete" onClick="deleteImg(this)">
                                        <svg class="icon" aria-hidden="true">
                                            <use xlink:href="#icon-shanchu4"></use>
                                        </svg>
                                    </div>
                                    <div align="center">付款收据</div>
                                </div>
                                <div class="item">
                                    <svg class="icon addImg" aria-hidden="true">
                                        <use xlink:href="#icon-tianjiatupian"></use>
                                    </svg>
                                    <input required  style="display: none" name="fly_data6" type="file" id="url6" class="upload_input" onload="preview(this)" onChange="preview(this)" >
                                    <div class="preview">
                                        <img src="${family.fly_data6}" >
                                    </div>
                                    <div class="click" onClick="loadImg(this)"></div>
                                    <div class="delete" onClick="deleteImg(this)">
                                        <svg class="icon" aria-hidden="true">
                                            <use xlink:href="#icon-shanchu4"></use>
                                        </svg>
                                    </div>
                                    <div align="center">安装协议</div>
                                </div>
                                <div style="clear: left;"></div>
                            </article>
                        </section>

                        <script type="text/javascript">
                            //选择图片
                            var loadImg = function(obj){
                                $(obj).parent().find(".upload_input").click();
                            }
                            //删除
                            var deleteImg = function(obj){
                                $(obj).parent().find('input').val('');
                                $(obj).parent().find('.preview').html('');
                                $(obj).hide();
                            }
                        </script>

                        <!-- 预览 -->
                        <script type="text/javascript">
                            function preview(file) {
                                var prevDiv = $(file).parent().find('.preview');
                                if (file.files && file.files[0]) {
                                    var reader = new FileReader();
                                    reader.onload = function(evt) {
                                        prevDiv.html('<img src="' + evt.target.result + '" />');
                                    }
                                    reader.readAsDataURL(file.files[0]);
                                } else {//IE
                                    prevDiv.html('<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>');
                                }
                                $(file).parent().find('.delete').show();
                            }
                        </script>
                    </td>
                    </tr>
                </table>
                <div class="" align="center">
                    <a href="/initfamilylist"> <button class="btn btn-primary" type="button"><返回列表></button></a>
                </div>

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
        var fly_name=this.value
        $.ajax({
            type:"post",
            url:"/ajax",
            data:{"fly_name":fly_name},
            success:function(returnData){
                if(returnData){
                    alert("已添加")
                }

            }
        })

    })


</script>
<script type="text/javascript">
    $(function(){
        $("#weibo").keyup(function(){
            var len = $(this).val().length;
            if(len > 300){
                $(this).val($(this).val().substring(0,300));
            }
            var num = 300 - len;
            $("#word").text(num);
        });
    });
</script>

<script type="text/javascript">
    $("#tj").click(function () {
        var u1 = $("#url1").val();
        var u2 = $("#url2").val();
        var u3 = $("#url3").val();
        var u4 = $("#url4").val();
        var u5 = $("#url5").val();
        var u6 = $("#url6").val();
        if(u1 ==""){
            alert("身份证正面不能为空")
            return false
        }
        if(u2 ==""){
            alert("身份证反面不能为空")
            return false
        }
        if(u3 ==""){
            alert("户口本其他页不能为空")
            return false
        }
        if(u4 ==""){
            alert("户口本主页不能为空")
            return false
        }
        if(u5 ==""){
            alert("付款收据不能为空")
            return false
        }
        if(u6 ==""){
            alert("安装协议不能为空")
            return false
        }

    })
</script>
<script>
    $("#xinghao").change(function() {
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
        $('#editable').dataTable().fnAddData([
            '<input style="border: 0;background-color: #f5f5f5" type="text" name="ept_id" value="'+ept_id+'"/>',
            '<input  style="border: 0;background-color: #f5f5f5" type="text" name="ept_type" value="'+ept_type+'"/>',
            '<input  style="border: 0;background-color: #f5f5f5" type="text" name="ept_facty" value="'+ept_facty+'"/>',
            '<input  style="border: 0;background-color: #f5f5f5" type="text" name="ept_model" value="'+ept_model+'"/>',
            '<input  style="border: 0;background-color: #f5f5f5" type="text" name="ept_price" value="'+ept_price+'"/>',
            '<input  style="border: 0.5;background-color: #f5f5f5" type="number" name="mount"/>',
            '<a onclick= "table.row($(this).parents(\'tr\')).remove().draw();" href="javascript:void(0);" class="btn btn-primary ">删除</a>']);
    }
</script>

    <script>
    //接收后台传递过来的数据页面回显
    var param="${family.fly_tem_id}";
    $("select[name=fly_tem_id]").find("option[value="+param+"]").attr('selected','selected');
    </script>

</body>

</html>
