import junit.framework.TestCase;
import view.*;
import model.*;
import controller.*;


public class Tests extends TestCase{

	public Polynomial p1 = new Polynomial();
	public Polynomial p2 = new Polynomial();
	public Polynomial p3 = new Polynomial();
	public Polynomial p4 = new Polynomial();
	
	
	public void setUp() {
		p1 = p1.StringToPolynomial("1x^1+2x^2+3x^3+4x^4");
		p2 = p2.StringToPolynomial("1x^2+2x^3+3x^4");
		System.out.println("p1 = " + p1.PolynomialToString() + "  " + "p2= " + p2.PolynomialToString());
	}
	
	public void testAdd() {
		p3 = p3.add(p1, p2);
		p4 = p4.StringToPolynomial("1x^1+3x^2+5x^3+7x^4");
		assertTrue(p3.PolynomialToString().equals(p4.PolynomialToString()));
	}
	
	public void testSub() {
		p3 = p3.sub(p1, p2);
		p4 = p4.StringToPolynomial("1x^1+1x^2+1x^3+1x^4");
		assertTrue(p3.PolynomialToString().equals(p4.PolynomialToString()));
	}	
	public void testDerives() {
		p3 = p3.derives(p1);
		p4 = p4.StringToPolynomial("1x^0+4x^1+9x^2+16x^3");
		assertTrue(p3.PolynomialToString().equals(p4.PolynomialToString()));
	}
	
	public void testMultiply() {
		p3 = p3.multiply(p1, p2);
		p4 = p4.StringToPolynomial("1x^3+16x^4+24x^5+6x^6+4x^6+9x^7");
		assertTrue(p3.PolynomialToString().equals(p4.PolynomialToString()));
	}
	
	public void testIntegrate() {
		p3 = p3.integrate(p1);
		p4.StringToPolynomial("0.5x^2+0.667x^3+0.75x^4+0.8x^5");
		assertTrue(p3.PolynomialToString().equals(p4.PolynomialToString()));
	}
	
	public void tearDown() {
		p1 = p1.StringToPolynomial("1x^1+2x^2+3x^3+4x^4");
		p2 = p2.StringToPolynomial("1x^2+2x^3+3x^4");
		System.out.println("p1 = " + p1.PolynomialToString() + "  " + "p2= " + p2.PolynomialToString());
	}
}
