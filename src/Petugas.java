/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
public class Petugas extends Manusia {
    private int idPetugas;

    public Petugas(int idPetugas, String nama) {
        this.idPetugas = idPetugas;
        super.setNama(nama);        
    }

    public void setId(int idPetugas) {
        this.idPetugas = idPetugas;
    }

    public int getIdPetugas() {
        return idPetugas;
    }
    
    
}
