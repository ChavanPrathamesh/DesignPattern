package studentCoursesBackup.driver;

import studentCoursesBackup.util.TreeBuilder;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;

/**
 * @author Prathamesh Chavan
 * This is the driver class which is responsible for all activities
 * This class initiates call to tree building, deleting courses and to
 * copying the values to result instance and copying them to output files 
 */

public class Driver {
	
	/**
	 * The main method where the program execution starts
	 */
	public static void main(String[] args) 
	{
		//perform null check as well
		if((args.length!=5)||args[0].equals("${arg0}")||args[1].equals("${arg1}")||args[2].equals("${arg2}")||args[3].equals("${arg3}")||args[4].equals("${arg4}"))
		{
			System.out.println("Incorrect number of arguments supplied. Please provide the correct input file delete file and output file name");
			System.exit(1);
		}
		if(args[0]==null||args[1]==null||args[2]==null||args[3]==null||args[4]==null)
		{
			System.out.println("NULL values passed in the argument");
			System.exit(1);
		}
		
		String inputFile = args[0];
		String outputFile = args[1];
		String output1 = args[2];
		String output2 = args[3];
		String output3 = args[4];
		
		//Building the three trees
		FileProcessor in = new FileProcessor(inputFile);
		TreeBuilder mytrees  = new TreeBuilder();
		mytrees.buildThreeTrees(in);
		in.closeInputFile();
		
		//Deleting value from the parent tree		
		FileProcessor op = new FileProcessor(outputFile);
		mytrees.deletevalues(op);
		op.closeInputFile();
		
		//Writing the results of original tree to output1
		Results results1 = new Results(output1);
		mytrees.getOrgObject().printNodes(results1);
		results1.writeToFile();
		
		//Writing the results of backup tree 1 to output2
		Results results2 = new Results(output2);
		mytrees.getclone1().printNodes(results2);
		results2.writeToFile();
		
		//Writing the results of backup tree 2 to output3
		Results results3 = new Results(output3);
		mytrees.getclone2().printNodes(results3);
		results3.writeToFile();
		
		//Closing all the output files
		results1.closeOutputFile();
		results2.closeOutputFile();
		results3.closeOutputFile();
	}
}
