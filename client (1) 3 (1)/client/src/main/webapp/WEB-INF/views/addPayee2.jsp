<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<m:Master2 title="Add Payee" heading="Add Payee">
<jsp:attribute name="header">
 
<style>
 
  h2 {
    color: white;
   font-size:30px;
   text-align :center;
   
  }
  h3
  {
  color: white;
     font-size:14px;
     text-align:center;
  }
  
  
</style>


<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script>
	$(document).ready(function() {
		$("#select").change(function() {

			$("#branchName").val($("#select option:selected").attr('id'));
		});
		$.ajax({
			type: "GET",
			url:"http://localhost:8080/bankmanagement/branch/other",
			dataType:"json",
			contentType:"application/json; charset=utf-8",
			success:function(msg){
				var str='<option value=""  disabled="true" selected="true">Select Branch Name</option>';
				for(var i=0;i<msg.length;i++){
					str+='<option value="'+msg[i].branchId+'" id="'+msg[i].branchName+'">'+msg[i].branchId+' &nbsp;'+msg[i].branchName+'</option>';
				
					}
				$("#select").empty().append(str);
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
		$("select").change(function(){
			$("#branch").val($("#select option:selected").attr("id"));
		});

	});
</script>


</jsp:attribute>
 
<jsp:attribute name="content">
 
 
<div style="position: absolute; width:30%;background-color:#3c5e6a; padding: 20px; z-index: 2; margin-left: 30%; margin-top: 0%;padding-bottom: 10px" >
 
<h2 >Add Payee</h2>
<h3 >Please enter the below details.</h3>
<f:form  style="background-color: #f2f2f2" action="createPayee2" modelAttribute="payee2" >
 

<table style="position: absolute;left:0%;top:120%; width:100%; height: 150%;background-color:#f2f2f2; padding-top: 10px" cellspacing="20px" >
<tr>
  <td colspan="2" id="msg1">${msg}</td>
  
  </tr>
<tr >
    <td>Receiver Account No </td>
    <td><f:input path="receiverAccountNo"/></td>
    <td><f:errors path="receiverAccountNo" cssClass="error" ></f:errors></td>
  </tr>

    <tr >
    <td>Branch Id:</td>
  <td><f:select path="branchId"  id="select" >
    <f:option value="" label="Select Branch " disabled="true" selected="true" ></f:option>
    
    </f:select>
  </tr>
   <tr>
    <td>Branch Location</td>
    <td>
    
    <f:input path="branchName" id="branch"/></td>
    <td><f:errors path="branchName" cssClass="error"></f:errors></td>
  </tr>
  <tr>
    <td>Receiver Name </td>
    <td >
	<f:input path='receiverName'  />
   </td>
    <td><f:errors path="receiverName" cssClass="error"></f:errors></td>
  </tr>
<tr >
  <td colspan="10"><button type="submit">Submit</button></td>
</tr>

</table>
</f:form>
 
</div>
</jsp:attribute>
</m:Master2>