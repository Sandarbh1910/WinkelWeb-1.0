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
    else if(user.getUser_type().equalsIgnoreCase("customer"))
    {
         session.setAttribute("message", "Unauthorised Access! . Do not try that again.");
    session.setAttribute("dcol","1");  
    response.sendRedirect("customer.jsp");
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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Merchant</title>
    <link rel="stylesheet" href="CSS/merchant.css">
</head>
<body>
    <!-- Navbar Starts -->
<nav>
    <div class="mynavbar">
        <a href="" class="logo">WinkelWeb</a>
        <a href="LogoutServlet" class="logout-btn">Logout</a>
    </div>
    <div class="below-bar">
        <label for="sideclosecheckbox" style="z-index: 10;cursor:pointer;width:30px;height:30px;" ><img src="./Icons/hamburger-icon.svg" alt=""  /></label>
        <span class="tabs">
            <label for="business-tab-radio" class="business-tab">Business</label>
            <label for="shopping-tab-radio" class="shopping-tab">Shopping</label>
        </span>
    </div>
          </nav>

<!-- Navbar ends -->



<!-- Sidebar starts -->

   
        
           
<input type="checkbox" id="sideclosecheckbox">
<div class="myoffcanvas">
    <div class="sidebar">

        <label for="sideclosecheckbox">
            <img src="Icons/closebtn.svg" alt="" width="10" height="10"class="sideclosebtn">
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
          
           
            <img class="sidebardp" src="Icons/login_shield.svg" alt="">
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

    
    
<!-- Sidebar ends -->

<main id="home">


    <!-- Business tab Starts here -->
    <input type="radio"  id="business-tab-radio" name="mytab" checked  onchange="adaptColor()">
    <div class="business-tab-page">
        <div class="app-stats-bar">
            <div class="users-stat"> <img src="Icons/customer.png" class="stats-icon" alt="">
                <h3>Users</h3>5
            </div>
            <div class="category-stat"> <img src="Icons/categoryimg.png" class="stats-icon" alt="">
                <h3>Categories</h3>4
            </div>
            <div class="products-stat"> <img src="Icons/product.png" class="stats-icon" alt="">
                <h3> Products</h3>6
            </div>
            <div class="orders-stat"> <img src="Icons/order.png" class="stats-icon" alt="">
                <h3>Orders</h3>3
            </div>
        </div>


        <div class="business-page-body">
            <div class="option">
                <div class="add-prod">
                    Add Product
                </div>
                <div class="rem-prod">
                    Remove Product
                </div>
            </div>
            
            <div class="option">
                <div class="disc-prod">Discount Product</div>
                <div class="disc-all-prod">Discount All Products</div>
            </div>
            
            <div class="option">
                <div class="update-prod">Update Product</div>
                <a href="" class="complain">Complain/Feedbacks</a>
            </div>
            


        </div>
    </div>
<!-- Business tab ends here -->


<!-- Shopping tab starts here -->
    <input type="radio" id="shopping-tab-radio" name="mytab">
    <div class="shopping-tab-page">
shopping gives me pleasure
    </div>
    <!-- shopping tab ends here -->
</main>



<script>
   
</script>
</body>
</html>