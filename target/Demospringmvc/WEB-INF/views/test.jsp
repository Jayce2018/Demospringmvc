<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-05-07
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
hello my test!
<div>
    <h1 id="hcc">初始化</h1>
</div>
<script>
    var datasource={"name":"李小明","type":"用户"};
    document.getElementsByTagName("h1")[0].innerText=datasource.name;
    alert(datasource);
    alert(datasource.name);
</script>
</body>

</html>
