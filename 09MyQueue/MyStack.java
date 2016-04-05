import java.util.*;
public class MyStack<T> extends MyLinkedList<T>{
    private MyLinkedList<T> L;
    public MyStack(){
	L = new MyLinkedList<T>();
    }
    public void push(T item){
	L.add(item);
    }
    public T pop(){
	if(size()<=0){throw new NoSuchElementException();}
	return L.remove(size()-1);
    }
    public T peek(){
	if(size()<=0){throw new NoSuchElementException();}
	return L.get(size()-1);
    }
    public int size(){
	return L.size();
    }
    public boolean isEmpty(){
	return size()==0;
    }
    public String toString(){
        System.out.print(L);
	return "";
    }

    public static void main(String[] args){
	/*
	Random rand = new Random(0);
	for(int i = 0; i < 6000; i++){
	    int op = rand.nextInt(4);
	    if(op == 0 || S.size()==0){
		s.push(""+i);
		S.push(""+i);
	    }else{
		if(op == 1){
		    s.push(""+i);
		    S.push(""+i);
		}
		if(op > 1){
		    if(!s.peek().equals(S.peek())){
			System.out.println("Non matching elements at end");
			System.exit(1);
		    }
		    if(!s.pop().equals(S.pop())){
			System.out.println("Non matching elements remove");
			System.exit(1);
		    }
		}	       
	    }
	}
	System.out.println(s);
	*/
    }
}
