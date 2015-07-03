<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp"%>

<div class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
                <h4 class="modal-title">添加用户</h4>
            </div>
            <div class="modal-body">
	            <form action="<c:url value="/sys/user/add"/>" class="form-horizontal" id="form-user-add">
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
    var $mainmodal = window.top.$('#mainmodal');
    var iframeWindow = window.top.pagecontent.window;
    $('#form-user-add').on('submit', function(e) {
        var $this = $(this);
        $this.ajaxSubmit({
            type: 'post',
            dataType: 'json',
            success: function(json) {
                $mainmodal.find('.modal').modal('hide');
                iframeWindow.location.reload();
            }
        });
        return false;
    });
});
</script>
