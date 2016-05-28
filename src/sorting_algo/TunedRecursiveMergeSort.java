package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class TunedRecursiveMergeSort extends DS_Sort_e implements DS_Sort_i{
	@Override
	public int[] sort(int[] array){
		tunedRecursiveMergeSort(array);
		return array;
	}
	public void tunedRecursiveMergeSort(int[] a){
		int[] b = new int[a.length];
		sort(a,b,0,a.length-1);
	}
	public void insertionSort(int[] a){
		int N=a.length;
		for(int i=1;i<N;i++){
			for(int j=i;j>0;j--){
				if(less(a[j],a[j-1]))
					swap(a,j,j-1);
				else break;
			}
		}
	}
	private void sort(int[] a,int[] b, int low, int high){
		//if(high<=low)return;
		if(high<low +100000000){
			insertionSort(a);
			return;
		}
		int mid=low +(high-low)/2;
		sort(a,b,low,mid);
		sort(a,b,mid+1,high);
		if(!less(a[mid+1],a[mid])) return;
		merge(a,b,low,mid,high);
	}
	
	public void merge(int[] a, int[]b, int low, int mid, int high){
		int i=low, j = mid+1;
		for(int k=low;k<=high;k++){
			if(i>mid) b[k]=a[j++];
			else if(j>high) b[k]=a[i++];
			else if(less(a[j],a[i])) b[k]=a[j++];
			else b[k]=a[i++];
		}
	}
}
