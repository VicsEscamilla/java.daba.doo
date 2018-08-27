import java.util.Arrays;
import java.util.Random;

public class Utils {
	public static final byte DEFAULT   =0;
	public static final byte SORTED    =1; 
	public static final byte DESC 	   =2;
	public static final byte DISTINCT  =4;
	public static final byte USE_SEED  =8;
	
	
	
	public static int[] createIntArray(int N, int min, int max, int options, long seed){
		int[] array = new int[N];
		Random r = new Random();
		if((options & USE_SEED )!=0)
			r.setSeed(seed);
		
		for(int i=0; i<array.length; i++) {
			array[i] = min + r.nextInt(max-min+1);
			if ((options & SORTED)!=0){
				if((options & DESC)!= 0) {
					if((options & DISTINCT)!= 0)
						max = array[i]-1;
					else
						max = array[i];
					if(max<=min)
						min=min-10;
				}else {
					if((options & DISTINCT)!= 0)
						min = array[i]+1;
						
					else
						min =array[i];
					
					if(min>=max)
						max=max+10;
				}
			}
					
		}
		
		return array;
	}
	
	//crear arreglo de tama�o N con valores aleatorios
	public static int[] createIntArray(int N, int min, int max){
		int[] array = new int[N];
		Random r = new Random();
		
		for(int i=0; i<array.length; i++)
			array[i] = min + r.nextInt(max-min+1);
		
		return array;
	}
	
	public static int[] createIntArray(int N, int min, int max, boolean useSeed,  long seed){
		int[] array = new int[N];
		Random r = new Random();
		
		if(useSeed)
			r.setSeed(seed);
		
		for(int i=0; i<array.length; i++)
			array[i] = min + r.nextInt(max-min+1);
		
		return array;
	}
	
	//imprimir en consola los valores del arreglo
	public static void printArray(int[] array){
		System.out.println(Arrays.toString(array));
	}
	
	//intercambia los valores del arreglo
	public static void swap(int[] array, int index1, int index2){
		if(index1>=0 && index1 < array.length &&
		   index2>=0 && index2 < array.length){
				int temp = array[index2];
				array[index2]= array[index1];
				array[index1]= temp;
		}else{
			System.out.println("indices fuera de rango");
		}
	}
	
	//intercambia los valores del arreglo
		public static <T extends Comparable<T>> void swap(T[] array, int index1, int index2){
			if(index1>=0 && index1 < array.length &&
			   index2>=0 && index2 < array.length){
					T temp = array[index2];
					array[index2]= array[index1];
					array[index1]= temp;
			}else{
				System.out.println("indices fuera de rango");
			}
		}
	
	//Verdadero si el arreglo est� ordenado ascendentemente
	public static boolean isSorted(int[] array){
		for(int i=0; i<array.length-1; i++){
			if(array[i]>array[i+1])
				return false;
		}
		
		return true;
	
		
	}
	
	public static void reverseArray(int []array){
		for(int i=0; i< array.length/2; i++)
			swap(array, i , array.length-i-1);
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = createIntArray(10, -200, 200,SORTED | DESC| DISTINCT | USE_SEED , 1002);
		printArray(arr);
		System.out.println(isSorted(arr));
		//swap(arr, 0, 9);
		arr = createIntArray(10, -200, 200,SORTED | DISTINCT | USE_SEED , 1002);
		printArray(arr);
		System.out.println(isSorted(arr));
		arr = createIntArray(10, -200, 200,SORTED | USE_SEED , 1002);
		printArray(arr);
		System.out.println(isSorted(arr));
		arr = createIntArray(10, -200, 200,USE_SEED , 1002);
		printArray(arr);
		System.out.println(isSorted(arr));
	}
}
