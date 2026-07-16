package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entity.Member;

import java.io.IOException;

@WebServlet(urlPatterns = {"/booking"})
public class BookingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        Member loginMember = (Member) req.getSession().getAttribute("loginMember");

        if(loginMember == null){
            resp.sendRedirect("index.jsp");
            return;
        }

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/booking.jsp");
        rd.forward(req, resp);
    }
}
