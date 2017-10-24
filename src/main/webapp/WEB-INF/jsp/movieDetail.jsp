<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="${movie.title}"/>

<%@include file="common/header.jspf" %>

	<div class="content-container">
		<div class="image-container"> <div class="image-holder"> <h4>image coming soon ...</h4> </div> </div>
		<div class="info-container">
			<h2><c:out value="${pageTitle}" /></h2> 
			
			<p>Release Date: <c:out value="${movie.formatedDate}" /> </p>
			
			<c:choose>
    			<c:when test="${movie.availableCopies > 0}">
       				<c:url var="processFormLink" value="/addMovieToCart" />
       				<form method="POST" action="${processFormLink}">
					<input type="hidden" name="id" value="${movie.id}" />
					<input type="submit" value="Add to Cart" />
				</form>
    			</c:when>    
   				 <c:otherwise>
       				<p class="error">Out of Stock</p> 
		      	</c:otherwise>
				</c:choose>
		</div>
	</div>

<%@include file="common/footer.jspf" %>
