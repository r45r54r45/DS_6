package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class RadixSort_LSD extends DS_Sort_e implements DS_Sort_i {
	
	@Override
	public int[] sort(int[] array){
		sortLSD(array);
		return array;
	}
	public void sortLSD(int[] a) { 
        int D = 4;  
        int R = 256; 
        int MASK = R - 1;

        int N = a.length;
        int[] aux = new int[N];

        for (int k = 0; k < D; k++) {  
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++) {           
                int n = (a[i] >> 8*k) & MASK;
                count[n + 1]++;
            }
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];
            if (k == D-1) {
                int shift1 = count[R] - count[R/2];
                int shift2 = count[R/2];
                for (int r = 0; r < R/2; r++)
                    count[r] += shift1;
                for (int r = R/2; r < R; r++)
                    count[r] -= shift2;
            }
            for (int i = 0; i < N; i++) {
                int n = (a[i] >> 8*k) & MASK;
                aux[count[n]++] = a[i];
            }
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }
}
