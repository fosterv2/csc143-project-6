import java.awt.Color;

/**
 * The class FractalGen is mainly responsible for using recursion to calculate FractalElements to create a prickly pear cactus fractal
 * with the characteristics of the given instance data set when the setData method is called. It also implements the Subject interface;
 * so it has an ArrayList of Observers associated with it, which it keeps updated of changes to itself.
 *
 * @author  Valerie Foster
 * @version 3/6/2018
 */
public class FractalGen implements Subject {
    
    private static final int START_X = 300;
    private static final int START_Y = 350;
    private static final int START_RAD = 100;
    
    // instance variables
    private ArrayList<Observer> obsArr;
    
    private ArrayList<FractalElement> fracElem;
    private int depth;
    private double ratio;
    private Color cactusColor;
    private Color pearColor;

    /**
     * Constructor for objects of class FractalGen
     */
    public FractalGen() {
        obsArr = new ArrayList<Observer>();
        fracElem = new ArrayList<FractalElement>();
    }
    
    /**
     * This private recusive method generates the ArrayList of FractalElements by adding a FractalElement created with the data from the
     * parameters and the cactus color, then it uses math to calculate where the next two new shapes should be drawn. Once the remaining
     * depth is one or the shape is too small, it adds a FractalElement with the pear color and stops recursing.
     *
     * @param   x           an x coordinate, an Integer
     * @param   y           a y coordinate, an Integer
     * @param   rad         a radius, an Integer
     * @param   ori         an orientation, a Double
     * @param   depthRemain a depth remaining, an Integer
     */
    private void calcShapes(int x, int y, int rad, double ori, int depthRemain) {
        if (rad == 0) {
            // do nothing
        } else if (depthRemain == 1 || rad == 1) {
            FractalElement elem = new FractalElement(x, y, 2 * rad, pearColor);
            fracElem.add(elem);
        } else {
            FractalElement elem = new FractalElement(x, y, 2 * rad, cactusColor);
            fracElem.add(elem);
            
            int newRad = (int)(rad * ratio);
            
            calcShapes((int)(x + rad + Math.cos(ori - Math.PI / 4) * (rad + newRad)- newRad),
                        (int)(y + rad - Math.sin(ori - Math.PI / 4) * (rad + newRad) - newRad),
                            newRad, ori - Math.PI / 4, depthRemain - 1);
            calcShapes((int)(x + rad + Math.cos(ori + Math.PI / 4) * (rad + newRad) - newRad),
                        (int)(y + rad - Math.sin(ori + Math.PI / 4) * (rad + newRad) - newRad),
                            newRad, ori + Math.PI / 4, depthRemain - 1);
        }
    }
    
    /**
     * This method sets the instance data for this FractalGen, then generates the ArrayList of FractalElements and notifies it's Observers
     * 
     * @param   depth       the depth to draw the fractal to, an Integer
     * @param   ratio       the ratio for each new piece of the fractal to have to it's parent, a Double
     * @param   cactusColor the color for most of the fractal to be drawn with, a Color
     * @param   pearColor   the color for the fractal pieces at the edges to be drawn with, a Color
     */
    public void setData(int depth, double ratio, Color cactusColor, Color pearColor) {
        this.depth = depth;
        this.ratio = ratio / 100;
        this.cactusColor = cactusColor;
        this.pearColor = pearColor;
        calcShapes(START_X, START_Y, START_RAD, Math.PI / 2, depth);
        notifyObs();
    }

    /**
     * This method returns the data that an Observer class would ask for after being updated in this "pull" model
     *
     * @return    the ArrayList of FractalElements for this class
     */
    public ArrayList<FractalElement> getData() {
        return this.fracElem;
    }
    
    /**
     * A method overriden from the interface, it adds the given Observer to the ArrayList of Observers
     * 
     * @param    obs    an Observer to add
     */
    public void addObs(Observer obs) {
        obsArr.add(obs);
    }
    
    /**
     * A method overriden from the interface, it removes the given Observer from the ArrayList of Observers
     * 
     * @param    obs    an Observer to remove
     */
    public void removeObs(Observer obs) {
        int num = obsArr.indexOf(obs);
        obsArr.remove(num);
    }
    
    /**
     * A method overriden from the interface, it notifies all of it's Observers by calling their update methods
     */
    public void notifyObs() {
        for (Observer observer : obsArr) {
            observer.update();
        }
    }
    
}
