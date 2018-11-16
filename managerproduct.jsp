<%-- 
    Document   : managerproduct
    Created on : Oct 25, 2018, 3:32:20 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Product</title>
    </head>
    <body>
        <h3>Manager Product</h3>
        <font color="red">Welcome, ${sessionScope.USERNAME}</font><br/>

        <a href="logout">Logout</a><br/>
        <br/>
        <c:set var="result" value="${requestScope.PRODUCT}"/>   
        <c:if test="${not empty result}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Title</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Sizes</th>
                        <th>Delete</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${result}" var="dto" varStatus="counter">
                        <tr>
                            
                            <td>${counter.count}</td>
                            <td>${dto.description}</td>
                            <td>${dto.shoes.price}</td>
                            <td>${dto.shoes.quantity}</td>
                            <td>${dto.sizes}</td>
                            <td>
                                <c:url var="urlRewriting" value="deleteshoes.jsp">
                                    <c:param name="shoesID" value="${dto.shoes.shoesID}"/>
                                    <c:param name="description" value="${dto.description}"/>
                                    <c:param name="id" value="${dto.shoes.id}"/>
                                    <c:param name="sizes" value="${dto.sizes}"/>
                                </c:url>
                                <a href="${urlRewriting}">X</a>
                            </td>
                            <td>
                                <form action="editshoes.jsp" method="POST">
                                    <input type="submit" value="Edit" />
                                    <input type="hidden" name="shoesID" value="${dto.shoes.shoesID}" />
                                    <input type="hidden" name="id" value="${dto.shoes.id}" />
                                    <input type="hidden" name="description" value="${dto.description}" />
                                    <input type="hidden" name="price" value="${dto.shoes.price}" />
                                    <input type="hidden" name="quantity" value="${dto.shoes.quantity}" />
                                    <input type="hidden" name="sizes" value="${dto.sizes}" />
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty result}">
            No recording is matched !!!
        </c:if>
    </body>
</html>
