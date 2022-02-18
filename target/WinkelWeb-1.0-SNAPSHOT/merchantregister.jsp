
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Merchant login</title>
    <link rel="stylesheet" href="CSS/merchantregister.css">
</head>
<body>
    <%@include file="Common_Components/message.jsp" %>
    <div class="brand-bar">
        WinkelWeb
    </div>
   <div class="top-box">
       
       
    <div class="merchant-register-box">
        
        <form action="MerchantRegistrationServlet" class="merchant-register-form">
            <input type="text" id="mrfirstname" placeholder="Firstname" name="mrfirstname" class="mrsignup-input">
            <input type="text" id="mrlastname" placeholder="Lastname" name="mrlastname" class="mrsignup-input">
            <input type="tel" id="mrmob" placeholder="Mobile" name="mrmob" class="mrsignup-input">
            <input type="date" id="mrdob" placeholder="DOB" name="mrdob" class="mrsignup-input">
            <input type="email" id="mremail" placeholder="Email" name="mremail" class="mrsignup-input">
            <input type="password" id="mrpassword" placeholder="Password" name="mrpassword" class="mrsignup-input">
            <textarea  rows="5" id="mraddress" placeholder="Address" name="mraddress" class="mrsignup-input" style="resize:none;
            width:100%;"></textarea>
            <input type="submit" value="Continue" id="mrsubmit-btn">
        </form>

        <div class="merchant-register-benefits">
            <h1>Get hassle free buying experience</h1>
            <h3>GST Invoice & Bulk Discounts</h3>
    
    
            <p> Save up to 28% more with GST input credit and avail discounts on multi-unit purchases.</p>
    
    <h3>Business Analytics</h3>
    
    
    <p>Track and monitor spending by your organisation with dynamic charts and data tables.</p>
    
    <h3>Secure Your Account</h3>
    
    <p> Add more colleagues to your account for making business purchases instead of sharing your login credentials.</p>
        </div>
        
    </div>
   
   </div>

   <footer>
       Need Help? <a href="">business customer care service.</a>
    <div>&copy;2022 WinkelWeb | Sandarbh Taran</div>
   </footer>


   
</body>
</html>
