<%-- 
    Document   : checkoutpage
    Created on : Jun 13, 2017, 6:57:48 PM
    Author     : maxkirchgesner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="style.css">

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script>


    function validateForm() {
        var product_name = /^[A-Za-z0-9 ]{1,50}$/;
        var name = /^[A-Za-z ]{1,50}$/;
        var quantity = /^[1-9 ]{1,2}$/;
        var phonenumber = /^(?([0-9]{3}))?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
        var ccnumb = /^[0-9]{16}$/;
        var cc_sec_num = /^[0-9]{3}$/;
        var zip = /^[0-9]{5}$/;

        var a = document.forms["orderForm"]["prod_name"].value;
        var e = document.forms["orderForm"]["quantity"].value;
        var f = document.forms["orderForm"]["fname"].value;
        var g = document.forms["orderForm"]["lname"].value;
        var h = document.forms["orderForm"]["pnumber"].value;
        var i = document.forms["orderForm"]["ccname"].value;
        var j = document.forms["orderForm"]["ccnumber"].value;
        var k = document.forms["orderForm"]["ccsn"].value;
        var l = document.forms["orderForm"]["address"].value;
        var m = document.forms["orderForm"]["city"].value;
        var n = document.forms["orderForm"]["state"].value;
        var o = document.forms["orderForm"]["zip"].value;

        if (!product_name.test(a)){
                alert("That is not a valid product name");
                return false;
        }
        else if (!quantity.test(e)){
                alert("That is not a valid quantity");
                return false;
        }
        else if (!name.test(f)){
                alert("That is not a valid first name");
                return false;
        }
        else if (!name.test(g)){
                alert("That is not a valid last name");
                return false;
        }
        else if (!phonenumber.test(h)) {
                alert("That is not a valid phone number");
                return false;
                }
        else if (!name.test(i)){
                alert("That is not a valid name for your credit card");
                return false;
        }
        else if (j.length != 16){
                alert("That is not a valid credit card number");
                return false;
        }
        else if (k.length != 3){
                alert("That is not a valid credit card security number");
                return false;
        }
        else if (!zip.test(o)){
                alert("That is not a valid zip code");
                return false;
        }
        else if (a == "" || e == "" || f == "" || g == "" || h == "" || i == "" || j == "" || k == "" || l == "" || m == "" || n == "" || o == "") {
                alert("All fields must be filled out");
                return false;
        }
    }
</script>


<html>
        <head>
                <div class="header">
                        <img src="pics/logo.jpg" alt="19th Hole Logo" style="width:70px;height:120px;position:absolute;">
                        <center id="pagetitle"><b>The 19th Hole</b></center>
                </div>
        </head>

        <body id="homepage">
                <div id="menu">
                        <a href="index.html">Home</a>
                        <a>  |  </a>
                        <a href="productpage.jsp">Products</a>
                        <a>  |  </a>
                        <a href="contact.html">Contact</a>
                        <a>  |  </a>
                        <a href="checkoutpage.jsp">Checkout</a>
        </div>
                <form action="../jerseyrest/v1/api/orders" method="POST" name="orderForm" onsubmit="return validateForm()" enctype="text/plain"><fieldset>
                    <legend>Shipping Information</legend>
                    Name:<br>
                    <input type="text" name="firstname"><br><br>
                    Phone Number:<br>
                    <input type="text" name="phonenumber"><br><br>
                    Name On Credit Card:<br>
                    <input type="text" name="ccname"><br><br>
                    Credit Card Number:<br>
                    <input type="text" name="ccnumber"><br><br>
                    Credit Card Security Number:<br>
                    <input type="text" name="ccsn"><br><br>
                    Billing Address:<br>
                    <input type="text" name="billingaddress"><br><br>
                    Shipping Address:<br>
                    <input type="text" name="shippingaddress"><br><br>
                    <input type="submit" value="Submit" id="submit">
                </fieldset></form>
        </body>
        <body>
        <div class="footer">Created by Maximillian Kirchgesner 4/25/17</div>
        </body>	
</html>
