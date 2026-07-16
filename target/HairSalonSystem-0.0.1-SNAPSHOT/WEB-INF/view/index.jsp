<%@ page import="model.entity.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>NANA's HairSalon - 線上預約</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <%
        // 從 Session 中取得登入的會員資料
        Member loginMember = (Member) session.getAttribute("loginMember");
    %>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-sm">

        <div class="container">

            <a class="navbar-brand fw-bold fs-4 text-warning" href="#"> NANA's HairSalon</a>

            <div class="d-flex align-items-center gap-4"> <% if (loginMember == null) { %>
                <a href="register" class="btn btn-outline-warning fw-bold">免費註冊</a>
                <a href="login.jsp" class="btn btn-outline-light me-2">會員登入</a>
                <% } else { %>
                <span class="text-white fs-5"> 歡迎 <%= loginMember.getName() %> 登入 !</span>
                <% } %>
            </div>

                </div>
     </nav>

    <div class="bg-dark text-white text-center py-5 shadow-sm">
        <div class="container py-5">
            <h1 class="display-4 fw-bold text-warning mb-3">尋找屬於你的個人魅力</h1>
            <p class="lead mb-4">專業剪髮、染髮、燙髮設計，頂級沙龍享受，即刻線上預約免排隊！</p>

            <div class="border-top border-bottom border-warning d-inline-block py-3 px-5 mt-3">
                <p class="mb-2 fs-5">📍 店鋪地址：台中市太平區育賢路 121 號</p>
                <p class="mb-0 fs-5">🕒 營業時間：週二至週日 10:30 - 20:00</p>
            </div>

        </div>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>