import view.*;
import model.*;
import controller.*;

public class MVCCalculator {

	public static void main(String args[]) {
		
		CalculatorView theView = new CalculatorView();
		CalculatorModel theModel = new CalculatorModel();
		
		ControllerCalculator theController = new ControllerCalculator(theView, theModel);
		
		theView.setVisible(true);
		
		Tests test = new Tests();
		
	}
	
}
