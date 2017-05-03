/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//pengen edit
package View;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;


import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author asus
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    public HomePage() {
        initComponents();
    }
     //Untuk yang Tambah Penyedia di Tab Data Barang Penyedia

    public JComboBox<String> getCbIdPenyedia() {
        return cbIdPenyedia;
    }

    public String getTfLokasiGudang() {
        return tfLokasiGudang.getText();
    }

    public String getTfIdG() {
        return tfIdG.getText();
    }


    public JButton getBtnAddGudang() {
        return btnAddGudang;
    }

    public void setBtnAddGudang(JButton btnAddGudang) {
        this.btnAddGudang = btnAddGudang;
    }
    
    public JTextArea getTxtDetailPny() {
        return txtDetailPny;
    }

    public void setTxtDetailPny(JTextArea txtDetailPny) {
        this.txtDetailPny = txtDetailPny;
    }

    
    
    public JButton getBtnPenyedia() {
        return btnAddPenyedia;
    }

    public JButton getBtnBarang() {
        return btnBarang;
    }
    
    
    
    public String getTfAlamat() {
        return tfAlamat.getText();
    }
    public void setTfAlamat(String alamat) {
        tfAlamat.setText(alamat);
    }
    public String getTfNama() {
        return tfNama.getText();
    } 
    public void setTfNama (String nama) {
        tfNama.setText(nama);
    }
    public String getTfNoHP() {    
        return tfNoHP.getText();
    }
    public void setTfNoHP (String hp){
        tfNoHP.setText(hp);
    }
    
    
    public void setTfIdBarang(String IdBarang) {
        tfIdBarang.setText(IdBarang);
    }

    public String getTfIdBarang() {
        return tfIdBarang.getText();
    }

    public void setTfNamaBarang(String NamaBarang) {
        tfNamaBarang.setText(NamaBarang);
    }

    public String getTfNamaBarang() {
        return tfNamaBarang.getText();
    }

    public void setTfStock(String Stock) {
        tfStock.setText(Stock);
    }

    public String getTfStock() {
        return tfStock.getText();
    }

    public void setTfHarga(String harga) {
        tfHarga.setText(harga);
    }

    public String getTfHarga() {
        return tfHarga.getText();
    }

    public JList<String> getListPenyedia() {
        return listPenyedia;
    }

    public JComboBox<String> getCbIdBarangG() {
        return cbIdBarangG;
    }

    public void setCbIdBarangG(JComboBox<String> cbIdBarangG) {
        this.cbIdBarangG = cbIdBarangG;
    }

    public JComboBox<String> getCbIdGudangG() {
        return cbIdGudangG;
    }

    public void setCbIdGudangG(JComboBox<String> cbIdGudangG) {
        this.cbIdGudangG = cbIdGudangG;
    }

    public JButton getBtnBarang2() {
        return btnBarang2;
    }

    public void setBtnBarang2(JButton btnBarang2) {
        this.btnBarang2 = btnBarang2;
    }

    public JTable getTabAllBarang() {
        return tabAllBarang;
    }

    public void setTabAllBarang(JTable tabAllBarang) {
        this.tabAllBarang = tabAllBarang;
    }
    

    public JList<String> getListGudang() {
        return listGudang;
    }

    public JTable getTabBarangP() {
        return tabBarangP;
    }

    public JTable getTabBarangG() {
        return tabBarangG;
    }
    
    public void showMessage(String message, String title, int type)
     {
         JOptionPane.showMessageDialog(null, message, title, type);
     }
    
    public void showMessage (String message)  {
        JOptionPane.showMessageDialog(null, message);
    }
    
    public void addKeyListener(KeyListener e)
    {
        tabBarangP.addKeyListener(e);
        tabBarangG.addKeyListener(e);
    }
    
    public void addListener(ActionListener e){
        btnAddPenyedia.addActionListener(e);
        btnBarang.addActionListener(e);
        btnAddGudang.addActionListener(e);
        btnBarang2.addActionListener(e);
    }
    public void addListSelection(ListSelectionListener ls)
    {
        listPenyedia.addListSelectionListener(ls);
        listGudang.addListSelectionListener(ls);
    }
    
    public void reset () {
        tfAlamat.setText("");
        tfHarga.setText("");
        tfIdBarang.setText("");
        tfIdG.setText("");
        tfLokasiGudang.setText("");
        tfNama.setText("");
        tfNamaBarang.setText("");
        tfNoHP.setText("");
        tfStock.setText("");
        tfStockG.setText("");
    }
    public void addActionListener (ActionListener e) {
        btnAddGudang.addActionListener(e);
        btnAddPenyedia.addActionListener(e);
        btnBarang.addActionListener(e);
        btnBarang2.addActionListener(e);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings(value = "unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        tabPenyedia = new javax.swing.JTabbedPane();
        panelPenyedia = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabBarangP = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        listPenyedia = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAddPenyedia = new javax.swing.JButton();
        tfNama = new javax.swing.JTextField();
        tfAlamat = new javax.swing.JTextField();
        tfNoHP = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        tfNamaBarang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfStock = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfHarga = new javax.swing.JTextField();
        btnBarang = new javax.swing.JButton();
        cbIdPenyedia = new javax.swing.JComboBox<>();
        tfIdBarang = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDetailPny = new javax.swing.JTextArea();
        panelGudang = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabBarangG = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        listGudang = new javax.swing.JList<>();
        jPanel6 = new javax.swing.JPanel();
        tfIdG = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnAddGudang = new javax.swing.JButton();
        tfLokasiGudang = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tfStockG = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnBarang2 = new javax.swing.JButton();
        cbIdGudangG = new javax.swing.JComboBox<>();
        cbIdBarangG = new javax.swing.JComboBox<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabAllBarang = new javax.swing.JTable();

        jCheckBox1.setText("jCheckBox1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabBarangP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Barang", "Nama Barang", "Stock", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabBarangP);
        if (tabBarangP.getColumnModel().getColumnCount() > 0) {
            tabBarangP.getColumnModel().getColumn(0).setResizable(false);
            tabBarangP.getColumnModel().getColumn(1).setResizable(false);
            tabBarangP.getColumnModel().getColumn(2).setResizable(false);
            tabBarangP.getColumnModel().getColumn(3).setResizable(false);
        }

        listPenyedia.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listPenyediaValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listPenyedia);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tambah penyedia barang"));

        jLabel2.setText("Nama");

        jLabel4.setText("Alamat");

        jLabel5.setText("No HP");

        btnAddPenyedia.setText("Tambah Penyedia");
        btnAddPenyedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPenyediaActionPerformed(evt);
            }
        });

        tfNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaActionPerformed(evt);
            }
        });

        tfAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAlamatActionPerformed(evt);
            }
        });

        tfNoHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNoHPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNama, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfAlamat, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfNoHP))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnAddPenyedia)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(btnAddPenyedia)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tambah barang pada penyedia"));

        jLabel6.setText("ID Penyedia");

        jLabel3.setText("ID Barang");

        jLabel7.setText("Nama barang");

        tfStock.setText("0");

        jLabel8.setText("Stock");

        jLabel9.setText("Harga");

        tfHarga.setText("0");
        tfHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHargaActionPerformed(evt);
            }
        });

        btnBarang.setText("Tambah Barang");

        cbIdPenyedia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfStock)
                    .addComponent(tfNamaBarang)
                    .addComponent(tfHarga)
                    .addComponent(cbIdPenyedia, 0, 148, Short.MAX_VALUE)
                    .addComponent(tfIdBarang))
                .addGap(18, 18, 18))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnBarang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbIdPenyedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tfIdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(btnBarang)
                .addGap(45, 45, 45))
        );

        txtDetailPny.setColumns(20);
        txtDetailPny.setRows(5);
        jScrollPane4.setViewportView(txtDetailPny);

        javax.swing.GroupLayout panelPenyediaLayout = new javax.swing.GroupLayout(panelPenyedia);
        panelPenyedia.setLayout(panelPenyediaLayout);
        panelPenyediaLayout.setHorizontalGroup(
            panelPenyediaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPenyediaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPenyediaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(panelPenyediaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelPenyediaLayout.setVerticalGroup(
            panelPenyediaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPenyediaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPenyediaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelPenyediaLayout.createSequentialGroup()
                        .addGroup(panelPenyediaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8)
                        .addGroup(panelPenyediaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        tabPenyedia.addTab("Data Barang Penyedia", panelPenyedia);

        tabBarangG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Barang", "Nama Barang", "Stock", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tabBarangG);
        if (tabBarangG.getColumnModel().getColumnCount() > 0) {
            tabBarangG.getColumnModel().getColumn(0).setResizable(false);
            tabBarangG.getColumnModel().getColumn(1).setResizable(false);
            tabBarangG.getColumnModel().getColumn(2).setResizable(false);
            tabBarangG.getColumnModel().getColumn(3).setResizable(false);
        }

        jScrollPane6.setViewportView(listGudang);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tambahkan gudang"));

        tfIdG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdGActionPerformed(evt);
            }
        });

        jLabel10.setText("ID");

        jLabel11.setText("Lokasi");

        btnAddGudang.setText("Tambah Gudang");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnAddGudang)
                        .addContainerGap(55, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfLokasiGudang, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfIdG))
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIdG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfLokasiGudang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddGudang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tambahkan barang pada gudang"));

        jLabel14.setText("ID Gudang");

        jLabel15.setText("ID Barang");

        jLabel17.setText("Stock");

        btnBarang2.setText("Tambah Barang");

        cbIdGudangG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbIdBarangG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBarang2)
                            .addComponent(tfStockG, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cbIdGudangG, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbIdBarangG, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cbIdGudangG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbIdBarangG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfStockG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBarang2)
                .addGap(104, 104, 104))
        );

        tabAllBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Barang", "Nama Barang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tabAllBarang);

        javax.swing.GroupLayout panelGudangLayout = new javax.swing.GroupLayout(panelGudang);
        panelGudang.setLayout(panelGudangLayout);
        panelGudangLayout.setHorizontalGroup(
            panelGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGudangLayout.createSequentialGroup()
                .addGroup(panelGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelGudangLayout.setVerticalGroup(
            panelGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGudangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGudangLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelGudangLayout.createSequentialGroup()
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        tabPenyedia.addTab("Data Barang Gudang", panelGudang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPenyedia, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPenyedia, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaActionPerformed

    private void tfAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAlamatActionPerformed

    private void btnAddPenyediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPenyediaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddPenyediaActionPerformed

    private void tfHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHargaActionPerformed

    private void tfNoHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNoHPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNoHPActionPerformed

    private void listPenyediaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listPenyediaValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listPenyediaValueChanged

    private void tfIdGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdGActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddGudang;
    private javax.swing.JButton btnAddPenyedia;
    private javax.swing.JButton btnBarang;
    private javax.swing.JButton btnBarang2;
    private javax.swing.JComboBox<String> cbIdBarangG;
    private javax.swing.JComboBox<String> cbIdGudangG;
    private javax.swing.JComboBox<String> cbIdPenyedia;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JList<String> listGudang;
    private javax.swing.JList<String> listPenyedia;
    private javax.swing.JPanel panelGudang;
    private javax.swing.JPanel panelPenyedia;
    private javax.swing.JTable tabAllBarang;
    private javax.swing.JTable tabBarangG;
    private javax.swing.JTable tabBarangP;
    private javax.swing.JTabbedPane tabPenyedia;
    private javax.swing.JTextField tfAlamat;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfIdBarang;
    private javax.swing.JTextField tfIdG;
    private javax.swing.JTextField tfLokasiGudang;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfNamaBarang;
    private javax.swing.JTextField tfNoHP;
    private javax.swing.JTextField tfStock;
    private javax.swing.JTextField tfStockG;
    private javax.swing.JTextArea txtDetailPny;
    // End of variables declaration//GEN-END:variables
}
