import java.util.*;
public class Quick{
    public Quick(){}

    public String name(){return "6,Waris,Hussain";}
    
    public static int quickselect(int[] data, int k){
	k = k-1;
	k = data.length - k;
	return quickSelect(data, k, 0, data.length-1);
    }
    
    public static int quickSelect(int[] data, int k, int left, int right){
	if(left <= right){
	    if(right==left){return data[left];}
	    int f = partition(data, left, right);
	    if(f==k){return data[k];}
	    if(f > k){
		return quickSelect(data, k, left, f-1);
	    }
	    if(f < k){
		return quickSelect(data, k, f+1, right);
	    }
	}
	return 0;
    }

    private void swap(int[] data, int x, int y){
	int nX = data[x];
	data[x] = data[y];
	data[y] = nX;
    }
    
    public static int partition(int[] data, int left, int right){
	Quick q = new Quick();
	int f = left + new Random().nextInt(right-left+1);
	q.swap(data, right, f);
	for (int i = left; i < right; i++) {
	    if (data[i] > data[right]) {
		q.swap(data, i, left);
		left++;
	    }
	}
	q.swap(data, left, right);
	return left;
    }

    /*
    public static void main(String[] args){
	int[] g = new int[]{1, 2, 3, 4, 5,6};
	
	System.out.println(new Quick().quickselect(g, 2));
	
    }
    */
}
