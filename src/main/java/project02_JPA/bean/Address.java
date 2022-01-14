package project02_JPA.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NUM", nullable = false)
	private int num;

	@Column(name = "STREET", nullable = false)
	private String street;

	@Column(name = "TOWN", nullable = false)
	private String town;
	
	@Column(name = "ZIP", nullable = false)
	private int zip;
	
	@Column(name = "COUNTRY", nullable = false)
	private String country;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(int num, String street, String town, int zip, String country) {
		super();
		this.num = num;
		this.street = street;
		this.town = town;
		this.zip = zip;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", num=" + num + ", street=" + street + ", town=" + town + ", zip=" + zip
				+ ", country=" + country + "]";
	}



}
