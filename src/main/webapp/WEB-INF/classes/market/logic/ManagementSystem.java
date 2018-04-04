package market.logic;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ManagementSystem {
    private static Connection con;
    private static ManagementSystem instance;
    private static DataSource dataSource;

    private ManagementSystem() {
    }
    public static synchronized ManagementSystem getInstance() {
        if (instance == null) {
            try {
                instance = new ManagementSystem();
                Context ctx = new InitialContext();
//                instance.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/AlMarket");
//                con = dataSource.getConnection();
//                Class.forName("org.h2.Driver");
                org.h2.Driver.load();
                con = DriverManager.getConnection("jdbc:h2:~/AlMarket", "sa", "");
//                stmt = con.createStatement();

            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public Collection getUsers() throws SQLException {
        Collection users = new ArrayList();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT am_login, am_password, am_access FROM am_users");

        while (rs.next()) {
            market.logic.User usr = new market.logic.User();
            usr.setLogin(rs.getString(1));
            usr.setPassword(rs.getString(2));
            usr.setAccess(rs.getInt(3));
            users.add(usr);
        }


        rs.close();
        stmt.close();
        return users;
    }
}
