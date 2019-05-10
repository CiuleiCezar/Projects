package Presentation;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Meniu {

	public JButton bt1 = new JButton("Client");
	public JButton bt2 = new JButton("Product");
	public JButton bt3 = new JButton("Order");
	public JFrame frame = new JFrame();
	public ClientWindow clientWindow;
	public ProductWindow productWindow;
	public OrderWindow orderWindow;
	
	public Meniu() {
		
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3,1));
		frame.add(bt1);
		frame.add(bt2);
		frame.add(bt3);
	}
	public void addCalculateListener(ActionListener listenForCalcButton) {
		bt1.addActionListener(listenForCalcButton);
		bt2.addActionListener(listenForCalcButton);
		bt3.addActionListener(listenForCalcButton);
		
	}
	
}
