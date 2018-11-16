<%-- 
    Document   : deleteshoes
    Created on : Nov 3, 2018, 8:39:53 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Page</title>
    </head>
    <body>
        <h1>Confirm</h1>
        <h3>Do you want to delete this ${param.description} shoes</h3>
        <form action="deleteShoes" method="POST">
            <input type="submit" value="OK" name="btAction" />
            <input type="submit" value="Cancel" name="btAction" />
            <input type="hidden" name="ShoesID" value="${param.shoesID}" />
            <input type="hidden" name="id" value="${param.id}" />
        </form>
    </body>
</html>
