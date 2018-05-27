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

    public market.logic.User checkUser (String sLogin, String sPassword) throws SQLException  {
        market.logic.User authUser = new market.logic.User();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT am_login, am_password, am_access, am_fio, am_email FROM am_users WHERE am_login = '"+sLogin+"'"
                                                +" and am_password = '"+sPassword+"'");
        if (rs.next()) {
            authUser.setLogin(rs.getString(1));
            authUser.setPassword(rs.getString(2));
            authUser.setAccess(rs.getInt(3));
            authUser.setFIO(rs.getString(4));
            authUser.setEmail(rs.getString(5));
            authUser.setAuthorized(true);
        } else {
            authUser.setFIO("");
            authUser.setLogin("");
            authUser.setAuthorized(false);
        }
        rs.close();
        stmt.close();
        return authUser;
    }

    public market.logic.User addUser (String sLogin, String sPassword, String sEmail, String sFIO) throws SQLException  {
        market.logic.User usr = new market.logic.User();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT am_login FROM am_users WHERE am_login = '"+sLogin+"'");
        if (rs.next()) {
            usr.setFIO("");
            usr.setLogin("");
            usr.setAuthorized(false);
        } else {
            int count_stmt = stmt.executeUpdate("INSERT INTO am_users (am_login, am_password, am_email, am_fio, am_access) " +
                    "VALUES ('"+sLogin+"','"+sPassword+"','"+sEmail+"','"+sFIO+"', 1 )");
            if ( count_stmt == 1) {
                usr = checkUser(sLogin, sPassword);
            } else {
                usr.setFIO("");
                usr.setLogin("");
                usr.setAuthorized(false);
            }
        }
        rs.close();
        stmt.close();
        return usr;
    }
}
