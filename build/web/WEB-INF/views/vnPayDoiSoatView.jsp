
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
        <main>
            <jsp:include page="_settings.jsp"></jsp:include>
                <!-- Side Panel -->
            <jsp:include page="_topbar.jsp"></jsp:include>

                <div class="content-inner remove-ext5">
                    <div class="row mrg20">
                        <div class="col-md-12 col-sm-12 col-lg-12">
                            <div class="wdgt-box typo-wrp">
                                <div class="wdgt-titl">
                                    <h4>Checkout System VNPAY</h4>
                                    <p>Điền thông tin để tiến hành đối soát dữ liệu hệ thống VNPAY</p>
                                </div>
                                <div class="hed-dta">
                                    <form class="cont-frm" method="POST" action="${pageContext.request.contextPath}/vnpay-doisoat" >
                                    <div class="row">
                                        <div class="col-md-3">
                                            <input required id="fromDate" name="fromDate" type="date" />
                                        </div>
                                        <div class="col-md-3">
                                            <input required id="toDate" name="toDate" type="date" />
                                        </div>
                                        <div class="file-loading col-md-4">
                                            <input required id="input-b6" name="file" type="file">
                                        </div>
                                        <div class="col-md-2">
                                            <button name="action" value="doisoat" type="submit" style="height: 50px; width: 190px; text-align: center;background-color: #e7e7e7; color: black;" >
                                                Đối soát</button>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <h5 style="margin: 10px;">Action với dữ liệu :</h5>
                                        <button class="btn" type="button" onclick="xuatExcel();" name="action" value="xuatexcel" style="margin: 10px; background-color: #008CBA; color: white">
                                            <i class="fa fa-save" aria-hidden="true"></i>Xuất Excel</button>
                                        <button class="btn" type="button" onclick="luuCSDL();" name="action" value="luucsdl" style="margin: 10px; background-color:#f44336;color: white">
                                            <i class="fa fa-send" aria-hidden="true"></i> Gửi VNPAY và Lưu vào CSDL</button>
                                        <button type="button" onclick="location.href = '${pageContext.request.contextPath}/vnpay-timkiem'" style="margin: 10px;" class="btn btn-success"><i class="fa fa-search" aria-hidden="true"></i> Truy vấn </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="content-wrap">
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

            <script type="text/javascript">
                                            function xuatExcel() {
                                                $.ajax({
                                                    url: '${pageContext.request.contextPath}/vnpay-doisoat?action=xuatexcel',
                                                    method: 'POST',
                                                }).done(function () {
                                                    alert("Xuất File Excel thành công, kiểm tra ổ D:/");
                                                });
                                            }
        </script>
        <script type="text/javascript">
            function luuCSDL() {
                $.ajax({
                    url: '${pageContext.request.contextPath}/vnpay-doisoat?action=luucsdl',
                    method: 'POST',
                }).done(function () {
                    alert("Lưu vào CSDL và Gửi cho VNPay thành Công. Kiểm tra chi tiết ổ D:/");
                });
            }
        </script>
        <script>
            $(window).on('beforeunload', function () {
                localStorage.setItem("fromDate", document.getElementById("fromDate").value);
                localStorage.setItem("toDate", document.getElementById("toDate").value);
                localStorage.setItem("input", document.getElementById("input-b6").value);
            });

        </script>
        <script>
            $(document).ready(function () {
                document.getElementById("fromDate").value = localStorage.getItem("fromDate");
                document.getElementById("toDate").value = localStorage.getItem("toDate");
                document.getElementById("input-b6").value = localStorage.getItem("input");
            });
        </script>

    </body>
</html>

