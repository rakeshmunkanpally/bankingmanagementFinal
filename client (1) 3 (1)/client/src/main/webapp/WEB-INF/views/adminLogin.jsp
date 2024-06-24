<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<tags:master heading="Admin Login Page" title="Admin Login Page">
	<jsp:attribute name="header">
<link href="${pageContext.request.contextPath}/styles/adminLogin.css"
			rel="StyleSheet">
			<!-- Font Awesome -->
<link
			href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
			rel="stylesheet" />
<!-- Google Fonts -->
<link
			href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
			rel="stylesheet" />
<!-- MDB -->
<link
			href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.1.0/mdb.min.css"
			rel="stylesheet" />
<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#showPassword").click(function() {

			if ($("#showPassword").is(":checked"))
				$("#pass").prop("type", "text");
			else
				$("#pass").prop("type", "password");
		});	});
</script>
    </jsp:attribute>
	<jsp:attribute name="content">
	<style>
	.form-floating{
	 border-radius:10px;
	 overflow:hidden;
	 }
	 footer {
            background-color:#5F9EA0 ;
            padding: 10px;
            text-align: center;
            color: #fff;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
          p {
            line-height: 1.6;
          
        } 
	</style>
	<div style="margin-left: 600px; background-color: #f2f2f2; margin-top: 120px; width: 600px; box-shadow: rgba(0, 0, 0, 0.3) 0px 19px 38px, rgba(0, 0, 0, 0.22) 0px 15px 12px;">
<div class="container-fluid ps-md-0" style="width: 500px; margin-left: 0px;">
<div class="col-md-1 col-lg-6"><div class="login d-flex  py-5" style="width: 700px"><div class="container"><div class="row"><div class="col-md-6 col-lg-8 mx-auto"> <h3 class="login-heading mb-3">Hey Admin!</h3>
              <form:form modelAttribute="adminLogin" action="validateAdmin">
              <table><tr><td><p class="errors">${msg}</p></td></tr><tr>
<td><div class="form-floating mb-3">
<form:input path="id" class="form-control" type="text" id="floatingInput" placeholder="Admin Id" />
<label for="floatingInput">Admin Id</label>
                </div></td>
    <td style="padding-left: 10px"><form:errors path="id"
														cssClass="errors" /></td>
  </tr>
  <tr>
													<td><div class="form-floating mb-3">
                <form:input path="password" type="password"
															class="form-control" id="pass" placeholder="Password" />
                  <label for="floatingPassword">Password</label>
                </div></td>
                
                <td style="padding-left: 10px"><form:errors
														path="password" cssClass="errors" /></td></tr><tr>
													<td><div class="form-check mb-3">
                  <input class="form-check-input" type="checkbox"
															value="" id="showPassword">
                  <label class="form-check-label"
															for="rememberPasswordCheck">
                    Show Password
                  </label>
                </div><td><td></td></tr><tr><td><div class="d-grid">
                  <button
															class="btn btn-lg btn-primary btn-login text-uppercase fw-bold mb-2"
															type="submit">Login</button>
                  <div class="text-center">
                  </div>
                </div></td><td width="180px"></td></tr>
</table>
              </form:form></div></div> </div></div></div></div></div>
              <footer style="margin-left: -10%;">
        <p>&copy; 2024 Bank Management System. All rights reserved.</p>
    </footer> 
    </jsp:attribute>
</tags:master>