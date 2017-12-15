/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maxkirchgesner
 */
public class Checkout extends HttpServlet {
    
     /*
     * doGet/doPost/processRequest methods taken from Inf 124 Lecture 7 Slide 50
     */
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        processRequest(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        processRequest(req, res);
    } 
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = res.getWriter();
        
        // Print out the checkout page using code below and print writer print statements
        pw.println("<!DOCTYPE html>");
        pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");

        pw.println("<script src=\"//code.jquery.com/jquery-1.10.2.js\"></script>");
        pw.println("<script src=\"//code.jquery.com/ui/1.11.4/jquery-ui.js\"></script>");

        pw.println("<script>");

	
	pw.println("function validateForm() {");
		pw.println("var product_name = /^[A-Za-z0-9 ]{1,50}$/;");
		pw.println("var name = /^[A-Za-z ]{1,50}$/;");
		pw.println("var quantity = /^[1-9 ]{1,2}$/;");
		pw.println("var phonenumber = /^\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;");
		pw.println("var ccnumb = /^[0-9]{16}$/;");
		pw.println("var cc_sec_num = /^[0-9]{3}$/;");
		pw.println("var zip = /^[0-9]{5}$/;");
		
                pw.println("var a = document.forms[\"orderForm\"][\"prod_name\"].value;");
                pw.println("var e = document.forms[\"orderForm\"][\"quantity\"].value;");
                pw.println("var f = document.forms[\"orderForm\"][\"fname\"].value;");
                pw.println("var g = document.forms[\"orderForm\"][\"lname\"].value;");
                pw.println("var h = document.forms[\"orderForm\"][\"pnumber\"].value;");
                pw.println("var i = document.forms[\"orderForm\"][\"ccname\"].value;");
                pw.println("var j = document.forms[\"orderForm\"][\"ccnumber\"].value;");
                pw.println("var k = document.forms[\"orderForm\"][\"ccsn\"].value;");
                pw.println("var l = document.forms[\"orderForm\"][\"address\"].value;");
                pw.println("var m = document.forms[\"orderForm\"][\"city\"].value;");
                pw.println("var n = document.forms[\"orderForm\"][\"state\"].value;");
                pw.println("var o = document.forms[\"orderForm\"][\"zip\"].value;");
    	
                pw.println("if (!product_name.test(a)){");
                        pw.println("alert(\"That is not a valid product name\");");
                        pw.println("return false;");
                pw.println("}");
                pw.println("else if (!quantity.test(e)){");
                        pw.println("alert(\"That is not a valid quantity\");");
                        pw.println("return false;");
                pw.println("}");
                pw.println("else if (!name.test(f)){");
                        pw.println("alert(\"That is not a valid first name\");");
                        pw.println("return false;");
                pw.println("}");
                pw.println("else if (!name.test(g)){");
                        pw.println("alert(\"That is not a valid last name\");");
                        pw.println("return false;");
                pw.println("}");
                pw.println("else if (!phonenumber.test(h)) {");
                        pw.println("alert(\"That is not a valid phone number\");");
                        pw.println("return false;");
                        pw.println("}");
                pw.println("else if (!name.test(i)){");
                        pw.println("alert(\"That is not a valid name for your credit card\");");
                        pw.println("return false;");
                pw.println("}");
                pw.println("else if (j.length != 16){");
                        pw.println("alert(\"That is not a valid credit card number\");");
                        pw.println("return false;");
                pw.println("}");
                pw.println("else if (k.length != 3){");
                        pw.println("alert(\"That is not a valid credit card security number\");");
                        pw.println("return false;");
                pw.println("}");
                pw.println("else if (!zip.test(o)){");
                        pw.println("alert(\"That is not a valid zip code\");");
                        pw.println("return false;");
                pw.println("}");
                pw.println("else if (a == \"\" || e == \"\" || f == \"\" || g == \"\" || h == \"\" || i == \"\" || j == \"\" || k == \"\" || l == \"\" || m == \"\" || n == \"\" || o == \"\") {");
                        pw.println("alert(\"All fields must be filled out\");");
                        pw.println("return false;");
                pw.println("}");
	pw.println("}");
        pw.println("</script>");
        

        pw.println("<html>");
                pw.println("<head>");
                        pw.println("<div class=\"header\">");
                                pw.println("<img src=\"pics/logo.jpg\" alt=\"19th Hole Logo\" style=\"width:70px;height:120px;position:absolute;\">");
                                pw.println("<center id=\"pagetitle\"><b>The 19th Hole</b></center>");
                        pw.println("</div>");
                pw.println("</head>");

                pw.println("<body id=\"homepage\">");
                        pw.println("<div id=\"menu\">");
                                pw.println("<a href=\"index.html\">Home</a>");
                                pw.println("<a>  |  </a>");
                                pw.println("<a href=\"MyProducts\">Products</a>");
                                pw.println("<a>  |  </a>");
                                pw.println("<a href=\"contact.html\">Contact</a>");
                                pw.println("<a>  |  </a>");
                                pw.println("<a href=\"Checkout\">Checkout</a>");
                pw.println("</div>");
                        pw.println("<form action=\"OrderSummary\" method=\"get\" name=\"orderForm\" onsubmit=\"return validateForm()\" enctype=\"text/plain\"><fieldset>");
                            pw.println("<legend>Shipping Information</legend>");
                            pw.println("Name:<br>");
                            pw.println("<input type=\"text\" name=\"firstname\"><br><br>");
                            pw.println("Phone Number:<br>");
                            pw.println("<input type=\"text\" name=\"phonenumber\"><br><br>");
                            pw.println("Name On Credit Card:<br>");
                            pw.println("<input type=\"text\" name=\"ccname\"><br><br>");
                            pw.println("Credit Card Number:<br>");
                            pw.println("<input type=\"text\" name=\"ccnumber\"><br><br>");
                            pw.println("Credit Card Security Number:<br>");
                            pw.println("<input type=\"text\" name=\"ccsn\"><br><br>");
                            pw.println("Billing Address:<br>");
                            pw.println("<input type=\"text\" name=\"billingaddress\"><br><br>");
                            pw.println("Shipping Address:<br>");
                            pw.println("<input type=\"text\" name=\"shippingaddress\"><br><br>");
                            pw.println("<input type=\"submit\" value=\"Submit\" id=\"submit\">");
                        pw.println("</fieldset></form>");
                pw.println("</body>");
                pw.println("<body>");
                pw.println("<div class=\"footer\">Created by Maximillian Kirchgesner 4/25/17</div>");
                pw.println("</body>");	
        pw.println("</html>");
        
    }
    
}