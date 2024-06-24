<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<m:Master2 title="Update User" heading="Update User">
    <jsp:attribute name="header">
      <style>
     
    h2 {
        color: white;
        font-size: 30px;
        text-align: center;
    }

    h3 {
        color: white;
        font-size: 14px;
        text-align: center;
    }

    #background {
        display: none;
    }

    /* Additional styles for the card layout */
    .card {
        background-color: #ffffff;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        padding: 20px;
        margin: 20px auto; /* Center the card horizontally */
        max-width: 400px; /* Set maximum width for the card (adjusted width) */
    }

    .card table {
        width: 100%;
        border-collapse: collapse;
        border: none; /* Remove the table border */
    }

    .card th,
    .card td {
        padding: 10px;
        text-align: left;
    }

    .card th {
        background-color: #f2f2f2;
    }

    .card button {
        background-color: #5F9EA0;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        margin-left:120%; /* Center the button horizontally */
        display: block; /* Ensure the button is a block element */
    }

    .card button:hover {
        background-color: #45a049;
    }

    .error {
        color: red;
    }
</style>
      
      
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    </jsp:attribute>

    <jsp:attribute name="content">
        <div class="card">
            <f:form modelAttribute="user">
                <table class="table">
                    <thead>
                    <tr align="left">
                        
                            <td colspan="2">${msg}</td>
                        </tr>
                        <tr align="left">
                            <th scope="col">UserId</th>
                            <td><f:input type="text" path="userId" readonly="true" /></td>
                        </tr>
                        <tr align="left">
                            <th scope="col">First Name</th>
                            <td><f:input type="text" path="firstName" readonly="true" /></td>
                        </tr>
                        <tr align="left">
                            <th scope="col">Last Name</th>
                            <td><f:input type="text" path="lastName" readonly="true" /></td>
                        </tr>
                        <tr align="left">
                            <th scope="col">Email</th>
                            <td><f:input type="text" path="email" /><f:errors path="email" cssClass="error" /></td>
                        </tr>
                        <tr align="left">
                            <th scope="col">Phone No</th>
                            <td><f:input type="text" path="phoneNo" /><f:errors path="phoneNo" cssClass="error" /></td>
                        </tr>
                        <tr align="left">
                            <th scope="col">Date Of Birth</th>
                            <td><f:input type="text" path="dateOfBirth" readonly="true" /></td>
                        </tr>
                        <tr align="left">
                            <th scope="col">Gender</th>
                            <td><f:input type="text" path="gender" readonly="true" /></td>
                        </tr>
                        <tr align="left">
                            <th scope="col">Address</th>
                            <td><f:input type="text" path="address" /><f:errors path="address" cssClass="error" /></td>
                        </tr>

                        <tr align="center">
                            <td><button formaction="validateUserUpdate">Save</button></td>
                        </tr>
                    </thead>
                </table>
            </f:form>
        </div>
    </jsp:attribute>
</m:Master2>
