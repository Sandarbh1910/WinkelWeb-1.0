<%@page import="java.util.ArrayList"%>
<%@page import="WinkelWeb_POJO.CategoryPOJO"%>
<%@page import="WinkelWeb_POJO.CategoryPOJO"%>
<%@page import="WinkelWeb_DAO.CategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    

    <link rel="stylesheet" href="CSS/index.css">

    <title>WinkelWeb</title>
</head>

<body>

    <%@include  file="Common_Components/message.jsp"%>

    <!-- Navbar Starts  -->
    
    <nav>
        
         <div class="mynavbar">
        <a class="logo" href="#home">WinkelWeb</a>

        <label for="nav-category-checkbox" class="category">Category&nbsp;<img src="./Icons/down.svg"
                style="filter: invert(50%); position: relative; top: 0px" /></label>
        <input type="checkbox" id="nav-category-checkbox" />
        <ul class="categorylist">
               <%ArrayList<CategoryPOJO>catlist=CategoryDAO.loadCategory();
            if(catlist!=null)
            {
                for(CategoryPOJO c:catlist)
                {
                
                %>
            <li class="categorylistitem"><a href="#"><%=c.getCatTitle()%></a></li>
            
            <%
                }
                

                
            }
            %>
        </ul>

        <div class="search">
            <form action="">
                <input type="search" placeholder="Search" class="searchbar" />
                <input type="submit" value="Search" class="searchbtn" />
            </form>
        </div>

        <div class="acc-btns">
            <label  for="register-modal-checkbox" class="signup-btn">Sign Up</label>
            <label  for="login-modal-checkbox" class="login-btn">Login</label>
            <!-- <label for="" class="logout-btn">Logout</label> -->
        </div>
    </div>

    <div class="below-bar">
        <label for="sideclosecheckbox" style="z-index: 10;cursor:pointer;width:30px;height:30px;" ><img src="./Icons/hamburger-icon.svg" alt=""  /></label>
    </div>
    </nav>

    <!--Navbar Ends Here-->
    
    
    <!-- Customer Register Modal Code Begins -->
    <input type="checkbox" id="register-modal-checkbox">
    <div class="customer-modal-black-screen">
        <div class="customer-register-modal">
            <div class="modal-header">
                Sign Up
               <label for="register-modal-checkbox" > <img src="./Icons/closebtn.svg" alt="" class="close-customer-modal-btn" /></label>
            </div>
            <hr />
            <div class="customer-register-modal-body modal-body">
                <form action="CustomerRegistrationServlet" class="signup">
                    <input type="text" placeholder="Firstname" name="crfirstname" class="signup-input"
                        id="signup-firstname" required/>
                    <input type="text" placeholder="Lastname" name="crlastname" class="signup-input"
                        id="signup-lastname" required/>
                    <input type="email" placeholder="Email" name="cremail" class="signup-input" id="signup-email" required />
                    <input type="tel" placeholder="Mob" name="crmob" class="signup-input" id="signup-mob" required/>
                    <input type="date" placeholder="DOB" name="crdob" class="signup-input" id="signup-dob" required/>
                    <input type="password" placeholder="Password" name="crpassword" class="signup-input" id="signup-password" required/>
                    <textarea  name="craddress" placeholder="Address" class="signup-input" id="craddress-txt-area"
                        style="resize: none; max-width: 98%; width: 98%;height:100px;min-height: 50px;" required></textarea>

                    <!--Merchant Modal button-->
                    <a href="merchantregister.jsp"
                        style="color: blue !important; text-decoration: underline !important; cursor: pointer">Business user</a>

                    <div class="terms">
                        <input type="checkbox" id="signup-term-checkbox"
                            onchange="enableSignupBtn()" />
                        <label for="signup-term-checkbox" id="lbl">I have read all the terms and I agree .
                        </label>
                        <hr />
                    </div>

                    <div class="modal-footer">
                        <label id="close-register-modal-lbl" for="register-modal-checkbox">
                            Close
                        </label>
                        <input type="submit" id="signup-submit-btn"  disabled value="Sign Up" />
                    </div>
                </form>
            </div>
        </div>
    </div>
    
    
    <script>
        function enableSignupBtn()
        {
            let check=document.getElementById('signup-term-checkbox');
            let btn=document.getElementById('signup-submit-btn');
            
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

    <!-- Customer Register Modal Code Ends -->

    <!-- Login Modal Code Begins -->
<input type="checkbox" id="login-modal-checkbox">
    <div class="login-modal-black-screen">
        <div class="login-modal">
            <div class="modal-header">
                Login
               <label for="login-modal-checkbox"> <img src="./Icons/closebtn.svg" alt="" class="close-login-modal-btn" /></label>
            </div>
            <hr>

            <div class="login-modal-body modal-body">
                <img src="./Icons/login_shield.svg" width="50" height="50" alt="" />
                <form action="LoginServlet" class="login">
                    <input type="tel" placeholder="Mob" name="logmob" class="login-input" id="login-mob" required/>
                    <input type="password" placeholder="Password" name="logpassword" class="login-input"
                        id="login-password" required/>

                    <div class="modal-footer">
                        <label id="close-login-modal-lbl"  for="login-modal-checkbox" >
                            Close
                        </label>
                        <input type="submit" id="login-submit-btn" value="Login" />
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Login Modal Code Ends -->
  
  
  
  
  
  
    <!-- Side Bar Starts -->


       
   <input type="checkbox" id="sideclosecheckbox">
    <div class="myoffcanvas">
        <div class="sidebar">

            <label for="sideclosecheckbox">
                <img src="./Icons/closebtn.svg" alt="" width="10" height="10"class="sideclosebtn">
            </label>

            <div class="sidehead">

                <label for="login-modal-checkbox" class="greeting">Hi ,Sign in</label>

            </div>
            <hr>
            <div class="sidemain">
                <ul class="sidelist">
                    <li class="sidelistitem"><a href="#home">Home</a></li>
                    <li class="sidelistitem"><label for="login-modal-checkbox">Orders</label></li>
                    <li class="sidelistitem"><label for="login-modal-checkbox">Cart</label></li>
                    <li class="sidelistitem"><a href="">Customer Services</a></li>

                </ul>
            </div>
            <hr>
            <div class="sidefooter">
              
               
                <img class="sidebardp" src="./Icons/user-solid.svg" alt="">
                <label for="sidebarusercheckbox" class="sidebarusername">Sandarbh Taran</label>
               
              


                <input type="checkbox" id="sidebarusercheckbox">
              <div class="sideuserlist">
                <ul>
                    <li class="sideuserlistitem"><a href="">Setting</a></li>
                    <li class="sideuserlistitem" style="border-bottom: 2px solid #e1e1e2;"><a href="">Profile</a></li>
                    <li class="sideuserlistitem"><label for="login-modal-checkbox">Sign in</label></li>
                </ul>
              </div>
            </div>

        </div>
    </div>


    <!-- Side Bar Ends -->


    <main id="home">
        <!-- Carousel Starts  -->

       <div class="mycarousel">
             <%@include file="Common_Components/carousel.jsp" %>
        </div>

        <!-- Carousel Ends  -->


<!--
        <div class="prod-container container-fluid mt-2">
            <div class="card col-6" style=" max-width:15rem;">
                <img src="http://source.unsplash.com/150x100/?nature,bikes" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                        card's content.</p>
                    
                </div>
            </div>


            <div class="card col-6" style="max-width: 15rem;">
                <img src="http://source.unsplash.com/150x100/?nature,bikes" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                        card's content.</p>
                    
                </div>
            </div>
            
             <div class="card col-6" style="max-width: 15rem;">
                <img src="http://source.unsplash.com/150x100/?nature,bikes" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                        card's content.</p>
                    
                </div>
            </div>
             <div class="card col-6" style="max-width: 15rem;">
                <img src="http://source.unsplash.com/150x100/?nature,bikes" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                        card's content.</p>
                    
                </div>
            </div>
            
             <div class="card col-6" style="max-width: 15rem;">
                <img src="http://source.unsplash.com/150x100/?nature,bikes" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                        card's content.</p>
                    
                </div>
            </div>
            
             <div class="card col-6" style="max-width: 15rem;">
                <img src="http://source.unsplash.com/150x100/?nature,bikes" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                        card's content.</p>
                    
                </div>
            </div>
            
            
             <div class="card col-6" style="max-width: 15rem;">
                <img src="http://source.unsplash.com/150x100/?nature,bikes" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                        card's content.</p>
                    
                </div>
            </div>
            
            
             <div class="card col-6" style="max-width: 15rem;">
                <img src="http://source.unsplash.com/150x100/?nature,bikes" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                        card's content.</p>
                    
                </div>
            </div>
            
            
             <div class="card col-6" style="max-width: 15rem;">
                <img src="http://source.unsplash.com/150x100/?nature,bikes" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                        card's content.</p>
                    
                </div>
            </div>
            
             <div class="card col-6" style="max-width: 15rem;">
                <img src="http://source.unsplash.com/150x100/?nature,bikes" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                        card's content.</p>
                    
                </div>
            </div>
            
             <div class="card col-6" style="max-width: 15rem;">
                <img src="http://source.unsplash.com/150x100/?nature,bikes" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                        card's content.</p>
                    
                </div>
            </div>
            
             <div class="card col-6" style="max-width: 15rem;">
                <img src="http://source.unsplash.com/150x100/?nature,bikes" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                        card's content.</p>
                    
                </div>
            </div>
        </div>
-->






    
    <%@include file="Common_Components/footer.jsp" %>

        
    </main>
   


















    



    


   
</body>

</html>