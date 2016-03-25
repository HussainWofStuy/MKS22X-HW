import java.util.*;
//anonymous class - class you only declare once because you only need it once
public class MyLinkedList<T> implements Iterable<T>{
    public class MyLinkedListIteratorThing implements Iterator<T>{
	private LNode next;
	public MyLinkedListIteratorThing(){
	    next = start;
	}
	public boolean  hasNext(){
	    return next != null;
	}
	public T next(){
	    if(!hasNext()){throw new NoSuchElementException();}
	    T temp = next.getValue();
	    next = next.getNext();
	    return temp;
	}
	
	public void remove(){throw new UnsupportedOperationException();}
    }

    public Iterator<T> iterator(){
	return new MyLinkedListIteratorThing();
    }
       		
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

    public int size(){return size;}
    
    public boolean add(T value){
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

    public boolean add(int index, T value){
	if(index < 0 || index > size){throw new IndexOutOfBoundsException();}
	if(index == size){
	    end.setNext(new LNode(value));
	    end = end.getNext();
	    size++;
	    return true;
	}
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
	if(i < 0 || i >= size){throw new IndexOutOfBoundsException();}
	
	if(i==0){
	    T rV = start.getValue();
	    start = start.getNext();
	    size--;
	    return rV;
	}else{
	    LNode p = start;
	    for(int k = 0; k < i-1; k++){
		p = p.getNext();
	    }
	    T rV = p.getNext().getValue();
	    p.setNext(p.getNext().getNext());
	    if(i == size()-1){end = p;}
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

    public T set(int i, T v){
	if(i < 0 || i >= size){throw new IndexOutOfBoundsException();}
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
		s += ", ";
	    }
	    p = p.getNext();
	}
	return s + "]";
    } 

    public static void main(String[]args){
	MyLinkedList<Integer> m = new MyLinkedList<Integer>();
	for(int x = 0, x < 21; x+=2){
    }

    
}
