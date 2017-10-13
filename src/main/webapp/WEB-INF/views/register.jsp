<%@include file="./common/navbar.jsp"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">


	<div class="row">
<c:if test="${not empty registered}">
		<div class="row">
			<div class="col-xs-12 col-md-offset-2 col-md-8">
				<div class="alert alert-success fade in">${registered}</div>
			</div>
		</div>
	</c:if>
		<div class="col-md-6 col-md-offset-3">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Sign Up - Personal</h4>
				</div>

				<div class="panel-body">

					<sf:form method="POST" modelAttribute="user"
						class="form-horizontal" id="registerForm" action="${contextRoot}/membership">


				<%-- 		<div class="form-group">
							<label class="control-label col-md-4">First Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="firstName" class="form-control"
									placeholder="First Name" />
								<sf:errors path="firstName" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4">Last Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="lastName" class="form-control"
									placeholder="Last Name" />
								<sf:errors path="lastName" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Email</label>
							<div class="col-md-8">
								<sf:input type="text" path="email" class="form-control"
									placeholder="abc@zyx.com" />
								<sf:errors path="email" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Contact Number</label>
							<div class="col-md-8">
								<sf:input type="text" path="contactNumber" class="form-control"
									placeholder="XXXXXXXXXX" maxlength="10" />
								<sf:errors path="contactNumber" cssClass="help-block"
									element="em" />
							</div>
						</div> --%>
						
							<div class="form-group">
							<label class="control-label col-md-4">User Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="username" class="form-control"
									placeholder="username" maxlength="10" />
								<sf:errors path="username" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Password</label>
							<div class="col-md-8">
								<sf:input type="password" path="password" class="form-control"
									placeholder="Password" />
								<sf:errors path="password" cssClass="help-block" element="em" />
							</div>
						</div>

					<%-- 	<div class="form-group">
							<label class="control-label col-md-4">Confirm Password</label>
							<div class="col-md-8">
								<sf:input type="password" path="confirmPassword"
									class="form-control" placeholder="Re-type password" />
								<sf:errors path="confirmPassword" cssClass="help-block"
									element="em" />
							</div>
						</div> --%>

						<div class="form-group">
							<label class="control-label col-md-4">Select Role</label>
							<div class="col-md-8">
							
								<c:forEach var="role" items="${roles}">
									<label class="radio-inline"> 
								<sf:radiobutton
										path="roleName" value="${role}" checked="checked" /> ${role}
								</label>
								</c:forEach> 
							<%-- 	<label class="radio-inline">
								 <sf:radiobutton
										path="userRole" value="SUPPLIER" /> Supplier
								</label> --%>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
							<!-- 	<button type="submit" name="_eventId_billing"
									class="btn btn-primary">
									Next - Billing <span class="glyphicon glyphicon-chevron-right"></span>
								</button>
								 -->
									<button type="submit" name="submit"
									class="btn btn-primary">
									Submit<span class=""></span>
								</button>
							</div>
						</div>


					</sf:form>


				</div>


			</div>


		</div>


	</div>


</div>

<%@include file="./common/footer.jsp"%>
