<%@ page import="model.entity.Member" %><%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 2026/7/16
  Time: 下午 05:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>

      <title>線上預約時段 - NANA's HairSalon</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

  </head>

  <body class="bg-light">
  <%
    // 1. 安全檢查：從 Session 拿登入資料
    Member loginMember = (Member) session.getAttribute("loginMember");

  %>

  <div class="container mt-5 text-center">
    <div class="card shadow-sm p-5 bg-white rounded d-inline-block">
      <h1 class="text-success fw-bold mb-4">🎉 登入成功！</h1>

      <h3 class="mb-3">
        歡迎來到預約系統，
        <span class="text-warning fw-bold"><%= loginMember.getName() %></span>
        先生/小姐！
      </h3>

      <p class="text-muted mb-4">（這裡就是未來的預約時間與項目選擇畫面，目前正在施工中...）</p>

      <div class="d-flex justify-content-center gap-3">
        <a href="index.jsp" class="btn btn-outline-secondary">回首頁</a>
        <a href="#" class="btn btn-danger">登出系統</a>
      </div>
    </div>
  </div>

  </body>
</html>
