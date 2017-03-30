/**
 * This class is subclass of Employee
 * and it contains calculation method for part-time employee.
 * @author sony
 *
 */
public class PartTime extends Employee{
	
	private int hourOfWork;
	private int minHoursOfWork = 10, maxHoursOfWork = 20;
	private double paidPerHour =12;

	public PartTime(String name, String surname, String registrationNumber,
			String position, int yearOfStart) {
		super(name, surname, registrationNumber, position, yearOfStart);
		// TODO Auto-generated constructor stub
	}

	
	public int getHourOfWork() {
		return hourOfWork;
	}
	public void setHourOfWork(int hourOfWork) {
		this.hourOfWork = hourOfWork;
	}
	public int getMinHoursOfWork() {
		return minHoursOfWork;
	}
	public void setMinHoursOfWork(int minHoursOfWork) {
		this.minHoursOfWork = minHoursOfWork;
	}
	public int getMaxHoursOfWork() {
		return maxHoursOfWork;
	}
	public void setMaxHoursOfWork(int maxHoursOfWork) {
		this.maxHoursOfWork = maxHoursOfWork;
	} 
	public double getPaidPerHour() {
		return paidPerHour;
	}
	
	public void setPaidPerHour(double paidPerHour) {
		this.paidPerHour = paidPerHour;
	}
	/**
	 * This method calculates salary of part-time employee.
	 */
	@Override
	public double calculateSalary(int[] hourPerWeek, int year)
	{
		double totalSalary = 0.00;
		for(int i = 0; i<hourPerWeek.length; i++)
		{
			if(hourPerWeek[i]<getMinHoursOfWork())
			{
				totalSalary += 0.00;
			}	
			else if(hourPerWeek[i]>=getMaxHoursOfWork())
			{
				totalSalary += getMaxHoursOfWork()*getPaidPerHour();				
			}
			else
			{
				totalSalary += hourPerWeek[i]*getPaidPerHour();
			}
		}
		return totalSalary;
	}
	/**
	 * Override method which helps me write output to files in Main class.
	 */
	@Override
	public String toString(Personnel partTime, int[] hourPerWeek, int year){
		return "Name : " + super.getName() + "\n" + "\nSurname : " + super.getSurname() + "\n"
				+ "\nRegistration Number : " + super.getRegistrationNumber() + "\n"+ "\nPosition : " 
				+ super.getPosition()+ "\n" + "\nYear of Start : " + super.getYearOfStart()+ "\n" + "\nTotal Salary : " 
				+ String.format("%.2f", partTime.calculateSalary(hourPerWeek, year)) + " TL";
	}
}
