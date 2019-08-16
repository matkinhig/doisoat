/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doisoat.servlet;

/**
 *
 * @author lucnt
 */
import doisoat.models.VNPayModel;
import doisoat.services.IResultCompare;
import doisoat.services.TransactionServiceImpl;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "D:\\Documents\\NetBeansProjects\\DOISOAT\\web\\WEB-INF\\views\\datafile\\"; // duong dan towi folder chua file

    private TransactionServiceImpl transactionServiceImpl;
    private IResultCompare callback;

    public HomeServlet() {
        super();
        this.transactionServiceImpl = new TransactionServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Forward toi trang /WEB-INF/views/homeView.jsp
        // (Người dùng không bao giờ truy cập trực tiếp được vào các trang JSP
        // đặt trong WEB-INF)
        
        
        
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/homeView.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
