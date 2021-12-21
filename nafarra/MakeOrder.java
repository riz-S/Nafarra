package nafarra;

import java.sql.*;
import javax.swing.JOptionPane;


public class MakeOrder extends javax.swing.JFrame {
    Statement state;
    Connection connect;
    
    public MakeOrder() {
        initComponents();
        loadDatabase();
        setProvince();
    }
    
    public void loadDatabase() {
        try {
            connect = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=nafarra; integratedSecurity=true;");
            state = connect.createStatement();
            System.out.println("EXECUTED");
        } catch (Exception e) {
            System.out.println("There's an error");
            e.printStackTrace();
        }
    }
    
    public void setProvince() {
        try {
            ResultSet result = state.executeQuery("SELECT DISTINCT (prov_name) FROM Province");
            while (result.next()) {
                String provName = result.getString("prov_name");
                provAsal.addItem(provName);
                provTuj.addItem(provName);
            }
        } catch (SQLException throwables) {
            System.out.println("Oops, an error has occured");
            throwables.printStackTrace();
        }
    }
    
    boolean setArrayValue(Object pengirim[], Object penerima[]) {
        
        boolean send = true;
        for (int i = 0; i < pengirim.length; i++) {
            if (pengirim[i].equals("")) {
                send = false;
            }
        }
        for (int i = 0; i < penerima.length; i++) {
            if (penerima[i].equals("")) {
                send = false;
            }
        }
        return send;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        buttonReturn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        simpanData = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        namaPengirim = new javax.swing.JTextField();
        namaPenerima = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jalanAsal = new javax.swing.JTextField();
        noAsal = new javax.swing.JTextField();
        kotaAsal = new javax.swing.JTextField();
        posAsal = new javax.swing.JTextField();
        provAsal = new javax.swing.JComboBox<>();
        jalanTuj = new javax.swing.JTextField();
        noTuj = new javax.swing.JTextField();
        kotaTuj = new javax.swing.JTextField();
        posTuj = new javax.swing.JTextField();
        provTuj = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        noPengirim = new javax.swing.JTextField();
        noPenerima = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tipeKirim = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(233, 235, 221));

        jPanel2.setBackground(new java.awt.Color(97, 140, 124));

        buttonReturn.setBackground(new java.awt.Color(206, 217, 126));
        buttonReturn.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        buttonReturn.setForeground(new java.awt.Color(97, 140, 124));
        buttonReturn.setText("< Kembali");
        buttonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReturnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(233, 235, 221));
        jLabel1.setText("Masukkan Data Pesanan");

        simpanData.setBackground(new java.awt.Color(206, 217, 126));
        simpanData.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        simpanData.setForeground(new java.awt.Color(97, 140, 124));
        simpanData.setText("Simpan Data");
        simpanData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(buttonReturn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(136, 136, 136)
                .addComponent(simpanData)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonReturn)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(simpanData))
                .addGap(19, 19, 19))
        );

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(97, 140, 124));
        jLabel2.setText("Alamat Tujuan");

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(97, 140, 124));
        jLabel4.setText("Alamat Asal");

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(97, 140, 124));
        jLabel5.setText("Nama Pengirim");

        jLabel6.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(97, 140, 124));
        jLabel6.setText("Nama Penerima");

        namaPengirim.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        namaPenerima.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(97, 140, 124));
        jLabel7.setText("Kota");

        jLabel8.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(97, 140, 124));
        jLabel8.setText("Kota");

        jLabel9.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(97, 140, 124));
        jLabel9.setText("Nama Jalan");

        jLabel10.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(97, 140, 124));
        jLabel10.setText("Nama Jalan");

        jLabel11.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(97, 140, 124));
        jLabel11.setText("No. Jalan");

        jLabel12.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(97, 140, 124));
        jLabel12.setText("No. Jalan");

        jLabel13.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(97, 140, 124));
        jLabel13.setText("Kode Pos");

        jLabel14.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(97, 140, 124));
        jLabel14.setText("Kode Pos");

        jLabel15.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(97, 140, 124));
        jLabel15.setText("Provinsi");

        jLabel16.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(97, 140, 124));
        jLabel16.setText("Provinsi");

        jalanAsal.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        noAsal.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        kotaAsal.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        posAsal.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        provAsal.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N

        jalanTuj.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        noTuj.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        kotaTuj.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        posTuj.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        provTuj.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(97, 140, 124));
        jLabel17.setText("No. HP Pengirim");

        noPengirim.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        noPenerima.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(97, 140, 124));
        jLabel18.setText("No. HP Penerima");

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(97, 140, 124));
        jLabel3.setText("Tipe Pengiriman");

        tipeKirim.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        tipeKirim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "REGULER", "EXPRESS" }));
        tipeKirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipeKirimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15)
                            .addComponent(jLabel7)
                            .addComponent(jLabel13))
                        .addGap(358, 358, 358)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jalanTuj, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noTuj, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kotaTuj, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(posTuj, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(provTuj, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(namaPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(noAsal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jalanAsal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kotaAsal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(posAsal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(provAsal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(noPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tipeKirim, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(noPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namaPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(2, 2, 2)))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(namaPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(noPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(noPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipeKirim, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jalanAsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(noAsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(kotaAsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(posAsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(provAsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jalanTuj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(noTuj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kotaTuj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(posTuj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(provTuj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addContainerGap(17, Short.MAX_VALUE))
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

    private void buttonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReturnActionPerformed
        // TODO add your handling code here:
        UserPage UserP = new UserPage();
        UserP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonReturnActionPerformed

    private void tipeKirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipeKirimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipeKirimActionPerformed

    private void simpanDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanDataActionPerformed
        // TODO add your handling code here:
        Object pengirim[] = new Object[8];
        Object penerima[] = new Object[7];
        pengirim[0] = namaPengirim.getText();
        pengirim[1] = noPengirim.getText();
        pengirim[2] = tipeKirim.getSelectedItem().toString();
        pengirim[3] = jalanAsal.getText();
        pengirim[4] = noAsal.getText();
        pengirim[5] = kotaAsal.getText();
        pengirim[6] = posAsal.getText();
        pengirim[7] = provAsal.getSelectedItem().toString();
        
        penerima[0] = namaPenerima.getText();
        penerima[1] = noPenerima.getText();
        penerima[2] = jalanTuj.getText();
        penerima[3] = noTuj.getText();
        penerima[4] = kotaTuj.getText();
        penerima[5] = posTuj.getText();
        penerima[6] = provTuj.getSelectedItem().toString();
        
        boolean send = setArrayValue(pengirim, penerima);
        try {   
            if (send == true) {
                connect.setAutoCommit(false);
                String temp = String.valueOf(pengirim[0]);
                String[] nama = new String[2];
                if(temp.contains(" ")){
                    nama = temp.split(" ", 2);
                }
                else{
                    nama[0] = temp;
                    nama[1] =  " ";
                }
                String query = "INSERT INTO Customer VALUES ('" + pengirim[1] + "','" + nama[0] 
                        + "','" + nama[1] + "','" + pengirim[3] + "','" + pengirim[4] + "','" + 
                        pengirim[5]+ "','" + pengirim[6] +"')";
                Statement statement = connect.createStatement();
                int input = JOptionPane.showConfirmDialog(null, 
                    "Apakah anda yakin ingin menambahkan data anda?", 
                    "Select an Option...",JOptionPane.OK_CANCEL_OPTION);
                statement.executeUpdate(query);
                if(input == 0){
                    connect.commit();
                    JOptionPane.showMessageDialog(this, "Data anda berhasil ditambahkan!");
                }
                else{
                    connect.rollback();
                    JOptionPane.showMessageDialog(this, "Data anda batal ditambahkan!","Error...",
                    JOptionPane.ERROR_MESSAGE);
                }
                AddItem pageTambahItem = new AddItem();
                pageTambahItem.setVisible(true);
                pageTambahItem.getDataUser(pengirim, penerima);
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(this, "Harap mengisi seluruh kolom yang ada", "Pengisian Dibatalkan", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan Saat Menambah Data","Error...",
            JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_simpanDataActionPerformed

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
            java.util.logging.Logger.getLogger(MakeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MakeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MakeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MakeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MakeOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jalanAsal;
    private javax.swing.JTextField jalanTuj;
    private javax.swing.JTextField kotaAsal;
    private javax.swing.JTextField kotaTuj;
    private javax.swing.JTextField namaPenerima;
    private javax.swing.JTextField namaPengirim;
    private javax.swing.JTextField noAsal;
    private javax.swing.JTextField noPenerima;
    private javax.swing.JTextField noPengirim;
    private javax.swing.JTextField noTuj;
    private javax.swing.JTextField posAsal;
    private javax.swing.JTextField posTuj;
    private javax.swing.JComboBox<String> provAsal;
    private javax.swing.JComboBox<String> provTuj;
    private javax.swing.JButton simpanData;
    private javax.swing.JComboBox<String> tipeKirim;
    // End of variables declaration//GEN-END:variables
}
