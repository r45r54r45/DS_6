package sorting_algo;

public class TurnedIterativeMergeSort {
	private void bubbleSort(int[] arr, int low, int high){
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
		
		int length = arr.length;
		
		 for(int i=0; i<length; i++){
			   for(int j=0; j<(length-i); j++){ // 비교를 하나씩 감소 시키기 위해서 6-i 번 째 까지 해줌
			    if(arr[j] > arr[j+1])	swap(arr,j,j+1);
			    }
			   }
		
	}

	public int[] sort(int[] array) {
		bubbleSort(array, 0, array.length-1);
		return array;
	}
}
