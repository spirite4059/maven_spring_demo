<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
  <title></title>
  <base href="<%=basePath%>"/>
  <link rel="stylesheet" type="text/css" href="resources/style/subPage.css"/>
</head>
<body>

<div style="...">
        <img alt="" src="/static/img/2.jpg">  
  <div style="...">
    <form id="loginForm" action="login" method="post">
      <div class="login_header">智慧人生</div>
      <div style="...">
        <div style="...">
          <div style="...">
            账&nbsp;&nbsp;号:
          </div>
          <!-- 特别注意  name="username" 这个必须写死,不能做更改-->
          <input type="text" name="username" style="..."/>
          <div style="...">
            密&nbsp;&nbsp;码:
          </div>
          <!-- 特别注意  name="password" 这个必须写死,不能做更改-->
          <input type="password" name="password" style="..."/>
        </div>
      </div>
      <div style="...">
        <input type="submit" style="..." value="登&nbsp;&nbsp;录" />
      </div>
      <div style="...">
        ${message}
      </div>
    </form>
  </div>
</div>

</body>
</html>