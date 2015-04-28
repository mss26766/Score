import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * Manpreet Singh Saini
 * CSC 200
 * email-mss26766@email.vccs.edu
 * Assignment 5 - Score Calculator
 */


public class Score implements ActionListener {
	
	final int size = 4;
private JFrame frame;
private JPanel panel, bpanel, rpanel;
private JTextField [] tscore = new JTextField[size];
private JTextField [] wscore = new JTextField[size];
private JLabel [] label = new JLabel[size];
private JLabel fscore;
private JButton calculate;
double [] s = new double [size];
double [] w = new double [size];
double [] ST = new double [size];
double [] WT = new double [size];
/**
 * Construct the GUI.
 */

public Score() {
	frame = new JFrame();
	frame.setVisible(true);
	frame.setSize(250, 500);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	panel = new JPanel();
	panel.setBackground(Color.green);
	panel.setLayout(new GridLayout(5,3));
	bpanel = new JPanel();
	bpanel.setBackground(Color.red);
	rpanel = new JPanel();
	rpanel.setBackground(Color.CYAN);
	label[0] = new JLabel("testscore1");
	label[1] = new JLabel("testscore2");
	label[2] = new JLabel("testscore3");
	label[3] = new JLabel("testscore4");
	for (int i=0; i<size; i++){
		panel.add(label[i]);
		tscore[i]=new JTextField(10);
		panel.add(tscore[i]);
		wscore[i]=new JTextField(10);
		panel.add(wscore[i]);
	}
	
	fscore = new JLabel();
	fscore.setText(".....");
	rpanel.add(fscore);
	
	calculate = new JButton("Calculate");
	calculate.addActionListener(this);
	bpanel.add(calculate);
	
	frame.add(panel, BorderLayout.NORTH);
	frame.add(bpanel, BorderLayout.CENTER);
	frame.add(rpanel, BorderLayout.SOUTH);
	
	frame.setVisible(true);
	frame.pack();
	frame.setLocationRelativeTo(null);
}
/**
 * Calculate the weighted average
 * @param s
 * @param w
 * @return
 */
public double calculateAvgScore(double [] s, double [] w){
	double total = 0;
	for (int i=0; i<size; i++){
		total+=(s[i] * w[i]);
	}
	return total;
}
/**
 * Input scores and get the result.
 */
public void actionPerformed(ActionEvent e){
	for (int i=0; i<size; i++){
		ST [i] = Double.parseDouble(tscore[i].getText());
		WT [i] = Double.parseDouble(wscore[i].getText());
	}
	double T = calculateAvgScore(ST,WT);
	fscore.setText(String.valueOf(T));
//	
}
}