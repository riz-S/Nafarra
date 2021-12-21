/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nafarra;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class UserPage extends javax.swing.JFrame {
    
    protected static String asal;
    protected static String tujuan;
    protected static int tujuanIndex;
    protected static int asalIndex;
    protected static int berat;
    protected static String orderID;
    
    private Connection connection;
    /**
     * Creates new form UserPage
     */
    public UserPage() {
        connectToDB(); 
        initComponents();
        populateAsalComboBox();
        populateTujuanComboBox();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        makeOrderButton = new javax.swing.JButton();
        adminBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        orderIDInput = new javax.swing.JTextField();
        lacakBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        beratField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cekOngkirBtn = new javax.swing.JButton();
        asalComboBox = new javax.swing.JComboBox<>();
        tujuanComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(97, 140, 124));

        jPanel4.setBackground(new java.awt.Color(233, 235, 221));

        jPanel5.setBackground(new java.awt.Color(97, 140, 124));
        jPanel5.setToolTipText("");
        jPanel5.setAlignmentX(0.0F);
        jPanel5.setAlignmentY(0.0F);

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(233, 235, 221));
        jLabel3.setText("NAFARRA");

        makeOrderButton.setBackground(new java.awt.Color(206, 217, 126));
        makeOrderButton.setFont(new java.awt.Font("Leelawadee UI", 1, 10)); // NOI18N
        makeOrderButton.setForeground(new java.awt.Color(97, 140, 124));
        makeOrderButton.setText("BUAT ORDER");
        makeOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeOrderButtonActionPerformed(evt);
            }
        });

        adminBtn.setBackground(new java.awt.Color(206, 217, 126));
        adminBtn.setFont(new java.awt.Font("Leelawadee UI", 1, 10)); // NOI18N
        adminBtn.setForeground(new java.awt.Color(97, 140, 124));
        adminBtn.setText("ADMIN");
        adminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(adminBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(makeOrderButton)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(makeOrderButton)
                        .addComponent(adminBtn))
                    .addComponent(jLabel3))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(97, 140, 124));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(233, 235, 221));
        jLabel1.setText("LACAK KIRIMAN");

        orderIDInput.setBackground(new java.awt.Color(233, 235, 221));
        orderIDInput.setFont(new java.awt.Font("Leelawadee UI", 1, 10)); // NOI18N
        orderIDInput.setForeground(new java.awt.Color(97, 140, 124));

        lacakBtn.setBackground(new java.awt.Color(206, 217, 126));
        lacakBtn.setFont(new java.awt.Font("Leelawadee UI", 1, 10)); // NOI18N
        lacakBtn.setForeground(new java.awt.Color(97, 140, 124));
        lacakBtn.setText("LACAK");
        lacakBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lacakBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(233, 235, 221));
        jLabel6.setText("CEK ONGKIR");

        jLabel7.setBackground(new java.awt.Color(233, 235, 221));
        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 1, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(233, 235, 221));
        jLabel7.setText("ASAL (PROVINSI)");

        jLabel8.setFont(new java.awt.Font("Leelawadee UI", 1, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(233, 235, 221));
        jLabel8.setText("TUJUAN (PROVINSI)");

        beratField.setBackground(new java.awt.Color(233, 235, 221));
        beratField.setFont(new java.awt.Font("Leelawadee UI", 1, 10)); // NOI18N
        beratField.setForeground(new java.awt.Color(97, 140, 124));

        jLabel9.setFont(new java.awt.Font("Leelawadee UI", 1, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(233, 235, 221));
        jLabel9.setText("BERAT (KG)");

        cekOngkirBtn.setBackground(new java.awt.Color(206, 217, 126));
        cekOngkirBtn.setFont(new java.awt.Font("Leelawadee UI", 1, 10)); // NOI18N
        cekOngkirBtn.setForeground(new java.awt.Color(97, 140, 124));
        cekOngkirBtn.setText("CEK");
        cekOngkirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekOngkirBtnActionPerformed(evt);
            }
        });

        asalComboBox.setBackground(new java.awt.Color(233, 235, 221));
        asalComboBox.setFont(new java.awt.Font("Leelawadee UI", 1, 10)); // NOI18N
        asalComboBox.setForeground(new java.awt.Color(97, 140, 124));

        tujuanComboBox.setBackground(new java.awt.Color(233, 235, 221));
        tujuanComboBox.setFont(new java.awt.Font("Leelawadee UI", 1, 10)); // NOI18N
        tujuanComboBox.setForeground(new java.awt.Color(97, 140, 124));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(orderIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lacakBtn))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(85, 85, 85)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(asalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tujuanComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(beratField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cekOngkirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(beratField)
                                .addComponent(cekOngkirBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lacakBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, Short.MAX_VALUE)
                                    .addComponent(orderIDInput, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(asalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tujuanComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(22, 22, 22))
        );

        jLabel2.setBackground(new java.awt.Color(97, 140, 124));
        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(97, 140, 124));
        jLabel2.setText("ANTAR PAKET ");

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(97, 140, 124));
        jLabel5.setText("KE SELURUH INDONESIA");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cekOngkirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekOngkirBtnActionPerformed
        // TODO add your handling code here:
        try {
            asal = asalComboBox.getSelectedItem().toString();
            asalIndex = asalComboBox.getSelectedIndex();
            tujuan = tujuanComboBox.getSelectedItem().toString();
            tujuanIndex = tujuanComboBox.getSelectedIndex();
            berat = Integer.parseInt(beratField.getText());
            Ongkir ongkir = new Ongkir();
            ongkir.setVisible(true);
            JOptionPane.showMessageDialog(null, "Cek Ongkos Kirim Berhasil!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Mohon masukan input yang sesuai!","Wrong Input!", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_cekOngkirBtnActionPerformed

    private void adminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminBtnActionPerformed
        // TODO add your handling code here:
        AdminLogin adminLogin = new AdminLogin();
        adminLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_adminBtnActionPerformed

    private void lacakBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lacakBtnActionPerformed
        // TODO add your handling code here:
        orderID = orderIDInput.getText();
        if(orderID.length() >= 6) {
            String subs = orderID.substring(0, 3);
            if(subs.equalsIgnoreCase("REG") || subs.equalsIgnoreCase("EXP")) {
                LacakKiriman lacakKiriman = new LacakKiriman();
                lacakKiriman.setVisible(true);
                JOptionPane.showMessageDialog(null, "Lacak Orderan Berhasil");
            } else {
                JOptionPane.showMessageDialog(this, "Mohon masukan input yang sesuai!","Wrong Input!", JOptionPane.ERROR_MESSAGE); 
            }
        } else {
            JOptionPane.showMessageDialog(this, "Mohon masukan input yang sesuai!","Wrong Input!", JOptionPane.ERROR_MESSAGE); 
        }
        
        
    }//GEN-LAST:event_lacakBtnActionPerformed

    private void makeOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeOrderButtonActionPerformed
        // TODO add your handling code here:
        MakeOrder MakeOrderPage = new MakeOrder();
        MakeOrderPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_makeOrderButtonActionPerformed
       
    
    private void connectToDB() {
        String url = "jdbc:sqlserver://localhost:1433; databaseName=nafarra; integratedSecurity=true;";
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Connected to Database");

        } catch (SQLException throwables) {
            System.out.println("Oops, an error has occured");
            throwables.printStackTrace();
        }
    }
    
    private void populateAsalComboBox(){
        try {
            String query = "SELECT prov_name FROM Province";
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String prov_name = rs.getString("prov_name");
                asalComboBox.addItem(prov_name);
            }

        } catch (SQLException throwables) {
            System.out.println("Oops, an error has occured");
            throwables.printStackTrace();
        }
    }
    
    private void populateTujuanComboBox() {
        try {
            String query = "SELECT prov_name FROM Province";
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String prov_name = rs.getString("prov_name");
                tujuanComboBox.addItem(prov_name);
            }
        } catch (SQLException throwables) {
            System.out.println("Oops, an error has occured");
            throwables.printStackTrace();
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminBtn;
    private javax.swing.JComboBox<String> asalComboBox;
    private javax.swing.JTextField beratField;
    private javax.swing.JButton cekOngkirBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton lacakBtn;
    private javax.swing.JButton makeOrderButton;
    private javax.swing.JTextField orderIDInput;
    private javax.swing.JComboBox<String> tujuanComboBox;
    // End of variables declaration//GEN-END:variables
}