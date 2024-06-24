<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<tags:home heading="User Regisration Page" title=" Registration Page">
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



.custom-shadow {
	box-shadow: 0 0 10px rgba(0, 123, 255, 0.3);
	/* Blue shadow effect, adjust as needed */
	border-radius: 10px; /* Rounded corners, adjust as needed */
	padding: 20px; /* Add padding for better appearance */
}

form {
	width: 700px;
	margin-left: 350px;
	height:20%;
}
label{
width: 100px;

}
 .radio-inline {
            display: inline-block;
            margin-right: 15px; /* Adjust the margin as needed for spacing */
        }
.success{
color: green;
}
</style>
<script>
	$(document).ready(function() {
		
		$.ajax({
			type: "GET",
			url:"http://localhost:8080/bankmanagement/branch/",
			dataType:"json",
			contentType:"application/json; charset=utf-8",
			success:function(msg){
				var str='<option value=""  disabled="true" selected="true">Select Branch Name</option>';
				for(var i=0;i<msg.length;i++){
					str+='<option value="'+msg[i].branchId+'">'+msg[i].branchName+'</option>';
				
					}
				$("#branch").empty().append(str);
			},
			error: function (jqXHR, exception) {
		        var msg = '';
		        if (jqXHR.status === 0) {
		            msg = 'Not connect.\n Verify Network.';
		        } else if (jqXHR.status == 404) {
		            msg = 'Requested page not found. [404]';
		        } else if (jqXHR.status == 500) {
		            msg = 'Internal Server Error [500].';
		        } else if (exception === 'parsererror') {
		            msg = 'Requested JSON parse failed.';
		        } else if (exception === 'timeout') {
		            msg = 'Time out error.';
		        } else if (exception === 'abort') {
		            msg = 'Ajax request aborted.';
		        } else {
		            msg = 'Uncaught Error.\n' + jqXHR.responseText;
		        }
		        alert(msg);
		    },
		});
		$("#showPassword").click(function() {

			if ($("#showPassword").is(":checked"))
				$("#password").prop("type", "text");
			else
				$("#password").prop("type", "password");
		});
		

	});
</script>
</jsp:attribute>
	<jsp:attribute name="content">
<form:form class="custom-shadow" modelAttribute="user" action="validRegistration">
    <h2 class="text-center">Registration Form</h2>
     <h2 class="success" align="center">${msg}</h2>
<table>
  <tr >
    <td colspan="2"><div class="col-md-3">
                <label for="userId" class="form-label">User Id:</label>
                <form:input type="text" class="form-control" id="userId"
								path="userId" style="width: 300px"  />
            </div>
   <span style="padding-left: 30px"><form:errors path="userId"  cssClass="errors"/></span>
            </td>
  </tr>
  <tr>
					<td  ><div class="col-md-3">
                <label for="firstName" class="form-label">First Name:</label>
                <form:input type="text" class="form-control"
								id="firstName" path="firstName" style="width: 300px"/>
            </div>
                <span style="padding-left: 30px"><form:errors path="firstName" cssClass="errors"/></span>
            </td>
					<td><div class="col-md-5">
                <label for="lastName" class="form-label">Last Name:</label>
                <form:input type="text" class="form-control"
								id="lastName" path="lastName" style="width: 300px" />
            </div>
                <span style="padding-left: 30px"><form:errors path="lastName" cssClass="errors" /></span>
                
            </td>
				</tr>
  <tr>
					<td  colspan="2" style="padding: 20px;"><div class="row mb-10">
            <div class="col-md-10">
                <label style="padding-left: 20px">Gender:</label>
                <div class="form-check radio-inline">
                    <form:radiobutton path="gender" value="MALE" class="form-check-input" />
                    <label class="form-check-label">Male</label>
                </div>
                <div class="form-check radio-inline">
                    <form:radiobutton path="gender" value="FEMALE" class="form-check-input" />
                    <label class="form-check-label">Female</label>
                </div>
                <form:errors path="gender" cssClass="errors"/>
            </div>
        </div>
    </td>
				</tr>
  <tr>
					<td><div class="col-md-4">
                <label for="dateOfBirth" class="form-label">Date Of Birth:</label>
                <form:input type="date" class="form-control"
								id="dateOfBirth" path="dateOfBirth" style="width: 300px" />
                </div>
                </td>
					<td><span style="padding-left: 30px"><form:errors path="dateOfBirth" cssClass="errors"/></span> </td>
				</tr>
				<tr>
					<td><div class="col-md-5">
                <label for="email" class="form-label">Email:</label>
                <form:input type="email" class="form-control" id="email"
								path="email" style="width: 300px" />
            </div>

            </td>
					<td><span style="padding-left: 30px"><form:errors path="email" cssClass="errors"/></span></td>
				</tr>
  <tr>
					<td><div class="col-md-5">
                <label for="phone" class="form-label">Phone:</label>
                <form:input type="number" class="form-control"
							id="phone" path="phoneNo" style="width: 300px"/>
            </div>
                
					</td>
					<td><span style="padding-left: 30px"><form:errors path="phoneNo" cssClass="errors"/></span></td>
				</tr>
  <tr>
					<td><div class="col-md-4">
                <label for="password" class="form-label">Password:</label>
                <form:input type="password" class="form-control"
								id="password" path="password" style="width: 300px"/>
            </div>
            </td>
					<td><span style="padding-left: 30px"><form:errors path="password" cssClass="errors"/></span></td>
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
					<td><div class="col-md-4">
                <label for="address" class="form-label">Address:</label>
                <form:input type="textarea" class="form-control"
								 path="address" style="width: 300px"/>
            </div>
            </td>
					<td><span style="padding-left: 30px"><form:errors path="address" cssClass="errors"/></span></td>
				</tr>
				<tr>
  <td><div class="row mb-3">
            <div class="col-md-4">
                <label for="branch" class="form-label">Branch : </label>
                <form:select path="branchId" class="form-select" id="branch" >
                    
                </form:select>
                <form:errors path="branchId" cssClass="text-danger"/>
            </div>
        </div></td>
  </tr>
    <tr>
					<td style="padding-left: 250px; padding-top: 20px;margin-left:50px;"><div class="col-md-4 text-center">
                <button type="submit" class="btn btn-primary">Register</button>
            </div></td>
					<td></td>
				</tr>
</table>
    </form:form>
<!-- Bootstrap JS (optional) -->
<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	</jsp:attribute>
</tags:home>
