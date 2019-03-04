<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="util.*"%>
<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!--  <link href="/static/css/bootstrap.min.css" rel="stylesheet">  -->

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h4>Recipe List</h4>
				<div class="table-responsive">
					<table class="table table-bordred table-striped">

						 <thead>

							<th>Recipes</th>
							<th>Link</th>
							<th>Ingredients</th>
							<th>Images</th>
						</thead>
						 <tbody>
						<%
							Utility obj = new Utility();
							List<Recipe> relist = obj.readRecipeJson();
							java.util.Iterator<Recipe> itr = relist.iterator();
                             
							Recipe recipeObj;

							while (itr.hasNext()) {
								recipeObj = itr.next();
								System.out.println(recipeObj.getTitle());
						%>
						<tr>
							<td><%=recipeObj.getTitle()%></td>
							<td><a href=<%=recipeObj.getHref()%>>Click Here</td>
							<td><%=recipeObj.getIngredients()%></td>
							<td><p data-placement="top" data-toggle="tooltip" title="click">
							<a href=<%=recipeObj.getStrthumbnail()%>><span class="glyphicon glyphicon-picture"></span></a>
							
							</td></tr>
							<%	
}
%>
						
						</tbody>
					</table>
				</div>

			</div>
		</div>
	</div>

</body>
</html>