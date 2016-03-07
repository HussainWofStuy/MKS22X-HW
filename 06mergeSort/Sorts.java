import java.util.*;
public class Sorts{
    public Sorts(){}
    
    public static void printArray(int[] data){
	String s = "[";
	for(int x = 0; x < data.length - 1; x ++){
	    s += data[x] + ", ";
	}
	System.out.println(s + data[data.length-1] + "]");
    }

    public static void fillRandom(int[] data){
	for(int k = 0; k < data.length; k++){
	    int sign = (int)(Math.pow(-1,(int)(Math.random()*2)));
	    int num = sign*(int)(Math.random()*10000);
	    data[k] = num;
	}
    }

    public static void swap(int[] data, int a, int b){
	int num = data[a];
	data[a] = data[b];
	data[b] = num;
    }

    public static void insertionSort(int[] data){
	int p;
	int k;
	//System.out.println("------------------");
	//System.out.println("Start insertion");
	for(int x = 0; x < data.length; x ++){
	    p = data[x];
	    k = x - 1;
	    while((0 <= k) && (p < data[k])){
		data[k+1] = data[k];
		k--;
	    }
	    data[k+1] = p;
	    //printArray(data);
	}
	//System.out.println("Done!");
	//System.out.println("-----------------");
    }

    public static void selectionSort(int[] data){
	//System.out.println("-----------------");
	//System.out.println("Start selection");
	//printArray(data);
	for(int i = 0; i < data.length - 1; i++){
	    int x = i;
	    for(int k = i + 1; k < data.length; k++){
		if(data[k] < data[x]){
		    x = k;
		}
	    }
	    int f = data[x];
	    data[x] = data[i];
	    data[i] = f;
	    //printArray(data);
	}
	//System.out.println("Done!");
	//System.out.println("-----------------");
    }

    public static void bubbleSort(int[] data){
	boolean s = true;
	int a;
	//System.out.println("-----------------");
	//System.out.println("Start bubble");
	while(s){
	    s = false;
	    for(int k = 0; k < data.length-1; k++){
		if(data[k] > data[k+1]){
		    a = data[k];
		    data[k] = data[k+1];
		    data[k+1] = a;
		    s = true;
		}
	    }
	    //printArray(data);
	}
	//System.out.println("Done!");
	//System.out.println("-----------------");
    }

    public static void  mergeSort(int[] a){
	int[] b = new int[a.length];
	b = new Sorts().mergeH(a);
	for(int i = 0; i < a.length; i++){
	    a[i] = b[i];
	}
    }

    public int[] mergeH(int[] a){
	if(a.length < 2){return a;}
	int sd = a.length / 2;
	int[] a1 = new int[sd];
	int[] a2 = new int[a.length-sd];
	for(int i = 0; i < a1.length; i++){
	    a1[i] = a[i];
	}
	for(int i = 0; i < a2.length; i++){
	    a2[i] = a[sd];
	    sd++;
	}
	//System.out.println(Arrays.toString(a1));
	//System.out.println(Arrays.toString(a2));
	//System.out.println(Arrays.toString(a));
	return merge(mergeH(a1),mergeH(a2));
    }

    public static int[] merge(int[] a, int[] b) {
	int[] answer = new int[a.length + b.length];
	int i = 0, j = 0, k = 0;
	while (i < a.length && j < b.length){
	    if (a[i] < b[j]){
		answer[k++] = a[i++];
	    }else{
		answer[k++] = b[j++];
	    }
	}
	while (i < a.length){
	    answer[k++] = a[i++];
	}
	while (j < b.length){
	    answer[k++] = b[j++];
	}
	return answer;
    }

    /*
    public static void main(String[] args){
	//Sorts g = new Sorts();
	
	int[] tA = new int[]{2,1,3,13,6,5,9,2,11,10};
	int[] tB = new int[]{2, 4, 6, 8, 10};


	//int[] tC = new int[]{2};
	//int[] tD = new int[]{1};
	//System.out.println(Arrays.toString(new Sorts().merge(tC,tD)));

	System.out.println(Arrays.toString(tA));
	mergeSort(tA);
	System.out.println(Arrays.toString(tA));
	//System.out.println(Arrays.toString(tA));
    }
    */
}

