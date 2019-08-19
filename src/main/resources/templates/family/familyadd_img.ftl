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


<form action="/dofamilyadd_img" method="post" enctype="multipart/form-data">
    <div class="wrapper wrapper-content animated fadeInRight">

        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>资料上传</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="table_data_tables.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="table_data_tables.html#">选项1</a>
                                </li>
                                <li><a href="table_data_tables.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <#--<div class="">-->
                            <#--<a &lt;#&ndash;onclick="fnClickAddRow();"&ndash;&gt; href="/doAddFeedback" class="btn btn-primary ">添加行</a>-->
                        <#--</div>-->
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
                                                <input required style="display: none" name="fly_data1" type="file" class="upload_input" id="url1"  onChange="preview(this)" >
                                                <input type="hidden" name="fly_id" value="${fly_id}">
                                                <div class="preview"></div>
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
                                                <input required style="display: none" name="fly_data2" type="file" id="url2" class="upload_input" onChange="preview(this)" >
                                                <div class="preview"></div>
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
                                                <input required style="display: none" name="fly_data3" type="file" id="url3" class="upload_input" onChange="preview(this)" >
                                                <div class="preview"></div>
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
                                                <input required style="display: none" name="fly_data4" type="file" id="url4" class="upload_input" onChange="preview(this)" >
                                                <div class="preview"></div>
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
                                                <input required style="display: none" name="fly_data5" type="file" id="url5" class="upload_input" onChange="preview(this)" >
                                                <div class="preview"></div>
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
                                                <input required style="display: none" name="fly_data6" type="file" id="url6" class="upload_input" onChange="preview(this)" >
                                                <div class="preview"></div>
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
                                    <input type="submit" value="提交" id="tj" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script type="text/javascript" src="js/svg.js"></script>



    <script src="js/plugins/jeditable/jquery.jeditable.js"></script>

    <!-- Data Tables -->
    <script src="/static/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="/static/js/plugins/dataTables/dataTables.bootstrap.js"></script>

    <!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>

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



  <#--  <script>
        var list=${'pic'};
        alert(list);
        if (list.size() > 0) {
            $.each(list, function (i, p) {
        for(var i=0;i<list.size();i++){
        var p="https://sxd-1258987597.cos.ap-chengdu.myqcloud.com/dsBuffer.jpg";
                document.getElementById("pic").src = p;
        })
        }
    </script>-->

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
