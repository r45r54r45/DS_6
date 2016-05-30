package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class RadixSort_MSD extends DS_Sort_e implements DS_Sort_i {
	private static final int R = 256;
	private static final int d = 4;
	
	private void radixSort_MSD(int[] a) {
		
		if (a == null || a.length == 0)
			return;
	
	//d=0일 때 a[i]의 맨앞자리 보려면 /1000
	int i;
	int N = a.length;
	int []bucket = new int[R];
	for(i=0; i < R; i++)
		bucket[i]=0;
	for (i=0; i<N; i++)
		bucket[a[i]/1000]++;
	int j =0;
	for(i=0;0<R;i++)
		while((bucket[i]--)>0)
			a[j++] =i;
	}
	

	
	
	public int[] sort(int[] array) {
		radixSort_MSD(array);
		return array;
	}
}
