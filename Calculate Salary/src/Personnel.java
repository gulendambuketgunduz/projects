/**
 * This class is super class of Manager, Officer, Employee and Security classes and 
 * contains their common variables and methods which to override.
 * @author sony
 *
 */

public class Personnel {

	String name;
	String surname;
	String registrationNumber;
	String position;
	int yearOfStart;
	
	public Personnel(String name, String surname, String registrationNumber,
			String position, int yearOfStart) {
		super();
		this.name = name;
		this.surname = surname;
		this.registrationNumber = registrationNumber;
		this.position = position;
		this.yearOfStart = yearOfStart;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getYearOfStart() {
		return yearOfStart;
	}
	public void setYearOfStart(int yearOfStart) {
		this.yearOfStart = yearOfStart;
	}
	/**
	 * This method calculates salary which will be implemented for each class.
	 * @param hourPerWeek
	 * @param year
	 * @return
	 */
	public double calculateSalary(int[] hourPerWeek, int year)
	{
		return 0;
	}
	/**
	 * This method helps to implement writing to the output files operations which will be override.
	 * @param personnel
	 * @param hourPerWeek
	 * @param year
	 * @return
	 */
	public String toString(Personnel personnel, int[] hourPerWeek, int year) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
