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
import javax.servlet.RequestDispatcher;

/**
 *
 * @author maxkirchgesner
 */
public class OrderSummary extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        processRequest(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        processRequest(req, res);
    } 
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        
        Connection jdbcConnection = DatabaseConnect.getInstance();
        
        String name = (String)req.getParameter("firstname");
        String phone = (String)req.getParameter("phonenumber");
        String ccname = (String)req.getParameter("ccname");
        String ccnum = (String)req.getParameter("ccnumber");
        String ccsn = (String)req.getParameter("ccsn");
        String billing = (String)req.getParameter("billingaddress");
        String shipping = (String)req.getParameter("shippingaddress");
        
        try {
            String sql = "insert into myorders (name,phone,ccname,ccnum,ccsn,billing,shipping) values (?,?,?,?,?,?,?)";
            PreparedStatement stmt = jdbcConnection.prepareStatement(sql);
            stmt.setString(1,name);
            stmt.setString(2,phone);
            stmt.setString(3,ccname);
            stmt.setString(4,ccnum);
            stmt.setString(5,ccsn);
            stmt.setString(6,billing);
            stmt.setString(7,shipping);

            stmt.executeUpdate();
            
        } catch (SQLException sqlException) {
            System.out.println("SQL Exception Error : " + sqlException.getMessage());
        }
        
        RequestDispatcher reqdis = req.getRequestDispatcher("OrderOutput");
        reqdis.forward(req, res);
        
        
    }
    
}
