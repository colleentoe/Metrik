package de.softwaretechnik;

import java.awt.*;
import java.awt.event.*;

/**
 * @author1 Colleen Tölle M24730
 * @author2 Denice Graupeter M26783
 * @date 2020-10-16
 * @version 1.2
 *
 * Softwaretechnik, exercise 1
 *
 * Description:This class generates a window with a canvas in it.
 */
public class MainWindow extends Frame implements WindowListener {

    private static DrawObject _canvas;
    /**
     * Constructor of this class. Sets important values and adds a window listener and a Canvas inside of this window.
     */
    public MainWindow() {
        setTitle("Metrik Version 1.2");
        setSize(500,500);

        addWindowListener(this);
        _canvas = new DrawObject(500,500);
        add(_canvas);
        setMenuBar(new MenuBar());
        setResizable(false);
    }

    public void openWindow(){
        setVisible(true);
    }

    public static void updateBackground(BackgroundColor color){
        _canvas.updateBackground(color.getColor());
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
