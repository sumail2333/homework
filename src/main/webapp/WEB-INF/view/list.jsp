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
    <style type="text/css">

    </style>
    <script type="text/javascript">
        var contextPath = "${pageContext.request.contextPath}";
        function editMenu(){
            window.location.href=contextPath+"/opt/edit";
        }
    </script>
</head>
<body>
<div style="position: absolute;transform: translate(-50%, -50%);top:50%;left:50%;text-align: center;width:400px;">
    <table border="1" cellpadding="0" cellspacing="0" width="400px" style="text-align:center;">
        <thead>
        <td>名称</td>
        <td>url</td>
        </thead>
        <c:forEach items="${opts}" var="item" >
            <tr style="height:40px;">
                <td>${item.name}</td>
                <td>${item.url}</td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <input type="button" value="菜单管理" onclick="editMenu()" style="margin-top:20px;"/>
    </div>
</div>

</body>
</html>
