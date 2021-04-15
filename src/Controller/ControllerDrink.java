package Controller;

import Model.DoUong;
import Model.NhanVien;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 *
 * @author luuhuy
 */
public class ControllerDrink extends ConnectionDB {

    DoUong du = null;
    DefaultTableModel dtb;

    public ArrayList<DoUong> ProcessDrinkDB() {
        ArrayList<DoUong> arr = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Drink";
        Statement stm = null;
        ResultSet rs = null;
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                du = new DoUong();
                du.setId(rs.getInt(1));
                du.setName(rs.getString(2));
                du.setPrice(rs.getInt(3));
                arr.add(du);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return arr;
    }

    public ArrayList<DoUong> searchDrink(String key) {
        ArrayList<DoUong> arr = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Drink WHERE name LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                du = new DoUong();
                du.setId(rs.getInt(1));
                du.setName(rs.getString(2));
                du.setPrice(rs.getInt(3));
                arr.add(du);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return arr;
    }

    public void addDrink(DoUong du) {
        String sql = "INSERT INTO dbo.Drink(name, price) VALUES(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, du.getName());
            ps.setInt(2, du.getPrice());
            
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public void updateDrink(DoUong du){
        String sql = "UPDATE dbo.Dink SET name = ? , price = ? WHERE id = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, du.getName());
            ps.setInt(2, du.getPrice());
            ps.setInt(3, du.getId());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void deleteDrink(int i){
        String sql = "DELETE FROM dbo.Drink WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, i);
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public void showTableDrink(JTable table, ArrayList<DoUong> arr1) {
        dtb = (DefaultTableModel) table.getModel();
        for (DoUong du : arr1) {
            dtb.addRow(new Object[]{
                du.getId(), du.getName(), du.getPrice()
            });
        }
    }

    public void showTableDrink(JTable table, DoUong du) {
        dtb = (DefaultTableModel) table.getModel();
        dtb.addRow(new Object[]{
            du.getId(), du.getName(), du.getPrice()
        });
    }

}
