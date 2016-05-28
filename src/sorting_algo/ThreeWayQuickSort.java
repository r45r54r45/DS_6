package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class ThreeWayQuickSort extends DS_Sort_e implements DS_Sort_i {
	@Override
	public int[] sort(int[] array){
		twayQuickSort(array,0,array.length-1);
		return array;
	}
	public void twayQuickSort(int[] a, int low, int high){
		if(high<=low)return;
		int lt=low;
		int gt=high;
		int i=low;
		int p=a[low];
		while(i<=gt)
		{
			int t=a[i]-p;
			if(t<0) swap(a,lt++,i++);
			else if(t>0)swap(a,i,gt--);
			else i++;
		}
		twayQuickSort(a,low,lt-1);
		twayQuickSort(a,gt+1,high);
	}
	
}
