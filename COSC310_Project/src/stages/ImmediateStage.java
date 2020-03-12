package stages;
import java.util.Scanner;

import main.Bot;
import main.Stage;
public class ImmediateStage implements Stage{
	
	public boolean start(Bot b) {
		Bot bot = b;
		System.out.println("");
		Scanner in = new Scanner(System.in);
		System.out.println(cannedCheck1[(int)(Math.random()*cannedCheck1.length)]);//Ask about immediate medical help
		boolean EMCheck = false;
		while(!EMCheck) {
			if(in.next().equalsIgnoreCase("no")) { //User does not need 911. Continue to Free stage.
				return true;
			}
			if(in.next().equalsIgnoreCase("yes")) {
				EMCheck = true;
			}
			else
				System.out.println(cannedYesNo[(int)(Math.random()*cannedYesNo.length)]);//not yes or no
		}
		System.out.println("Alright, please give us your address and we'll dispatch 911 to that address.");
		EMCheck = false;
		while(!EMCheck) {
			bot.userAddress = in.nextLine();
			System.out.println("Is this the correct address: /n" +bot.userAddress);
			boolean ACheck = false;
			while(!ACheck) {
				if(in.next().equalsIgnoreCase("yes")) { //Address confirmed. Send message to 911
					ACheck = true;
					EMCheck = true;
				}
				if(in.next().equalsIgnoreCase("no")) {
					System.out.println("Okay, what is the correct address?");
					ACheck = true;
				}
				else
					System.out.println(cannedYesNo[(int)(Math.random()*cannedYesNo.length)]);//not yes or no
			}
		}
		System.out.println("We're sending 911 your way right now. Please stay where you are until they arrive.");
		//Implement calling 911 maybe
		return false;//911 called for user. END
	}
	
	public void printFailMessage() {
		System.out.println("Intro stage failed. Returning to main for another \"agent\"");
	}
	
	//Resources
	String[] cannedCheck1 = {"I see. Do you need immediate emergency medical attention?", 
			"Okay, do you feel like you require immediate emergency medical attention?"};
	String[] cannedYesNo = {"Pardon me, was that a yes or a no?", "Sorry, I didn't quite catch that. Was that yes or no?"};
	
}
