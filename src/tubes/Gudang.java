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
    private int jumBarang;
    private String id;
    private String lokasi;
    
    public void addBarang (Barang br){
        //belum 
    }

    //get barang belum
    
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
