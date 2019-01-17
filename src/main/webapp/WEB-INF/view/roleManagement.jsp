<%--
  Created by IntelliJ IDEA.
  User: swu33
  Date: 2019/1/17
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>role manage</title>
    <script type="text/javascript" src="../resources/jquery.min.js"></script>
    <style type="text/css">
        #popup{
            background:rgba(1,1,1,0.5);
            width:100%;
            height:100%;
            z-index: 200;
            display: none;
        }
        #popout{
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
        function pop() {
            $('#table')[0].style.display = "none";
            $('#popup')[0].style.display = "block";
        }
        function pop2() {
            $('#table')[0].style.display = "none";
            $('#popout')[0].style.display = "block";
        }
        function cancel() {
            $('#table')[0].style.display = "block";
            $('#popup')[0].style.display = "none";
        }
        function search() {
            var roleID = $('#roleId').val();
            var roleName = $('#roleName').val();
            $.ajax({
                type: "get",
                contentType: "application/json; charset=utf-8",
                url: "/role/listRole?roleID="+roleID+"&roleName="+roleName,
                success: function (data) {
                    var str = "";
                    $('#tbody').html("");
                    for(var i=0;i<data.length;i++){
                        str = "<tr>"+
                                "<td>"+data[i].roleId+"</td>"+
                                "<td>"+data[i].roleName+"</td>"+
                                "<td>"+"<input class=\"button1\" type=\"button\" onclick=\"modify('{data[i].roleId}',${data[i].roleName})\" value=\"Modify\">" +
                            "           <input class=\"button1\" type=\"button\" onclick=\"deleteItem(${data[i].roleId})\" value=\"Delete\">"+"</td>"+
                                "</tr>";
                        $('#tbody').append(str);
                    }
                },
                error: function (data) {
                }
            });
        }
        function modify(roleId,roleName) {
            pop();
            $('#roleId2').val(roleId);
            $('#roleName2').val(roleName);
        }
        function saveModify() {
            var roleID = $('#roleId2').val();
            var roleName = $('#roleName2').val();
            var submitData = {
                roleId:roleID,
                roleName:roleName
            };
            $.ajax({
                type: "post",
                contentType: "application/json; charset=utf-8",
                url: "/role/updateRole",
                data:JSON.stringify(submitData),
                success: function (result) {
                    alert("Operation success");
                    cancel();
                    search();
                },
                error: function (result) {
                    alert("Operation failure");
                    cancel();
                }
            });
        }
        function saveAdd() {
            var roleID = $('#roleId3').val();
            var roleName = $('#roleName3').val();
            var submitData = {
                roleId:roleID,
                roleName:roleName
            };
            $.ajax({
                type: "post",
                contentType: "application/json; charset=utf-8",
                url: "/role/insertRole",
                data:JSON.stringify(submitData),
                success: function (result) {
                    alert("Operation success");
                    cancel();
                    search();
                },
                error: function (result) {
                    alert("Operation failure");
                    cancel();
                }
            });
        }
        function deleteItem(roleId){
            $.ajax({
                type: "post",
                contentType: "application/json; charset=utf-8",
                data:JSON.stringify({roleId:roleId}),
                url: "role/deleteRole",
                success: function (data) {
                    alert("Operation success");
                    search();
                },
                error: function (data) {
                    alert("Operation failure");
                }
            });
        }
    </script>
</head>
<body>
    <div>
        <div id="search" style="PADDING-LEFT: 300px;padding-top: 200px;">
            <div>Role ID <br><input type="text" id="roleId"></div>
            <div>Role Name<br><input type="text" id="roleName"></div>
            <input type="button" onclick="search()" value="search">
        </div>
        <div id="add" style="padding-left: 300px;padding-top: 50px;padding-bottom: 50px" >
            <input type="button" value="Add Role" onclick="pop2()">
        </div>
        <div id="table" style="padding-left: 300px" >
            <table border="1" cellpadding="0" cellspacing="0" width="400px" style="text-align:center;">
                <thead>
                <td>Role ID</td>
                <td>Role Name</td>
                <td>operate</td>
                </thead>
                <tbody id="tbody">
                <c:forEach items="${roleInfo}" var="item" >
                    <tr style="height:40px;">
                        <td>${item.roleId}</td>
                        <td>${item.roleName}</td>
                        <td>
                            <input class="button1" type="button" onclick="modify('${item.roleId}','${item.roleName}')" value="Modify">
                            <input class="button1" type="button" onclick="deleteItem('${item.roleId}')" value="Delete">
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
        <div id="popup">
            <table class="content">
                <tr>
                    <td width:30%;><span style="color:red;">*</span>Role ID</td>
                    <td><input id="roleId2" type="text" required="required"></td>
                </tr>
                <tr>
                    <td width:30%;><span style="color:red;">*</span>Role Name</td>
                    <td><input id="roleName2" type="text" required="required"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="button" onclick="saveModify()" value="Commit" style="margin-top:5px;"/></td>
                    <td colspan="2"><input type="button" onclick="cancel()" value="Cancel" style="margin-top:5px;"/></td>
                </tr>
            </table>
        </div>
        <div id="popout">
            <table class="content">
                <tr>
                    <td width:30%;><span style="color:red;">*</span>Role ID</td>
                    <td><input id="roleId3" type="text" required="required"></td>
                </tr>
                <tr>
                    <td width:30%;><span style="color:red;">*</span>Role Name</td>
                    <td><input id="roleName3" type="text" required="required"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="button" onclick="saveAdd()" value="Commit" style="margin-top:5px;"/></td>
                    <td colspan="2"><input type="button" onclick="cancel()" value="Cancel" style="margin-top:5px;"/></td>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>
