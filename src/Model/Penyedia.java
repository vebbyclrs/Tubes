package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Endriawan
 */
public class Penyedia extends Manusia {
 private int idPenyedia;
 private Barang[] daftarBarang;
 private int jumlahBarang = 0;

    public Penyedia(int idPenyedia, String namaPenyedia, String alamat, String noHp) {
        this.idPenyedia = idPenyedia;
        super.setNama(namaPenyedia);
        super.setAlamat(alamat);
        super.setNoHp(noHp);
        daftarBarang = new Barang[20];
    }
    
    
    public int getId() {
        return idPenyedia;
    }

    public void setId(int idPenyedia) {
        this.idPenyedia = idPenyedia;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }
    
    public void addBarang(Barang br) {
        if (jumlahBarang<20) {
            daftarBarang[jumlahBarang] = br;
            jumlahBarang+=1;
        } else {
            System.out.println("!!Penambahan gagal. Maksimum barang tercapai");
        }
       
    }
    
    public Barang getBarang(int idx){
        return daftarBarang[idx];
    }
 
}
