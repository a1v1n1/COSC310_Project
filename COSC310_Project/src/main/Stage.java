package main;

public interface Stage {

	//main Stage interface
	public boolean start(); //return false if failed
	public void printFailMessage(); //print a failed message if failed 3 times
	
}
