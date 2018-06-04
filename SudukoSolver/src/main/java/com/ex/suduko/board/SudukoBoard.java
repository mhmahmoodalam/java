package com.ex.suduko.board;

public class SudukoBoard {
	
	  
	private int[][] board;
	
	private int boardSize;
	
	private int minValue;
	private int maxValue;
	private int subSequenceSize;
	
    public SudukoBoard(int[][] board,int maxValue, int subSequenceSize) {
    	this.board=board;
    	this.boardSize=board.length;
    	this.minValue=1;
    	this.maxValue=maxValue;
    	this.subSequenceSize=subSequenceSize;
    }
    
	public int[][] getBoard() {
		return board;
	}

	public int getBoardSize() {
		return boardSize;
	}

	public int getMinValue() {
		return minValue;
	}
	
	public int getMaxValue() {
		return maxValue;
	}

	
	public int getSubSequenceSize() {
		return subSequenceSize;
	}

	public void printBoard(int[][] board) {
    	System.out.println();
        System.out.println("----------------------");
        for (int row = 0; row < this.boardSize; row++) 
        {
        	for (int column = 0; column < this.boardSize; column++) 
            {
            	System.out.print(board[row][column] + " ");
                if(column!=0&&(column+1)%subSequenceSize==0 )
                {
                    System.out.print("| ");
                }
            }
            if(row!=0 && (row+1)%subSequenceSize==0)
            {
                System.out.println();
                System.out.print("----------------------");
            }
            System.out.println();
        	
        }
        
    }


}
