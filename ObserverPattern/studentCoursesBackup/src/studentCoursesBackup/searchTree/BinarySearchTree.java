package studentCoursesBackup.searchTree;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.Results;

import java.util.List;

/**
 * @author Prathamesh Chavan
 * This is the implementation of the Binary Search tree
 * which handles all the operations of a binary tree  
 */

public class BinarySearchTree {
	
	public Node root;
	
	/**
	 * Constructor 
	 */
	public BinarySearchTree()
	{
		root = null;
	}
	
	/**
	 * This method inserts nodes in to the tree
	 * @param newNode the node to be inserted
	 */
	public void insert(Node newNode)
	{
		if(root==null)
		{
			root = newNode;
		}
		else
		{
			insertTraverse(root,newNode);
		}
	}
	
	/**
	 * A recurring method to traverse the tree and insert
	 * the nodde at the correct location
	 * @param currentNode the current node which is to be checked
	 * @param insertNode the node which is to be inserted
	 */
	public void insertTraverse(Node currentNode,Node insertNode)
	{
		if(insertNode.getBnumber()<currentNode.getBnumber())
		{
			if(currentNode.getLeftChild()==null)
			{
				currentNode.setLeftChild(insertNode);
			}
			else
			{
				insertTraverse(currentNode.getLeftChild(),insertNode);
			}
		}
		else
		{
			if(currentNode.getRightChild()==null)
			{
				currentNode.setRightChild(insertNode);
			}
			else
			{
				insertTraverse(currentNode.getRightChild(),insertNode);
			}
		}
	}
	
	/**
	 * The start point of searching for a node in a tree 
	 */
	public Node search(int s)
	{
		if(root==null)
		{
			return null;
		}
		else
		{
			return searchTraverse(root,s);
		}
	}
	
	/**
	 * The traversal of the tree to search for a node is done here 
	 */
	public Node searchTraverse(Node currentNode,int str)
	{
		if(currentNode.getBnumber()==str)
		{
			return currentNode;
		}
		else if(str<currentNode.getBnumber()&&currentNode.getLeftChild()!=null)
		{
			return searchTraverse(currentNode.getLeftChild(),str);
		}
		else if(str>currentNode.getBnumber()&&currentNode.getRightChild()!=null)
		{
			return searchTraverse(currentNode.getRightChild(),str);
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * This method adds the nodes of the tree to the result instance
	 * @param r the result instance
	 */
	public void printNodes(Results r)
	{
		Node traverseNode = root;
		if(traverseNode!=null)
			printTraverseNodes(traverseNode,r);
		
	}
	
	/**
	 * The traversal for adding the nodes to the result instance is done here 
	 */
	public void printTraverseNodes(Node traverseNode, Results r)
	{
		if(traverseNode.getLeftChild()!=null)
		{
			printTraverseNodes(traverseNode.getLeftChild(),r);
		}
		
		r.storeNewResult(traverseNode.getBnumber()+": "+toString(traverseNode.getCourseList()));
		
		if(traverseNode.getRightChild()!=null)
		{
			printTraverseNodes(traverseNode.getRightChild(),r);
		}
	}
	
	/**
	 * The toString method for formatting the string 
	 */
	public String toString(List<String> courselist)
	{
		String stra = "";
		for(String str:courselist)
		{
			stra = stra + str + " ";
		}
		return stra;
	}

}
