/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vebbyclrs
 * 
 */
public class DatabaseConnection
{

    private Connection conn;
    private Statement sta;

    public void connect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/db_tubes", "root", "");
            sta = conn.createStatement();
        } catch (Exception ex)
        {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void disconnect()
    {
        try
        {
            conn.close();
            sta.close();
        } catch (SQLException ex)
        {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean manipulate(String query)
    {
        boolean berhasil = false;
        try
        {
            int rows = sta.executeUpdate(query);
            if (rows > 0)
            {
                berhasil = true;
            }

        } catch (Exception ex)
        {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return berhasil;

    }

    public ResultSet getData(String query)
    {
        ResultSet rs = null;
        try
        {
            rs = sta.executeQuery(query);
        } catch (Exception ex)
        {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    public boolean savePenyedia (Penyedia p) {
        boolean berhasil = false;
        try {
            String query = "insert into penyedia (idpenyedia,nama,alamat,nohp,jumbarang) "
                    + "values ('" + p.getId() + "','"
                    + p.getNama() + "','"
                    + p.getAlamat() + "','"
                    + p.getNoHp() + "','"
                    + p.getJumlahBarang() + "');";
            sta.execute(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = sta.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                p.setId(generatedId);
            berhasil = true;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat menambahkan penyedia");
        }   
        return berhasil;    
        
    }
    public boolean savePetugas (Petugas p) {
        boolean berhasil = false;
        try{
            String query = "insert into petugas (idpetugas, nama, alamat, nohp, email, password)"
                + " values ('"+p.getIdPetugas()+
                "','"+p.getNama()+
                "','"+p.getAlamat()+
                "','"+p.getNoHp()+
                "','"+p.getEmail()+
                "','"+p.getPass()+"');";
            berhasil = manipulate(query);
            if (! berhasil) {
                throw new IllegalArgumentException("Terjadi kesalahan saat save petugas");
            }
        } catch (Exception e){
            throw new IllegalArgumentException("Terjadi kesalahan saat save petugas");
        }
        
        return berhasil;
    }
    
    public boolean saveGudang (Gudang g) {
        boolean berhasil = false;
        try {
            String query = "insert into gudang (idgudang,lokasi,jumBarang) "
                        + "values ('" + g.getId() +"',"
                        + "'"+g.getLokasi() + "',"
                        + "'"+ g.getJumBarang()+ "');";
            berhasil = manipulate(query);
            if (! berhasil) {
                throw new IllegalArgumentException("Terjadi kesalahan saat save barang");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat save barang");
        }
        return berhasil;
    }
    
    public boolean saveBarangPenyedia (Barang b, int idPenyedia) {
        boolean berhasil = false;
        try {
            String query = "insert into barang (idbarang,nama,harga,Stock,idpenyedia) "
                + "values ('" + b.getId() + "','"
                + b.getNama() + "','"
                + b.getHarga() + "','"
                + b.getStock() + "','"
                + idPenyedia +"');";
            berhasil = manipulate(query);
            
            if (! berhasil) {
                throw new IllegalArgumentException("terjadi kesalahan saat save barang ke penyedia");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save barang ke penyedia");
        }
        return berhasil;
    }
    public boolean saveBarangGudang  (String idbarang, String idGudang) {
        boolean berhasil = false;
        Barang b;
        
        try {
            String query = "update barang set idgudang='"+idGudang+"' where idbarang='"+idbarang+"'";
            berhasil = manipulate(query);
            
            if (! berhasil) {
                throw new IllegalArgumentException("terjadi kesalahan saat menambahkan barang ke gudang");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return berhasil;
    }
    
//    public boolean deletePenyedia (Barang b, int idPenyedia) { //Kalo penyedia di hapus, barang juga di hapus
//        boolean berhasil = false;
//        try {
//            String queryOnBarang = "delete * from barang where idPenyedia = '"+idPenyedia+"'; ";
//            berhasil = manipulate(queryOnBarang);
//            
//            if (! berhasil) {
//                throw new IllegalArgumentException("terjadi kesalahan saat save barang ke penyedia");
//            }
//        } catch (Exception e) {
//            throw new IllegalArgumentException("terjadi kesalahan saat save barang ke penyedia");
//        }
//        return berhasil;
//    }
//    
    
    
}