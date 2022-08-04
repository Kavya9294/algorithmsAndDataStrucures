import java.io.*;
import java.util.*;
/*
 After catching your classroom students cheating before, you realize your students are getting craftier and hiding words in 2D grids of letters. The word may start anywhere in the grid, and consecutive letters can be either immediately below or immediately to the right of the previous letter.

Given a grid and a word, write a function that returns the location of the word in the grid as a list of coordinates. If there are multiple matches, return any one.

grid1 = [
    ['c', 'c', 't', 'n', 'a', 'x'],  
    ['c', 'c', 'a', 't', 'n', 't'],  
    ['a', 'c', 'n', 'n', 't', 't'],  
    ['t', 'n', 'i', 'i', 'p', 'p'],  
    ['a', 'o', 'o', 'o', 'a', 'a'],
    ['s', 'a', 'a', 'a', 'o', 'o'],
    ['k', 'a', 'i', 'o', 'k', 'i'],
]
word1 = "catnip"
word2 = "cccc"
word3 = "s"
word4 = "ant"
word5 = "aoi"
word6 = "ki"
word7 = "aaoo"
word8 = "ooo"

grid2 = [['a']]
word9 = "a"

find_word_location(grid1, word1) => [ (1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4) ]
find_word_location(grid1, word2) =>
       [(0, 0), (1, 0), (1, 1), (2, 1)]
    OR [(0, 0), (0, 1), (1, 1), (2, 1)]
find_word_location(grid1, word3) => [(5, 0)]
find_word_location(grid1, word4) => [(0, 4), (1, 4), (2, 4)] OR [(0, 4), (1, 4), (1, 5)]
find_word_location(grid1, word5) => [(4, 5), (5, 5), (6, 5)]
find_word_location(grid1, word6) => [(6, 4), (6, 5)]
find_word_location(grid1, word7) => [(5, 2), (5, 3), (5, 4), (5, 5)]
find_word_location(grid1, word8) => [(4, 1), (4, 2), (4, 3)]
find_word_location(grid2, word9) => [(0, 0)]

Complexity analysis variables:

r = number of rows
c = number of columns
w = length of the word
*/
public class Solution {
  
  static int[][] directions = {{1,0},{0,1}};
  static boolean[][] visited;
  
  public static boolean DFS(char[][] grid, StringBuffer word, int i, int j){
    if(word.size() == 0){
      return true;
    }
    
    visited[i][j] = true;

    for(int k =0; k < directions.length;k++){
      int newRow = i+directions[k][0];
      int newCol = j+directions[k][1];
      if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol< grid.length){
        if(word.startsWith(grid[newRow][newCol])){
          word.deleteCharAt(0);
          DFS(grid, word, newRow, newCol);
          word.insert(0,grid[newRow][newCol]);
          visited[i][j] = false;
        }
        
      }
    }
    return false;
  }
  
  
  public static String findMatches(String str, String[] words){
    Map<Character, Integer> map = new HashMap<>();
    String result = "-";
    for(char ch: str.toCharArray()){
      int ctr = map.getOrDefault(ch, 0);
      map.put(ch, ctr+1);
    }
    
    for(String word: words){
      Map<Character, Integer> localMap = new HashMap<>(map);
      int len = word.length();
      for(char ch: word.toCharArray()){
        if(localMap.containsKey(ch)){
          int ctr = localMap.get(ch);
          ctr = ctr-1;
          localMap.put(ch, ctr);
          len--;
          if(ctr == 0){
            localMap.remove(ch);
          }
        }
      }
      if(len == 0){
        result = word;
      }
    }
    
    return result;
    
  }
  
  public static void callFinder(char[][] grid, String word){
    visited = new boolean[grid.length][grid[0].length];
    StringBuffer sb = new StringBuffer(word);
      for(int i =0; i< grid.length; i++){
        for(int j = 0; j < grid[0].length; j++){
          if(sb.startsWith(grid[i][j])){
            visited[i][j] = true;
            word.deleteCharAt(0);
            boolean flag = DFS(grid, sb, i, j);
            if(flag){
              break;
            }
          }
        }
      }
      //Handle visited
      List<int[]> res = new ArrayList<>();
      for(int i =0; i< grid.length; i++){
        for(int j = 0; j < grid[0].length; j++){
          if(visited[i][j]){
            System.out.print("["+i+","+j+"]");
            res.add(new int[]{i,j});
          }
        }
      }
      
  }
  
  public static void main(String[] argv) {
    char[][] grid1 = {
      {'c', 'c', 't', 'n', 'a', 'x'},
      {'c', 'c', 'a', 't', 'n', 't'},
      {'a', 'c', 'n', 'n', 't', 't'},
      {'t', 'n', 'i', 'i', 'p', 'p'},
      {'a', 'o', 'o', 'o', 'a', 'a'},
      {'s', 'a', 'a', 'a', 'o', 'o'},
      {'k', 'a', 'i', 'o', 'k', 'i'}
    };
    String word1 = "catnip";
    String word2 = "cccc";
    String word3 = "s";
    String word4 = "ant";
    String word5 = "aoi";
    String word6 = "ki";
    String word7 = "aaoo";
    String word8 = "ooo"; 

    char[][] grid2 = {{'a'}};
    String word9 = "a";
    
    callFinder(grid1, word1);
     
    }
}
