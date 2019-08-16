/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doisoat.servlet;

import doisoat.services.TransactionServiceImpl;
import doisoat.models.VNPayModel;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucnt
 */
@WebServlet(urlPatterns = {"/vnpay-doisoat"})
public class VnPayCompareListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "D:\\Documents\\NetBeansProjects\\DOISOAT\\web\\WEB-INF\\views\\datafile\\"; // duong dan towi folder chua file

    private TransactionServiceImpl transactionServiceImpl;

    ArrayList<VNPayModel> results = null;
    ArrayList<VNPayModel> errorList = null;

    DateFormat fmt = new SimpleDateFormat("yyMMdd");
    String name = fmt.format(new java.util.Date());

    public VnPayCompareListServlet() {
        super();
        this.transactionServiceImpl = new TransactionServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fromDate = request.getParameter("fromDate");
        String toDate = request.getParameter("toDate");
        String fileName = request.getParameter("file");
        String action = request.getParameter("action");
        File file = new File(UPLOAD_DIRECTORY + fileName);
        if (this.transactionServiceImpl.compareData(file, fromDate, toDate)) {
            //Results List and Error List
            results = this.transactionServiceImpl.getResults();
            errorList = this.transactionServiceImpl.getErrorList();
            this.transactionServiceImpl.setResults(results);
            this.transactionServiceImpl.setResults(errorList);
        }
        if (null != action) {
            switch (action) {
                case "doisoat": {
                    request.setAttribute("errorList", errorList);
                    request.setAttribute("resultList", results);
                    RequestDispatcher dispatcher = request.getServletContext()
                            .getRequestDispatcher("/WEB-INF/views/vnPayDoiSoatView.jsp");
                    dispatcher.forward(request, response);
                    break;
                }
                case "xuatexcel": {
                    request.setAttribute("resultList", results);
                    String exportExcel = this.transactionServiceImpl.exportExcel(results);
                    System.out.println(exportExcel);
                    RequestDispatcher dispatcher = request.getServletContext()
                            .getRequestDispatcher("/WEB-INF/views/vnPayDoiSoatView.jsp");
                    dispatcher.forward(request, response);
                    break;
                }
                case "luucsdl": {
                    request.setAttribute("resultList", results);
                    try {
                        this.transactionServiceImpl.writeData(results, errorList, "D:/" + name + "_TRANS_DISPUTE_VIETBANK.txt");
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(VnPayCompareListServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    RequestDispatcher dispatcher = request.getServletContext()
                            .getRequestDispatcher("/WEB-INF/views/vnPayDoiSoatView.jsp");
                    dispatcher.forward(request, response);
                    break;
                }
                default:
                    break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/vnPayDoiSoatView.jsp");
        dispatcher.forward(req, resp);
    }

}
