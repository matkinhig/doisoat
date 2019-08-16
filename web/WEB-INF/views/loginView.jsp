<%-- 
    Document   : loginView
    Created on : Aug 8, 2019, 5:26:34 PM
    Author     : lucnt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <link rel="icon" href="assets/images/favicon.png" sizes="32x32" type="image/png">
        <title>Vietbank - Checkout System</title>

        <link rel="stylesheet" href="assets/css/icons.min.css">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/plugins.min.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/color.css">
        <link rel="stylesheet" href="assets/css/responsive.css">
        <script type="text/javascript">
            window.history.forward() ;
        </script>
    </head>
    <body>
        <main class="gnrl-pg">
            <section>
                <div class="gap gray-layer opc85">
                    <div class="fixed-bg2" style="background-image: url(assets/images/resources/back-groud.jpg);"></div>
                    <div class="container">
                        <div class="rgstr-wrp text-center">
                            <div class="rgstr-innr">
                                <div class="rgstr-frm">
                                    <div class="wdgt-titl wdgt-titl-icn">
                                        <i class="icon ion-ios-person-outline"></i>
                                        <h4>Signin to Admin</h4>
                                        <p>Fill your detail for login</p>
                                    </div>
                                    <form method="POST" action="${pageContext.request.contextPath}/login" class="cont-frm">
                                        <div class="row mrg10">
                                            <div class="col-md-12 col-sm-12 col-lg-12">
                                                <input name="userName" value= "${user.userName}" type="text" placeholder="User Name" />
                                                <i class="icon ion-android-person"></i>
                                            </div>
                                            <div class="col-md-12 col-sm-12 col-lg-12">
                                                <input name="password" value="${user.password}" type="password" placeholder="Password" />
                                                <i class="icon ion-key"></i>
                                            </div>
                                            <div class="col-md-12 col-sm-12 col-lg-12">
                                                <span class="chck-bx">
                                                    <input  type="checkbox" name="rememberMe" value= "Y" type="checkbox" id="terms-policy">
                                                    <label for="terms-policy">Agree the terms and policy</label>
                                                </span>
                                            </div>
                                            <div class="col-md-12 col-sm-12 col-lg-12">
                                                <button type="submit" value= "Submit"> Signin </button>
                                                <a style="margin-left: 15px" href="${pageContext.request.contextPath}/">Cancel</a>
                                            </div>
                                        </div>
                                    </form>                                
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <footer>
                <div class="container">
                    <p>Copyright <a href="#" title="">VietBank</a> &copy; 2019</p>
                    <ul class="btm-lnks">
                        <li><a href="${pageContext.request.contextPath}/" title="">Dashboard</a></li>
                        <li><a href="#" title="">Contact us</a></li>
                    </ul>
                </div>
            </footer><!-- Footer -->
        </main><!-- Main Wrapper -->

        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/plugins.min.js"></script>
        <script src="assets/js/custom-scripts.js"></script>
    </body>	
</html>
