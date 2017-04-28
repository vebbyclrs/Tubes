/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Aplikasi;
import Model.Gudang;
import Model.Barang;
import Model.Penyedia;
import View.HomePage;
import Model.DatabaseConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
/**
 *
 * @author Endriawan
 */
public class ControllerHomePage implements ActionListener, KeyListener{
    Aplikasi model;
    HomePage view;
    
    public ControllerHomePage(Aplikasi model){
        this.model = model;
        view = new HomePage();
        view.setVisible(true);
        view.addListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Kalo pencet delete gimana?
        //Kalo pencet F2(?) gimana?
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
