<%-- 
    Document   : createnewshoes
    Created on : Nov 2, 2018, 12:13:50 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="error" value="${requestScope.INSERTER}"/>

        <form action="updateShoes" method="POST">

            <c:if test="${not empty error.descriptionErr}">
                <font color="red">
                ${error.descriptionErr}<br/>
                </font>
            </c:if>
            Title* <input type="text" name="description" value="${param.description}" /><br/>

            <c:if test="${not empty error.priceErr}">
                <font color="red">
                ${error.priceErr}<br/>
                </font>
            </c:if>
                Price* <input type="text" name="price" value="${param.price}" /><br/>
            <c:if test="${not empty error.quantityErr}">
                <font color="red">
                ${error.quantityErr}<br/>
                </font>
            </c:if>
            Quantity* <input type="text" name="quantity" value="${param.quantity}" /><br/>

            <c:if test="${not empty error.sizesErr}">
                <font color="red">
                ${error.sizesErr}<br/>
                </font>
            </c:if>
                Sizes* <input type="text" name="sizes" value="${param.sizes}" /><br/>

            <input type="hidden" name="id" value="${param.id}" />
            <input type="hidden" name="shoesID" value="${param.shoesID}" />
            <input type="submit" value="Update" /><br/>
        </form>
            <br/>
            <br/>
            <br/>
            
            
            <c:set var="errors" value="${requestScope.CREATE}"/>
        <form action="createShoes">
            <c:if test="${not empty errors.ShoesID}">
                <font color="red">
                ${errors.ShoesID}<br/>
                </font>
            </c:if>
            ShoesID* <input type="text" name="shoesID" value="" /><br/>
             <c:if test="${not empty errors.descriptionErr}">
                <font color="red">
                ${errors.descriptionErr}<br/>
                </font>
            </c:if>
            Title* <input type="text" name="description" value="" /><br/>

            <c:if test="${not empty errors.priceErr}">
                <font color="red">
                ${errors.priceErr}<br/>
                </font>
            </c:if>
                Price* <input type="text" name="price" value="" /><br/>
            <c:if test="${not empty errors.quantityErr}">
                <font color="red">
                ${errors.quantityErr}<br/>
                </font>
            </c:if>
            Quantity* <input type="text" name="quantity" value="" /><br/>

            <c:if test="${not empty errors.sizesErr}">
                <font color="red">
                ${errors.sizesErr}<br/>
                </font>
            </c:if>
                Sizes* <input type="text" name="sizes" value="" /><br/>
             
                Country* <input type="text" name="country" value="" /><br/>
            <input type="hidden" name="id" value="${param.id}" />
            <input type="hidden" name="shoesID" value="${param.shoesID}" />
            <input type="submit" value="Create New Shoes" /><br/>
        </form>
        <form action ="productList" method="POST">
            <input type="submit" value="Cancel" /><br/>
        </form>
    </body>
</html>
