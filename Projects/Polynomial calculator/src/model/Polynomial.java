package model;

import java.io.*; 
import java.text.DecimalFormat;
import java.util.*; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import java.math.*;
public class Polynomial{

	List<Monom> polinom = new ArrayList<Monom>();
	
	
	public String PolynomialToString() {	
		String s = new String();
		int size = polinom.size();
		int nr = 0;
		for(Monom m : polinom) {				
			if(m.coefficient == 0) {
				nr++;
			}
			else {	
			if(m == polinom.get(0)) {
				if(m.coefficient != (int)m.coefficient) {
					if(m.coefficient>0) {
						s = s  + m.coefficient + "x^" +m.degree;	
					}
					else {
						s = s + "-" + m.coefficient + "x^" +m.degree;	
					}
				}
				else{
					if(m.coefficient > 0) {
						s = s + (int)m.coefficient + "x^" +m.degree;	
					}
					else {
						s = s + "-" +(int)m.coefficient + "x^" +m.degree;
					}
				}
			}	
			else if(m.coefficient > 0) {
				if(m.coefficient != (int)m.coefficient) {
					s = s + "+" + m.coefficient + "x^" +m.degree;	
				}
				else{
					s = s + "+" + (int)m.coefficient + "x^" +m.degree;	
				}
			}
			else {
				if(m.coefficient != (int)m.coefficient) {
					s = s + "-" + -m.coefficient + "x^" +m.degree;	
				}
				else{
					s = s + "-" + (int)(-m.coefficient) + "x^" +m.degree;	
				}	
				}
			}
		}
		if(nr == size) s = "0x^0";
		return s;
	}
	
	public void correctPolynomial() {
		
		Collections.sort(polinom);
		
	}
	
	public Polynomial StringToPolynomial(String s) {
		int position = 0;
		int coefficient = 0 , degree = 0;
		Monom monom;
		Polynomial pol = new Polynomial();
		int index = 1;
		Pattern pat = Pattern.compile("-?\\d+");
		Matcher mat = pat.matcher(s);
		
		while(mat.find()) {
			
			String str  = mat.group().toString();
			int aux = Integer.parseInt(str);			
			if(index %2 == 1) {
				coefficient = aux;
				index+=1;
			}
			else if(index %2 == 0) {
				degree = aux;
				index+=1;
				monom = new Monom(coefficient, degree);
				pol.polinom.add(position,monom);
				position += 1;
			}	
		}
		//p.correctPolynomial();
		return pol;
	}
	
	public Polynomial add(Polynomial p1, Polynomial p2) {
	
		Polynomial p = new Polynomial();
		int ok = 0;
		
		for(Monom m2: p2.polinom) {
			ok = 0;
			for(Monom m1: p1.polinom) {
				if(m2.degree == m1.degree) {
					p.polinom.add(new Monom(m1.coefficient + m2.coefficient, m1.degree));
					ok = 1; break;
				}
			}
			if(ok == 0) {
				p.polinom.add(m2);
			}
		}
		for(Monom m1: p1.polinom) {
			ok = 0;
			for(Monom m2 : p2.polinom) {
				if(m1.degree == m2.degree) {
					ok = 1; break;
				}
			}
			if(ok == 0) {
				p.polinom.add(m1);
			}
		}
		p.correctPolynomial();
		return p;
	}	

	public Polynomial sub(Polynomial p1, Polynomial p2) {
	
	Polynomial p = new Polynomial();
	int ok = 0;
	
	for(Monom m2: p2.polinom) {
		ok = 0;
		for(Monom m1: p1.polinom) {
			if(m2.degree == m1.degree) {
				p.polinom.add(new Monom(m1.coefficient - m2.coefficient, m1.degree));
				ok = 1; break;
			}
		}
		if(ok == 0) {
			m2.coefficient = -m2.coefficient;
			p.polinom.add(m2);
		}
	}
	for(Monom m1: p1.polinom) {
		ok = 0;
		for(Monom m2 : p2.polinom) {
			if(m1.degree == m2.degree) {
				ok = 1; break;
			}
		}
		if(ok == 0) {
			m1.coefficient = m1.coefficient;
			p.polinom.add(m1);
		}
	}
	p.correctPolynomial();
	return p;
	}	
	
	public Polynomial derives(Polynomial pol) {
		
		Polynomial p = new Polynomial();
		
		for(Monom m: pol.polinom) {
			if(m.degree !=0) {
				p.polinom.add(new Monom(m.coefficient * m.degree, m.degree-1));
			}
		}
		p.correctPolynomial();
		return p;
	}
	
	public Polynomial integrate(Polynomial pol) {
		
		DecimalFormat df = new DecimalFormat("###.###");
		
		for(Monom m : pol.polinom) {
			String s = df.format(m.coefficient/(m.degree+1));
			double d = Double.parseDouble(s);
			m.coefficient = d;
			m.degree+=1;
		}
		pol.correctPolynomial();
		return pol;
	}
	
	public Polynomial multiply(Polynomial p1, Polynomial p2) {
		
		Polynomial p = new Polynomial();
		
		for(Monom m: p1.polinom) {
			for(Monom m1: p2.polinom) {
				int ok = 0;
				Monom aux = new Monom(m.coefficient * m1.coefficient, m1.degree + m.degree);
				for(Monom mon: p.polinom) {
					if(mon.coefficient == aux.coefficient) {
						mon.coefficient += aux.coefficient;
						ok = 1; 
						break;
					}
				}
				if(ok == 0) {
					p.polinom.add(new Monom(m.coefficient * m1.coefficient, m1.degree + m.degree));
				}
			}
		}	
		p.correctPolynomial();
		return p;
	}
	
	public double coef(Polynomial p) {
		
		for(Monom m: p.polinom){
			if(m.coefficient !=0) {
				return m.coefficient;
			}
		}
		return 0;
	}
	
	public int grade(Polynomial p) {
		for(Monom m: p.polinom) {
			if(m.degree!=0 && m.coefficient!=0) {
				return m.degree;
			}
		}
		return 0;
	}
	
	public Polynomial divide(Polynomial p1, Polynomial p2) {
		Polynomial p = new Polynomial();  Polynomial cat = new Polynomial();
	
		while(p1.grade(p1) >= p2.grade(p2) && Math.abs(p1.coef(p1)) >= Math.abs(p2.coef(p2))) {
			
			Polynomial aux = new Polynomial();
			double coef = (int)(p1.coef(p1)/p2.coef(p2));
			int degree = p1.polinom.get(0).degree-p2.polinom.get(0).degree;
			Monom m = new Monom(coef,degree);
			aux.polinom.add(m);
			p = p.multiply(aux, p2); 
			cat.polinom.add(m);
			p1 = p1.sub(p1, p);
			p1.correctPolynomial();
			cat.correctPolynomial();
			
			System.out.println(p1.PolynomialToString() + " ---- " + cat.PolynomialToString());
			//return cat;
			//System.out.println(p1.grade(p1) + " " + p2.grade(p2) + " " + p1.coef(p1) + " " + p2.coef(p2));
		}
		//System.out.println(p1.PolynomialToString());
		return cat;
	}//12x^4-6x^3+2x^1+7^0
	//3x^2+2x^0
	 
}

