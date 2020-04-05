package stages;
import java.util.Scanner;

import main.Bot;
import main.GuiBot;
import main.Stage;
public class FreeStage implements Stage{
	
	public boolean start(Bot b) {
		Bot bot = b;
		//Scanner in = new Scanner(System.in);
		GuiBot.println(cannedGreets1[(int)(Math.random()*cannedGreets1.length)]);//Ask if user is free to answer questions
		boolean bCheck = false;
		while(!bCheck) {
			String answer = GuiBot.getInput();
			if(answer.toLowerCase().contains("no")) {
				GuiBot.println("I see. Well, have a good day.");//User does not need help. END
				return false;
			}
			if(answer.toLowerCase().contains("yes")) {
				bCheck = true;
			}
			else
				GuiBot.println(cannedYesNo[(int)(Math.random()*cannedYesNo.length)]);//not yes or no
		}
		GuiBot.println(cannedGreets2[(int)(Math.random()*cannedGreets2.length)]);//Ask for user name
		bot.username = GuiBot.getInput(); //Save user name
		GuiBot.println(cannedGreets3[(int)(Math.random()*cannedGreets3.length)] +bot.username +", what is your sex?");
		bCheck = false;
		while(!bCheck) {//Ask for user sex
			String s = GuiBot.getInput();
			if(s.toLowerCase().contains("male") || s.toLowerCase().contains("boy") || s.toLowerCase().contains("m")) {
				bot.userSex = "M";//User is male
				bCheck = true;
			}
			else if(s.toLowerCase().contains("female") || s.toLowerCase().contains("girl") || s.toLowerCase().contains("f")) {
				bot.userSex = "F";//user is female
				bCheck = true;
			}
			else
				GuiBot.println(cannedSex[(int)(Math.random()*cannedSex.length)]);//not M or F
		}
		GuiBot.println(cannedGreets4[(int)(Math.random()*cannedGreets4.length)]);//Ask for user age
		bCheck = false;
		while(!bCheck) {
			String age = " "+GuiBot.getInput()+" ";
			for(String ageTensCheck : ageTens) {
				if(age.toLowerCase().contains(ageTensCheck)) {
					bot.userAge = ageTensCheck;//Save user tens age
					//bCheck = true;
					for(String ageCheck : ageList) {
						if(age.toLowerCase().contains(ageCheck)) {
							bot.userAge += ageCheck;
							break;
						}
					}
					bCheck = true;
					break;
				}
			}
			for(String ageIntCheck : intAge) {
				if(age.toLowerCase().contains(ageIntCheck)) {
					bot.userAge = ageIntCheck;
					bCheck = true;
				}
			}
			if(!bCheck)
				GuiBot.println("Please only input numbers as your age.");//age not in int
		}
		
		
		return true;//continue to DiagnoseStage
	}
	
	public void printFailMessage() {
		GuiBot.println("Free stage failed. Returning to main for another \"agent\"");
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
	String[] ageList = {" one ", " two ", " three ", " four ", " five ", " six ", " seven ", " eight ", " nine ", " ten "};
	String[] ageTens = {" twenty ", " thirty ", " forty ", " fifty ", " sixty ", " seventy ", " eighty ", " ninety ", " eleven ",
			" twelve ", " thirteen ", " fourteen ", " fifteen ", " sixteen ", " seventeen ", " eighteen ", " nineteen "};
	String[] intAge = {" 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 ", " 7 ", " 8 ", " 9 ", " 10 ", " 11 ", " 12 ", " 13 ", " 14 ",
			" 15 ", " 16 ", " 17 ", " 18 ", " 19 ", " 20 ", " 21 ", " 22 ", " 23 ", " 24 ", " 25 ", " 26 ", " 27 ", " 28 ", " 29 ",
			" 30 ", " 31 ", " 32 ", " 33 ", " 34 ", " 35 ", " 36 ", " 37 ", " 38 ", " 39 ", " 40 ", " 41 ", " 42 ", " 43 ", " 44 ",
			" 45 ", " 46 ", " 47 ", " 48 ", " 49 ", " 50 ", " 51 ", " 52 ", " 53 ", " 54 ", " 55 ", " 56 ", " 57 ", " 58 ", " 59 ",
			" 60 ", " 61 ", " 62 ", " 63 ", " 64 ", " 65 ", " 66 ", " 67 ", " 68 ", " 69 ", " 70 ", " 71 ", " 72 ", " 73 ", " 74 ",
			" 75 ", " 76 ", " 77 ", " 78 ", " 79 ", " 80 ", " 81 ", " 82 ", " 83 ", " 84 ", " 85 ", " 86 ", " 87 ", " 88 ", " 89 ",
			" 90 ", " 91 ", " 92 ", " 93 ", " 94 ", " 95 ", " 96 ", " 97 ", " 98 ", " 99 "};
}

