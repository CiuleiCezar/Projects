package model;

import java.util.ArrayList;

public class Model {
  
	public ArrayList<Coada> rand = new ArrayList<Coada>();
	public Coada c1 = new Coada(1);
	public Coada c2 = new Coada(2);
	public Coada c3 = new Coada(3);
	
	
	public void addClient(Client e,Coada c) {
		c.addElement(e);
	}
	
	public double avgWait(Coada c) {
		return(c.AverageWaiting/c.NoClients);
	}
	
	public Client generateClient(int arrTime, int servTime) {
		Client e = new Client(arrTime, servTime);
		return e;
	}
	
}
