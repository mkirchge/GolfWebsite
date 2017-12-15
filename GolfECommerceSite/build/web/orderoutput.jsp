<%-- 
    Document   : orderoutput
    Created on : Jun 13, 2017, 8:22:19 PM
    Author     : maxkirchgesner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="style.css">
<html>
<br><br><h1><center>Thank you for your order!</center></h1><br>
<h2><center>Order Summary:</center></h2>
<center><table>
    <tr>
        <th><center>Name</center></th>
        <th><center>Phone Number</center></th>
        <th><center>Credit Card Name</center></th>
        <th><center>Credit Card #</center></th>
        <th><center>Credit Card Security #</center></th>
        <th><center>Billing Address</center></th>
        <th><center>Shipping Address</center></th>
    </tr>

    <tr>
        <th><center>${name}</center></th>
        <th><center>${phone}</center></th>
        <th><center>${ccname}</center></th>
        <th><center>${ccnum}</center></th>
        <th><center>${ccsn}</center></th>
        <th><center>${shipping}</center></th>
        <th><center>${billing}</center></th>
    </tr>

</table></center><br><br><br>
<a style="color:black;font-size:14px;font-family:Arial;" href="index.html"><center>CLICK HERE TO RETURN TO HOMEPAGE</center></a>
</html>
