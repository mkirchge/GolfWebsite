/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author maxkirchgesner
 */
public class ProductDetails extends HttpServlet{
    
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
        
        pw.println("<!DOCTYPE html>");
        pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
        pw.println("<html>");
            pw.println("<head>");
                pw.println("<div class=\"myheader\">");
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
        pw.println("<ul id=\"detailedlist\">");
        
        ArrayList<String> myproducts = new ArrayList<String>();

        // JDBC Connection
        
        try {
            Connection jdbcConnection = DatabaseConnect.getInstance();
            Statement statement = jdbcConnection.createStatement();
            String sql = "SELECT * FROM golf WHERE prod_name=\"" + req.getParameter("product") + "\"";
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()) {

                pw.println("<li><h2 id=\"testingtitles\"><center>Detailed Description of " + resultSet.getString("prod_name").replace("_"," ") + "</center></h2></li>");
                pw.println("<br>");
                pw.println("<li>");
                    pw.println("<img class=\"zoom\" src=" + resultSet.getString("image1") + " alt=\"pic1\" border=\"1\" style=\"width:200px;height:200px;border-color:black;\" margin-right=\"1%\">");
                    pw.println("<img class=\"zoom\" src=" + resultSet.getString("image2") + " alt=\"pic2\" border=\"1\" style=\"width:200px;height:160px;border-color:black;\" margin-right=\"1%\">");
                pw.println("</li>");
                pw.println("<br><li><h3 id=\"testingtitles\">Specifications:</h3></li><br><br>");
                pw.println("<li> $" + resultSet.getString("price") + "</li><br>");
                pw.println("<li>" + resultSet.getString("detail1") + "</li><br>");
                pw.println("<li>" + resultSet.getString("detail2") + "</li>");

                pw.println("</ul>");
                
                pw.println("<center><form id=\"addtocart\" action=\"Cart\" method=\"GET\">");
                    pw.println("Product:<br>");
                    pw.println("<input value=\"" + resultSet.getString("prod_name") + "\"type=\"text\" name=\"product\"><br><br>");
                    pw.println("<input type=\"submit\" value=\"Add To Cart\" />");
                pw.println("</form></center>");
            }
            
            resultSet.close();
            statement.close();
               
            if(sesh.isNew()) {
                myproducts.add(resultSet.getString("product_name"));
            } else {
                myproducts = (ArrayList<String>)sesh.getAttribute("shoppingcart");
                myproducts.add(resultSet.getString("product_name"));
            }
            sesh.setAttribute("shoppingcart", myproducts);
            
            
            RequestDispatcher reqdis = req.getRequestDispatcher("SessionTracking");
            reqdis.include(req, res);
            
        } catch (SQLException sqlException) {
            System.out.println("SQL Exception Error : " + sqlException.getMessage());
        }
        
        
                    pw.println("</body>");
            pw.println("<body>");
                pw.println("<div class=\"footer\">Created by Maximillian Kirchgesner 4/25/17</div>");
            pw.println("</body>");
        pw.println("</html>");
        
    }
    
}