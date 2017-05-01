package Model;

import java.util.ArrayList;

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
 private ArrayList<Barang> daftarBarang;

    public Penyedia(int idPenyedia, String namaPenyedia, String alamat, String noHp) {
        this.idPenyedia = idPenyedia;
        super.setNama(namaPenyedia);
        super.setAlamat(alamat);
        super.setNoHp(noHp);
        daftarBarang = new ArrayList<>();
    }

    public Penyedia() {
        daftarBarang = new ArrayList<>();
    }
    
    public int getId() {
        return idPenyedia;
    }

    public void setId(int idPenyedia) {
        this.idPenyedia = idPenyedia;
    }

    public int getJumlahBarang() {
        return daftarBarang.size();
    }
    
    public void addBarang(Barang br) {
        daftarBarang.add(br);
    }
    
    public Barang getBarang(int idx){
        return daftarBarang.get(idx);
    }
 
}
