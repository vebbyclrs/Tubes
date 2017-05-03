/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author TESASET
 */
public class Gudang {
    private ArrayList<Barang>  daftarBarang;
    private String id;
    private String lokasi;

    public Gudang(String id, String lokasi) {
        this.id=id;
        this.lokasi=lokasi;
        daftarBarang = new ArrayList<>();
    }

    //overloading
    public Gudang() {
        daftarBarang=new ArrayList<>();
    }
    
    public void addBarang (Barang br){
        daftarBarang.add(br);
    }

    public Barang getBarang(int idx){
        return daftarBarang.get(idx);
    }
    
    public int getJumBarang() {
        return daftarBarang.size();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
    public ArrayList<Barang> getArrBarangG () {
        return this.daftarBarang;
    }
}
