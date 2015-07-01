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

<script type="text/javascript">
$(function(){
    $('.nav-tabs a').on('click', function(e){
        $(this).tab('show');
    });
    
});
</script>
</head>
<body>
    <div>
        <ul class="nav nav-tabs" style="border-bottom:0;">
            <li class="active"><a href="#tab-pane-rolelist">角色列表</a></li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane active" id="tab-pane-rolelist">
                <div class="panel panel-default">
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>RoleName</th>
                                <th>RoleDesc</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${roles}" var="role">
                                <tr>
                                    <td>${role.id}</td>
                                    <td>${role.name}</td>
                                    <td>${role.desc}</td>
                                    <td>
                                        <a href="<c:url value="/sys/role/${role.id}"/>">查看</a>
                                        <a href="<c:url value="/sys/role/update/${role.id}"/>">修改</a>
                                        <a href="<c:url value="/sys/role/delete/${role.id}"/>">删除</a>
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

