package Business;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import DataAccess.*;
import Model.*;
import Presentation.*;

public class Business {

	public View view;
	public Connect con;
	public Business(View v, Connect c) {
		this.view = v;
		this.con = c;
		this.view.addCalculateListener(new CalculateListener());
		this.view.m.addCalculateListener(new CalculateListener());
	
	}
	
	class CalculateListener implements ActionListener{
	
		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == view.m.bt1) {
				view.m.clientWindow = new ClientWindow();
				view.m.productWindow = new ProductWindow(5);
				view.m.clientWindow.addCalculateListener(new CalculateListener());
			}
			else if(e.getSource() == view.m.bt2) {
				view.m.productWindow = new ProductWindow();
				view.m.clientWindow = new ClientWindow(6);
				view.m.productWindow.addCalculateListener(new CalculateListener());
			}
			else if(e.getSource() == view.m.bt3) {
				view.m.orderWindow = new OrderWindow();
				view.m.productWindow = new ProductWindow(6);
				view.m.clientWindow = new ClientWindow(6);
				view.m.orderWindow.addCalculateListener(new CalculateListener());
			}
			else if(e.getSource() == view.m.clientWindow.b_addClient) {
				con.insertClient(view.m.clientWindow.tf1.getText(), view.m.clientWindow.tf2.getText(), view.m.clientWindow.tf3.getText(), Integer.parseInt(view.m.clientWindow.tf4.getText()));
			}
			else if(e.getSource() == view.m.clientWindow.b_deleteClient) {
				con.deleteClient(view.m.clientWindow.tf1.getText());
			}
			else if(e.getSource() == view.m.clientWindow.b_editClient) {
				con.updateClients(view.m.clientWindow.tf3.getText(), 20);
			}
			else if(e.getSource() == view.m.clientWindow.b_showClients) {
				con.selectClients();
			}
			else if(e.getSource() == view.m.productWindow.b_addProduct) {
				con.insertProduct(view.m.productWindow.tf11.getText(), Integer.parseInt(view.m.productWindow.tf12.getText()), Integer.parseInt(view.m.productWindow.tf13.getText()));
			}
			else if(e.getSource() == view.m.productWindow.b_deleteProduct) {
				con.deleteProductName(view.m.productWindow.tf11.getText());
			}
			else if(e.getSource() == view.m.productWindow.b_editProduct) {
				con.updateProductStoc("Telefon", 111);
			}
			else if(e.getSource() == view.m.productWindow.b_showProduct) {
				con.selectProducts();
			}
			else if(e.getSource() == view.m.orderWindow.b_placeOrder) {
				
				String name = view.m.orderWindow.tf3.getText();
				int stoc = Integer.parseInt(view.m.orderWindow.tf4.getText());
				int auxStoc = con.selectStoc(name);
				if(stoc > auxStoc) {
					System.out.println("Stoc indisponibil");
				}
				else {
					int pret = con.selectPret(view.m.orderWindow.tf3.getText());
					con.insertOrder(view.m.orderWindow.tf2.getText(), view.m.orderWindow.tf3.getText(), Integer.parseInt(view.m.orderWindow.tf4.getText()), Integer.parseInt(view.m.orderWindow.tf4.getText()) * pret);
					con.updateProductStoc(view.m.orderWindow.tf3.getText(), auxStoc-stoc);
				}
			}
			else if(e.getSource() == view.m.orderWindow.b_seeOrders) {
				con.selectOrders();
			}
			
		}
		
	}
	
	
}
