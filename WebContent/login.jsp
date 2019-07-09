<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<style>
a{
	text-decoration:none;
}
</style>
	<script type="text/javascript" src="${APP_PATH }/static/js/jquery.min.js"></script>
	<link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<link href="${APP_PATH }/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
	<link href="${APP_PATH }/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
	<link href="${APP_PATH }/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
	<link href="${APP_PATH }/static/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<title>用户登录 </title>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class=""></div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="${APP_PATH }/user/login" method="post">
    <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input value="${uName }" name="userName" type="text" placeholder="姓名" class="input-text size-L">
         <br><span style="color:gray">${userName }</span>
        </div>
      </div>
  <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input value="${uNumber }" name="userNumber" type="text" placeholder="学号" class="input-text size-L">
        <br><span style="color:gray">${userNumber } ${error }</span>
        </div>
      </div> 
		
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <label for="online">
            <a href="${APP_PATH }/queryUserNumber.jsp">
            忘记学号?</a></label>
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
        <input type="submit" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;" id="myButton" data-loading-text="Loading..." class="btn btn-success radius size-L">

          <input type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer"></div>


  <script>
  $('#myButton').on('click', function () {
    var $btn = $(this).button('loading')    // business logic...    $btn.button('reset')
  })
</script>
<script type="text/javascript" src="${APP_PATH }/static/h-ui/js/H-ui.min.js"></script>

</body>
</html>