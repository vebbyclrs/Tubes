/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.LoginForm;
import View.HomePage;
import View.SignUpPegawai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.View;

/**
 *
 * @author TESASET
 */
public class ControllerSignUp implements ActionListener {

    private Aplikasi apps;
    private SignUpPegawai daftarFrame;
    private ControllerLoginForm loginCont;

    public ControllerSignUp() {
        apps = new Aplikasi();
        daftarFrame = new SignUpPegawai();
        daftarFrame.setVisible(true);
        daftarFrame.setActionListener(this);
        daftarFrame.setLocationRelativeTo(null);

    }

    public void btnBackActionPerformed(ActionEvent ae) {
        daftarFrame.setVisible(false);
        loginCont = new ControllerLoginForm();
    }
    
    public void btnDaftarActionPerformed(ActionEvent ae) {
        
        int idPetugas = 0;
        try {
            idPetugas = Integer.parseInt(daftarFrame.getTfId());
            
            String nama = daftarFrame.getTfNama();
            String alamat = daftarFrame.getTfAlamat();
            String noHp = daftarFrame.getTfNoHp();
            String email = daftarFrame.getTfEmail();
            String password = daftarFrame.getPassword();
            
            if (email.contains("@"))
            {

                Petugas p = new Petugas(idPetugas, nama, alamat, noHp, email, password);
                if (apps.addPetugas(p)) {
                    daftarFrame.showMessage("Berhasil di simpan");
                } else {
                    daftarFrame.showMessage("GAGAL", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                daftarFrame.showMessage("Email tidak valid", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            daftarFrame.showMessage(e.getLocalizedMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(daftarFrame.getBtnBack())) {
            btnBackActionPerformed(e);
        }

        if (e.getSource().equals(daftarFrame.getBtnSignUp())) {
            btnDaftarActionPerformed(e);
        }
    }

}
