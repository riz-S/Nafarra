package nafarra;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class AddItem extends javax.swing.JFrame {
    int index = 0;
    DefaultTableModel myTable;
    Connection connect;
    ArrayList<ArrayList<Object>> allData = new ArrayList<ArrayList<Object>>();
    Object dataPengirim[], dataPenerima[];
    
    public AddItem() {
        initComponents();
        loadDatabase();
        setTableEmpty();
    }
    
    public void loadDatabase() {
        try {
            connect = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=nafarra; integratedSecurity=true;");
            System.out.println("EXECUTED");
        } catch (SQLException throwables) {
            System.out.println("Oops, an error has occured");
            throwables.printStackTrace();
        }
    }
    
    public void addItemToTable(Object item[]) {
        allData.add(new ArrayList<>());
        for (int i = 0; i < item.length; i++) {
            allData.get(index).add(item[i]);
        }
        myTable = (DefaultTableModel)itemList.getModel();
        for (int i = 0; i < allData.size(); i++) {
            Object myData[] = {i+1, allData.get(i).get(0), (Integer) allData.get(i).get(1) * (Integer) allData.get(i).get(2) * (Integer) allData.get(i).get(3), allData.get(i).get(4)};
            myTable.addRow(myData);
        }
        this.index++;
    }
    
    public void setTableEmpty() {
        itemList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "No", "Nama Item", "Dimensi", "Berat"
            }
        ));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        confirmOrder = new javax.swing.JButton();
        buttonReturn = new javax.swing.JButton();
        editOrder1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemList = new javax.swing.JTable();
        namaBarang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panjang = new javax.swing.JTextField();
        lebar = new javax.swing.JTextField();
        tinggi = new javax.swing.JTextField();
        berat = new javax.swing.JTextField();
        addItem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(233, 235, 221));

        jPanel1.setBackground(new java.awt.Color(233, 235, 221));
        jPanel1.setForeground(new java.awt.Color(233, 235, 221));

        jPanel2.setBackground(new java.awt.Color(97, 140, 124));

        confirmOrder.setBackground(new java.awt.Color(206, 217, 126));
        confirmOrder.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        confirmOrder.setForeground(new java.awt.Color(97, 140, 124));
        confirmOrder.setText("KONFIRMASI ORDER");
        confirmOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmOrderActionPerformed(evt);
            }
        });

        buttonReturn.setBackground(new java.awt.Color(206, 217, 126));
        buttonReturn.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        buttonReturn.setForeground(new java.awt.Color(97, 140, 124));
        buttonReturn.setText("< KEMBALI");
        buttonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReturnActionPerformed(evt);
            }
        });

        editOrder1.setBackground(new java.awt.Color(206, 217, 126));
        editOrder1.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        editOrder1.setForeground(new java.awt.Color(97, 140, 124));
        editOrder1.setText("HAPUS ITEM");
        editOrder1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editOrder1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editOrder1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(confirmOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editOrder1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        itemList.setBackground(new java.awt.Color(233, 235, 221));
        itemList.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        itemList.setForeground(new java.awt.Color(97, 140, 124));
        itemList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nama Item", "Dimensi", "Berat"
            }
        ));
        itemList.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(itemList);

        namaBarang.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(97, 140, 124));
        jLabel1.setText("NAMA BARANG");

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(97, 140, 124));
        jLabel2.setText("PANJANG (CM)");

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(97, 140, 124));
        jLabel4.setText("TINGGI (CM)");

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(97, 140, 124));
        jLabel5.setText("BERAT (GR)");

        panjang.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        lebar.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        tinggi.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        berat.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        addItem.setBackground(new java.awt.Color(206, 217, 126));
        addItem.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        addItem.setForeground(new java.awt.Color(97, 140, 124));
        addItem.setText("+ TAMBAH ITEM");
        addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(97, 140, 124));
        jLabel3.setText("LEBAR (CM)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(panjang, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lebar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tinggi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(berat, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(addItem)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(panjang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lebar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tinggi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(berat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addItem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemActionPerformed
        // TODO add your handling code here:
        try {
            setTableEmpty();
            Integer lengthItem, widthItem, highItem, weightItem = null;
            lengthItem = Integer.parseInt(panjang.getText());
            widthItem = Integer.parseInt(lebar.getText());
            highItem = Integer.parseInt(tinggi.getText());
            weightItem = Integer.parseInt(berat.getText());
            Object myArr[] = new Object[5];
            myArr[0] = namaBarang.getText();
            myArr[1] = lengthItem;
            myArr[2] = widthItem;
            myArr[3] = highItem;
            myArr[4] = weightItem;
            addItemToTable(myArr);
            namaBarang.setText(null); panjang.setText(null); lebar.setText(null); tinggi.setText(null); berat.setText(null);
            JOptionPane.showMessageDialog(null, "PENGISIAN BERHASIL");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "1. Harap mengisi seluruh kolom yang ada\n2. Nilai dari Panjang, Lebar, Tinggi, serta Berat tidak boleh bernilai String", "Pengisian Dibatalkan", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_addItemActionPerformed

    private void buttonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReturnActionPerformed
        // TODO add your handling code here:
        MakeOrder MakeOrderPage = new MakeOrder();
        MakeOrderPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonReturnActionPerformed

    private void confirmOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmOrderActionPerformed
        // TODO add your handling code here:
        String numberAsal = String.valueOf(dataPengirim[1]);
        String tipe = String.valueOf(dataPengirim[2]);
        String jalanAsal = String.valueOf(dataPengirim[3]);
        String noJalanAsal = String.valueOf(dataPengirim[4]);
        String kotaAsal = String.valueOf(dataPengirim[5]);
        String posAsal = String.valueOf(dataPengirim[6]);
        String provAsal = String.valueOf(dataPengirim[7]);
        try {
            connect.setAutoCommit(false);
            String jnsKirim = tipe.equals("REGULER")? "REG":"EXP";
            String query = "exec addOrder '" + jalanAsal + "','" + noJalanAsal + "','" 
                    + posAsal + "','" + kotaAsal + "','" + java.time.LocalDate.now() + "','" + numberAsal 
                    + "','" + jnsKirim + "','" + provAsal + "'";
            Statement statement = connect.createStatement();
            int input = JOptionPane.showConfirmDialog(null, 
                "Apakah anda yakin ingin membuat order baru?", "Select an Option...",JOptionPane.OK_CANCEL_OPTION);
            statement.executeUpdate(query);
            if(input == 0 && !allData.isEmpty()){
                connect.commit();
                JOptionPane.showMessageDialog(this, "Order berhasil dibuat!");
            }
            else{
                if(allData.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Harap mengisi minimal 1 item","Error...",
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else
                    JOptionPane.showMessageDialog(this, "Order gagal dibuat!","Error...",
                    JOptionPane.ERROR_MESSAGE);
                connect.rollback();
            }
            addSemuaItem(getId(numberAsal));
            UserPage UserP = new UserPage();
            UserP.setVisible(true);
            this.dispose();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan Saat Menambah Order!","Error...",
            JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_confirmOrderActionPerformed
    private String getId(String pNum){
        String id ="";
        try {
            String query = "select order_id from Order1 where cust_phone_num = '"+pNum+
                    "' and date_made= '"+java.time.LocalDate.now()+"'";
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                id = rs.getString("order_id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "ID Gagal Didapatkan!","Error...", JOptionPane.ERROR_MESSAGE); 
            e.printStackTrace();
        }
        return id;
    }
    
    private void addSemuaItem(String id){
        for (int i = 0; i < allData.size(); i++) {
            Object namaB = allData.get(i).get(0);
            Object panjangB = allData.get(i).get(1);
            Object lebarB = allData.get(i).get(2);
            Object tinggiB = allData.get(i).get(3);
            Object beratB = allData.get(i).get(4);
            try {
                String query = "INSERT INTO Item values('" + namaB + "','" + id + "','" 
                        + panjangB + "','" + lebarB + "','" + tinggiB + "','" + beratB + "')";
                Statement statement = connect.createStatement();
                statement.executeUpdate(query);
                connect.commit();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Item Gagal Ditambahkan!","Error...", JOptionPane.ERROR_MESSAGE); 
                e.printStackTrace();
            }
        }
    }
    private void editOrder1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editOrder1ActionPerformed
        String index = JOptionPane.showInputDialog(null, "Masukkan nomor urutan item yang ingin dihapus", null);
        for (int i = 0; i < allData.size(); i++) {
            myTable.removeRow(0);
        }
        allData.remove(Integer.valueOf(index) - 1);
        this.index--;
        showTable();
    }//GEN-LAST:event_editOrder1ActionPerformed
    
    void showTable() {
        for (int i = 0; i < allData.size(); i++) {
            Object myData[] = {i+1, allData.get(i).get(0), (Integer) allData.get(i).get(1) * (Integer) allData.get(i).get(2) * (Integer) allData.get(i).get(3), allData.get(i).get(4)};
            this.myTable.addRow(myData);
        }
    }
    
    void getDataUser(Object arrPengirim[], Object arrPenerima[]) {
        this.dataPengirim = arrPengirim;
        this.dataPenerima = arrPenerima;
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
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddItem().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItem;
    private javax.swing.JTextField berat;
    private javax.swing.JButton buttonReturn;
    private javax.swing.JButton confirmOrder;
    private javax.swing.JButton editOrder1;
    private javax.swing.JTable itemList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lebar;
    private javax.swing.JTextField namaBarang;
    private javax.swing.JTextField panjang;
    private javax.swing.JTextField tinggi;
    // End of variables declaration//GEN-END:variables
}
