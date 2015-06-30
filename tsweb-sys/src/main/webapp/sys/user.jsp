<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp"%>

<div class="panel panel-default">
    <div class="panel-body">
        <div class="btn-group pull-right">
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
                        <a menu-name="user-add" href="<c:url value="/sys/user/${user.id}"/>">查看</a>
                        <a menu-name="user-update" href="<c:url value="/sys/user/update/${user.id}"/>">修改</a>
                        <a href="<c:url value="/sys/user/delete/${user.id}"/>">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="panel-body"></div>
</div>
