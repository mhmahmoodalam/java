package com.ex.suduko.solver;

import com.ex.suduko.board.SudukoBoard;
import com.ex.suduko.rules.SudukoBoardRule;

public class SudukoSolver {
	
	public static final int BOARD_START_INDEX=0;
	public static final int NO_VALUE=0;
	private SudukoBoard sudukoBoard;
	private int[][] board;
	
	private SudukoBoardRule sudukoBoardRule;

	public SudukoBoard getSudukoBoard() {
		return sudukoBoard;
	}

	public void setSudukoBoard(SudukoBoard sudukoBoard) {
		this.sudukoBoard = sudukoBoard;
		this.board=sudukoBoard.getBoard();
	}

	public SudukoBoardRule getSudukoBoardRule() {
		return sudukoBoardRule;
	}

	public void setSudukoBoardRule(SudukoBoardRule sudukoBoardRule) {
		this.sudukoBoardRule = sudukoBoardRule;
	}
	
	
	public boolean solve() {
        for (int row = BOARD_START_INDEX; row < sudukoBoard.getBoardSize(); row++) {
            for (int column = BOARD_START_INDEX; column < sudukoBoard.getBoardSize(); column++) {
                if (board[row][column] == NO_VALUE) {
                    for (int k = sudukoBoard.getMinValue(); k <= sudukoBoard.getMaxValue(); k++) {
                        board[row][column] = k;
                        if (sudukoBoardRule.isValid(board, row, column,sudukoBoard.getSubSequenceSize()) && solve()) {
                            return true;
                        }
                        board[row][column] = NO_VALUE;
                    }
                    return false;
                }
            }
        }
        sudukoBoard.printBoard(board);
        return true;
    }
	
	

}
