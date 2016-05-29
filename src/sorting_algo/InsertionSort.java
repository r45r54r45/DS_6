package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class InsertionSort  extends DS_Sort_e implements DS_Sort_i {
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

	public int[] sort(int[] array) {
		insertionSort(array, 0, array.length-1);
		return array;
	}
}
