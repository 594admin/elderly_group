<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>鹤壁清洁能源管理平台</title>
    <meta name="keywords" content="鹤壁，清洁取暖，清洁能源，鹤壁清洁能源">
    <meta name="description" content="鹤壁清洁能源管理平台是一个给鹤壁市农村取暖设备安装监测的服务平台">

    <link rel="shortcut icon" href="img/logo.ico">
    <link href="/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css?v=4.1.0" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
    <style type="text/css">
        .form-control:focus{
            border-color:  #0d68ce !important;;
        }
        .btn-primary {
            background-color: #0d68ce;
            border-color: #0d68ce;
            color: #FFFFFF;
        }
        .btn-primary:hover{
            background-color: #0f5eb6;
            border-color: #0f5eb6;
            color: #FFFFFF;
        }
    </style>
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div style="margin-top: 30%;">
            <div>
                <img src="img/logo.png" alt="Logo" width="109px" height="109px">
            </div>
            <h3>鹤壁市农村清洁取暖智能管理平台</h3>

            <form class="m-t" role="form" id="formOne" action="/doLogin" method="post">
                <div class="form-group">
                    <input type="input" id="account"  class="form-control" name="account" placeholder="手机号/邮箱" pattern="(\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14})|(0?(13|14|15|18|17)[0-9]{9})" required="required" title="请输入正确的账号格式">
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="密码" required="required">
                </div>
                <#if "msg??"><p class="text-muted text-center"><small style="color: red">${msg}</small></p></#if>
                <button type="submit" name="login" class="btn btn-primary block full-width m-b">登 录</button>
            </form>
        </div>
    </div>


    <!-- 全局js -->
    <script src="/js/jquery.min.js?v=2.1.4"></script>
    <script src="/js/bootstrap.min.js?v=3.3.6"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    <!--统计代码，可删除-->

</body>

</html>
