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

public class ClientWindow {

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
	
	public JLabel label1 = new JLabel("Nume");
	public JLabel label2 = new JLabel("Prenume");
	public JLabel label3 = new JLabel("Email");
	public JLabel label4 = new JLabel("Varsta");
	public JButton b_addClient = new JButton("AddClient");
	public JButton b_deleteClient = new JButton("DeleteClient");
	public JButton b_editClient = new JButton("EditClient");
	public JButton b_showClients = new JButton("ShowClients");

	public ClientWindow() {
		
		frame.setTitle("Client Window");
		frame.setLayout(new GridLayout(6,2));
		frame.setVisible(true);	
		frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                w.getWindow().dispose();
            }
        });
		
		frame.setSize(500, 400);
		panel.add(label1);
		panel.add(tf1);
		panel.add(label2);
		panel.add(tf2);
		panel1.add(label3);
		panel1.add(tf3);
		panel1.add(label4);
		panel1.add(tf4);
		panel2.add(b_addClient);
		panel2.add(b_deleteClient);
		panel2.add(b_editClient);
		panel2.add(b_showClients);
		frame.add(panel);
		frame.add(panel1);
		frame.add(panel2);
		
	}
	public ClientWindow(int a) {
		frame.setTitle("Client Window");
		frame.setLayout(new GridLayout(6,2));
		frame.setVisible(false);
		frame.setSize(500, 400);
		
		frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                w.getWindow().dispose();
            }
        });
		
		panel.add(label1);
		panel.add(tf1);
		panel.add(label2);
		panel.add(tf2);
		panel1.add(label3);
		panel1.add(tf3);
		panel1.add(label4);
		panel1.add(tf4);
		panel2.add(b_addClient);
		panel2.add(b_deleteClient);
		panel2.add(b_editClient);
		panel2.add(b_showClients);
		frame.add(panel);
		frame.add(panel1);
		frame.add(panel2);
	}
	public void addCalculateListener(ActionListener listenForCalcButton) {
		b_addClient.addActionListener(listenForCalcButton);
		b_deleteClient.addActionListener(listenForCalcButton);
		b_editClient.addActionListener(listenForCalcButton);
		b_showClients.addActionListener(listenForCalcButton);
	}
}
