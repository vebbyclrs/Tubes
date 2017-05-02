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
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author Endriawan
 */
public class ControllerHomePage implements ActionListener, KeyListener, ListSelectionListener {
    Aplikasi model;
    HomePage view;
    
    public ControllerHomePage(){
        this.model = new Aplikasi();
        view = new HomePage();
        view.setVisible(true);
        view.addListener(this);
        view.addListSelection(this);
        
        addPenyediaToComboBox(model.getDaftarPenyedia(), view.getCbIdPenyedia());
        showListPenyedia(model.getDaftarPenyedia(), view.getListPenyedia());
        
    }
    
    private void addPenyediaToComboBox(ArrayList<Penyedia> data, JComboBox combo)
    {
        combo.removeAllItems();
        for (Penyedia pnye : data)
        {
            combo.addItem(pnye.getId()+"");
        }
    }
    
    private void showListPenyedia (ArrayList <Penyedia> arrP , JList list) {
        list.removeAll();
        String[] dataList = new String[arrP.size()];
        for (int i=0;i<arrP.size();i++) {
            Penyedia penyedia = arrP.get(i);
             dataList[i] = penyedia.getId() +":"+ penyedia.getNama();
            list.setListData(dataList);
        }
    }
    private void showDetailPenyedia (Penyedia p , JTextArea txtDetilPenyedia) {
        txtDetilPenyedia.setText("Detail Penyedia:" + "\n" +
                "Id Penyedia: " + p.getId() + "\n" +
                "Nama: " + p.getNama() + "\n" +
                "Alamat: " +  p.getAlamat() +"\n" +
                "No hp : " + p.getNoHp() + "\n" +
                "Jenis barang: "+ p.getJumlahBarang());
    }
    
    private void addBarangToTable(ArrayList<Barang> data, JTable table)
    {
        DefaultTableModel t = (DefaultTableModel) table.getModel();
        t.setRowCount(0);
        for (Barang b : data) {
            String [] s = {b.getId(), b.getNama() , b.getStock()+"" , b.getHarga()+""}; //+"" ngejadiin string doang :P
            t.addRow(s);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource().equals(view.getListPenyedia()))
        {
            //id:asdasd
            String value = view.getListPenyedia().getSelectedValue();
            String[] splited = value.split(":");
            model.loadBarang(splited[0]);
            addBarangToTable(model.getDaftarBarang(), view.getTabBarangP());
            showDetailPenyedia(model.getPenyedia(Integer.parseInt(splited[0])), view.getTxtDetailPny());
        }
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Object source = e.getSource();
        if (source.equals(view.getBtnPenyedia())){
            Penyedia p = new Penyedia();
            p.setNama(view.getTfNama());
            p.setId(0);
            p.setAlamat(view.getTfAlamat());
            p.setNoHp(view.getTfNoHP());

            if (model.addPenyedia(p)) {
                view.showMessage("berhasil menambahkan penyedia");
                addPenyediaToComboBox(model.getDaftarPenyedia(), view.getCbIdPenyedia());
            }
        }else if(source.equals(view.getBtnBarang())){
            Barang brg = new Barang();
            brg.setNama(view.getTfNamaBarang());
            brg.setId(view.getTfIdBarang());
            brg.setStock(Integer.parseInt(view.getTfStock()));
            brg.setHarga(Double.parseDouble(view.getTfHarga()));
            if(model.addBarangPenyedia(brg,Integer.parseInt(view.getCbIdPenyedia().getSelectedItem().toString()))) {
                view.showMessage("berhasil menambahkan barang penyedia");
            } else {
                view.showMessage("gagal menambahkan", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            //tambahin else buat error besok gan, bos udah ngantuk u,u
        }else if (source.equals(view.getBtnAddGudang())) {
//            Gudang g = new Gudang(view.getTfIdG().toString(), view.getTfLokasiGudang().toString());
            Gudang gudang  = new Gudang();
            gudang.setId(view.getTfIdG().toString() );
            gudang.setLokasi(view.getTfLokasiGudang().toString());
            if (model.addGudang(gudang)) {
                view.showMessage("berhasil menambahkan gudang");
            } else {
                view.showMessage("gagal menambahkan", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        if (e.getSource().equals(view.getTabBarangP())) {
//            if (e.getKeyCode() == e.VK_DELETE) {
//                view.showMessage("Harusnya ngedelete");
//            }
//        }
//        else if (e.getSource().equals(view.getListPenyedia())) {
            if (e.getKeyCode() == e.VK_DELETE) {
                view.showMessage("Harusnya ngedelete(2)");
            }
//        }
                
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}