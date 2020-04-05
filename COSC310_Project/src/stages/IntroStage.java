package stages;
import java.io.IOException;
import java.util.Scanner;

import main.Bot;
import main.GuiBot;
import main.Stage;
public class IntroStage implements Stage{
	
	public boolean start(Bot b) {
		int unin = 0;
		Bot bot = b;
		//Scanner in = new Scanner(System.in);
		GuiBot.println(cannedGreets1[(int)(Math.random()*cannedGreets1.length)] +bot.name 
				+cannedGreets2[(int)(Math.random()*cannedGreets2.length)]);//Greet user, ask about medical help
		boolean medX = false;
		while(!medX) {
//			try {
//				while(System.in.available() == 0) {
//					System.out.println("waiting for input");
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			String answer = GuiBot.getInput();
//			while(answer.equals("")) {
//				answer = GuiBot.getInput();
////				System.out.println("waiting " + answer);
//				try {
//				Thread.sleep(1);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
			
			//String answer = in.next();
			if(answer.toLowerCase().contains("no")) {
				GuiBot.println("I see. Well, have a good day.");//User does not need help. END
				return false;
			}
			if(answer.toLowerCase().contains("yes")) {
				medX = true;
			}
			else {
				if(unin<5) {
					GuiBot.println(cannedTopic[(int)(Math.random()*cannedTopic.length)]);//not yes or no
				}
				else {
					GuiBot.println("It seems that I cannot help you, have a good day.");
					return false;
				}
				unin++;
			}
		}
		return true;//continue to ImmediateStage//
	}
	
	public void printFailMessage() {
		GuiBot.println("Intro stage failed. Returning to main for another \"agent\"");
	}
	
	
	//Resources
	String[] cannedGreets1 = {"Hello, my name is ", "Hi there, I'm ", "Greetings, I'm "};
	String[] cannedGreets2 = {", did you need medical attention?", ", are you looking for medical attention?",
			", do you need medical help?"};
	String[] cannedTopic = {"Sorry, I don't know much about that topic. Could I help you with getting medical help?",
			"I'm not trained on that topic. Do you want help with medical attention?", 
			"I can only help you in getting medical attention. Would you like help with that?", 
			"I'm sorry did you need help with getting medical attention?",
			"That's not something I'm familiar with. Can I help you with getting medical help?"};
	
}