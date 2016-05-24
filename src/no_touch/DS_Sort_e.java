package no_touch;

public class DS_Sort_e {
	public void swap(int[] array, int i,int j){
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	public boolean less(int i,int j){
		if(i<j)return true;
		else return false;
	}
}
