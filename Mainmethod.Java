import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public final class Calunod extends javax.swing.JFrame {
    private javax.swing.JTextField Id;

    public Calunod() throws SQLException {
        initComponents();
        Connect();
        LoadProductNo();
        Fetch();                   
       
    }

   Connection con; 
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect(){
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/awaw", "root","root");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Calunod.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadProductNo (){
        try {
            pst = con.prepareStatement("SELECT id FROM wawa");
            rs = pst.executeQuery();
            txtpid.removeAllItems();
            while(rs.next()){
            txtpid.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Calunod.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    
    private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM wawa");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int a=1; a<=q; a++){
                    v2.add(rs.getString("ID"));
                    v2.add(rs.getString("Product Name"));
                    v2.add(rs.getString("Price"));
                    v2.add(rs.getString("Quantity"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Calunod.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtpid = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtPname = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Product ID:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Product Quantity:");

        btnAdd.setBackground(new java.awt.Color(0, 153, 153));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(0, 102, 204));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(204, 102, 0));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(204, 51, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Choose ID:");

        txtpid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtpid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpidActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Price", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Product Price:");

        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        txtPname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPnameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("BankGothic Md BT", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(117, 99, 0));
        jLabel5.setText("Stock Management Solution");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Product Name:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpid, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPname, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(167, 167, 167)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtpid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(370, 370, 370))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void txtPnameActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void txtpidActionPerformed(java.awt.event.ActionEvent evt) {                                       

    }                                      

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          

        try {
            Object selectedItem = txtpid.getSelectedItem();

            if (selectedItem == null || selectedItem.toString().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select a valid product ID to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String pid = selectedItem.toString();

            int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete product ID " + pid + "?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION);

            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }

            pst = con.prepareStatement("DELETE FROM wawa WHERE id = ?");
            pst.setString(1, pid);

            int k = pst.executeUpdate();
            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Record has been successfully deleted!");
                txtid.setText("");
                txtPname.setText("");
                txtPrice.setText("");
                txtQty.setText("");
                txtPname.requestFocus();
                Fetch();
                LoadProductNo();
            } else {
                JOptionPane.showMessageDialog(this, "Record failed to delete!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Calunod.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "SQL Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                         

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          

        try {
            Object selectedItem = txtpid.getSelectedItem();

            if (selectedItem == null) {
                JOptionPane.showMessageDialog(this, "No product selected", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String selectedPid = selectedItem.toString();
            String newID = txtid.getText().trim();
            String pname = txtPname.getText().trim();
            String price = txtPrice.getText().trim();
            String qty = txtQty.getText().trim();

            if (newID.isEmpty() || pname.isEmpty() || price.isEmpty() || qty.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            PreparedStatement checkID = con.prepareStatement("SELECT * FROM wawa WHERE ID = ? AND ID != ?");
            checkID.setString(1, newID);
            checkID.setString(2, selectedPid);
            ResultSet rsID = checkID.executeQuery();
            if (rsID.next()) {
                JOptionPane.showMessageDialog(this, "Product ID already exists!", "Duplicate ID", JOptionPane.ERROR_MESSAGE);
                return;
            }

            PreparedStatement checkName = con.prepareStatement("SELECT * FROM wawa WHERE `Product Name` = ? AND ID != ?");
            checkName.setString(1, pname);
            checkName.setString(2, selectedPid);
            ResultSet rsName = checkName.executeQuery();
            if (rsName.next()) {
                JOptionPane.showMessageDialog(this, "Product Name already exists!", "Duplicate Name", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Update record using WHERE ID = selectedPid
            PreparedStatement pst = con.prepareStatement(
                "UPDATE wawa SET ID = ?, `Product Name` = ?, Price = ?, Quantity = ? WHERE ID = ?"
            );
            pst.setString(1, newID);
            pst.setString(2, pname);
            pst.setString(3, price);
            pst.setString(4, qty);
            pst.setString(5, selectedPid);

            int k = pst.executeUpdate();
            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Record has been successfully updated!");
                txtid.setText("");
                txtPname.setText("");
                txtPrice.setText("");
                txtQty.setText("");
                txtPname.requestFocus();
                Fetch();
                LoadProductNo();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Calunod.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

    }                                         

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {                                          

        try {
            Object selectedItem = txtpid.getSelectedItem();

            if (selectedItem == null) {
                JOptionPane.showMessageDialog(this, "No product selected", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String pid = txtpid.getSelectedItem().toString();

            pst = con.prepareStatement("SELECT * FROM wawa WHERE id=?");
            pst.setString(1,pid);
            rs=pst.executeQuery();

            if(rs.next()==true){
                txtid.setText(rs.getString("ID"));
                txtPname.setText(rs.getString("Product Name"));
                txtPrice.setText(rs.getString("Price"));
                txtQty.setText(rs.getString("Quantity"));

            }else {
                JOptionPane.showMessageDialog(this, "No record found" );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Calunod.class.getName()).log(Level.SEVERE, null, ex);
        }

    }                                         

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if(txtid.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Product ID is required" );
        }else if(txtPname.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Product name is required" );
        }else if(txtPrice.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Product price is required" );
        }else if(txtQty.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Product qty is required" );

        }else{

            try {
                String ID = txtid.getText();
                String pname = txtPname.getText();
                String price = txtPrice.getText();
                String qty = txtQty.getText();

                try {
                    PreparedStatement checkStmt = con.prepareStatement("SELECT * FROM wawa WHERE id = ?");
                    checkStmt.setString(1, ID);
                    ResultSet rs = checkStmt.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "Product ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    PreparedStatement checkName = con.prepareStatement("SELECT * FROM wawa WHERE `Product Name` = ?");
                    checkName.setString(1, pname);
                    ResultSet rsName = checkName.executeQuery();

                    if (rsName.next()) {
                        JOptionPane.showMessageDialog(this, "Product Name already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    pst = con.prepareStatement("INSERT INTO wawa (ID,`Product Name`,Price,Quantity)VALUES(?,?,?,?)");
                    pst.setString(1, ID);
                    pst.setString(2, pname);
                    pst.setString(3, price);
                    pst.setString(4, qty);

                    int k = pst.executeUpdate();

                    if (k == 1) {
                        JOptionPane.showMessageDialog(this, "Record Added Successfully!!!");
                        txtid.setText("");
                        txtPname.setText("");
                        txtPrice.setText("");
                        txtQty.setText("");
                        Fetch();
                        LoadProductNo();
                    } else {
                        JOptionPane.showMessageDialog(this, "Record failed to save!!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Calunod.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (HeadlessException e) {
            }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bocadoprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(() -> {
            new loginform().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtPname;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtid;
    private javax.swing.JComboBox<String> txtpid;
    // End of variables declaration                   

}
