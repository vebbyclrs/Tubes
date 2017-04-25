/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Gudang;
import Model.Barang;
import Model.Penyedia;
import View.HomePage;
import Model.DatabaseConnection;
import java.util.ArrayList;
/**
 *
 * @author Endriawan
 */
public class ControllerHomePage {
    ArrayList<Penyedia> daftarPenyedia;
    ArrayList<Barang> daftarBarang;
    ArrayList<Gudang> daftarGudang;
    DatabaseConnection db;
    
    public void addPenyedia(int idPenyedia ,String namaPenyedia ,String Alamat) {
        //disini nanti di taruh if karena apa lah gk ngerti,
        //isi voidnya klo masih kurang tambahin aja ya
        Penyedia n = new Penyedia(idPenyedia, namaPenyedia, Alamat);
        daftarPenyedia.add(n);
        db.savePenyedia(n);
    }
}
