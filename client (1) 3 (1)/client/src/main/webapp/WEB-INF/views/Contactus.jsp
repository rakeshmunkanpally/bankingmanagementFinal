<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<tags:master  heading="Contact Us" title=" Contact US">

<jsp:attribute name="header">



    </jsp:attribute>
    <jsp:attribute name="content">
    <style>
        /* Card Styles */
        .card {
            max-width: 600px;
           margin-top:-30px;
           align-content: center;
           margin-left:300px;
           
        }

       .contact_us_2 * {
  font-family: Nunito, sans-serif;
}

.contact_us_2 .text-blk {
  
  line-height: 25px;
}

.contact_us_2 .responsive-cell-block {
  min-height: 75px;
}


.contact_us_2 .container-block {
  min-height: 75px;
  width: 100%;
  
  display: block;
}



.contact_us_2 .responsive-container-block {
  min-height: 75px;
  height: fit-content;
  width: 100%;
  display: flex;
  flex-wrap: wrap;
  justify-content: flex-start;
 
  margin-right: auto;
  margin-bottom: 50px;
  margin-left: auto;
 
}

.contact_us_2 .responsive-container-block.big-container {
  padding-top: 10px;
  padding-right: 30px;
  padding-bottom: 10px;
  padding-left: 30px;
  position: relative;
  height: auto;
}

.contact_us_2 .responsive-container-block.container {
  position: static;
  min-height: 75px;
  flex-direction: column;
  z-index: 2;
  max-width: 800px;
  margin-top: 120px;
  margin-right: auto;
  margin-bottom: 50px;
  margin-left: auto;
}

.contact_us_2 .container-block.form-wrapper {
  background-color: white;
  max-width:1000px;
  text-align: center;
 box-shadow: rgba(0, 0, 0, 0.05) 0px 4px 20px 7px;
 
  margin-right: auto;
  margin-bottom: 0px;
  margin-left: 550px;
}

.contact_us_2 .text-blk.contactus-head {
  font-size: 36px;
  line-height: 50px;
  font-weight: 900;
}

.contact_us_2 .text-blk.contactus-subhead {
  color: #9c9c9c;
  
  margin-bottom: 50px;
  
}

.contact_us_2 .responsive-cell-block.wk-desk-6.wk-ipadp-6.wk-tab-12.wk-mobile-12 {
 
  margin-bottom: 26px;

  min-height: 50px;
}

.contact_us_2 .input {
  width: 96%;
  height: 50px;
  padding-top: 1px;
  padding-right: 15px;
  font-size: 16px;
  color: black;
 
}

.contact_us_2 .textinput {
  width: 98%;
  min-height: 150px;
  
  font-size: 16px;
 
}

.contact_us_2 .submit-btn {
  width: 98%;
   background-color:#F5F5F5; 
  height: 60px;
  font-size: 20px;
  font-weight: 700;
  color: black;
  border-radius:14px;
  cursor: pointer;
}

.contact_us_2 .form-box {
  
  margin-right: auto;

  margin-left: auto;
}

.contact_us_2 .social-media-links {
  width: 250px;
  display: flex;
  justify-content: space-evenly;
  margin-top: 50px;
  margin-right: auto;
 
  margin-left: auto;
}

.contact_us_2 .link-img {
  width: 30px;
  height: 30px;
}

.contact_us_2 .text-blk.input-title {
  text-align: left;
  padding-left: 10px;
  font-size: 14px;
  margin-bottom: 5px;
   color: #9c9c9c; 
}

.contact_us_2 ::placeholder {
  color: #dadada;
}

.contact_us_2 .blueBG {
  position: absolute;
  width: 100%;
  
  height: 300px;
}

@media (max-width: 768px) {
  .contact_us_2 .submit-btn {
    width: 100%;
  }
  }

  .contact_us_2 .input {
    width: 100%;
  }

  .contact_us_2 .textinput {
    width: 100%;
  }

  .contact_us_2 .container-block.form-wrapper {
    margin-top: 80px;
   
  }
  .contact_us_2 .responsive-container-block.container {
    margin-top: 80px;
    margin-bottom: 50px;
  }
  .contact_us_2 .text-blk.contactus-head {
    font-size: 30px;
    line-height: 40px;
  }

@media (max-width: 500px) {
  .contact_us_2 .container-block.form-wrapper {
    padding-top: 50px;
    padding-right: 15px;
    padding-bottom: 50px;
    padding-left: 15px;
  }
}
  .contact_us_2 .container-block.form-wrapper {
    margin-top: 60px;
  
  }

  .contact_us_2 .responsive-cell-block.wk-ipadp-6.wk-tab-12.wk-mobile-12.wk-desk-6 {
    
    margin-bottom: 15px;
    
  }

  .contact_us_2 .responsive-container-block {
   
    margin-bottom: 35px;
    margin-left: 10px;
    
  }

  .contact_us_2 .text-blk.input-title {
    font-size: 12px;
  }

  .contact_us_2 .responsive-container-block.container {
    margin-top: 50px;
    
    margin-bottom: 50px;
    
  }

  .contact_us_2 .container-block.form-wrapper {
    margin-top: 1px;
    margin-right: 1px;
    margin-bottom: 1px;
    margin-left: 1px;
  }

  .contact_us_2 .responsive-container-block.big-container {
    padding-top: 10px;
    padding-right: 20px;
    padding-bottom: 10px;
    padding-left: 20px;
  }

  .contact_us_2 .text-blk.contactus-head {
    font-size: 26px;
    line-height: 34px;
  }

  .contact_us_2 .input {
    height: 45px;
  }
      
        footer {
            background-color: #5F9EA0;
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
<div class="contact_us_2"  >

    <div class="responsive-container-block container"  >
    <!-- Card Container -->
    <div class="card">
        <!-- Form Content -->
        <form class="form-box">
            <div class="container-block form-wrapper" style="padding: 20px 20px 10px 20px; margin-left: 65%; background-color: #ADD8E6;">
          <p class="text-blk contactus-subhead" style="color: black; margin-top:5%;"> </p>
           <h1 style="background-color:#F5F5F5;margin-top:5%;color: black;">Get in Touch</h1>
           <br>
          <div class="responsive-container-block">
            <div class="responsive-cell-block wk-ipadp-6 wk-tab-12 wk-mobile-12 wk-desk-6" id="i10mt">
              <p class="text-blk input-title" style="color: black;">
                FIRST NAME
              </p>
              <input class="input" id="ijowk" name="FirstName" placeholder="Please enter first name...">
            </div>
            <br>
            <div class="responsive-cell-block wk-desk-6 wk-ipadp-6 wk-tab-12 wk-mobile-12">
              <p class="text-blk input-title" style="color: black; padding-left: 20px;">
                LAST NAME
              </p>
              <input class="input" id="indfi" name="Last Name" placeholder="Please enter last name...">
            </div>
            <br>
            <div class="responsive-cell-block wk-desk-6 wk-ipadp-6 wk-tab-12 wk-mobile-12">
              <p class="text-blk input-title" style="color: black;">
                EMAIL
              </p>
              <input class="input" id="ipmgh" name="Email" placeholder="Please enter email...">
            </div>
            <br>
            <div class="responsive-cell-block wk-desk-6 wk-ipadp-6 wk-tab-12 wk-mobile-12">
              <p class="text-blk input-title" style="color: black;">
                PHONE NUMBER
              </p>
              <input class="input" id="imgis" name="PhoneNumber" placeholder="Please enter phone number...">
            </div>
            <br>
            <div class="responsive-cell-block wk-tab-12 wk-mobile-12 wk-desk-12 wk-ipadp-12" id="i634i">
              <p class="text-blk input-title" style="color: black;">
                WHAT DO YOU HAVE IN MIND
              </p>
              <textarea class="textinput" id="i5vyy" placeholder="Please enter query..."></textarea>
            </div>
          </div>
          <button class="submit-btn">
            Submit
          </button>
        </div>
        <div class="social-media-links" style="margin-left: 90%;margin-top:5px;">
          <a href="#" id="ix94i-2">
            <img class="link-img" src="https://workik-widget-assets.s3.amazonaws.com/Footer1-83/v1/images/Icon-twitter.png">
          </a>
          <a href="#">
            <img class="link-img" src="https://workik-widget-assets.s3.amazonaws.com/Footer1-83/v1/images/Icon-facebook.png">
          </a>
          <a href="#">
            <img class="link-img" src="https://workik-widget-assets.s3.amazonaws.com/Footer1-83/v1/images/Icon-google.png">
          </a>
          <a href="#" id="izldf-2">
            <img class="link-img" src="https://workik-widget-assets.s3.amazonaws.com/Footer1-83/v1/images/Icon-instagram.png">
          </a>
        </div>
      </form>
    </div>
  </div>
  </div>
    <footer>
        <p>&copy; 2024 Bank Management System. All rights reserved.</p>
    </footer>
</jsp:attribute>
</tags:master>
