<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp"%>

<div class="panel panel-default">
    <div class="panel-body">
        <form action="#" class="form-horizontal">
            <div class="form-group">
                <label class="control-label col-md-1">用户Id:</label>
                <div class="col-md-4">
                    <p class="form-control-static">${user.id}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-1">用户名:</label>
                <div class="col-md-4">
                    <p class="form-control-static">${user.username}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-1">密　码:</label>
                <div class="col-md-4">
                    <p class="form-control-static">${user.password}</p>
                </div>
            </div>
        </form>
    </div>
</div>
