<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
</head>
<body>
    User: <shiro:principal/>
    <br/>
    <shiro:hasPermission name="Menu:SysMenu">
        hasPermission: Menu:SysMenu<br/>
    </shiro:hasPermission>
    
    <shiro:hasRole name="Programmer">
        hasRole: Programmer<br/>
    </shiro:hasRole>
    
    <shiro:hasPermission name="Menu:MenuMenu">
        hasPermission: Menu:MenuMenu<br/>
    </shiro:hasPermission>
    
</body>
</html>