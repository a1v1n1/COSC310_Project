package stages;
import java.util.Scanner;

import main.Bot;
import main.Stage;
public class FreeStage implements Stage{
	
	public boolean start(Bot b) {
		Bot bot = b;
		Scanner in = new Scanner(System.in);
		System.out.println(cannedGreets1[(int)(Math.random()*cannedGreets1.length)]);//Ask if user is free to answer questions
		boolean bCheck = false;
		while(!bCheck) {
			String answer = in.next();
			if(answer.equalsIgnoreCase("no")) {
				System.out.println("I see. Well, have a good day.");//User does not need help. END
				return false;
			}
			if(answer.equalsIgnoreCase("yes")) {
				bCheck = true;
			}
			else
				System.out.println(cannedYesNo[(int)(Math.random()*cannedYesNo.length)]);//not yes or no
		}
		System.out.println(cannedGreets2[(int)(Math.random()*cannedGreets2.length)]);//Ask for user name
		bot.username = in.next(); //Save user name
		System.out.println(cannedGreets3[(int)(Math.random()*cannedGreets3.length)] +bot.username +", what is your sex?");
		bCheck = false;
		while(!bCheck) {//Ask for user sex
			String s = in.next();
			if(s.equalsIgnoreCase("male") || s.equalsIgnoreCase("boy") || s.equalsIgnoreCase("M")) {
				bot.userSex = "M";//User is male
				bCheck = true;
			}
			if(s.equalsIgnoreCase("female") || s.equalsIgnoreCase("girl") || s.equalsIgnoreCase("F")) {
				bot.userSex = "F";//user is female
				bCheck = true;
			}
			else
				System.out.println(cannedSex[(int)(Math.random()*cannedSex.length)]);//not M or F
		}
		System.out.println(cannedGreets4[(int)(Math.random()*cannedGreets4.length)]);//Ask for user age
		bCheck = false;
		while(!bCheck) {
			if(in.hasNextInt()) {
				bot.userAge = in.nextInt();//Save user age
				bCheck = true;
			}
			else
				System.out.println("Please only input numbers as your age.");//age not in int
		}
		
		
		return true;//continue to DiagnoseStage
	}
	
	public void printFailMessage() {
		System.out.println("Free stage failed. Returning to main for another \"agent\"");
	}
	
	//Resources
	String[] cannedGreets1 = {"Alright, I'm here to help you get medical attention. Are you free to answer a few questions?"
			, "Okay, I'm here to help you get medical attention. Do you have time to answer a few questions?"};
	String[] cannedGreets2 = {"Great. May I ask for your name?", "Alright. What's your name?",
			"Okay, how would you like me to call you?"};
	String[] cannedGreets3 = {"Hello ", "Hi ", "Greetings "};
	String[] cannedGreets4 = {"Okay, and how old are you?", "Alright, how old are you?"};
	String[] cannedYesNo = {"Pardon me, was that a yes or a no?", "Sorry, I didn't quite catch that. Was that yes or no?"};
	String[] cannedSex = {"Could you repeat that? Are you a male or a female?",
			"Sorry, I didn't quite catch that. Was that male or female?"};
	
}

