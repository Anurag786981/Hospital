package dao;

import exceptions.DoctorDaoException;
import model.Doctor;

public interface DoctorDao {
	public void addDoctor(Doctor doctor) throws DoctorDaoException ; 
    public void getDoctorName(String doctorName) throws DoctorDaoException;
	

}
