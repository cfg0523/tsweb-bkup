<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/static/bootstrap/css/bootstrap.css"/>"/>
	<script type="text/javascript" src="<c:url value="/static/js/jquery.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/static/bootstrap/js/bootstrap.js"/>"></script>
	
	<title>Login</title>
</head>
<body>
    <div class="container-fluid">
        <h1>TSWEB</h1>
        <div class="row">
            <div class="col-lg-2">Nav</div>
            <div class="col-lg-10">Content
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="email" class="col-lg-2">Email</label>
                        <div class="col-lg-10">
                            <input type="emaill" class="form-control" id="email" placeholder="Email"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-lg-2">Password</label>
                        <div class="col-lg-10">
	                        <div class="input-group">
	                            <div class="input-group-addon">$</div>
	                            <input type="password" class="form-control" id="password" placeholder="Password"/>
	                            <div class="input-group-addon">.00</div>
	                        </div>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>