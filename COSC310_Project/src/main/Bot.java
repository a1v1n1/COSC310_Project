package main;

import stages.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bot implements Runnable{
	public String name;
	public String username;
	public String userAddress;
	public String userSex;
	public String userAge;
	public String userReview;
	public String userRating;
	public Map<Stager, Stage> stages = new HashMap<Stager, Stage>();

	
	
	public Bot() {
		name = botNames[(int) (Math.random() * botNames.length)];
		//SampleStage SampleStage = new SampleStage();
		//IntroStage IntroStage = new IntroStage();
		// create stage objects
		//stages.put(Stager.SampleStage, SampleStage);
		stages.put(Stager.intro, new IntroStage());
		stages.put(Stager.immediate, new ImmediateStage());
		stages.put(Stager.free, new FreeStage());
		stages.put(Stager.diagnose, new Diagnosis());
		stages.put(Stager.review, new Review());
	}

	public void run() {
		boolean success = true;
		//Stager failedStage = null;
		
		for(Stager stage : Stager.values()) {
			if(!stager(stage)) { //if stage returns false
				break;
			}
		}
		
		//return success;
		
		//OLD CODE START
		
//		for (Stager stage : Stager.values()) { //run through all stages
//			//boolean failed = false;
//			boolean stageFailed = true;
//			for(int i = 0; i < 3; i++) { //try to run stage 3 times
//				if(stager(stage)) {
//					stageFailed = false;
//					break; //success
//				}
//					
//			}
//			//failed
//			if(stageFailed) {
//				success = false;
//				failedStage = stage; //reducible currently
//				stages.get(failedStage).printFailMessage();
//				break;
//			}
//			
//		}
		
		//OLD CODE END
		
		
		
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
		
	}

	public boolean stager(Stager stage) {
		boolean completed = false;

		switch (stage) {
//		case SampleStage:
//			completed = stages.get(Stager.SampleStage).start(this);
//			break;
		case intro:
			completed = stages.get(Stager.intro).start(this);
			break;
//		case need:
//			completed = true;
//			break;
		case immediate:
			completed = stages.get(Stager.immediate).start(this);
			break;
		case free:
			completed = stages.get(Stager.free).start(this);
			break;
		case diagnose:
			completed = stages.get(Stager.diagnose).start(this);
			break;
//		case repeat:
//			completed = true;
//			break;
		case review:
			completed = stages.get(Stager.review).start(this);
//			break;
//		case outro:
//			completed = true;
//			break;
		}
		return completed;
	}

	enum Stager {
		//SampleStage, // sample
		intro, // Introduction
		//need, // Need Medical Attention?
		immediate, // Is it immediate?
		free, // Are you free?
		diagnose, // Get personal info, get diagnosis info and give diagnosis
		//repeat, // Would you like to repeat?
		review, // Ask for review
		//outro // Ending remarks
	}

	// Resources
	String[] botNames = { "Roboto", "Botricia", "Botrina", "Boton",
			"Botino Montoyo Francisco Nepomuceno Santino Riges" };

}