<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp"%>

<div class="panel panel-default">
    <div class="panel-body">
        Role list
    </div>
    <table class="table table-bordered table-hover">
        <thead>
            <tr>
                <th>Id</th>
                <th>RoleName</th>
                <th>RoleDesc</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${roles}" var="role">
                <tr>
                    <td>${role.id}</td>
                    <td>${role.name}</td>
                    <td>${role.desc}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
