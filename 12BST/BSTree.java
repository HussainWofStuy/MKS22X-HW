import java.util.*;
public class BSTree<T extends Comparable<T>>{
    private class Node{
	T data;
	Node left;
	Node right;
	
	public Node(T a){
	    data = a;
	}
	public void setLeft(T d){
	    left = new Node(d);
	}
	public void setRight(T d){
	    right = new Node(d);
	}
	public void setValue(T d){
	    data = d;
	}
	public Node getLeft(){
	    return left;
	}
	public Node getRight(){
	    return right;
	}
	public T getValue(){
	    return data;
	}
	public int height(){
	    if(left == null && right == null){
		return 1;
	    }else if(left == null){
		return 1 + right.height();
	    }else if(right == null){
		return 1 + left.height();
	    }else{
		return Math.max(1+right.height(),1+left.height());
	    }
	}
	public boolean contains(T v){
	    if(v.compareTo(data) == 0){
		return true;
	    }else if(v.compareTo(data) > 0 && left!=null){
		return left.contains(v);
	    }else if(v.compareTo(data) < 0 && right!=null){
		return right.contains(v);
	    }else{
		return false;
	    }
	}
	public void add(T v){
	    if(v.compareTo(data) < 0){
		if(left==null){left = new Node(v);}
		else{left.add(v);}
	    }else if(v.compareTo(data) > 0){
	        if(right==null){right = new Node(v);}
		else{right.add(v);}
	    }
	}
	public String toString(){
	    if(left == null && right == null){
		return data + " " + "_" + " " + "_";
	    }else if(left == null){
		return data + " " + "_" + " " + right.toString();
	    }else if(right == null){
		return data + " " + left.toString() + " " + "_";
	    }else{
		return data + " " + left.toString() + " " + right.toString();
	    }
	}
    }
    private Node root;
    
    public int getHeight(){
	if(root == null){return 0;}
	return root.height();
    }
    public boolean contains(T v){
	if(root == null){return false;}
        return root.contains(v);
    }
    public void add(T v){
	if(root == null){
	    root = new Node(v);
	}else{
	    root.add(v);
	}
    }
    public String toString(){
	if(root == null){return "";}
	return root.toString();
    }

    /*
    public static void main(String[] args){
	BSTree<Integer> b = new BSTree<Integer>();
	b.add(9);
	b.add(4);
	b.add(5);
	b.add(10);
	b.add(12);
	System.out.println(b);
	System.out.println(b.getHeight());
    }
    */
}
