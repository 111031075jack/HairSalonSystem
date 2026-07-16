package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.MemberDao;
import model.entity.Member;

import java.io.IOException;

@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 建立請求分派器
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/register.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        member.setName(name);
        member.setPhone(phone);
        member.setEmail(email);

        MemberDao memberDao = MemberDao.getInstance();

        String msg =" Register OK ! 註冊成功";

        try {
            memberDao.register(member);
            req.getSession().setAttribute("loginMember", member);
            resp.sendRedirect("booking");
            return;
        } catch (RuntimeException e){
            msg = "Register Fail !　註冊失敗" + e.getMessage() ;
        }

        // 建立請求分派器
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/register.jsp");
        req.setAttribute("msg", msg);
        rd.forward(req, resp);

    }
}
