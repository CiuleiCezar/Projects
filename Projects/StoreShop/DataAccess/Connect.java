package DataAccess;
import Model.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class Connect{

	public Connection getConnection() throws Exception{
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/school";
			String username = "root";
			String password = "parola22";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;
		}catch(Exception e){System.out.println(e);}
		
		return null;
	}

	public void insertClient(String nume, String prenume, String email, int varsta) {
		
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO client (nume, prenume,email,varsta) VALUES('"+nume+"','"+prenume+"','"+email+"', '"+varsta+"')");
			posted.executeUpdate();
		}catch(Exception e) {System.out.println(e);}
		finally {
			System.out.println("Insert completed");
		}
	}
	
	public void updateClients(String newEmail, int age) {
		
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("UPDATE client Set email='"+newEmail+"' WHERE varsta='"+age+"'");
			posted.executeUpdate();
		}catch(Exception e) {System.out.println(e);}
		finally {
			System.out.println("Update completed");
		}
		
	}
	
	public void selectClients(){
		
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT id, nume, prenume, email, varsta from client");
			String[] columnNames = {"ID", "NUME", "PRENUME", "EMAIL", "VARSTA" };
			DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
			
			ArrayList<String> array = new ArrayList<String>();
			ResultSet result  = statement.executeQuery();
						
			while(result.next()) {
				
				String id = result.getString("ID");
				String nume = result.getString("NUME");
				String prenume = result.getString("PRENUME");
				String email = result.getString("EMAIL");
				String varsta = result.getString("VARSTA");
				String[] data = {id, nume, prenume, email, varsta};
				tableModel.addRow(data);
			}
			JTable jt = new JTable(tableModel);
			JFrame frame = new JFrame();
			frame.setVisible(true);
			frame.setTitle("Test");
			frame.setSize(500, 500);
			frame.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent w) {
	                w.getWindow().dispose();
	            }
	        });
			frame.add(jt);
			
		}catch(Exception e) {System.out.println(e);}
		finally {
			System.out.println("Select completed");
		}
	}
	
	public void deleteClient(String name) {
		
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("DELETE from client where nume='"+name+"'");
			statement.executeUpdate();
			
		}catch(Exception e) {System.out.println(e);}
		finally {
			System.out.println("Delete completed");
		}
		
	}
	
	public void insertProduct(String nume, int stoc, int pret) {
		
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Insert into produse(nume, stoc, pret) VALUES('"+nume+"', '"+stoc+"', '"+pret+"')");
			statement.executeUpdate();
			
		}catch(Exception e) {System.out.println(e);}
		finally {
			System.out.println("Product insert");
		}
		
	}
	
	public void updateProductStoc(String nume, int stoc) {
	
			
	try {
				Connection con = getConnection();
				PreparedStatement posted = con.prepareStatement("UPDATE produse Set stoc='"+stoc+"' WHERE nume='"+nume+"'");
				posted.executeUpdate();
			}catch(Exception e) {System.out.println(e);}
			finally {
				System.out.println("Update completed");
			}
		
	}
	
	public void deleteProductName(String nume) {
		
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("Delete from produse Where nume ='"+nume+"'");
			posted.executeUpdate();
		}catch(Exception e) {System.out.println(e);}
		finally {
			System.out.println("Update completed");
		}
	
}
		public void selectProducts(){
		
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT id, nume, stoc, pret from produse");
			String[] columnNames = {"ID", "NUME", "STOC", "PRET"};
			DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
			
			ArrayList<String> array = new ArrayList<String>();
			ResultSet result  = statement.executeQuery();
						
			while(result.next()) {
				
				String id = result.getString("ID");
				String nume = result.getString("NUME");
				String stoc = result.getString("STOC");
				String pret = result.getString("PRET");
				String[] data = {id, nume, stoc, pret};
				tableModel.addRow(data);
			}
			JTable jt = new JTable(tableModel);
			JFrame frame = new JFrame();
			frame.setVisible(true);
			frame.setTitle("Test");
			frame.setSize(500, 500);
			frame.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent w) {
	                w.getWindow().dispose();
	            }
	        });
			frame.add(jt);
			
		}catch(Exception e) {System.out.println(e);}
		finally {
			System.out.println("Select completed");
		}
	}	
	
	public void insertOrder(String numeClient, String numeProdus, int cantitate, int pret) {	
			try {
				Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement("Insert into `order`(numeClient, numeProdus, cantitate, pret) VALUES('"+numeClient+"', '"+numeProdus+"', '"+cantitate+"', '"+pret+"')");				
				statement.executeUpdate();
				
			}catch(Exception e) {System.out.println(e);}
			finally {
				System.out.println("Order insert");
			}
	}
	

	public void selectOrders(){
	
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT id, numeClient, numeProdus,cantitate, pret from `order`");
		String[] columnNames = {"ID", "numeClient", "numeProdus", "STOC", "PRET"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		
		ArrayList<String> array = new ArrayList<String>();
		ResultSet result  = statement.executeQuery();
		
		String[] data = {"id","numeClient","numeProdus","cantitate","pret"};
		tableModel.addRow(data);
		
		while(result.next()) {
			
			String id = result.getString("ID");
			String numeClient = result.getString("numeClient");
			String numeProdus = result.getString("numeProdus");
			String cantitate = result.getString("CANTITATE");
			String pret = result.getString("PRET");
			String[] data1 = {id, numeClient, numeProdus, cantitate, pret};
			tableModel.addRow(data1);
		}
		
		JTable jt = new JTable(tableModel);
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("Test");
		frame.setSize(500, 500);
		frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                w.getWindow().dispose();
            }
        });
		frame.add(jt);
		
	}catch(Exception e) {System.out.println(e);}
	finally {
		System.out.println("Select orders completed");
	}
}	
	
	public int selectStoc(String name) {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT stoc from produse where nume='"+name+"'");
			
			ResultSet result  = statement.executeQuery();
			
			while(result.next()) {
				return Integer.parseInt(result.getString("Stoc"));
			}

			
		}catch(Exception e) {System.out.println(e);}
		finally {
			System.out.println("Select completed");
		}
		return -1;
	}
	
	public int selectPret(String name) {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT pret from produse where nume='"+name+"'");
			
			ResultSet result  = statement.executeQuery();
			
			while(result.next()) {
				return Integer.parseInt(result.getString("pret"));
			}

			
		}catch(Exception e) {System.out.println(e);}
		finally {
			System.out.println("Select completed");
		}
		return -1;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		Connect c = new Connect();
		System.out.println(c.selectPret("Samsung"));
		
	}
	
}
