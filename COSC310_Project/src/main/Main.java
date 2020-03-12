package main;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = true;
		while(run) {
			System.out.println("Enter 'start' to begin");
			
			Scanner in = new Scanner(System.in);
			String input = in.next();
			if(input.equalsIgnoreCase("start")) {
				System.out.println("Connecting...");
				Bot bot = new Bot();
				String botName = bot.name;
				System.out.println("Connected");
				
				if(bot.start()) {
					System.out.println("Disconnected \nWould you like to talk to another agent?");
					//input = in.next();
					//TODO implement response
					System.out.println("assuming yes");
				}else {
					System.out.println("Sorry " + botName + " Couldn't help you out today. \nWould you like to try another agent?");
					//input = in.next();
					//TODO implement response
					System.out.println("assuming yes");
				}
				
				
				
			}
		}
		
	}

}
