<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<tags:master  heading="About Us" title=" About US">
<jsp:attribute name="header">

<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}

html {
  box-sizing: border-box;
}

*, *:before, *:after {
  box-sizing: inherit;
}

.column {
  float:left;
  width: 22.3%;
  margin-bottom: 20px;
  padding: 0 30px;
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  margin: 8px;
}

.about-section {
  padding: 20px;
  text-align: center;
  background-color: #537887;
  color: white;
}

.container {
  padding: 0 16px;
}

.container::after, .row::after {
  content: "";
  clear: both;
  display: table;
}

.title {
  color: grey;
}

.button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
}

.button:hover {
  background-color: #555;
}

@media screen and (max-width: 650px) {
  .column {
    width: 100%;
    display: block;
  }
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
</jsp:attribute>
<jsp:attribute name="content">

<div class="about-section" style="background-color: white; " ><h2 style="text-align:center; color:black;">Our Team</h2>
</div>
<div class="row">
  <div class="column">
    <div class="card">
      <img src="${pageContext.request.contextPath}/images/ankith.jpg" alt="ankith" style="width:100%">
      <div class="container" style="color: black;">
        <h2>Ankith Gunisetti</h2>
        <p>Some text that describes more about the bank.</p>
        <p>ankith@bank.com</p>
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
<div class="column">
    <div class="card">
      <img src="${pageContext.request.contextPath}/images/aruna1.jpg" alt="aruna" style="width:100%">
      <div class="container" style="color: black;">
        <h2>Aruna Thundla</h2>
        <p>Some text that describes more about the bank.</p>
        <p>aruna@bank.com</p>
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
  <div class="column">
    <div class="card">
      <img src="${pageContext.request.contextPath}/images/CFO.jpg" alt="CFO" style="width:100%">
      <div class="container" style="color: black;">
        <h2>Rakesh Munkanpally</h2>
        <p>Some text that describes more about the bank.</p>
        <p>rakesh@bank.com</p>
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
   <div class="column">
    <div class="card">
      <img src="${pageContext.request.contextPath}/images/aruna.jpg" alt="John" style="width:100%">
      <div class="container" style="color: black;">
        <h2>Shirisha Patlola</h2>
        <p>Some text that describes more about the bank.</p>
        <p>shirisha@bank.com</p>
        <p><button class="button">Contact</button></p>
      </div>
    </div>
  </div>
</div>
<footer>
        <p>&copy; 2024 Bank Management System. All rights reserved.</p>
    </footer>
</jsp:attribute>
</tags:master>

    