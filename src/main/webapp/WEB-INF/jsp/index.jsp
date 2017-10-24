<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Movies!"/>

<%@include file="common/header.jspf" %>

<%-- <h2><c:out value="${pageTitle}" /></h2> --%>

		<div class="content-container">
			
			<div class="movies">
			<h3>New Releases</h3>
				<c:forEach items="${movies}" var="tempMovie">
					<div class="movie-container">
						<ul class="movie-list">
							<li> 
								<c:url var="movieLink" value="/movieDetail/${tempMovie.id}" />
								<a href="${movieLink}"> <c:out value="${tempMovie.title}" /> </a>  - <c:out value="${tempMovie.formatedDate}" /> 
							</li>
						</ul>
					</div>
				</c:forEach>
			</div>
		</div>
<%@include file="common/footer.jspf" %>
