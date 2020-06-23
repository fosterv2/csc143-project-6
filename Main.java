
/**
 * The class Main is the class that runs the application of this project.
 *
 * @author  Valerie Foster
 * @version 3/6/2018
 */
public class Main{
    
    public static void main(String[] args) {
        FractalGen fracGen = new FractalGen();
        
        FractalGUI gui = new FractalGUI(fracGen);
        gui.setVisible(true);
    }
    
}
