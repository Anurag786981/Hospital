package service.Implementation;

import dao.DoctorDao;
import dao.Implementation.DoctorDaoImpl;
import exceptions.DoctorDaoException;
import exceptions.DoctorServiceException;
import model.Doctor;
import service.DoctorService;

public class DoctorServiceImpl implements DoctorService {
     DoctorDao sd= new DoctorDaoImpl(); 
	
	public void addDoctor(Doctor doctor) throws DoctorServiceException {
		try {
			sd.addDoctor(doctor);
		} catch (DoctorDaoException e) {
			
			throw new DoctorServiceException(e.getMessage());
			
		
		}
		
	}

	public void getDoctorName(String doctorName) throws DoctorServiceException {
		try {
			sd.getDoctorName(doctorName);
		} catch (DoctorDaoException e) {
			throw new DoctorServiceException(e.getMessage());
			
		}
		
	}

}
