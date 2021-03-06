package com.ex.suduko.data;

public class TestDataGenerator {
	
	public static int[][] problemBoard = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}};
	
	public static int[][] hardestProblemBoard = {
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

	public static int[][] invalidSudukoBoard = {
	          { 8, 9, 9, 9, 9, 9, 9, 9, 9 },
	          { 9, 9, 9, 6, 9, 9, 9, 9, 9 },
	    	  { 9, 7, 9, 9, 9, 9, 2, 9, 9 },
	    	  { 9, 5, 9, 9, 9, 7, 9, 9, 9 },
	    	  { 9, 9, 9, 9, 9, 9, 9, 9, 9 },
	    	  { 9, 9, 9, 1, 9, 9, 9, 3, 9 },
	    	  { 9, 9, 9, 9, 9, 9, 9, 6, 9 },
	    	  { 9, 9, 8, 5, 9, 9, 9, 9, 9 },
	    	  { 9, 9, 9, 9, 9, 9, 9, 9, 9 } 
	     };
}
