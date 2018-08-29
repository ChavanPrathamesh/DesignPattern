package myArrayList.driver;

import myArrayList.MyArrayList;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.Results;
import myArrayList.util.FileProcessor;

/**
 * @author prathamesh chavan
 * This class contains the main method which gives calls to methods implemented in other classes
 */

public class Driver 
{

	public static void main(String[] args) 
	{
		//perform null check as well
		if((args.length!=2)||args[0].equals("${arg0}")||(args[1].equals("${arg1}")))
		{
			System.out.println("Incorrect number of arguments supplied. Please provide the input file and output file name");
			System.exit(1);
		}
		if(args[0]==null||args[1]==null)
		{
			System.out.println("NULL values passed in the argument");
			System.exit(1);
		}
		
		String inputFile = args[0];
		String outputFile = args[1];
		
		MyArrayList arrayList = new MyArrayList();
		FileProcessor fr = new FileProcessor(inputFile);
		String readString = " " ;
		while((readString=fr.readLine())!=null)
		{
			arrayList.insertSorted(Integer.parseInt(readString));
		}
		MyArrayListTest  arrayListTest = new MyArrayListTest();
		Results results = new Results(outputFile);
		arrayListTest.testMe(arrayList, results);
		
		results.writeToFile();
		results.writeToStdout();
		fr.closeInputFile();
		results.closeOutputFile();
	}
}
