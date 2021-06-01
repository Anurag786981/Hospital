package dao;

import exceptions.HospitaDaoException;
import exceptions.HospitalServiceException;
import model.Hospital;

public interface HospitalDao {
	public void addHospital(Hospital hospital) throws HospitaDaoException;
	public void fetchDetailDoctor() throws HospitaDaoException;

}
