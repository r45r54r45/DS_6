package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class BubbleSort extends DS_Sort_e implements DS_Sort_i {

	private void bubbleSort(int[] arr, int low, int high){
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;

		  boolean swapped = true;
	      int j = 0;
	      int tmp;
	      while (swapped) {
	            swapped = false;
	            j++;
	            for (int i = 0; i < arr.length - j; i++) {                                       
	                  if (arr[i] > arr[i + 1]) {                          
	                        swap(arr,i,i+1);
	                        swapped = true;
	                  }
	            }                
	      }
		
	}

	public int[] sort(int[] array) {
		bubbleSort(array, 0, array.length-1);
		return array;
	}
	}

