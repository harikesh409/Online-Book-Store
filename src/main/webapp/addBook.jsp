<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/lib/bootstrap.min.css">
</head>
<body>
	<jsp:include page="adminHeader.jsp"></jsp:include>
	<div class="container">
		<h2>Add Book</h2>
		<hr />
		<form action="AddBook" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-md-6 col-12">
					<div class="form-group">
						<label for="isbn">ISBN Number</label> <input type="number"
							id="isbn" class="form-control" name="isbn"
							placeholder="ISBN Number" required />
					</div>
				</div>
				<div class="col-md-6 col-12">
					<div class="form-group">
						<label for="title">Book Title</label> <input type="text"
							id="title" class="form-control" placeholder="Book Title"
							name="title" required />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 col-12">
					<div class="form-group">
						<label for="author">Author</label> <input type="text" id="author"
							class="form-control" placeholder="Author" name="author" required />
					</div>
				</div>
				<div class="col-md-6 col-12">
					<label for="publisher">Publisher</label> <input type="text"
						class="form-control" id="publisher" placeholder="Publisher"
						name="publisher" required />
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 col-12">
					<div class="form-group">
						<label for="category">Book Category</label> <select
							name="category" id="category" class="form-control" required>
							<option value="" disabled selected>Select Category</option>
							<option value="novel">Novel</option>
							<option value="engg">Engineering</option>
							<option value="medic">Medical</option>
							<option value="arts">Arts &amp; Photography</option>
							<option value="cooking">Cooking</option>
							<option value="others">Others</option>
						</select>
					</div>
				</div>
				<div class="col-md-6 col-12">
					<div class="form-group">
						<label for="price">Price</label> <input type="number"
							class="form-control" id="price" step=".01" placeholder="Price"
							name="price" required />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 col-12">
					<div class="form-group">
						<label for="description">Description</label>
						<textarea name="description" id="description" cols="20" rows="5"
							class="form-control" placeholder="Description" required></textarea>
					</div>
				</div>
				<div class="col-md-6 col-12">
					<label for="inStock">Number of Books in Stock</label> <input
						type="number" class="form-control" id="inStock"
						placeholder="Number of Books in Stock" name="inStock" required />
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="form-group">
						<label for="cover">Cover Image<span class="text-danger">*</span></label>
						<input type="file" class="form-control-String" id="cover"
							accept="image/*" name="cover" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-12 ">
					<input type="submit"
						class="btn btn-outline-primary btn-lg d-block mx-auto"
						value="Add Book" />
				</div>
			</div>
		</form>
	</div>
	<script src="assets/js/script.js"></script>
</body>
</html>