package stages;
import java.util.Scanner;

import main.Bot;
import main.Stage;
public class FreeStage implements Stage{
	
	public boolean start(Bot b) {
		Bot bot = b;
		Scanner in = new Scanner(System.in);
		System.out.println(cannedGreets1[(int)(Math.random()*cannedGreets1.length)]);//Ask if user is free to answer questions
		boolean hasTime = false;
		while(!hasTime) {
			if(in.next().equalsIgnoreCase("no")) {
				System.out.println("I see. Well, have a good day.");//User does not need help. END
				return false;
			}
			if(in.next().equalsIgnoreCase("yes")) {
				hasTime = true;
			}
			else
				System.out.println(cannedYesNo[(int)(Math.random()*cannedYesNo.length)]);//not yes or no
		}
		return true;//continue to ImmediateStage
	}
	
	public void printFailMessage() {
		System.out.println("Intro stage failed. Returning to main for another \"agent\"");
	}
	
	//Resources
	String[] cannedGreets1 = {"Alright, I'm here to help you get medical attention. Are you free to answer a few questions?"
			, "Okay, I'm here to help you get medical attention. Do you have time to answer a few questions?"};
	String[] cannedGreets2 = {", may I ask your for your name?", ", what's your name?", ", who am I speaking to?"};
	String[] cannedGreets3 = {"Hello ", "Hi ", "Greetings "};
	String[] cannedGreets4 = {", did you need medical attention?", ", are you looking for medical attention?",
			", do you need medical help?"};
	String[] cannedYesNo = {"Pardon me, was that a yes or a no?", "Sorry, I didn't quite catch that. Was that yes or no?"};
	
}
