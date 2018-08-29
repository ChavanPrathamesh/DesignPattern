package studentCoursesBackup.util;
import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.searchTree.BinarySearchTree;

/**
 * @author Prathamesh Chavan
 * This is the class where the three trees are build
 * Insertion and deletion of notes take place here
 * Insertion is done in all three trees
 * while deletion is done only from one tree 
 */
public class TreeBuilder {
	public BinarySearchTree org;
	public BinarySearchTree clone1;
	public BinarySearchTree clone2;
	
	/**
	 * This is the constructor of the TreeBuilder class
	 * It creates the instances for three trees 
	 */
	public TreeBuilder()
	{
		org = new BinarySearchTree();
		clone1 = new BinarySearchTree();
		clone2 = new BinarySearchTree();
	}
	
	/**
	 * This method takes the file reads data from it creates three nodes
	 * and then inserts the three nodes in the three different trees
	 * NOTE: If the node already exists then it just adds the course to it
	 * @param  fr The FileProcessor for the input file 
	 */
	public void buildThreeTrees(FileProcessor createfr)
	{
		Node node_orig;
		Node backup_Node_1;
		Node backup_Node_2;
		
		String readString = " " ;
		while((readString=createfr.readLine())!=null)
		{
			String[] splitstring = readString.split(":");
			node_orig=org.search(Integer.parseInt(splitstring[0]));
			backup_Node_1=clone1.search(Integer.parseInt(splitstring[0]));
			backup_Node_2=clone2.search(Integer.parseInt(splitstring[0]));
				
			if(node_orig!=null)
			{
				if(!(node_orig.getCourseList().contains(splitstring[1])))
				{
					node_orig.addCourse(splitstring[1]);
					backup_Node_1.addCourse(splitstring[1]);
					backup_Node_2.addCourse(splitstring[1]);
				}
			}
			else
			{
				node_orig = new Node(Integer.parseInt(splitstring[0]),splitstring[1]);
				backup_Node_1  = node_orig.clone();			//Create a clone of node_orig
				backup_Node_2  = node_orig.clone();			//Create a clone of node_orig
				org.insert(node_orig);
				clone1.insert(backup_Node_1);
				clone2.insert(backup_Node_2);
				node_orig.register(backup_Node_1);
				node_orig.register(backup_Node_2);
			}
		}
	}
	
	/**
	 * This method deletes the courses from a node
	 * @param deletefr The FileProcessor for delete.txt
	 */
	public void deletevalues(FileProcessor deletefr)
	{
		String readString = " " ;
		while((readString=deletefr.readLine())!=null)
		{
			String[] splitstring = readString.split(":");
			Node node_delete;
			node_delete=org.search(Integer.parseInt(splitstring[0]));
			if(node_delete!=null)
			{
				node_delete.deleteCourse(splitstring[1]);
			}
		}
	}
	
	/**
	 * @return the object of the original/first tree 
	 */
	public BinarySearchTree getOrgObject()
	{
		return org;
	}
	
	/**
	 * @return the object of the clone1/second tree 
	 */
	public BinarySearchTree getclone1()
	{
		return clone1;
	}
	
	/**
	 * @return the object of the clone2/second tree 
	 */
	public BinarySearchTree getclone2()
	{
		return clone2;
	}
}
