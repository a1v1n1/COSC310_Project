package stages;
import main.Bot;
import main.GuiBot;
import main.InputProcess;
import main.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.*;

public class Diagnosis implements Stage {
	
	Map<String, Boolean> badBodyParts = new HashMap<String, Boolean>();
	
	String[] bodyParts = {
			"heart",
			"blood",
			"allergy",
			"skin",
			"hair",
			"nail",
			"scar",
			"mole",
			"acne",
			"flu",
			"chronic",
			"arm",
			"hand",
			"finger",
			"stomach",
			"bowel",
			"pancreas",
			"liver",
			"gallbladder",
			"diarrhea",
			"colon",
			"ulser",
			"brain",
			"nerve",
			"cancer",
			"eye",
			"ear",
			"nose",
			"throat",
			"sinus",
			"head",
			"neck",
			"lung",
			"mouth",
			"foot",
			"ankle",
			"leg",
	};
	
	boolean firstLineOut = false;
	
	public Diagnosis() {
		
	}
	
	public boolean start(Bot bot) {
		badBodyParts.clear();
		for(String bodyPart : bodyParts ) {
			badBodyParts.put(bodyPart, false);
		}
		//Scanner in = new Scanner(System.in);
		String input = "";
		//in.useDelimiter("\\n");
		
		String title = "";
		if(bot.userSex.equalsIgnoreCase("M"))
			title = "Mister ";
		if(bot.userSex.equalsIgnoreCase("F"))
			title = "Miss ";
		
		
		GuiBot.println("Alright " + title + bot.username + ", does your condition involve pain at all?");
		try {
			input = GuiBot.getInput();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int number = 5;
		if(input.toLowerCase().contains("yes") || input.toLowerCase().contains("yea")) {
			GuiBot.println("I'm sorry to hear that. On a scale of 1-10 how would you rate your pain? With 1 being pretty much unnoticable and 10 being unbearable pain");
			try {
				input = GuiBot.getInput();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				number = Integer.parseInt(input.replaceAll("\\D+", ""));
			}
			catch (Exception e) {
				GuiBot.println("couldn't recognize a number"); //for testing
				number = 5;
			}
			
			GuiBot.println("Where is this pain located?");
			
		}
		else {
			GuiBot.println("I see. What seems to be bothering you today?");
		}
		
		boolean hasProblem = true;
		while(hasProblem) {
			try {
				input = GuiBot.getInput();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(String bodyPart : bodyParts) {
				if(input.toLowerCase().contains(bodyPart)||InputProcess.check(input, bodyPart)) {
					badBodyParts.replace(bodyPart, true);
				}
			}
			
			GuiBot.println("Is there anything else related to your health you are concerned about?");
			try {
				input = GuiBot.getInput();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!(input.toLowerCase().contains("yes") || input.toLowerCase().contains("yea"))) {
				hasProblem = false;
				GuiBot.println("Alright, Here's my recommendation:");
			}
			else {
				GuiBot.println("Ok, what else is bothering you today?");
			}
		}
		
		firstLineOut = false;
		
		boolean underNineteen = false;
		for(String ageIntCheck : ageInt) {
			if(bot.userAge.toLowerCase().contains(ageIntCheck))
				underNineteen = true;
		}
		for(String ageCheck : ageList) {
			if(bot.userAge.toLowerCase().contains(ageCheck))
				underNineteen = true;
		}
		for(String ageTen : ageTens) {
			if(bot.userAge.toLowerCase().contains(ageTen))
				underNineteen = false;
		}
		
		if(underNineteen)
			printer(firstLineOut, "You should go see a Pediatrician. \nA pediatrician deals with humans from birth to young adulthood");
		
		if(badBodyParts.get("heart") || badBodyParts.get("blood"))
			printer(firstLineOut, "You should go see a Cardiologist. \nA cardiologist deals with heart and blood vessels. People see them for conditions such as heart failure, high blood pressure or an irregular heartbeat");
		
		if(badBodyParts.get("allergy"))
			printer(firstLineOut, "You should go see an Allergist. \nAn allergist treat immune system disorders such as asthma, eczema, food allergies, insect sting allergies, and some autoimmune diseases");
		
		if(badBodyParts.get("skin") || badBodyParts.get("hair") || badBodyParts.get("nail") || badBodyParts.get("scar") || badBodyParts.get("mole") || badBodyParts.get("acne"))
			printer(firstLineOut, "You should go see a Dermatologist. \nA dermatologist deals with problems involving skin, hair, nails, moles, scars, acne, and skin allergies");
		
		if(badBodyParts.get("flu") || badBodyParts.get("chronic"))
			printer(firstLineOut, "You should go see a Family Physician. \nA Family Physician does routine checkups and gives you flu, immunization shots, and handle long term medical conditions");
		
		if(badBodyParts.get("stomach") || badBodyParts.get("bowel") || badBodyParts.get("pancreas") || badBodyParts.get("liver") || badBodyParts.get("gallbladder") || badBodyParts.get("diarrhea") || badBodyParts.get("colon") || badBodyParts.get("ulser"))
			printer(firstLineOut, "You should go see a Gastroenterologist. \nA gastroenterologist deals with digestive organs including stomach, bowels, pancreas, liver, and gallbladder.");
		
		if(badBodyParts.get("brain") || badBodyParts.get("nerve"))
			printer(firstLineOut, "You should go see a Neurologist. \nA neurologist specializes in the nervous system including the brain, spinal cord and nerves. They treat strokes, brain and spinal tumors, epilepsy, Parkinson's, and Alzheimer's");
		
		if(badBodyParts.get("cancer"))
			printer(firstLineOut, "You should go see an Oncologist. \nAn oncologist is a cancer specialist. They do chemotherapy and work with radiation and surgeons to care for someone with cancer");
		
		if(badBodyParts.get("eye"))
			printer(firstLineOut, "You should go see an Ophthalmologist. \nAn ophathalmologist is the eye doctor. They deal with anything medical to do with your eyes including operations, deseases, and prescriptions");
		
		if(badBodyParts.get("ear") || badBodyParts.get("nose") || badBodyParts.get("throat") || badBodyParts.get("sinus") || badBodyParts.get("head") || badBodyParts.get("neck") || badBodyParts.get("lung")|| badBodyParts.get("mouth"))
			printer(firstLineOut, "You should go see an Otolaryngologist. \nAn otolaryngologist treats diseases in the ears, nose, throat, sinuses, head, neck and respiratory system");
		
		if(badBodyParts.get("foot") || badBodyParts.get("ankle") || badBodyParts.get("leg"))
			printer(firstLineOut, "You should go see a Podiatrist. \nA podiatrist deals with abnormal conditions in the lower human limbs");
		
		if(bot.userSex.equalsIgnoreCase("f"))
			printer(firstLineOut, "You may want to see a gynecologist. \nA gynecologist deals with women's health including pregnancy, childbirth and overall wommen's reproductive health");
		
		GuiBot.println("Would you like me to attempt to diagnose you again?");
		try {
			input =  GuiBot.getInput();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(input.toLowerCase().contains("yes") ||InputProcess.check(input, "yes")) {
			this.start(bot); //repeat diagnosis
		}
		
		return true;
	}
	
	public void printer(Boolean firstLineOut, String toPrint) {
		if(firstLineOut) {
			GuiBot.print("Also, ");
		}
		firstLineOut = true;
		GuiBot.println(toPrint);
	}
	
	public boolean checker(String[] array) {
		boolean contains = false;
		
		
		
		return contains;
	}
	
	//Resources
	String[] ageList = {" one ", " two ", " three ", " four ", " five ", " six ", " seven ", " eight ", " nine ", " ten ",
			" eleven ", " twelve ", " thirteen ", " fourteen ", " fifteen ", " sixteen ", " seventeen ", " eighteen "};
	String[] ageInt = {" 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 ", " 7 ", " 8 ", " 9 ", " 10 ", " 11 ", " 12 ", " 13 ", " 14 ",
			" 15 ", " 16 ", " 17 ", " 18 "};
	String[] ageTens = {" twenty ", " thirty ", " forty ", " fifty ", " sixty ", " seventy ", " eighty ", " ninety "};
	
}

