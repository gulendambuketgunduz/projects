import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 * @author gulendam buket gunduz
 *In this class, there are variables of Price List file such as medicament name, 
 *social security administration code, effective date, expiry date and price.
 */

public class Price {

	String medicineName;
	String socialSecurity;
	String effectiveDate;
	String expiryDate;
	String price;
	
	/**
	 * 
	 * @return
	 * It's returns patient name
	 */
	public String getMedicineName() {
		return medicineName;
	}
	/**
	 * 
	 * @param medicineName
	 * It sets medicine name
	 */
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	/**
	 * 
	 * @return
	 * It's returns patient name
	 */
	public String getSocialSecurity() {
		return socialSecurity;
	}
	/**
	 * 
	 * @param socialSecurity
	 *It sets social security
	 */
	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}
	/**
	 * 
	 * @return
	 * It's returns patient name
	 */
	public String getEffectiveDate() {
		return effectiveDate;
	}
	/**
	 * 
	 * @param effectiveDate
	 * It sets effective date
	 */
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	/**
	 * 
	 * @return
	 * It's returns patient name
	 */
	public String getExpiryDate() {
		return expiryDate;
	}
	/**
	 * 
	 * @param expiryDate
	 * It sets expiry date
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	/**
	 * 
	 * @return
	 * It's returns patient name
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * 
	 * @param price
	 * It sets price
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * 
	 * @param medicineName
	 * @param socialSecurity
	 * @param effectiveDate
	 * @param expiryDate
	 * @param price
	 * It is a constructor which create an object of price class 
	 */
	public Price(String medicineName, String socialSecurity,
			String effectiveDate, String expiryDate, String price) {
		this.medicineName = medicineName;
		this.socialSecurity = socialSecurity;
		this.effectiveDate = effectiveDate;
		this.expiryDate = expiryDate;
		this.price = price;
	}
	/**
	 * 
	 * @param a
	 * @param b
	 * @param i
	 * @return min
	 * @throws NumberFormatException
	 * @throws ParseException
	 * This method helps find the right price of each medicine
	 */
	public static double findMedicinePrice(ArrayList<Prescription> a, ArrayList<Price> b, int i) throws NumberFormatException, ParseException
	{
		double min = 0.0;
		DateFormat date = new SimpleDateFormat("dd.mm.yyyy");
			for(int j = 0; j<b.size(); j++)
			{
				if(a.get(i).getMedicine().equals( b.get(j).getMedicineName()) && a.get(0).getSocialSecurity().equals(b.get(j).getSocialSecurity()))
				{
					if(date.parse(b.get(j).getEffectiveDate()).before(date.parse(a.get(0).prescriptionDate))&& date.parse(b.get(j).getExpiryDate()).after(date.parse(a.get(0).prescriptionDate)))
					{
						if(min>Double.parseDouble(b.get(j).getPrice()) || min==0.0)
						{
							min = Double.parseDouble(b.get(j).getPrice());
						}

					}
				}
			}							
					
		return min;

	}
	

}
