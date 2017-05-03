/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import Model.Gudang;
import Model.Barang;
import Model.Penyedia;
import View.HomePage;
import Model.DatabaseConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Endriawan
 */
public class ControllerHomePage implements ActionListener, KeyListener, ListSelectionListener {

    Aplikasi model;
    HomePage view;

    public ControllerHomePage() {
        this.model = new Aplikasi();
        view = new HomePage();
        view.setVisible(true);
        view.addListener(this);
        view.addListSelection(this);
        view.addKeyListener(this);
        addPenyediaToComboBox(model.getDaftarPenyedia(), view.getCbIdPenyedia());
        showListPenyedia(model.getDaftarPenyedia(), view.getListPenyedia());
        addGudangToComboBox(model.getDaftarGudang(), view.getCbIdGudangG());
        addBarangToComboBox(model.loadBarang(), view.getCbIdBarangG());
        showListGudang(model.getDaftarGudang(), view.getListGudang());

        addBarangToTable(model.loadBarang(), view.getTabAllBarang());

    }

    private void addPenyediaToComboBox(ArrayList<Penyedia> data, JComboBox combo) {
        combo.removeAllItems();
        for (Penyedia pnye : data) {
            combo.addItem(pnye.getId() + "");
        }
    }

    private void addGudangToComboBox(ArrayList<Gudang> data, JComboBox combo) {
        combo.removeAllItems();
        for (Gudang gdg : data) {
            combo.addItem(gdg.getId() + "");
        }
    }

    private void addBarangToComboBox(ArrayList<Barang> data, JComboBox combo) {
        combo.removeAllItems();
        for (Barang brg : data) {
            combo.addItem(brg.getId() + "");
        }
    }

    private void showListPenyedia(ArrayList<Penyedia> arrP, JList list) {
        list.removeAll();
        String[] dataList = new String[arrP.size()];
        for (int i = 0; i < arrP.size(); i++) {
            Penyedia penyedia = arrP.get(i);
            dataList[i] = penyedia.getId() + ":" + penyedia.getNama() + " (" + penyedia.getNoHp() + ")";
            list.setListData(dataList);
        }
    }

    private void showListGudang(ArrayList<Gudang> arrG, JList list) {
        list.removeAll();
        String[] dataList = new String[arrG.size()];
        for (int i = 0; i < arrG.size(); i++) {
            Gudang gudang = arrG.get(i);
            dataList[i] = gudang.getId() + " (" + gudang.getLokasi() + ")";
            list.setListData(dataList);
        }
    }

    private void addBarangToTable(ArrayList<Barang> data, JTable table) {
        DefaultTableModel t = (DefaultTableModel) table.getModel();

        t.setRowCount(0);
        for (Barang b : data) {
            String[] s = {b.getId(), b.getNama(), b.getStock() + "", b.getHarga() + ""}; //+"" ngejadiin string doang :P
            t.addRow(s);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource().equals(view.getListPenyedia())) {
            //id:asdasd
            String value = view.getListPenyedia().getSelectedValue();
            String[] splited = value.split(":");
            ArrayList<Barang> daftarBarang = model.loadBarangByPenyedia(splited[0]);
            addBarangToTable(daftarBarang, view.getTabBarangP());
            showDetailPenyedia(model.getPenyedia(Integer.parseInt(splited[0])), view.getTxtDetailPny());
            
        } else if (e.getSource().equals(view.getListGudang())) {
            String value = view.getListGudang().getSelectedValue();
            String[] splited = value.split(" ");
            
            ArrayList<Barang> daftarBarang = model.loadBarangByGudang(splited[0]);
            addBarangToTable(daftarBarang, view.getTabBarangG());
        }
    }

    private void showDetailPenyedia(Penyedia p, JTextArea txtDetilPenyedia) {
        txtDetilPenyedia.setText("Detail Penyedia:" + "\n"
                + "Id Penyedia: " + p.getId() + "\n"
                + "Nama: " + p.getNama() + "\n"
                + "Alamat: " + p.getAlamat() + "\n"
                + "No hp : " + p.getNoHp() + "\n"
                + "Jenis barang: " + p.getJumlahBarang());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Object source = e.getSource();
        if (source.equals(view.getBtnPenyedia())) {
            Penyedia p = new Penyedia();
            p.setNama(view.getTfNama());
            p.setId(0);
            p.setAlamat(view.getTfAlamat());
            p.setNoHp(view.getTfNoHP());
            if (view.getTfNama().equals("") || view.getTfAlamat().equals("")
                    || view.getTfNoHP().equals("")) {
                JOptionPane.showMessageDialog(view, "field tidak boleh kosong!", "terjadi kesalahan input", 0);
            } else if (model.addPenyedia(p)) {
                view.showMessage("berhasil ditambahkan");
                addPenyediaToComboBox(model.getDaftarPenyedia(), view.getCbIdPenyedia());
                showListPenyedia(model.getDaftarPenyedia(), view.getListPenyedia());
                view.reset();
            }
//            showListPenyedia(model.getDaftarPenyedia(), view.getListPenyedia());
        } else if (source.equals(view.getBtnBarang())) {
            Barang brg = new Barang();
            brg.setNama(view.getTfNamaBarang());
            brg.setId(view.getTfIdBarang());
            brg.setStock(Integer.parseInt(view.getTfStock()));
            brg.setHarga(Double.parseDouble(view.getTfHarga()));
            if (view.getTfNamaBarang().equals("") || view.getTfIdBarang().equals("")
                    || view.getTfStock().equals("0") || view.getTfHarga().equals("0")) {
                JOptionPane.showMessageDialog(view, "field tidak bileh kosong", "terjadi kesalahan inputan", 0);
            } else if (model.addBarangPenyedia(brg, Integer.parseInt(view.getCbIdPenyedia().getSelectedItem().toString()))) {
                view.showMessage("berhasil menambahkan");
                view.reset();
////Pengennya tabelnya langsung ngerefresh////////                
                addBarangToTable(model.loadBarang(), view.getTabAllBarang());
                addBarangToComboBox(model.loadBarang(), view.getCbIdBarangG());
            }

            //tambahin else buat error besok gan, bos udah ngantuk u,u
        } else if (source.equals(view.getBtnAddGudang())) { //Add gudang
            //            Gudang g = new Gudang(view.getTfIdG().toString(), view.getTfLokasiGudang().toString());
            Gudang g = new Gudang(view.getTfIdG(), view.getTfLokasiGudang());
            if (model.addGudang(g)) {
                view.showMessage("berhasil menambahkan gudang");
                addGudangToComboBox(model.getDaftarGudang(), view.getCbIdGudangG());
                showListGudang(model.getDaftarGudang(), view.getListGudang());
                view.reset();
                //REFRESH LIST GUDANG
            } else {
                view.showMessage("gagal menambahkan", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else if (source.equals(view.getBtnBarang2())) {
            String idGudang = view.getCbIdGudangG().getSelectedItem().toString();
            String idBarang = view.getCbIdBarangG().getSelectedItem().toString();
//            view.showMessage(idGudang,idBarang, JOptionPane.INFORMATION_MESSAGE);
            if (model.addBarangToGudang(idBarang, idGudang)) {
                view.showMessage("berhasil menambahkan barang ke gudang");
                view.reset();
            } else {
                view.showMessage("gagal menambahkan", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
//            model.save
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource().equals(view.getTabBarangP()))
        {
            if (e.getKeyCode() == KeyEvent.VK_DELETE)//delete barang di penyedia
            {
                String idBarang = view.getTabBarangP().getModel().getValueAt(view.getTabBarangP().getSelectedRow(), 0).toString();
                boolean berhasil=model.deleteBarangP(idBarang);
                if (berhasil) {
                    view.showMessage("deleted !!!");
                    addBarangToTable(model.loadBarang(), view.getTabAllBarang());
                    addBarangToComboBox(model.loadBarang(), view.getCbIdBarangG());
                } else {
                    view.showMessage("Gagal menghapus barang", "Errorr delete barang", JOptionPane.ERROR_MESSAGE); 
                }
            }
        }
        else if (e.getSource().equals(view.getTabBarangG()))
        {
            if (e.getKeyCode() == KeyEvent.VK_DELETE)//delete barang di penyedia
            {
                String idBarang = view.getTabBarangG().getModel().getValueAt(view.getTabBarangG().getSelectedRow(), 0).toString();
                boolean berhasil = model.deleteBarangG(idBarang);
                if (berhasil) {
                    view.showMessage("deleted !!!");
                    addBarangToTable(model.loadBarang(), view.getTabAllBarang());
                    addBarangToComboBox(model.loadBarang(), view.getCbIdBarangG());
                } else {
                    view.showMessage("Gagal menghapus barang", "Errorr delete barang", JOptionPane.ERROR_MESSAGE); 
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
