/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;

/**
 *
 * @author maxkirchgesner
 */
public class OrderOutput extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        processRequest(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        processRequest(req, res);
    } 
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        PrintWriter pw = res.getWriter();
        HttpSession sesh = req.getSession(true);
        
        pw.println("<!DOCTYPE html>");
        pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
        pw.println("<html>");
        pw.println("<br><br><h1><center>Thank you for your order!</center></h1><br>");
        pw.println("<h2><center>Order Summary:</center></h2>");
        pw.println("<center><table>");
                pw.println("<tr>");
                    pw.println("<th><center>Name</center></th>");
                    pw.println("<th><center>Phone Number</center></th>");
                    pw.println("<th><center>Credit Card Name</center></th>");
                    pw.println("<th><center>Credit Card #</center></th>");
                    pw.println("<th><center>Credit Card Security #</center></th>");
                    pw.println("<th><center>Billing Address</center></th>");
                    pw.println("<th><center>Shipping Address</center></th>");
                pw.println("</tr>");
                
        try {
            Connection jdbcConnection2 = DatabaseConnect.getInstance();
            Statement statement = jdbcConnection2.createStatement();
            String sql = "SELECT * FROM myorders";
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                pw.println("<tr>");
                        pw.println("<th><center>" + resultSet.getString("name") + "</center></th>");
                        pw.println("<th><center>" + resultSet.getString("phone") + "</center></th>");
                        pw.println("<th><center>" + resultSet.getString("ccname") + "</center></th>");
                        pw.println("<th><center>" + resultSet.getString("ccnum") + "</center></th>");
                        pw.println("<th><center>" + resultSet.getString("ccsn") + "</center></th>");
                        pw.println("<th><center>" + resultSet.getString("billing") + "</center></th>");
                        pw.println("<th><center>" + resultSet.getString("shipping") + "</center></th>");
                    pw.println("</tr>");
            }
 
        } catch (SQLException sqlException) {
            System.out.println("SQL Exception Error : " + sqlException.getMessage());
        }
                
        pw.println("</table></center><br><br><br>");
        pw.println("<a style=\"color:black;font-size:14px;font-family:Arial;\" href=\"index.html\"><center>CLICK HERE TO RETURN TO HOMEPAGE</center></a>");
        pw.println("</html>");
    }
    
}
