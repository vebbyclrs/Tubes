/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;
import Controller.ControllerHomePage;
import View.HomePage;
import Model.Aplikasi;
/**
 *asa
 * @author Endriawan
 */
public class Driver {
    public static void main(String[] args) {
        Aplikasi app =  new Aplikasi();
        new ControllerHomePage(app);
    }
}
