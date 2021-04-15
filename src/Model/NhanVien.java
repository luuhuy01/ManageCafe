
package Model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author luuhuy
 */
public class NhanVien implements Serializable{
    private int id;
    private String name;
    private Date date;
    private String Number;

    public NhanVien() {
    }

    public NhanVien(String name, Date date, String Number) {
        this.name = name;
        this.date = date;
        this.Number = Number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }
    
    
}
