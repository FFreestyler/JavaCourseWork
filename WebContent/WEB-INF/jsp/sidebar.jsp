<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div id="sidebar" class="sidebar-toggle">
	<ul class="nav nav-sidebar">
		<li role="separator" class="divider"></li>
		<!-- chart types -->
		<li data-toggle="collapse" href="#chart-types" aria-expanded="false"
			aria-controls="chart-types"><a href="#"> 
			<i class="fa fa-area-chart" aria-hidden="true"></i><span>USAGE TYPES</span>
		</a></li>
		<li>
			<ul id="chart-types" class="sub-menu collapse ${fn:contains(pageContext.request.requestURI,'chart-types') ? 'in' : ''}">
				<li><a href="${pageContext.request.contextPath}/chart-types/line1">Memory Chart</a></li>
                                <li><a href="${pageContext.request.contextPath}/chart-types/line2">CPU Chart</a></li>
                                <li><a href="${pageContext.request.contextPath}/chart-types/line3">DISK Chart</a></li>
			</ul>
	</ul>
</div>