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

    public class MLLIteratorBack implements Iterator<T>{
	private LNode next;
	public MLLIteratorBack(){
	    next = end;
	}
	public boolean  hasNext(){
	    return next != null;
	}
	public T next(){
	    if(!hasNext()){throw new NoSuchElementException();}
	    T temp = next.getValue();
	    next = next.getPrev();
	    return temp;
	}
	
	public void remove(){throw new UnsupportedOperationException();}
    }

    public Iterator<T> iteratorBack(){
	return new MLLIteratorBack();
    }
       		
    private class LNode{
	private T data;
	private LNode next;
	private LNode prev;
	public LNode(T i){data = i;}
	private LNode getNext(){return next;}
	private LNode getPrev(){return prev;}
	private T getValue(){return data;}
	private void setValue(T i){data = i;}
	private void setPrev(LNode p){prev = p;}
	private void setNext(LNode p){next = p;}
    }

    private LNode start;
    private LNode end;
    private int size;

    public int size(){return size;}
    
    public boolean add(T value){
	if(size == 0){
	    start = new LNode(value);
	    size++;
	    end = start;
	    return true;
	}else{	    
	    return add(size(), value);
	}
    }
   
    public boolean add(int index, T value){
	if(index < 0 || index > size){throw new IndexOutOfBoundsException();}
	if(index == 0){
	    LNode p = start;
	    start = new LNode(value);
	    start.setNext(p);
	    p.setPrev(start);
	}
	if(index == size()){
	    LNode p = end;
	    end = new LNode(value);
	    end.setPrev(p);
	    p.setNext(end);
	}else{
	    LNode p = start;
	    for(int i = 0; i < index-1; i++){
		p = p.getNext();
	    }
	    LNode s1 = p.getNext();
	    p.setNext(new LNode(value));
	    p.getNext().setPrev(p);
	    p.getNext().setNext(s1);
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
	return remove(0);
    }
    
    public T remove(int i){
	if(i < 0 || i >= size){throw new IndexOutOfBoundsException();}
	if(i==0){
	    if(size == 1){
		T rV = start.getValue();
		start = null;
		end = null;
		size--;
		return rV;
	    }else{
		T rV = start.getValue();
		start = start.getNext();
		if(start.getNext()==null){}
		start.setPrev(null);
		size--;
		return rV;
	    }
	}else{
	    LNode p = start;
	    for(int k = 0; k < i-1; k++){
		p = p.getNext();
	    }
	    T rV = p.getNext().getValue();
	    if(i == size()-1){end = p;p.setNext(null);
	    }else{
		p.setNext(p.getNext().getNext());
		p.getNext().setPrev(p);
	    }
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

    public String toString(boolean f){
	return "head -- " + start.getValue() + ", end -- " + end.getValue();
    }
    


   
    public static void main(String[]args){
	/*
	MyLinkedList<Integer> m = new MyLinkedList<Integer>();
	for(int i = 0; i < 10; i++){
	    m.add(i);
	    System.out.println(m);
	}

	Iterator<Integer> i = m.iteratorBack();
	for(Integer a : m){
	    System.out.println(a);
	}

	
	for(int i = 0; i < 9; i++){
	    m.remove(m.size()-1);
	    //System.out.println(m.size());
	    //System.out.println(m.start.getValue());
	    System.out.println(m);
	}
	
	for(int i = 0; i < 10; i++){
	    m.remove(i);
	    System.out.println(m);
	}
	*/
    }

   
}
