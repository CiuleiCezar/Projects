import controller.Controller;
import model.*;
import view.*;

public class Main {

	public static void main(String[] args) {
		
		View theView = new View();
		Model theModel = new Model();
		
		Controller controller = new Controller(theView, theModel);
		theView.setVisible(true);
	}
	
}
