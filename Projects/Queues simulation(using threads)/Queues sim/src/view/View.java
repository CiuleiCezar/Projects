package view;


import java.awt.event.ActionListener;
import javax.swing.*;

import model.Coada;

import java.awt.*;
import java.lang.Thread;
import java.util.LinkedList;

public class View extends JPanel{

	public JFrame frame = new JFrame();
	public JLabel label1 = new JLabel("COADA 1");
	public JLabel label2 = new JLabel("COADA 2");
	public JLabel label3 = new JLabel("COADA 3");
	public JLabel label4 = new JLabel("AvgTime 1");
	public JLabel label5 = new JLabel("AvgTime 2");
	public JLabel label6 = new JLabel("AvgTime 3");
	public JLabel label7 = new JLabel("Min service time");
	public JLabel label8 = new JLabel("Max service time");
	public JLabel label9 = new JLabel("Arrivingg min time");
	public JLabel label10 = new JLabel("Arriving max time");
	public JPanel panel  = new JPanel();
	public JPanel panel1 = new JPanel();
	public JPanel panel2 = new JPanel();
	public JPanel panel3 = new JPanel();
	public JPanel panel4 = new JPanel();
	public JPanel panel5 = new JPanel();
	public JPanel panel6 = new JPanel();
	public JPanel panel7 = new JPanel();
	public TextField tf11 = new TextField(20);
	public TextField tf12 = new TextField(20);
	public TextField tf13 = new TextField(20);
	public TextField tf14 = new TextField(20);
	public TextField tf21 = new TextField(20);
	public TextField tf22 = new TextField(20);
	public TextField tf23 = new TextField(20);
	public TextField tf24 = new TextField(20);
	public TextField tf31 = new TextField(20);
	public TextField tf32 = new TextField(20);
	public TextField tf33 = new TextField(20);
	public TextField tf34 = new TextField(20);
	public TextField tfMinServ = new TextField(5);
	public TextField tfMaxServ = new TextField(5);
	public TextField arrMin = new TextField(5);
	public TextField arrMax = new TextField(5);
	public JButton start = new JButton("START");
	public TextField average1 = new TextField(10);
	public TextField average2 = new TextField(10);
	public TextField average3 = new TextField(10);
	public JLabel label11 = new JLabel("AvgWaiting1:");
	public JLabel label12 = new JLabel("AvgWaiting2:");
	public JLabel label13 = new JLabel("AvgWaiting3:");
	public TextField interval = new TextField(10);
	public JLabel inter = new JLabel("Simulation Time");
	public JLabel empty1 = new JLabel("Empty time1:");
	public JLabel empty2 = new JLabel("Empty time2:");
	public JLabel empty3 = new JLabel("Empty time3:");
	public TextField empty11 = new TextField(10);
	public TextField empty22 = new TextField(10);
	public TextField empty33 = new TextField(10);
	public JLabel service1 = new JLabel("ServiceAvg1:");
	public JLabel service2 = new JLabel("ServiceAvg2:");
	public JLabel service3 = new JLabel("ServiceAvg3:");
	public TextField tfs1 = new TextField(10);
	public TextField tfs2 = new TextField(10);
	public TextField tfs3 = new TextField(10);
	public JPanel panel9 = new JPanel();
	public JPanel panel8 = new JPanel();
	
	public View(){
		
		frame.setSize(800, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(9,8));
		
		panel1.add(label1);
		panel1.add(tf11);
		panel1.add(tf12);
		panel1.add(tf13);
		panel1.add(tf14);
		panel2.add(label2);
		panel2.add(tf21);
		panel2.add(tf22);
		panel2.add(tf23);
		panel2.add(tf24);
		panel3.add(label3);
		panel3.add(tf31);
		panel3.add(tf32);
		panel3.add(tf33);
		panel3.add(tf34);
		panel4.add(label7);
		panel4.add(tfMinServ);
		panel4.add(label8);
		panel4.add(tfMaxServ);
		panel5.add(label9);
		panel5.add(arrMin);
		panel5.add(label10);
		panel5.add(arrMax);
		panel5.add(inter);
		panel5.add(interval);
		panel6.add(start);
		panel7.add(label11);
		panel7.add(average1);
		panel7.add(label12);
		panel7.add(average2);
		panel7.add(label13);
		panel7.add(average3);
		panel9.add(empty1);
		panel9.add(empty11);
		panel9.add(empty2);
		panel9.add(empty22);
		panel9.add(empty3);
		panel9.add(empty33);
		panel8.add(service1);
		panel8.add(tfs1);
		panel8.add(service2);
		panel8.add(tfs2);
		panel8.add(service3);
		panel8.add(tfs3);
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);
		panel.add(panel7);
		panel.add(panel9);
		panel.add(panel8);
		frame.setContentPane(panel);
		
	}
	
	public void addStartListener(ActionListener listenForButton) {
		
		start.addActionListener(listenForButton);
	
	}

	
	public void shift1() {
		tf11.setText(tf12.getText());
		tf12.setText(tf13.getText());
		tf13.setText(tf14.getText());;
		tf14.setText("");
	}
	
	public void shift2() {
		tf21.setText(tf22.getText());
		tf22.setText(tf23.getText());
		tf23.setText(tf24.getText());;
		tf24.setText("");
	}
	
	public void shift3() {
		tf31.setText(tf32.getText());
		tf32.setText(tf33.getText());
		tf33.setText(tf34.getText());;
		tf34.setText("");
	}
	
	public void refresh1(Coada c) {
		tf11.setText(tf12.getText());
		tf12.setText(tf13.getText());
		tf13.setText(tf14.getText());
	}
	public void refresh2(Coada c) {
		tf21.setText(tf22.getText());
		tf22.setText(tf23.getText());
		tf23.setText(tf24.getText());
	}
	
	public void refresh3(Coada c) {
		tf31.setText(tf32.getText());
		tf32.setText(tf33.getText());
		tf33.setText(tf34.getText());
	}
	
	public void setAvgWaiting(int d1, int d2, int d3) {
		
		String s1 = new String();
		s1 = Integer.toString(d1);
		this.average1.setText(s1);
		s1 = Integer.toString(d2);
		this.average2.setText(s1);
		s1 = Integer.toString(d3);
		this.average3.setText(s1);
		
	}
	public void setEmpty(int d1, int d2, int d3) {
		String s1 = new String();
		s1 = Integer.toString(d1);
		this.empty11.setText(s1);
		s1 = Integer.toString(d2);
		this.empty22.setText(s1);
		s1 = Integer.toString(d3);
		this.empty33.setText(s1);
	}
	
	public void setService(int d1, int d2, int d3) {
		String s1 = new String();
		s1 = Integer.toString(d1);
		this.tfs1.setText(s1);
		s1 = Integer.toString(d2);
		this.tfs2.setText(s1);
		s1 = Integer.toString(d3);
		this.tfs3.setText(s1);
	}
	
}
