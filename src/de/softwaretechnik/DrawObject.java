package de.softwaretechnik;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

/**
 * @author1 Colleen Tölle M24730
 * @author2 Denice Graupeter M26783
 * @date 2020-10-16
 * @version 1.2.1
 *
 * Softwaretechnik, exercise 1
 *
 * Description:
 * The instance of this class generates a canvas. A circle will be painted when the user click
 * twice on the canvas. On a third double click the canvas will be cleared.
 **/
public class DrawObject extends Canvas implements MouseListener {

    private float _x,_y,_x2,_y2;
    private int _count;
    private static int _radius;
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
        _x2 = _y2 = 0;
        _radius = 50;

        setSize(_widthWindow,_heightWindow);
        setBackground(Color.lightGray);

        addMouseListener(this);
    }

    public static void updateSize(int value){
        _radius = value;
    }

    /**
     * With the change of the Background color the previous input of the users click will be cleard too.
     * @param color
     */
    public void updateBackground(Color color){
        _x = _y = 0;
        _x2 = _y2 = 0;
        _count = 0;
        this.setBackground(color);
    }

    /**
     * This method paints the circle on the position where the user double clicked.
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        if(_x!=0||_y!=0 && _x2!=0||_y2!=0 ) {

            float coordinateX;
            float coordinateY;

            if (_count == 1){
                coordinateX = _x;
                coordinateY = _y;
            }
            else {
                coordinateX = _x2;
                coordinateY = _y2;
            }

            Graphics2D g2d = (Graphics2D) g;

            g2d.setStroke(new BasicStroke(2.5F));

            Ellipse2D ellipse2D = new Ellipse2D.Float(coordinateX-_radius/2, coordinateY-_radius/2, _radius, _radius);

            g2d.draw(ellipse2D);

            if (_count == 1){
                g2d.drawString("Circle 1:  X:   "+ _x +"  Y:  "+ _y ,15, 15);
            }
            else {
                g2d.drawString("Circle 2:  X:   "+ _x2 +"  Y:  "+ _y2 ,15, 30);
                double distance = Math.sqrt(Math.pow((_x-_x2), 2) + Math.pow((_y-_y2), 2));
                g2d.drawString("Distance: " + distance,15, 45);
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
            _x2 = 0;
            _y2 = 0;
            update(getGraphics());

            getGraphics().clearRect(getX(),getY(),_widthWindow,_heightWindow);
            _count=0;
        }
        else if(e.getClickCount()==2){

            if (_count == 0){
                _x = e.getX();
                _y = e.getY();
            }
            else{
                _x2 = e.getX();
                _y2 = e.getY();
            }

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