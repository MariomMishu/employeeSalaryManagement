<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Salary Management</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
</head>
<body>
<!-- COURSE COVER IMAGE -->
<img src="${pageContext.request.contextPath }/images/course_cover.jpg"
	height="200px" class="w-100" />


<!-- MAIN CONTENT OF THE PAGE -->
<div class="container">

	<div class="row">

		<!-- HOMEWORK COLUMN-->
		<div class="col-md-4">
			<h3 class="p-3">Java Assignment</h3>

			<div class="row">
				

				<div class="col-sm-12">
					<div class="card mb-2">
						<div class="card-body">
							<h4 class="card-title pb-3">Employee</h4>
							<p class="card-text">
								<a class="btn btn-success btn-lg btn-block" href="${pageContext.request.contextPath }/employee/add"
									role="button">Add Employee Info</a> <a
									class="btn btn-primary btn-lg btn-block"
									href="${pageContext.request.contextPath }/employee/show-all" role="button">List Of Employee</a>
							</p>
						</div>
					</div>
				</div>

				<div class="col-sm-12">
					<div class="card mb-2">
						<div class="card-body">
							<h4 class="card-title pb-3">Company</h4>
							<p class="card-text">
							
							<a class="btn btn-success btn-lg btn-block" href="${pageContext.request.contextPath }/account/add"
								role="button">Add Account</a> <a
								class="btn btn-primary btn-lg btn-block" href="${pageContext.request.contextPath }/account/show-all"
								role="button">Show Account List</a>
								<a class="btn btn-success btn-lg btn-block" href="${pageContext.request.contextPath }/basicSalary/add"
								role="button">Basic Salary Add</a> 
								<a class="btn btn-primary btn-lg btn-block" href="${pageContext.request.contextPath }/employee/show-salary"
								role="button">Calculate Salary</a>
							</p>
						</div>
					</div>
				</div>
				<%-- <div class="col-sm-12">
					<div class="card mb-2">
						<div class="card-body">
							<h4 class="card-title pb-3">Grade</h4>
							<p class="card-text">
								<a class="btn btn-success btn-lg btn-block" href="${pageContext.request.contextPath }/grade/add"
									role="button">Add New Grade</a> <a
									class="btn btn-primary btn-lg btn-block"
									href="${pageContext.request.contextPath }/grade/show-all" role="button">Show All Grade</a>
							</p>
						</div>
					</div>
				</div> --%>

			</div>

		</div>

