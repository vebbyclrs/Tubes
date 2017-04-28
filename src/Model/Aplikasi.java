/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import View.HomePage;

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
        db.Connect();
   //     daftarPenyedia = db.loadPenyedia;
    //    daftarBarang = db.loadBarang;
    }
    /*Area untuk HomePage*/
    
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
       
       Barang b = new Barang(, nama, 0, 0);
    }
    
    
    /*Area Untuk LoginForm*/
}
