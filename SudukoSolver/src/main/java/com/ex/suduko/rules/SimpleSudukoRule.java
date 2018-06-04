package com.ex.suduko.rules;

import java.util.stream.IntStream;

import com.ex.suduko.solver.SudukoSolver;

public class SimpleSudukoRule implements SudukoBoardRule{

	@Override
	public boolean rowConstraint(int[][] board, int row) {
		boolean[] constraint = new boolean[board.length];
        return IntStream.range(0, board.length)
        		 .allMatch(column -> checkConstraint(board, row, constraint, column));
	}

	@Override
	public boolean columnConstraint(int[][] board, int column) {
		boolean[] constraint = new boolean[board.length];
        return IntStream.range(0, board.length)
          .allMatch(row -> checkConstraint(board, row, constraint, column));
	}

	@Override
	public boolean subsectionConstraint(int[][] board, int row, int column,int subsectionSize) {
		boolean[] constraint = new boolean[board.length];
        int subsectionRowStart = (row / subsectionSize) * subsectionSize;
        int subsectionRowEnd = subsectionRowStart + subsectionSize;

        int subsectionColumnStart = (column / subsectionSize) * subsectionSize;
        int subsectionColumnEnd = subsectionColumnStart + subsectionSize;

        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if (!checkConstraint(board, r, constraint, c)) return false;
            }
        }
        return true;
	}

	@Override
	public boolean isValid(int[][] board, int row, int column,int subsequenceSize) {
		 return rowConstraint(board, row) &&
		          columnConstraint(board, column) &&
		          subsectionConstraint(board, row, column,subsequenceSize);
	}

	@Override
	public boolean checkConstraint(int[][] board, int row, boolean[] constraint, int column) {
		if (board[row][column] != SudukoSolver.NO_VALUE) {
            if (!constraint[board[row][column] - 1]) {
                constraint[board[row][column] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
	}

}
