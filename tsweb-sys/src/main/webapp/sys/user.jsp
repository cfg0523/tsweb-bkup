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
<script type="text/javascript" src="<c:url value="/static/js/jquery.form.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/bootstrap/js/bootstrap.js"/>"></script>

<style type="text/css">
    .nav-tabs {
        border-bottom: 0;
    }
    
    .tab-close {
        margin-left: 0.8em;
    }
</style>

<script type="text/javascript">
$(function(){
    var $navtabHeader = $('#navtab-header');
    var $navtabContent = $('#navtab-content');
    var $mainmodal = window.top.$('#mainmodal');
    
    $navtabHeader.on('click', 'a', function(e){
        $(this).tab('show');
    });
    
    $('a.modal-trigger').on('click', function(e) {
        e.preventDefault();
        $.get(this.href, function(html) {
            $mainmodal.html(html).find('.modal').modal({
                backdrop: 'static'
            });
        });
    });
    
    $('a.delete-trigger').on('click', function(e) {
        e.preventDefault();
        $.get(this.href, function(json) {
            if (json.success) {
	            window.location.reload();
            }
        });
    });
});
</script>

</head>
<body>
    <div class="navtab">
	    <ul class="nav nav-tabs" id="navtab-header">
	        <li class="active"><a href="#tab-pane-user-list">用户列表</a></li>
	    </ul>
	    <div class="tab-content" id="navtab-content">
	        <div class="tab-pane active" id="tab-pane-user-list">
	            <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="btn-group pull-right">
                            <a href="<c:url value="/sys/user/add"/>" class="btn btn-primary modal-trigger">添加</a>
                        </div>
                    </div>
	                <table class="table table-bordered table-responsive table-hover">
	                    <thead>
	                        <tr>
	                            <th>用户名</th>
	                            <th>密码</th>
	                            <th>操作</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                        <c:forEach items="${users}" var="user">
	                            <tr>
	                                <td>${user.username}</td>
	                                <td>${user.password}</td>
	                                <td>
	                                    <a class="modal-trigger" href="<c:url value="/sys/user/${user.id}"/>">查看</a>
	                                    <a class="modal-trigger" href="<c:url value="/sys/user/update/${user.id}"/>">修改</a>
	                                    <a class="delete-trigger" href="<c:url value="/sys/user/delete/${user.id}"/>">删除</a>
	                                </td>
	                            </tr>
	                        </c:forEach>
	                    </tbody>
	                </table>
                    <div class="panel-body"></div>
	            </div>
	        </div>
	   </div>
    </div>
</body>
</html>

