package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class RadixSort_MSD extends DS_Sort_e implements DS_Sort_i {
	
	private void radixSort_MSD(int[] a, int d) {
	int N = a.length;
	int[] aux = new int[N];
	sort2(a,0,N-1,0,aux);
	}
	
	private void sort2(int[] a,int low,int high,int d,int[] aux){
		int R = 256;
		int[] sindex = new int[R+1];
		int[] oldindex = new int[R+1];
		for (int i = low ; i <= high ; i++){
			sindex[a[i]+1]++;}
		for (int r = 0 ; r < R; r++) sindex[r+1] += sindex[r];
		for (int r = 0 ; r < R; r++) oldindex[r] = sindex[r];
		for (int i = low; i <= high ; i++)
			aux[sindex[a[i]]++] = a[i];
		for (int i = low ; i<= high ; i++) a[i] = aux[i - low];
		for (int r = 0; r< R; r++)
			sort2(a,low+oldindex[r],low+oldindex[r+1]-1,d+1,aux);
		}
	
	public int[] sort(int[] array) {
		radixSort_MSD(array, 4);
		return array;
	}
}
