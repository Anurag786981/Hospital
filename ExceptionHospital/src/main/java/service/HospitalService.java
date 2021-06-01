package service;

import exceptions.HospitalServiceException;
import model.Hospital;

public interface HospitalService {

	public void addHospital(Hospital hospital) throws HospitalServiceException;

	public void fetchDetailDoctor() throws HospitalServiceException;

}
