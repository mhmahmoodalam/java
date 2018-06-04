package org.hackerrank.mahmood;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastReader {

	static BufferedReader buff= new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static String next() {
		
		while(st==null||!st.hasMoreTokens()) {
		
				
				try {
					st= new StringTokenizer(buff.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return st.nextToken();
	}
	
	public static long nextLong() {
		return Long.parseLong(next());
	}
	
	public static double nextDouble() {
		return Double.parseDouble(next());
	}
	
	public static int nextInt() {
		return Integer.parseInt(next());
	}
	
	public static String nextLine()  {
		String str="";
		try {
			str= buff.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(nextInt());
		System.out.println(nextLine());
		
	}

}
