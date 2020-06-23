import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

/**
 * The class Drawing generates a window with the prickly pear cactus fractal created from the FractalGen class by making an inner class
 * that extends JPanel and overriding JPanel's paintComponent method. It also implements the Observer interface and repaints the fractal
 * every time it is notified of changes from it's Subject.
 *
 * @author  Valerie Foster
 * @version 3/6/2018
 */
public class Drawing extends JFrame implements Observer{

    private static final int WIDTH = 800;
    private static final int HEIGHT = 580;
    
    // instance variables
    Subject subject;
    JPanel panel;
    
    /**
     * Constructor for objects of class Drawing
     * 
     * @param   subject     a Subject for this class to observe
     */
    public Drawing(Subject subject) {
        this.subject = subject;
        this.subject.addObs(this);

        setTitle("Prickly Pear Cactus Fractal");
        setSize(WIDTH, HEIGHT);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(7*(size.width - getWidth())/8, (size.height - getHeight())/2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        panel = new GPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
        
        panel.setBackground(Color.WHITE);
    }

    /**
     * A method overriden from the interface, it is called by it's Subject to be notified of any changes
     */
    public void update() {
        panel.repaint();
    }

    private class GPanel extends JPanel {

        /**
         * A method overriden from JPanel, it tells the panel what it should draw by using the draw method of all the FractalElements in the ArrayList
         *
         * @param   g   a Graphics object to draw with
         */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ArrayList<FractalElement> fracElem = ((FractalGen)subject).getData();
            for (FractalElement elem : fracElem) {
                elem.draw(g);
            }
        }
        
    }

}
