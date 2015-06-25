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

<style type="text/css">
    #pageheader {
        background-color: #222;
    }
    
    #pagecontent {
        margin-top: 70px;
    }
</style>

<title>Main</title>
</head>
<body>

    <div id="pageheader">
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#pageheader-navbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="#" class="navbar-brand">TSWEB</a>
                </div>
                <div class="collapse navbar-collapse" id="pageheader-navbar">
                    <ul class="nav navbar-nav">
                        <c:forEach items="${navbarTopMenus}" var="menu">
                        <c:choose>
                            <c:when test="${menu.subMenus.size() > 0}">
                                <li class="dropdown">
                                    <a href="<c:url value="${menu.path}"/>" class="dropdown-toggle" data-toggle="dropdown">
                                        ${menu.desc} <span class="caret"></span>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <c:forEach items="${menu.subMenus}" var="subMenu">
                                            <li><a href="<c:url value="${subMenu.path}"/>">${subMenu.desc}</a></li>
                                        </c:forEach>
                                    </ul>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="<c:url value="${menu.path}"/>">${menu.desc}</a></li>
                            </c:otherwise>
                        </c:choose>
                        </c:forEach>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <shiro:principal/> <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-right">
                                <li><a href='<c:url value="/sys/logout"/>'>退出</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    
    <div id="pagecontent">
        <div class="col-md-2">
            <ul class="list-group">
                <li class="list-group-item">
                    <div class="collapsed" data-toggle="collapse" data-target="#qareport-daily-menus">
                        <span>Daily</span>
                        <span class="glyphicon glyphicon-chevron-down pull-right"></span>
                    </div>
                    <ul class="nav nav-list collapse" id="qareport-daily-menus">
                        <li><a href="#">PO Daily</a></li>
                        <li><a href="#">DFT Daily</a></li>
                        <li><a href="#">AQL Daily</a></li>
                        <li><a href="#">PKG Daily</a></li>
                        <li><a href="#">TECH Daily</a></li>
                    </ul>
                </li>
                <li class="list-group-item">
                    <div class="collapsed" data-toggle="collapse" data-target="#qareport-datail-menus">
                        <span>Detail</span>
                        <span class="glyphicon glyphicon-chevron-down pull-right"></span>
                    </div>
                    <ul class="nav nav-list collapse" id="qareport-datail-menus">
                        <li><a href="#">PO Detail</a></li>
                        <li><a href="#">DFT Detail</a></li>
                        <li><a href="#">AQL Detail</a></li>
                        <li><a href="#">PKG Detail</a></li>
                        <li><a href="#">TECH Detail</a></li>
                    </ul>
                </li>
                <li class="list-group-item">
                    <div class="collapsed" data-toggle="collapse" data-target="#qareport-master-menus">
                        <span>Master</span>
                        <span class="glyphicon glyphicon-chevron-down pull-right"></span>
                    </div>
                    <ul class="nav nav-list collapse" id="qareport-master-menus">
                        <li><a href="#">Defect Master</a></li>
                        <li><a href="#">Status Master</a></li>
                        <li><a href="#">Tech Master</a></li>
                        <li><a href="#">Model Master</a></li>
                        <li><a href="#">Customer Master</a></li>
                        <li><a href="#">Package Master</a></li>
                    </ul>
                </li>
                <li class="list-group-item">
                    <div class="collapsed" data-toggle="collapse" data-target="#qareport-report-menus">
                        <span>Report</span>
                        <span class="glyphicon glyphicon-chevron-down pull-right"></span>
                    </div>
                    <ul class="nav nav-list collapse" id="qareport-report-menus">
                        <li><a href="#">For Report Generation</a></li>
                        <li><a href="#">Generate Report</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="col-md-10"></div>
    </div>
</body>
</html>