package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class RecursiveMergeSort extends DS_Sort_e implements DS_Sort_i{
	
	public void merge(int[] dest, int[] a, int[] b) {
        int i = 0;
        int j = 0;
        while(i < a.length && j < b.length) {
            if(a[i] < b[j]) {
                dest[i + j] = a[i];
                ++i;
            } else {
                dest[i + j] = b[j];
                ++j;
            }
        }
        for(; i < a.length; i++) dest[i + j] = a[i];
        for(; j < b.length; j++) dest[i + j] = b[j];
    }
  

	public void MergeSort_Recursive(int [] elts)
    {
		if(elts.length > 1) {
            // split the array into two pieces, as close to the same
            // size as possible.
            int[] first = extract(elts, 0, elts.length / 2);
            int[] last = extract(elts, elts.length / 2, elts.length);

            // sort each of the two halves recursively
            sort(first);
            sort(last);

            // merge the two sorted halves together
            merge(elts, first, last);
        }
 
    }
	public int[] extract(int[] elts, int start, int last) {
		int[] ret = new int[last - start];
		for(int i = 0; i < ret.length; i++) ret[i] = elts[start + i];
		return ret;
	}

	@Override
	public int[] sort(int[] array) {
		MergeSort_Recursive(array);
		return array;
	}
	
}
