package com.ex.suduko.solver;

import com.ex.suduko.board.SudukoBoard;
import com.ex.suduko.rules.SimpleSudukoRule;

public class SudkoStarter {

	
  	    
  	    private static int[][] hardestProblemBoard = {
  	          { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
           	  { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
  	    	  { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
  	    	  { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
  	    	  { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
  	    	  { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
  	    	  { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
  	    	  { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
  	    	  { 0, 9, 0, 0, 0, 0, 4, 0, 0 } 
  	     };
  	    
  	  private static int[][] boardSimpleSquare = {
	    	      {8, 0, 0, 0},
	    	      {0, 0, 3, 6},
	    	      {0, 7, 0, 0},
	    	      {0, 5, 0, 0}
	    	    };

  	    public static void main(String[] args) {
  	    	SudukoSolver sudukoSolver=new SudukoSolver();
  	    	sudukoSolver.setSudukoBoard(new SudukoBoard(hardestProblemBoard, 9, 3));
  	    	sudukoSolver.setSudukoBoardRule(new SimpleSudukoRule());
  	    	sudukoSolver.solve();
  	    }
}
