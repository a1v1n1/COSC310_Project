package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;

public class GuiBot {
	//BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(new byte[0]));
	static String inputString = "";
	static JTextArea text;
	public static String getInput() {
		while(inputString.equals("")) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String buffer = inputString;
		inputString = "";
		return buffer;
		
		
	}
	
	public static void print(String toPrint) {
		text.append(toPrint);
	}
	
	public static void println(String toPrint) {
		print(toPrint + "\n");
	}
	
	public boolean makeGui() {
		boolean success = false;
		//System.setIn(in);
		
		Bot bot = new Bot();
		String name = bot.name;
		
		//WINDOW INITIATION
		JFrame frame = new JFrame("Agent: " + name);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(1000,400);
		Container con = frame.getContentPane();
		
		//PANEL INITIATION
		JPanel top = new JPanel();
		JPanel left = new JPanel();
		JPanel middle = new JPanel();
		JPanel right = new JPanel();
		JPanel bottom = new JPanel();
		
		//TOP
		JLabel welcome = new JLabel("WELCOME!");
		top.add(welcome);
		con.add(top,BorderLayout.NORTH);
		
		//MIDDLE
		text = new JTextArea();
		JScrollPane scroll = new JScrollPane(text);
		scroll.setPreferredSize(new Dimension(800,200));
		middle.add(scroll);
		con.add(middle,BorderLayout.CENTER);
		
		//MIDDLE CODE
		text.setEditable(false);
		//text.setText("test");
		
		//BOTTOM
		JLabel inputLabel = new JLabel("Input: ");
		bottom.add(inputLabel);
		
		JTextField input = new JTextField();
		input.setPreferredSize(new Dimension(300,40));
		bottom.add(input);
		
		JButton send = new JButton("Send");
		send.setPreferredSize(new Dimension(80,40));
		bottom.add(send);
		
		con.add(bottom, BorderLayout.SOUTH);
		
		//BOTTOM CODE
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userInput = input.getText();
				//sendToBot(userInput);
				inputString = userInput;
				input.setText("");
				
			}
		});
		
		
		frame.setVisible(true);
		
		
		
		//BOT LOOP
		
		new Thread(bot).start();
		
//		if(bot.start()) {
//			
//			success = true;
//		}
//		else {
//			success = false;
//		}
		
		
		
		
		
		return success;
	}
	
}
