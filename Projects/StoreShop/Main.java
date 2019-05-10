import java.sql.Connection;
import Business.*;
import DataAccess.Connect;
import Presentation.View;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {

	public static void main(String[] args) throws Exception {
		
		View v = new View();
		Connect con = new Connect();
		
		Business main = new Business(v, con);

	}

}
