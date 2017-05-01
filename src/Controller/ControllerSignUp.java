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
import javax.swing.text.View;

/**
 *
 * @author TESASET
 */
public class ControllerSignUp implements ActionListener {
    private Aplikasi apps;
    private SignUpPegawai daftarFrame;

    public ControllerSignUp() {
        new Aplikasi();
        daftarFrame = new SignUpPegawai();
        daftarFrame.setVisible(true);
        daftarFrame.setLocationRelativeTo(null);
    }
    
    public void btnBackActionPerformed (ActionEvent ae) {
        daftarFrame.dispose();
        new ControllerLoginForm();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}
