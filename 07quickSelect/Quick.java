import java.util.*;
public class Quick{
    public Quick(){}

    public static int partition(int[] data, int left, int right){
	Random rand = new Random();
	int c = rand.nextInt(right-left+1) + left;
	int d = data[c];
	System.out.println(d);
	data[c] = data[right];
	data[right] = d;
	int tempLeft = left;
	int tempRight = right - 1;
	while(tempLeft != tempRight){
	    if(data[tempLeft] <= d){tempLeft++;}
	    if(data[tempLeft] > d){
		int s1 = data[tempLeft];
		data[tempLeft] = data[tempRight];
		data[tempRight] = s1;
		tempRight--;
	    }
	}
	data[right] = data[tempRight+1];
	data[tempRight+1] = d;
	if(data[tempRight] > d){
	    data[tempRight+1] = data[tempRight];
	    data[tempRight] = d;
	}
	return tempRight+1;
    }

    public static void main(String[] args){
	int[] g = new int[]{4,6,13,99,45,113,112,9,6,5,-88,1000,345,66,44};
	System.out.println(Arrays.toString(g));
	System.out.println(new Quick().partition(g, 0, g.length-1));
	System.out.println(Arrays.toString(g));
    }
}
