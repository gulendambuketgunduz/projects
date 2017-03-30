/**
 * This class where program calculate manager's salary.
 * @author sony
 *
 */
public class Manager extends Personnel{

	private double baseSalary = 1800;
	private double ssBenefits = (baseSalary/100)*135;
	private double severancePay;
	private double overWorkSalary;
	private int maxOverWorkPerWeek = 8;
	private double overWorkPaidPerHour = 5;
	private int hourOfWork = 40;
	
	public Manager(String name, String surname, String registrationNumber,
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

	public int getMaxOverWorkPerWeek() {
		return maxOverWorkPerWeek;
	}

	public void setMaxOverWorkPerWeek(int maxOverWorkOverPerWeek) {
		this.maxOverWorkPerWeek = maxOverWorkOverPerWeek;
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
			if(hourPerWeek[i]<getHourOfWork())
				overWorkPaid = 0;
			else
				{
				if((hourPerWeek[i]-getHourOfWork())>getMaxOverWorkPerWeek())
				{
					overWorkPaid+=getMaxOverWorkPerWeek()*getOverWorkPaidPerHour();
					
				}
				else if((hourPerWeek[i]-getHourOfWork())<getMaxOverWorkPerWeek())
				{
				overWorkPaid += (hourPerWeek[i]-getHourOfWork())*getOverWorkPaidPerHour();
			}
				}
			
		}
		return overWorkPaid;
	}
	/**
	 * Override method which calculate salary of manager.
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
	public String toString(Personnel manager, int[] hourPerWeek, int year) {
		return "Name : " + super.getName() + "\n" + "\nSurname : " + super.getSurname() + "\n"
				+ "\nRegistration Number : " + super.getRegistrationNumber() + "\n"+ "\nPosition : " 
				+ super.getPosition()+ "\n" + "\nYear of Start : " + super.getYearOfStart()+ "\n" 
				+ "\nTotal Salary : " + String.format("%.2f", manager.calculateSalary(hourPerWeek, year)) + " TL";
	}

	
}
