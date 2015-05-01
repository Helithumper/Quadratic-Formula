package com.peyton.menu;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.peyton.quadratic.QuadPanel;
import com.peyton.quadratic.Utilities;

public class MainMenu extends JFrame implements ActionListener{
	JPanel mainPanel;
	JLabel titleText;
	JButton quadraticButton;
	
	
	public MainMenu(){
		instantiateFrame();
	}
	
	private void instantiateFrame(){
		
		setMinimumSize(new Dimension(300,400));
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(2,1));
		titleText = new JLabel("Peyton's Calculator");
		titleText.setFont(Utilities.TEXT_FONT);
		quadraticButton = new JButton ("Quadratic Formula Calculator");
		quadraticButton.addActionListener(this);
		mainPanel.add(titleText);
		mainPanel.add(quadraticButton);
		
		add(mainPanel);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==quadraticButton){
			new QuadPanel();
			setVisible(false);
		}
		
	}
	
	

}
