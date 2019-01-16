<%--
  Created by IntelliJ IDEA.
  User: zxiong4
  Date: 1/15/2019
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../resources/jquery.min.js"></script>
    <style type="text/css">
        .popup{
            background:rgba(1,1,1,0.5);
            width:100%;
            height:100%;
            z-index: 200;
            display: none;
        }
        .content{
            background:white;
            position: absolute;
            transform: translate(-50%, -50%);
            top:50%;
            left:50%;
            text-align: center;
            display: flex;
            justify-content: center;
            align-items: center;
            width:400px;
        }
    </style>
    <script type="text/javascript">
        var contextPath = "${pageContext.request.contextPath}";
        var flag = false;
        var id=22;
        function editMenu(){
            $('.menu')[0].style.display = "none";
            $('.popup')[0].style.display = "block";
        }
        function deleteItem(id){
            $.ajax({
                type: "post",
                contentType: "application/json; charset=utf-8",
                data:JSON.stringify({id:id}),
                url: contextPath+"/opt/delete",
                success: function (data) {
                    window.location.href = "/opt/edit"
                },
                error: function (data) {
                }
            });
        }
        function modify(id,name,url){
            editMenu();
            $('#mc').val(name);
            $('#url').val(url);
            this.flag = true;
            this.id = id;
        }
        function save(){
            console.log($('#mc').val());
            if($('#mc').val().length == 0){
                alert("请填写名称");
                return;
            }
            if($('#url').val().length == 0){
                alert("请填写名称");
                return;
            }
            var url = this.flag ? contextPath+"/opt/update":contextPath+"/opt/create";
            var params = this.flag ? {id:this.id,name:$('#mc').val(),url:$('#url').val()}:{url:$('#url').val(),name:$('#mc').val()}
            $.ajax({
                type: "post",
                dataType: "text",
                contentType: "application/json; charset=utf-8",
                data:JSON.stringify(params),
                url: url,
                success: function (data) {
                    $('.menu')[0].style.display = "block";
                    $('.popup')[0].style.display = "none";
                    flag = false;
                    window.location.href = "/opt/edit"
                },
                error: function (data) {
                    alert("111111");
                }
            });
        }
    </script>
</head>
<body>
<div class="menu" style="position: absolute;transform: translate(-50%, -50%);top:50%;left:50%;text-align: center;width:400px;">
    <table border="1" cellpadding="0" cellspacing="0" width="400px" style="text-align:center;">
        <thead>
        <td>名称</td>
        <td>url</td>
        <td>操作</td>
        </thead>
        <c:forEach items="${opts}" var="item" >
            <tr style="height:40px;">
                <td>${item.name}</td>
                <td>${item.url}</td>
                <td>
                    <input class="button1" type="button" onclick="modify('${item.id}','${item.name}','${item.url}')" value="修改">
                    <input class="button1" type="button" onclick="deleteItem('${item.id}')" value="删除">
                </td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <input type="button" class="button1" value="新增菜单" onclick="editMenu()" style="margin-top:20px;"/>
    </div>
</div>
<div class="popup">
    <table class="content">
        <tr>
            <td width:30%;>名称</td>
            <td><input id="mc" type="text"></td>
        </tr>
        <tr>
            <td width:30%;>url</td>
            <td><input id="url" type="text"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="button" onclick="save()" value="确认" style="margin-top:5px;"/></td>
        </tr>
    </table>
</div>
</body>
</html>
