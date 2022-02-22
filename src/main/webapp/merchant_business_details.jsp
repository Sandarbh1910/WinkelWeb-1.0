
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="CSS/merchantregister.css">
</head>
<body>
    <div class="brand-bar">
        WinkelWeb
    </div>
   <div class="top-box">
       
       
    <div class="merchant-register-box">
        
        <form action="MerchantBusinessDetailsSubmissionServlet" method="POST" class="merchant-register-form">
            <input type="text" id="mrfirmname" placeholder="Firm Name" name="mrfirmname" class="mrsignup-input">
            <input type="text" id="mrgstnumber" placeholder="GST Number" name="mrgstnumber" class="mrsignup-input">
            <input type="text" id="mraccnumber" placeholder="Account Number" name="mraccnumber" class="mrsignup-input">
            <input type="text" id="mrifsccode" placeholder="IFSC Code" name="mrifsccode" class="mrsignup-input">
            <textarea  rows="5" id="mrfirmaddress" placeholder="Firm Address" class="mrsignup-input" style="resize:none;
            width:100%;" name="mrfirmaddress"></textarea>
            <div class="terms">
                        <input type="checkbox" id="mrbusiness-term-checkbox"
                            onchange="enableSignupBtn()" />
                        <label for="mrbusiness-term-checkbox" id="lbl">I/We hereby confirm that the information provided herein is accurate, correct and complete.WinkelWeb is not responsible for any misadventure.
                        </label>
                        <hr />
                    </div>
            <input type="submit" value="Continue" id="mrsubmit-btn" disabled>
        </form>

        <div class="merchant-register-benefits">
            <h1>Get hassle free buying experience</h1>
            <h3>GST Invoice & Bulk Discounts</h3>
    
    
    Save up to 28% more with GST input credit and avail discounts on multi-unit purchases.
    
    <h3>Business Analytics</h3>
    
    
    Track and monitor spending by your organisation with dynamic charts and data tables.
    
    <h3>Secure Your Account</h3>
    
    Add more colleagues to your account for making business purchases instead of sharing your login credentials.
        </div>
        
    </div>
   
   </div>

   <footer>
       Need Help? <a href="">business customer care service.</a>
    <div>&copy;2022 WinkelWeb | Sandarbh Taran</div>
   </footer>

     <script>
        function enableSignupBtn()
        {
            let check=document.getElementById('mrbusiness-term-checkbox');
            let btn=document.getElementById('mrsubmit-btn');
            
            btn.disabled=!check.checked;
            console.log('btn is'+btn.disabled);
            
            if(btn.disabled)
            {
                console.log('to light blue');
                btn.style.backgroundColor='#5a9cfe';
            }
            else {
                btn.style.backgroundColor='#0d6efd';
                 console.log('to dark blue');
            }
    
        }
    </script>
    
</body>
</html>