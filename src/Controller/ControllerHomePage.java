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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Endriawan
 */
public class ControllerHomePage implements ActionListener, KeyListener, ListSelectionListener{
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
             dataList[i] = penyedia.getId() +":"+ penyedia.getNama()+" ("+penyedia.getNoHp()+")";
            list.setListData(dataList);
        }
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
            if (view.getTfNama().equals("")||view.getTfAlamat().equals("")
                    ||view.getTfNoHP().equals("")){
                JOptionPane.showMessageDialog(view,"field tidak boleh kosong!","terjadi kesalahan input", 0);
            }
            else if (model.addPenyedia(p)) {
                view.showMessage("berhasil ditambahkan");
                addPenyediaToComboBox(model.getDaftarPenyedia(), view.getCbIdPenyedia());
            }
        }else if(source.equals(view.getBtnBarang())){
            Barang brg = new Barang();
            brg.setNama(view.getTfNamaBarang());
            brg.setId(view.getTfIdBarang());
            brg.setStock(Integer.parseInt(view.getTfStock()));
            brg.setHarga(Double.parseDouble(view.getTfHarga()));
            if(view.getTfNamaBarang().equals("")||view.getTfIdBarang().equals("")
                    ||view.getTfStock().equals("0")||view.getTfHarga().equals("0")){
                JOptionPane.showMessageDialog(view,"field tidak bileh kosong", "terjadi kesalahan inputan", 0);
            }
          else if(model.addBarangPenyedia(brg,Integer.parseInt(view.getCbIdPenyedia().getSelectedItem().toString()))) {
                view.showMessage("berhasil menambahkan");
            }
            //tambahin else buat error besok gan, bos udah ngantuk u,u
           
            


        }
        //eji masih bingung error terus sok di bantu
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
