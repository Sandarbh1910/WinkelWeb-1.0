<%@page import="WinkelWeb_POJO.UserCredentialsPOJO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    UserCredentialsPOJO user=(UserCredentialsPOJO)session.getAttribute("current_user");
   
if(user!=null)
{
    if(user.getUser_type().equalsIgnoreCase("customer"))
   {
        session.setAttribute("message", "Unauthorised Access!. Do not try that again.");
   session.setAttribute("dcol","1");
   response.sendRedirect("customer.jsp");
    return;
   }
    else if(user.getUser_type().equalsIgnoreCase("merchant"))
    {
         session.setAttribute("message", "Unauthorised Access!. Do not try that again.");
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



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Feebacks</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
