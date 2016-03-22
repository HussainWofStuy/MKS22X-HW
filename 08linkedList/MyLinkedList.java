import java.util.*;
public class MyLinkedList<T>{
    private class LNode{
	private T data;
	private LNode next;
	public LNode(T i){data = i;}
	private LNode getNext(){return next;}
	private T getValue(){return data;}
	private void setValue(T i){data = i;}
	private void setNext(LNode p){next = p;}
    }

    private LNode start;
    private LNode end;
    private int size;

    public  boolean add(T value){
	if(start == null){
	    start = new LNode(value);
	    end = start;
	}else{	
	    end.setNext(new LNode(value));
	    end = end.getNext();
	}
	size++;
	return true;
    }
    
    /*
    public boolean add(int value){
	if(start == null){
	    start = new LNode(value);    
	}else{
	    LNode p = start;
	    while(p.getNext()!=null){
		p = p.getNext();
	    }
	    p.setNext(new LNode(value));
	}
	size++;
	return true;
    }
    */

    public boolean add(T value, int index){
	if(index == 0){
	    LNode p = start;
	    start = new LNode(value);
	    start.setNext(p);
	}else{
	    LNode p = start;
	    for(int i = 0; i < index-1; i++){
		p = p.getNext();
	    }
	    LNode s = p.getNext();
	    p.setNext(new LNode(value));
	    p = p.getNext();
	    p.setNext(s);
	}
	size++;
	return true;
    }

    /*
    public T indexOf(T val){
	LNode p = start;
	int c = 0;
	while(p.getNext()!=null){
	    if(p.getValue() == val){
		return c; 
	    }
	    p = p.getNext();
	    c++;
	}
	return -1;
    }
    */
    
    public T remove(){
	T rV = start.getValue();
	start = start.getNext();
	size--;
	return rV;
    }
    
    public T remove(int i){
	if(i==0){
	    T rV = start.getValue();
	    start = start.getNext();
	    return rV;
	}else{
	    LNode p = start;
	    for(int k = 0; k < i-1; k++){
		p = p.getNext();
	    }
	    T rV = p.getNext().getValue();
	    p.setNext(p.getNext().getNext());
	    size--;
	    return rV;
	}
    }

    public T get(int i){
	LNode p = start;
	for(int k = 0; k < i; k++){
	    p = p.getNext();
	}
	return p.getValue();
    }

    public T set(int i, int v){
	LNode p = start;
	for(int k = 0; k < i; k++){
	    p = p.getNext();
	}
	T rV = p.getValue();
	p.setValue(rV);
	return rV;
    }

    public String toString(){
	String s = "[";
	LNode p =  start;
	while(p!=null){
	    s += p.getValue();
	    if(p.getNext()!=null){
		s += ",";
	    }
	    p = p.getNext();
	}
	return s + "]";
    } 

    /*
    public static void main(String[]args){
	MyLinkedList<String> m = new MyLinkedList<String>();

	m.add(new String("Hello?"));
	System.out.println(m);

	MyLinkedList< m = new MyLinkedList();

	ArrayList<Integer> n = new ArrayList<Integer>();
       
	long start,end;
		
	start = System.currentTimeMillis();
	//code to test here on ArrayList n
	for(int i = 0; i < 10000000; i++){
	    n.add(i);
	}
	end = System.currentTimeMillis();
	System.out.println("Time: " + (end-start)/1000.0 + " seconds for ArrayList");
	
	start = System.currentTimeMillis();
	for(int i = 0; i < 10000000; i++){
	    m.add(i);
	}
	end = System.currentTimeMillis();
	System.out.println("Time: " + (end-start)/1000.0 + " seconds for MyLinkedList");	
       
    }    
    */
}
