package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class InsertionSort  extends DS_Sort_e implements DS_Sort_i {
	private void insertionSort(int[] arr, int low, int high){
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
		
		int length = arr.length;
		for(int i=1; i<length; i++){
			int tmp = arr[i];
			
			int j;
			for (j = i-1 ; j >=0 && tmp < arr[j]; j--)
				arr[j+1] = tmp;
			arr[j+1] = tmp;
		}
		
		
	}

	public int[] sort(int[] array) {
		insertionSort(array, 0, array.length-1);
		return array;
	}
}
