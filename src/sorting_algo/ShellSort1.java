package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class ShellSort1 extends DS_Sort_e implements DS_Sort_i{

	@Override
	public int[] sort(int[] a) {
		int N = a.length;
	     // 1,4,10,23,57,132,301,701,1750
		int[] seq=new int[]{1,4,10,23,57,132,301,701,1750};
		int seqNum=8;
	    while (seqNum>-1&&seq[seqNum] >= 1) {
	     // h-sort the array
	      for (int i = seq[seqNum]; i < N; i++) {
	        for (int j = i; j >= seq[seqNum] && less(a[j], a[j-seq[seqNum]]); j -= seq[seqNum]) {
	           swap(a, j, j-seq[seqNum]);
	         }
	      }
	      seqNum--;
	    }
		return a;
	}

}
