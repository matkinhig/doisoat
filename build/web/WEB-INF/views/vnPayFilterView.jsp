<%-- 
    Document   : vnPayFilter
    Created on : Aug 9, 2019, 1:24:54 PM
    Author     : lucnt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <link rel="icon" href="assets/images/icon.png" sizes="32x32" type="image/png">
        <title>Vietbank - Checkout System</title>

        <link rel="stylesheet" href="assets/css/icons.min.css">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/plugins.min.css">
        <link rel="stylesheet" href="assets/css/calendar-core-main.min.css">
        <link rel="stylesheet" href="assets/css/calendar-daygrid-main.min.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/responsive.css">
        <!-- Color Scheme -->
        <link rel="stylesheet" href="assets/css/colors/color.css" title="theme-color1">
        <link rel="alternate stylesheet" href="assets/css/colors/color2.css" title="theme-color2">
        <link rel="alternate stylesheet" href="assets/css/colors/color3.css" title="theme-color3">
        <link rel="alternate stylesheet" href="assets/css/colors/color4.css" title="theme-color4">
        <link rel="alternate stylesheet" href="assets/css/colors/color5.css" title="theme-color5">
        <link rel="alternate stylesheet" href="assets/css/colors/color6.css" title="theme-color6">
        <link rel="alternate stylesheet" href="assets/css/colors/color7.css" title="theme-color7">
        <link rel="alternate stylesheet" href="assets/css/colors/color8.css" title="theme-color8">
        <link rel="alternate stylesheet" href="assets/css/colors/color9.css" title="theme-color9">
    </head>
    <body class="gray-bg">
        <main >
            <jsp:include page="_settings.jsp"></jsp:include>
                <!-- Side Panel -->
            <jsp:include page="_topbar.jsp"></jsp:include>
                <!-- Header -->

                <!-- main layout here-->
                <div class="content-wrap">
                    <div class="content-inner remove-ext5">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="wdgt-box chckut-wrp">
                                    <form action="${pageContext.request.contextPath}/vnpay-timkiem" method="POST">
                                    <div class="chckut-innr">
                                        <div class="wdgt-titl">
                                            <h4>Truy vấn thông tin</h4>
                                            <p>Please fill out the form below Form for Research.</p>
                                        </div>
                                        <div class="chckut-inr">
                                            <div class="row">
                                                <div class="col-md-2">
                                                    <input id="systemTrace" name="systemTrace" type="text"
                                                           placeholder="Số trade...">
                                                </div>
                                                <div class="col-md-2">
                                                    <input id="dateF" name="dateF" type="date">
                                                </div>
                                                <div class="col-md-2">
                                                    <input id="dateT" name="dateT" type="date">
                                                </div>
                                                <div class="col-md-2">
                                                    <input id="accountNumber" name="accountNumber" type="text" 
                                                           placeholder="Số tài khoản...">
                                                </div>
                                                <div class="col-md-2">
                                                    <input id="amount" name="amount" type="text"
                                                           placeholder="Số tiền">
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="slct-box2"  style="margin-top: -5px;">
                                                        <select name="listSelected">
                                                            <option value="0">Tất cả</option>
                                                            <option value="1">BANK có, VNPAY không</option>
                                                            <option value="2">BANK không, VNPAY có</option>
                                                        </select>
                                                    </div>
                                                </div>                                                
                                            </div>
                                            <div class="row">
                                                <button type="submit" style="margin-left: 15px;height: 50px; width: 180px; text-align: center;background-color: red;"><i
                                                        class="fa fa-paper-plane"></i>Search</button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>                   
                    </div>
                </div>
            </div>

            <!-- Contant Wrap -->

            <div class="wdgt-box tabl-wrp">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th data-toggle="tooltip" title="Số tài khoản" scope="col">Số tài khoản</th>
                            <th data-toggle="tooltip" title="Mã xử lý" scope="col">Mã xử lý</th>
                            <th data-toggle="tooltip" title="Số tiền giao dịch" scope="col">Tiền giao dịch</th>
                            <th data-toggle="tooltip" title="Số trace hệ thống" scope="col">Số trace</th>
                            <th data-toggle="tooltip" title="Mã giao dịch" scope="col">Mã giao dịch</th>
                            <th data-toggle="tooltip" title="Giờ giao dịch" scope="col">Giờ giao dịch</th>
                            <th data-toggle="tooltip" title="Ngày giao dịch" scope="col">Ngày giao dịch</th>
                            <th data-toggle="tooltip" title="Ngày thanh toán" scope="col">Ngày thanh toán</th>
                            <th data-toggle="tooltip" title="Loại thiết bị" scope="col">Thiết bị</th>
                            <th data-toggle="tooltip" title="Mã tổ chức khởi tạo giao dịch" scope="col">Mã tổ chức</th>
                            <th data-toggle="tooltip" title="Số cấp phép giao dịch" scope="col">Số cấp phép</th>
                            <th data-toggle="tooltip" title="Mã số trả lời giao dịch" scope="col">Mã trả lời</th>
                            <th data-toggle="tooltip" title="Mã số xử lý giao dịch" scope="col">Mã xử lý</th>
                            <th data-toggle="tooltip" title="Mã số thiết bị chấp nhận thẻ" scope="col">Mã thiết bị</th>
                            <th data-toggle="tooltip" title="Thông tin bổ sung" scope="col">Thông tin</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- code body here-->
                        <c:forEach items="${resultList}" var="rs" >
                            <tr>
                                <td>${rs.accountNumber}</td>
                                <td>${rs.processingCode}</td>
                                <td> <fmt:formatNumber pattern="#,##0.00" value="${rs.amount}"/></td>
                                <td>${rs.systemTrace}</td>
                                <td>${rs.transactionCode}</td>
                                <td>${rs.transactionTime}</td>
                                <td>${rs.transactionDate}</td>
                                <td>${rs.paymentDate}</td>
                                <td>${rs.deviceType}</td>
                                <td>${rs.maKhoiTaoGiaoDich}</td>
                                <td>${rs.soGiaoDich}</td>
                                <td></td>
                                <td>${rs.processingCompareCode}</td>
                                <td>${rs.maSoThietBiChapNhanThe}</td>
                                <td>${rs.thongTinBonus}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>


            <jsp:include page="_footer.jsp"></jsp:include>
            <!-- footer -->
        </main>
        <!-- include script-->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/chart-core.js"></script>
        <script src="assets/js/charts.js"></script>
        <script src="assets/js/animated.js"></script>
        <script src="assets/js/pie-chart1.js"></script>
        <script src="assets/js/chart1.js"></script>
        <script src="assets/js/chart2.js"></script>
        <script src="assets/js/chart3.js"></script>
        <script src="assets/js/calendar-core-main.min.js"></script>
        <script src="assets/js/calendar-interaction-main.min.js"></script>
        <script src="assets/js/calendar-daygrid-main.min.js"></script>
        <script src="assets/js/calendar-int.js"></script>
        <script src="assets/js/plugins.min.js"></script>
        <script src="assets/js/custom-scripts.js"></script>

        <script>
            $(window).on('beforeunload', function () {
                localStorage.setItem("systemTrace", document.getElementById("systemTrace").value);
                localStorage.setItem("dateF", document.getElementById("dateF").value);
                localStorage.setItem("dateT", document.getElementById("dateT").value);
                localStorage.setItem("accountNumber", document.getElementById("accountNumber").value);
                localStorage.setItem("amount", document.getElementById("amount").value);
            });

        </script>
        <script>
            $(document).ready(function () {
                document.getElementById("systemTrace").value = localStorage.getItem("systemTrace");
                document.getElementById("dateF").value = localStorage.getItem("dateF");
                document.getElementById("dateT").value = localStorage.getItem("dateT");
                document.getElementById("accountNumber").value = localStorage.getItem("accountNumber");
                document.getElementById("amount").value = localStorage.getItem("amount");
            });
        </script>

    </body>
</html>
