<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://www.jquery-az.com/boots/css/bootstrap-multiselect/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript"
	src="https://www.jquery-az.com/boots/js/bootstrap-multiselect/bootstrap-multiselect.js"></script>


</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h4>Ingredient List</h4>
				<script type="text/javascript">
    $(document).ready(function() {
        $('#multi-select-demo').multiselect();
    });
</script>

				<form:form action="/list" method="post">
					<select multiple="multiple" id="multi-select-demo" name="SELECTED_INGREDIENT">
						<c:forEach items="${INGREDIENTS_LIST}" var="LIST">

							<option value="${LIST}"><c:out value="${LIST}" /></option>

						</c:forEach>
					</select>
					
					<input type="submit" value="Search Recipe">

				</form:form>

			</div>
		</div>
	</div>




</body>
</html>