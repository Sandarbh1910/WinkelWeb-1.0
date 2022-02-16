
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <style>
            @import url('https://fonts.googleapis.com/css2?family=KoHo&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Paytone+One&display=swap');


*{
    box-sizing: border-box;
    margin:0;
    padding:0;

}

a{
    text-decoration:none;
    color:black;
}

.myoffcanvas{
    height:100vh;
    width:25vw;
    min-width: 250px;
    background-color: aqua;
    z-index: 20000000;
    position:fixed;
    top:0;
    left:-100%;
    transition-duration: .6s;
    
    
}


.sidebar{
    padding:15px;
    background-color: #f8f9fa;
    width:100%;
    height: 100%;
}

.sidehead{
    padding:15px;
}


.sideclosebtn{
    width:25px;
    height:25px;
}
.greeting{
    padding:15px;
    text-align: center;
    font-size: 30px;
    font-family: 'KoHo', sans-serif;
    
    
}

@media only screen and (max-width:1500px) {

.greeting{
    font-size:20px ;
    font-weight: bolder;
}
    
}

.sidemain{
    height:65%;
}

.sidelist{
    list-style-type: none;
    padding:20px 0px;
}

.sidelistitem{
    font-size: large;
    padding:10px 30px;

}

.sidelistitem:active{
    background-color: #0d6efd;
    color:white;
}

.sidelistitem:hover{
    background-color: #ffffff;
    border-radius:5px;
}

#sideclosecheckbox{
    display:none;
}

#sideclosecheckbox:checked ~ .myoffcanvas{
    left:0;
}

.sidefooter{
   
   height: 60px;
   padding:10px;
}

.sidebardp{
    background-color: aqua;
    border-radius: 50%;
    width:50px;
    height:50px;
    padding:5px;
    text-align: center;
    object-fit:contain;
}

.sidebarusername{
   
    padding:5px;
    text-align: center;
    font-family: 'Paytone One', sans-serif;

}

.sideuserlist{
   position:relative;
   bottom:210px;
   left:50px;
    max-width: 120px;
    border:2px solid #e1e1e2;
    border-radius: 5px;
    background-color: #ffffff;
    padding:10px 0px;
    min-width:160px;
    display: none;
    
}

.sideuserlist ul{
    list-style-type: none;
}

.sideuserlistitem{
    padding:8px;
}

.sideuserlistitem:hover{
    background-color: #e1e1e2;
}

#sidebarusercheckbox{
    display:none;
}
#sidebarusercheckbox:checked ~ .sideuserlist{
    display: block;
}


            
        </style>
        
    </head>
    <body>
       
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

    </body>
</html>
