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
<title>学号查询 </title>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class=""></div>
<div class="">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="${APP_PATH }/user/getUserNumber" method="post">
    <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input value="${uName }" name="userName" type="text" placeholder="姓名" class="input-text size-L">
         <br><span style="color:gray">${nameError }${Error }</span>
        </div>
      </div>
  <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input readonly value="${ur.userNumber }" name="userNumber" type="text" placeholder="学号" class="input-text size-L">
        </div>
      </div> 
		
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <label for="online"></label>
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
        <input type="submit" value="&nbsp;查&nbsp;&nbsp;&nbsp;&nbsp;询&nbsp;" id="myButton" data-loading-text="..." class="btn btn-success radius size-L">

         <a href="${APP_PATH }/login.jsp"> <input type="button" class="btn btn radius size-L" value="&nbsp;返&nbsp;&nbsp;&nbsp;&nbsp;回&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
  <script>
  $('#myButton').on('click', function () {
    var $btn = $(this).button('loading')    // business logic...    $btn.button('reset')
  })
</script>
<script type="text/javascript" src="${APP_PATH }/static/h-ui/js/H-ui.min.js"></script>

</body>
</html>