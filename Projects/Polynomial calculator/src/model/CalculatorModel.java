package model;


public class CalculatorModel {

	public Polynomial p1 = new Polynomial();
	public Polynomial p2 = new Polynomial();
	public Polynomial p3 = new Polynomial();
	
	public Polynomial add(Polynomial p1, Polynomial p2) {
		return p3.add(p1, p2);
	}
	
	public Polynomial sub(Polynomial p1, Polynomial p2) {
		return p3.sub(p1, p2);
	}
	
	public Polynomial derive(Polynomial p1) {
		return p3.derives(p1);
	}
	
	public Polynomial integrate(Polynomial p1, Polynomial p2) {
		return p3.integrate(p1);
	}
	
	public Polynomial multiply(Polynomial p1, Polynomial p2) {
		return p3.multiply(p1, p2);
	}
	public Polynomial divide(Polynomial p1, Polynomial p2) {
		return p3.divide(p1, p2);
	}
	public Polynomial getPolynomialResult() {
		return p3;
	}
}
