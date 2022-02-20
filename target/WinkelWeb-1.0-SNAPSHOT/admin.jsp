<%@page import="java.util.ArrayList"%>
<%@page import="WinkelWeb_POJO.CategoryPOJO"%>
<%@page import="WinkelWeb_DAO.CategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="WinkelWeb_POJO.UserCredentialsPOJO"%>





<%
//    UserCredentialsPOJO user=(UserCredentialsPOJO)session.getAttribute("current_user");
//    
//if(user!=null)
//{
//    if(user.getUser_type().equalsIgnoreCase("customer"))
//    {
//         session.setAttribute("message", "Unauthorised Access!. Do not try that again.");
//    session.setAttribute("dcol","1");
//    response.sendRedirect("customer.jsp");
//    return;
//    }
//    else if(user.getUser_type().equalsIgnoreCase("merchant"))
//    {
//         session.setAttribute("message", "Unauthorised Access!. Do not try that again.");
//    session.setAttribute("dcol","1");  
//    response.sendRedirect("merchant.jsp");
//    return;
//    }
//    
//}
//else{
//    session.setAttribute("message", "Login Required!");
//    session.setAttribute("dcol","1");
//    response.sendRedirect("index.jsp");
//    return;
//}


%>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
        <title>WinkelWeb</title>
        
        <link rel="stylesheet" href="CSS/admin.css">
    </head>
    <body>
       <!-- Navbar Starts -->
<nav>
    <div class="mynavbar">
        <a href="" class="logo">WinkelWeb</a>
        <a href="" class="logout-btn">Logout</a>
    </div>
    <div class="below-bar">
        <label for="sideclosecheckbox" style="z-index: 10;cursor:pointer;width:30px;height:30px;" ><img src="./Icons/hamburger-icon.svg" alt=""  /></label>
    </div>
          </nav>

<!-- Navbar ends -->


<!-- Sidebar starts -->

   
        
           
   <input type="checkbox" id="sideclosecheckbox">
    <div class="myoffcanvas">
        <div class="sidebar">

            <label for="sideclosecheckbox">
                <img src="./Icons/closebtn.svg" alt="" width="10" height="10" class="sideclosebtn">
            </label>

            <div class="sidehead">

                <span class="greeting">Hi ,Sandarbh</span>

            </div>
            <hr>
            <div class="sidemain">
                <ul class="sidelist">
                    <li class="sidelistitem"><a href="#home">Home</a></li>
                    <li class="sidelistitem"><a href="">Orders</a></li>
                    <li class="sidelistitem"><a href="">Cart</a></li>
                    <li class="sidelistitem"><a href="feedbacks.jsp">Feedbacks/Complaints</a></li>

                </ul>
            </div>
            <hr>
            <div class="sidefooter">
              
               
                <img class="sidebardp" src="icons/login_Shiled.svg" alt="">
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
    <div class="app-stats-bar">
        <div class="users-stat"> <img src="icons/login_Shiled.svg" class="stats-icon" alt="">
            <h3>Users</h3>
        </div>
        <div class="category-stat"> <img src="icons/login_Shiled.svg" class="stats-icon" alt="">
            <h3>categories</h3>
        </div>
        <div class="products-stat"> <img src="icons/login_Shiled.svg" class="stats-icon" alt="">
            <h3> Products</h3>
        </div>
        <div class="orders-stat"> <img src="icons/login_Shiled.svg" class="stats-icon" alt="">
            <h3>Orders</h3>
        </div>
    </div>

    <div class="admin-option-box">
       <div class="cat">
           <label for="add-cat-modal-checkbox" class="add-cat"> <img src="./Icons/add-cat.svg" width="80" height="100" alt=""><span class="option-title">Add Category</span></label>
           <label for="rem-cat-modal-checkbox" class="rem-cat"><img src="./Icons/delete.svg" width="80" height="100" alt=""> <span class="option-title">Remove Category</span></label>
       </div>
        <label for="rem-user-modal-checkbox" class="rem-user"><img src="./Icons/remove-user.svg" width="80" height="100" alt=""> <span class="rem-user-title option-title">Remove User</span></label>
        <div class="feedbacks">
            <a  href="viewcustomerfeedbacks.jsp" class="cfeeds" ><img src="./Icons/chat-left.svg" width="80" height="100" alt=""> <span class="option-title">Customer Feedbacks</span></a>
            <a  href="viewmerchantfeedbacks.jsp" class="mfeeds" ><img src="./Icons/chat-right.svg" width="80" height="100" alt=""> <span class="option-title">Merchant Feedbacks</span></a>
        </div>
        
    </div>
       
       
       <div class="footer">
     &copy;2021-2022 WinkelWeb | Sandarbh Taran
</div>
       
       
   </main>
   
       <!--Add Category Modal Starts-->
       <input type="checkbox" id="add-cat-modal-checkbox">
    <div class="add-cat-modal-black-screen">
        <div class="add-cat-modal">
            <div class="modal-header">
                Add Category
               <label for="add-cat-modal-checkbox"> <img src="./Icons/closebtn.svg" alt="" class="close-add-cat-modal-btn" /></label>
            </div>
            <hr>

            <div class="add-cat-modal-body modal-body">
                <img src="" alt="" />
               <form id="add-cat-form" action="AddCategoryServlet" method="POST">
                    <input type="text" required id="add-cat-title-input" name="cat-title" placeholder="Category Title">
                    <input type="text" required id="add-cat-desc-input" name="cat-desc" placeholder="Category Description">
                    <div class="modal-btns">
                         <label class="lbl-close" for="add-cat-modal-checkbox">Close</label>
                    <input type="submit" id="add-cat-submit-btn" value="Add Category">
                    </div>
                </form>
            </div>
        </div>
    </div>
       
<!--Add Category Modal Ends-->


       <!--Remove Category Modal Starts-->
        <input type="checkbox" id="rem-cat-modal-checkbox">
    <div class="rem-cat-modal-black-screen">
        <div class="rem-cat-modal">
            <div class="modal-header">
                Remove Category
               <label for="rem-cat-modal-checkbox"> <img src="./Icons/closebtn.svg" alt="" class="close-rem-cat-modal-btn" /></label>
            </div>
            <hr>

            <div class="rem-cat-modal-body modal-body">
                <img src="" alt="" />
               <form id="rem-cat-form" action="RemoveCategoryServlet" method="POST">
                   
               <%
                      ArrayList<CategoryPOJO>arr=CategoryDAO.loadCategory();
                     
                   if(arr!=null){
                    for(CategoryPOJO cat:arr)
                   {
                %>
                   
                       <div class="rem-cat-input"> <input type="checkbox"  name="del-cat" value="<%=cat.getCatTitle()%>" ><span><%=cat.getCatTitle()%></span></div>
                   
               <%
                    }
                               }
                   
               %>    
                   
                     
                   
                   
                  
                   
                   
                   
                    <div class="modal-btns">
                        <label class="lbl-close" for="rem-cat-modal-checkbox">Close</label>
                    <input type="submit" id="rem-cat-submit-btn" value="Remove">
                    </div>
                </form>
            </div>
        </div>
    </div>
       
       <!--Remove Category Modal Ends-->
       
       
       <!--Remove User Modal Starts-->
       
        <input type="checkbox" id="rem-user-modal-checkbox">
    <div class="rem-user-modal-black-screen">
        <div class="rem-user-modal">
            <div class="modal-header">
                Remove User
               <label for="rem-user-modal-checkbox"> <img src="./Icons/closebtn.svg" alt="" class="close-rem-user-modal-btn" /></label>
            </div>
            <hr>

            <div class="rem-user-modal-body modal-body">
                <img src="" alt="" />
                <form id="rem-user-form" action="" method="POST">
                    <input type="tel" required id="rem-user-mob-input" placeholder="Mobile Number">
                    <div class="modal-btns">
                        <label class="lbl-close" for="rem-user-modal-checkbox">Close</label>
                    <input type="submit" id="rem-user-submit-btn" value="Remove">
                    </div>
                </form>
            </div>
        </div>
    </div>
       
       <!--Remove User Modal Ends-->
      
   
  
    </body>
</html>
