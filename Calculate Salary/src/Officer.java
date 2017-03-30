/**
 * This class is child of Personnel class. 
 * In this class program calculates officer's salary. 
 * @author sony
 *
 */
public class Officer extends Personnel{
	
	private double baseSalary = 1800;
	private double ssBenefits = (baseSalary/100)*49;
	private double severancePay;
	private double overWorkSalary;
	private int maxOverWorkOverPerWeek = 10;
	private double overWorkPaidPerHour = 4;
	private int hourOfWork = 40;
	
	public Officer(String name, String surname, String registrationNumber,
			String position, int yearOfStart) {
		super(name, surname, registrationNumber, position, yearOfStart);
		// TODO Auto-generated constructor stub
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public double getSsBenefits() {
		return ssBenefits;
	}

	public void setSsBenefits(double ssBenefits) {
		this.ssBenefits = ssBenefits;
	}

	public double getSeverancePay() {
		return severancePay;
	}

	public void setSeverancePay(double severancePay) {
		this.severancePay = severancePay;
	}

	public double getOverWorkSalary() {
		return overWorkSalary;
	}

	public void setOverWorkSalary(double overWorkSalary) {
		this.overWorkSalary = overWorkSalary;
	}

	public int getMaxOverWorkOverPerWeek() {
		return maxOverWorkOverPerWeek;
	}

	public void setMaxOverWorkOverPerWeek(int maxOverWorkOverPerWeek) {
		this.maxOverWorkOverPerWeek = maxOverWorkOverPerWeek;
	}

	public double getOverWorkPaidPerHour() {
		return overWorkPaidPerHour;
	}

	public void setOverWorkPaidPerHour(double overWorkPaidPerHour) {
		this.overWorkPaidPerHour = overWorkPaidPerHour;
	}

	public int getHourOfWork() {
		return hourOfWork;
	}

	public void setHourOfWork(int hourOfWork) {
		this.hourOfWork = hourOfWork;
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
			if(hourPerWeek[i]<hourOfWork)
				overWorkPaid = 0;
			else
				{
				if((hourPerWeek[i]-40)>getMaxOverWorkOverPerWeek())
				{
					overWorkPaid+=getMaxOverWorkOverPerWeek()*getOverWorkPaidPerHour();
					
				}
				else if((hourPerWeek[i]-getHourOfWork())<getMaxOverWorkOverPerWeek())
				{
				overWorkPaid += (hourPerWeek[i]-getHourOfWork())*getOverWorkPaidPerHour();
			}
				}
			
		}
		return overWorkPaid;
	}
	/**
	 * This method calculates salary of an Officer.
	 */
	@Override
	public double calculateSalary(int[] hourPerWeek, int year)
	{
		double totalSalary = 0;
		setSeverancePay((2016-year)*20*0.8);
		totalSalary = getBaseSalary() + getSsBenefits() + getSeverancePay() + calculateOverWorkSalary(hourPerWeek);
		return totalSalary;
	}
	/**
	 * Override method which helps me write output to files in Main class.
	 */
	@Override
	public String toString(Personnel officer, int[] hourPerWeek, int year) {
		return "Name : " + super.getName() + "\n" + "\nSurname : " + super.getSurname() + "\n"
				+ "\nRegistration Number : " + super.getRegistrationNumber() + "\n"+ "\nPosition : " 
				+ super.getPosition()+ "\n" + "\nYear of Start : " + super.getYearOfStart()+ "\n" + "\nTotal Salary : " 
				+ String.format("%.2f", officer.calculateSalary(hourPerWeek, year))+ " TL";
	}
}
