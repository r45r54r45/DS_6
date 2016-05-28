package sorting_algo;

public class RadixSort_MSD {
	private void radixSort_MSD(String[] a, int d){
	int N = a.length;
	String[] aux = new String[N];
	sort2(a,0,N-1,0,aux);
	}
	
	private static void sort2(String[] a,int low,int high,int d,String[] aux){
		int R = 256;
		int[] sindex = new int[R+1];
		int[] oldindex = new int[R+1];
		for (int i = low ; i <= high ; i++){
			sindex[a[i].charAt(d)+1]++;}
		for (int r = 0 ; r < R; r++) sindex[r+1] += sindex[r];
		for (int r = 0 ; r < R; r++) oldindex[r] = sindex[r];
		for (int i = low; i <= high ; i++)
			aux[sindex[a[i].charAt(d)]++] = a[i];
		for (int i = low ; i<= high ; i++) a[i] = aux[i - low];
		for (int r = 0; r< R; r++)
			sort2(a,low+oldindex[r],low+oldindex[r+1]-1,d+1,aux);
		}
	
	public String[] sort(String[] array) {
		radixSort_MSD(array, 4);
		return array;
	}
}
