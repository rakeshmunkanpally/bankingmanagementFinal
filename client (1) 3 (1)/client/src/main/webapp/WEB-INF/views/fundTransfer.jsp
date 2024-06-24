<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<m:Master2 title="Bank Transfer Page" heading="Bank Transfer Page">
<jsp:attribute name="header">
 
<style>
 
  h2 {
    color: white;
   font-size:30px;
   text-align:center;
   
  }
  h3
  {
  color: white;
     font-size:14px;
     text-align:center;
  }
  
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#bank').change(function() {
			$("#msg1").html("");
			$("#msg2").html("");
			if ($('#bank').val() == 'same') {
				$('#account-details').show();
				$('#ifsc-details').hide();
			} else {
				$('#account-details').hide();
				$('#ifsc-details').show();
			}
		});
		var selectedBankOption = "${selectedBankOption}";
		  if (selectedBankOption === 'same') {
		        $('#bank').val('same');
		        $('#account-details').show();
		        $('#ifsc-details').hide();
		    } else if (selectedBankOption === 'other') {
		        $('#bank').val('other');
		        $('#account-details').hide();
		        $('#ifsc-details').show();
		    }
		
		$("#bank").change(function(){
			
			var accountNo=$("#senderAccountNo").val();
			if($("#bank option:selected").val()=="other"){
				
		$.ajax({
			type: "GET",
			url:"http://localhost:8080/bankmanagement/fundtransfer/otherBank/"+accountNo,
			dataType:"json",
			contentType:"application/json; charset=utf-8",
			success:function(msg){
				var str='<option value=""  disabled="true" selected="true">Select Reciever Number</option>';
				for(var i=0;i<msg.length;i++){
					str+='<option value="'+msg[i].receiverAccountNo+'" id='+msg[i].receiverName+'>'+msg[i].receiverAccountNo+' '+msg[i].receiverName+'</option>';
					}
				$("#select2").empty().append(str);
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
		    },
		});
			}
			
			if($("#bank option:selected").val()=="same"){
				$.ajax({
					type: "GET",
					url:"http://localhost:8080/bankmanagement/fundtransfer/"+accountNo,
					dataType:"json",
					contentType:"application/json; charset=utf-8",
					success:function(msg){
						var str='<option value=""  disabled="true" selected="true">Select Reciever Number</option>';
						for(var i=0;i<msg.length;i++){
							str+='<option value="'+msg[i].receiverAccountNo+'" id='+msg[i].receiverName+'>'+msg[i].receiverAccountNo+'  '+  msg[i].receiverName+'</option>';
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
				    },
				});
			}
		});
		
		
			$("#select").change(function() {
				$("#receiverName").val($("#select option:selected").attr('id'));
			});
			$("#select2").change(function() {
				$("#receiverName2").val($("#select2 option:selected").attr('id'));
			});
			$("#submit").click(function(){
				var sel=$("#select2 option:selected").attr('id');
				$("#"+sel).attr("selected", "selected");
			});

	});
</script>
</jsp:attribute>
 
<jsp:attribute name="content">
 
 
<div style="position: absolute; width:30%;background-color:#3c5e6a; padding: 20px; z-index: 2; margin-left: 30%; margin-top: 0%;padding-bottom: 10px" >

 
 
<h2 >Transfer Page</h2>
<h3 >Please enter the below details.</h3>
</div>
<div style="position: absolute;margin-left: 30%; margin-top:10.1%; padding : 1% 1% 1% 1%;background-color: #f2f2f2; width:30.05%">
		<label for="bank">Choose a bank:</label>
		<select id="bank">
		<option value="" selected="selected" disabled="disabled">Select </option>
			  <option value="same" ${selectedBankOption == 'same' ? 'selected' : ''}>Same bank</option>
    <option value="other" ${selectedBankOption == 'other' ? 'selected' : ''}>Other bank</option>
		</select>
</div>

<div style="position: absolute; width:32%; padding: 20px; z-index: 2; margin-left: 29%; margin-top: 12%;padding-bottom: 10px" >
		<div id="account-details">
	<form:form modelAttribute="sameBankTransfer" style="background-color: #f2f2f2;padding:20px" >
	<table cellspacing="10px">
	<tr>
  <td colspan="2" id="msg1">${msg}</td>
  
  </tr>
  <tr>
  <td><label for="senderAccountNo">Sender Account number:</label></td>
  <td><form:input type="text" path="senderAccountNo" id="senderAccountNo" value="${sessionScope.accountNo}"/><form:errors path="senderAccountNo" cssClass="error"/></td>
  </tr>
  
  
  <tr>
  <td><label for="receiverAccountNo">Receiver Account number:</label> </td>
  <td><form:select path="receiverAccountNo" id="select"><option value="" selected="selected" disabled="disabled">Select Receiver No </option></form:select></td><td><form:errors path="receiverAccountNo" cssClass="error"/></td>
  <td><button formaction="addPayee">Add Payee</button></td>
  </tr>
  
  <tr>
  <td><label for="Receiver Name"> Receiver Name:</label></td>
  <td> <input type="text" id="receiverName"/></td>
  </tr>
  
  <tr>
  <td><label for="amount">Amount:</label></td>
  <td><form:input type="text" path="amount" /><td><td><form:errors path="amount" cssClass="error"/></td>
  </tr>
  
  <tr>
  <td></td>
  <td><button type="submit" id="submit" formaction="transferAmount"> Transfer</button></td>
  </tr>
</table>
	</form:form>
		</div>

			 
		</div>
		<div id="ifsc-details" style="position: absolute; width:32%; padding: 20px; z-index: 2; margin-left: 29%; margin-top: 12%;padding-bottom: 10px; display: none;" >
		<form:form modelAttribute="otherBankTransfer" style="background-color: #f2f2f2;padding:20px" >
	<table cellspacing="10px">
	<tr>
  <td colspan="3" id="msg2">${msg}</td>
  <td colspan="2" ><form:errors /></td>
  </tr>
  <tr>
  <td><label for="senderAccountNo">Sender Account No:</label></td>
  <td><form:input type="text" path="senderAccountNo" readonly="true"/><td><td><form:errors path="senderAccountNo" cssClass="error"/></td>
  </tr>
  <tr>
  <td><label for="receiverAccountNo">Receiver Account number:</label> </td>
  <td><form:select path="receiverAccountNo" id="select2"><option value="" selected="selected" disabled="disabled">Select Receiver No </option><td><td><form:errors path="receiverAccountNo" cssClass="error"/></form:select></td>
  <td><button formaction="addPayee2">Add Payee</button></td>
  </tr>
  
  <tr>
  <td><label for="Receiver Name"> Receiver Name:</label></td>
  <td>  <form:input type="text" path="receiverName" id="receiverName2" readonly="true"/><td><td><form:errors path="receiverName" cssClass="error"/></td>
  </tr>
  
  <tr>
  <td><label for="amount">Amount:</label> </td>
  <td><form:input type="text" id="amount" path="amount"/><td><td><form:errors path="amount" cssClass="error"/></td>
  </tr>
  
  <tr>
  <td></td>
  <td><button type="submit" formaction="transferAmount2"> Transfer</button></td>
  </tr>
</table>

		</form:form>

				
		</div>
	
</jsp:attribute>
</m:Master2>
