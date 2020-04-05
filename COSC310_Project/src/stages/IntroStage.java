package stages;
import java.util.Scanner;

import main.Bot;
import main.Stage;
public class IntroStage implements Stage{
	
	public boolean start(Bot b) {
		int unin = 0;
		Bot bot = b;
		System.out.println("");
		Scanner in = new Scanner(System.in);
		System.out.println(cannedGreets1[(int)(Math.random()*cannedGreets1.length)] +bot.name 
				+cannedGreets2[(int)(Math.random()*cannedGreets2.length)]);//Greet user, ask about medical help
		boolean medX = false;
		while(!medX) {
			String answer = in.next();
			if(answer.equalsIgnoreCase("no")) {
				System.out.println("I see. Well, have a good day.");//User does not need help. END
				return false;
			}
			if(answer.equalsIgnoreCase("yes")) {
				medX = true;
			}
			else {
				if(unin<5) {
					System.out.println(cannedTopic[(int)(Math.random()*cannedTopic.length)]);//not yes or no
				}
				else {
					System.out.println("It seems that I cannot help you, have a good day.");
					return false;
				}
				unin++;
			}
		}
		return true;//continue to ImmediateStage
	}
	
	public void printFailMessage() {
		System.out.println("Intro stage failed. Returning to main for another \"agent\"");
	}
	
	
	//Resources
	String[] cannedGreets1 = {"Hello, my name is ", "Hi there, I'm ", "Greetings, I'm "};
	String[] cannedGreets2 = {", did you need medical attention?", ", are you looking for medical attention?",
			", do you need medical help?"};
	String[] cannedTopic = {"Sorry, I don't know much about that topic. Could I help you with getting medical help or [TOPIC TWO]?",
			"I'm not trained on that topic. Do you want help with medical attention or [TOPIC TWO]?", 
			"I can only help you in getting medical attention and [TOPIC TWO]. Would you like help with that?", 
			"I'm sorry did you need help with getting medical attention or [TOPIC TWO]?",
			"That's not something I'm familiar with. Can I help you with getting medical help or [TOPIC TWO]?"};
	
}