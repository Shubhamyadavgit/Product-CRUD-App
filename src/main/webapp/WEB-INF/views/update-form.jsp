<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="./base.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>
	<h1 class="text-center">Change Product Details</h1>
	<div class="container text-center mt-3 ml-20 mr-20">
		<form action="${pageContext.request.contextPath }/handleUpdateproduct" method="post">
		<input type="hidden" name="id" value="${product.id}" />
		
			<div class="form-group">
				<label for="productname">Product Name</label> <input type="text"
					class="form-control" id="productname" aria-describedby="emailHelp"
					placeholder="Enter product name" name="name"
					value="${product.name }"
					>
			</div>
			<div class="form-group">
				<label for="description">Description</label>
				<textarea class="form-control" id="description"
					placeholder="Add description " name="description">${product.description }
				</textarea>
			</div>
			<div class="form-group">
				<label for="price">Price</label> <input type="text"
					class="form-control" id="price" placeholder="Enter price"
					name="price" value="${product.price }">
			</div>
			<div class="container text-center">
				<a href="${pageContext.request.contextPath }/index"
					class="btn btn-outline-danger">Back</a>
				<button type="submit" class="btn btn-outline-warning">Update</button>
			</div>
		</form>
	</div>
</body>
</html>