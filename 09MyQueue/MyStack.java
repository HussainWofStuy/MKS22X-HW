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
    public static boolean isMatching(String s){
	MyStack<Character> S = new MyStack<Character>();
	for(char next : s.toCharArray()){
	    if(next == '{' || next == '[' || next == '<' || next == '('){
		S.push(next);
	    }
	    if(next == '}' || next == ']' || next == '>' || next == ')'){
		try{
		    char m = getMatch(next);
		    if(S.pop() != m){
			System.out.println("Mismatch");
			return false;
		    }
		}catch(NoSuchElementException e){
		    System.out.println("Colse without any opens left!");
		    return false;
		}
	    }
	}
	return S.isEmpty();
    }

    public static char getMatch(char c){
	char match = 0;
	if(c == '}'){match = '{';}
	if(c == ')'){match = '(';}
	if(c == ']'){match = '[';}
	if(c == '>'){match = '<';}
	return match;
    }
    
    public static void main(String[] args){
	String input = "";
	if(args.length > 0){input =  args[0];}
	System.out.println(isMatching(input));
    }
}
