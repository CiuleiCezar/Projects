package model;
import java.lang.Thread;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import view.*;
public class Coada implements Runnable{

	//public Thread thread1 = new Thread(this);
	public int index;
	public int comuta = 0;
	public int AverageWaiting = 0;
	public int NoClients = 0;
	public int TotalClients = 0;
	public int empty = 0;
	public int ServiceTime = 0;
	//public View v = new View();
	
	public Coada(int index) {
		this.index = index;
	}
	
	public LinkedList<Client> list = new LinkedList<Client>();
	Random rand = new Random();
	
	public int noElements() {
		Iterator it = list.iterator();
		int index = 0 ;
		
		while(it.hasNext()) {
			index++;
			it.next();
		}
		return index;
	}
	
	public void addElement(Client e) {
		list.add(e);
		this.NoClients += 1;
	}
	
	public int emptyQueue() {
		
		if(list.lastIndexOf(list) != -1) {
			return list.lastIndexOf(list);
		}
		else {
			return 0;
		}
	}
	public void run() {	

		 {
			//System.out.println("INCEPE");
			if(this.NoClients > 0) {
				
				Iterator it = list.iterator();
				if(it.hasNext()) {
					it.next();
				}
				int j = 1;
				while(it.hasNext()) {
					this.list.get(j).waitingTime +=1;
					j++;
					it.next();
				}
				this.list.get(0).finishTime +=1;
				//System.out.println(this.list.get(0).finishTime+ " ");
				this.list.get(0).serviceTime -=1;	
				if(this.list.get(0).serviceTime==0){
					this.ServiceTime += this.list.get(0).service;
					//System.out.println("Waiting time: " + this.list.get(0).waitingTime);
					this.AverageWaiting += this.list.get(0).waitingTime;
					//System.out.println("-- " + this.list.get(0).waitingTime + "  --");
					this.list.removeFirst();
					this.TotalClients += 1;
					//System.out.println(list.get(0).waitingTime);
					this.NoClients -= 1;
					this.comuta = 1;
				}
			}
			else {
				
			}		
		}
		
	}
	
	public void modify() {
		if(this.NoClients > 0) {
			
			Iterator it = list.iterator();
			if(it.hasNext()) {
				it.next();
			}
			int j = 1;
			while(it.hasNext()) {
				this.list.get(j).waitingTime +=1;
				j++;
				it.next();
			}
			this.list.get(0).finishTime +=1;
			//System.out.println(this.list.get(0).finishTime+ " ");
			this.list.get(0).serviceTime -=1;	
			if(this.list.get(0).serviceTime==0){
				//System.out.println("Waiting time: " + this.list.get(0).waitingTime);
				this.AverageWaiting += this.list.get(0).waitingTime;
				//System.out.println("-- " + this.list.get(0).waitingTime + "  --");
				this.list.removeFirst();
				this.NoClients -= 1;
			}
		}
	}
	
}
