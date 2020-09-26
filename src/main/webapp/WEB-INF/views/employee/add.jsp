<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- GLOBAL HEADER -->
<jsp:include page="../common/header.jsp" />

		<!-- COURSE OUTLINE COLUMN -->
		<div class="col-md-8">
			<h3 class="p-3">Add New Employee</h3>

			<div class="row">
				<div class="col-sm-12">
					<div class="card mb-2">
						<div class="card-body">

	<form:form action="${pageContext.request.contextPath }/employee/add"
		modelAttribute="employee">
		<div class="form-group">
			<label>Name </label> <form:input  class="form-control" path="name"/></div>
		<div class="form-group">
			<label>Mobile </label> <form:input  class="form-control" path="mobile"/></div>
		<div class="form-group">
			<label>Address </label> <form:input  class="form-control" path="address"/></div>
		<div class="form-group">
			<label>Grade </label> <br>
			 <form:radiobutton path="grade" value="One" />One 
			<form:radiobutton path="grade" value="Two" />Two
			 <form:radiobutton path="grade" value="Three" />Three 
			<form:radiobutton path="grade" value="Four" />Four
			 <form:radiobutton path="grade" value="Five" />Five 
			<form:radiobutton path="grade" value="Six" />Six</div>
		<div class="form-group">
			<label>Rank </label> <form:input  class="form-control" path="rank"/></div>
		<div class="form-group">
			<label>Account </label> <form:input class="form-control"  path="account"/></div>		 <br>

		<input type="submit" name="submit" value="Add">
	</form:form>

</div>
					</div>
				</div>

			</div>

		</div>

	</div>

</div>


<!-- GLOBAL FOOTER -->
<jsp:include page="../common/footer.jsp" />




