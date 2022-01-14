package project02_JPA.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

	private static final long serialVersionUID = -578848996893330737L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// je contr�le ma colonne depuis mon bean!
	@Column(name = "FIRST_NAME", nullable = true, length=20)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false, length=30)
	private String lastName;

	@Column(name = "SECTION", nullable = false)
	private String section;

	public Student() {
		super();
	}
	public Student(String firstName, String lastName, String section) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.section = section;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", section=" + section + "]";
	}

}
