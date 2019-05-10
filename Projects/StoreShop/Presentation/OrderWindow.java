package Presentation;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OrderWindow {

	public JFrame frame = new JFrame();
	public JLabel label1 = new JLabel("ID client");
	public JLabel label2 = new JLabel("Nume client");
	public JLabel label3 = new JLabel("Nume produs");
	public JLabel label4 = new JLabel("Cantitate");
	
	public TextField tf1 = new TextField(20);
	public TextField tf2 = new TextField(20);
	public TextField tf3 = new TextField(20);
	public TextField tf4 = new TextField(20);
	
	public JPanel panel = new JPanel();
	public JPanel panel1 = new JPanel();
	public JPanel panel2 = new JPanel();
	public JPanel panel3 = new JPanel();
	public JPanel panel4 = new JPanel();
	public JButton b_placeOrder = new JButton("Place Order");
	public JButton b_seeOrders = new JButton("Show orders");
	
	public OrderWindow() {
		
		frame.setSize(500, 500);
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(5,3));
		
		frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                w.getWindow().dispose();
            }
        });
		
		panel1.add(label1);
		panel1.add(tf1);
		panel2.add(label2);
		panel2.add(tf2);
		panel3.add(label3);
		panel3.add(tf3);
		panel4.add(label4);
		panel4.add(tf4);
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
		panel.add(b_placeOrder);
		panel.add(b_seeOrders);
		frame.add(panel);
		
	}
	public void addCalculateListener(ActionListener listenForCalcButton) {
		b_placeOrder.addActionListener(listenForCalcButton);
		b_seeOrders.addActionListener(listenForCalcButton);
	}

}
