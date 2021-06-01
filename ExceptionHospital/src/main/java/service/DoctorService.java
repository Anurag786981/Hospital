package service;

import exceptions.DoctorServiceException;
import model.Doctor;

public interface DoctorService {

	void addDoctor(Doctor doctor) throws DoctorServiceException;

	void getDoctorName(String doctorName) throws DoctorServiceException;

}
