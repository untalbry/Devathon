
package com.days100proyects.tipscalculator.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.Document;
import com.itextpdf.text.*;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@WebServlet(name = "SvTicket", urlPatterns = {"/SvTicket"})
public class SvTicket extends HttpServlet {

    
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
            double tipAmount = 0;
            double total = 0;
            int porcentage;
            int numberOfPeople ;
            double accountPerPerson=0;
           
            try{
                total = Double.parseDouble(request.getParameter("total"));
                porcentage = Integer.parseInt(request.getParameter("porcentage"));
                numberOfPeople = Integer.parseInt(request.getParameter("numPeople"));
                if(total>0){
                    tipAmount = (porcentage > 0)? (total * porcentage) /100.0 : 0;
                    accountPerPerson = (total + tipAmount)/numberOfPeople;
                }
                
            }catch(NumberFormatException e){
                System.out.println("Los parametros deben de ser números");
            } 

            Document document = new Document(new RectangleReadOnly(227, 300));
            try{
                PdfWriter.getInstance(document , response.getOutputStream());
                document.open();
                document.add(new Paragraph("====[RESTAURANTE]===="));
                document.add(new Paragraph("Cuenta: " + total));
                document.add(new Paragraph("Propina: " + tipAmount));
                document.add(new Paragraph("Total a pagar por persona: " + accountPerPerson));
                document.add(new Paragraph("======================"));
                document.add(new Paragraph("Total: " + (total+tipAmount)));
                document.close();
                
            }catch(DocumentException e){
                throw new ServletException(e); 
            }
            
            response.setContentType("tipscalculator/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=Tycket.pdf");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
