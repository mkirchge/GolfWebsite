/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author maxkirchgesner
 */
public class Cart extends HttpServlet{
    
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
        // get the name of the product and the quantity
        String productname = (String)req.getParameter("product");
        

        // begin session
        ArrayList<String> shoppingcart = (ArrayList<String>) sesh.getAttribute("shoppingcart");
        
        if (shoppingcart.size() == 0){
            shoppingcart = new ArrayList<String>();
            shoppingcart.add(productname);
            
             try {
                Connection jdbcConnection = DatabaseConnect.getInstance();
                Statement statement = jdbcConnection.createStatement();
                String sql = "SELECT prod_name, price FROM golf";
                ResultSet resultSet = statement.executeQuery(sql);
                String total_price = "";
                
                while(resultSet.next()){
                    if(resultSet.getString("prod_name") == productname) {
                        total_price = resultSet.getString("price");
                    }
                }

                sesh.setAttribute("totalprice",total_price);

                resultSet.close();
                statement.close();

                } catch (SQLException sqlException) {
                    System.out.println("SQL Exception Error : " + sqlException.getMessage());
                }
            
        } else {
            shoppingcart.add(productname);
        }
        sesh.setAttribute("shoppingcart", shoppingcart);
        res.sendRedirect("MyProducts");
        
        pw.println("<h1>You have successfully added " + productname.replace("_", " ") + " to the cart</h1>");

    }
    
}