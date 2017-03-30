import java.util.Random;

public class BinarySearch {
	
	public static void bubbleSortForBinarySearch(Integer[] list, int n)
    { 
        for(int i=1; i<n; i++)
        {
        	int swaps = 0;
        			
            for(int j=0; j<n-i; j++)
            {
                if(list[j] > list[j+1])
                {
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                    swaps = swaps + 1;
                }
            }
            if(swaps == 0)
            	break;
        }
      }

	public static int binarySearch(Integer[] array, int value, int left, int right)
	{
		for(int i = 0; i < right; i++)
    	{
    		Random randomGenerator = new Random();
    	    int randomInt = randomGenerator.nextInt(2500);
    	    array[i] = randomInt;
    	}

		bubbleSortForBinarySearch(array,right);
		while(left <= right)
		{
			int middle = Math.round(((right-left)/2)+left);
			if(array[middle]==value)
			{
				return middle;
			}
			if(value < array[middle])
			{
				right = middle - 1;
			}
			else
			{
				left = middle + 1;
			}
		}
		
		return -1;
	}
}
