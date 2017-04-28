/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import View.HomePage;
import java.sql.ResultSet;

/**
 *
 * @author Endriawan
 */
public class Aplikasi {
    
    ArrayList<Penyedia> daftarPenyedia;
    ArrayList<Barang> daftarBarang;
    DatabaseConnection db;
    
    public Aplikasi() {
        db = new DatabaseConnection();
   //     daftarPenyedia = db.loadPenyedia;
    //    daftarBarang = db.loadBarang;
    }
    /*Area untuk HomePage*/
    public boolean savePenyedia (Penyedia p) {
        db.connect();
        boolean berhasil = db.manipulate("insert into penyedia (idpenyedia,nama,alamat,nohp,jumbarang) "
                + "values ('"+p.getId()+"','"
                +p.getNama()+"','"
                +p.getAlamat()+"','"
                +p.getNoHp()+"','"
                +p.getJumlahBarang()+"');");
        db.disconnect();
        return berhasil;
    }
    public ArrayList<Penyedia> getAllPenyedia () {
        db.connect();
        ResultSet rs = db.getData("select idpenyedia,nama,alamat,nohp,jumbarang from penyedia");
        try {
            while (rs.next()) {
                Penyedia p = new Penyedia(rs.getInt("idpenyedia"), rs.getString("nama"), rs.getString("alamat"),rs.getString("nohp"));
                
            }
        } catch (Exception e) {
        }
    }
    
    public void addPenyedia (int idPenyedia, String namaPenyedia, String alamat) {
        //belum dikasih error corectionnya
        
        Penyedia p = new Penyedia(idPenyedia, namaPenyedia, alamat);
        daftarPenyedia.add(p);
        //db.savePenyedia;
    }
    public  Penyedia getPenyedia(int idPenyedia){
        for (Penyedia p : daftarPenyedia) {
            if (p.getId()== idPenyedia){
                return p;
            }
        }
        return null;
        
    }
    public void addBarangPenyedia(){
       
       
    }
    
    
    /*Area Untuk LoginForm*/
}
