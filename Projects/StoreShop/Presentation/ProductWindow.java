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

public class ProductWindow {

	public JFrame frame = new JFrame();
	public JPanel panel = new JPanel();
	public JPanel panel1 = new JPanel();
	public JPanel panel2 = new JPanel();
	public JPanel panel11 = new JPanel();
	public JPanel panel12 = new JPanel();
	public JPanel panel13 = new JPanel();
	
	public TextField tf11 = new TextField(20);
	public TextField tf12 = new TextField(20);
	public TextField tf13 = new TextField(20);
	
	public JLabel label11 = new JLabel("Nume produs");
	public JLabel label12 = new JLabel("Pret");
	public JLabel label13 = new JLabel("Stoc");
	
	public JFrame frame1 = new JFrame();
	public JButton b_addProduct = new JButton("AddProduct");
	public JButton b_deleteProduct = new JButton("DeleteProduct");
	public JButton b_editProduct = new JButton("EditProduct");
	public JButton b_showProduct = new JButton("ShowProducts");
	
	public ProductWindow() {
		
		frame1.setTitle("Products Window");
		frame1.setLayout(new GridLayout(8,4));
		frame1.setVisible(true);
		
		frame1.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                w.getWindow().dispose();
            }
        });
		
		frame1.setSize(500, 400);
		panel11.add(label11);
		panel11.add(tf11);
		panel11.add(label12);
		panel11.add(tf12);
		panel13.add(label13);
		panel13.add(tf13);
		panel12.add(b_addProduct);
		panel12.add(b_deleteProduct);
		panel12.add(b_editProduct);
		panel12.add(b_showProduct);
		frame1.add(panel11);
		frame1.add(panel13);
		frame1.add(panel12);
		
	}
	
public ProductWindow(int a) {
		
		frame1.setTitle("Products Window");
		frame1.setLayout(new GridLayout(8,4));
		frame1.setVisible(false);
		frame1.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                w.getWindow().dispose();
            }
        });
		
		frame1.setSize(500, 400);
		panel11.add(label11);
		panel11.add(tf11);
		panel11.add(label12);
		panel11.add(tf12);
		panel13.add(label13);
		panel13.add(tf13);
		panel12.add(b_addProduct);
		panel12.add(b_deleteProduct);
		panel12.add(b_editProduct);
		panel12.add(b_showProduct);
		frame1.add(panel11);
		frame1.add(panel13);
		frame1.add(panel12);
		
	}
	
	public void addCalculateListener(ActionListener listenForCalcButton) {
		b_addProduct.addActionListener(listenForCalcButton);
		b_deleteProduct.addActionListener(listenForCalcButton);
		b_editProduct.addActionListener(listenForCalcButton);
		b_showProduct.addActionListener(listenForCalcButton);
	}
	
}
