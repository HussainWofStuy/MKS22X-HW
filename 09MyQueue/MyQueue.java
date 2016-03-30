import java.util.*;
public class MyQueue<T> extends MyLinkedList<T>{
    private MyLinkedList<T> L;
    public void enqueue(T item){
	L.add(item);
    }
    public T dequeue(){
	if(size() <= 0){throw new NoSuchElementException();}
	return L.remove(0);
    }
    public T peek(){
	return L.get(0);
    }
    public int size(){
	return L.size();
    }
}
