/**
 * This class is child of FullTime class
 * there is calculation methods for worker.
 * @author sony
 *
 */
public class Worker extends FullTime{

	public Worker(String name, String surname, String registrationNumber,
			String position, int yearOfStart) {
		super(name, surname, registrationNumber, position, yearOfStart);
		this.setOverWorkPaidPerHour(4);
		this.setMaxOverWorkPerWeek(10);
		this.setPaidPerDay(73);
		// TODO Auto-generated constructor stub
	}
	/**
	 * This method calculate over work salary by control given conditions.
	 * @param hourPerWeek
	 * @return
	 */
	private double calculateOverWorkSalary(int[] hourPerWeek)
	{
		double overWorkPaid = 0;
	
		for(int i = 0; i<hourPerWeek.length; i++)
		{
		
			if(hourPerWeek[i]<super.getHourOfWork())
				overWorkPaid = 0;
			else
			{
				if((hourPerWeek[i]-super.getHourOfWork())>=super.getMaxOverWorkPerWeek())
				{
					overWorkPaid+=super.getMaxOverWorkPerWeek()*super.getOverWorkPaidPerHour();
					
				}
				else if((hourPerWeek[i]-super.getHourOfWork())<super.getMaxOverWorkPerWeek())
				{
					overWorkPaid += (hourPerWeek[i]-super.getHourOfWork())*super.getOverWorkPaidPerHour();
				}
			}
		}
		return overWorkPaid;
	}
	/**
	 * This method calculates salary of worker.
	 */
	@Override
	public double calculateSalary(int[] hourPerWeek, int year)
	{
		double totalSalary = 0;
		setSeverancePay((2016-year)*20*0.8);
		totalSalary = super.getSeverancePay() + calculateOverWorkSalary(hourPerWeek) + getPaidPerDay()*getDayOfWork()*4;
		return totalSalary;
	}
	/**
	 * Override method which helps me write output to files in Main class.
	 */
	@Override
	public String toString(Personnel worker, int[] hourPerWeek, int year) {
		return "Name : " + super.getName() + "\n" + "\nSurname : " + super.getSurname() + "\n"
				+ "\nRegistration Number : " + super.getRegistrationNumber() + "\n"+ "\nPosition : " 
				+ super.getPosition() + "\n" + "\nYear of Start : " + super.getYearOfStart()+ "\n" 
				+ "\nTotal Salary : " + String.format("%.2f", worker.calculateSalary(hourPerWeek, year))+ " TL";
	}
	
}
