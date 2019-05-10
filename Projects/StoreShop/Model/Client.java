package Model;

public class Client {

	public static int id = 0;
	public String lastName;
	public String firstName;
	public String email;
	public int varsta;
	
	public Client(){
		this.id = 0;
		this.lastName = "NoName";
		this.firstName = "NoName";
		this.email = "NoEmail";
		this.varsta = 0;
	}
	public Client(String lastName, String firstName, String email, int varsta) {
		this.id = this.id +1;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.varsta = varsta;
	}
	
}
