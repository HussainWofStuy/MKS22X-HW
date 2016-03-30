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

    public String toString(boolean f){
	return "head -- " + start.getValue() + ", end -- " + end.getValue();
    }
    


   
    public static void main(String[]args){
	MyLinkedList<String> m = new MyLinkedList<String>();
	ArrayList<String>    n = new ArrayList<String>();
	
	for(int i = 0; i < 10; i++){
	    n.add(""+i);
	    m.add(""+i);
	}
	
	try{
	    m.add(-1,"oops");
	    System.out.println("\n\nAdd -1 #####################################");
	}catch(IndexOutOfBoundsException e){
	    
	}
	try{
	    m.add(12,"oops");
	    System.out.println("\n\n add 12 #####################################");
	}catch(IndexOutOfBoundsException e){
	    
	    }
	try{
	    m.remove(12);
	    System.out.println("\n\n remove 12 #####################################");
	}catch(IndexOutOfBoundsException e){
	    
	}
	
	try{
	    m.set(12,"Fwazzat?!?");
	    System.out.println("\n\n set 12 #####################################");
	}catch(IndexOutOfBoundsException e){
	    
	}
	
	
	
	
	
	//replace toString(true) with a debug to string that shows the head/tail
	System.out.println(m.toString(true));
	System.out.println(n);
	
	//test removing from head/tail/middle
	m.remove(0);
	n.remove(0);
	System.out.println(m.toString(true));
	
	m.remove(2);
	n.remove(2);
	System.out.println(m.toString(true));
	
	m.remove(m.size()-1);
	n.remove(n.size()-1);
	System.out.println(m.toString(true));
	System.out.println(n);
	
	//test adding to end/start
	m.add(0,"START");
	n.add(0,"START");
	m.add(m.size(),"PENULTIMATE");
	n.add(n.size(),"PENULTIMATE");
	System.out.println(m.toString(true));
	System.out.println(n);
	
	//test add
	m.add("Z-END!");
	n.add("Z-END!");
	System.out.println(m.toString(true));
	System.out.println(n);
	    
	//test remove random items:
	Random rand = new Random(0);
	for(int i = 0; i < 6000; i++){
	    int op = rand.nextInt(4);
	    
	    if(op == 0 || n.size()==0){//ensure never empty
		n.add(""+i);
		m.add(""+i);
	    }else if(op == 1 ){
		int x = rand.nextInt(n.size());
		n.add(x,""+i);
		m.add(x,""+i);
	    }else{
		int x = rand.nextInt(n.size());
		if(!n.remove(x).equals(m.remove(x))){
		    System.out.println("Non matching elements removed\n");
		    System.exit(1);
		}
	    }
	}
	System.out.println(m.toString(true));
	System.out.println(n);
	
	/*test speed of add in front and at end.
	  long start,end;
	  System.out.println("Add 100k to front");
	  
	  start = System.currentTimeMillis();
	  for(int i = 0; i < 100000; i++)
	  n.add(0,""+i);
	  end = System.currentTimeMillis();
	  System.out.println( "ArrayList "+(end-start)/1000.0 );
	  
	  start = System.currentTimeMillis();
	  for(int i = 0; i < 100000; i++)
	  m.add(0,""+i);
	  end = System.currentTimeMillis();
	  System.out.println( "LinkedList "+(end-start)/1000.0 );
	  
	  
	  System.out.println("Add 1m to end");
	  
	  start = System.currentTimeMillis();
	  for(int i = 0; i < 1000000; i++)
	  n.add(""+i);
	  end = System.currentTimeMillis();
	  System.out.println( "ArrayList "+(end-start)/1000.0 );
	  
	  start = System.currentTimeMillis();
	  for(int i = 0; i < 1000000; i++)
	  m.add(""+i);
	  end = System.currentTimeMillis();
	  System.out.println( "LinkedList "+(end-start)/1000.0 );
	  
	*/
    }

   
}
