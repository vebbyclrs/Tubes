
import tubes.Barang;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Endriawan
 */
public class Penyedia {
 private int idPenyedia;
 private Barang[] daftarBarang = new Barang[9];
 private int jumlahBarang = 0;
    

    public int getId() {
        return idPenyedia;
    }

    public void setId(int idPenyedia) {
        this.idPenyedia = idPenyedia;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

  /* public void setJumlahBarang(int jumlahBarang) {
    //    this.jumlahBarang = jumlahBarang;
    }*/
    
    public void addBarang(Barang br) {
        if (jumlahBarang<10) {
            daftarBarang[jumlahBarang] = br;
            jumlahBarang+=1;
        }
    }
    
    public Barang getBarang(int idx){
        return daftarBarang[idx];
    }
 
}
