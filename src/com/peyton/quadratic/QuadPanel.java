package com.peyton.quadratic;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class QuadPanel extends JFrame implements ActionListener, FocusListener{
	private JPanel titlePanel, answerPanel, inputPanel, submitPanel;
	private JTextField aField, bField, cField;
	private JButton submitButton;
	private JLabel title, answerLineOne,answerLineTwo, termone, termtwo, termthree;
	private double a=1,b=1,c=1;
	
	
	public QuadPanel(){
		initializeFrame();
	}
	
	private void initializeFrame(){
		setTitle("Quadratic Solver");
		setMinimumSize(new Dimension(1300,400));
		setLayout(new GridLayout(4,1));
		
		//Title Panel
		titlePanel = new JPanel();
		title = new JLabel("Quadratic Solver");
	    title.setFont(new Font("Courier New", Font.ITALIC, 48));
		titlePanel.add(title);
		add(titlePanel);
		
		//Answer Panel
		answerPanel = new JPanel();
		answerPanel.setLayout(new GridLayout(2,1));
		answerLineOne = new JLabel("__X^2 + __X + __ = 0");
		answerLineTwo = new JLabel("X = __ and __");

	    answerLineOne.setFont(new Font("Courier New", Font.PLAIN, 36));
	    answerLineOne.setHorizontalAlignment(SwingConstants.CENTER);
	    answerLineTwo.setFont(new Font("Courier New",Font.PLAIN, 36));
	    answerLineTwo.setHorizontalAlignment(SwingConstants.CENTER);
	    title.setFont(new Font("Courier New", Font.ITALIC, 48));
		answerPanel.add(answerLineOne);
		answerPanel.add(answerLineTwo);
		add(answerPanel);
		
		//Input Panel
		inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(1,6));
		aField = new JTextField("A");
		aField.addFocusListener(this);
		bField = new JTextField("B");
		bField.addFocusListener(this);
		cField = new JTextField("C");
		cField.addFocusListener(this);
		termone = new JLabel("X^2 + ");
	    termone.setFont(new Font("Courier New", Font.PLAIN, 24));
		termtwo = new JLabel("X + ");
	    termtwo.setFont(new Font("Courier New", Font.PLAIN, 24));
		termthree = new JLabel(" = 0");
	    termthree.setFont(new Font("Courier New", Font.PLAIN, 24));
		inputPanel.add(aField);
		inputPanel.add(termone);
		inputPanel.add(bField);
		inputPanel.add(termtwo);
		inputPanel.add(cField);
		inputPanel.add(termthree);
		add(inputPanel);
		
		//Button Panel
		submitPanel = new JPanel();
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		submitPanel.add(submitButton);
		add(submitButton);
		
		setIconImage(new ImageIcon("frameIcon.png").getImage());
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submitButton){
			try{
			a=Double.parseDouble(aField.getText());
			b=Double.parseDouble(bField.getText());
			c=Double.parseDouble(cField.getText());
			computeAnswer(a,b,c);
			}
			catch(Exception exception){
				Utilities.throwErrorBox("Entry is not a valid number", "Entry Mismatch");
			}
		}
		
	}
	private void computeAnswer(double a, double b, double c){
		double answerOne = ((-1*b)+Math.sqrt((b*b)-((4)*(a)*(c))))/(2*a);
		double answerTwo = ((-1*b)-Math.sqrt((b*b)-((4)*(a)*(c))))/(2*a);
		
		String finalAnswerOne = (Double.isNaN(answerOne)) ? "Unreal" : answerOne + "";

		String finalAnswerTwo = (Double.isNaN(answerTwo)) ? "Unreal" : answerTwo + "";
		
		//Line One
		answerLineOne.setText(a+"X^2 + " + b + "X + " + c + " = 0");
		answerLineTwo.setText("X = " + finalAnswerOne + " and " + finalAnswerTwo);
	}

	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource()==aField || e.getSource()==bField || e.getSource()==cField){
			((JTextField) e.getSource()).setText("");
		}
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
