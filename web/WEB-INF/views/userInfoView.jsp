<%-- 
    Document   : userInfoView
    Created on : Aug 8, 2019, 5:35:57 PM
    Author     : lucnt
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <body  class="gray-bg">

        <jsp:include page="_header.jsp"></jsp:include>
        

            <h3>Hello: ${user.userName}</h3>

        User Name: <b>${user.userName}</b>

        <jsp:include page="_footer.jsp"></jsp:include>

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
