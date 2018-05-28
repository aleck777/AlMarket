package market.web;

import market.logic.ManagementSystem;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
// import javax.annotation.processing.Generated;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class mainServlet extends HttpServlet {
    private String p = "main"; // p - page, атрибут для перехода на страницу
    private String sAction = "";
    private String sActionResult = "";
    private market.logic.User oUserActive = new market.logic.User();


    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, SQLException {
        // Установка кодировки для принятия параметров
        req.setCharacterEncoding("UTF-8");
        // Получаем доступ к сессии, что бы записать переменные
        HttpSession session = req.getSession();

        //  Сбрасываем результат действия
        sActionResult = "";

        // Получаем значение переременной p (page)
        if (req.getParameter("p") != null) {
            this.p = req.getParameter("p").trim();
        } else {
            this.p = "main";
        }

        // Получаем значение параметра Action (для форм)
        if (req.getParameter("action") != null) {
            this.sAction = req.getParameter("action").trim();
        }

        // Получаем активного пользователя
        if (req.getAttribute("oActiveUser") != null) {
            this.oUserActive = (market.logic.User) req.getAttribute("oActiveUser");
        }

        // Logout
        if (sAction.equals("logout")) {
            oUserActive.setFIO("");
            oUserActive.setLogin("");
            oUserActive.setAuthorized(false);
            sAction = "";
        }

        // Проверка Логина и Пароля - в базе данных
        if (sAction.equals("auth")) {
            String sLogin = req.getParameter("login").trim();
            String sPassword = req.getParameter("password").trim();
            oUserActive = ManagementSystem.getInstance().checkUser(sLogin, sPassword);
            sAction = "";
        }

        // Регистрация нового пользователя
        if (sAction.equals("register")) {
            String sLogin = req.getParameter("login").trim();
            String sPassword = req.getParameter("password").trim();
            String sEmail = req.getParameter("email").trim();
            String sFIO = req.getParameter("fio").trim();
            oUserActive = ManagementSystem.getInstance().addUser(sLogin,sPassword,sEmail,sFIO);

            sAction = "";
            p = "RegisterResult";
            if (oUserActive.getAuthorized()) {
                sActionResult = "RegisterGood";
            } else {
                sActionResult = "RegisterBad";
            }
        }
        // Добавление товара в базу
        if (sAction.equals("product_add")) {
            String sCode = req.getParameter("product_code").trim();
            String sName = req.getParameter("product_name").trim();
            String sDescription = req.getParameter("product_description").trim();
            String sImage = req.getParameter("product_image").trim();
            boolean bAddResult = ManagementSystem.getInstance().addProduct(sCode,sName,sDescription,sImage);

            sAction = "";
            p = "list";
            if (bAddResult) {
                sActionResult = "ProductAddGood";
            } else {
                sActionResult = "ProductAddBad";
            }
        }

        // Записываем значение в атрибут P
        req.setAttribute("p", this.p);

        // Атрибут users - коллекция пользователей
        Collection cUsers = ManagementSystem.getInstance().getUsers();
        req.setAttribute("users", cUsers);

        // Атрибут products - коллекция пользователей
        Collection cProducts = ManagementSystem.getInstance().getProducts();
        req.setAttribute("products", cProducts);

        // Записываем значение в атрибут Action
        req.setAttribute("action", this.sAction);

        // Записываем значение в атрибут Action
        req.setAttribute("sActionResult", this.sActionResult);

        // Записываем активного пользователя
        req.setAttribute("oActiveUser", this.oUserActive);

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
