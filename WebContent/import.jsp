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
<div class="">
  <div id="loginform" class="loginBox">
    <form id="form_excel" name="form_excel"  action="${APP_PATH }/excelUpload/form" method="post" enctype="multipart/form-data">
    	
    <div class="row cl">
        <label class="form-label col-xs-3"></label>
        <div class="formControls col-xs-8">
           <input type="file"  name="upfile" />
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
         	<input type="submit" value="&nbsp;上&nbsp;&nbsp;&nbsp;&nbsp;传&nbsp;" id="myButton" data-loading-text="导入..." class="btn btn-success radius size-L">
            <a href="${APP_PATH }/group/getGroupOrder">
            <input type="button" class="btn btn size-L" value="&nbsp;返&nbsp;&nbsp;&nbsp;&nbsp;回&nbsp;">
        	</a>
        </div>
      </div>
    </form>
    
    <div class="row cl">
        <label class="form-label col-xs-3"></label>
        <div class="formControls col-xs-8">
          <a href="${APP_PATH }/excelUpload/clear">
    	<input type="button" value="&nbsp;清&nbsp;&nbsp;&nbsp;&nbsp;除&nbsp;" id="myButton2" data-loading-text="清除..." class="btn btn-warning radius size-L">
    	</a>
    	<span>若上传错误或重复导入可清除数据</span>
    	<br><span style="color:red">${msg }</span>
        </div> 
      </div> 
  </div>
</div>
<div class=""></div>
  <script>
  $('#myButton').on('click', function () {
    var $btn = $(this).button('loading')    // business logic...    $btn.button('reset')
  })
    $('#myButton2').on('click', function () {
    var $btn = $(this).button('loading')    // business logic...    $btn.button('reset')
  })
</script>
</body>
</html>