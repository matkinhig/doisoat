/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doisoat.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doisoat.models.VNPayModel;
import doisoat.services.TransactionServiceImpl;
import doisoat.utils.DBUtils;
import doisoat.utils.MyUtils;
import java.util.ArrayList;

/**
 *
 * @author lucnt
 */
@WebServlet(urlPatterns = {"/vnpay-timkiem"})
public class VnPayTransactionListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private TransactionServiceImpl transactionServiceImpl;

    public VnPayTransactionListServlet() {
        super();
        this.transactionServiceImpl = new TransactionServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);

        String errorString = null;
        List<VNPayModel> list = null;

        try {
            list = DBUtils.queryTransactionResult(conn);
        } catch (SQLException e) {
            errorString = e.getMessage();
        }
        // Lưu thông tin vào request attribute trước khi forward sang views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("resultList", list);

        // Forward sang /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/vnPayFilterView.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String errorString = null;
        List<VNPayModel> list = null;
        String systemTrace = request.getParameter("systemTrace");
        String dateF = request.getParameter("dateF");
        String dateT = request.getParameter("dateT");
        String accountNumber = request.getParameter("accountNumber");
        String amount = request.getParameter("amount");
        String listSelected = request.getParameter("listSelected");
        list = transactionServiceImpl.searchByTrace(systemTrace, dateF, dateT, accountNumber, amount, Integer.parseInt(listSelected));
        request.setAttribute("resultList", list);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/vnPayFilterView.jsp");
        dispatcher.forward(request, response);

    }
}
