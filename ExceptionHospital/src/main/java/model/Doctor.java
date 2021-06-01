package model;

public class Doctor {
	
	private String name;
	private double salary;
	private String speciality;
	
	private String hspName;
	
	

	public Doctor() {
		super();
	}



	public Doctor(String name, double salary, String speciality,String hspName) {
		super();
		this.name = name;
		this.salary = salary;
		this.speciality = speciality;
		this.hspName = hspName;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}



	public String getSpeciality() {
		return speciality;
	}



	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}



	public String getStringhspName() {
		return hspName;
	}



	public void setHspName(int id) {
		this.hspName = hspName;
	}
	
	
	
	

}
