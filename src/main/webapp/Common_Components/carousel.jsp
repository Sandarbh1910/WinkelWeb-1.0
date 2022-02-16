
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="common_css_js.jsp"%>
        
    </head>
    <body>
        
            <div id="carouselExampleFade" class="carousel slide carousel-fade mt-2"  data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="http://source.unsplash.com/1200x300/?nature,rivers" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="http://source.unsplash.com/1200x300/?nature,mountains" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="http://source.unsplash.com/1200x300/?nature,sky" class="d-block w-100" alt="...">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade"
                data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade"
                data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
       
    </body>
</html>
