<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/static/bootstrap/css/bootstrap.css"/>"/>
	<script type="text/javascript" src="<c:url value="/static/js/jquery.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/static/bootstrap/js/bootstrap.js"/>"></script>
	
	<style type="text/css">
	   #pageheader {
	       background-color: #222;
	   }
	</style>
	
	<title>Login</title>
</head>
<body>
    
    <div id="pageheader">
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#pageheader-navbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="#" class="navbar-brand">TSWEB</a>
                </div>
                <div class="collapse navbar-collapse" id="pageheader-navbar">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">系统管理 <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">用户管理</a></li>
                                <li><a href="#">角色管理</a></li>
                                <li><a href="#">菜单管理</a></li>
                                <li><a href="#">组件管理</a></li>
                            </ul>
                        </li>
                    </ul>
                    <div class="nav navbar-nav navbar-right">
                        <a href="#" class="btn btn-link navbar-btn">登录</a>
                        <a href="#" class="btn btn-link navbar-btn">注册</a> 
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div class="pagecontent" style="margin-top: 70px;">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2" id="accordion">
					<ul class="list-group">
					   <li class="list-group-item active">用户管理</li>
					   <li class="list-group-item">角色管理</li>
					   <li class="list-group-item">
                            <div data-target="#systemSetting" class="text-primary collapsed" data-toggle="collapse">
                                <span class="glyphicon glyphicon-cog"></span> 菜单管理
                                <span class="glyphicon glyphicon-chevron-down pull-right"></span>
                            </div>
                            <ul id="systemSetting" class="nav nav-list collapse secondmenu" style="height: 0px;">
                                <li class="active"><a href="#"><span class="glyphicon glyphicon-user"></span> 用户管理</a></li>
                                <li><a href="#"><span class="glyphicon glyphicon-th-list"></span> 菜单管理</a></li>
                                <li><a href="#"><span class="glyphicon glyphicon-asterisk"></span> 角色管理</a></li>
                                <li><a href="#"><span class="glyphicon glyphicon-edit"></span> 修改密码</a></li>
                                <li><a href="#"><span class="glyphicon glyphicon-eye-open"></span> 日志查看</a></li>
                            </ul>
                       </li>
					   <li class="list-group-item">组件管理</li>
					   <li class="list-group-item">系统管理</li>
					   
					</ul>
                </div>
                <div class="col-md-10">
                    <ul class="breadcrumb">
                        <li><a href="#">A</a></li>
                        <li><a href="#">B</a></li>
                        <li><a href="#">C</a></li>
                    </ul>
                    <div class="panel panel-default">
                        <div class="panel-heading">用户列表</div>
                        <table class="table table-bordered table-hover table-condensed">
                            <thead>
                                <tr>
                                    <th>姓名</th>
                                    <th>年龄</th>
                                    <th>Email</th>
                                    <th>地址</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>A</td>
                                    <td>B</td>
                                    <td>C</td>
                                    <td>D</td>
                                </tr>
                                <tr>
                                    <td>A</td>
                                    <td>B</td>
                                    <td>C</td>
                                    <td>D</td>
                                </tr>
                                <tr>
                                    <td>A</td>
                                    <td>B</td>
                                    <td>C</td>
                                    <td>D</td>
                                </tr>
                                <tr>
                                    <td>A</td>
                                    <td>B</td>
                                    <td>C</td>
                                    <td>D</td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="panel-footer">
                            <div class="row">
                                <div class="col-md-6">
		                            <ul class="pagination">
		                                <li><a href="#">&laquo;</a></li>
		                                <li><a href="#">1</a></li>
		                                <li><a href="#">2</a></li>
		                                <li class="active"><a href="#">3</a></li>
		                                <li><a href="#">4</a></li>
		                                <li><a href="#">5</a></li>
		                                <li><a href="#">6</a></li>
		                                <li><a href="#">7</a></li>
		                                <li><a href="#">8</a></li>
		                                <li><a href="#">9</a></li>
		                                <li><a href="#">10</a></li>
		                                <li><a href="#">&raquo;</a></li>
		                            </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</body>
</html>