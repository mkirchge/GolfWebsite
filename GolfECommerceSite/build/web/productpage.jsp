<%-- 
    Document   : productpage
    Created on : Jun 2, 2017, 1:20:21 PM
    Author     : maxkirchgesner
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<%@page import = "java.io.*"%>
<%@page import = "java.util.*"%>
<%@page import = "java.sql.*"%>
<%@page import = "javax.servlet.http.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="style.css">
<html>
    <head>
        <div class="header">
            <img src="pics/logo.jpg" alt="19th Hole Logo" style="width:70px;height:120px;position:absolute;">
            <center id="pagetitle"><b>The 19th Hole</b></center>
        </div>
    </head>

    <body>
        <div id="menu">
            <a href="index.html">Home</a>
            <a>  |  </a>
            <a href="productpage.jsp">Products</a>
            <a>  |  </a>
            <a href="contact.html">Contact</a>
            <a>  |  </a>
            <a href="checkoutpage.jsp">Checkout</a>
        </div>


        <h1 id="myheader"><center>Products</center></h1>
        <h3 style="font-size:14px;"><center>Click on picture for more details</center></h3>

        <!--<table style="float:left;margin:10px;">-->
        <!--<tr>-->
            <!--<th>Cart</th>-->
        <!--</tr>-->

        <%--<core:forEach var="photo" items="${image}" >--%>
        
        
        
        
       <!--ArrayList<String> prods = (ArrayList<String>) sesh.getAttribute("shoppingcart-->

       <!--if(sesh.isNew()) {-->
<!--           prods = new ArrayList<String>();
       } else {
           prods = (ArrayList<String>)sesh.getAttribute("shoppingcart
       }
       sesh.setAttribute("shoppingcart", prods);

       for (int i = 0; i < prods.size(); i++){
           <tr>
               <th>" + prods.get(i).replace("_", " ") + "</th>
           </tr>
       }
       </table>-->

        
    <center><table>
        <tr>
            <th style="font-size:16px;"><center>Product Name</center></th>
            <th style="font-size:16px;"><center>Picture</center></th>
            <th style="font-size:16px;"><center>Price</center></th>
        </tr>
        <tr>
            <td><center>${it.prod_name}</center></td>
        </tr>
        <c:forEach var="row" items="${golf}">
            <tr>
                <td><center>${row.prod_name}</center></td>
                <td><a href="proddetails.jsp?prod=${row.prod_name}"</td>
                <td>${row.price}</td>
            </tr>
        </c:forEach>
    </table></center>


            </body>
    <body>
        <div class="footer">Created by Maximillian Kirchgesner 4/25/17</div>
    </body>
</html>