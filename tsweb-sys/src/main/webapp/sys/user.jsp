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
    //var $mymodal = $(window.top.document.getElementById('mainmodal'));
    var $mymodal = $('#mymodal');
    var $navtabHeader = $('#navtab-header');
    var $navtabContent = $('#navtab-content');
    
    $navtabHeader.on('click', 'a', function(e){
        $(this).tab('show');
    });
    
    $('a.tab-trigger').on('click', function(e){
        e.preventDefault();
        var $this = $(this);
        var tabpaneid = $this.attr('tab-pane-id');
        var tabpanelabel = $this.attr('tab-pane-label');
        var $taba = $navtabHeader.find('a[href*="' + tabpaneid + '"]');
        if ($taba.size() > 0) {
            $taba.tab('show');
        } else {
            $.get(this.href, function(html) {
                $navtabHeader.find('li.active').removeClass('active');
                $navtabContent.find('.tab-pane.active').removeClass('active');
                
                var $tabclose = $('<span class="glyphicon glyphicon-remove tab-close"/>');
                var $a = $('<a/>').attr('href', '#' + tabpaneid).text($this.text() + tabpanelabel).append($tabclose);
                var $li = $('<li class="active"/>').append($a);
                var $div = $('<div class="tab-pane active"/>').attr('id', tabpaneid).html(html);
                
                $navtabHeader.append($li);
                $navtabContent.append($div);
                
                $tabclose.on('click', function() {
                    $li.detach();
                    $div.detach();
                    $navtabHeader.find('li:first a').tab('show');
                });
            });
        }
    });
    
    $('a.modal-trigger').on('click', function(e) {
        e.preventDefault();
        $.get(this.href, function(html) {
            $mymodal.html(html).find('.modal').modal({
                backdrop: 'static'
            });
        });
    });
    
});
</script>

</head>
<body>
    
    <div id="mymodal"></div>

    <div class="navtab">
	    <ul class="nav nav-tabs" id="navtab-header">
	        <li class="active"><a href="#tab-pane-user-list">用户列表</a></li>
	    </ul>
	    <div class="tab-content" id="navtab-content">
	        <div class="tab-pane active" id="tab-pane-user-list">
	            <div class="panel panel-default">
	                <div class="panel-body">
	                   <div class="btn-group pull-right">
	                       <button class="btn btn-primary">添加</button>
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
	                                    <a class="tab-trigger" tab-pane-id="tab-pane-viewuser-${user.id}" tab-pane-label="用户:${user.username}" href="<c:url value="/sys/user/${user.id}"/>">查看</a>
	                                    <a class="modal-trigger" href="<c:url value="/sys/user/update/${user.id}"/>">修改</a>
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

