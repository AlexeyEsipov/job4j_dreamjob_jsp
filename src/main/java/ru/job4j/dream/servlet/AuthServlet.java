package ru.job4j.dream.servlet;

import ru.job4j.dream.model.User;
import ru.job4j.dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User userInDb = DbStore.instOf().findUserByEmail(email);
        if (userInDb != null && Objects.equals(password, userInDb.getPassword())) {
            HttpSession sc = req.getSession();
            sc.setAttribute("user", userInDb);
            resp.sendRedirect(req.getContextPath() + "/index.do");
        } else {
            req.setAttribute("error", "Неверный email или пароль");
            req.getRequestDispatcher("candidate/login.jsp").forward(req, resp);
        }
    }
}
