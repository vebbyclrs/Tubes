/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
/**
 *
 * @author TESASET
 */
public class SignUpHandler implements ActionListener {
    private SignUpPegawai view;

    public SignUpHandler() {
        this.view = view;
        view.setVisible(true);
        view.setActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object click = e.getSource();
        if(click.equals(view.getBtnBack())){
            //JOptionPane.showMessageDialog(null, "Berhasil");
            //view.reset();
        }
        else if(click.equals(view.getBtnSignUp())){
        }
    }
}
