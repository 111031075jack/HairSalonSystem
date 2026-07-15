package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Ctrl + Shift + K直接就會把修改過內容全部git上去
@WebServlet("/home")
public class HomePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1. 設定瀏覽器編碼
        resp.setContentType("text/html;charset=utf-8");

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/index.jsp");
        rd.forward(req, resp);
    }
}