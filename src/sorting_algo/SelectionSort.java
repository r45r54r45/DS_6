package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class SelectionSort extends DS_Sort_e implements DS_Sort_i {

	private void selectionSort(int[] arr, int low, int high){
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;

		int N = arr.length;
		for (int i = 0 ; i < N ; i++){
			int min = i;
			for (int j = i+1 ; j<N ; j++)
				if(less(arr[j], arr[min])) min = j;
			swap(arr, i, min);
		}
	}

	public int[] sort(int[] array) {
		selectionSort(array, 0, array.length-1);
		return array;
	}
	
}
