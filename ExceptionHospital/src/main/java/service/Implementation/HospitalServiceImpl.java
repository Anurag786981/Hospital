package service.Implementation;

import dao.HospitalDao;
import dao.Implementation.HospitalDaoImpl;
import exceptions.HospitaDaoException;
import exceptions.HospitalServiceException;
import model.Hospital;
import service.HospitalService;

public class HospitalServiceImpl implements HospitalService {
	
	HospitalDao hos = new HospitalDaoImpl(); 

	public void addHospital(Hospital hospital) throws HospitalServiceException {
		try {
			hos.addHospital(hospital);
		} catch (HospitaDaoException e) {
			
		throw new HospitalServiceException();
		}
		
	}

	public void fetchDetailDoctor() throws HospitalServiceException {
		
		try {
			hos.fetchDetailDoctor();
		} catch (HospitaDaoException e) {
			
			throw new HospitalServiceException(e.getMessage());
			
			
		}
		
	}

}
