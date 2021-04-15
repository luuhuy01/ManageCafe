
package View;

import Controller.ControllerDrink;
import Model.DoUong;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luuhuy
 */
public class ManageDrink extends javax.swing.JFrame {

    DefaultTableModel dtm = null;
    ControllerDrink ct = null;
    DoUong du = null;
    
    public ManageDrink() {
        initComponents();
        setTitle("Quản lý đồ uống");
        this.setVisible(false);
        dtm = (DefaultTableModel) jTableDrink.getModel();
        ct = new ControllerDrink();
        ArrayList<DoUong> arr = new ArrayList<>();
        arr = ct.ProcessDrinkDB();
        ct.showTableDrink(jTableDrink, arr);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSearchDrink = new javax.swing.JButton();
        jTextFieldDrink = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDrink = new javax.swing.JTable();
        jButtonDeleteDrink = new javax.swing.JButton();
        jButtonEditDrink = new javax.swing.JButton();
        jButtonAddDrink = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonSearchDrink.setText("Tìm kiếm");
        jButtonSearchDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchDrinkActionPerformed(evt);
            }
        });

        jTableDrink.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên đồ uống", "Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDrink);

        jButtonDeleteDrink.setText("Xóa");
        jButtonDeleteDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteDrinkActionPerformed(evt);
            }
        });

        jButtonEditDrink.setText("Sửa");
        jButtonEditDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditDrinkActionPerformed(evt);
            }
        });

        jButtonAddDrink.setText("Thêm");
        jButtonAddDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddDrinkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextFieldDrink, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButtonSearchDrink)
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonAddDrink)
                        .addGap(34, 34, 34)
                        .addComponent(jButtonEditDrink)
                        .addGap(27, 27, 27)
                        .addComponent(jButtonDeleteDrink)
                        .addGap(82, 82, 82))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearchDrink))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDeleteDrink)
                    .addComponent(jButtonEditDrink)
                    .addComponent(jButtonAddDrink))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jTextFieldDrink.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddDrinkActionPerformed
        AddDrink addDrink = new AddDrink();
        addDrink.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonAddDrinkActionPerformed

    private void jButtonSearchDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchDrinkActionPerformed
        String search = jTextFieldDrink.getText();
        ArrayList<DoUong> arr = new ArrayList<>();
        arr = ct.searchDrink(search);
        dtm.setNumRows(0);
        ct.showTableDrink(jTableDrink, arr);
    }//GEN-LAST:event_jButtonSearchDrinkActionPerformed

    private void jButtonEditDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditDrinkActionPerformed
        int i = jTableDrink.getSelectedRow();
        String name = JOptionPane.showInputDialog("Nhập tên món ăn");
        int price = Integer.parseInt(JOptionPane.showInputDialog("Nhập giá món ăn"));
        du = new DoUong(name, price);
        du.setId((int) jTableDrink.getValueAt(i, 0));
        jTableDrink.setValueAt(name, i, 1);
        jTableDrink.setValueAt(price, i, 2);
        ct.updateDrink(du);
    }//GEN-LAST:event_jButtonEditDrinkActionPerformed

    private void jButtonDeleteDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteDrinkActionPerformed
        dtm = (DefaultTableModel) jTableDrink.getModel();
        int i = jTableDrink.getSelectedRow();
        int n = JOptionPane.showConfirmDialog(this.jButtonDeleteDrink,"Bạn có chắc chắn muốn xóa không?", "DELETE",JOptionPane.YES_NO_OPTION);      
        if(n==0){
            ct.deleteDrink((int) jTableDrink.getValueAt(i, 0));
            dtm.removeRow(i);
        }
    }//GEN-LAST:event_jButtonDeleteDrinkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddDrink;
    private javax.swing.JButton jButtonDeleteDrink;
    private javax.swing.JButton jButtonEditDrink;
    private javax.swing.JButton jButtonSearchDrink;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDrink;
    private javax.swing.JTextField jTextFieldDrink;
    // End of variables declaration//GEN-END:variables
}
