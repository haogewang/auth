<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>授权管理平台-登录</title>
    <link rel="icon" href="./assets/images/favicon.ico">
    <!-- Bootstrap -->
    <link href="./assets/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./assets/css/app.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        html,body {width: 100%; height: 100%;}
        .login-bg{ height:100%; position:relative;background: url("./assets/images/Login_Bg.png") no-repeat 0 0;background-size: cover;}
        .login-form {width: 350px; height: 224px;margin-top:-112px;margin-left: -175px; position: absolute; top:50%;left: 50%;}
        .form-group{margin-bottom: 25px; }
        .form-control:focus { border-color: #66afe9 !important; }
    </style>
</head>
<body>
<div class="login-bg">
    <form class="login-form">
        <div class="form-group">
            <h3 class="text-center" style="color: #df2434;">授权管理平台</h3>
        </div>
        <div class="form-group">
            <label for="userName" class="sr-only">用户名</label>
            <input type="text" class="form-control" autocomplete="off" id="userName" placeholder="用户名">
            <span class="has-error">请输入用户名</span>
        </div>
        <div class="form-group">
            <label for="userPwd" class="sr-only">密码</label>
            <input type="password" class="form-control" autocomplete="off" id="userPwd" placeholder="密码">
            <span class="has-error">请输入密码</span>
        </div>
        <button type="button" id="login_btn" class="btn btn-danger btn-block">登录</button>
    </form>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="./assets/js/jquery-1.12.4.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="./assets/js/bootstrap.min.js"></script>
<script src="./assets/js/app.js"></script>
<script>
    $(document).ready(function () {

        $('#userName,#userPwd').blur(function () {
            if($(this).val() === '') {
                $(this).addClass('form-control-error')
                $(this).siblings('.has-error').show()
                return
            } else {
                $(this).removeClass('form-control-error')
                $(this).siblings('.has-error').hide()
            }
        })
        $('#login_btn').click(function () {
            $('#userName,#userPwd').trigger('blur')
            if($('#userName').val() === '' || $('#userPwd').val() === '') {
                return
            }
            $.post(App.ajaxUrl + '/login',{
                username: $('#userName').val(),
                password: $('#userPwd').val()
            }, function(res){
                if (res.code === '200') {
                    window.location.href = './index'
                } else {
                    App.alert(res.msg)
                }
            })
        })
    })
</script>
</body>
</html>