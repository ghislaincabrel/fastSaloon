/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finamproject;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class admin extends javax.swing.JFrame {

    String ImgPath = null;
    String ImgPath1 = null;
    ResizeImage img = new ResizeImage();
    Connecter connect = new Connecter();
    Connection con = connect.getConnect();
    PreparedStatement ps;
    PreparedStatement pss;
    PreparedStatement pss1;

    public admin() {
        initComponents();

    }

    String email;

    public admin(String val) throws SQLException {
        initComponents();
        this.setSize(1100, 700);
        jButton3.setEnabled(false);
        jButton2.setEnabled(false);
        this.setLocationRelativeTo(null);
        jLabel5.setIcon(img.ResizeImage("C:\\Users\\Admin\\Desktop\\demo-team-member.jpg", null, jLabel5.getWidth(), jLabel5.getHeight()));
//        jLabel14.setIcon(img.ResizeImage("C:\\Users\\Admin\\Desktop\\british_columbia.jpg", null, jLabel14.getWidth(), jLabel14.getHeight()));

        this.email = val;
        setImage();
        Show_services_In_JTable();
    }

    public void setImage() throws SQLException {

        String query = "SELECT saloonName,saloonImage FROM service_provider WHERE email = ? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String saloon = rs.getString("saloonName").toUpperCase();
            txt_name1.setText(saloon);
            jLabel1.setIcon(img.ResizeImage(null, rs.getBytes("saloonImage"), jLabel1.getWidth(), jLabel1.getHeight()));
        }
    }

    public ArrayList<Services> getProductList() {
        ArrayList<Services> servicetList = new ArrayList<Services>();
        Connection con = connect.getConnect();
        try {

            String query = "SELECT id,haid_style,price,image  FROM services WHERE email = ?  ";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Services service = new Services(rs.getInt("id"), rs.getString("haid_style"), rs.getInt("price"), rs.getBytes("image"));
                servicetList.add(service);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return servicetList;

    }

    public void setInfo() {
        try {

            String query1 = "SELECT * FROM service_provider WHERE email= ?  ";
            PreparedStatement ps = con.prepareStatement(query1);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //set the information
                txt_saloonName.setText(rs.getString("saloonName"));
                txt_town.setSelectedItem(rs.getString("town"));
                txt_quater.setText(rs.getString("quater"));
                txt_description.setText(rs.getString("description"));
                txt_contact.setText(rs.getString("contact"));

                imageI.setIcon(img.ResizeImage(null, rs.getBytes("saloonImage"), imageI.getWidth(), imageI.getHeight()));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void Show_services_In_JTable() {
        ArrayList<Services> list = getProductList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        // clear jtable content
        model.setRowCount(0);
        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getHaid_Style();
            row[1] = list.get(i).getPrice();
            row[2] = list.get(i).getImage();

            model.addRow(row);
        }

    }

    public void ShowItem(int index) {
        txt_haid.setText(getProductList().get(index).getHaid_Style());
        txt_price.setText(Integer.toString(getProductList().get(index).getPrice()));
        jLabel5.setIcon(img.ResizeImage(null, getProductList().get(index).getImage(), jLabel5.getWidth(), jLabel5.getHeight()));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_haid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txt_name1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_saloonName = new javax.swing.JTextField();
        txt_quater = new javax.swing.JTextField();
        txt_contact = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_description = new javax.swing.JTextArea();
        txt_password = new javax.swing.JPasswordField();
        imageI = new javax.swing.JLabel();
        Update = new javax.swing.JButton();
        Update1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txt_town = new javax.swing.JComboBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(260, 10, 351, 176);

        jLabel2.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel2.setText("Haid_Style :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 240, 91, 25);

        txt_haid.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jPanel1.add(txt_haid);
        txt_haid.setBounds(150, 240, 230, 30);

        jLabel3.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel3.setText("Image");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 360, 50, 25);

        jLabel4.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel4.setText("Price:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 300, 41, 25);

        txt_price.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jPanel1.add(txt_price);
        txt_price.setBounds(150, 300, 230, 30);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(150, 350, 230, 152);

        jButton1.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        jButton1.setText("Browse");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(290, 510, 90, 17);

        jButton2.setBackground(new java.awt.Color(102, 255, 0));
        jButton2.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\ICON\\1484958167_adept_update.png")); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(150, 560, 113, 41);

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\ICON\\1484913657_Delete.png")); // NOI18N
        jButton3.setText("Delete");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(280, 560, 107, 41);

        jButton4.setBackground(new java.awt.Color(102, 102, 255));
        jButton4.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\ICON\\1484913691_Save.png")); // NOI18N
        jButton4.setText("Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(30, 560, 97, 41);

        jTable1.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hiair_Style", "Price", "Image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(20);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(410, 247, 430, 275);

        txt_name1.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        txt_name1.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(txt_name1);
        txt_name1.setBounds(370, 190, 200, 40);

        jTabbedPane1.addTab("Account", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel7.setText("SaloonName:");

        jLabel8.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel8.setText("Description :");

        jLabel9.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel9.setText("Town");

        jLabel10.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel10.setText("Contact :");

        jLabel11.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel11.setText("Image:");

        jLabel12.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel12.setText("Password:");

        jLabel13.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel13.setText("Quater :");

        txt_saloonName.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        txt_quater.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        txt_contact.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        txt_description.setColumns(20);
        txt_description.setRows(5);
        jScrollPane2.setViewportView(txt_description);

        txt_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Update.setBackground(new java.awt.Color(255, 255, 255));
        Update.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        Update.setForeground(new java.awt.Color(51, 255, 0));
        Update.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\ICON\\1484958167_adept_update.png")); // NOI18N
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Update1.setBackground(new java.awt.Color(255, 255, 255));
        Update1.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        Update1.setForeground(new java.awt.Color(255, 0, 0));
        Update1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\ICON\\1484913657_Delete.png")); // NOI18N
        Update1.setText("Delete");
        Update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update1ActionPerformed(evt);
            }
        });

        jButton5.setText(" browse");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txt_town.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        txt_town.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bafoussam", "Buea", "Douala", "Yaounde", "Bamenda", "Dschang" }));

        jCheckBox1.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jCheckBox1.setText("See password");
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imageI, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel10)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(62, 62, 62)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                        .addComponent(txt_saloonName)
                                        .addComponent(txt_quater)
                                        .addComponent(txt_contact)
                                        .addComponent(txt_town, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(Update)
                        .addGap(26, 26, 26)
                        .addComponent(Update1)
                        .addContainerGap(116, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_saloonName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_town, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_quater, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(53, 53, 53)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jCheckBox1))
                        .addGap(18, 18, 18)
                        .addComponent(imageI, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(51, 51, 51)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Update)
                            .addComponent(Update1))
                        .addGap(58, 58, 58))))
        );

        jTabbedPane1.addTab("Personal information", jPanel2);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(-8, -11, 1160, 690);

        jMenu1.setForeground(new java.awt.Color(255, 0, 51));
        jMenu1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\ICON\\1484959318_exit.png")); // NOI18N
        jMenu1.setText("Logout");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        setInfo();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jCheckBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseClicked
        if (jCheckBox1.isSelected()) {
            txt_password.setEchoChar((char) 0);
        } else {
            txt_password.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            imageI.setIcon(img.ResizeImage(path, null, imageI.getWidth(), imageI.getHeight()));
            ImgPath1 = path;
        } else {
            System.out.println("No File Selected");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void Update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update1ActionPerformed
        int reponse = JOptionPane.showConfirmDialog(null, "Are you sur you want to Delete the accont ?", "message", JOptionPane.YES_NO_OPTION);
        if (reponse == JOptionPane.YES_OPTION) {
            try {
                ps = con.prepareStatement("DELETE FROM service_provider WHERE email = ? ");
                ps.setString(1, email);
                ps.executeUpdate();

                try {
                    pss = con.prepareStatement("DELETE FROM services WHERE email = ? ");
                    pss.setString(1, email);
                    pss.executeUpdate();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                JOptionPane.showMessageDialog(null, "Account Delete");
                new login().setVisible(true);
                this.hide();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_Update1ActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // check if the field are empty
        if (txt_saloonName.getText().isEmpty() || txt_town.getSelectedItem().toString().isEmpty() || txt_quater.getText().isEmpty() || txt_description.getText().isEmpty() || txt_contact.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "One or more field are empty");
        } else if (ImgPath1 == null) {
            try {
                //check if the the password is empty and update
                if (txt_password.getText().isEmpty()) {
                    ps = con.prepareStatement("UPDATE service_provider SET saloonName = ?, town = ? ,quater = ? ,description = ?,contact = ?   WHERE email = ? ");

                    ps.setString(1, txt_saloonName.getText());
                    ps.setString(2, txt_town.getSelectedItem().toString());
                    ps.setString(3, txt_quater.getText());
                    ps.setString(4, txt_description.getText());
                    ps.setString(5, txt_contact.getText());
                    ps.setString(6, email);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Update");
                } else {
                    ps = con.prepareStatement("UPDATE service_provider SET saloonName = ?, town = ? ,quater = ? ,description = ?,contact = ? ,password = ?  WHERE email = ? ");

                    ps.setString(1, txt_saloonName.getText());
                    ps.setString(2, txt_town.getSelectedItem().toString());
                    ps.setString(3, txt_quater.getText());
                    ps.setString(4, txt_description.getText());
                    ps.setString(5, txt_contact.getText());
                    ps.setInt(6, txt_password.getText().hashCode());
                    ps.setString(7, email);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Update");
                }

                setImage();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            try {
                if (txt_password.getText().isEmpty()) {
                    ps = con.prepareStatement("UPDATE service_provider SET saloonName = ?, town = ? ,quater = ? ,description = ?, contact = ? ,saloonImage= ? WHERE email= ? ");;

                    ps.setString(1, txt_saloonName.getText());
                    ps.setString(2, txt_town.getSelectedItem().toString());
                    ps.setString(3, txt_quater.getText());
                    ps.setString(4, txt_description.getText());
                    ps.setString(5, txt_contact.getText());

                    InputStream img1 = new FileInputStream(new File(ImgPath1));
                    ps.setBlob(6, img1);
                    ps.setString(7, email);

                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Update");

                } else {
                    ps = con.prepareStatement("UPDATE service_provider SET saloonName = ?, town = ? ,quater = ? ,description = ?,contact = ? ,password = ? ,saloonImage= ? WHERE email = ?  ");

                    ps.setString(1, txt_saloonName.getText());
                    ps.setString(2, txt_town.getSelectedItem().toString());
                    ps.setString(3, txt_quater.getText());
                    ps.setString(4, txt_description.getText());
                    ps.setString(5, txt_contact.getText());
                    ps.setInt(6, txt_password.getText().hashCode());

                    InputStream img1 = new FileInputStream(new File(ImgPath1));
                    ps.setBlob(7, img1);
                    ps.setString(8, email);

                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Update");
                }

                setImage();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jButton3.setEnabled(true);
        jButton2.setEnabled(true);
        int index = jTable1.getSelectedRow();

        ShowItem(index);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if ((txt_haid.getText().isEmpty() || txt_price.getText().isEmpty() || ImgPath == null)) {
            JOptionPane.showMessageDialog(null, "One Or More Field Are Empty");
        } else {

            String query0 = "SELECT * FROM services WHERE haid_style= ? AND image=? ";
            try {
                PreparedStatement ps = con.prepareStatement(query0);
                ps.setString(1, txt_haid.getText());
                InputStream img1 = new FileInputStream(new File(ImgPath));
                ps.setBlob(2, img1);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "The field already exist");
                } else {
                    try {
                        PreparedStatement ps1 = con.prepareStatement("INSERT INTO services(email,haid_style,price,image)"
                                + "values(?,?,?,?) ");
                        ps1.setString(1, email);
                        ps1.setString(2, txt_haid.getText());
                        ps1.setString(3, txt_price.getText());

                        InputStream img = new FileInputStream(new File(ImgPath));
                        ps1.setBlob(4, img);

                        ps1.executeUpdate();
                        Show_services_In_JTable();

                        JOptionPane.showMessageDialog(null, "Data Inserted");
                        txt_haid.setText("");
                        txt_price.setText("");
                        jLabel5.setIcon(null);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());

                    }

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int reponse = JOptionPane.showConfirmDialog(null, "Are you sur you want to Delete ?", "message", JOptionPane.YES_NO_OPTION);
        if (reponse == JOptionPane.YES_OPTION) {
            int x = jTable1.getSelectedRow();
            int x1 = getProductList().get(x).getId();
            try {
                ps = con.prepareStatement("DELETE FROM services WHERE id = ?");
                ps.setInt(1, x1);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data Delete");
                Show_services_In_JTable();

                txt_haid.setText("");
                txt_price.setText("");
                jLabel5.setIcon(null);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int x = jTable1.getSelectedRow();
        int x1 = getProductList().get(x).getId();
        //  jTextField1.setText(String.valueOf(x1));
        if (ImgPath == null) {
            try {
                ps = con.prepareStatement("UPDATE services SET haid_style = ?, price = ?  WHERE id = ?");

                ps.setString(1, txt_haid.getText());
                ps.setString(2, txt_price.getText());
                ps.setInt(3, x1);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data Update");
                Show_services_In_JTable();
                txt_haid.setText("");
                txt_price.setText("");
                jLabel5.setIcon(null);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            try {
                ps = con.prepareStatement("UPDATE services SET haid_style = ?, price = ?,image = ? WHERE id= ? ");
                ps.setString(1, txt_haid.getText());
                ps.setString(2, txt_price.getText());

                InputStream img = new FileInputStream(new File(ImgPath));
                ps.setBlob(3, img);

                ps.setInt(4, x1);
                ps.executeUpdate();

                Show_services_In_JTable();

                JOptionPane.showMessageDialog(null, "Data Update");
                txt_haid.setText("");
                txt_price.setText("");
                jLabel5.setIcon(null);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            jLabel5.setIcon(img.ResizeImage(path, null, jLabel5.getWidth(), jLabel5.getHeight()));
            ImgPath = path;
        } else {
            System.out.println("No File Selected");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        new login().setVisible(true);
        this.hide();
    }//GEN-LAST:event_jMenu1MouseClicked

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
            java.util.logging.Logger.getLogger(admin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Update;
    private javax.swing.JButton Update1;
    private javax.swing.JLabel imageI;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_contact;
    private javax.swing.JTextArea txt_description;
    private javax.swing.JTextField txt_haid;
    public javax.swing.JLabel txt_name1;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_quater;
    private javax.swing.JTextField txt_saloonName;
    private javax.swing.JComboBox txt_town;
    // End of variables declaration//GEN-END:variables
}
