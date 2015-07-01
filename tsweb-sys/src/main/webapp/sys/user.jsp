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
    var $navtabHheader = $('#navtab-header');
    var $navtabContent = $('#navtab-content');
    
    $navtabHheader.on('click', 'a', function(e){
        $(this).tab('show');
    });
    
    $('a.tab-trigger').on('click', function(e){
        e.preventDefault();
        var $this = $(this);
        var tabpaneid = $this.attr('tab-pane-id');
        var tabpanelabel = $this.attr('tab-pane-label');
        var $taba = $navtabHheader.find('a[href*="' + tabpaneid + '"]');
        if ($taba.size() > 0) {
            $taba.tab('show');
        } else {
            $.post(this.href, function(html) {
                $navtabHheader.find('li.active').removeClass('active');
                $navtabContent.find('.tab-pane.active').removeClass('active');
                
                var $tabclose = $('<span class="glyphicon glyphicon-remove tab-close"/>');
                var $a = $('<a/>').attr('href', '#' + tabpaneid).text($this.text() + tabpanelabel).append($tabclose);
                $navtabHheader.append($('<li class="active"/>').append($a));
                
                $navtabContent.append($('<div class="tab-pane active"/>').attr('id', tabpaneid).html(html));
            });
        }
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
	                                    <a class="tab-trigger" tab-pane-id="tab-pane-user-view" tab-pane-label="用户:${user.id}" href="<c:url value="/sys/user/${user.id}"/>">查看</a>
	                                    <a href="<c:url value="/sys/user/update/${user.id}"/>">修改</a>
	                                    <a href="<c:url value="/sys/user/delete/${user.id}"/>">删除</a>
	                                </td>
	                            </tr>
	                        </c:forEach>
	                    </tbody>
	                </table>
	            </div>
	        </div>
	   </div>
    </div>
</body>
</html>

