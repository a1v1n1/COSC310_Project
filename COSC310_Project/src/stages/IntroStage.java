package stages;
import java.util.Scanner;

import main.Bot;
import main.Stage;
public class IntroStage implements Stage{
	
	public boolean start(Bot b) {
		Bot bot = b;
		System.out.println("");
		Scanner in = new Scanner(System.in);
		System.out.println(cannedGreets1[(int)(Math.random()*cannedGreets1.length)] +bot.name 
				+cannedGreets4[(int)(Math.random()*cannedGreets4.length)]);//Greet user, ask about medical help
		boolean medX = false;
		while(!medX) {
			if(in.next().equalsIgnoreCase("no")) {
				System.out.println("I see. Well, have a good day.");//User does not need help. END
				return false;
			}
			if(in.next().equalsIgnoreCase("yes")) {
				medX = true;
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
	String[] cannedGreets1 = {"Hello, my name is ", "Hi there, I'm ", "Greetings, I'm "};
	String[] cannedGreets2 = {", may I ask your for your name?", ", what's your name?", ", who am I speaking to?"};
	String[] cannedGreets3 = {"Hello ", "Hi ", "Greetings "};
	String[] cannedGreets4 = {", did you need medical attention?", ", are you looking for medical attention?",
			", do you need medical help?"};
	String[] cannedYesNo = {"Pardon me, was that a yes or a no?", "Sorry, I didn't quite catch that. Was that yes or no?"};
	
}
