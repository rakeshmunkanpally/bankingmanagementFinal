<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tags:adminHome heading="Applications" title="Admin Home Page">
<jsp:attribute name="header">
<style type="text/css">
td{
 padding: 0px 0px 0px 0px;
}
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>

$(document).ready(function(){
	$("button").click(function(){
		var userId=$(this).attr("name");
		$("button[name="+userId+"]").remove();
		var status=$(this).val();
		if(status==="A"){
		$("#"+userId).html("Accepted");
		}
		else{
			$("#"+userId).html("Rejected");
		}
		$.ajax({
			type: "PUT",
			url:"http://localhost:8080/bankmanagement/admin/userstatus/"+status+"/"+userId,
			dataType:"json",
			contentType:"application/json; charset=utf-8",
			success:function(msg){
				alert(msg.message);
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
		        $('#'+userId).html(msg);
		    },
		});
	});
	
});

</script>



</jsp:attribute>
	<jsp:attribute name="content">

<div class="table-responsive" style="width: 1300px;  ">
 <table class="table"  style="font-size:medium; align-content: center; padding: 0%;" >
 <thead class="thead-light">
 <tr align="center">
 <th scope="col">User Id</th>
 <th scope="col">First Name</th>
 <th scope="col">Last Name</th>
 <th scope="col">Phone Number</th>
  <th scope="col">Email</th>
   <th scope="col">Gender</th>
    <th scope="col">Date Of Birth</th>
    <th scope="col">Address</th>
     <th scope="col">Status</th>
 </tr>
 </thead>
 <tbody class="customtable">
 <c:forEach var="user" items="${userList}">
 <tr align="center" >
 
 <td style="padding: 2px 0px 0px 0px; ">${user.userId}</td>
 <td style="padding: 2px 0px 0px 0px;">${user.firstName}</td>
 <td style="padding: 2px 0px 0px 0px;">${user.lastName}</td>
<td style="padding: 2px 0px 0px 0px;"> ${user.phoneNo}</td>
 <td style="padding: 2px 0px 0px 0px;">${user.email}</td>
 <td style="padding: 2px 0px 0px 0px;">${user.gender}</td>
 <td style="padding: 2px 0px 0px 0px;">${user.dateOfBirth}</td>
<td style="padding: 2px 0px 0px 0px;">${user.address}</td>
<td style="padding: 2px 0px 0px 0px; height: 40px; width: 20%;" id="${user.userId}"><button type="button" class="btn btn-outline-success" name="${user.userId}" value="A">Accept</button>
<button type="button" class="btn btn-outline-danger" name="${user.userId}" value="R">Reject</button>
</td>
</tr>
 </c:forEach>
 </tbody>
  </table>
</div>
</jsp:attribute>

</tags:adminHome>