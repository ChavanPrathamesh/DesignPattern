package studentCoursesBackup.myTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Prathamesh Chavan
 * This class is the node implementation for the tree
 * Each Node stores a b number a list of subjects
 * and data about the children i.e. leftChild and rightChild 
 */

public class Node implements ObserverI ,SubjectI,Cloneable {
	
	private int bNumber;
	private List<String> courseList = new ArrayList<String>();
	private ObserverI observerarr[] = new Node[2];
	private Node leftChild;
	private Node rightChild;
	int current = 0;
	
	public Node()
	{}
	
	/**
	 * This is the constructor of the class
	 * Only called when a node is created
	 * @param bno is the b number of the node 
	 * @param s is the course of node
	 */
	public Node(int bno,String s )
	{
		bNumber = bno;
		courseList.add(s);
		leftChild = null;
		rightChild = null;
	}
	
	/**
	 * @return the bNumber of the node 
	 */
	public int getBnumber()
	{
		return bNumber;
	}
	
	/**
	 * Set the bNumber of the node
	 * @param bno the number to be set 
	 */
	public void setBnumber(int bno)
	{
		bNumber=bno;
	}
	
	/**
	 * @return courseList the list of courses for that node 
	 */
	public List<String> getCourseList()
	{
		return courseList;
	}
	
	/**
	 * Set the courselist
	 * @param a a list of courses 
	 */
	public void setCourseList(List<String> a)
	{
		courseList.addAll(a);
	}
	
	/**
	 * @return leftChild gives the left child of the node 
	 */
	public Node getLeftChild()
	{
		return leftChild;
	}
	
	
	/**
	 * This method sets the left child of a node
	 */
	public void setLeftChild(Node lc)
	{
		leftChild=lc;
	}
	
	/**
	 * @return rightChild the right child of the node
	 */
	public Node getRightChild()
	{
		return rightChild;
	}
	
	/**
	 * This method sets the right child of the node 
	 */
	public void setRightChild(Node lc)
	{
		rightChild=lc;
	}
	
	
	/**
	 * This method is called whenever a node wants to
	 * subscribe to this node
	 * Since there are only two backup nodes this is an array 
	 * which can hold two values
	 * This method adds the observers to the list 
	 */
	@Override
	public void register(ObserverI A)
	{
		observerarr[current]=A;
		current++;
	}
	
	/**
	 * Called whenever other node which this node has subscribed to
	 * When the notify method of the subscribed node is called this
	 * method is called
	 */
	@Override
	public void Update(String course)
	{
		courseList.remove(course);
	}
	
	/**
	 * This method is used to notify all the observers about a change
	 */
	public void notifyAll(String s)
	{
		for(int i=0;i<2;i++)
		{
			observerarr[i].Update(s);
		}
	}
	
	/**
	 * This method adds a new course to the node
	 * @param s the course to be added  
	 */
	public void addCourse(String s)
	{
		if(!(courseList.contains(s)))
		{
			courseList.add(s);
		}
	}
	
	public void deleteCourse(String s)
	{
		if(courseList.contains(s))
		{
			courseList.remove(s);
			notifyAll(s);
		}
	}
	
	/**
	 * Over riding the java clone method
	 * this method initializes the bnumber and courselist of the 
	 * new object to be created
	 * NOTE The object created has a deep copy of courselist
	 * @return the new object A which is the clone of parent object  
	 */
	@Override
	public Node clone()
	{
		Node A = new Node();
		A.setBnumber(this.getBnumber());
		for(String c : this.getCourseList()) {
			A.addCourse(c);
		}
		return A;
	}
}
