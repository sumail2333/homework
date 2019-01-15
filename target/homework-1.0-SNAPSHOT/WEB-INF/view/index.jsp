<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        input {
            border:none;
            border: 1px solid #ddd;
        }
        .in_form{
            margin-top: 15px;
        }
        input {
            margin-left: 10px;
        }
        .title{
            width:80px;
            text-align: center;
            display: inline-block;
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/userManage" method="post" style="position: absolute;transform: translate(-50%, -50%);top:50%;left:50%;">
        <div class="in_form">
            <label for="username">用户名</label>
            <input type="text" id="username" name="username"/>
        </div>
        <div class="in_form">
            <label for="password">密码</label>
            <input type="password" id="password" name="password"/>
        </div>
        <div class="in_form"><input type="submit" value="登录" /></div>
    </form>
</body>
</html>