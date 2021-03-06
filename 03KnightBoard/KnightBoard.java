
public class KnightBoard{
    int[][] board;

    public KnightBoard(int n, int n1){
	board = new int[n][n1];
    }
    
    public boolean  solve(){
	if(solveH(0,0,1,1)){
	    return true;
	}
	System.out.println("No solution for this board!");
	return false;
    }

    public boolean solveH(int row, int col, int index,  int n){
	if(board[row][col]!=0){
	    return false;
	}
	board[row][col] = n;
	if(index == board.length*board[0].length){
	    return true;
	}
	if(canMove(row+1, col+2)){
	    if(solveH(row+1, col+2, index+1, n+1)){
		return true;
	    }
	}
	if(canMove(row+1, col-2)){
	    if(solveH(row+1, col-2, index+1, n+1)){
		return true;
	    }
	}
	if(canMove(row-1, col+2)){
	    if(solveH(row-1, col+2, index+1, n+1)){
		return true;
	    }
	}
	if(canMove(row-1, col-2)){
	    if(solveH(row-1, col-2, index+1, n+1)){
		return true;
	    }
	}
	if(canMove(row+2, col+1)){
	    if(solveH(row+2, col+1, index+1, n+1)){
		return true;
	    }
	}
	if(canMove(row+2, col-1)){
	    if(solveH(row+2, col-1, index+1, n+1)){
		return true;
	    }
	}
	if(canMove(row-2, col+1)){
	    if(solveH(row-2, col+1, index+1, n+1)){
		return true;
	    }
	}
	if(canMove(row-2, col-1)){
	    if(solveH(row-2, col-1, index+1, n+1)){
		return true;
	    }
	}
	board[row][col] = 0;
	return false;
    }

    public boolean canMove(int row, int col){
	if(row >=0 && col >= 0 && row < board.length && col < board[0].length){
	    return true;
	}
	return false;
    }

    void printSolution(){
	for(int i = 0; i < board.length; i++){
	    for(int k = 0; k < board.length; k++){
		if(board[i][k]<10){
		    System.out.print(" "+board[i][k]+" ");
		}
		if(board[i][k] >= 10){
		    System.out.print(board[i][k]+" ");
		}
	    }
	    System.out.println();
	}
    }
    /*
    public static void main (String[] args){
	KnightBoard k = new KnightBoard(3,5);
	if(k.solve()){
	    k.printSolution();
	}

    }
    */
}
