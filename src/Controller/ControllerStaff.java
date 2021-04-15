/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.NhanVien;
import java.sql.*;
import java.text.SimpleDateFormat;
//import java.time.Instant;
import java.util.ArrayList;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luuhuy
 */
public class ControllerStaff extends ConnectionDB{
    NhanVien nhanvien;
    DefaultTableModel dtb;
    
    public ArrayList<NhanVien> ProcesssStaffDB(){
        ArrayList<NhanVien> arr = new ArrayList();
        Statement stm = null;
        ResultSet rs = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "SELECT dbo.Staff.id, name, birthday, phone FROM dbo.PhoneStaff, dbo.Staff WHERE dbo.Staff.id = dbo.PhoneStaff.Staffid";
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                nhanvien= new NhanVien();
                nhanvien.setId(Integer.parseInt(rs.getString(1)));
                nhanvien.setName(rs.getString(2));
                nhanvien.setDate(rs.getDate(3));
                nhanvien.setNumber(rs.getString(4));
                arr.add(nhanvien);
            }           
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return arr;
    }
    
    public void showTableStaff(JTable table, ArrayList<NhanVien> arr1){
        dtb = (DefaultTableModel) table.getModel();
        for (NhanVien nv : arr1) {
            dtb.addRow(new Object[]{
                nv.getId(), nv.getName(), nv.getDate(), nv.getNumber()
            });
        }
    }
    public void AddStaffDB(NhanVien nv){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "INSERT INTO dbo.Staff(name, birthday) VALUES(?, ?) ";
        String sql1 = "INSERT INTO dbo.PhoneStaff(Staffid, phone) VALUES(?, ?) ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement ps1 = conn.prepareStatement(sql1);

            ps.setString(1, nv.getName());
            ps.setString(2, sdf.format(nv.getDate()));
            
            int id = 0;
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                id = rs.getInt(1);
            }
            ps1.setInt(1, id);
            ps1.setString(2, nv.getNumber());
            
            ps1.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        
     }
    
    public void editStaffDB(NhanVien nv){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "UPDATE dbo.nhan_vien SET ma_nhan_vien = ? , ten_nhan_vien = ?, ngay_sinh = ?";
        String sql1 = "UPDATE dbo.sdt_nhan_vien SET ma_nhan_vien = ?, sdt = ?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement ps1 = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, nv.getId());
            ps.setString(2, nv.getName());
            ps.setString(3, sdf.format(nv.getDate()));
            ResultSet generatedKeys = ps.getGeneratedKeys();
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
