package stages;
import java.util.Scanner;

import main.Bot;
import main.GuiBot;
import main.Stage;
public class ImmediateStage implements Stage{
	
	public boolean start(Bot b) {
		Bot bot = b;
		//Scanner in = new Scanner(System.in);
		GuiBot.println(cannedCheck1[(int)(Math.random()*cannedCheck1.length)]);//Ask about immediate medical help
		boolean EMCheck = false;
		while(!EMCheck) {
			String answer = GuiBot.getInput();
			if(answer.toLowerCase().contains("no")) { //User does not need 911. Continue to Free stage.
				return true;
			}
			if(answer.toLowerCase().contains("yes")) {//User needs 911. Ask for address
				EMCheck = true;
			}
			else
				GuiBot.println(cannedYesNo[(int)(Math.random()*cannedYesNo.length)]);//not yes or no
		}
		GuiBot.println("Alright, please give us your address and we'll dispatch 911 to that address.");
		EMCheck = false;
		while(!EMCheck) {
			bot.userAddress = GuiBot.getInput();
			GuiBot.println("Is this the correct address: /n" +bot.userAddress);
			boolean ACheck = false;
			while(!ACheck) {
				String answer = GuiBot.getInput();
				if(answer.toLowerCase().contains("yes")) { //Address confirmed. Send message to 911
					ACheck = true;
					EMCheck = true;
				}
				if(answer.toLowerCase().contains("no")) {
					GuiBot.println("Okay, what is the correct address?");
					ACheck = true;
				}
				else
					GuiBot.println(cannedYesNo[(int)(Math.random()*cannedYesNo.length)]);//not yes or no
			}
		}
		GuiBot.println("We're sending 911 your way right now. Please stay where you are until they arrive.");
		//Implement calling 911 maybe
		return false;//911 called for user. END
	}
	
	public void printFailMessage() {
		GuiBot.println("Immediate stage failed. Returning to main for another \"agent\"");
	}
	
	//Resources
	String[] cannedCheck1 = {"I see. Do you need immediate emergency medical attention?", 
			"Okay, do you feel like you require immediate emergency medical attention?"};
	String[] cannedYesNo = {"Pardon me, was that a yes or a no?", "Sorry, I didn't quite catch that. Was that yes or no?"};
	
}

