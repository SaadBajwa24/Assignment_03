import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class readFile extends Thread{

	String fileName;
	Vector<String> v1 = new Vector<String>(1);
	public readFile(String n) {
		fileName=n;
	}
	// Overriding run method
	public void run(){
		Scanner fileScanner = new Scanner(System.in) ;
		try {
				String tempData="";
				fileScanner = new Scanner(new File(fileName));
			    while(fileScanner.hasNext()){
			        tempData = fileScanner.next();
			        v1.add(tempData);
			    }
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public void display() {
		System.out.println("The data is: " + v1);
	}
}
