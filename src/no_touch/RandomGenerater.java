package no_touch;

import java.util.LinkedList;
import java.util.Random;

public final class RandomGenerater {
	private int bound;
	private final Random gen = new Random();
	private LinkedList<int[]> type1Random;
	private LinkedList<int[]> type2Random;
	private LinkedList<int[]> type3Random;
	private LinkedList<int[]> type4Random;
	private LinkedList<int[]> type5Random;
	
	public RandomGenerater(){
		type1Random=type1Random();
		type2Random=type2Random();
		type3Random=type3Random();
		type4Random=type4Random();
		type5Random=type5Random();
	}
	public int[] getRandom(int type, int caseNum){
		switch(type){
		case 1:
			return shuffle(type1Random.get(caseNum-1));
		case 2:
			return shuffle(type2Random.get(caseNum-1));
		case 3:
			return shuffle(type3Random.get(caseNum-1),(int)(2*Math.log(type3Random.get(caseNum-1).length)));
		case 4:
			return type4Random.get(caseNum-1);
		case 5:
			return type5Random.get(caseNum-1);
		}
		return null;
	}
	
	private int[] shuffle (int[] array) {
	    int n = array.length;
	    while (n > 1) {
	        int k = gen.nextInt(n--);
	        int temp = array[n];
	        array[n]= array[k];
	        array[k]= temp;
	    }
	    return array;
	}
	private int[] shuffle (int[] array,int count) {
	    int n = array.length;
	    while (n > 1 && count>0) {
	    	 int k = gen.nextInt(n--);
	    	 int temp = array[n];
		     array[n]= array[k];
		     array[k]= temp;
	        count--;
	    }
	    return array;
	}
	
	private LinkedList<int[]> type1Random() { //no duplicates
		LinkedList<int[]> caseList=new LinkedList<>();
		//10000 items
		bound=10000;
		int[] item1=new int[bound];
		for(int i=0; i<bound; i++){
			item1[i]=i;
		}
		caseList.add(item1);
		
		//100000 items
		bound=100000;
		int[] item2=new int[bound];
		for(int i=0; i<bound; i++){
			item2[i]=i;
		}
		caseList.add(item2);

		//1000000 items
		bound=1000000;
		int[] item3=new int[bound];
		for(int i=0; i<bound; i++){
			item3[i]=i;
		}
		caseList.add(item3);

		return caseList;
	}

	private LinkedList<int[]> type2Random() { //many duplicates - using bound/100
		LinkedList<int[]> caseList=new LinkedList<>();
		//10000 items
		bound=10000;
		int[] item1=new int[bound];
		for(int i=0; i<bound; i++){
			item1[i]=gen.nextInt(bound/100);
		}
		caseList.add(item1);

		//100000 items
		bound=100000;
		int[] item2=new int[bound];
		for(int i=0; i<bound; i++){
			item2[i]=gen.nextInt(bound/100);
		}
		caseList.add(item2);
		
		//1000000 items
		bound=1000000;
		int[] item3=new int[bound];
		for(int i=0; i<bound; i++){
			item3[i]=gen.nextInt(bound/100);
		}
		caseList.add(item3);
		
		return caseList;
	}
	private  LinkedList<int[]> type3Random(){ //no duplicates and almost sorted, by adding clogn unordered elements
		//using c as 2
		
		LinkedList<int[]> caseList=new LinkedList<>();
		//10000 items
		bound=10000;
		int[] item1=new int[bound];
		for(int i=0; i<bound; i++){
			item1[i]=i;
		}
		caseList.add(shuffle(item1,(int)(2*Math.log(item1.length))));

		
		//100000 items
		bound=100000;
		int[] item2=new int[bound];
		for(int i=0; i<bound; i++){
			item2[i]=i;
		}
		caseList.add(shuffle(item2,(int)(2*Math.log(item2.length))));
		
		//1000000 items
		bound=1000000;
		int[] item3=new int[bound];
		for(int i=0; i<bound; i++){
			item3[i]=i;
		}
		caseList.add(shuffle(item3,(int)(2*Math.log(item3.length))));

		return caseList;
	}
	private LinkedList<int[]> type4Random(){ //reverse sorted
		LinkedList<int[]> caseList=new LinkedList<>();
		//10000 items
		bound=10000;
		int[] item1=new int[bound];
		for(int i=bound; i>0; i--){
			item1[bound-i]= i;
		}
		caseList.add(item1);

		//100000 items
		bound=100000;
		int[] item2=new int[bound];
		for(int i=bound; i>0; i--){
			item2[bound-i]= i;
		}
		caseList.add(item2);
		
		//1000000 items
		bound=1000000;
		int[] item3=new int[bound];
		for(int i=bound; i>0; i--){
			item3[bound-i]= i;
		}
		caseList.add(item3);
		
		return caseList;
	}
	
	private LinkedList<int[]> type5Random(){ //sizes 9,999, 99,999, and 999,999
		LinkedList<int[]> caseList=new LinkedList<>();
		//9999 items
		bound=9999;
		int[] item1=new int[bound];
		for(int i=0; i<bound/2; i++){
			item1[i]=i+1;
		}
		item1[bound/2]= bound/2+1;
		for(int i=bound/2+1; i<bound; i++){
			item1[i]=bound-i;
		}
		caseList.add(item1);

		//99999 items
		bound=99999;
		int[] item2=new int[bound];
		for(int i=0; i<bound/2; i++){
			item2[i]=i+1;
		}
		item2[bound/2]= bound/2+1;
		for(int i=bound/2+1; i<bound; i++){
			item2[i]=bound-i;
		}
		caseList.add(item2);
		
		bound=999999;
		int[] item3=new int[bound];
		for(int i=0; i<bound/2; i++){
			item3[i]=i+1;
		}
		item3[bound/2]= bound/2+1;
		for(int i=bound/2+1; i<bound; i++){
			item3[i]=bound-i;
		}
		caseList.add(item3);
		
		return caseList;
	}
}
