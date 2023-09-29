
package com.days100proyects.tipscalculator.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvTicket", urlPatterns = {"/SvTicket"})
public class SvTicket extends HttpServlet {
    private double tipAmount = 0;
    private double total = 0;
    private int porcentage = 0;
    private int numberOfPeople = 0;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try{
                    total =  Double.parseDouble(request.getParameter("total"));
                    porcentage = Integer.parseInt(request.getParameter("porcentage"));
                    numberOfPeople = Integer.parseInt(request.getParameter("numPeople"));
                    tipAmount = (total * porcentage) / (100 *numberOfPeople);
                }catch(NumberFormatException e){
                     tipAmount = (total * porcentage) / (100);
                }finally{
                    System.out.println("Total a pagar: " + tipAmount);

                }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
