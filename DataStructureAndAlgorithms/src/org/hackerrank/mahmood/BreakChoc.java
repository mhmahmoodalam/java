package org.hackerrank.mahmood;
import java.util.Scanner;

public class BreakChoc {
	static long count=0;
	static int[] primeList= {1,2,3,5,7,9,11,13,17,19,23};
    static void breakChoc(long size){
        
        if(size!=1){
        	count++;
            System.out.println(count);
            int d=2;
            for(int i=primeList.length-1;i>=0;i--) {
            	//System.out.println(size+"%"+primeList[i]+"="+size%primeList[i]);
            	if(size%primeList[i]==0) {
            		d=primeList[i];
            		System.out.println(d);
            		break;
            	}
            }
            if(d==2) {
	            long middle=size/2;
	            if(size%2==0){
	                breakChoc(middle);
	                breakChoc(middle);
	            }else{
	                breakChoc(middle);
	                breakChoc(middle+1);
	            }
            }else {
            	for(int i=0;i<d;i++) {
            		breakChoc(size/d);
            	}
            }
        }else {
        	count++;
           // System.out.println(count);
        }
    }
    static long longestSequence(long[] a) {
        //  Return the length of the longest possible sequence of moves.
        for(int i=0;i<a.length;i++){
            breakChoc(a[i]);            
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextLong();
        }
        long result = longestSequence(a);
        System.out.println(result);
        in.close();
    }
}
