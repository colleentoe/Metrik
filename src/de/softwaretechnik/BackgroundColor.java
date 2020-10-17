package de.softwaretechnik;

import java.awt.*;

/**
* @author1 Colleen Tölle M24730
 * @author2 Denice Graupeter M26783
 * @date 2020-10-17
 * @version 1.1.0
 *
 * Softwaretechnik, exercise 1
 *
 * Description:This enum contains all background colors the window can have.
*/
public enum BackgroundColor {
    ORANGE(Color.orange), GREEN(Color.green), CYAN(Color.cyan),
    GRAY(Color.lightGray);

    private Color _color;

    /**
     * Constructor of this class.
     * @param color
     */
    BackgroundColor(Color color) {
        this._color = color;
    }

    public Color getColor() {
        return _color;
    }
}
