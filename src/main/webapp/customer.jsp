<%@page import="WinkelWeb_POJO.UserCredentialsPOJO"%>


<%
    UserCredentialsPOJO user=(UserCredentialsPOJO)session.getAttribute("current_user");
    
if(user!=null)
{
    if(user.getUser_type().equalsIgnoreCase("admin"))
    {
         session.setAttribute("message", "Unauthorised Access!.Do not try that again.");
    session.setAttribute("dcol","1");
    response.sendRedirect("admin.jsp");
    return;
    }
    else if(user.getUser_type().equalsIgnoreCase("merchant"))
    {
         session.setAttribute("message", "Unauthorised Access! . Do not try that again.");
    session.setAttribute("dcol","1");  
    response.sendRedirect("merchant.jsp");
    return;
    }
    
}
else{
    session.setAttribute("message", "Login Required!");
    session.setAttribute("dcol","1");
    response.sendRedirect("index.jsp");
    return;
}


%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WinkelWeb</title>
        <link rel="stylesheet" href="CSS/customer.css">
    </head>
    <body>
        
        
         <!-- Navbar Starts  -->
    
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
<!--            <label  for="register-modal-checkbox" class="signup-btn">Sign Up</label>
            <label  for="login-modal-checkbox" class="login-btn">Login</label>-->
             <a href="LogoutServlet" class="logout-btn">Logout</a> 
        </div>
    </nav>

    <div class="below-bar">
        <label for="sideclosecheckbox" style="z-index: 10;cursor:pointer;width:30px;height:30px;" ><img src="./Icons/hamburger-icon.svg" alt=""  /></label>
    </div>

    <!--Navbar Ends Here-->
        
        
        
        <!--Sidebar Code starts here-->
        
           
   <input type="checkbox" id="sideclosecheckbox">
    <div class="myoffcanvas">
        <div class="sidebar">

            <label for="sideclosecheckbox">
                <img src="./Icons/closebtn.svg" alt="" width="10" height="10"class="sideclosebtn">
            </label>

            <div class="sidehead">

                <span class="greeting">Hi ,Sandarbh</span>

            </div>
            <hr>
            <div class="sidemain">
                <ul class="sidelist">
                    <li class="sidelistitem"><a href="">Home</a></li>
                    <li class="sidelistitem"><a href="">Orders</a></li>
                    <li class="sidelistitem"><a href="">Cart</a></li>
                    <li class="sidelistitem"><a href="">Customer Services</a></li>

                </ul>
            </div>
            <hr>
            <div class="sidefooter">
              
               
                <img class="sidebardp" src="./Icons/login_shield.svg" alt="">
                <label for="sidebarusercheckbox" class="sidebarusername">Sandarbh Taran</label>
               
              


                <input type="checkbox" id="sidebarusercheckbox">
              <div class="sideuserlist">
                <ul>
                    <li class="sideuserlistitem"><a href="">Setting</a></li>
                    <li class="sideuserlistitem" style="border-bottom: 2px solid #e1e1e2;"><a href="">Profile</a></li>
                    <li class="sideuserlistitem"><a href="">Sign out</a></li>
                </ul>
              </div>
            </div>

        </div>
    </div>

        
        <!--Sidebar Code ends here-->
        
        <main>
            
        </main>
    </body>
</html>
