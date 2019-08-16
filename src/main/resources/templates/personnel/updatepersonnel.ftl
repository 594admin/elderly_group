<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>修改员工信息</title>
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
                    <h5>修改 <small>员工</small></h5>
                </div>

            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="commentForm" action="/doUpdatePersonnels" method="post">
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><span style="color: red">*</span>手机号：</label>
                                <div class="col-sm-8">
                                    <input name="prePhone" value="${personnel.prePhone}" minlength="2" type="text" class="form-control" pattern="0?(13|14|15|18|17)[0-9]{9}" required="" aria-required="true">
                                    <input name="preId" value="${personnel.preId}" minlength="2" type="hidden">
                                </div>
                            </div>
                            <p align="center"  style="color: red" id="prePhones"></p>
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><span style="color: red">*</span>密码：</label>
                                <div class="col-sm-8">
                                    <input name="prePassword" value="${personnel.prePassword}" minlength="2" type="password" class="form-control"  required="" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><span style="color: red">*</span>姓名：</label>
                                <div class="col-sm-8">
                                    <input name="preName"  value="${personnel.preName}" minlength="2" type="text" class="form-control" required="" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">E-mail：</label>
                                <div class="col-sm-8">
                                    <input id="cemail"  value="${personnel.preEmail}" type="email" class="form-control" name="preEmail"  aria-required="true">
                                </div>
                            </div>
                            <p align="center"  style="color: red" id="preEmails"></p>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">性别：</label>
                                <div class="col-sm-8">
                                    <div class="radio">
                                        <label><input type="radio" value="1"  name="preGender">男</label>
                                        <label><input type="radio" value="0" name="preGender">女</label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">状态：</label>
                                <div class="col-sm-8">
                                    <div class="radio">
                                        <label><input type="radio" value="1" name="preStatus">正常</label>
                                        <label><input type="radio" value="0"  name="preStatus">注销</label>
                                    </div>

                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button class="btn btn-primary" type="submit">确认修改</button>
                                    <a href="javascript:void(0)" class="btn btn-primary" onclick="window.location='/listPersonnels'">返回</a>
                                </div>
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
            //默认选中单选按钮
            $("input[name='preGender'][value='${personnel.preGender}']").attr("checked",true);
            $("input[name='preStatus'][value='${personnel.preStatus}']").attr("checked",true);

            var preId = "${personnel.preId}";
                //验证手机号
                $("[name='prePhone']").focus(function(){
                    $("#prePhones").html('');
                }).blur(function(){
                    var prePhone = $("[name='prePhone']").val();
                    if(prePhone !='' && prePhone !=null){
                        var a = /0?(13|14|15|18|17)[0-9]{9}/;
                       if(!a.test(prePhone)){
                           $("#prePhones").append("请输入正确格式的手机号");
                           $("[name='prePhone']").val('');
                       }else {
                           $.post("/ajaxCheckPhoneById",{"prePhone":prePhone,"preId":preId},
                                   function(prePhone){
                                       if(prePhone == 1){
                                           $("#prePhones").append("手机号已经被使用");
                                           $("[name='prePhone']").val('');
                                       }else if(prePhone == 0){
                                           $("#prePhones").append("手机号已经被使用,原有账号已经被注销");
                                           $("[name='prePhone']").val('');
                                       }else{
                                           $("#prePhones").append("手机号可以使用");
                                       }
                                   }
                           )
                       }
                    }
                });
            //验证邮箱
            $("[name='preEmail']").focus(function(){
                $("#preEmails").html('');
            }).blur(function(){
                var preEmail = $("[name='preEmail']").val();
                if(preEmail !='' && preEmail !=null){
                    var a = /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/;
                    if(!a.test(preEmail)){
                        $("#preEmails").append("请输入正确格式的邮箱");
                        $("[name='preEmail']").val('');
                    }else {
                        $.post("/ajaxCheckEmailById",{"preEmail":preEmail,"preId":preId},
                                function(preEmail){
                                    if(preEmail==1){
                                        $("#preEmails").append("邮箱已经被使用");
                                        $("[name='preEmail']").val('');
                                    }else if(preEmail==0){
                                        $("#preEmails").append("邮箱已经被使用,原有账号被注销");
                                        $("[name='preEmail']").val('');
                                    }else{
                                        $("#preEmails").append("邮箱可以使用");
                                    }
                                }
                        )
                    }
                }
            })


        })
    </script>



    <script src="js/plugins/jeditable/jquery.jeditable.js"></script>


    <!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>



    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    <!--统计代码，可删除-->

</body>

</html>
