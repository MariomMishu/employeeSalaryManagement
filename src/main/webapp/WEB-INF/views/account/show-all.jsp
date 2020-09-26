<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- GLOBAL HEADER -->
<jsp:include page="../common/header.jsp" />

		<!-- COURSE OUTLINE COLUMN -->
		<div class="col-md-8">
			<h3 class="p-3"> Account List</h3>

			<div class="row">
				<div class="col-sm-12">
					<div class="card mb-2">
						<div class="card-body ">
						<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-dark">
		<tr>
			<th>Id</th>
			<th>A/c Name</th>
			<th>A/c Number</th>
			<th>A/c Type</th>
			<th>Current Balance</th>
			<th>Bank</th>
			<th>Branch</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${account_list }" var="account">
			<tr>
				<th>${ account.id }</th>
				<th>${ account.acName }</th>
				<th>${ account.acNumber }</th>
				<th>${ account.acType }</th>
				<th>${ account.balance }</th>
				<th>${ account.bank }</th>
				<th>${ account.branch }</th>
				
				<th><a href="edit?id=${ account.id }">Edit</a>
				<a href="delete?id=${ account.id }">Delete</a></th>
			</tr>
		</c:forEach>
	</table></div>

</div>
					</div>
				</div>

			</div>

		</div>

	</div>

</div>


<!-- GLOBAL FOOTER -->
<jsp:include page="../common/footer.jsp" />




