<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1 align="center">测试权限页面</h1>
<h2>页面是templates/testAuto.ftl</h2>
<h2>---------guest（游客）--一旦登录就不会显示---------</h2>
<@shiro.guest>
    您当前是游客，<a href="javascript:void(0);">登录</a>
</@shiro.guest>
<h1>-------- user（已经登录，或者记住我登录) ------------</h1>
<@shiro.user>
    <p>欢迎[<@shiro.principal/>]</p>
    <h2><a href="/logout">用户退出</a></h2>
</@shiro.user>
<h2>--------hasRole标签（判断是否拥有这个角色）------------</h2>
<h3> 1=管理员、2=工程组长、3=信息员、4=安装工、5=库管员、6=政府人员、7=运维人员、8=测试、9=测试员</h3>
<@shiro.hasRole name="1">拥有角色管理员<br/></@shiro.hasRole>
<@shiro.hasRole name="2">拥有角色工程组长<br/></@shiro.hasRole>
<@shiro.hasRole name="3">拥有角色信息员<br/></@shiro.hasRole>
<@shiro.hasRole name="4">拥有角色安装工<br/></@shiro.hasRole>
<@shiro.hasRole name="5">拥有角色库管员<br/></@shiro.hasRole>
<@shiro.hasRole name="6">拥有角色政府人员<br/></@shiro.hasRole>
<@shiro.hasRole name="7">拥有角色运维人员<br/></@shiro.hasRole>
<@shiro.hasRole name="8">拥有角色测试<br/></@shiro.hasRole>
<@shiro.hasRole name="9">拥有角色测试员<br/></@shiro.hasRole>

<h2>--------hasAnyRoles标签（判断是否拥有这些角色的其中一个）------------</h2>
<@shiro.hasAnyRoles name="1,2,3">
拥有角色:管理员--或--工程组长--或--信息员<br/>
</@shiro.hasAnyRoles>



<h2>-------- lacksRole标签（判断是否不拥有这个角色）------------</h2>
<@shiro.lacksRole name="2">
    不拥有工程组长角色
</@shiro.lacksRole>

<h2>--------hasPermission标签（判断是否有拥有这个权限）------------</h2>
<@shiro.hasPermission name="52">
   拥有移动端的权限
</@shiro.hasPermission>

<@shiro.hasPermission name="49">
   编辑户信息
</@shiro.hasPermission>
</body>
</html>