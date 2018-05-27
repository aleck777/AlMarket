package market.logic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {

    private String sCode;
    private String sName;
    private String sDescription;
    private String sImage;

    public Product(ResultSet rs) throws SQLException {
        setCode(rs.getString(1));
        setName(rs.getString(2));
        setDescription(rs.getString(3));
        setImage(rs.getString(4));
    }

    public Product() {
    }

    public void setCode(String sCode) {
        this.sCode = sCode;
    }
    public void setName(String sName) {
        this.sName = sName;
    }
    public void setDescription(String sDescription) {
        this.sDescription = sDescription;
    }
    public void setImage(String sImage) {
        this.sImage = sImage;
    }

    public String getCode() {
        return sCode;
    }
    public String getName() {
        return sName;
    }
    public String getDescription() {
        return sDescription;
    }
    public String getImage() {
        return sImage;
    }
}
