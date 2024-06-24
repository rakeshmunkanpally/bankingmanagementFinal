<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<tags:master  heading="Help" title=" help">

<jsp:attribute name="header">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #F0F8FF;
            margin: 0;
            padding: 0;
            color: #333;
        }
 
        header {
            background-color:#537887;
            padding: 20px;
            text-align: center;
            color: #fff;
            width: 1887px;
        }
 
        section {
            max-width: 800px;
            margin: 30px auto;
            padding: 10px;
            background-color:#F8F8FF;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            border-radius: 14px;
            width: 1500px;
            height:400px;
            
        }
 
        h1{
        
        color:white;
        }
        
         h2 {
            color: black;
            
        }
 
        p {
            line-height: 1.6;
          
        }
 
        ul {
            list-style-type: none;
            padding: 0;
        }
 
        li {
            margin-bottom: 10px;
            
        }
 
        a {
            color: #007BFF;
            text-decoration: none;
            transition: color 0.3s ease-in-out;
        }
 
        a:hover {
            color: #0056b3;
        }
 
        ol {
            margin-top: 10px;
           
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
    </style>
</jsp:attribute>
<jsp:attribute name="content">


 
    <section style="margin-left: 70%; margin-top: 15%">
        <h2>Welcome to our Bank Management System Help Page</h2>
 
        <p>This page provides information and guidance on using the bank management system.</p>
 
<!--         <h2>Table of Contents</h2> -->
<!--         <ul> -->
<!--             <li><a href="#getting-started">Getting Started</a></li> -->
<!--             <li><a href="#account-management">Account Management</a></li> -->
<!--             <li><a href="#transactions">Transactions</a></li> -->
<!--             <li><a href="#security">Security</a></li> -->
<!--             <li><a href="#contact">Contact Support</a></li> -->
<!--         </ul> -->
 
        <h2 id="getting-started">Getting Started</h2>
        <p>Follow these steps to get started with the Bank Management System:</p>
        <ol>
            <li>Create an account by visiting our website.</li>
            <li>Login with your credentials.</li>
            <li>Explore the features available in the system.</li>
        </ol>
 
        <!-- Add more sections as needed -->
 
    </section>
 
    <footer>
        <p>&copy; 2024 Bank Management System. All rights reserved.</p>
    </footer>
 
</jsp:attribute>
</tags:master>