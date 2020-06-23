import java.awt.Color;
import java.awt.Graphics;

/**
 * The class FractalElement stores information about one piece of the fractal to be drawn.
 * It also has a method to draw the element with the stored data.
 *
 * @author  Valerie Foster
 * @version 3/6/2018
 */
public class FractalElement {
    
    // instance variables
    private int x;
    private int y;
    private int size;
    private Color color;

    /**
     * Constructor for objects of class FractalElement
     * 
     * @param   x       an x coordinate for the FractalElement, an Integer
     * @param   y       a y coordinate for the FractalElement, an Integer
     * @param   size    a size of the FractalElement, an Integer
     * @param   color   a color for the FractalElement, a Color
     */
    public FractalElement(int x, int y, int size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    /**
     * An accessor method - returns the x coordinate for this fractal element to be drawn at
     *
     * @return    an x coordinate for the FractalElement, an Integer
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * An accessor method - returns the y coordinate for this fractal element to be drawn at
     *
     * @return    a y coordinate for the FractalElement, an Integer
     */
    public int getY() {
        return this.y;
    }
    
    /**
     * An accessor method - returns the size for this fractal element to be drawn with
     *
     * @return    a size of the FractalElement, an Integer
     */
    public int getSize() {
        return this.size;
    }
    
    /**
     * An accessor method - returns the color for this fractal element to be drawn with
     *
     * @return    a color for the FractalElement, an Color
     */
    public Color getColor() {
        return this.color;
    }
    
    /**
     * This method takes a Graphics element as input and draws a circle with the characteristics of the instance variables
     *
     * @param   g   a Graphics element to draw with
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    /** 
     * Creates and returns a string representation of this fractal element
     * 
     * @return  a String showing basic information about the FractalElement
     */
    @Override
    public String toString() {
        String str = "";
        str += x + ", " + y + ", " + size +  ", " + color;
        return str;
    }
    
}
