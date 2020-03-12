package main;

import stages.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bot {
	public String name;

	public Map<Stager, Stage> stages = new HashMap<Stager, Stage>();

	public Bot() {
		name = botNames[(int) Math.random() * botNames.length];
		SampleStage SampleStage = new SampleStage();

		// create stage objects
		stages.put(Stager.SampleStage, SampleStage);
	}

	public boolean start() {
		boolean success = false;
		Stager failedStage = null;
		
		
		for (Stager stage : Stager.values()) { //run through all stages
			//boolean failed = false;
			for(int i = 0; i < 3; i++) { //try to run stage 3 times
				if(stager(stage)) {
					success = true;
					break; //success
				}
					
			}
			//failed
			failedStage = stage; //reducible currently
			if(!success) {
				stages.get(failedStage).printFailMessage();
				break;
			}
			
		}

		
		
		// TESTING CODE START

//		for (int i = 0; i < 3; i++) { // try to run stage 3 times
//			if (stager(Stager.SampleStage)) {
//				success = true;
//				break; // success
//			}
//		}
//		// failed
//		failedStage = Stager.SampleStage;
//		if (!success) {
//			stages.get(failedStage).printFailMessage();
//		}

		// TESTING CODE END
		
//		Scanner in = new Scanner(System.in);
//		String input = in.next();
		
		

		return success;
	}

	public boolean stager(Stager stage) {
		boolean completed = false;

		switch (stage) {
		case SampleStage:
			completed = stages.get(Stager.SampleStage).start();
			break;
		case intro:
			break;
		case need:
			break;
		case immediate:
			break;
		case free:
			break;
		case diagnose:
			break;
		case repeat:
			break;
		case review:
			break;
		case outro:
			break;
		}
		return completed;
	}

	enum Stager {
		SampleStage, // sample
		intro, // Introduction
		need, // Need Medical Attention?
		immediate, // Is it immediate?
		free, // Are you free?
		diagnose, // Get personal info, get diagnosis info and give diagnosis
		repeat, // Would you like to repeat?
		review, // Ask for review
		outro // Ending remarks
	}

	// Resources
	String[] botNames = { "Roboto", "Botricia", "Botrina", "Boton",
			"Botino Montoyo Francisco Nepomuceno Santino Riges" };

}
