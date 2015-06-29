<%@ include file="include.jsp"%>

<div class="panel panel-default">
    <div class="panel-heading">${rootMenu.desc}</div>
    <ul class="list-group">
        <c:forEach items="${rootMenu.subMenus}" var="appMenu">
            <c:choose>
                <c:when test="${empty appMenu.path}">
                    <li class="list-group-item">
                        <div class="collapsed" data-toggle="collapse" data-target="#collapse-menu-${appMenu.name}">
                            <span>${appMenu.desc}</span>
                            <span class="glyphicon glyphicon-chevron-down pull-right"></span>
                        </div>
                        <ul class="nav nav-list collapse" id="collapse-menu-${appMenu.name}">
                            <c:forEach items="${appMenu.subMenus}" var="menuItem">
                                <li><a href="<c:url value="${menuItem.path}"/>" menu-name="${menuItem.name}">${menuItem.desc}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="list-group-item">
                        <a href="<c:url value="${appMenu.path}"/>" menu-name="${appMenu.name}">${appMenu.desc}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </ul>
</div>
