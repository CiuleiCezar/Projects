package Presentation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JPanel{

	public JFrame frame = new JFrame();
	public JPanel panel = new JPanel();
	public JPanel panel1 = new JPanel();
	public JPanel panel2 = new JPanel();
	public JPanel panel11 = new JPanel();
	public JPanel panel12 = new JPanel();
	public JPanel panel13 = new JPanel();
	
	public TextField tf1 = new TextField(20);
	public TextField tf2 = new TextField(20);
	public TextField tf3 = new TextField(20);
	public TextField tf4 = new TextField(20);
	
	public TextField tf11 = new TextField(20);
	public TextField tf12 = new TextField(20);
	public TextField tf13 = new TextField(20);
	
	public JLabel label11 = new JLabel("Nume produs");
	public JLabel label12 = new JLabel("Pret");
	public JLabel label13 = new JLabel("Stoc");
	
	public JLabel label1 = new JLabel("Nume");
	public JLabel label2 = new JLabel("Prenume");
	public JLabel label3 = new JLabel("Email");
	public JLabel label4 = new JLabel("Varsta");
	public JButton b_addClient = new JButton("AddClient");
	public JButton b_deleteClient = new JButton("DeleteClient");
	public JButton b_editClient = new JButton("EditClient");
	public JButton b_showClients = new JButton("ShowClients");
	public JFrame frame1 = new JFrame();
	public JButton b_addProduct = new JButton("AddProduct");
	public JButton b_deleteProduct = new JButton("DeleteProduct");
	public JButton b_editProduct = new JButton("EditProduct");
	public JButton b_showProduct = new JButton("ShowProducts");
	public Meniu m;
	
	public View() {
		
//		frame.setTitle("Client Window");
//		frame.setLayout(new GridLayout(6,2));
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
//		frame.setSize(500, 400);
//		panel.add(label1);
//		panel.add(tf1);
//		panel.add(label2);
//		panel.add(tf2);
//		panel1.add(label3);
//		panel1.add(tf3);
//		panel1.add(label4);
//		panel1.add(tf4);
//		panel2.add(b_addClient);
//		panel2.add(b_deleteClient);
//		panel2.add(b_editClient);
//		panel2.add(b_showClients);
//		frame.add(panel);
//		frame.add(panel1);
//		frame.add(panel2);
//		frame1.setTitle("Products Window");
//		frame1.setLayout(new GridLayout(8,4));
//		frame1.setVisible(true);
//		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame1.setSize(500, 400);
//		panel11.add(label11);
//		panel11.add(tf11);
//		panel11.add(label12);
//		panel11.add(tf12);
//		panel13.add(label13);
//		panel13.add(tf13);
//		panel12.add(b_addProduct);
//		panel12.add(b_deleteProduct);
//		panel12.add(b_editProduct);
//		panel12.add(b_showProduct);
//		frame1.add(panel11);
//		frame1.add(panel13);
//		frame1.add(panel12);
		
		m = new Meniu();
		
	}
	
	public void addCalculateListener(ActionListener listenForCalcButton) {
		b_addClient.addActionListener(listenForCalcButton);
		b_deleteClient.addActionListener(listenForCalcButton);
		b_editClient.addActionListener(listenForCalcButton);
		b_showClients.addActionListener(listenForCalcButton);
		b_addProduct.addActionListener(listenForCalcButton);
		b_deleteProduct.addActionListener(listenForCalcButton);
		b_editProduct.addActionListener(listenForCalcButton);
		b_showProduct.addActionListener(listenForCalcButton);
	}
	
	
}
