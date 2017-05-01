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
        db.connect();
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
        ArrayList<Petugas> arrPetugas = new ArrayList<>();
        ResultSet rs = db.getData("select idpetugas, nama, alamat, noHp, email, password");
        try {
           while (rs.next()) {
            Petugas p = new Petugas(
                    rs.getInt("idpetugas"),
                    rs.getString("nama"),
                    rs.getString("alamat"),
                    rs.getString("nohp"),
                    rs.getString("email"),
                    rs.getString("password"));
            arrPetugas.add(p);
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnect();
        return arrPetugas;
    }

//    public Penyedia getPenyedia(int idPenyedia) /*BELOM*/{
//        /*
//        alur: fungsi akan mengeluarkan semua data penyedia dengan id=idpenyedia
//        data penyedia tsb disimpan dalam objek p
//        kemudian akan dicari dalam tabel barang: barang mana saja yang punya barang.idpenyedia=p.idpenyedia
//          yang kemudian akan di simpan dalam resultsetBarang
//        isi dari result set barang tadi akan di simpan ke dalam array penyedia.barang[] untuk kemudian ditampilkan
//        */
//        db.connect();
//        Penyedia p = new Penyedia();
//        ResultSet rs = db.getData("Select * from Penyedia where nim = '"+idPenyedia+"'");
//        try {
//            if (rs.first()) {
//                p.setAlamat(rs.getString("alamat"));
//                p.setId(rs.getInt("idpenyedia"));
//                p.setNama(rs.getString("nama"));
//                p.setNoHp(rs.getString("nohp"));
//                
//                ResultSet rsBarang = db.getData("select idbarang, idpenyedia, id, nama, harga, stock "
//                        + "where idpenyedia='"+idPenyedia+"'");
//                
//                while (rsBarang.next()) {
//                    if (p.getJumlahBarang()<=20) { 
//                        Barang b = new Barang(rs.getString("idbarang"), 
//                                rs.getString("nama"),
//                                rs.getDouble("harga"), 
//                                rs.getInt("stock"));
//                        p.addBarang(b);                            
//                    }
//                }
//            }
//            
//        } catch (Exception e) {
//        }
//        
//        
//        db.disconnect();
//        return p;
//    }
//    
    public Barang getBarang (String  idBarang) {
        for (Barang brg : daftarBarang) {
            if (brg.getId().equals(idBarang)) { 
                return brg;
            }
        }
        return null;
    }
    
    public Petugas getPetugas (String idPetugas) {
        //dipake buat login
        for (Petugas p: daftarPetugas) {
            if (idPetugas.equals(p.getIdPetugas())) {
                return p;
            }
        }
        return null;
    }
    public Petugas getPetugasByEmail (String email) {
        for (Petugas p : daftarPetugas) {
            if (email.equals(p.getEmail())) {
                return p;
            }
        }
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
