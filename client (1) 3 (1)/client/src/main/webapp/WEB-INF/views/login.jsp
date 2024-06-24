<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<tags:master  heading="User Login Page" title=" User Login Page">
<jsp:attribute name="header">

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link href="${pageContext.request.contextPath}/styles/userLogin.css"
	rel="stylesheet">
<style type="text/css">
.errors {
	color: red;
}

#inputId{
width: 300px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script >
$(document).ready(function(){
	$("#showPassword").click(function(){
		
	if($("#showPassword").is(":checked"))
		$("#password").prop("type","text");
	else
		$("#password").prop("type","password");
	});

});

</script>
</jsp:attribute>
<jsp:attribute name="content">

	<section class="login-block" style="padding:1px 1px 1px 1px;margin-left: 120%; width: 100%; margin-top: 100px;background: background-color: #96aeba; border-radius: 50px">
		<div class="container" style="width: 100%; margin-left:0%; ">
			<div class="col-md-12 login-sec" style="padding: 10px 20px 10px 20px; ">
				<h2 class="text-center" style="margin: 0px;color: #63849e">Login Now</h2>
				<form:form class="login-form" modelAttribute="userLogin">
					<table>
					<tr><td><p class="errors">${msg}</p></td></tr>
						<tr>
							<td ><div class="form-group"  >
									<label for="exampleInputEmail1" class="text-uppercase">UserId</label>
									<form:input path="id" class="form-control" placeholder="" id="inputId" type="text"/>
								</div></td>
							<td width="170px"><form:errors path="id" cssClass="errors" /></td>
						</tr>
						<tr>
							<td><div class="form-group" >
									<label for="exampleInputPassword1" class="text-uppercase">Password</label>
									<form:input path="password" type="password"
										class="form-control" placeholder="" id="password"/>
								</div></td>
							<td><form:errors path="password" cssClass="errors" /></td>
						</tr>
						<tr>
							<td><div class="form-check" style="padding-left: 60px" >
									<label class="form-check-label"> <input type="checkbox"
										class="form-check-input" id="showPassword"> <small >Show Password</small>
									</label>
							</div>
									
									</td>
						</tr>
									<tr>
									<td align="center" style="padding-top: 20px">
									<div class="form-check" >
									<input type="submit" class="btn btn-login " style="margin-left: 50px" value="Login"  formaction="validateUserLogin">
								</div>
								</td>
								</tr>
								<tr align="center">
								<td style="padding:20px 0px 0px 30px;">Don't Have Account Try To Register</td></tr>
								<tr>
								<td style="padding-top:20px;" align="center" >
								<div class="form-check" >
									<input type="submit"  class="btn btn-login " style="margin-left: 50px" value="Register" formaction="registration"/>
									</div>
								</td>
								</tr>
					</table>

				</form:form>
			</div>
			</div>
	</section>
</jsp:attribute>
</tags:master>
