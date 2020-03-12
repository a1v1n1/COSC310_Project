package stages;
import java.util.Scanner;

import main.Stage;
public class SampleStage implements Stage{

	public boolean start() {
		System.out.println("this is a sample stage. Enter 'c' to continue or anything else to fail");
		Scanner in = new Scanner(System.in);
		if(in.next().equalsIgnoreCase("c")) {
			System.out.println("stage complete.");
			return true;
		}
		return false;
	}
	
	public void printFailMessage() {
		System.out.println("Sample stage failed. Returning to main for another \"agent\"");
	}
	
	
}
