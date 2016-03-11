import java.util.*;
public class Quick{
    public Quick(){}

    public String name(){return "6,Waris,Hussain";}

    private static void swap(int[] data, int x, int y){
	int nX = data[x];
	data[x] = data[y];
	data[y] = nX;
    }

    ////////////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    
    public static void quickSortOld(int[] data){
	quickSortOld(data, 0, data.length-1);
	//System.out.println(Arrays.toString(data));
    }

    public static void quickSortOld(int[] data, int left, int right){
	if(left < right){
	    int p = partitionOld(data, left, right);
	    //System.out.println(p);
	    quickSortOld(data, left, p-1);
	    quickSortOld(data, p+1, right);
	}
	//System.out.println(Arrays.toString(data));
    }
    
    public static int quickselectOld(int[] data, int k){
	k = k-1;
	return quickSelectOld(data, k, 0, data.length-1);
    }
    
    public static int quickSelectOld(int[] data, int k, int left, int right){	
	if(right==left){return data[left];}
	int f = partitionOld(data, left, right);
	if(f==k){return data[k];}
	if(f > k){
	    return quickSelectOld(data, k, left, f-1);
	}else{
	    return quickSelectOld(data, k, f+1, right);
	}
    }
       
    public static int partitionOld(int[] data, int left, int right){
	int i = left + (int)(Math.random()*(right-left));
	swap(data,right,i);	
	int l = left, r = right-1;
	while(l!=r){
	    if(data[l] > data[right]){
		swap(data,r,l);
		r--;
	    }else{
		l++;
	    }
	}
	if(data[right] > data[r]){
	    swap(data,right,r+1);
	    return r+1;
	}else{
	    swap(data,right,r);
	    return r;
	}
    }


    ////////////////////////////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    
    public static void quickSort(int[] data){
	quickSort(data, 0, data.length-1);
	//System.out.println(Arrays.toString(data));
    }

    public static void quickSort(int[] data, int left, int right){
	if(left < right){
	    int[] p = partition(data, left, right);
	    //System.out.println(p);
	    quickSort(data, left, p[0]);
	    quickSort(data, p[1]+1, right);
	}
	//System.out.println(Arrays.toString(data));
    }

   
    public static int quickselect(int[] data, int k){
	k = k-1;
	return quickSelect(data, k, 0, data.length-1);
    }
    
    public static int quickSelect(int[] data, int k, int left, int right){	
	if(right==left){return data[left];}
	int[] p = partition(data, left, right);
	if(p[1]==k){return data[k];}
	if(p[1] > k){
	    return quickSelect(data, k, left, p[0]);
	}else{
	    return quickSelect(data, k, p[1]+1, right);
	}
    }
    
    

    public static int[] partition(int[] data, int left, int right){
	int i = left + (int)(Math.random()*(right-left));
	swap(data,right,i);	
	int l = left, r = right-1, c = 0;;
	while(l!=r){
	    if(data[l] == data[right]){c++;}
	    if(data[l] > data[right]){
		swap(data,r,l);
		r--;
	    }else{
		l++;
	    }
	}
  
	int E1 = 0, E2 = 0;
	if(data[right] > data[r]){
	    swap(data,right,r+1);
	    E1 = r+1;
	    E2 = r+1;
	}else{
	    swap(data,right,r);
	    E1 = r;
	    E2 = r;
	}

	//System.out.println(Arrays.toString(data));
	//System.out.println(E1);

	while(E2 >= 0 && data[E2]==data[E1]){E2--;}
	E2++;
	//System.out.println(E2);
	for(int o = 0; o < E2; o++){
	    if(data[o]==data[E1] && c > 0){
		swap(data, o, E2-1);
		E2--;
		c--;
	    }
	}
     
	int[] R = new int[]{E2,E1};
	return R;
    }




    
    public static void main(String[] args){
	int[] g = new int[]{4,3,9,4,10,11,5,3,2,-2,13};

	System.out.println(Arrays.toString(g));
        //System.out.println(partitionOld(g, 0, g.length-1));
	//System.out.println(Arrays.toString(partition(g, 0, g.length-1)));
	//System.out.println(quickselect(g,0));
	//quickSort(g);
	System.out.println(Arrays.toString(g));
	
    }
    
}
