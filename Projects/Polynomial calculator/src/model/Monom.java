package model;

public class Monom implements Comparable<Monom>{

	public double coefficient;
	public int  degree;
	
	Monom(){
		coefficient = 0;
		degree = 0;
	}
	
	Monom(double c, int d){
		coefficient = c;
		degree = d;
	}
	
	public String Monom_To_String(){
		
		return coefficient+"x" + "^"+ degree + " + ";
		
	}
	
	public int compareTo(Monom m) {
		
		return (int)(this.degree-m.degree);
		
	}
	
}


