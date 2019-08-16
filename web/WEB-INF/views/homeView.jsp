<%-- 
    Document   : homeView
    Created on : Aug 8, 2019, 4:39:56 PM
    Author     : lucnt
--%>

<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

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

                <!-- main layout-->
                <div class="content-wrap">
                    <div class="home-title">
                        <h1>Hệ thống tra cứu đối soát <strong><span>VIETBANK</span></strong></h1>
                        <p>VIETBANK control search system</p>
                    </div>
                    <div class="content-inner remove-ext5">
                        <div class="row mrg20">
                            <div class="col-md-3 col-sm-6 col-lg-3">
                                <div class="wdgt-box stats-box box-blu">
                                    <div class="wdgt-opt">
                                        <a class="refrsh-btn" href="#" title=""><i class="icon ion-ios-reload"></i></a>
                                        <a class="expnd-btn" href="#" title=""><i class="icon ion-arrow-expand"></i></a>
                                    </div>
                                    <div class="wdgt-ldr">
                                        <div class="ball-pulse">
                                            <div></div>
                                            <div></div>
                                            <div></div>
                                        </div>
                                    </div>
                                    <i class="icon ion-arrow-graph-up-right"></i>
                                    <div class="stats-inr">
                                        <h6><span class="counter">789</span>K</h6>
                                        <span>Dữ liệu xử lý</span>
                                    </div>
                                    <div class="progress">
                                        <div class="progress-bar wdth100"><span>100%</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6 col-lg-3">
                                <div class="wdgt-box stats-box box-prpl">
                                    <div class="wdgt-opt">
                                        <a class="refrsh-btn" href="#" title=""><i class="icon ion-ios-reload"></i></a>
                                        <a class="expnd-btn" href="#" title=""><i class="icon ion-arrow-expand"></i></a>
                                    </div>
                                    <div class="wdgt-ldr">
                                        <div class="ball-pulse">
                                            <div></div>
                                            <div></div>
                                            <div></div>
                                        </div>
                                    </div>
                                    <i class="icon ion-android-desktop"></i>
                                    <div class="stats-inr">
                                        <h6><span class="counter">100</span>K</h6>
                                        <span>Uptime</span>
                                    </div>
                                    <div class="progress">
                                        <div class="progress-bar wdth100"><span>100%</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6 col-lg-3">
                                <div class="wdgt-box stats-box box-red">
                                    <div class="wdgt-opt">
                                        <a class="refrsh-btn" href="#" title=""><i class="icon ion-ios-reload"></i></a>
                                        <a class="expnd-btn" href="#" title=""><i class="icon ion-arrow-expand"></i></a>
                                    </div>
                                    <div class="wdgt-ldr">
                                        <div class="ball-pulse">
                                            <div></div>
                                            <div></div>
                                            <div></div>
                                        </div>
                                    </div>
                                    <i class="icon ion-ios-person-outline"></i>
                                    <div class="stats-inr">
                                        <h6><span class="counter">349</span>K</h6>
                                        <span>Quản lý ID</span>
                                    </div>
                                    <div class="progress">
                                        <div class="progress-bar wdth80"><span>80%</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6 col-lg-3">
                                <div class="wdgt-box stats-box box-grn">
                                    <div class="wdgt-opt">
                                        <a class="refrsh-btn" href="#" title=""><i class="icon ion-ios-reload"></i></a>
                                        <a class="expnd-btn" href="#" title=""><i class="icon ion-arrow-expand"></i></a>
                                    </div>
                                    <div class="wdgt-ldr">
                                        <div class="ball-pulse">
                                            <div></div>
                                            <div></div>
                                            <div></div>
                                        </div>
                                    </div>
                                    <i class="icon ion-social-usd-outline"></i>
                                    <div class="stats-inr">
                                        <h6><span class="counter">120</span>Tỷ</h6>
                                        <span>Tổng tiền</span>
                                    </div>
                                    <div class="progress">
                                        <div class="progress-bar wdth100"><span>100%</span></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--form Vnpay-->
                        <div class="wdgt-box tabl-wrp">
                            <div class="row">
                                <h4 style="margin: 10px;">Hệ thống đối soát VNPAY</h4>
                                <button onclick="location.href = '${pageContext.request.contextPath}/vnpay-doisoat'" style="margin: 10px;" class="btn btn-primary"><i class="fa fa-save" aria-hidden="true"></i>
                                Đối soát hệ thống VNPAY</button>
                            <button onclick="location.href = '${pageContext.request.contextPath}/vnpay-timkiem'" style="margin: 10px;" class="btn btn-danger"><i class="fa fa-send"></i> Tìm kiếm và kiểm tra dữ liệu</button>
                        </div> 
                    </div>
                    <!--form luong the vinh-->
                    <div class="wdgt-box tabl-wrp">
                        <div class="row">
                            <h4 style="margin: 10px;">Hệ thống đối soát LTV</h4>
                            <button onclick="location.href = '${pageContext.request.contextPath}/vnpay-doisoat'" style="margin: 10px;" class="btn btn-primary"><i class="fa fa-save" aria-hidden="true"></i>
                                Đối soát hệ thống Lương Thế Vinh</button>
                            <button onclick="location.href = '${pageContext.request.contextPath}/vnpay-themdulieu'" style="margin: 10px;" class="btn btn-primary"><i class="fa fa-save" aria-hidden="true"></i>
                                Đối soát hệ thống Lương Thế Vinh</button>
                            <button onclick="location.href = '${pageContext.request.contextPath}/vnpay-timkiem'" style="margin: 10px;" class="btn btn-danger"><i class="fa fa-send"></i> Tìm kiếm và kiểm tra dữ liệu</button>
                        </div> 
                    </div>

                </div>
            </div>
            <!-- Contant Wrap -->
            <jsp:include page="_footer.jsp"></jsp:include>
            <!-- Footer -->
        </main><!-- Main Wrapper -->

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
    </body>

</html>
