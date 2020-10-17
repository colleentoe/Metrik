package de.softwaretechnik;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

/**
 * @author1 Colleen Tölle M24730
 * @author2 Denice Graupeter M26783
 * @date 2020-10-16
 * @version 1.1.1
 *
 * Softwaretechnik, exercise 1
 *
 * Description:
 * The instance of this class generates a canvas. A circle will be painted when the user click
 * twice on the canvas. On a third double click the canvas will be cleared.
 **/
public class DrawObject extends Canvas implements MouseListener {

    private float _x,_y;
    private int _count,_heightCirc,_widthCirc;
    private int _heightWindow, _widthWindow;

    /**
     * Constructor of this class. Generates a canvas, setting the background color and added a mouse listener.
     * @param _heightWindow
     * @param _widthWindow
     */
    public DrawObject(int _heightWindow, int _widthWindow) {
        this._widthWindow = _widthWindow;
        this._heightWindow = _heightWindow;
        _count=0;
        _x = _y = 0;
        _heightCirc = _widthCirc = 50;

        setSize(_widthWindow,_heightWindow);
        setBackground(Color.lightGray);

        addMouseListener(this);
    }

    /**
     * This method paints the circle on the position where the user double clicked.
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        if(_x!=0||_y!=0) {
            Graphics2D g2d = (Graphics2D) g;

            g2d.setStroke(new BasicStroke(2.5F));

            Ellipse2D ellipse2D = new Ellipse2D.Float(
                    _x-_widthCirc/2, _y-_heightCirc/2,
                    _widthCirc, _heightCirc);

            g2d.draw(ellipse2D);

            if (_count == 1){
                g2d.drawString("Kreis 1:  X:   "+ _x +"  Y:  "+ _y ,15, 15);
            }
            else {
                g2d.drawString("Kreis 2:  X:   "+ _x +"  Y:  "+ _y ,15, 30);
            }
        }
    }

    /**
     * This method calls the print method or clears the canvas depending on the amount of clicks.
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(_count==2 && e.getClickCount()==2){

            _x = 0;
            _y = 0;
            update(getGraphics());

            getGraphics().clearRect(getX(),getY(),_widthWindow,_heightWindow);
            _count=0;
        }
        else if(e.getClickCount()==2){
            _x = e.getX();
            _y = e.getY();
            _count++;

            paint(getGraphics());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
