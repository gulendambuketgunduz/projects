import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author gulendam buket gunduz
 * This class is where the program read the inputs file, declare them to arraylists, calculate result and write it in output 
 */
public class Main {

	public static void main(String[] args)throws IOException, NumberFormatException, ParseException {
		// TODO Auto-generated method stub

		ReadFile readingFile = new ReadFile();
		Scanner scan = readingFile.openFile(args[0]);
		ArrayList<Prescription> prescription = new ArrayList<Prescription>();
		int lineCounter = 0;
		while(scan.hasNextLine()==true)
		{
			String line;
			String[] array;
			line=scan.nextLine();
			array=line.split("\t");
			lineCounter++;
			if(lineCounter==1)
			{
				prescription.add(new Prescription(array[0], array[1], array[2]));
			}
			else
			{
				prescription.add(new Prescription(array[0], array[1]));
			}
		}
		
		ReadFile readingFile2 = new ReadFile();
		Scanner scan2 = readingFile2.openFile(args[1]); 	
		ArrayList<Price> price = new ArrayList<Price>();
		while(scan2.hasNextLine()==true)
		{
			String line;
			String[] array;
			line=scan2.nextLine();
			array=line.split("\t");
			price.add(new Price(array[0], array[1], array[2], array[3], array[4]));
		}
		
		double[] minArray = new double[prescription.size()];
		
		for(int i = 1; i<prescription.size(); i++)
		{
			minArray[i] = Price.findMedicinePrice(prescription, price, i);
		}
		
		double total = 0.0;
		
		for(int i = 1; i<prescription.size(); i++)
		{
			System.out.printf("%s\t%.2f\t%s\t%.2f\n", prescription.get(i).getMedicine(), minArray[i],
					prescription.get(i).getQuantity(), 
					Double.parseDouble(prescription.get(i).getQuantity())*minArray[i]);
					total += Double.parseDouble(prescription.get(i).getQuantity())*minArray[i];
		}
		System.out.printf("Total: %.2f", total);
	}
}
