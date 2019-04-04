package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import model.*;
import view.*;

public class Controller implements Runnable{
	
	public Thread thread1 = new Thread(this);
	Random random = new Random();
	public View theView;
	public Model theModel;
	public int serMin = 1;
	public int serMax = 1 ;
	public int arrMin = 1;
	public int arrMax = 1;
	public int interval;
	public int arr;
	
	public Controller(View theView, Model theModel) {
		this.theView = theView;
		this.theModel = theModel;
		theView.addStartListener(new StartListener());
		theModel.rand.add(theModel.c1);
		theModel.rand.add(theModel.c2);
		theModel.rand.add(theModel.c3);
	}
	

	
	class StartListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == theView.start) {
				serMin = Integer.parseInt(theView.tfMinServ.getText());
				serMax = Integer.parseInt(theView.tfMaxServ.getText());
				arrMin = Integer.parseInt(theView.arrMin.getText());
				arrMax = Integer.parseInt(theView.arrMax.getText());
				interval = Integer.parseInt(theView.interval.getText());
				//arr = random.nextInt(arrMax-arrMin)+arrMin;
				run();
			}
		}
	}
	
	public void run() {
		this.arr = random.nextInt(arrMax-arrMin)+arrMin;
		int numar_client = 1;
		for(int i = 0; i < interval; i++) {
			try {
			Thread.sleep(1000);
			
			if(i%arr == 0) {
				Client e1 = theModel.generateClient(i, random.nextInt(this.serMax-this.serMin)+this.serMin);
				int min = this.theModel.rand.get(0).noElements();
				if(min > this.theModel.rand.get(1).noElements()) {
					min = this.theModel.rand.get(1).noElements();
				}
				if(min > this.theModel.rand.get(2).noElements()) {
					min = this.theModel.rand.get(2).noElements();
				}
				
				if(this.theModel.rand.get(0).noElements()==min) {
					if(this.theModel.rand.get(0).noElements()==0) {	this.theModel.rand.get(0).empty+=1;}
					this.theModel.rand.get(0).addElement(e1);
					this.pune1("Client",numar_client);
					numar_client++;
					min = 10;
				}
				else if(this.theModel.rand.get(1).noElements()==min) {
					if(this.theModel.rand.get(1).noElements()==0) {	this.theModel.rand.get(1).empty+=1;}
					this.theModel.rand.get(1).addElement(e1);
					this.pune2("Client", numar_client);
					numar_client++;
					min = 10;
				}
				else if(this.theModel.rand.get(2).noElements()==min) {
					if(this.theModel.rand.get(2).noElements()==0) {	this.theModel.rand.get(2).empty+=1;}
					this.theModel.rand.get(2).addElement(e1);
					this.pune3("Client", numar_client);
					numar_client++;
					min = 10;
				}
			}
			this.theModel.rand.get(0).run();
			this.theModel.rand.get(1).run();
			this.theModel.rand.get(2).run();
			
			if(this.theModel.rand.get(0).comuta == 1) {
				this.theView.shift1(); 
				this.theModel.rand.get(0).comuta = 0;
			}
			
			if(this.theModel.rand.get(1).comuta == 1) {
				this.theView.shift2();
				this.theModel.rand.get(1).comuta = 0;
			}
			
			if(this.theModel.rand.get(2).comuta == 1) {
				this.theView.shift3();
				this.theModel.rand.get(2).comuta = 0;
			}
			
		}catch(InterruptedException ex) {}
		}
		
		int arg1 = this.theModel.rand.get(0).AverageWaiting/this.theModel.rand.get(0).TotalClients;
		int arg2 = this.theModel.rand.get(1).AverageWaiting/this.theModel.rand.get(1).TotalClients;
		int arg3 = this.theModel.rand.get(0).AverageWaiting/this.theModel.rand.get(2).TotalClients;
		this.theView.setAvgWaiting(arg1, arg2, arg3);
		this.theView.setEmpty(this.theModel.rand.get(0).empty, this.theModel.rand.get(1).empty, this.theModel.rand.get(2).empty);
		int arg11 = this.theModel.rand.get(0).ServiceTime/this.theModel.rand.get(0).TotalClients;
		int arg22 = this.theModel.rand.get(1).ServiceTime/this.theModel.rand.get(1).TotalClients;
		int arg33 = this.theModel.rand.get(2).ServiceTime/this.theModel.rand.get(2).TotalClients;
		this.theView.setService(arg11, arg22, arg33);
		
	}
	
	public void pune1(String s, int numar) {
		int size = this.theModel.rand.get(0).NoClients;
		
		if(size < 5) {
			if(size == 1) {
				this.theView.tf11.setText("Client"+numar);
			}
			else if(size ==2) {
				this.theView.tf12.setText("Client"+numar);
			}
			else if(size == 3) {
				this.theView.tf13.setText("Client"+numar);
			}
			else if(size == 4) {
				this.theView.tf14.setText("Client"+numar);
			}
		}
		
	}
	
	public void pune2(String s, int numar) {
		int size = this.theModel.rand.get(1).NoClients;
		
		if(size < 5) {
			if(size == 1) {
				this.theView.tf21.setText("Client"+numar);
			}
			else if(size ==2) {
				this.theView.tf22.setText("Client"+numar);
			}
			else if(size == 3) {
				this.theView.tf23.setText("Client"+numar);
			}
			else if(size == 4) {
				this.theView.tf24.setText("Client"+numar);
			}
		}
		
	}
	public void pune3(String s, int numar) {
		int size = this.theModel.rand.get(2).NoClients;
		
		if(size < 5) {
			if(size == 1) {
				this.theView.tf31.setText("Client"+numar);
			}
			else if(size ==2) {
				this.theView.tf32.setText("Client"+numar);
			}
			else if(size == 3) {
				this.theView.tf33.setText("Client"+numar);
			}
			else if(size == 4) {
				this.theView.tf34.setText("Client"+numar);
			}
		}
		
	}
	
}
