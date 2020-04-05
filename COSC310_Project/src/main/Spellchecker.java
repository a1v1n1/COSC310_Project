package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spellchecker {

	public static void main(String []args){
		//test 
		String []list=new String [5];
		list[0]="yes";
		list[1]="no";
		list[2]="male";
		list[3]="female";
		list[4]="shoulder";
		String input="shoulder pain";
			if (spellCheck(input,list)){
			System.out.println("no errors");
			}
			else {
				System.out.println("spell error");
		}
	}
	public static boolean spellCheck(String input, String[] dictionary) {
		String currentCheck = "";
		boolean noError = true;
		Scanner spellChecker = new Scanner(input);
		spellChecker.useDelimiter("\\s+");
		while (spellChecker.hasNext()) {
			currentCheck = spellChecker.next();
			if (!isSpecial(currentCheck)) {
				if (!checkWord(currentCheck, dictionary)) {
					System.out.println(currentCheck + "is not spelled correctly");
					noError = false;
				}
			}
		}
		return noError;
	}
 
	public static boolean isSpecial(String input){
		Pattern pattern =Pattern.compile("[a-z0-9]",Pattern.CASE_INSENSITIVE);
		Matcher match=pattern.matcher(input);
		return match.find();
	}

	public static boolean checkWord(String input, String[] dictionary) {
		boolean validity = false;
		int length = dictionary.length;
		int i = 0;
		while (!validity && i < length) {
			if (input.trim().equalsIgnoreCase(dictionary[i])) {
				validity = true;
			}
			i++;
		}
		return validity;
	}
}

