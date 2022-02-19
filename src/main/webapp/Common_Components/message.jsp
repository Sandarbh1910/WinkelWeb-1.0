
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="common_css_js.jsp" %>
        <style>
            .alert{
                position: absolute;
                top:100px;
                z-index: 10000;
                min-width: 100vw;
            }
        </style>
    </head>
    <body>
        <%
            String msg=(String)session.getAttribute("message");
            if(msg!=null)
            {
                String dcol=(String)session.getAttribute("dcol");
                if(dcol.equalsIgnoreCase("0"))
                {
                    %>
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
  <strong>Error!</strong> <%=msg%>
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
                    <%
                }
                else if(dcol.equalsIgnoreCase("1"))
                {
                    %>
                    <div class="alert alert-warning alert-dismissible fade show" role="alert">
  <strong>Warning!</strong> <%=msg%>
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div> 
                    <%
                }
                else if(dcol.equalsIgnoreCase("2"))
                {
                    %>
                    <div class="alert alert-success alert-dismissible fade show" role="alert">
  <strong>Success!</strong> <%=msg%>
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>             
                    <%
                }
            }
        
          session.removeAttribute("message");
          session.removeAttribute("dcol");
        %>
        
    </body>
</html>
