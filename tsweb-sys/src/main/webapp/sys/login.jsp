<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="<c:url value="/static/bootstrap/css/bootstrap.css"/>" />
<script type="text/javascript" src="<c:url value="/static/js/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/bootstrap/js/bootstrap.js"/>"></script>

<title>Login</title>
</head>
<body>
    <div class="container">
	    <div class="page-header">
	        <h1>TSWEB</h1>
	    </div>
	    <div class="row">
	        <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-8 col-xs-offset-2">
	           <div class="well">
	               <h4>用户登录</h4>
	               <hr>
		           <form class="form-horizontal" action="<c:url value="/sys/login"/>" method="post">
	                   <div class="form-group">
	                       <label for="username" class="col-md-3 col-sm-3 control-label">用户名</label>
	                       <div class="col-md-6 col-sm-6">
	                           <input type="text" class="form-control" name="username" id="username" value="hayden" placeholder="请输入用户名"/>
	                       </div>
	                   </div>
	                   <div class="form-group">
	                       <label for="password" class="col-md-3 col-sm-3 control-label">密　码</label>
	                       <div class="col-md-6 col-sm-6">
	                           <input type="text" class="form-control" name="password" id="password" value="hayden" placeholder="请输入密码"/>
	                       </div>
	                   </div>
	                   <div class="form-group">
	                       <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
	                           <div class="checkbox">
	                               <label>
	                                   <input type="checkbox" name="rememberMe"/> 记住我
	                               </label>
	                           </div>
	                       </div>
	                   </div>
	                   <div class="form-group">
	                       <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
	                           <button type="submit" class="btn btn-primary">登录</button>
	                       </div>
	                   </div>
	               </form>
	           </div>
	        </div>
	    </div>
    </div>
</body>
</html>