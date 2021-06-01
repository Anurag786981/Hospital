package client;

/*PseudoCode
	1-Create an Hospital and Patients
	2- assign hospital to a doctor
	3- search doctor on the basis of Hospital
*/
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.AppException;
import exceptions.DoctorServiceException;
import exceptions.HospitalServiceException;
import model.Doctor;
import model.Hospital;
import service.DoctorService;
import service.HospitalService;
import service.Implementation.DoctorServiceImpl;
import service.Implementation.HospitalServiceImpl;
import utility.JdbcConnection;

public class HospitalMangement {
	static Scanner scanner = new Scanner(System.in);
	static HospitalService hospitals = new HospitalServiceImpl();
	static DoctorService doctors = new DoctorServiceImpl();

	public static void main(String[] args) {
		boolean flag = true;
		JdbcConnection connection = new JdbcConnection();
		try {
			connection.connectToDatabase();
			
		} catch (ConnectException e1) {
			connection = null;
			System.err.println(e1.getMessage());

		}
		if (connection == null) {
			System.out.println("Check your Credentials");

		} else {

			do {
				dispalyMenu();

				System.out.println("Enter the choice");
				byte choice = scanner.nextByte();
				switch (choice) {

				case 1:
					ArrayList<Hospital> hospitalInfo = new ArrayList<Hospital>();
					Hospital hospital = null;
					System.out.println("Enter number of hospitals ");
					byte noOfHospitals = scanner.nextByte();
					try {

						for (int i = 0; i < noOfHospitals; i++) {

							hospital = hospitalDetails();
							hospitalInfo.add(hospital);
							
							hospitals.addHospital(hospital);
						}
						// Directly communicating with dao is not allowed
						// HospitalDao addingHospital= new HospitalDaoImpl();
					} catch (HospitalServiceException e) {

						System.out.println(e.getMessage());
					}

					break;
				case 2:
					Doctor doctor = null;
					ArrayList<Doctor> doctorInfo = new ArrayList<Doctor>();
					System.out.println("Enter no of doctors ");
					byte noOfDoctors = scanner.nextByte();
					scanner.nextLine();
					try {

						for (int i = 0; i < noOfDoctors; i++) {

							doctor = doctorDetails();
							doctorInfo.add(doctor);
							doctors.addDoctor(doctor);
						}
						// Directly communicating with dao is not allowed
						// DoctorDao addingDoctor = new DoctorDaoImpl();

					} catch (DoctorServiceException e) {
						System.out.println(e.getMessage());
					}

					break;
				case 3:
					// Directly communicating with dao is not allowed
					// DoctorDao doc = new DoctorDaoImpl();
					System.out.println("enter the doctor name");
					String doctorName = scanner.next();

					try {
						doctors.getDoctorName(doctorName);
					} catch (DoctorServiceException e) {

					}

					break;
				case 4:
					// Directly communicating with dao is not allowed
					// HospitalDao da= new HospitalDaoImpl();
					try {
						hospitals.fetchDetailDoctor();
					} catch (HospitalServiceException e) {
						e.printStackTrace();
					}
					break;
				case 5:
					System.out.println("Thank you got covid negavite ");
					flag = false;
				default:
					break;
				}
			} while (flag);

		}
	}

	private static Doctor doctorDetails() {
		System.out.println("Enter id");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the name of the doctor : ");
		String name = scanner.nextLine();
		System.out.println("Enter the salary for doctor ");
		double salary = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("enter the Speciality: ");
		String speciality = scanner.nextLine();
		System.out.println("Enter the hospital name : ");
		String hspName = scanner.nextLine();

		Doctor doctor = new Doctor(name, salary, speciality, hspName);
		scanner.nextLine();
		return doctor;

	}

	private static void dispalyMenu() {
		System.out.println("=============================");
		System.out.println("1. Add hospital");
		System.out.println("2. Add doctors  and assign hospital ");
		System.out.println("3. get Doctor by name ");
		System.out.println("4. Fetch all the doctors sort by Salary ");
		System.out.println("5. Exit");
		System.out.println("=============================");

	}

	private static Hospital hospitalDetails() {

		System.out.println("Enter hospital id : ");
		int id = scanner.nextInt();

		System.out.println("Enter hospital name");
		scanner.nextLine();

		String hspName = scanner.nextLine();
		System.out.println("Enter the total no of doctors : ");

		int noOfDoctors = scanner.nextInt();
		Hospital hospital = new Hospital(id, hspName, noOfDoctors);

		return hospital;
	}

}
