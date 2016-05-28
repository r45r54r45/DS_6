package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class Turned1QuickSort extends DS_Sort_e implements DS_Sort_i {
	
	private void turned1QuickSort(int[] arr, int low, int high){
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
		
		 int size = arr.length;
		 if (size <= 3) manualSort(arr, low, high);
		else {
		      double median = medianOfThree(arr, low, high);
		      int partition = partition(arr, low, high, median);
		      turned1QuickSort(arr, low, partition - 1);
		      turned1QuickSort(arr, partition + 1, high);
		    }
	}
		    
		   public int medianOfThree (int[] arr, int low, int high) {
		        int center = (low + high) / 2;

		        if (arr[low] > arr[center])
		          swap(arr, low, center);

		        if (arr[low] > arr[high])
		          swap(arr, low, high);

		        if (arr[center] > arr[high])
		          swap(arr, center, high);

		        swap(arr, center, high - 1);
		        
		        return arr[high - 1];
		      }

		  
		   public int partition(int[] arr, int low, int high, double pivot) {
			    int leftPtr = low;
			    int rightPtr = high - 1;

			    while (true) {
			      while (arr[++leftPtr] < pivot)
			        ;
			      while (arr[--rightPtr] > pivot)
			        ;
			      if (leftPtr >= rightPtr)
			        break;
			      else
			        swap(arr, leftPtr, rightPtr);
			    }
			    swap(arr, leftPtr, high - 1);
			    return leftPtr;
			  }


		    public void manualSort(int[] arr, int low, int high) {
		        int size = high - low + 1;
		        if (size <= 1)
		          return;
		        if (size == 2) {
		          if (arr[low] > arr[high])
		            swap(arr, low, high);
		          return;
		        } else {
		          if (arr[low] > arr[high - 1]) swap(arr, low, high - 1);
		          if (arr[low] > arr[high])
		            swap(arr, low, high);
		          if (arr[high - 1] > arr[high])
		            swap(arr, high - 1, high);
		        }
		      }
		   
		   public int[] sort(int[] array) {
				turned1QuickSort(array, 0, array.length-1);
				return array;
			}

}
