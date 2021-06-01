package dao.Implementation;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import dao.HospitalDao;
import exceptions.HospitaDaoException;
import exceptions.HospitalServiceException;
import model.Doctor;
import model.Hospital;
import service.Implementation.HospitalServiceImpl;
import utility.JdbcConnection;

public class HospitalDaoImpl implements HospitalDao {
	JdbcConnection obJ = new JdbcConnection();
	
	public void addHospital(Hospital hospital) throws HospitaDaoException   {
		Connection connection = null;
		try {
			connection= obJ.connectToDatabase();
		} catch (ConnectException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement statement;
		try {
			statement = connection.createStatement();
			String query = "INSERT INTO HOSPITAL VALUES("+hospital.getId()+",'"+hospital.getHspName()+"',"+hospital.getTotalNumberDoctors()+")";
			statement.execute(query);
		} catch (SQLException e) {
			
			throw new HospitaDaoException(e.getMessage());
		}
		
	}
	
	public void fetchDetailDoctor() throws HospitaDaoException {
		Statement statement=null;
		Connection connection = null;
		try {
			connection = obJ.connectToDatabase();
		} catch (ConnectException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			statement=connection.createStatement();
			String query= "select * from doctor join hospital on doctor.hspName =hospital.hspName; " ;
			ResultSet rs= statement.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString("name")+ " "+ rs.getString("Salary")+ " "+ rs.getString("speciality")+" "+rs.getString("hspName")  +" "+rs.getString("totalNumberDoctors"));
					
			}
				
		} catch (SQLException e) {
			throw new  HospitaDaoException();
		}
		finally {
			obJ.closeConnection(connection);
			try {
				statement.close();
			} catch (SQLException e) {
			}
		}
		
		
	}

}
