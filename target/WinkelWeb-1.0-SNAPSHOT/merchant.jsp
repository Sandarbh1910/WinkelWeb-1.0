<%@page import="WinkelWeb_DAO.CategoryDAO"%>
<%@page import="WinkelWeb_POJO.CategoryPOJO"%>
<%@page import="WinkelWeb_POJO.ProductsPOJO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="WinkelWeb_DAO.ProductDAO"%>
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
            <img src="Icons/closebtn.svg" alt="" width="10" height="10" class="sideclosebtn">
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
                <li class="sidelistitem"><label for="inventory-tab-radio">Inventory</label></li>
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
               <label for="add-prod-tab-radio" class="add-prod">
                    <img src="Icons/addprodshelf.png" alt="">
                    Add Product
                </label>
                <label for="update-modal-checkbox" class="update-prod">
                    <img src="Icons/update.png" alt="">
                    Update Product</label>
            </div>
            
            <div class="option">
                <label for="disc-prod-modal-checkbox" class="disc-prod">
                    <img src="Icons/discount.png" alt="">
                    Discount Product</label>
                <label for="disc-all-prod-modal-checkbox" class="disc-all-prod">
                    <img src="Icons/discountall.png" alt="">
                    Discount All Products</label>
            </div>
            
            <div class="option">
                
                <a href="" class="complain">
                    <img src="Icons/help.png" alt="">
                    Complain/Feedbacks</a>
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


<!-- Inventory tab starts here -->
<input type="radio" id="inventory-tab-radio" name="mytab">
<div class="inventory-tab-page">
My Inventory
</div>
<!-- Inventory tab ends here -->




<!-- Add Products  tab starts here -->
<input type="radio" id="add-prod-tab-radio" name="mytab">
<div class="add-prod-tab-page">

<div class="add-prod-page-body">
    <form action="AddProductServlet" id="add-prod-form">
        <input type="text" class="add-prod-input" placeholder="Product Title" autofocus required name="ptitle">
                    <label for="prod-pic" id="prod-pic-icon"><img src="Icons/upload pic.png" alt=""><span>Select pictures
                            maximum 5 in jpeg format</span></label>

                    <input type="file"  name="ppic" multiple id="prod-pic" accept=".jpeg,.jpg">
                    <div class="img-prev-container"></div>
                    <textarea name="pdesc" id="" cols="30" rows="5" class="add-prod-input"
                        placeholder="Product Description" required></textarea>
                    <input type="text" name="pprice" class="add-prod-input" placeholder="Price" required>
                    <input type="text" name="pdisc" class="add-prod-input" placeholder="Discount" required>
                    <input type="text" name="pquant" class="add-prod-input" placeholder="Quantity" required>
                    <select name="pcat" class="add-prod-input" id="" required>
                    <%ArrayList<CategoryPOJO>catlist=CategoryDAO.loadCategory();
            if(catlist!=null)
            {
                for(CategoryPOJO c:catlist)
                {
                
                %>
           
            <option value=""><%=c.getCatTitle()%></option>
            <%
                } 
            }
            %>
                    </select>
                    <input type="submit" id="add-prod-submit-btn" value="Add Product">
                </form>
</div>
</div>
<!-- Add Products tab ends here -->


</main>


<!-- Update Product modal starts -->

 
 <input type="checkbox" id="update-modal-checkbox">
 <div class="update-modal-black-screen">
     <div class="update-modal">
         <div class="modal-header">
             Update Product Details
            <label for="update-modal-checkbox"> <img src="./Icons/closebtn.svg" alt="" class="close-update-modal-btn" /></label>
         </div>
         <hr>

         <div class="update-modal-body modal-body">
             <!-- <img src="./Icons/login_shield.svg" width="50" height="50" alt="" /> -->
             <form action="UpdateProductDetailsServlet" class="update">
                 
                 <input type="text" placeholder="Product Name" name="uppname" class="update-input" id="uppname" required/>
                 <input type="text" placeholder="Product Description" name="updesc" class="update-input" id="updesc" required/>
                 <input type="number" placeholder="Price" name="upprice" class="update-input" id="upprice" required/>
                 <input type="number" placeholder="Quantity" name="upquan" class="update-input" id="upquan" required/>
                 
                 

                 <div class="modal-footer">
                     <label id="close-update-modal-lbl"  for="update-modal-checkbox" >
                         Close
                     </label>
                     <input type="submit" id="update-submit-btn" value="Update" />
                 </div>
             </form>
         </div>
     </div>
 </div>

 

<!-- Update Product Modal Ends Here -->







<!-- Discount Product modal starts -->

 
<input type="checkbox" id="disc-prod-modal-checkbox">
<div class="disc-prod-modal-black-screen">
    <div class="disc-prod-modal">
        <div class="modal-header">
            Discount Product
           <label for="disc-prod-modal-checkbox"> <img src="./Icons/closebtn.svg" alt="" class="close-disc-prod-modal-btn" /></label>
        </div>
        <hr>

        <div class="disc-prod-modal-body modal-body">
            <!-- <img src="./Icons/login_shield.svg" width="50" height="50" alt="" /> -->
            <%ArrayList<String>pidlist=ProductDAO.loadPid(user.getUsid());%>
            <form action="DiscountProductServlet" class="discount">
                <select name="dpid" id="pidselectbox">
                    <%
                        for(String pid:pidlist)
                        {
                    %>
                    <option value="<%=pid%>"><%=pid%></option>
                    <%
                        }
                    %>
                </select>
                <input type="number" placeholder="%" name="disc-per" class="disc-input" id="disc-per" required/>
               

                <div class="modal-footer">
                    <label id="close-disc-prod-modal-lbl"  for="disc-prod-modal-checkbox" >
                        Close
                    </label>
                    <input type="submit" id="disc-prod-submit-btn" value="Update" />
                </div>
            </form>
        </div>
    </div>
</div>



<!-- Discount Product Modal Ends Here -->







<!-- Discount All Products modal starts -->

 
<input type="checkbox" id="disc-all-prod-modal-checkbox">
<div class="disc-all-prod-modal-black-screen">
    <div class="disc-all-prod-modal">
        <div class="modal-header">
            Common Discount
           <label for="disc-all-prod-modal-checkbox"> <img src="./Icons/closebtn.svg" alt="" class="close-disc-all-prod-modal-btn" /></label>
        </div>
        <hr>

        <div class="disc-all-prod-modal-body modal-body">
            <!-- <img src="./Icons/login_shield.svg" width="50" height="50" alt="" /> -->
            <form action="DiscountAllProductsServlet" class="discount-all">
                <input type="number" placeholder="%" name="disc-all-per" class="disc-input" id="disc-all-per" required/>
                

                <div class="modal-footer">
                    <label id="close-disc-all-prod-modal-lbl"  for="disc-all-prod-modal-checkbox" >
                        Close
                    </label>
                    <input type="submit" id="disc-all-prod-submit-btn" value="Update" />
                </div>
            </form>
        </div>
    </div>
</div>



<!-- Discount All Products Modal Ends Here -->






    <script>

        const input = document.querySelector('#prod-pic');

        // Listen for files selection
        input.addEventListener('change', function () {
            // Retrieve all files
            const myfiles = input.files;

            // Checking files count
            if (myfiles.length > 5) {
                alert(`Only 5 images are allowed to upload.`);
                input.value = '';
                console.log(input.value);
                return;
            }
            console.log(input.value);
            loadImg();
            if (myfiles.length !== 0)
                document.getElementById('prod-pic-icon').style.display = "none";





        });





        // Load Img 
        var images = [];
        function loadImg() {
            const myfiles = input.files;
            for (i = 0; i < myfiles.length; i++) {
                images.push({
                    "name": myfiles[i].name,
                    "url": URL.createObjectURL(myfiles[i]),
                    "file": myfiles[i]
                });
            }

            document.querySelector('.img-prev-container').innerHTML = prevImg();
        }


        // Preview Img
        function prevImg() {
            const myfiles = input.files;
            var img = "";
            for (i = 0; i < images.length; i++) {
                img += `<div class="prev-img-box"><img class="del-prod-pic-btn" onclick="delProdPic(` + i + `)" src="Icons/closebtn.svg"><img class="prev-img" src="` + images[i].url + `"></div>`
            }
            console.log("img= " + img);
            return img;

        }


        function delProdPic(e) {
            images.splice(e, 1);

            document.querySelector('.img-prev-container').innerHTML = prevImg();
            var myfiles = input.files;
            console.log("file len= " + myfiles.length);
            if (images.length == 0) {
                document.getElementById('prod-pic-icon').style.display = "flex";
                input.value = "";
                console.log(input.value);
            }
        }

    </script>



</body>
</html>