package Model;

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
    private String email;
    private String pass;

    public Petugas(int idPetugas, String nama) {
        this.idPetugas = idPetugas;
        super.setNama(nama);        
    }

    public Petugas(int idPetugas, String nama, String alamat, String noHp, String email,String password) {
        this.idPetugas = idPetugas;
        this.email = email;
        pass = password;
        super.setAlamat(alamat);
        super.setNama(nama);
        super.setNoHp(noHp);
    }
    

    public void setId(int idPetugas) {
        this.idPetugas = idPetugas;
    }

    public int getIdPetugas() {
        return idPetugas;
    } 

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }
}
