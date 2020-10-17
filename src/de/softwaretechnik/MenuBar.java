package de.softwaretechnik;

import java.awt.*;
import java.awt.event.*;

/**
 * @author1 Colleen Tölle M24730
 * @author2 Denice Graupeter M26783
 * @date 2020-10-17
 * @version 1.2.1
 *
 * Softwaretechnik, exercise 1
 *
 * Description: The instance of this class generates a menubar. The user can change the color of the background with it.
 */
public class MenuBar extends java.awt.MenuBar implements ActionListener {

    private Menu _menu;
    private Menu _menuSize;
    private int[] _size = {25,50,75,100};

    /**
     * Constructor of this class. Generates a manu based of the values the enum.
     */
    public MenuBar() {
        _menu = new Menu("Background Color");

        for (BackgroundColor value:BackgroundColor.values()) {

            MenuItem newItem = new MenuItem("Color: " + value.toString().toLowerCase());
            newItem.setActionCommand(value.toString());
            _menu.add(newItem);
        }

        add(_menu);

        _menu.addActionListener(this);

        _menuSize = new Menu("Circle size");

        for (int value:_size) {
            MenuItem newItem = new MenuItem("Size: " + value);
            newItem.setActionCommand(Integer.toString(value));
            _menuSize.add(newItem);
        }

        _menuSize.addActionListener(this);

        add(_menuSize);
    }


    /**
     * Method will be called when the user clicked on a menu item.
     * The value of the color will be send to the MainWindow class.
     * The value of the circle size will be send to the DrawObject class.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        for (BackgroundColor value:BackgroundColor.values()) {
            if(value.toString()==e.getActionCommand()){
                MainWindow.updateBackground(value);
            }
        }
        for (int value:_size) {
            if(Integer.toString(value).compareTo(e.getActionCommand())==0){
                DrawObject.updateSize(value);
            }
        }
    }
}
