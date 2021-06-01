package model;

public class Hospital {
	
	private int id;
	private String hspName;
	private int totalNumberDoctors;
	
	
	public Hospital() {
		super();
	}


	public Hospital(int id, String hspName, int totalNumberDoctors) {
		super();
		this.id = id;
		this.hspName = hspName;
		this.totalNumberDoctors = totalNumberDoctors;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getHspName() {
		return hspName;
	}


	public void setHspName(String hspName) {
		this.hspName = hspName;
	}


	public int getTotalNumberDoctors() {
		return totalNumberDoctors;
	}


	public void setTotalNumberDoctors(int totalNumberDoctors) {
		this.totalNumberDoctors = totalNumberDoctors;
	}
	
	
	
	

}
