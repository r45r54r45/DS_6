package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class ShellSort2 extends DS_Sort_e implements DS_Sort_i{

	@Override
	public int[] sort(int[] a) {
		int N = a.length;
	     // 2^k-1
	    int h = 1;
	    while (h < N/2) h = (h + 1)*2-1; 
	    while (h >= 1) {
	     // h-sort the array
	      for (int i = h; i < N; i++) {
	        for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
	           swap(a, j, j-h);
	         }
	      }
	      h /= 2;
	    }
		return a;
	}

}
