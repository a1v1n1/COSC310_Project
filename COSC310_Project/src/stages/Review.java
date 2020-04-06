package stages;
import java.io.IOException;
import java.util.Scanner;

import main.Bot;
import main.GuiBot;
import main.Stage;
public class Review implements Stage{
	
	public boolean start(Bot b) {
		Bot bot = b;
		//Scanner in = new Scanner(System.in);
		GuiBot.println(cannedReview1[(int)(Math.random()*cannedReview1.length)]);//Ask for user feedback
		try {
			bot.userReview =  GuiBot.getInput();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		GuiBot.println(cannedReview2[(int)(Math.random()*cannedReview2.length)]);//Ask for 1 to 5 rating
		boolean bCheck = false;
		while(!bCheck) {
			String rating = "";
			try {
				rating = GuiBot.getInput();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(String rate : rateList) {
				if(rating.toLowerCase().contains(rate)) {
					bot.userRating = rating;//Rating obtained
					bCheck = true;
				}
			}
			if(!bCheck)//Number not within 1 and 5
				GuiBot.println(cannedReview3[(int)(Math.random()*cannedReview3.length)]);
		}
		GuiBot.println("Thank you for your review! I hope you have a gre-");
		
		return true;//continue to DiagnoseStage
	}
	
	public void printFailMessage() {
		GuiBot.println("Review stage failed. Returning to main for another \"agent\"");
	}
	
	//Resources
	String[] cannedReview1 = {"Alright, can you tell me how I did today?"
			, "Okay, If you have time, could you tell me how I did today?"};
	String[] cannedReview2 = {"Okay, and how would you rate me out of 5?", "I've noted that down. How did I do, from 1 to 5?"};
	String[] cannedReview3 = {"Uh, please only put numbers between 1 and 5.", "Those numbers aren't between 1 and 5"};
	String[] rateList = {"one", "1", "two", "2", "three", "3", "four", "4", "five", "5"};
	
}

