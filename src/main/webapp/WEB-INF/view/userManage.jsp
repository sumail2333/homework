<%--
  Created by IntelliJ IDEA.
  User: zxiong4
  Date: 1/15/2019
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../resources/jquery.min.js"></script>
    <script type="text/javascript">
        function search(id){

        }
    </script>
</head>
<body>
<input type="text" placeholder="请输入用户名"><input type="button" onclick="search('${item.userId}')" value="查询" />
</body>
</html>
