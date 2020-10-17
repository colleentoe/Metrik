package de.softwaretechnik;

import java.awt.*;
import java.awt.event.*;

/**
 * @author1 Colleen Tölle M24730
 * @author2 Denice Graupeter M26783
 * @date 2020-10-17
 * @version 1.2
 *
 * Softwaretechnik, exercise 1
 *
 * Description: The instance of this class generates a menubar. The user can change the color of the background with it.
 */
public class MenuBar extends java.awt.MenuBar implements ActionListener {

    private Menu _menu;

    /**
     * Constructor of this class. Generates a manu based of the values the enum.
     */
    public MenuBar() {
        _menu = new Menu("Background color");

        for (BackgroundColor value:BackgroundColor.values()) {

            MenuItem newItem = new MenuItem("Color: " + value.toString().toLowerCase());
            newItem.setActionCommand(value.toString());
            _menu.add(newItem);
        }

        add(_menu);

        _menu.addActionListener(this);
    }


    /**
     * Method will be called when the user clicked on a menu item. The value of the color will be send to the
     * MainWindow class.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        for (BackgroundColor value:BackgroundColor.values()) {
            if(value.toString()==e.getActionCommand()){
                MainWindow.updateBackground(value);
            }
        }

    }
}
