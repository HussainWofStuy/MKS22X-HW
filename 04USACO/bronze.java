import java.util.*;
import java.io.*;
public class bronze{
    int[][] b = new int[4][6];

    public bronze(int[][] h){
	b = h;
    }
   
    public void stompDown(int r, int c, int n){
	int k = Math.max(b[r-1][c-1],b[r-1][c]);
	k = Math.max(k,b[r-1][c+1]);
        //System.out.println(k);
	k-=n;
	for(int i = r-1; i <= r+1; i++){
	    for(int f = c-1; f <= c+1; f++){
		if(b[i][f] > k){
		    b[i][f] = k; 
		}
	    }
	}
    }

    public void finalDown(int E){
	for(int i = 0; i < b.length; i++){
	    for(int k = 0; k < b[0].length; k++){
		b[i][k] = E - b[i][k];
	    }
	}
    }

    public int depthSum(){
	int s = 0;
	for(int i = 0; i < b.length; i++){
	    for(int k = 0; k < b[0].length; k++){
		if(b[i][k]>0){
		    s+=b[i][k];
		}
	    }
	}
	return s;
    }

    public int finalVol(){
	return 72*72*depthSum();
    }

    public void print(){
	for(int k = 0; k < b.length; k++){
	    for(int i = 0; i < b[0].length; i++){
		if(b[k][i]>=0 && b[k][i]<10){
		    System.out.print(b[k][i]+" ");
		}
		if(b[k][i]>=10){
		    System.out.print(b[k][i]+" ");
		}
		if(b[k][i]<0){
		    System.out.print("- ");
		}
	    }
	    System.out.println();
	}
    }
    
    public static void main(String[] args){
	File f = new File("makelake.in");
	try{
	    Scanner line = new Scanner(f);
	    int R = line.nextInt();
	    int C = line.nextInt();
	    int D = line.nextInt();
	    int N = line.nextInt();
	    int[][] b = new int[R][C];
	    for(int w = 0; w < R; w++){
		for(int z = 0; z < C; z++){
		    b[w][z] = line.nextInt();
		}
	    }

	    bronze g = new bronze(b);
	    
	    int n = 0;
	    while(line.hasNext() && n<N){
		g.stompDown(line.nextInt(),line.nextInt(),line.nextInt());
		n++;
		//g.print();
		//System.out.println();
	    }

	    g.finalDown(D);
	    System.out.println(g.finalVol()+", 6, Waris, Hussain");
	}catch(FileNotFoundException e){
	    e.printStackTrace();
	}
	/*
	bronze g = new bronze(b);

	g.print();
	System.out.println();
	g.stompDown(1,4,4);
	g.print();
	System.out.println();
	g.stompDown(1,1,10);
	
	g.print();
	System.out.println();

	g.stompDown(1,3,14);
	g.print();
	System.out.println();
	

	g.finalDown(22);
	g.print();
	System.out.println();
	System.out.println(g.finalVol());
	*/
    }
    
}

