import java.util.*;
public class RunningMedian{
    MyHeap<Integer> left = new MyHeap<Integer>(false);
    MyHeap<Integer> right = new MyHeap<Integer>(true);

    public RunningMedian(){}

    public double getMedian(){
	if(left.size() < 1 && right.size() < 1){
	    throw new NoSuchElementException();
	}
	if(left.size() > right.size()){
	    return left.peek();
	}
	if(left.size() > right.size()){
	    return left.peek();
	}
	return (left.peek()+right.peek())/2.0;
    }

    public void add(Integer i){
	if(left.size() < 1 && right.size() < 1){
	    right.add(i);
	    throw new NoSuchElementException();
	}
	if(i < getMedian()){
	    right.add(i);
	}else{
	    left.add(i);
	}
	if(left.size()-right.size() > 1){
	    left.add(right.delete());
	}    
	if(right.size()-left.size() > 1){
	    right.add(left.delete());
	}
    }
}
