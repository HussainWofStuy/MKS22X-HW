import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
    private T[] heap;
    private int size;
    private boolean isMax;
    
    public MyHeap(){
	heap = (T[]) new Comparable[20];
	size = 1;
	isMax = true;
    }

    public MyHeap(T[] h){
	size = h.length;
	heap = (T[]) new Comparable[size+1];
	for(int i = 1; i  < size+1; i++){
	    heap[i] = h[i-1];
	}
	isMax = true;
	heapify();
    }

    public MyHeap(boolean f){
	isMax = f;
	heap = (T[]) new Comparable[20];
	size = 1; 
    }

    public MyHeap(T[] h, boolean f){
	size = h.length;
	heap = (T[]) new Comparable[size+1];
	for(int i = 1; i < size+1; i++){
	    heap[i] = h[i-1];
	}
	isMax = f;
	heapify();
    }
    
    public String toString(){
	String s = "[";
	for(int i = 1; i < size; i++){
	    s += heap[i]+", ";;
	}
	return s + heap[size] + "]";
    }


    public  void swap(T[] o, int i, int j){
	T temp = o[i];
	o[i] = o[j];
	o[j] = temp;
    }
    
    public void pushDown(int k){
	if(k < size/2 + 1){
	    if(isMax){
		if(!( heap[k].compareTo(heap[2*k]) > 0 && heap[k].compareTo(heap[2*k+1]) > 0)){
		    int u;
		    if(heap[2*k].compareTo(heap[2*k+1]) > 0){u = 2*k;}
		    else{u = 2*k+1;}
		    swap(heap, k, u);
		    pushDown(u);
		}
	    }else{
		if(heap[k].compareTo(heap[2*k]) > 0 || heap[k].compareTo(heap[2*k+1]) > 0){
		    int u;
		    if(heap[2*k].compareTo(heap[2*k+1]) < 0){u = 2*k;}
		    else{u = 2*k+1;}
		    swap(heap, k, u);
		    pushDown(u);
		}
	    }
	}
    }

    public void pushUp(int k){
	if(k > 1){
	    if(isMax){
		if(heap[k].compareTo(heap[k/2]) > 0){
		    swap(heap, k, k/2);
		    pushUp(k/2);
		}
	    }else{
		if(heap[k].compareTo(heap[k/2]) < 0){
		    swap(heap, k, k/2);
		    pushUp(k/2);
		}
	    }
	}
    }

    public void heapify(){
	for(int i = size/2; i > 0; i--){
	    pushDown(i);
	}
    }

    public void add(T x){
	if(size+1 > heap.length-1){
	    doubleSize();
	}
	heap[size+1] = x;
	pushUp(size+1);
	size++;
    }

    public void doubleSize(){
	T[] rHeap = (T[]) new Comparable[heap.length * 4];
	for(int i = 1; i < size + 1; i++){
	    rHeap[i] = heap[i];
	}
	heap = rHeap;
    }
    
    public T delete(){
	if(size == 0){throw new NoSuchElementException();}
	T rVal = heap[1];
	if(size == 1){
	    heap[1] = null;
	    return rVal;
	}
	heap[1] = heap[size];
	heap[size] = null;
	size--;
	pushDown(1);
	return rVal;
    }

    /*
    public static void main(String[] args){
	Integer[] y = {0, 5, 10, 3, 2, 7, 9, 11, -1};
	MyHeap<Integer> h = new MyHeap<Integer>(y, false);
	System.out.println(h);
	h.add(6);
	System.out.println(h);
	h.delete();
	System.out.println(h);
    }
    */
}
