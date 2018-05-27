package market.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

public class User  {

    private String sFIO;
    private String sLogin;
    private String sPassword;
    private String sEmail;
    private int iAccess;
    private boolean bAuthorized = false;

    public User(ResultSet rs) throws SQLException {
        setLogin(rs.getString(1));
        setPassword(rs.getString(2));
        setAccess(rs.getInt(3));
    }

    public User() {
    }

    public void setFIO(String sFIO) {
        this.sFIO = sFIO;
    }
    public void setEmail(String sEmail) {
        this.sEmail = sEmail;
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
    public void setAuthorized(boolean bAuthorized) { this.bAuthorized = bAuthorized; }

    public String getFIO() {
        return sFIO;
    }
    public String getEmail() {
        return sEmail;
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
    public boolean getAuthorized () { return bAuthorized; }
}
