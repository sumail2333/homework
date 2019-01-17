<%--
  Created by IntelliJ IDEA.
  User: zxiong4
  Date: 1/15/2019
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../resources/jquery.min.js"></script>
    <script type="text/javascript">
        function getRoleName(id){
            return id ==1?"普通":id==2?"管理员":"超级用户";
        }
        function getRoleId(name){
            return name=="普通"?"1":name=="管理员"?"2":"3";
        }
        function addNew(){
            var username=$('#username').val();
            var password=$('#password').val();
            var password2=$('#password2').val();
            var roleId=getRoleId($('#roleId').val());
            if(username == ""||password==""||password2==""){
                alert("用户名或者密码为空");
                return;
            }
            if(password !== password2){
                alert("两次输入密码不一致!");
                return;
            }
            var params = {
                username:username,
                password:password,
                roleId:roleId
            }
            console.log(JSON.stringify(params));
            $.ajax({
                type: "post",
                contentType: "application/json; charset=utf-8",
                data:JSON.stringify(params),
                url: "/user/addNew",
                success: function (data) {
                    alert("新建成功");
                },
                error: function (data) {
                    alert("新建失败");
                }
            });
        }
        function search(){
            var name = $('#name').val();
            var params = {
                userName:name
            }
            $.ajax({
                type: "post",
                contentType: "application/json; charset=utf-8",
                data:JSON.stringify(params),
                url: "/user/search",
                success: function (data) {
                    $('#ids').html(data.userId);
                    $('#mc').html(data.userName);
                    var list = data.list.split(",");
                    var array = [];
                    for(var i=0;i<list.length;i++){
                        array.push(getRoleName(list[i]));
                    }
                    $('#role').html(array.join(","));
                },
                error: function (data) {
                }
            });
        }
    </script>
</head>
<body>
<input type="text" id="name" placeholder="请输入用户名"><input type="button" onclick="search()" value="查询" />
<table>
    <thead>
        <td>ID</td>
        <td>名称</td>
        <td>角色</td>
    </thead>
    <tr>
        <td id="ids"></td>
        <td id="mc"></td>
        <td id="role"></td>
    </tr>
</table>
    用户名:<br>
    <input type="text" id="username" value="">
    <br>
    密码:<br>
    <input type="password" id="password" value=""><br>
    确认密码:<br>
    <input type="password" id="password2" value="">
    <br>
    角色:<br>
    <select id="roleId" name="roleId">
        <option>普通</option>
        <option>管理员</option>
        <option>超级用户</option>
    </select>
    <br><br>
    <input type="button" onclick="addNew()" value="提交"><br>
</body>
</html>
