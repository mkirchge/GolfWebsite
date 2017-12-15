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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 *
 * @author maxkirchgesner
 */
public class SessionTracking extends HttpServlet{
    
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
        HttpSession sesh = req.getSession(true);
        String product = (String)req.getParameter("product");
        ArrayList<String> myproducts = new ArrayList<String>();
               
        if(sesh.isNew()) {
            myproducts.add(product);
        } else {
            myproducts = (ArrayList<String>)sesh.getAttribute("shoppingcart");
            myproducts.add(product);
        }
        sesh.setAttribute("shoppingcart",myproducts);

        try {
            Connection jdbcConnection = DatabaseConnect.getInstance();
            Statement statement = jdbcConnection.createStatement();
            String sql = "SELECT prod_name, price FROM golf";
            ResultSet resultSet = statement.executeQuery(sql);
            Integer total_price = 0;

            while(resultSet.next()) {
                for (int i = 0; i < myproducts.size(); i++){
                    if (myproducts.get(i) == resultSet.getString("prod_name")){
                        total_price = total_price + Integer.parseInt(resultSet.getString("price"));                         
                    }
                }
            }
            sesh.setAttribute("totalprice",total_price);

            resultSet.close();
            statement.close();

        } catch (SQLException sqlException) {
            System.out.println("SQL Exception Error : " + sqlException.getMessage());
        }

        // Removes oldest viewed item from session if there are 5 in it
        ArrayList<String> prods = (ArrayList<String>) sesh.getAttribute("shoppingcart");
        if (prods.size() > 5){
            prods.remove(prods.get(prods.size() - 1));
        }
    }   
}