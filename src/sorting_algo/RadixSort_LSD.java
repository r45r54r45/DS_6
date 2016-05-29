package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class RadixSort_LSD extends DS_Sort_e implements DS_Sort_i {
	private static final int BITS_PER_BYTE = 8;
	@Override
	public int[] sort(int[] array){
		sortLSD(array);
		return array;
	}
	public static void sortLSD(int[] a) { 
        int W = 4;  
        int R = 256; 
        int MASK = R - 1;

        int N = a.length;
        int[] aux = new int[N];

        for (int d = 0; d < W; d++) {  
        	
            // compute frequency counts
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++) {           
                int c = (a[i] >> BITS_PER_BYTE*d) & MASK;
                count[c + 1]++;
            }
            
            // compute cumulates
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];
            
            // for most significant byte, 0x80-0xFF comes before 0x00-0x7F
            if (d == W-1) {
                int shift1 = count[R] - count[R/2];
                int shift2 = count[R/2];
                for (int r = 0; r < R/2; r++)
                    count[r] += shift1;
                for (int r = R/2; r < R; r++)
                    count[r] -= shift2;
            }

            // move data
            for (int i = 0; i < N; i++) {
                int c = (a[i] >> BITS_PER_BYTE*d) & MASK;
                aux[count[c]++] = a[i];
            }

            // copy back
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }

}
