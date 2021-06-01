package dao.Implementation;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import dao.DoctorDao;
import exceptions.DoctorDaoException;
import model.Doctor;
import utility.JdbcConnection;

public class DoctorDaoImpl implements DoctorDao {
	static Scanner scanner = new Scanner(System.in);
	JdbcConnection obJ = new JdbcConnection();

	public void addDoctor(Doctor doctor) throws DoctorDaoException  {

		Connection connection = null;
		try {
			connection = obJ.connectToDatabase();
		} catch (ConnectException e1) {
			
		}
		Statement statement;
		try {
			statement = connection.createStatement();
			
			String query = "INSERT INTO DOCTOR VALUES('" + doctor.getName() + "'," + doctor.getSalary() + ",'"
					+ doctor.getSpeciality() + "','" + doctor.getStringhspName() + "');";
			statement.execute(query);
			
		
		}
		catch (SQLException e) {
			throw new DoctorDaoException("Hospital already exist");		
		}
	}

	public void getDoctorName(String doctorName) throws DoctorDaoException {
		Connection connection = null;
		try {
			connection = obJ.connectToDatabase();
		} catch (ConnectException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM DOCTOR WHERE name ='" + doctorName + "' ";
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				System.out.println(
						rs.getString("Salary") + " " + rs.getString("speciality") + " " + rs.getString("name") + " " + rs.getString(4));
			}
		} catch (SQLException e) {
			throw new DoctorDaoException(e.getMessage());
		}

	}
	
	
	
}

