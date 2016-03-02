import java.util.*;
import java.io.*;
public class silver{
    int[][] y;
    public silver(int[][] o, int R1, int C1){
	y = new int[o.length][o[0].length];
	for(int i = 0; i < o.length; i++){
	    for(int k = 0; k < o[0].length; k++){
		y[i][k] = o[i][k];
	    }
	}
	y[R1][C1] = 1;
	//System.out.println(Arrays.deepToString(y));
    }

    public int countPaths(int r, int c, int t){
	for(int p = 0; p < t; p++){
	    for(int i = 0; i < y.length; i++){
		for(int k = 0; k < y[0].length; k++){
		    
		    if(y[i][k] == 0 && p%2 != (i+k)%2){
			
			if(i+1 < y.length && y[i+1][k] > 0){
			    y[i][k] += y[i+1][k];
			}
			
			if(i-1 >=0 && y[i-1][k] > 0){
			    y[i][k] += y[i-1][k];
			}
			if(k+1 < y[0].length && y[i][k+1] > 0){
			    y[i][k] += y[i][k+1];
			}
			if(k-1 >=0 && y[i][k-1] > 0){
			    y[i][k] += y[i][k-1];
			}
		    }
		    
		}
		
	    }
	    //System.out.println(Arrays.deepToString(y));
	    for(int u = 0; u < y.length; u++){
		for(int d = 0; d < y[0].length; d++){
		    if(y[u][d] != -1 && p%2 == (u+d)%2){y[u][d] = 0;}
		}
	    }
	    
	}
	
	return y[r][c];
    }
    
    public static void main(String[] args){
	File f = new File("ctravel.in");
	try{
	    Scanner line = new Scanner(f);
	    int N = line.nextInt();
	    int M = line.nextInt();
	    int T = line.nextInt();

	    String fill = line.nextLine();

	    char[][] b = new char[N][M];
	    for(int w = 0; w < N; w++){
		b[w] = line.nextLine().toCharArray();
	    }
	    
	    int[][] o = new int[N][M];
	    for(int i = 0; i < N; i++){
		for(int k = 0; k < M; k++){
		    if(b[i][k]=='*'){
			o[i][k] = -1;
		    }
		}
	    }

	    int R1 = line.nextInt();
	    int C1 = line.nextInt();
	    int R2 = line.nextInt();
	    int C2 = line.nextInt();

	    //System.out.println(R1 + " " + C1);
	    
	    silver g = new silver(o,R1-1,C1-1);

	    System.out.println(g.countPaths(R2-1,C2-1,T)+", 6, Waris, Hussain");

	}catch(FileNotFoundException e){
	    e.printStackTrace();
	}
    }
}

