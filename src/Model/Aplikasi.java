/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import View.HomePage;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author Endriawan
 */
public class Aplikasi {

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
    DatabaseConnection db;

    public Aplikasi() {
        db = new DatabaseConnection();
    }

    /*Area untuk HomePage*/
    public boolean addPenyedia(Penyedia p) {
        db.connect();
        boolean berhasil = db.manipulate("insert into penyedia (idpenyedia,nama,alamat,nohp,jumbarang) "
                + "values ('" + p.getId() + "','"
                + p.getNama() + "','"
                + p.getAlamat() + "','"
                + p.getNoHp() + "','"
                + p.getJumlahBarang() + "');");
        db.disconnect();
        return berhasil;
    }

    public ArrayList<Penyedia> loadPenyedia() /*done, = loadPenyedia*/ {
        db.connect();
        ResultSet rs = db.getData("select idpenyedia,nama,alamat,nohp,jumbarang from penyedia");
        ArrayList<Penyedia> arrPenyedia = new ArrayList<>();
        try {
            while (rs.next()) {
                Penyedia p = new Penyedia(rs.getInt("idpenyedia"), rs.getString("nama"), rs.getString("alamat"), rs.getString("nohp"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnect();
        return arrPenyedia;
    }

    public boolean addBarang(Barang b) /*Done*/ {
        db.connect();
        boolean berhasil = db.manipulate("insert into barang (idbarang,nama,harga,Stock) "
                + "values ('" + b.getId() + "','"
                + b.getNama() + "','"
                + b.getHarga() + "','"
                + b.getStock() + "');");
        
        db.disconnect();
        return berhasil;
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
            e.printStackTrace();
        }
        db.disconnect();
        return arrBarang; 
    }

    public boolean addGudang(Gudang b)/*done*/ {
        db.connect();
        boolean berhasil = db.manipulate(
                "insert into gudang (id,lokasi,jumBarang) "
                        + "values ('" + b.getId() +"',"
                        + "'"+b.getLokasi() + "',"
                        + "'"+ b.getJumBarang()+ "');");
        db.disconnect();
        return berhasil;

        //DOING BY VEBBY
    }

    public ArrayList<Gudang> loadGudang() /*done*/ {
        db.connect();
        ArrayList<Gudang> arrGudang = new ArrayList<>();
        ResultSet rs = db.getData("select id,lokasi,jumbarang from gudang");
        try {
            while (rs.next()) {
                Gudang g = new Gudang(rs.getString("id"), "lokasi");
                arrGudang.add(g);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnect();
        return arrGudang;
    }

    public boolean addPetugas(Petugas b) /*done*/ {
        db.connect();
        boolean berhasil = db.manipulate("insert into petugas (idpetugas, nama, alamat, nohp, email, password)"
                + " values ('"+b.getIdPetugas()+
                "','"+b.getNama()+
                "','"+b.getAlamat()+
                "','"+b.getNoHp()+
                "','"+b.getEmail()+
                "','"+b.getPass()+"');");
        db.disconnect();
        return berhasil;

        //DOING BY VEBBY
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

    public Penyedia getPenyedia(int idPenyedia) {
        /*
        alur: fungsi akan mengeluarkan semua data penyedia dengan id=idpenyedia
        data penyedia tsb disimpan dalam objek p
        kemudian akan dicari dalam tabel barang: barang mana saja yang punya barang.idpenyedia=p.idpenyedia
          yang kemudian akan di simpan dalam resultsetBarang
        isi dari result set barang tadi akan di simpan ke dalam array penyedia.barang[] untuk kemudian ditampilkan
        */
        db.connect();
        Penyedia p = new Penyedia();
        ResultSet rs = db.getData("Select * from Penyedia where nim = '"+idPenyedia+"'");
        try {
            if (rs.first()) {
                p.setAlamat(rs.getString("alamat"));
                p.setId(rs.getInt("idpenyedia"));
                p.setNama(rs.getString("nama"));
                p.setNoHp(rs.getString("nohp"));
                
                ResultSet rsBarang = db.getData("select idbarang, idpenyedia, id, nama, harga, stock "
                        + "where idpenyedia='"+idPenyedia+"'");
                
                while (rsBarang.next()) {
                    if (p.getJumlahBarang()<=20) {
                        Barang b = new Barang(rs.getString("idbarang"),
                                rs.getString("nama"),
                                rs.getDouble("harga"), 
                                rs.getInt("stock"));
                        p.addBarang(b);                            
                    }
                }
            }
            
        } catch (Exception e) {
        }
        
        
        db.disconnect();
        return p;
    }
    /**
     * bikin method returnnya penyedia parameter :id penyedia
     *
     *
     *
     */

    /*Area Untuk LoginForm*/
}
