<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../resources/jquery.min.js"></script>
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
    <script>
        var contextPath = "${pageContext.request.contextPath}";
    </script>
    <script type="text/javascript">
        function checkMenu(){
            // $.ajax({
            //     type: "post",
            //     dataType: "text",
            //     contentType: "application/json; charset=utf-8",
            //     url: contextPath+"/opt/list",
            //     success: function (data) {
            //         window.location.href="/opt/list";
            //     },
            //     error: function (data) {
            //     }
            // });
            window.location.href = contextPath+"/opt/list";
        }
    </script>
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
    <%--<input type="button" value="菜单总览" onclick="checkMenu()"/>--%>
    <a href="opt/list">菜单总览</a>
    <a href="role/routeToRole">角色管理</a>
</body>
</html>