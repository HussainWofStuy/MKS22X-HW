public class QueenBoard{
    private int[][]board;

    public QueenBoard(int size){
	board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *postcondition: 
     *-return false, and board is still filled
     *with 0's for a board that cannot be solved.
     *-return true, and board is filled with the 
     *final configuration of the board after adding 
     *all n queens.
     */
    public boolean solve(){
	return solvenH(0);
    }

    public boolean solvenH(int col){
	if(col == board.length){
	    return true;
	}
	for(int k = 0; k < board[col].length; k++){
	    if(addQueen(k,col)){
		if(solvenH(col+1)){
		    return true;
		}
		else{
		    removeQueen(k,col);
		}
	    }
	}
	return false;
    }

    public void printSolution(){
	/**Print the board like toString, except
	      all negative numbers, and 0's are replaced with '_'
	         and all 1's are replaced with 'Q'
	*/
	for(int i = 0; i < board.length; i++){
	    for(int k = 0; k < board[i].length; k++){
		if(board[i][k] == 1){
		    System.out.print("Q ");
		}
		System.out.print("_ ");
	    }
	    System.out.println();
	}
    }

    public boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	col++;
	int offset = 1;
	while(col < board[row].length){
	    board[row][col]--;
	    if(row - offset >= 0){
		board[row-offset][col]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col]--;
	    }
	    col++;
	    offset++;
	}
	return true;
    }

    public boolean removeQueen(int row, int col){
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = 0;
	col++;
	int offset = 1;
	while(col < board[row].length){
	    board[row][col]++;
	    if(row - offset >= 0){
		board[row-offset][col]++;
	    }
	    if(row + offset < board.length){
		board[row+offset][col]++;
	    }
	    col++;
	    offset++;
	}
	return true;
    }

    public String  toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		ans+= board[r][c]+"\t";
	    }
	    ans+="\n";
	}
	return ans;
    }




    
    public static void main(String[]args){
	QueenBoard b = new QueenBoard(8);
	b.solve();
	b.printSolution();
	/*
	System.out.println(b);
	b.addQueen(3,0);
	b.addQueen(0,1);
        System.out.println(b);
	b.removeQueen(3,0);
        System.out.println(b);
	*/
    }
    
}
