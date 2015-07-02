<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp"%>

<div class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
                <h4 class="modal-title">修改用户</h4>
            </div>
            <div class="modal-body">
	            <form action="<c:url value="/sys/user/update/${user.id}"/>" class="form-horizontal" id="form-user-update">
	                <div class="form-group">
	                    <label class="control-label col-md-2" for="id">用户Id:</label>
	                    <div class="col-md-8">
	                        <input type="text" class="form-control" name="id" readonly value="${user.id}"/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="control-label col-md-2" for="username">用户名:</label>
	                    <div class="col-md-8">
	                        <input type="text" class="form-control" name="username" value="${user.username}"/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="control-label col-md-2" for="password">密　码:</label>
	                    <div class="col-md-8">
	                        <input type="text" class="form-control" name="password" value="${user.password}"/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <div class="col-md-offset-2 col-md-8">
	                        <button type="submit" class="btn btn-primary">保存</button>
	                    </div>
	                </div>
	            </form>
            </div>
        </div>
    </div>
</div>



<script type="text/javascript">
$(function() {
    $('#form-user-update').on('submit', function(e) {
        var $this = $(this);
        $this.ajaxSubmit({
            url: $this.attr('action'),
            type: 'post',
            dataType: 'json',
            success: function(json) {
                if (json.success) {
                    
                }
            }
        });
        return false;
    });
});
</script>
