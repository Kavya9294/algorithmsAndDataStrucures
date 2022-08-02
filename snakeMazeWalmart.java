
import java.util.*;
public class MyClass {
public static void findAllPaths(char[][] maze){
	List<Integer> rows = new ArrayList<>();
	List<Integer> cols = new ArrayList<>();
	for(int i = 0; i < maze.length; i++){
		for(int j = 0; j < maze[0].length;j++){
			if(maze[i][j] == '+'){
				break;
			}
			if(j == maze[0].length-1){
				rows.add(i);
			}
		}
	}

	for(int i = 0; i < maze[0].length;i++){
		for(int j = 0; j < maze.length; j++){
			if(maze[j][i] == '+'){
				break;
			}
			if( j == maze.length-1){
				cols.add(j);
			}
		}
	}

	System.out.println("rows: "+ rows);
	System.out.println("cols: "+ cols);
}

 static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
static int n=0, m=0;
public static boolean isBoundary(int i, int j){
	if( i==0 || i==n-1 || j==0 || j==m-1){
		return true;
	}
	return false;
}

public static void shortestPath(char[][] maze, int[] start){
	Deque<int[]> q = new ArrayDeque<>();
	n = maze.length;
	m = maze[0].length;
	int[] res = new int[2];
	q.offer(start);
	maze[start[0]][start[1]] = '+';
	while( !q.isEmpty()){
		int[] cur = q.poll();
		//skip for first time
		if(maze[cur[0]][cur[1]] != '+'){
			maze[cur[0]][cur[1]] = '+';
			if(isBoundary(cur[0], cur[1])){
				res = cur;
				System.out.println(res[0] +", "+ res[1]);
				break;
			}
		}

		for( int i = 0; i < directions.length; i++){
			int newRow = cur[0]+directions[i][0];
			int newCol = cur[1]+directions[i][1];
			if((newRow>=0 && newRow<n) && (newCol>=0 && newCol<m) && maze[newRow][newCol] == '0'){
				int[] next = {newRow,newCol};
				q.offer(next);
			}
		}

	}
	

}
    public static void main(String args[]) {
      char[][] board1 =
{{'+', '+', '+', '+', '+', '+', '+', '0', '0'},
{'+', '+', '0', '0', '0', '0', '0', '+', '+'},
{'0', '0', '0', '0', '0', '+', '+', '0', '+'},
{'+', '+', '0', '+', '+', '+', '+', '0', '0'},
{'+', '+', '0', '0', '0', '0', '0', '0', '+'},
{'+', '+', '0', '+', '+', '0', '+', '0', '+'}   
};
    // findAllPaths(board1);
    int[] cur = {5, 5};
    shortestPath(board1, cur);
    }
}


