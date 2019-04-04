package model;

public class Client {
	
	public int	indice;
	public int waitingTime;
	public int arrivalTime;
	public int finishTime;
	public int serviceTime;
	public int service;
	
	public Client(){
		this.waitingTime = 0;
		this.arrivalTime = 0;
		this.finishTime  = 0;
		this.serviceTime = 0;
		this.service = 0;
	}
	public Client(int a, int b){
		this.arrivalTime = a;
		this.serviceTime = b;
		this.service = b;
	}
	public void setWT(int time) {
		this.waitingTime = time;
	}
	
	public void setAT(int time) {
		this.arrivalTime = time;
	}
	
	public void setFT(int time) {
		this.finishTime = time;
	}
	
	public void setST(int time) {
		this.serviceTime = time;
	}
	
	public int getWT() {
		return this.waitingTime;
	}
	
	public void addWT() {
		this.waitingTime += 1;
	}
	
	public void addST() {
		this.serviceTime += 1;
	}
	
}
