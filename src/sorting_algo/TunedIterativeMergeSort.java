package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class TunedIterativeMergeSort extends DS_Sort_e implements DS_Sort_i  {
	 private int N;
	 
	public void merge(int[] a, int[]b, int low, int mid, int high){

		for( int k=low; k<=high;k++)b[k]=a[k];
		int i=low, j = mid+1;
		for(int k=low;k<=high;k++){
			if(i>mid) a[k]=b[j++];
			else if(j>high) a[k]=b[i++];
			else if(less(b[j],b[i])) a[k]=b[j++];
			else a[k]=b[i++];
		}
		}
	
	
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
		}}
	
	public void turnedIterativeMergeSort(int[] a){ 
		int cut_size = 20;
		N=a.length;
		int[] b =new int[N];
		for(int k=1;k<N-cut_size;k=k+k){
			for(int i=0;i<N-k;i+=k+k){
			int low=i;
			int mid =i+k-1;
			int high = Math.min(i+k+k-1, N-1);
			merge(a,b,low,mid,high);
			}
		}
		quickSort(a,0,a.length-1);
	}	  
	
	public int[] sort(int[] array){
		turnedIterativeMergeSort(array);
		return array;
	}
}
