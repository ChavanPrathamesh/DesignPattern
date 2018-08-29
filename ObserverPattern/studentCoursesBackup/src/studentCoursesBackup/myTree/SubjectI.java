package studentCoursesBackup.myTree;

/**
 * @author Prathamesh Chavan
 * This is the interface to implement the register method 
 */

public interface SubjectI {
	
	/**
	 * Using this method any node can subscribe as an observer 
	 */
	public void register(ObserverI A);

}
