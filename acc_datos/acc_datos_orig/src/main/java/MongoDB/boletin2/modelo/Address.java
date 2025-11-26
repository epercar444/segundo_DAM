package MongoDB.boletin2.modelo;

public class Address {
	private String city,street;
	private int zip,number;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Address(String city, String street, int zip, int number) {
		super();
		this.city = city;
		this.street = street;
		this.zip = zip;
		this.number = number;
	}
	public Address() {
		super();
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + ", zip=" + zip + ", number=" + number + "]";
	}
	
	
	
}
