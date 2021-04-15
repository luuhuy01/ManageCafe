package Model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author luuhuy
 */
public class HoaDon implements Serializable{
    private int idBill;
    private Date date;
    private String status;
    private int idStaff;
    private int idTable;
//    private int [] idDrink;

    public HoaDon(Date date, String status, int idStaff, int idTable) {
        this.date = date;
        this.status = status;
        this.idStaff = idStaff;
        this.idTable = idTable;
    }

    

    public HoaDon() {
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    
}
