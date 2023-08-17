package LB4;

import java.io.Serializable;

public class ATM implements Serializable {
	private int id;
	private String address;
	public int	getID() {
		return id;
	}
	public void setId(int Id) {
		id = Id;
	}
	public ATM(){

	}
	public int getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String NewAddress) {
		address= NewAddress;
	}
	public ATM(int Id, String Address) {
		this.address=Address;
		this.id=Id;
		System.out.println("Банкомат " + id + " по адресу: " + address);
		
	}

}
