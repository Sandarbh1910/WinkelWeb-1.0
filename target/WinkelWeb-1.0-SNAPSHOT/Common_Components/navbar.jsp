

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    
        <style>
            *{
    box-sizing: border-box;
    margin:0;
    padding:0;
}

a{
    text-decoration: none;
    color:black;
}

nav{
    background-color: #212529;
    padding:15px;
    display:flex;
    flex-wrap: wrap;
    align-items: center;
    min-width:250px;
    
    
}

.logo{
    color:white;
    font-size: 25px;
}

.category{
    color:#939a97;
    margin-left:20px;
    margin-right: 10px;
}

.categorylist{
    list-style-type: none;
    border:2px solid #e1e1e2;
    border-radius: 5px;
    background-color: #ffffff;
    padding:10px 0px;
    min-width:160px;
    position:absolute;
    top:50px;
    left:200px;
    display:none;
    z-index:6;
    
}

.categorylistitem{
    padding:10px;
}
.categorylistitem a{
    width:100%;
}
.categorylistitem:hover{
    background-color: #e1e1e2;
    border-radius:4px;
}
#nav-category-checkbox{
    display:none;
}


#nav-category-checkbox:checked ~ .categorylist{
    display:block;
}

.search{
    display: inline-block;
    margin-left:auto;
    margin-right: 10px;
    min-width: 250px;
}

.searchbar{
    padding:10px;
    border-radius: 5px;
    min-width:200px;
}

.searchbtn{
    padding:10px;
    border-radius: 4px;
    border:1px solid #198754;
    color:#198754;
    background-color:#212529 ;
}

.searchbtn:hover{
    background-color: #198754;
    color:white;
}



.acc-btns{
    display:inline-block;
}


.below-bar{
    background-color: #f8f9fa;
    padding:10px;
    z-index:5;
}

.signup-btn,.login-btn,.logout-btn{
    text-decoration: none;
}

.signup-btn,.login-btn{
    border: 1px solid #515f6b;
    color:#515f6b;
    padding:10px;
    border-radius: 4px;
}

.signup-btn:hover,.login-btn:hover{
    background-color: #515f6b;
    color:white;
}

.logout-btn{
    color:red;
    border:1px solid red;
    padding:10px;
    border-radius: 4px;
}

.logout-btn:hover{
    background-color: red;
    color:white;
}



@media only screen and (max-width:654px)
{
    .acc-btns{
        margin-top: 10px;
    }
}


@media only screen and (max-width:515px)
{
    .search{
        width:100%;
    }

    .searchbar{
        width:80%;
    }

    .acc-btns{
        margin-top: 20px;
    }

    .category{
        display:none;
    }

    .categorylist{
        display:none !important;
    }

}



/* Common modal code starts */
.modal-body{
    display:flex;
    justify-content: center;
    flex-wrap: wrap;
    
}

.modal-header{
    padding:15px;
}

.modal-body form{
    display:flex;
    justify-content: center;
    flex-wrap: wrap;
    align-items: center;
    padding:10px;
    
}

.modal-footer{
    margin-top:20px;
}

#register-modal-checkbox,#login-modal-checkbox{
    display: none;
}

/* Common modal code ends */

/* Customer modal code starts */

.customer-modal-black-screen{
    width:100vw;
    height:100vh;
    position:absolute;
    top:0;
    background-color: black;
    opacity:0.8;
    display:none;
    z-index:5;
}


.customer-register-modal{
    min-width:250px;
    max-width:32vw;
    min-height: 85vh;
    background-color: white;
    margin:auto;
    position:relative;
    top:80px;
    border-radius: 3px;
}

.customer-register-modal-body{
    height:80%;
}

.signup{
    display:flex;
    justify-content: center;
    flex-wrap: wrap;
    align-items: center;
    padding:50px;
    height:80%;
    font-size: large;
}


.close-customer-modal-btn{
    float:right;
}


.signup-input{
    margin:auto;
    margin-top:15px;
    padding:10px;
    border-radius:5px;
    min-width:150px;
    
}

.terms{
    padding:15px 5px;
    text-align: center;
    width:100%;
}

#lbl{
    font-weight: bolder;
    color:black;
   

}

#close-register-modal-lbl{
    padding:10px 15px;
background-color: #6c757d;
color:white;
border-radius: 5px;
position:relative;
top:1px;}

#close-register-modal-btn{
    padding:10px;
}

#signup-submit-btn{
    padding:10px;
background-color: #0d6efd;
color:white;
border-radius: 5px;
margin-left:10px;
border:0px;

}

#signup-email,#signup-mob,#signup-password{
    width:93%;
}


@media only screen and (max-width:1228px)
{
    .signup-input{
        width:100%;
    }
}

#register-modal-checkbox:checked ~ .customer-modal-black-screen{
    display:block;
}

/* Customer modal code ends */


/* Login modal code begins */

.login-modal-black-screen{
    width:100vw;
    height:100vh;
    position:absolute;
    top:0;
    background-color: black;
    opacity:0.8;
    display:none;
    z-index:5;
}



.login-modal{
    max-width:32vw;
    min-height: 45vh;
    min-width: 250px;
    color:black;
    background-color: white;
    margin:auto;
    position:relative;
    top:180px;
    border-radius: 3px;
    
}




.close-login-modal-btn{
    float:right;
}

#close-login-modal-lbl{
    padding:10px 15px;
    background-color: #6c757d;
    color:white;
    border-radius: 5px;
    position:relative;
    top:1px;
}


#login-submit-btn{
    padding:10px;
    background-color: #0d6efd;
    color:white;
    border-radius: 5px;
    margin-left:10px;
    border:0px;
}

#login-modal-checkbox:checked ~ .login-modal-black-screen
{
    display:block;
}
/* Login modal code ends */
            
        </style>
    </head>
    <body>
          <nav>
        <span class="logo">WinkelWeb</span>

        <label for="nav-category-checkbox" class="category">Category&nbsp;<img src="./Icons/down.svg"
                style="filter: invert(50%); position: relative; top: 5px" /></label>
        <input type="checkbox" id="nav-category-checkbox" />
        <ul class="categorylist">
            <li class="categorylistitem"><a href="">Phones</a></li>
            <li class="categorylistitem"><a href="">Laptops</a></li>
            <li class="categorylistitem"><a href="">Tvs</a></li>
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
    </nav>

    <div class="below-bar">
        <label for="sideclosecheckbox" style="z-index: 10;cursor:pointer;width:30px;height:30px;border:1px solid black;" ><img src="./Icons/hamburger-icon.svg" alt=""  /></label>
    </div>

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
                        id="signup-firstname" />
                    <input type="text" placeholder="Lastname" name="crlastname" class="signup-input"
                        id="signup-lastname" />
                    <input type="email" placeholder="Email" name="cremail" class="signup-input" id="signup-email" />
                    <input type="tel" placeholder="Mob" name="crmob" class="signup-input" id="signup-mob" />
                    <input type="date" placeholder="DOB" name="crdob" class="signup-input" id="signup-dob" />
                    <textarea id="" rows="8" name="craddress" placeholder="Address" class="signup-input" id=""
                        style="resize: none; max-width: 98%; width: 98%"></textarea>

                    <!--Merchant Modal button-->
                    <a href="merchantregister.jsp"
                        style="color: blue; text-decoration: underline; cursor: pointer">Business user</a>

                    <div class="terms">
                        <input type="checkbox" id="check"
                            onchange="document.getElementById('signup-submit-btn').disabled = !this.checked;" />
                        <label for="check" id="lbl">I have read all the terms and I agree .
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
                <img src="" alt="" />
                <form action="LoginServlet" class="login">
                    <input type="tel" placeholder="Mob" name="logmob" class="signup-input" id="signup-mob" />
                    <input type="password" placeholder="Password" name="logpassword" class="signup-input"
                        id="signup-password" />

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
    </body>
</html>
