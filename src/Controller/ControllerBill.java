/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DoUong;
import Model.HoaDon;
import Model.NhanVien;
import java.util.ArrayList;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luuhuy
 */
public class ControllerBill extends ConnectionDB{
    DefaultTableModel dtm = null;
    
    public ArrayList<String> getIDStaff(){
        ArrayList<String> arr = new ArrayList<>();
        String sql ="SELECT id FROM dbo.Staff";
        ResultSet rs = null;
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                arr.add(rs.getString(1));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return arr;
    }
    
    public ArrayList<String> getTable(){
        ArrayList<String> arr = new ArrayList<>();
        String sql ="SELECT number FROM dbo.[Table]";
        ResultSet rs = null;
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                arr.add(rs.getString(1));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return arr;
    }
    
    public void saveBill(HoaDon bill, int [] idDrink, int [] quantity){
        String sql = "INSERT INTO dbo.Bill (date, status, Staffid, Tableid) VALUES(?, ?, ?, ?)";
        String sql1 = "INSERT INTO dbo.Have (quantity, Drinkid, Billid) VALUES(?, ?, ?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, sdf.format(bill.getDate()));
            ps.setString(2, bill.getStatus());
            ps.setInt(3, bill.getIdStaff());
            ps.setInt(4, bill.getIdTable());
            
            ps.executeUpdate();
            int id=0;
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next())
                id = rs.getInt(1);
            for(int i =0; i< quantity.length; i++){
                PreparedStatement ps1 = conn.prepareStatement(sql1);
                ps1.setInt(1, quantity[i]);
                ps1.setInt(2, idDrink[i]);
                ps1.setInt(3, id);
                ps1.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    public int showTableBill(JTable table, DoUong du, int i){
        dtm = (DefaultTableModel) table.getModel();
        int money = du.getPrice()*i;
        dtm.addRow(new Object[]{
            du.getId(), du.getName(), du.getPrice(), i, money
        });
        return money;
    }
    
    public void getBillPay(JTable table){
        String sql = "SELECT dbo.Bill.id, date, Staffid, Tableid FROM dbo.Bill "
                + "WHERE dbo.Bill.status ='NO' ";
        Statement st;
        ArrayList<HoaDon> arr = new ArrayList<>();
        try {          
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setIdBill(rs.getInt(1));
                hd.setDate(rs.getDate(2));
                hd.setIdStaff(rs.getInt(3));
                hd.setIdTable(rs.getInt(4));
                hd.setStatus("NO");
                arr.add(hd);
            } 
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        String sql1 = "SELECT quantity * price FROM dbo.Have, dbo.Drink "
                + "WHERE Billid = ? AND dbo.Have.Drinkid = dbo.Drink.id AND dbo.Drink.id = ? ";
        String sql2 = "SELECT Drinkid FROM dbo.Have WHERE Billid = ?";
        int money;
        PreparedStatement ps2;
        PreparedStatement ps1;
        int k =0;
        try {
            ps2 = conn.prepareStatement(sql2);
            for(int i=0; i< arr.size(); i++){
                ps2.setInt(1, arr.get(i).getIdBill());
                ResultSet rsIdDrink = ps2.executeQuery();
                ResultSet rs1;
                money = 0;
                while(rsIdDrink.next()){
                    ps1 = conn.prepareStatement(sql1);
                    ps1.setInt(1, arr.get(i).getIdBill());
                    ps1.setInt(2, rsIdDrink.getInt(1));
                    rs1 = ps1.executeQuery();
                    while(rs1.next()){
                        money +=rs1.getInt(1);
                    }
                }
                showTablePay(table,arr.get(i), money);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        
    }
    
    public void showTablePay(JTable table, HoaDon bill, int total ){
        dtm = (DefaultTableModel) table.getModel();
        dtm.addRow(new Object[]{
            bill.getIdBill(), bill.getIdTable(), bill.getIdTable(), bill.getDate(), bill.getIdStaff(), total
        });
    }
    
    public void updatePay(int id){
        String sql = "UPDATE dbo.Bill SET status = 'YES' WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
    }
}
