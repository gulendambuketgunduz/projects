/**
 * This class is child of Personnel class and it has calculation methods of security's salary.
 * @author sony
 *
 */
public class Security extends Personnel {

	private int hourOfWork;
	private int minHourOfWorkPerDay = 5, maxHourOfWorkPerDay = 9;
	private double severancePay;
	private double transMoney = 4;
	private double foodMoney = 5;
	private int dayOfWork = 6;
	private double paidPerHour = 6.5;

	public Security(String name, String surname, String registrationNumber,
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

	public int getMinHourOfWorkPerDay() {
		return minHourOfWorkPerDay;
	}

	public void setMinHourOfWorkPerDay(int minHourOfWorkPerDay) {
		this.minHourOfWorkPerDay = minHourOfWorkPerDay;
	}

	public int getMaxHourOfWorkPerDay() {
		return maxHourOfWorkPerDay;
	}

	public void setMaxHourOfWorkPerDay(int maxHourOfWorkPerDay) {
		this.maxHourOfWorkPerDay = maxHourOfWorkPerDay;
	}

	public double getSeverancePay() {
		return severancePay;
	}

	public void setSeverancePay(double severancePay) {
		this.severancePay = severancePay;
	}

	public double getTransMoney() {
		return transMoney;
	}

	public void setTransMoney(double transMoney) {
		this.transMoney = transMoney;
	}

	public double getFoodMoney() {
		return foodMoney;
	}

	public void setFoodMoney(double foodMoney) {
		this.foodMoney = foodMoney;
	}

	public int getDayOfWork() {
		return dayOfWork;
	}

	public void setDayOfWork(int dayOfWork) {
		this.dayOfWork = dayOfWork;
	}

	public double getPaidPerHour() {
		return paidPerHour;
	}

	public void setPaidPerHour(double paidPerHour) {
		this.paidPerHour = paidPerHour;
	}
	/**
	 * This method calculates security's salary.
	 */
	@Override
	public double calculateSalary(int[] hourPerWeek, int year)
	{
		double totalSalary = 0;
		setSeverancePay((2016-year)*20*0.8);
		for(int i = 0; i<hourPerWeek.length; i++)
		{
			if(hourPerWeek[i]<getMinHourOfWorkPerDay()*getDayOfWork())
			{
				totalSalary = 0.0;
			}	
			else if(hourPerWeek[i]>=getMaxHourOfWorkPerDay()*getDayOfWork())
			{
				totalSalary += getMaxHourOfWorkPerDay()*getDayOfWork()*getPaidPerHour()+(getTransMoney()+getFoodMoney())*getDayOfWork();				
			}
			else
			{
				totalSalary += hourPerWeek[i]*getPaidPerHour()+(getTransMoney()*getDayOfWork())+(getFoodMoney()*getDayOfWork());
			}
		}
		totalSalary += getSeverancePay();
		return totalSalary;
	}
	/**
	 * Override method which helps me write output to files in Main class.
	 */
	@Override
	public String toString(Personnel security, int[] hourPerWeek, int year) {
		return "Name : " + super.getName() + "\n" + "\nSurname : " + super.getSurname() + "\n"
				+ "\nRegistration Number : " + super.getRegistrationNumber() + "\n"+ "\nPosition : " 
				+ super.getPosition()+ "\n" + "\nYear of Start : " + super.getYearOfStart()+ "\n" + "\nTotal Salary : " 
				+ String.format("%.2f", security.calculateSalary(hourPerWeek, year)) + " TL";
	}
}
