/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author TESASET
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginFormHandler implements ActionListener {
    private LoginForm view;

    public LoginFormHandler() {
        this.view = view;
        view.setVisible(true);
        view.setActionListener(this);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        Object click = e.getSource();
        if(click.equals(view.getBtnDaftar())){
            new SignUpHandler();
        }
        else if(click.equals(view.getBtnLogin())){
        }
    }
}
