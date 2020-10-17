package de.softwaretechnik;

import java.awt.*;
import java.awt.event.*;

/**
 * @author1 Colleen Tölle M24730
 * @author2 Denice Graupeter M26783
 * @date 2020-10-16
 * @version 1.0.1
 *
 * Softwaretechnik, exercise 1
 *
 * Description:This class generates a window with a canvas in it.
 */
public class MainWindow extends Frame implements WindowListener {

    /**
     * Constructor of this class. Sets important values and adds a window listener and a Canvas inside of this window.
     */
    public MainWindow() {
        setTitle("Programm für Softwaretechnik");
        setSize(500,500);

        addWindowListener(this);
        add(new DrawObject(500,500));
    }

    public void openWindow(){
        setVisible(true);
    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
