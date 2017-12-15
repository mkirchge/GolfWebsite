/*
 To change this license header, choose License Headers in Project Properties.
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
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author maxkirchgesner
 */
public class MyProducts extends HttpServlet{
    
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
        HttpSession sesh = req.getSession(true);
       
        // Header/Beginning of Table
        pw.println("<!DOCTYPE html>");
        pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");

        pw.println("<html>");
            pw.println("<head>");
                pw.println("<div class=\"header\">");
                    pw.println("<img src=\"pics/logo.jpg\" alt=\"19th Hole Logo\" style=\"width:70px;height:120px;position:absolute;\">");
                    pw.println("<center id=\"pagetitle\"><b>The 19th Hole</b></center>");
                pw.println("</div>");
            pw.println("</head>");

            pw.println("<body>");
                pw.println("<div id=\"menu\">");
                    pw.println("<a href=\"index.html\">Home</a>");
                    pw.println("<a>  |  </a>");
                    pw.println("<a href=\"MyProducts\">Products</a>");
                    pw.println("<a>  |  </a>");
                    pw.println("<a href=\"contact.html\">Contact</a>");
                    pw.println("<a>  |  </a>");
                    pw.println("<a href=\"Checkout\">Checkout</a>");
                pw.println("</div>");


                pw.println("<h1 id=\"myheader\"><center>Products</center></h1>");
                pw.println("<h3 style=\"font-size:20px;font-family:Arial;\"><center>Click on picture for more details</center></h3>");
                
                // Cart
                pw.println("<table style=\"float:left;margin:10px;\">");
                pw.println("<tr>");
                    pw.println("<th>Cart</th>");
                pw.println("</tr>");

                ArrayList<String> prods = (ArrayList<String>) sesh.getAttribute("shoppingcart");

                if(sesh.isNew()) {
                    prods = new ArrayList<String>();
                } else {
                    prods = (ArrayList<String>)sesh.getAttribute("shoppingcart");
                }
                sesh.setAttribute("shoppingcart", prods);

                for (int i = 0; i < prods.size(); i++){
                    pw.println("<tr>");
                        pw.println("<th>" + prods.get(i).replace("_", " ") + "</th>");
                    pw.println("</tr>");
                }
                pw.println("</table>");
                
                
                pw.println("<center><table>");
                pw.println("<tr>");
                    pw.println("<th style=\"font-size:16px;\"><center>Product Name</center></th>");
                    pw.println("<th style=\"font-size:16px;\"><center>Picture</center></th>");
                    pw.println("<th style=\"font-size:16px;\"><center>Price</center></th>");
                pw.println("</tr>");
        
        // JDBC Connection
        
        try {    
            Connection jdbcConnection = DatabaseConnect.getInstance(); 
            Statement statement = jdbcConnection.createStatement();
            String sql = "SELECT * FROM golf";
            ResultSet resultSet = statement.executeQuery(sql);
            // Product Table 
            while (resultSet.next()) {
                pw.println("<tr>");
                pw.println("<td><center>" + resultSet.getString("prod_name").replace("_"," ")  + "</center></td>");
                pw.println("<td><a href=ProductDetails?product=" + resultSet.getString("prod_name") + "><img class=\"zoom\" src=" + resultSet.getString("image") + " alt=\"" + resultSet.getString("prod_name") +"\" style=\"width:200px;height:200px;\"></a></td>");
                pw.println("<td>$" + resultSet.getString("price") + "</td>");
                pw.println("</tr>");
            }
            resultSet.close();
            statement.close();
            
            pw.println("</table></center>");
        } catch (SQLException sqlException) {
            System.out.println("SQL Exception Error : " + sqlException.getMessage());
        }
        
        // Footer
                    pw.println("</body>");
            pw.println("<body>");
                pw.println("<div class=\"footer\">Created by Maximillian Kirchgesner 4/25/17</div>");
            pw.println("</body>");
        pw.println("</html>");

    }
    

}
