package myArrayList;

import java.util.Arrays;

public class MyArrayList {
	
	private int[] a;
	private int count;
	private int initialarrvalue = 50;
	private int maxvalue;
	
	public MyArrayList()
	{
		a = new int[initialarrvalue];
		count =0;
		maxvalue = initialarrvalue;
	}
	
	/**
	 * @void
	 */
	public void insertSorted(int newValue)
	{
		if(count<maxvalue)
		{
		a[count]= newValue;
		count++;
		Arrays.sort(a,0,count);
		}
		else
		{
			int tempmaxvalue = maxvalue;
			maxvalue=maxvalue+(maxvalue/2);
			int[] temp = new int[maxvalue];
			for(int i=0;i<tempmaxvalue;i++)
			{
				temp[i]=a[i];
			}
			
			a=temp;
			a[count]=newValue;
			count++;
			Arrays.sort(a,0,count);
		}
	}
	
	/**
	 * @return returns -1 if element to be removed does not exist 
	 */
	public int removeValue(int value)
	{
		int exists=0;
		for(int i=0;i<count;i++)
		{
			if(a[i]==value)
			{
				if(i==count-1)
				{
					count--;
				}
				else
				{
					for(int z=i;z<count;z++)
					{
						a[z]=a[z+1];
					}
					count--;
					i=i-1;
					exists=1;
				}
			}
		}
		if(exists==1)
		{
			return 1;
		}
		else 
		{
			return -1;
		}
	}
	
	/**
	 * @return Index of an element. Return -1 if not found 
	 */
	public int indexOf(int value)
	{
		for(int i=0;i<count;i++)
		{
			if(a[i]==value)
			{
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * @return Size of the array 
	 */
	public int size()
	{
		return count;
	}
	
	public int sum()
	{
		int sum = 0;
		for(int i=0;i<count;i++)
		{
			sum=sum+a[i];
		}
		return sum;
	}
	
	/**
	 * @void 
	 */
	public void empty()
	{
		int temp[]=new int[initialarrvalue];
		a = temp;
		count = 0;
	}
	
	/**
	 * Print the values stored in the array 
	 */
	public String toString()
	{
		System.out.println("Printing the values stored in the array :\n");
		if(count==0)
		{
			System.out.println("The array is empty \n");
			return null;
		}
		for(int i=0;i<count;i++)				//Test to be done if count =0
		{
			System.out.println(a[i]+"\n");
		}
		return null;
	}
}
