import java.util.*;
public class ParenDemo{
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
