/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

/**
 *
 * @author TESASET
 */
public class Gudang {
    private Barang[]  daftarBarang;
    private int jumBarang = 0;
    private String id;
    private String lokasi;

    public Gudang(String id, String lokasi) {
        this.id=id;
        this.lokasi=lokasi;
        daftarBarang = new Barang [20];
    }

    //overloading
    public Gudang() {
        daftarBarang=new Barang[20];
    }
    
    public void addBarang (Barang br){
        if(jumBarang<20){
            daftarBarang[jumBarang] = br;
            jumBarang +=1;
        }else {
            System.out.println("Tidak bisa menambahkan barang ke gudang");
        }
    }

    public Barang getBarang(int idx){
        return daftarBarang[idx];
    }
    
    public int getJumBarang() {
        return jumBarang;
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
}
