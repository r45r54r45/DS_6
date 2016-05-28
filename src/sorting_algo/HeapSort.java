package sorting_algo;

import no_touch.DS_Sort_e;
import no_touch.DS_Sort_i;

public class HeapSort extends DS_Sort_e implements DS_Sort_i {
    private int[] a;
    private int n;
    private int left;
    private int right;
    private int largest;
    @Override
	public int[] sort(int[] array){
		heapSort(array);
		return array;
	}
	private void heapSort(int []a0){
        a=a0;
        buildheap(a);
        
        for(int i=n;i>0;i--){
            exchange(0, i);
            n=n-1;
            maxheap(a, 0);
        }
    }
	public void buildheap(int []a){
        n=a.length-1;
        for(int i=n/2;i>=0;i--){
            maxheap(a,i);
        }
    }
    
    public void maxheap(int[] a, int i){ 
        left=2*i;
        right=2*i+1;
        if(left <= n && a[left] > a[i]){
            largest=left;
        }
        else{
            largest=i;
        }
        
        if(right <= n && a[right] > a[largest]){
            largest=right;
        }
        if(largest!=i){
            exchange(i,largest);
            maxheap(a, largest);
        }
    }
    
    public void exchange(int i, int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t; 
    }
}
