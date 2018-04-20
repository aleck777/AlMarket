package market.web;

import market.logic.ManagementSystem;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class mainServlet extends HttpServlet {
    private String p = "main";
    private String sAction = "";
    private market.logic.User oUserActive = new market.logic.User();


    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, SQLException {
        // Установка кодировки для принятия параметров
        req.setCharacterEncoding("UTF-8");
        // Получаем доступ к сессии, что бы записать переменные
        HttpSession session = req.getSession();


        // Получаем значение параметра Action (для форм)
        if (req.getParameter("action") != null) {
            this.sAction = req.getParameter("action").trim();
        }

        if (req.getAttribute("oActiveUser") != null) {
            this.oUserActive = (market.logic.User) req.getAttribute("oActiveUser");
        }

        // Logout
        if (sAction.equals("logout")) {
            oUserActive.setFIO("");
            oUserActive.setLogin("");
            oUserActive.setAuthorized(false);
        }
        // Проверка Логина и Пароля - вставлена заглушка для тестирования
        // Реализовать проверку в базе данных
        if (sAction.equals("auth")) {
            oUserActive.setFIO("Новиков Александр");
            oUserActive.setLogin("aleck");
            oUserActive.setAuthorized(true);
        }
        req.setAttribute("oActiveUser", this.oUserActive);

        // Получаем значение переременной p (page)
        if (req.getParameter("p") != null) {
            this.p = req.getParameter("p").trim();
        } else {
            this.p = "main";
        }
        // Записываем значение в атрибут P
        req.setAttribute("p", this.p);

        // Атрибут users - коллекция пользователей
        Collection cUsers = ManagementSystem.getInstance().getUsers();
        req.setAttribute("users", cUsers);

        // Вызов страницы вывода
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
