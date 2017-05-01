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
    
    public void savePenyedia (Penyedia p) {
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
                
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat menambahkan penyedia");
        }        
        
    }
    public void savePetugas (Petugas p) {
        try{
            String query = "insert into petugas (idpetugas, nama, alamat, nohp, email, password)"
                + " values ('"+p.getIdPetugas()+
                "','"+p.getNama()+
                "','"+p.getAlamat()+
                "','"+p.getNoHp()+
                "','"+p.getEmail()+
                "','"+p.getPass()+"');";
            boolean berhasil = manipulate(query);
            if (! berhasil) {
                throw new IllegalArgumentException("Terjadi kesalahan saat save petugas");
            }
        } catch (Exception e){
            throw new IllegalArgumentException("Terjadi kesalahan saat save petugas");
        }
    }
    
    public void saveGudang (Gudang g) {
        try {
            String query = "insert into gudang (idgudang,lokasi,jumBarang) "
                        + "values ('" + g.getId() +"',"
                        + "'"+g.getLokasi() + "',"
                        + "'"+ g.getJumBarang()+ "');";
            boolean berhasil = manipulate(query);
            if (! berhasil) {
                throw new IllegalArgumentException("Terjadi kesalahan saat save barang");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat save barang");
        }
    }
    
    public void saveBarangPenyedia (Barang b, int idPenyedia) {
        try {
            String query = "insert into barang (idbarang,nama,harga,Stock,idpenyedia) "
                + "values ('" + b.getId() + "','"
                + b.getNama() + "','"
                + b.getHarga() + "','"
                + b.getStock() + "','"
                + idPenyedia +"');";
            boolean berhasil = manipulate(query);
            if (! berhasil) {
                throw new IllegalArgumentException("terjadi kesalahan saat save barang ke penyedia");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save barang ke penyedia");
        }
    }
    
    
    
    
}