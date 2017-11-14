<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<c:if test="${not empty message}">
		<div class="row">
			<div class="col-xs-12 col-md-offset-2 col-md-8">
				<div class="alert alert-info fade in">${message}</div>
			</div>
		</div>
	</c:if>

	<div class="page-header">
		<h1>User Management</h1>
	</div>
	<div class="row">
		<div class='col-xs-12'>
			<table id="usersTable" class="table table-condensed table-bordered">
				<thead>
					<tr>
						<th>UserName</th>
						<th>Email</th>
						<th>Contact No.</th>
						<th>Address</th>
						<th>Activate</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${userList}" var="user">
						<tr>

							<td>${user.username}</td>
							<td>${user.email}</td>
							<td>${user.contactNo}</td>
							<td>${user.address}</td>
							<td>
							<c:if test="${user.enabled==true}">
								<label class="switch"> <input type="checkbox"
											value="${user.username}"
											onchange="enableUser(this)" checked="checked">
											<div class="slider round"></div></label>
								</c:if>
								
								<c:if test="${user.enabled==false}">
								<label class="switch"> <input type="checkbox"
											value="${user.username}"
											onchange="enableUser(this)" >
											<div class="slider round"></div></label>
								</c:if>
								
								
								
								</td>
							
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th>UserName</th>
						<th>Email</th>
						<th>Contact No.</th>
						<th>Address</th>
						<th>Activate</th>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</div>