<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- GLOBAL HEADER -->
<jsp:include page="../common/header.jsp" />

		<!-- COURSE OUTLINE COLUMN -->
		<div class="col-md-8">
			<h3 class="p-3">Edit Account Info</h3>

			<div class="row">
				<div class="col-sm-12">
					<div class="card mb-2">
						<div class="card-body">

	<form:form action="${pageContext.request.contextPath }/account/edit"
		modelAttribute="account">
		<form:input path="id" value="${account.id}" hidden="hidden" />
		<div class="form-group">
			<label>A/C Type:  </label><br>
		 <form:radiobutton path="acType" value="savings" />Savings 
			<form:radiobutton path="acType" value="current" />Current
			</div>
		<div class="form-group">
			<label>A/C Name </label><form:input class="form-control"  path="acName" value="${account.acName}"/></div>
		<div class="form-group">
			<label>A/C Number </label> <form:input class="form-control"  path="acNumber" value="${account.acNumber}"/></div>
		<div class="form-group">
			<label>Current Balance </label>
			 <form:input  path="balance" class="form-control" value="${account.balance}" style="text-align:right"/></div>
		<div class="form-group">
			<label>Bank </label> 
			<form:input class="form-control" value="${account.bank}" path="bank"/></div>
		<div class="form-group">
			<label>Branch</label>
			<form:input class="form-control" value="${account.branch}" path="branch"></form:input>
		</div>
		

		<input type="submit" class="btn btn-secondary" name="submit" value="Update">
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




