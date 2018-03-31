package market.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class mainServlet extends HttpServlet {
    private String p = "main";

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Установка кодировки для принятия параметров
        req.setCharacterEncoding("UTF-8");
        // Получаем доступ к сессии, что бы записать переменные
        HttpSession session = req.getSession();

        // session.getAttribute("user");

        // Получаем значение переременной p (page)
        if (req.getParameter("p") != null) {
            this.p = req.getParameter("p").trim();
        }
        // Записываем значение в атрибут P
        req.setAttribute("p", this.p);

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }



}
