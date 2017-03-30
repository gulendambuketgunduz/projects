/**
 * @author gulendam buket gunduz
 * In this class there are variables of prescription input file 
 * which are patient name, social security administration code, prescription date, 
 * medicament name and quantity and their getter and setter functions
 */

public class Prescription {

	String patientName;
	String socialSecurity;
	String prescriptionDate;
	String medicine;
	String quantity;
	/**
	 * 
	 * @param medicine
	 * @param quantity
	 * It is a constructor which create an object that include medicine and quantity 
	 */
	public Prescription(String medicine, String quantity) {
		
		this.medicine = medicine;
		this.quantity = quantity;
	}
	/**
	 * 
	 * @param patientName
	 * @param socialSecurity
	 * @param prescriptionDate
	 * It is a constructor which create an object that include patient name, 
	 * social security administration code and prescription date 
	 */
	public Prescription(String patientName, String socialSecurity,
			String prescriptionDate) {
		this.patientName = patientName;
		this.socialSecurity = socialSecurity;
		this.prescriptionDate = prescriptionDate;
	}
	/**
	 * 
	 * @return
	 * It's returns patient name
	 */
	public String getPatientName() {
		return patientName;
	}
	/**
	 * 
	 * @param patientName
	 * It sets patient name.
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	/**
	 * 
	 * @return
	 * It returns patient name
	 */
	public String getSocialSecurity() {
		return socialSecurity;
	}
	/**
	 * 
	 * @param socialSecurity
	 * It sets socialSecurity.
	 */
	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}
	/**
	 * 
	 * @return
	 * It returns prescription date
	 */
	public String getPrescriptionDate() {
		return prescriptionDate;
	}
	/**
	 * 
	 * @param prescriptionDate
	 * It sets prescription date.
	 */
	public void setPrescriptionDate(String prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}
	/**
	 * 
	 * @return
	 * It returns medicine
	 */
	public String getMedicine() {
		return medicine;
	}
	/**
	 * 
	 * @param medicine
	 * It sets medicine.
	 */
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	/**
	 * 
	 * @return
	 * It returns quantity
	 */
	public String getQuantity() {
		return quantity;
	}
	/**
	 * 
	 * @param quantity
	 * It sets quantity.
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
