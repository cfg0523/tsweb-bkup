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
    
    #pagebody {
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
                    <a href="<c:url value="${brandMenu.path}"/>" class="navbar-brand">${brandMenu.desc}</a>
                </div>
                <div class="collapse navbar-collapse" id="pageheader-navbar">
                    <ul class="nav navbar-nav" id="pagenavbar">
                        <c:forEach items="${brandMenu.subMenus}" var="moduleMenu">
                            <c:choose>
                                <c:when test="${empty moduleMenu.path}">
                                    <li class="dropdown">
                                        <a href="<c:url value="${moduleMenu.path}"/>" class="dropdown-toggle" data-toggle="dropdown">
                                            ${moduleMenu.desc} <span class="caret"></span>
                                        </a>
                                        <ul class="dropdown-menu">
                                            <c:forEach items="${moduleMenu.subMenus}" var="subModuleMenu">
                                                <li><a href="<c:url value="${subModuleMenu.path}"/>">${subModuleMenu.desc}</a></li>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="<c:url value="${moduleMenu.path}"/>">${moduleMenu.desc}</a></li>
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
    
    <div id="pagebody">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2 col-sm-2" id="pageaside"></div>
                <div class="col-md-10 col-sm-10" id="pagecontent"></div>
            </div>
        </div>
    </div>
    
    <script type="text/javascript">
    $(function() {
        var $pagecontent = $('#pagecontent');
        var $pageaside = $('#pageaside').on('click', '.list-group-item a', function(e) {
            e.preventDefault();
            $.get(this.href, function(html) {
                $pagecontent.empty().html(html);
            });
        });
        var $pagenavbar = $('#pagenavbar').on('click', 'a:not(".dropdown-toggle")', function(e) {
            e.preventDefault();
            $.get(this.href, function(html) {
                $pageaside.empty().html(html);
            });
        });
    });
    </script>
</body>
</html>