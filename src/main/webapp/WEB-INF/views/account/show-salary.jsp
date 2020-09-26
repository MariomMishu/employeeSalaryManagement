<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- GLOBAL HEADER -->
<jsp:include page="../common/header.jsp" />

		<!-- COURSE OUTLINE COLUMN -->
		<div class="col-md-8">
			<h3 class="p-3">Show Employee Salary</h3>

			<div class="row">
				<div class="col-sm-12">
					<div class="card mb-2">
						<div class="card-body ">
						<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-dark">
		<tr>
			<th>Sl.</th>
			<th>Name</th>
			<th>Rank</th>
			<th>Salary</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${employee_list }" var="employee">
			<tr>
			
				<th>${ employee.id }</th>
				<th>${ employee.name }</th>
				<th>${ employee.rank }</th>
			    <th>${ employee.salary }</th>
				
				<th><a href="#">Transaction </a></th>
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




