<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
</head>
<body>
    User: <shiro:principal/><br/>
    
    <shiro:hasPermission name="menu:sys">
        hasPermission: menu:sys<br/>
    </shiro:hasPermission>
    
    <shiro:hasRole name="programmer">
        hasRole: programmer<br/>
    </shiro:hasRole>
    
    <shiro:hasPermission name="menu:menu">
        hasPermission: menu:menu<br/>
    </shiro:hasPermission>
    
    <shiro:hasPermission name="sys:main:main">
        hasPermission: sys:main:main
    </shiro:hasPermission>
    
</body>
</html>