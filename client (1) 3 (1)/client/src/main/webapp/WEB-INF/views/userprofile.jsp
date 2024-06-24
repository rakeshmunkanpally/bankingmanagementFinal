<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<m:Master2 title="User Profile" heading="User Profile">
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
                max-width: 400px; /* Set maximum width for the card */
            }

            .card table {
                width: 100%;
                border-collapse: collapse;
                /* Center the table within the card */
            }

            .card th, .card td {
                padding: 10px;
                border-bottom: 1px solid #ddd;
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
            }

            .card button:hover {
                background-color: #45a049;
            }
               @media print {
        body * {
            visibility: hidden;
        }

        .card, .card * {
            visibility: visible;
        }

        .card {
            position: absolute;
            left: 0;
            top: 0;
        }
    
        </style>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script>
            function printDetails() {
                window.print();
            }
        </script>
    </jsp:attribute>

    <jsp:attribute name="content">
        <div class="card">
            <form action="">
                <table class="table" style="font-size: medium; align-content: center; padding: 0%; width: 420px;">
                    <thead>
                        <tr align="left">
                            <th scope="col">UserId</th>
                            <td>${userprofile.userId}</td>
                        </tr>
                        <tr align="left">
                            <th scope="col">First Name</th>
                            <td>${userprofile.firstName}</td>
                        </tr>
                        <tr align="left">
                            <th scope="col">Last Name</th>
                            <td>${userprofile.lastName}</td>
                        </tr>
                        <tr align="left">
                            <th scope="col">Email</th>
                            <td>${userprofile.email}</td>
                        </tr>
                        <tr align="left">
                            <th scope="col">Phone No</th>
                            <td>${userprofile.phoneNo}</td>
                        </tr>
                        <tr align="left">
                            <th scope="col">Date Of Birth</th>
                            <td>${userprofile.dateOfBirth}</td>
                        </tr>
                        <tr align="left">
                            <th scope="col">Gender</th>
                            <td>${userprofile.gender}</td>
                        </tr>
                        <tr align="left">
                            <th scope="col">Address</th>
                            <td>${userprofile.address}</td>
                        </tr>
                        <tr align="left">
 <th scope="col">Account No</th><td>${userprofile.accountNo}</td>
 </tr>
  <tr align="left">
 <th scope="col">Balance</th><td>${userprofile.balance}</td>
 </tr>
                    </thead>
                </table>
                <div style="text-align: center; margin-top: 20px;">
                    <button formaction="updateUser">EDIT</button>
                    <button type="button" onclick="printDetails()">PRINT</button>
                </div>
            </form>
        </div>
    </jsp:attribute>
</m:Master2>

