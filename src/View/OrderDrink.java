/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerBill;
import Controller.ControllerDrink;
import Model.DoUong;
import Model.HoaDon;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luuhuy
 */
public class OrderDrink extends javax.swing.JFrame {

    ControllerBill ctb = null;
    ControllerDrink ctd = null;
  
    DefaultTableModel dtm = null;
    static int total = 0;
    public OrderDrink() {
        initComponents();
        this.setTitle("Gọi đồ uống");
        this.setVisible(false);
        ctd = new ControllerDrink();
        ctb = new ControllerBill();
        ArrayList<String> arr = ctb.getIDStaff();
        for(int i=0; i< arr.size(); i++)
            this.jComboBoxNameStaff.addItem(arr.get(i));
        ArrayList<String> arr1 = ctb.getTable();
        for(int i=0; i< arr1.size(); i++)
            this.jComboBoxTable.addItem(arr1.get(i));
        ArrayList<DoUong> arrdu = ctd.ProcessDrinkDB();
        ctd.showTableDrink(jTableSearch, arrdu);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabelSearch = new javax.swing.JLabel();
        jComboBoxNameStaff = new javax.swing.JComboBox<>();
        jTextSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSearch = new javax.swing.JTable();
        jButtonAddFood = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePay = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBoxTable = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelSearch.setText("Tìm kiếm");

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jTableSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên Món ăn", "Giá tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableSearch);

        jButtonAddFood.setText("Thêm");
        jButtonAddFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddFoodActionPerformed(evt);
            }
        });

        jTablePay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên món ăn", "Số tiền", "Số lượng", "Tính tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTablePay);

        jButton1.setText("Lưu ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã nhân viên: ");

        jLabel2.setText("Mã bàn:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tổng tiền:");

        jTextFieldTotal.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(50, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(jButtonAddFood))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelSearch)
                                .addGap(21, 21, 21)
                                .addComponent(jTextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButtonSearch))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jComboBoxNameStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jButton2)
                                .addGap(88, 88, 88)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(229, 229, 229)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldTotal)
                                .addGap(10, 10, 10))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxNameStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSearch)
                    .addComponent(jTextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jButtonAddFood)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldTotal)
                        .addGap(112, 112, 112))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddFoodActionPerformed
        int i = jTableSearch.getSelectedRow();
        int amount = Integer.parseInt(JOptionPane.showInputDialog(this,"Nhập số lượng đồ uống"));
        int id = (int) jTableSearch.getValueAt(i, 0);
        String name = (String) jTableSearch.getValueAt(i, 1);
        int price = (int) jTableSearch.getValueAt(i, 2);
        DoUong du = new DoUong(name, price);
        du.setId(id);
        int n = ctb.showTableBill(jTablePay, du, amount);
        total =  total + n;
        jTextFieldTotal.setText(total+"");
    }//GEN-LAST:event_jButtonAddFoodActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dtm = (DefaultTableModel) jTablePay.getModel();
        int i = jTablePay.getSelectedRow();
        total = total - (int)jTablePay.getValueAt(i, 4);
        jTextFieldTotal.setText(total+"");
        dtm.removeRow(i);      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        String search = jTextSearch.getText();
        dtm = (DefaultTableModel) jTableSearch.getModel();
        ArrayList<DoUong> arr = new ArrayList<>();
        arr = ctd.searchDrink(search);
        dtm.setNumRows(0);
        ctd.showTableDrink(jTableSearch, arr);
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int idTable = Integer.parseInt(jComboBoxTable.getSelectedItem().toString());
        int idStaff = Integer.parseInt(jComboBoxNameStaff.getSelectedItem().toString());
        long millis=System.currentTimeMillis();  
        Date date=new Date(millis);
        String status = "NO";
        int n = jTablePay.getRowCount();
        int [] idFood = new int[n];
        int [] quantity = new int[n];
        for(int i=0; i< n; i++){
            idFood[i] = (int) jTablePay.getValueAt(i, 0);
            quantity[i] = (int) jTablePay.getValueAt(i, 3);
        }
        HoaDon hd = new HoaDon(date,status,idStaff, idTable);
        ctb.saveBill(hd, idFood, quantity);
        JOptionPane.showMessageDialog(this, "Bạn đã lưu hóa đơn thành công");
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAddFood;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox<String> jComboBoxNameStaff;
    private javax.swing.JComboBox<String> jComboBoxTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePay;
    private javax.swing.JTable jTableSearch;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JTextField jTextSearch;
    // End of variables declaration//GEN-END:variables
}
