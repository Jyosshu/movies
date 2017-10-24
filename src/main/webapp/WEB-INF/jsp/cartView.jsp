<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="${movie.title}"/>

<%@include file="common/header.jspf" %>

	<div class="content-container">
		<div class="table-container">
			<table>
				<c:forEach var="entry" items="${movieList}">
					<tr> 
						<td>
								(Future Remove Button)
						</td>
						<td> <c:out value="${entry.value.title}" /> </td>
					</tr>	
				</c:forEach>
			</table>
		</div>
		<div class="checkout-container">
			<c:url var="processFormLink" value="/view" />
			<form method="POST" action="${processFormLink}">
				<input type="hidden" name="id" value="${movie.id}" />
				<input type="submit" value="Checkout" class="login-button" />
			</form>
		</div>
	</div>
		
	<%@include file="common/footer.jspf" %>
	