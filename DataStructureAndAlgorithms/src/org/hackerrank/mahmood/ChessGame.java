package org.hackerrank.mahmood;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ChessGame {

	ArrayList<String> move= new ArrayList<>();
    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        //  Print the distance along with the sequence of moves.
    	boolean nextMove=true;    	
    	ArrayList<String> move= new ArrayList<>();
    	if(i_end==i_start||j_end==j_start) {
    		if(!(i_end==i_start&&j_end==j_start)) {
    			if(i_end==i_start) {
	    			if(j_end<j_start) {	    				
	    				if((j_start-j_end)%4==0){
	    					if(i_start>1) {
		    					for(int i=0;i<(j_start-j_end)/4;i++) {
		    						move.add("UL");
		    						move.add("LL");
		    						j_start-=4;
		    					}
	    					}else {
	    						for(int i=0;i<(j_start-j_end)/4;i++) {
		    						move.add("LL");
		    						move.add("UL");
		    						j_start-=4;
		    					}
	    					}
	    				}
	    			}else {
	    				if((j_end-j_start)%4==0){
	    					if(i_start>1) {
		    					for(int i=0;i<(j_end-j_start)/4;i++) {
		    						move.add("UR");
		    						move.add("LR");
		    						j_start+=4;
		    					}
	    					}else {
	    						for(int i=0;i<(j_end-j_start)/4;i++) {
		    						move.add("LR");
		    						move.add("UR");
		    						j_start+=4;
		    					}
	    					}
	    				}
	    			}
    			}else if(j_end==j_start) {
	    			if(i_end<i_start) {	   
	    				if(j_start>0) {
		    				if((i_start-i_end)%4==0){
		    					for(int i=0;i<(i_start-i_end)/4;i++) {
		    						move.add("UL");
		    						move.add("UR");
		    						i_start-=4;
		    					}
		    				}
	    				}else {
	    					if((i_start-i_end)%4==0){
		    					for(int i=0;i<(i_start-i_end)/4;i++) {
		    						move.add("UR");
		    						move.add("UL");
		    						i_start-=4;
		    					}
		    				}
	    				}
	    			}else {
	    				if(j_start<n-2) {
		    				if((i_end-i_start)%4==0){
		    					for(int i=0;i<(i_end-i_start)/4;i++) {
		    						move.add("LR");
		    						move.add("LL");
		    						i_start+=4;
		    					}
		    				}
	    				}else {
	    					if((i_end-i_start)%4==0){
		    					for(int i=0;i<(i_end-i_start)/4;i++) {
		    						move.add("LL");
		    						move.add("LR");
		    						i_start+=4;
		    					}
		    				}
	    				}
	    			}
    			}
    		}
    	}else if(i_end>i_start) {
    		//System.out.println("Down");
    		if(j_end>j_start) {
	    		//R,LR
    			//System.out.println("Right");
    			while(nextMove) {
    	    		nextMove=false;
    	    		if(j_start+2<n) {
    	    			// R			
    	    			j_start+=2;
    	    			nextMove=true;
    	    			move.add("R");
    	    			continue;
    	    		}
    	    		else if(j_start+1<n&&i_start+2<n&&i_end>i_start) {
    	    			//  LR
    	    			i_start+=2;
    	    			j_start+=1;
    	    			nextMove=true;
    	    			move.add("LR");
    	    			continue;
    	    		}
    			}
    		}else {    		
    			//LL,L
    			//System.out.println("Left");
    			while(nextMove) {
    				nextMove=false;
    				if(j_start-1<=0&&i_start+2<n&&i_end>i_start) {
    	    			// LL
    	    			i_start+=2;
    	    			j_start-=1;
    	    			nextMove=true;
    	    			move.add("LL");
    	    			continue;
    	    		}
    	    		else if(j_start-2>=0) {
    	    			//  L    			
    	    			j_start-=2;
    	    			nextMove=true;
    	    			move.add("L");
    	    			continue;
    	    		}
    			}

    		}
    	}else {
    		//System.out.println("UP");
    		if(j_end>j_start) {
    			//UR,R
    			//System.out.println("Right");
    			while(nextMove) {
    	    		nextMove=false;
    	    		if(j_start+1<n&&i_start-2>=0&&i_end<i_start) {
    	    			// UR
    	    			i_start-=2;
    	    			j_start+=1;
    	    			nextMove=true;
    	    			move.add("UR");
    	    			continue;
    	    		}
    	    		
    	    		if(j_start+2<n) {
    	    			// R   			
    	    			j_start+=2;
    	    			nextMove=true;
    	    			move.add("R");
    	    			continue;
    	    		}
    			}
    		}else {
    			//UL,L
    			//System.out.println("left");
    			while(nextMove) {
    	    		nextMove=false;
    	    		if(j_start-1>=0&&i_start-2>=0&&i_end<i_start) {
    	    			//UL
    	    			i_start-=2;
    	    			j_start-=1;
    	    			nextMove=true;
    	    			move.add("UL");
    	    			continue;
    	    		}
    	    		
    	    		else if(j_start-2>=0) {
    	    			//  L    			
    	    			j_start-=2;
    	    			nextMove=true;
    	    			move.add("L");
    	    			continue;
    	    		}
    			}
    		}
    	}
    	if(i_start==i_end&&j_start==j_end) {
    		System.out.println(move.size());
    		for(String Value:move)
    			System.out.print(Value+" ");
    	}else {
    		System.out.println("Impossible");
    		
    	}
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i_start = in.nextInt();
        int j_start = in.nextInt();
        int i_end = in.nextInt();
        int j_end = in.nextInt();
       // System.out.println("STarting....");
        printShortestPath(n, i_start, j_start, i_end, j_end);
       // System.out.println("ended....");
        in.close();
    }
}
