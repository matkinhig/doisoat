<%-- 
    Document   : _header
    Created on : Aug 8, 2019, 4:23:40 PM
    Author     : lucnt
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<header class="dark-bg">
    <div class="usr-inf" style="background-image: url(assets/images/bg-user.jpg);">
        <div class="usr-inf-inner">
            <span class="usr-img"><img src="assets/images/user-icon.png" alt="user-img.jpg"><i
                    class="usr-sts onln"></i></span>
            <div class="usr-nm-desg">
                <h4> ${loginedUser.userName} Lực</h4>
                <span>Developer</span>
            </div>
        </div>
    </div><!-- User Info -->
    <nav>
        <ul>
            <li><a href="/doisoat" title=""><i class="icon ion-android-home"></i><span>Dashboard</span></a></li>
            <li class="menu-item-has-children"><a href="#" title=""><i class="icon ion-ios-briefcase"></i><span>VNPAY</span></a>
                <ul class="children">
                    <li><a href="/doisoat/vnpay-doisoat" title="">Checkout With Database</a></li>
                    <li><a href="/doisoat/vnpay-timkiem" title="">Search by Fields</a></li>
                </ul>
            </li>
            <li class="menu-item-has-children"><a href="#" title=""><i class="icon ion-fireball"></i><span>LTV</span></a>
                <ul class="children">
                    <li><a href="/doisoat/ltv-doisoat" title="">Checkout With Database</a></li>
                    <li><a href="/doisoat/ltv-timkiem" title="">Search by Fields</a></li>
                </ul>
            </li>
            <li class="menu-item-has-children"><a href="#" title="">
                    <i class="icon ion-android-contact"></i><span>User</span></a>
                <ul class="children">
                    <li><a href="userInfo" title="">Thông tin</a></li>
                    <li><a href="#" title="">Chỉnh sửa</a></li>
                </ul>
            </li>
        </ul>
    </nav><!-- Nav -->
</header>
