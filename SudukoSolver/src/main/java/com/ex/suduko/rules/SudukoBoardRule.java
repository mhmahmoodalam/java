package com.ex.suduko.rules;

public interface SudukoBoardRule {

	boolean rowConstraint(int[][] board, int row);
	
	boolean columnConstraint(int[][] board, int column);
	
	boolean subsectionConstraint(int[][] board, int row, int column,int subsectionSize) ;
	
	boolean isValid(int[][] board, int row, int column, int subsectionSize);
	
	boolean checkConstraint(int[][] board, int row, boolean[] constraint, int column);
}
