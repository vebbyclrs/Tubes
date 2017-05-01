/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author TESASET
 */
import Model.*;
import View.LoginForm;
import View.HomePage;
import View.SignUpPegawai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import sun.security.pkcs11.Secmod;



public class ControllerLoginForm implements ActionListener, KeyListener {

    private LoginForm loginFrame;
    private ControllerSignUp daftarFrame;
    private ControllerHomePage homeFrame;
    private Aplikasi apps;

    public ControllerLoginForm() {
        apps = new Aplikasi();
        loginFrame = new LoginForm();
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
        loginFrame.setKeyListener(this);
        loginFrame.setActionListener(this); //add action listener utk semua button
    }

    private void btnDaftarActionPerformed(ActionEvent ae) {
        loginFrame.setVisible(false);
        daftarFrame = new ControllerSignUp();
    }

    private void btnLoginActionPerformed(ActionEvent ae) {
        String email = loginFrame.getTfEmail().getText();
        String password = loginFrame.getTfPassword().getText();

        try {
            Petugas p = apps.getPetugasByEmail(email);
            if (p == null) {
                loginFrame.showMessage("Email salah");
            } else {
                if (!p.getPass().equals(password)) {
                    loginFrame.showMessage("Password salah");
                } else { //masuk gan
//                            daftarFrame = new ControllerSignUp();
                    loginFrame.setVisible(false);
                    homeFrame = new ControllerHomePage();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(loginFrame.getBtnDaftar())) {
            btnDaftarActionPerformed(e);
        }
        if (e.getSource().equals(loginFrame.getBtnLogin())) {
            btnLoginActionPerformed(e);
        }

//            Petugas p = apps.getPetugasByEmail(email);
//            if (p==null) {
//               throw new IllegalArgumentException("Email tidak ditemukan");
//            } else {
//                if (p.getPass() != password) {
//                    throw new IllegalArgumentException("Password salah");
//                } else {
//                    HomePage home = new HomePage();
//                    home.setVisible(true);
//                    loginFrame.dispose();
//                }
//            }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource().equals(loginFrame.getTfPassword())) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                btnLoginActionPerformed(null);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    /**
     * kalo pencet daftar bakal langsung pindah ke sign up , udah di atur d
     * viewnya
     */

}
