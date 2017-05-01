/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Endriawan
 */
public class Aplikasi {
    //TEST BELOM COMMIT

    /**
     * ====KETERANGAN NAMA METHOD DALAM CLASS INI====
     * load berfungsi untuk menerima result set yang di lemparkan DB, direturn berupa array data
     * add berfungsi untuk menambahkan sebuah objek ke dalam DB. return berupa T/F dimana:
     *      T merepresentasikan objek telah sukses di simpan di dalam DB
     *      F merepresentasikan bahwa terjadi kegagalan saat menyimpan objek ke dalam DB
     * get berfungsi untuk mencari satu baris data berdasarkan parameter method di
     * dalam DB
     */

    ArrayList<Penyedia> daftarPenyedia;
    ArrayList<Barang> daftarBarang;
    ArrayList<Petugas> daftarPetugas;
    DatabaseConnection db;

    public Aplikasi() {
        db = new DatabaseConnection();
//        db.connect();
        loadPetugas();
        
    }

    /*Area untuk HomePage*/
    public void addPenyedia(Penyedia p) /*DONE*/ {
        //tidak ada kemungkinan bahwa idPenyedia sudah ada karena
        //saat menyimpan data, id increment
        db.connect();
        db.savePenyedia(p);
        daftarPenyedia.add(p);
        db.disconnect();
    }
    
    public void addBarangPenyedia(Barang b, int idPenyedia) /*Done*/ {
        db.connect();
        db.saveBarangPenyedia(b, idPenyedia);        
        db.disconnect();
    }
   
    public void addGudang(Gudang b)/*done*/ {
        db.connect();
        db.saveGudang(b);
        db.disconnect();
    }

    public void addPetugas(Petugas b) /*done*/ {
        db.connect();
        db.savePetugas(b);
        db.disconnect();
    }

    
    public ArrayList<Penyedia> loadPenyedia() /*DONE, = loadPenyedia*/ {
        ArrayList<Penyedia> arrPenyedia = new ArrayList<>();
        db.connect();
        String query = "select idpenyedia,nama,alamat,nohp,jumbarang from penyedia";
        ResultSet rs = db.getData(query);
        try {
            while (rs.next()) {
                Penyedia p = new Penyedia(rs.getInt("idpenyedia"), rs.getString("nama"), rs.getString("alamat"), rs.getString("nohp"));
                arrPenyedia.add(p);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat load penyedia");
        }
        db.disconnect();
        return arrPenyedia;
    }

    public ArrayList<Barang> loadBarang() /*Done*/ {
        db.connect();
        ArrayList<Barang> arrBarang = new ArrayList<>();
        ResultSet rs = db.getData("select idBarang, nama, harga, stock from barang");
        try {
            while (rs.next()) {
                Barang b = new Barang(rs.getString("idBarang"), rs.getString("nama"),rs.getDouble("harga"), rs.getInt("stock"));
                arrBarang.add(b);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat load barang");
        }
        db.disconnect();
        return arrBarang; 
    }

    public ArrayList<Gudang> loadGudang() /*done*/ {
        db.connect();
        ArrayList<Gudang> arrGudang = new ArrayList<>();
        ResultSet rs = db.getData("select idgudang,lokasi,jumbarang from gudang");
        try {
            while (rs.next()) {
                Gudang g = new Gudang(rs.getString("idgudang"), "lokasi");
                arrGudang.add(g);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnect();
        return arrGudang;
    }

    public ArrayList<Petugas> loadPetugas() /*done*/{
        db.connect();
        daftarPetugas = new ArrayList<>();
        ResultSet rs = db.getData("select idpetugas, nama, alamat, noHp, email, password from Petugas");
        try {
           while (rs.next()) {
            Petugas p = new Petugas(
                    rs.getInt("idpetugas"),
                    rs.getString("nama"),
                    rs.getString("alamat"),
                    rs.getString("nohp"),
                    rs.getString("email"),
                    rs.getString("password"));
            daftarPetugas.add(p);
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnect();
        return daftarPetugas;
    }

    public Barang getBarang (String  idBarang) {
        db.connect();
        for (Barang brg : daftarBarang) {
            if (brg.getId().equals(idBarang)) { 
                return brg;
            }
        }
        db.disconnect();
        return null;
        
    }
    
    public Petugas getPetugas (String idPetugas) {
        //dipake buat login
        db.connect();
        for (Petugas p: daftarPetugas) {
            if (idPetugas.equals(p.getIdPetugas())) {
                return p;
            }
        }
        db.disconnect();
        return null;
    }
    
    public Petugas getPetugasByEmail (String email) {
        db.connect();
        for (Petugas p : daftarPetugas) {
            if (email.equals(p.getEmail())) {
                return p;
            }
        }
        db.disconnect();
        return null;
        
    }
}
    /**
     * bikin method returnnya penyedia parameter :id penyedia
     *
     *
     *
     */

    /*Area Untuk LoginForm*/
