
Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND -Darg2=THIRD -Darg3=FOURTH -Darg4=FIFTH

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf firstName_secondName_assign_number.tar.gz firstName_secondName_assign_number

-----------------------------------------------------------------------

Data Structures used in this assignment in
term of Big O complexity (time and/or space)

Assuming that the data is well distributed I have used a Binary Search Tree for implementing the tree
The time complexity of a Binary Search Tree for the above assumption is:
insert : O(log n)
search : O(log n)
delete : O(log n)

If the values passed are in ascending order then the time complexity becomes: (Worst case time complexity)
insert : O(n)
search : O(n)
delete : O(n)
as the tree becomes a linked list

ARRAYLIST for storing results. Complexity [ O(1) for reading data O(n) for writing data ]
ARRAYLIST for storing Courses. Complexity [ O(1) for reading data O(n) for writing data ]

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).
OCA/OCP Java SE7 Programmer I & II Study Guide(Exams 1Z0-803 & 1Z0-804)

