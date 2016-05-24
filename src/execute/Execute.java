package execute;

import no_touch.DS_Sort_i;
import no_touch.RandomGenerater;
import sorting_algo.BubbleSort;

public class Execute {
	private static RandomGenerater rg;
	public static void main(String[] args) {
		try {
			rg=new RandomGenerater(); 
			DS_Sort_i[] sort_algo=new DS_Sort_i[]{
					new BubbleSort()
					}; //... 구현하고 추가하셈 예) {new BubbleSort(),new SelectionSort()....}
			run(sort_algo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static boolean isSorted(int[] a) {
	    for (int i = 0; i < a.length - 1; i++) {
	        if (a[i] > a[i+1]) {
	            return false; 
	        }
	    }
	    return true; 
	}
	private static void run(DS_Sort_i[] sorting){
		int currentAlgoReadyNum=sorting.length;
		
		long[][][] time=new long[5][3][currentAlgoReadyNum];
		
		for(int type=1; type<4; type++){ //exclude type4 and type5
			for(int size=1; size<4; size++){
				for(int cases=0; cases<20; cases++){
					int[] arr=rg.getRandom(type, size);
					for(int currentAlgo=0; currentAlgo<currentAlgoReadyNum; currentAlgo++){
						long start=System.currentTimeMillis();
						int[] result=sorting[currentAlgo].sort(arr);
						time[type-1][size-1][currentAlgo]+=System.currentTimeMillis()-start;
						if(!isSorted(result)){
							System.out.println("--------------------------------------");
							System.out.println("/////////sorting not done...//////////");
							System.out.println("/////////type: "+type+", size: "+size+", algo: "+currentAlgo+"//////////");
							System.out.println("--------------------------------------");
						}
					}
				}
				for(int currentAlgo=0; currentAlgo<currentAlgoReadyNum; currentAlgo++){
					time[type-1][size-1][currentAlgo]/=20;
					System.out.println("type "+type+", size: "+1000*(int)(Math.pow(10, size))+", Algorithm num."+currentAlgo+" : "+time[type-1][size-1][currentAlgo]+"ms");
				}
			}
		}
		
	
		for(int type=4; type<6; type++){ // type4 and type5
			for(int size=1; size<4; size++){
				int[] arr=rg.getRandom(type, size);
				for(int currentAlgo=0; currentAlgo<currentAlgoReadyNum; currentAlgo++){
					long start=System.currentTimeMillis();
					int[] result=sorting[currentAlgo].sort(arr);
					time[type-1][size-1][currentAlgo]+=System.currentTimeMillis()-start;
					if(!isSorted(result)){
						System.out.println("--------------------------------------");
						System.out.println("/////////sorting not done...//////////");
						System.out.println("/////////type: "+type+", size: "+size+", algo: "+currentAlgo+"//////////");
						System.out.println("--------------------------------------");
					}
				}
				
				for(int currentAlgo=0; currentAlgo<currentAlgoReadyNum; currentAlgo++){
					time[type-1][size-1][currentAlgo]/=20;
					if(type!=5)
						System.out.println("type "+type+", size: "+1000*(Math.pow(10, size))+", Algorithm num."+currentAlgo+" : "+time[type-1][size-1][currentAlgo]+"ms");
					else 
						System.out.println("type "+type+", size: "+(int)(1000*(Math.pow(10, size))-1)+", Algorithm num."+currentAlgo+" : "+time[type-1][size-1][currentAlgo]+"ms");
				}
			}
		}
	}

}
