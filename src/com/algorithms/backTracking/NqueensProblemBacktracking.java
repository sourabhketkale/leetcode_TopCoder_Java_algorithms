package com.algorithms.backTracking;

public class NqueensProblemBacktracking {

	
	class Position{
		int col, row;
		public Position(int col, int row) {
			this.col = col;
			this.row = row;
		}
	}
	
	public Position[] Nqueenssolution(int n){
		Position[] positions =  new Position[n];
	
		boolean hasSolution=NqueensProblemBacktracking.NqueensUtil(n,0, positions);
		if(hasSolution){
			return positions;
		}else{
			return new Position[0];
		}
		
		
	} 
	
	public static boolean NqueensUtil(int n, int row, Position[] positions){
		if(n==0){
			return true;
		}
		
		int col;
		
		for(col=0; col<n;col++ ){
			
			boolean safenessCheck=true;
			for(int queenIndex=0; queenIndex< n; queenIndex++){
				if(positions[queenIndex].col==col || positions[queenIndex].row- positions[queenIndex].col==row-col || 
						positions[queenIndex].row + positions[queenIndex].col==row + col){
					safenessCheck =false;
					break;
				}
				
			}
			if(safenessCheck){
			//	positions[row] = new Position(col, row);	
				return true;
			}else{
				return false;
			}
		}
		
		
		return true;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}

}
