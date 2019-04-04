package view;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JPanel{

	public JFrame frame = new JFrame();
	public JPanel panel = new JPanel();
	public JPanel panel1 = new JPanel();
	public JPanel panel2 = new JPanel();
	public JPanel panel3 = new JPanel();
	public JPanel panel4 = new JPanel();
	public JPanel panel5 = new JPanel();
	public JButton b_add = new JButton("ADD");
	public JButton b_sub = new JButton("SUB");
	public JButton b_divide = new JButton("DIVIDE");
	public JButton b_multiply = new JButton("MULTIPLY");
	public JButton b_derives = new JButton("DERIVES");
	public JButton b_integrate = new JButton("INTEGRATE");
	public JButton b_clear = new JButton("CLEAR1");
	public JButton b_clear1 = new JButton("CLEAR2");
	public TextField tf1 = new TextField(40);
	public TextField tf2 = new TextField(40);
	public TextField tf3 = new TextField(40);
	public JLabel label = new JLabel("Polynomial 1");
	public JLabel label1 = new JLabel("Polynomial 2");
	public JLabel label2 = new JLabel("            Result");
	
	public CalculatorView(){
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setSize(500, 300);
		panel.setLayout(new FlowLayout());
		panel1.add(label);
		panel1.add(tf1);
		panel1.add(b_clear);
		
		panel2.add(label1);
		panel2.add(tf2);
		panel2.add(b_clear1);
		panel3.add(tf3);
		tf3.setEditable(false);
		
		panel4.setLayout(new GridLayout(3,3, 10, 10));
		panel4.add(b_add); 
		panel4.add(b_sub);
		panel4.add(b_divide);
		panel4.add(b_multiply);
		panel4.add(b_derives);
		panel4.add(b_integrate);
		
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		frame.setContentPane(panel);
	}	
	
	public String getFirstPolynom() {
		return tf1.getText();
	}
	
	public String getSecondPolynom() {
		return tf2.getText();
	}
	
	
	public void setFirstPolynom(String s) {
		tf1.setText(s);
	}
	
	public void setSecondPolynom(String s) {
		tf2.setText(s);
	}
	
	public String getResult() {
		return tf3.getText();
	}
	
	public void setResult(String s) {
		tf3.setText(s);
	}
	
	public void addCalculateListener(ActionListener listenForCalcButton) {
		b_add.addActionListener(listenForCalcButton);
		b_sub.addActionListener(listenForCalcButton);
		b_multiply.addActionListener(listenForCalcButton);
		b_divide.addActionListener(listenForCalcButton);
		b_derives.addActionListener(listenForCalcButton);
		b_integrate.addActionListener(listenForCalcButton);
		b_clear.addActionListener(listenForCalcButton);
		b_clear1.addActionListener(listenForCalcButton);
	}
	
	
	
}
