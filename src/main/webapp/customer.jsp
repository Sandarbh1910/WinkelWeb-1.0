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
    </head>
    <body>
        <%@include file="Common_Components/navbar.jsp" %>
        <%@include file="Common_Components/sidebar.jsp" %>
    </body>
</html>
