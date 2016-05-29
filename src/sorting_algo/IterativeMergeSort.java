package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class IterativeMergeSort extends DS_Sort_e implements DS_Sort_i {
	
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
	public void MergeSort_Iterative(int[] a){
		int N=a.length;
		int[] b =new int[N];
		for(int k=1;k<N;k=k+k){
			for(int i=0;i<N-k;i+=k+k){
			int low=i;
			int mid =i+k-1;
			int high = Math.min(i+k+k-1, N-1);
			merge(a,b,low,mid,high);
			}
		}
	}
	@Override
	public int[] sort(int[] array){
		MergeSort_Iterative(array);
		return array;
	}
}
