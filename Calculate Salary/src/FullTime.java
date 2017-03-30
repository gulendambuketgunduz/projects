/**
 * This class is child of Employee class
 * and super class of Worker and Chief classes.
 * @author sony
 *
 */
public class FullTime extends Employee{
	
	private int dayOfWork = 5;
	private int hourOfWork = 40;
	private double severancePay;
	private double overWorkSalary;
	private int maxOverWorkPerWeek;
	private double overWorkPaidPerHour;
	private double paidPerDay;
	
	public FullTime(String name, String surname, String registrationNumber,
			String position, int yearOfStart) {
		super(name, surname, registrationNumber, position, yearOfStart);
		// TODO Auto-generated constructor stub
	}

	
	public int getDayOfWork() {
		return dayOfWork;
	}

	public void setDayOfWork(int dayOfWork) {
		this.dayOfWork = dayOfWork;
	}

	public int getHourOfWork() {
		return hourOfWork;
	}

	public void setHourOfWork(int hourOfWork) {
		this.hourOfWork = hourOfWork;
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

	public void setMaxOverWorkPerWeek(int maxOverWorkPerWeek) {
		this.maxOverWorkPerWeek = maxOverWorkPerWeek;
	}

	public double getOverWorkPaidPerHour() {
		return overWorkPaidPerHour;
	}

	public void setOverWorkPaidPerHour(double overWorkPaidPerHour) {
		this.overWorkPaidPerHour = overWorkPaidPerHour;
	}
	public double getPaidPerDay() {
		return paidPerDay;
	}

	public void setPaidPerDay(double paidPerDay) {
		this.paidPerDay = paidPerDay;
	}
}
