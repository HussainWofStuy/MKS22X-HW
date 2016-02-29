import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private int startx, starty;
    private boolean animate;
    
    
    /*Constructor loads a maze text file.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (only 1 per file)
      'S' - the location of the start(only 1 per file)

     2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found, print an error and exit the program.
    */
    public Maze(String filename, boolean ani){
	animate = ani;
	
	File a = new File(filename);
	try{
	    Scanner l = new Scanner(a);
	    //Scanner lp = new Scanner(a);
	    Scanner lr = new Scanner(a);
	    Scanner lc = new Scanner(a);
	    
	    int R = 0;
	    int C = 0;
	    
	    String cC = lr.nextLine();
	    R = cC.length();
	    lr.close();
	    
	    while(lc.hasNextLine()){
		C++;
		lc.nextLine();
	    }
	    lc.close();
	    
	    maze = new char[C][R];
	    //char[][] smaze = new char[C][R];
	    for(int r = 0; l.hasNextLine() && r < maze.length; r++){
		maze[r] = l.nextLine().toCharArray();
	    }
	    //lp.close();

	    /*
	    for(int i = 0; i < maze.length; i++){
		for(int k = 0; k < maze[0].length; k++){
		    maze[i][k] = smaze[k][i];
		}
	    }
	    */
	    
	    l.close();
	    
	    for(int k = 0; k < maze.length; k++){
		for(int i = 0; i < maze[0].length; i++){
		    if(maze[k][i]=='S'){
			startx = k;
			starty = i;
			k = maze.length;
			i = maze[0].length;
		    }
		}
	    }
	    
	}
	catch(FileNotFoundException e){
	    System.out.print("Breh");
	}
	
    }



    /*Main Solve Function

      Things to note:
       When no S is contained in maze, print an error and return false.
    */
    public boolean solve(){
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}else{
	    maze[startx][starty] = ' ';
	    return solve(startx,starty);
	}
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.
      The S is replaced with '@' but the 'E' is not.

      Postcondition:
        Returns true when the maze is solved,
        Returns false when the maze has no solution.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'

     */

    private boolean solve(int x, int y){
	if(animate){
	    System.out.println(this);
	    wait(20);
	}

	if(maze[x][y]=='E'){
	    return true;
	}
	
	if(maze[x][y]==' '){
	    
	    maze[x][y] = '@';
	    if(solve(x+1,y)||solve(x,y+1)||solve(x,y-1)||solve(x-1,y)){
		return true;
	    }else{
		maze[x][y] = '.';
	    }
	}
		
	//animate = false;
	return false; //so it compiles
    }

    





    
    //FREE STUFF!!! *you should be aware of this
        //MORE FREE STUFF!!! *you can ignore all of this*
    //Terminal keycodes to clear the terminal, or hide/show the cursor
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    
    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public String toString(){
	int maxx = maze.length;
	int maxy = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
	}
	for(int i = 0; i < maxx; i++){
	    for(int k = 0; k < maxy; k++){
		char c =  maze[i][k];
		if(c == '#'){
		    ans += color(38,47)+c;
		}else{
		    ans += color(32,40)+c;
		}
	    }
	    ans += "\n";
	}
	return HIDE_CURSOR + go(0,0) + ans + "\n" + SHOW_CURSOR + color(37,40);
    }


    //END FREE STUFF


    

}
