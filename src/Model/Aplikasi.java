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
    ArrayList<Petugas> daftarPetugas;
    ArrayList <Gudang> daftarGudang;
    DatabaseConnection db;

    public ArrayList<Penyedia> getDaftarPenyedia() {
        return daftarPenyedia;
    }
    
    public ArrayList<Gudang> getDaftarGudang() {
        return daftarGudang;
    }
    
    
    public  Penyedia getPenyedia (int idPenyedia) {
         for (Penyedia p : daftarPenyedia) {
             if (p.getId() == idPenyedia) {
                 return p;
             }
         }
         return null;
     }
    
    public Aplikasi() {
        db = new DatabaseConnection();
//        db.connect();
        loadPetugas();
        loadPenyedia();
        loadBarang();
        loadGudang();
        
    }

    public ArrayList<Barang> getDaftarBarang() {
        return loadBarang();
    }

    public ArrayList<Petugas> getDaftarPetugas() {
        return daftarPetugas;
    }
    
    

    /*Area untuk HomePage*/
    public boolean addPenyedia(Penyedia p) /*DONE*/ {
        //tidak ada kemungkinan bahwa idPenyedia sudah ada karena
        //saat menyimpan data, id increment
        boolean berhasil;
        db.connect();
        berhasil = db.savePenyedia(p);
        daftarPenyedia.add(p);
        db.disconnect();
        return berhasil;
    }
    
    public boolean addBarangPenyedia(Barang b, int idPenyedia) /*Done*/ {
        db.connect();
        boolean berhasil = db.saveBarangPenyedia(b, idPenyedia); 
        for (Penyedia penyedia : daftarPenyedia) {
            if (penyedia.getId() == idPenyedia) {
                penyedia.addBarang(b);
            }
        }
        db.disconnect();
        return berhasil;
    }
   
    
    public boolean addGudang(Gudang b)/*done*/ {
        boolean berhasil = false;
        db.connect();
        berhasil = db.saveGudang(b);
        daftarGudang.add(b);
        db.disconnect();
        return berhasil;
    }

    public boolean addPetugas(Petugas b) /*done*/ {
        db.connect();
        boolean berhasil = db.savePetugas(b);
        db.disconnect();
        return berhasil;
    }
    public boolean addBarangToGudang(String idBarang, String idGudang) {
        db.connect();
        boolean berhasil = db.saveBarangGudang(idBarang, idGudang);
        for (Gudang gudang : daftarGudang) {
            if (gudang.getId().equals(idGudang)) {
                gudang.addBarang(getBarang(idBarang)); //masukin barang ke array barang di gudang
            }
        }
        db.disconnect();
        return berhasil;
    }

    
    public ArrayList<Penyedia> loadPenyedia() /*DONE, = loadPenyedia*/ {
        daftarPenyedia = new ArrayList<>();
        db.connect();
        String query = "select idpenyedia,nama,alamat,nohp,jumbarang from penyedia";
        ResultSet rs = db.getData(query);
        try {
            while (rs.next()) {
                Penyedia p = new Penyedia(rs.getInt("idpenyedia"), rs.getString("nama"), rs.getString("alamat"), rs.getString("nohp"));
                daftarPenyedia.add(p);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat load penyedia");
        }
        db.disconnect();
        return daftarPenyedia;
    }

    public ArrayList<Gudang> loadGudang() /*Done*/ {
        db.connect();
        daftarGudang = new ArrayList<>();
        ResultSet rs = db.getData("select * from gudang");
        try {
            while (rs.next()) {
                Gudang g = new Gudang(rs.getString("idgudang"), rs.getString("lokasi"));
                daftarGudang.add(g);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat load gudang");
        }
        db.disconnect();
        return daftarGudang; 
    }
    
    public ArrayList<Barang> loadBarangByPenyedia(String idPenyedia) /*Done*/ {
        db.connect();
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        ResultSet rs = db.getData("select idBarang, nama, harga, stock from barang where idpenyedia='"+idPenyedia+"'");
        try {
            while (rs.next()) {
                Barang b = new Barang(rs.getString("idBarang"), rs.getString("nama"),rs.getDouble("harga"), rs.getInt("stock"));
                daftarBarang.add(b);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat load barang");
        }
        db.disconnect();
        return daftarBarang; 
    }
    
    public ArrayList<Barang> loadBarangByGudang(String idGudang) /*Done*/ {
        db.connect();
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        ResultSet rs = db.getData("select idBarang, nama, harga, stock from barang where idgudang='"+idGudang+"'");
        try {
            while (rs.next()) {
                Barang b = new Barang(rs.getString("idBarang"), rs.getString("nama"),rs.getDouble("harga"), rs.getInt("stock"));
                daftarBarang.add(b);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat load barang");
        }
        db.disconnect();
        return daftarBarang; 
    }
    
    //download ni https://nchc.dl.sourceforge.net/project/ireport/iReport/iReport-5.6.0/iReport-5.6.0-windows-installer.exe
    //sama jre 7 http://download.oracle.com/otn-pub/java/jdk/7u79-b15/jre-7u79-windows-x64.exe?AuthParam=1493749535_d2408faa8778521a6842a892b2096cd8
    //karena ireport ga bsa jalan d JRE 8, harus 7
    
    
    
    
    public ArrayList<Barang> loadBarang() /*Done*/ {
        db.connect();
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        ResultSet rs = db.getData("select idBarang, nama, harga, stock from barang ");
        try {
            while (rs.next()) {
                Barang b = new Barang(rs.getString("idBarang"), rs.getString("nama"),rs.getDouble("harga"), rs.getInt("stock"));
                daftarBarang.add(b);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat load barang");
        }
        db.disconnect();
        return daftarBarang; 
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
        ArrayList<Barang> daftarBarang = new ArrayList<>();
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
