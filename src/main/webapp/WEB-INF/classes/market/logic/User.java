package market.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

public class User  {

    private String sLogin;
    private String sPassword;
    private int iAccess;

    public User(ResultSet rs) throws SQLException {
        setLogin(rs.getString(1));
        setPassword(rs.getString(2));
        setAccess(rs.getInt(3));
    }

    public User() {
    }

    public void setLogin(String sLogin) {
        this.sLogin = sLogin;
    }
    public void setPassword(String sPassword) {
        this.sPassword = sPassword;
    }
    public void setAccess(int iAccess) {
        this.iAccess = iAccess;
    }


    public String getLogin() {
        return sLogin;
    }
    public String getPassword() {
        return sPassword;
    }
    public int getAccess() {
        return iAccess;
    }
}
