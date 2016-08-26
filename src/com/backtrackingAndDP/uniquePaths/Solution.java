package com.backtrackingAndDP.uniquePaths;


/**
 * 
 * Follow up for "Unique Paths":

	Now consider if some obstacles are added to the grids. How many unique paths would there be?
	
	An obstacle and empty space is marked as 1 and 0 respectively in the grid.
	
	For example,
	There is one obstacle in the middle of a 3x3 grid as illustrated below.
*[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
 * */

public class Solution {
    
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		
		
		for(int i =0; i< 3; i++){
			for(int j =0; j< 3;j++){
				if(obstacleGrid[i][j]!=1){
					continue;
				}else{
					
				}
			}
		}
		
		return 0;
        
    }
	
	public static void main(String args[]){
		
		int[][] obstacleGrid = new int[3][3];
		obstacleGrid[1][1]=1;
		
		Solution solution= new Solution();
		solution.uniquePathsWithObstacles(obstacleGrid);
	}
}