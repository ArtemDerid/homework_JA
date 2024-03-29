package ua.lviv.lgs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class University {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String name;
	
	@Column(name = "accreditation_level")
	private int accreditationLevel;
	
	@Column(name = "number_of_institutes")
	private int numberOfInstitutes;
	
	@Column(name = "number_of_students")
	private int numberOfStudents;
	
	@Column
	private String address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccreditationLevel() {
		return accreditationLevel;
	}

	public void setAccreditationLevel(int accreditationLevel) {
		this.accreditationLevel = accreditationLevel;
	}

	public int getNumberOfInstitutes() {
		return numberOfInstitutes;
	}

	public void setNumberOfInstitutes(int numberOfInstitutes) {
		this.numberOfInstitutes = numberOfInstitutes;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "University [name=" + name + ", accreditationLevel=" + accreditationLevel + ", numberOfInstitutes="
				+ numberOfInstitutes + ", numberOfStudents=" + numberOfStudents + ", address=" + address + "]";
	}
	
}
