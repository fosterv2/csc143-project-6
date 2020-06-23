
/**
 * The interface Subject is designed to be implemented by a class that would have Observers that would want to be informed of changes to the Subject.
 *
 * @author  Valerie Foster
 * @version 3/6/2018
 */
public interface Subject {
    
    public void addObs(Observer obs);
    
    public void removeObs(Observer obs);
    
    public void notifyObs();

}
