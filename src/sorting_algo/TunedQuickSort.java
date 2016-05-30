package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class TunedQuickSort extends DS_Sort_e implements DS_Sort_i{
	private static final int cutSize = 8;
	public void tuned1QuickSort(int[] intArray, int left, int right) {
	    int size = right - left + 1;
	    if(3 < size && size <=cutSize){ insertionSort(intArray, left, right);}
	    if (size <= 3)
	      manualSort(intArray, left, right);
	    else {
	      double median = medianOf3(intArray, left, right);
	      int partition = partitionIt(intArray, left, right, median);
	      tuned1QuickSort(intArray, left, partition - 1);
	      tuned1QuickSort(intArray, partition + 1, right);
	    }
	  }

	  public int medianOf3(int[] intArray, int left, int right) {
	    int center = (left + right) / 2;

	    if (intArray[left] > intArray[center])
	      swap(intArray, left, center);

	    if (intArray[left] > intArray[right])
	      swap(intArray, left, right);

	    if (intArray[center] > intArray[right])
	      swap(intArray, center, right);

	    swap(intArray, center, right - 1);
	    return intArray[right - 1];
	  }
	  public int partitionIt(int[] intArray, int left, int right, double pivot) {
		    int leftPtr = left;
		    int rightPtr = right - 1;

		    while (true) {
		      while (intArray[++leftPtr] < pivot)
		        ;
		      while (intArray[--rightPtr] > pivot)
		        ;
		      if (leftPtr >= rightPtr)
		        break;
		      else
		        swap(intArray, leftPtr, rightPtr);
		    }
		    swap(intArray, leftPtr, right - 1);
		    return leftPtr;
		  }

		  public void manualSort(int[] intArray, int left, int right) {
		    int size = right - left + 1;
		    if (size <= 1)
		      return;
		    if (size == 2) {
		      if (intArray[left] > intArray[right])
		        swap(intArray, left, right);
		      return;
		    } else {
		      if (intArray[left] > intArray[right - 1])
		        swap(intArray, left, right - 1);
		      if (intArray[left] > intArray[right])
		        swap(intArray, left, right);
		      if (intArray[right - 1] > intArray[right])
		        swap(intArray, right - 1, right);
		    }
		  }
		  
		  private void insertionSort(int[] arr, int low, int high){
				if (arr == null || arr.length == 0)
					return;
		 
				if (low >= high)
					return;
				
				for(int index = 1 ; index < arr.length ; index++){
				      
				      int temp = arr[index];
				      int aux = index - 1;

				      while( (aux >= 0) && ( arr[aux] > temp) ) {

				         arr[aux+1] = arr[aux];
				         aux--;
				      }
				      arr[aux + 1] = temp;
				   }
				
				
			}
		  
	public int[] sort(int[] intArray) {
		tuned1QuickSort(intArray, 0, intArray.length - 1);
		return intArray;
}
	
}
