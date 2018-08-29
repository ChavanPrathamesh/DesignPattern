package myArrayList.test;

import myArrayList.MyArrayList;
import myArrayList.util.Results;

/**
 * @author prathamesh chavan
 * This class implements all the test cases 
 */
public class MyArrayListTest {
	
	MyArrayList myArrayList1;
	Results results1;
	
	/**
	 * Executing the test cases  
	 */
	public void testMe(MyArrayList myArrayList, Results results)
	{
		myArrayList1=myArrayList;
		results1 = results;
		
		int y = basictestcase();
		results1.storeNewResult("The sum of all the values in the array list is :"+y);
		
		int a = testcase1();
		results1.storeNewResult(" Test case 1 passed [[ checking the size of the array ]] :"+a);
		
		int b = testcase2(2000);
		results1.storeNewResult("Test case 2 passed [[ Inserting new value 2000 and finding the index ]] index:"+b);
		
		int z = testcase3(2000);
		results1.storeNewResult("Test case 3 passed [[ Removing the inserted value 2000 and checking the size of the array ]] size:"+z);
		
		int c = testcase4();
		results1.storeNewResult("Test case 4 passed [[ Check remove function :Insert(33)->Insert(33)->Remove(33),Remove(33) ]] value returned:"+c);
		
		int d = testcase5(20000);
		if(d<0)
		{
			results1.storeNewResult("Test case 5 passed [[ value returned from function when trying to remove a non existing value ]] value :"+d);
		}
		else
		{
			results1.storeNewResult("Test case 5 failed did not return -1 as expected");
		}
		
		int e = testcase6(20000);
		if(d<0)
		{
			results1.storeNewResult("Test case 6 passed [[ value returned from function when trying to check index of a non existing value ]] value :"+e);
		}
		else
		{
			results1.storeNewResult("Test case 6 failed did not return -1 as expected");
		}
		
		int f = testcase7();
		results1.storeNewResult("Test case 7 passed [[ Inserting 10,20 in the list and then removing 20 and calculating the sum]] sum:"+f);
		
		int g = testcase8();
		results1.storeNewResult("Test case 8 passed [[ Inserting 55,55 and calculating the index it gives the first indexs ]] index :"+g);
		
		int h = testcase9();
		results1.storeNewResult("Test case 9 passed [[ Inserting element 3, check if sorting is working and find index value]] index :"+h);
		
		int i = testcase10();
		results1.storeNewResult("Test case 10 passed [[ Insert 100 elements and check array size print total new size ]] size :"+i);
		
	}
	/**
	 * @return Sum of all the elements in the array
	 */
	public int basictestcase()
	{
		return myArrayList1.sum();
	}
	
	/**
	 * TestCase to check if the sum is generated properly
	 */
	public int testcase1()
	{
		return myArrayList1.size();
	}
	
	/**
	 * Test case to check if the new inserted value is inserted at the correct index
	 */
	public int testcase2(int a)
	{
		myArrayList1.insertSorted(a);
		return myArrayList1.indexOf(a);
	}
	
	/**
	 * Remove the previously inserted value and then check the count of array
	 */
	public int testcase3(int a)
	{
		myArrayList1.removeValue(a);
		return myArrayList1.size();
	}
	
	
	/**
	 * Inserting two same values and trying to remove them twice to check if remove is working 
	 */
	public int testcase4()
	{
		myArrayList1.insertSorted(33);
		myArrayList1.insertSorted(33);
		myArrayList1.removeValue(33);
		return myArrayList1.removeValue(33);
	}
	
	/**
	 * Trying to remove a value that does not exist in the list
	 */
	public int testcase5(int b)
	{
		return myArrayList1.removeValue(b);
	}
	
	/**
	 * Checking the index of a non existing value
	 */
	public int testcase6(int c)
	{
		return myArrayList1.indexOf(c);
	}
	
	/**
	 * Checking multiple insert and remove and then calculate the sum
	 */
	public int testcase7()
	{
		myArrayList1.insertSorted(10);
		myArrayList1.insertSorted(20);
		myArrayList1.removeValue(20);
		return myArrayList1.sum();
	}
	
	/**
	 * Getting the index of the first instance when two or more values in the array are the same values 
	 */
	public int testcase8()
	{
		myArrayList1.insertSorted(55);
		myArrayList1.insertSorted(55);
		return myArrayList1.indexOf(55);
	}
	/**
	 * When inserting multiple elements checking if they are sorted by getting the index of the smallest element
	 */
	public int testcase9()
	{
		myArrayList1.insertSorted(22);
		myArrayList1.insertSorted(11);
		myArrayList1.insertSorted(3);
		return myArrayList1.indexOf(3);
	}
	
	/**
	 * Adding elements more than the array size and returning the new size
	 */
	public int testcase10()
	{
		for(int i=0;i<100;i++)
		{
			myArrayList1.insertSorted(1);    //Inserting 100 new elements
		}
		return myArrayList1.size();
	}
	
	//empty constructor
	
}
