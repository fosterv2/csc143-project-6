import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JColorChooser;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The class FractalGUI generates a user interface for the user to select the fractal options they would like for the fractal to draw with.
 * It uses imports from javax.swing to make things like JLabels, JButtons, and JSliders for the user to select their choice of
 * depth, ratio, cactus color, and pear color.
 *
 * @author  Valerie Foster
 * @version 3/6/2018
 */
public class FractalGUI extends JFrame {
    
    // instance variable
    private FractalGen fracGen;

    /**
     * Constructor for objects of class FractalGUI
     */
    public FractalGUI(FractalGen fracGen) {
        
        this.fracGen = fracGen;
        
        setTitle("Prickly Pear Cactus Options");
        setSize(360, 360);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation((size.width - getWidth())/8, (size.height - getHeight())/2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel heading = new JLabel("Choose your fractal options:");
        heading.setBounds(100, 20, 200, 20);
        panel.add(heading);
        
        JLabel depthL = new JLabel("Depth");
        depthL.setBounds(90, 60, 50, 20);
        panel.add(depthL);
        
        JSlider depthS = new JSlider(2, 10, 4);
        depthS.setPaintTicks(true);
        depthS.setPaintLabels(true);
        depthS.setMajorTickSpacing(2);
        depthS.setMinorTickSpacing(1);
        depthS.setBounds(30, 90, 150, 50);
        panel.add(depthS);
        
        JLabel ratioL = new JLabel("Ratio");
        ratioL.setBounds(90, 160, 50, 20);
        panel.add(ratioL);
        
        JSlider ratioS = new JSlider(40, 70, 50);
        ratioS.setPaintTicks(true);
        ratioS.setPaintLabels(true);
        ratioS.setMajorTickSpacing(10);
        ratioS.setMinorTickSpacing(2);
        ratioS.setBounds(30, 190, 150, 50);
        panel.add(ratioS);
        
        JLabel cactusL = new JLabel("Cactus Color");
        cactusL.setBounds(245, 60, 100, 20);
        panel.add(cactusL);
        
        JPanel cactus = new JPanel();
        cactus.setBounds(290, 90, 30, 30);
        cactus.setBackground(new Color(0, 204, 51));
        panel.add(cactus);
        
        JButton cactusColor = new JButton();
        cactusColor.setBounds(240, 90, 30, 30);
        panel.add(cactusColor);
        cactusColor.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    JColorChooser clr = new JColorChooser();
                    Color color = clr.showDialog(panel, "Choose Color", Color.white);
                    cactus.setBackground(color);
                }
            });
        
        JLabel pearL = new JLabel("Pear Color");
        pearL.setBounds(250, 160, 100, 20);
        panel.add(pearL);
        
        JPanel pear = new JPanel();
        pear.setBounds(290, 190, 30, 30);
        pear.setBackground(new Color(204, 0, 204));
        panel.add(pear);
        
        JButton pearColor = new JButton();
        pearColor.setBounds(240, 190, 30, 30);
        panel.add(pearColor);
        pearColor.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    JColorChooser clr = new JColorChooser();
                    Color color = clr.showDialog(panel, "Choose Color", Color.white);
                    pear.setBackground(color);
                }
            });
        
        JButton draw = new JButton("Draw");
        draw.setBounds(140, 270, 70, 30);
        draw.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    Drawing draw = new Drawing(fracGen);
                    draw.setVisible(true);
                    int depth = depthS.getValue();
                    double ratio = ratioS.getValue();
                    Color cactusCol = cactus.getBackground();
                    Color pearCol = pear.getBackground();
                    fracGen.setData(depth, ratio, cactusCol, pearCol);
                }
            });
        panel.add(draw);
    }
    
}
