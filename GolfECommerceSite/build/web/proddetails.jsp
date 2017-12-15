<%-- 
    Document   : proddetails
    Created on : Jun 13, 2017, 10:41:23 AM
    Author     : maxkirchgesner
--%>

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
        <ul id="detailedlist">



            <li><h2 id="testingtitles"><center>Detailed Description of <%= request.getAttribute("prod")%></center></h2></li>
            <br>
            <li>
                <img class="zoom" src=<%= request.getAttribute("image1")%> alt="pic1" border="1" style="width:200px;height:200px;border-color:black;" margin-right="1%">
                <img class="zoom" src=<%= request.getAttribute("image2")%> alt="pic2" border="1" style="width:200px;height:160px;border-color:black;" margin-right="1%">
            </li>
            <br><li><h3 id="testingtitles">Specifications:</h3></li><br><br>
            <li><%= request.getAttribute("detail1")%></li><br>
            <li><%= request.getAttribute("detail2")%></li><br>
            <li><%= request.getAttribute("detail3")%></li>

        </ul>

        <center><form id="addtocart" action="Cart" method="GET">
            Product:<br>
            <input value=<%= request.getAttribute("prod_name")%> type="text" name="product"><br><br>
            <input type="submit" value="Add To Cart" />
        </form></center>

    </body>

    <body>
        <div class="footer">Created by Maximillian Kirchgesner 4/25/17</div>
    </body>
</html>