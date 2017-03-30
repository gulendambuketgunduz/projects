import java.util.ArrayList;

public class MergeSort {
	
	public static ArrayList<Integer> merge(ArrayList<Integer> left,ArrayList<Integer> right)
	{
		ArrayList<Integer> newArray = new ArrayList<>();		
		
		while(left.size()>0 && right.size()>0)
		{
			if(left.get(0) > right.get(0))
			{
				newArray.add(right.get(0));
				right.remove(0);
			}
			else
			{
				newArray.add(left.get(0));
				left.remove(0);
			}
			
			while(left.size()>0)
			{
				newArray.add(left.get(0));
				left.remove(0);
			}
		}
		
		while(right.size()>0)
		{
			newArray.add(right.get(0));
			right.remove(0);
		}
		return newArray;
	}
	
	public static ArrayList<Integer> mergeSort(ArrayList <Integer> array)
	{		
		
			if(array.size() == 1) 
				return array;
		
			ArrayList<Integer> leftArray = new ArrayList<>();
			ArrayList<Integer> rightArray = new ArrayList<>();	
			
			for(int i=0; i<array.size()/2; i++)
				leftArray.add(array.get(i));
			for(int j=leftArray.size() ; j<array.size();j++)
				rightArray.add(array.get(j));
			
			leftArray = mergeSort(leftArray);
			rightArray = mergeSort(rightArray);
		
			return merge(leftArray,rightArray);
	}
}
