import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is where program reads input files, executes methods and creates output files.
 * @author sony
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReadFile readingFile = new ReadFile();
		ReadFile readingFile2= new ReadFile();
		
		Scanner scan = readingFile.openFile(args[0]);
		Scanner scan2 = readingFile2.openFile(args[1]);
		
		ArrayList<Personnel> personnel = new ArrayList<Personnel>();
		while(scan.hasNextLine()==true)
		{
			String line;
			String[] array;
			String[] name;
			line=scan.nextLine();
			array = line.split("\t");
			name = array[0].split(" ");
			
			if(array[2].equalsIgnoreCase("MANAGER"))
			{
				personnel.add(new Manager(name[0], name[1], array[1], array[2], Integer.parseInt(array[3])));
			}
			else if(array[2].equalsIgnoreCase("OFFICER"))
			{
				personnel.add(new Officer(name[0], name[1], array[1], array[2], Integer.parseInt(array[3])));
			}
			else if(array[2].equalsIgnoreCase("SECURITY"))
			{
				personnel.add(new Security(name[0], name[1], array[1], array[2], Integer.parseInt(array[3])));
			}
			else if(array[2].equalsIgnoreCase("PARTTIME_EMPLOYEE"))
			{
				personnel.add(new PartTime(name[0], name[1], array[1], array[2], Integer.parseInt(array[3])));
			}
			else if(array[2].equalsIgnoreCase("WORKER"))
			{
				personnel.add(new Worker(name[0], name[1], array[1], array[2], Integer.parseInt(array[3])));
			}
			else if(array[2].equalsIgnoreCase("CHIEF"))
			{
				personnel.add(new Chief(name[0], name[1], array[1], array[2], Integer.parseInt(array[3])));
			}
		}
		while(scan2.hasNextLine()==true)
		{
			String line;
			String[] array;
			int[] hourPerWeek = new int[4];
			int year;
			line=scan2.nextLine();
			array = line.split("\t");
			hourPerWeek[0]=Integer.parseInt(array[1]);
			hourPerWeek[1]=Integer.parseInt(array[2]);
			hourPerWeek[2]=Integer.parseInt(array[3]);
			hourPerWeek[3]=Integer.parseInt(array[4]);
			for(int i = 0; i<personnel.size(); i++)
			{
				if(array[0].equalsIgnoreCase(personnel.get(i).getRegistrationNumber()))
				{
						year = personnel.get(i).getYearOfStart();
						personnel.get(i).calculateSalary(hourPerWeek, year);
						WriteFile writeFile = new WriteFile();
						writeFile.openWFile(personnel.get(i).getRegistrationNumber() + ".txt");
						writeFile.write(personnel.get(i).toString(personnel.get(i), hourPerWeek, year));
						writeFile.closeWFile();
				}
			}	
		}	
	}

	

}
