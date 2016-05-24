package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class QuickSort extends DS_Sort_e implements DS_Sort_i{

	private void quickSort(int[] arr, int low, int high){
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				swap(arr,i,j);
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}

	@Override
	public int[] sort(int[] array) {
		quickSort(array, 0, array.length-1);
		return array;
	}
}
