package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class GuiBot {
	//BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(new byte[0]));
	static String inputString = "";
	static JTextArea text;
	static Bot bot;
	static ChatbotSocket botSocket;
	
	//GET USER INPUT
	public synchronized static String getInput() {
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
		text.append("<" + bot.name.toUpperCase() + ">:\n" + toPrint);
	}
	
	public static void println(String toPrint) {
		print(toPrint + "\n");
	}
	

	//SOCKET BOT COMMUNICATION
	public synchronized static String getInput2() throws IOException {
		while(!botSocket.input.ready());
		String in = botSocket.input.readLine();
		text.append("<POTATO BOT>:\n" + in);
		return in;
	}
	
	public static void print2(String toPrint) {
		botSocket.output.append(toPrint);
		//botSocket.output.
		botSocket.output.flush();
		text.append("\n<" + bot.name.toUpperCase() + ">:\n" + toPrint);
	}
	
	public static void println2(String toPrint) {
		botSocket.output.append(toPrint + "\n");
		botSocket.output.flush();
		text.append("\n<" + bot.name.toUpperCase() + ">:\n" + toPrint + "\n");
	}
	
	
	
	
	public boolean makeGui() {
		boolean success = false;
		try {
			botSocket = new ChatbotSocket();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} 
		
		bot = new Bot();
		String name = bot.name;
		
		//WINDOW INITIATION
		JFrame frame = new JFrame("Agent: " + name);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(1000,700);
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
		//bar = scroll.getVerticalScrollBar();
		scroll.setPreferredSize(new Dimension(800,500));
		middle.add(scroll);
		con.add(middle,BorderLayout.CENTER);
		
		//MIDDLE CODE
		text.setEditable(false);
		text.setLineWrap(true);
		DefaultCaret caret = (DefaultCaret)text.getCaret();
		caret.setUpdatePolicy(DefaultCaret.OUT_BOTTOM);
		
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
		ActionListener inputAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userInput = input.getText();
				input.setText("");
				//text.append(userInput + "\n");
				text.append("<USER>:\n" + userInput + "\n");
				inputString = userInput;
				//bar.setValue(bar.getMaximum());
			}
		};
		
		
		send.addActionListener(inputAction);
		input.addActionListener(inputAction);
		
		
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
