<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 2026/7/16
  Time: 下午 01:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <head>
        <title> 歡迎使用註冊頁面 </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body class="bg-light"> <div class="container mt-5">
        <%
            String msg = (String) request.getAttribute("msg");
        %>
        <div class="row justify-content-center">
            <div class="col-md-6"> <div class="card shadow-sm border-0">
                <div class="card-body p-5 bg-white rounded">
                    <% if (msg != null) { %>

                    <div class="alert alert-danger" role="alert">

                        ⚠️ <%= msg %>

                    </div>
                    <% } %><h2 class="text-center fw-bold text-dark mb-4">加入 NANA's 會員</h2>

    <form action="register" method="post">
        <div class="mb-3">
           <label class="form-label">帳號</label>
           <input type="text" class="form-control" name="username" placeholder="請輸入註冊帳號" />
        </div><div class="mb-3">
            <label class="form-label">密碼</label>
            <input type="password" class="form-control" name="password" placeholder="請輸入註冊密碼" />
        </div><div class="mb-3">
            <label class="form-label">姓名</label>
            <input type="text" class="form-control" name="name" placeholder="請輸入註冊姓名" />
        </div><div class="mb-3">
            <label class="form-label">電話</label>
            <input type="text" class="form-control" name="phone" placeholder="請輸入註冊電話" />
        </div><div class="mb-3">
            <label class="form-label">電子信箱</label>
            <input type="email" class="form-control" name="email" placeholder="請輸入電子信箱" />
        </div>

        <button type="submit" class="btn btn-success">註冊會員</button>

    </form>
                </div>
            </div>
            </div>
        </div>
    </div>


    </body>

</html>
