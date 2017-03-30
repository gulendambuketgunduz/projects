import java.util.Random;

public class FindingMax {
	public static Integer[] makeArray(int n)
	{
		Integer[] array = new Integer[n];
		for(int i = 0; i < n; i++)
    	{
    		Random randomGenerator = new Random();
    	    int randomInt = randomGenerator.nextInt(2500);
    	    array[i] = randomInt;
    	}
		return array;
	}
	public static int findMax(int n)
	{
		Integer[] list = makeArray(n);
		int max = 0;
		for(int i = 0; i<n; i++)
		{
			max = Math.max(list[i], max);
		}
		return max;
	}
}
