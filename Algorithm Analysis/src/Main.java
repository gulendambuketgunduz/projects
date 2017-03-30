import java.util.ArrayList;
import java.util.Random;
import java.util.ArrayList;
import java.lang.Math;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100;
		long lStartTime = System.currentTimeMillis();
		 Random rand = new Random();
		MatrixMultiplication.multiply(n);
		FindingMax.findMax(n);
		BubbleSort.bubbleSort(n);
		Integer[] array = new Integer[n]; 
		BinarySearch.binarySearch(array, 3, 0, n);
		ArrayList<Integer> array1 = new ArrayList<Integer>();
		for(int i = 0; i < n; i++)
    	{
			array1.add(rand.nextInt(2500));
    	}
		
		MergeSort.mergeSort(array1);
		long lEndTime = System.currentTimeMillis();
		long difference = lEndTime - lStartTime;
		System.out.println("Elapsed milliseconds: " + difference);
	}

}
