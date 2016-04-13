import java.util.*;
public class MyDeque<T>{
    private T[] data;
    private int size;
    public int start;
    public int end;
    private int s2;
    @SuppressWarnings({"unchecked"})
    public MyDeque(){
	data = (T[]) new Object[10];
	start = 4;
	end = 4;
	s2 = 10;
    }

    public int size(){return size;}

              
    public void addFirst(T n){
	if(data[start] == null){
	    data[start] = n;   
	}else{
	    if(start-1 < 0){grow();}
	    data[start-1] = n;
	    start--;
	}
	size++;
    }

    public void addLast(T n){
	if(data[end] == null){
	    data[end] = n;
	}else{
	    if(end+1 > s2-1){grow();}
	    data[end+1] = n;
	    end++;
	}
	size++;
    }

    @SuppressWarnings({"unchecked"})
    public void grow(){
	T[] n = (T[]) new Object[s2*2];
	for(int i = s2/2, k = start; i < 3*s2-2 && k < end+1; i++, k++){
	    n[i] = data[k];
	}
	end += (s2)/2;
	start += (s2)/2;
	data = n;
	s2 = s2*2;
    }

    public void removeFirst(){
	if(data[start]==null){throw new NullPointerException();}
	data[start] = null;
	if(end!=start){start++;}
	size--;
    }

    public void removeLast(){
	if(data[start]==null){throw new NullPointerException();}
	data[end] = null;
	if(end!=start){end--;}
	size--;
    }	
	
    public T get(int i){
	return data[i];
    }
    
    public void deb(){
	for(T a : data){
	    System.out.print(a+" ");
	}   
	System.out.println();
    }
    
    public String toString(){
	String rS = "[";
	for(int i = start; i < end; i++){
	    if(data[i]!=null){rS += data[i] + ", ";}
	}
	if(data[end]!=null){return rS + data[end] + "]";}
	return rS + "]";
    }

    public static void main(String[] args){
	MyDeque<Integer> t = new MyDeque<Integer>();
	System.out.println(t);
	for(int h = 0, k = 10; h < 11; h++, k--){
	    t.addFirst(h);
	    t.addLast(k);
	    System.out.println(t);
	    // t.deb();
	}
	for(int h = 0, k = 10; h < 11; h++, k--){
	    t.removeFirst();
	    t.removeLast();;
	    System.out.println(t);
	    // t.deb();
	}
	
    }
}
