/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reststuff;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.glassfish.jersey.client.ClientConfig;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.List;
import javax.servlet.ServletException;

/**
 *
 * @author maxkirchgesner
 */
public class golfServlet extends HttpServlet{
    
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        ClientConfig config = new ClientConfig();

        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(getBaseURI());


        String jsonResponse =
                target.path("v1").path("api").path("orders").
                        request(). //send a request
                        accept(MediaType.APPLICATION_JSON). //specify the media type of the response
                        get(String.class); // use the get method and return the response as a string

        System.out.println(jsonResponse);

        ObjectMapper objectMapper = new ObjectMapper(); // This object is from the jackson library

        List<orderdetails> orderSummary = objectMapper.readValue(jsonResponse, new TypeReference<List<orderdetails>>(){});

        PrintWriter out = response.getWriter();

        out.print("<html><head>" +
                "<title>REST Client</title>" +
                "</head>" +
                "<body>" +
                "<h2>REST response for GET call - /v1/api/todos</h2>" +
                "<ul>"
        );

        for(orderdetails gi : orderSummary) {
            out.print("<li>Name: ");
            out.print(gi.getName());
            out.print("</li>");
            out.print("<li>Phone: ");
            out.print(gi.getPhone());
            out.print("</li>");
            out.print("<li>Credit Card Name: ");
            out.print(gi.getCCName());
            out.print("</li>");
            out.print("<li>Credit Card Number: ");
            out.print(gi.getCCNum());
            out.print("</li>");
            out.print("<li>Credit Card Security Number: ");
            out.print(gi.getCCsn());
            out.print("</li>");
            out.print("<li> Billing Addres: ");
            out.print(gi.getBilling());
            out.print("</li>");
            out.print("<li>Shipping Address: ");
            out.print(gi.getShipping());
            out.print("</li>");
            
        }
        out.print("</ul>");

        out.print(
                "<h2>REST response for GET call - /v1/api/todos/1</h2>" +
                "<ul>"
        );

        String jsonResponse2 = target.path("v1").path("api").path("todos").path("1").
                        request(). //send a request
                        accept(MediaType.APPLICATION_JSON). //specify the media type of the response
                        get(String.class);
        
        System.out.println(jsonResponse2);

        orderdetails golfinfo = objectMapper.readValue(jsonResponse2, orderdetails.class);

        out.print("<li>Name: ");
        out.print(golfinfo.getName());
        out.print("</li>");
        out.print("<li>Phone: ");
        out.print(golfinfo.getPhone());
        out.print("</li>");
        out.print("<li>Credit Card Name: ");
        out.print(golfinfo.getCCName());
        out.print("</li>");
        out.print("<li>Credit Card Number: ");
        out.print(golfinfo.getCCNum());
        out.print("</li>");
        out.print("<li>Credit Card Security Number: ");
        out.print(golfinfo.getCCsn());
        out.print("</li>");
        out.print("<li> Billing Addres: ");
        out.print(golfinfo.getBilling());
        out.print("</li>");
        out.print("<li>Shipping Address: ");
        out.print(golfinfo.getShipping());
        out.print("</li>");

        out.print("</ul></body></html>");
        
        try {
            request.getRequestDispatcher("orderoutput.jsp").forward(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://andromeda-4.ics.uci.edu:5004/golfREST").build();
    }
    
}
