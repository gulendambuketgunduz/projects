import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
/**
 * this class has method which helps write output in a file
 * @author sony
 *
 */
public class WriteFile {

	
	File output;
	private PrintWriter file;
	
	public void write(String str)
	{
		file.print(str);
	}
	public void writeln(String str)
	{
		file.println(str);
	}
	public void writeln(Object obj)
	{
		file.println(obj);
	}
	public void openWFile(String fileName)
	{
		try
		{
			file = new PrintWriter(new FileOutputStream(fileName), true);
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening file.");
			System.exit(1);
		}
		
	}
	public void closeWFile()
	{
		if(file != null)
		{
			file.close();
		}
	}

}
