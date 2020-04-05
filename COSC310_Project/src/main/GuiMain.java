package main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
public class GuiMain{
	public static void makeGui() {
		//WINDOW INITIATION
		JFrame frame = new JFrame("Gui Main");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
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
		
		//LEFT
		JLabel output = new JLabel("OUTPUT:");
		left.add(output);
		left.setLayout(new FlowLayout());
		//con.add(left,BorderLayout.WEST);
		
		//MIDDLE
		JTextArea text = new JTextArea();
		JScrollPane scroll = new JScrollPane(text);
		scroll.setPreferredSize(new Dimension(300,200));
		middle.add(scroll);
		con.add(middle,BorderLayout.CENTER);
		
		//MIDDLE CODE
		text.setEditable(false);
		text.setText("test");
		
		DefaultCaret caret = (DefaultCaret)text.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		
		//RIGHT
		
		
		//BOTTOM
		JButton button = new JButton("Connect to Agent");
		button.setPreferredSize(new Dimension(300,150));
		bottom.add(button);
		con.add(bottom,BorderLayout.SOUTH);
		
		//BOTTOM CODE
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//text.setText(text.getText() + "\ntest");
				textAdd(text,"test");
				GuiBot guiBot = new GuiBot();
				if(guiBot.makeGui()) {
					textAdd(text, "success");
				}
				else {
					textAdd(text, "failed");
				}
				
			}
		});
		
		
		
		frame.setVisible(true);
		
		
		
		/*
		JPanel panel = new JPanel();
		Dimension panelSize = panel.getSize();
		panelSize.width = 500;
		panelSize.height = 500;
		panel.setPreferredSize(panelSize);
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gridCon = new GridBagConstraints();
		gridCon.gridx = 0;
		gridCon.gridy = 0;
		gridCon.weightx = .5;
		gridCon.weighty = .5;
		//gridCon.fill = GridBagConstraints.VERTICAL;
		//gridCon.insets = new Insets(10,10,10,10);
		
		
		JButton buttonConnect = new JButton("Connect to Agent");
		//buttonConnect.setPreferredSize(new Dimension(200,300));
		//buttonConnect.setMargin(new Insets(5,10,15,20));
		panel.add(buttonConnect,gridCon);
		
		JTextArea text1 = new JTextArea();
		//text1.setPreferredSize(new Dimension(200,300));
		gridCon.gridx = 1;
		panel.add(text1,gridCon);
		
		
		frame.getContentPane().add(panel,BorderLayout.WEST);
		
		JButton placeholder1 = new JButton("Placeholder1");
		//frame.getContentPane().add(placeholder1,BorderLayout.CENTER);
		
		
		JTextArea text2 = new JTextArea();
		text2.setSize(100, 300);
		frame.getContentPane().add(text2, BorderLayout.SOUTH);
		*/
		
		
	}
	
	public static void textAdd(JTextArea text, String message) {
		text.setText(text.getText() + "\n" + message);
	}
	
	
	
	
}
