package stages;
import java.util.Scanner;

import main.Bot;
import main.GuiBot;
import main.Stage;
public class Review implements Stage{
	
	public boolean start(Bot b) {
		Bot bot = b;
		//Scanner in = new Scanner(System.in);
		System.out.println(cannedReview1[(int)(Math.random()*cannedReview1.length)]);//Ask for user feedback
		bot.userReview =  GuiBot.getInput();
		System.out.println(cannedReview2[(int)(Math.random()*cannedReview2.length)]);//Ask for 1 to 5 rating
		boolean bCheck = false;
		while(!bCheck) {
			String rating = GuiBot.getInput();
			for(String ageCheck : rateList) {
				if(rating.toLowerCase().contains(ageCheck)) {
					bot.userRating = rating;//Rating obtained
					bCheck = true;
				}
			}
			if(!bCheck)//Number not within 1 and 5
				System.out.println(cannedReview3[(int)(Math.random()*cannedReview3.length)]);
		}
		System.out.println("Thank you for your review! I hope you have a gre-");
		
		return true;//continue to DiagnoseStage
	}
	
	public void printFailMessage() {
		System.out.println("Review stage failed. Returning to main for another \"agent\"");
	}
	
	//Resources
	String[] cannedReview1 = {"Alright, can you tell me how I did today?"
			, "Okay, If you have time, could you tell me how I did today?"};
	String[] cannedReview2 = {"Okay, and how would you rate me out of 5?", "I've noted that down. How did I do, from 1 to 5?"};
	String[] cannedReview3 = {"Uh, please only put numbers between 1 and 5.", "Those numbers aren't between 1 and 5"};
	String[] rateList = {"one", "1", "two", "2", "three", "3", "four", "4", "five", "5"};
	
}

