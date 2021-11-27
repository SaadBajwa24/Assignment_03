import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

//Main Class
@SuppressWarnings("unused")
public class trying extends Thread{
	
	static Object[] secondThread;
	static Object readFile;
	static BinarySearchTree BST_Tree;
	static word tempObj;
	String firstFileName;
	
	public trying(String n) {
		firstFileName=n ;
	}
	// Overriding run method
	public void run() {
		Scanner fileScanner = new Scanner(System.in);
		try {
				String tempData="";
				BinarySearchTree tempTree = new BinarySearchTree();
				fileScanner = new Scanner(new File(firstFileName));
			    while(fileScanner.hasNext()){
			        tempData = fileScanner.next();
			        tempTree.insert(tempData);
			    }
			    BST_Tree = tempTree ;
		} 
		catch (IOException e0) {
			e0.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "static-access", "resource" })
	public static void main(String[] args) throws InterruptedException {
		
		// Displaying no of files and their names
		System.out.println("No of files are: " + args.length);
		for(int i=0 ; i<args.length ; i++)
		{
			System.out.println("File name " + (i+1) + " is: " + args[i]);
		}
		
		// Creating first thread and naming it with first argument passed
		trying firstThread = new trying(args[0]) ;
		firstThread.setName(args[0]);
		firstThread.start();
		
		// Creating other threads and naming it too
		readFile secondThread[] = new readFile[args.length-1];
		for(int i=0 ; i<args.length-1 ; i++)
		{
			secondThread[i] = new readFile(args[i+1]) ;
			secondThread[i].setName(args[i+1]);
			secondThread[i].start();
		}
		Thread.sleep(200);
		
		word arr[] = new word[args.length-1];
		for (int i=0 ; i<args.length-1 ;i++)
		{
			arr[i] = new word() ;
			for(int j=0 ; j<secondThread[i].v1.size() ; j++)
			{
				if(firstThread.BST_Tree.breadthFirst(secondThread[i].v1.elementAt(j)))
				{
					if(arr[i].search(secondThread[i].v1.elementAt(j)))
					{
						arr[i].insertWord(secondThread[i].v1.elementAt(j));
					}
					else
					{
						arr[i].increaseCount(secondThread[i].v1.elementAt(j));
					}
				}
			}
			System.out.println();
		}
		
		Scanner s1=new Scanner(System.in);
		Scanner s2=new Scanner(System.in);
		System.out.println();
	    System.out.println("Welcome to Multi-threading world!");
	    System.out.println("Enter 1 to displaying BST build from vocabulary file!");
	    System.out.println("Enter 2 to display vectors build from input files!");
	    System.out.println("Enter 3 to viewing match words and its frequency!");
	    System.out.println("Enter 4 to search a query!");
	    System.out.println("Enter 5 to exit!");
	    System.out.println("Enter the option!");
	    int option=s1.nextInt();
	    do {
	    	if(option==1)
	    	{
	    		BST_Tree.inorder();
	    		System.out.println();
	    		System.out.println("Displayed In-order traversal of vocabulary file!");
	    	}
	    	else if (option==2)
	    	{
	    		for(int i=0;i<args.length-1;i++)
	    		{
	    			secondThread[i].display();
	    		}
	    	}
	    	else if(option==3)
	    	{
	    		for(int i=0;i<args.length-1;i++)
	    		{
	    			arr[i].display();
	    		}
	    	}
	    	else if(option==4)
	    	{
	    		boolean foundStatus=true;
	    		word tempObj=new word();
	    		System.out.println("Enter the string!");
	    		String tempString=s2.next();
	    		for(int i=1;i<args.length;i++)
	    		{
	    			try {
	    				if(tempObj.querySearch(tempString,secondThread[i].v1))
	    				{
	    					System.out.println("Word found in " + args[i] + "file");
	    					foundStatus=false;
	    					break;
	    				}
	    			}
	    			catch(ArrayIndexOutOfBoundsException e2)
	    			{
	    				e2.printStackTrace();
	    			}
	    			catch(InputMismatchException e3)
	    			{
	    				e3.printStackTrace();
	    			}
	    		}
	    		if(foundStatus)
	    			System.out.println("Not found:(");
	    	}
	    	System.out.println("Enter the option again!");
	    	option=s1.nextInt();
	    }while(option!=5);
	    System.out.println("Exitting :)");
	}

}