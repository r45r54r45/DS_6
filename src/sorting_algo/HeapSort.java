package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class HeapSort extends DS_Sort_e implements DS_Sort_i {
    private int n;
    private int left;
    private int right;
    private int big;
    @Override
	public int[] sort(int[] array){
		heapSort(array);
		return array;
	}
	private void heapSort(int []a){
        
        heap(a);
        
        for(int i=n;i>0;i--){
            swap(a,0, i);
            n=n-1;
            upheap(a, 0);
        }
    }
	public void heap(int []a){
        n=a.length-1;
        for(int i=n/2;i>=0;i--){
            upheap(a,i);
        }
    }
    public void upheap(int[] a, int i){ 
        left=2*i;
        right=2*i+1;
        if(left <= n && a[left] > a[i])big=left;
        else big=i;
        if(right <= n && a[right] > a[big])big=right;
        if(big!=i){
            swap(a,i,big);
            upheap(a, big);
        }
    }
}
