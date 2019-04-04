package controller;
import view.*;
import model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControllerCalculator {

	public CalculatorView theView;
	public CalculatorModel theModel;
	
	public ControllerCalculator(CalculatorView theView, CalculatorModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		this.theView.addCalculateListener(new CalculateListener());
	}
	
	class CalculateListener implements ActionListener{

		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		
		public void actionPerformed(ActionEvent e) {
			
			p1 = p1.StringToPolynomial(theView.getFirstPolynom());
			p2 = p2.StringToPolynomial(theView.getSecondPolynom());
			Polynomial p3 = new Polynomial();
			
			if(e.getSource() == theView.b_add) {
				p3 = theModel.add(p1, p2);
				theView.setResult(p3.PolynomialToString());
			}
			else if(e.getSource() == theView.b_sub) {
				p3 = theModel.sub(p1, p2);
				theView.setResult(p3.PolynomialToString());
			}
			else if(e.getSource() == theView.b_multiply) {
				p3 = theModel.multiply(p1, p2);
				theView.setResult(p3.PolynomialToString());
			}
			else if(e.getSource() == theView.b_derives) {
				p3 = theModel.derive(p1);
				theView.setResult(p3.PolynomialToString());
			}
			else if(e.getSource() == theView.b_integrate) {
				p3 = theModel.integrate(p1, p2);
				theView.setResult(p3.PolynomialToString());
			}
			else if(e.getSource() == theView.b_clear) {
				theView.setFirstPolynom("");
			}
			else if(e.getSource() == theView.b_clear1) {
				theView.setSecondPolynom("");
			}
			else if(e.getSource() == theView.b_divide) {
				p3 = theModel.divide(p1, p2);
				theView.setResult(p3.PolynomialToString());
			}
		}
		
	}

	
}
