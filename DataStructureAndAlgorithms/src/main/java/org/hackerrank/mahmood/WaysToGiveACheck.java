package org.hackerrank.mahmood;

/*
 * In this problem, the task is to implement a very simple pawn promotion component that can be used in a chess engine.

For clarity, White promotes the Pawn by moving it from the 7-th to the 8-th rank(row) along the same file (column). There are  
4 possible different promotions: the pawn can be promoted either to a Queen, or to a Rook, or to a Bishop, or to a Knight.

		Q	R	B	K
8		^	^	^	^
7		P	P	P	P
	a	b	c	d	e	f	g	h
	
Note:

*You should assume that there is no position on the board in which the Pawn can be moved to the 8-rank by capturing the Black's 
	piece (A diagonal move).
*Moves resulting in a checkmate also count.

 Moreover, White can have more than one Pawn in the 7-th rank, but there will be exactly one that can be promoted with a single valid 
 move. In other words, there might be more White's Pawns in the 7-th rank, but only one can make a valid move along its file to the 8-rank.
 Your task is to find the number of ways to promote the white pawn in the 7-th rank, to the right piece (Queen, Rook, or Bishop, or Knight) 
 to give a check to Black's King.

Complete the function waysToGiveACheck that takes a 2-D char array as input, describing the positions of various pieces on the board, 
and return an integer denoting the number of ways to end up in a check scenario.

Input Format

In the first line, there is a single integer t denoting the number of scenarios to handle. After that, descriptions of subsequent 
scenarios are given.

Each scenario consists of 8 lines, with 8 characters each. The first line denotes the 8-th rank (row) on the board, while the last 
line denotes the 1-st rank. Empty cells on the board are denoted by "#", while pieces are denoted by characters {K,Q,N,B,R,P} for White's pieces 
and  {k,q,n,b,r,p} for Black's pieces, where  k/K is the King, q is a Queen, n is a Knight, b is a Bishop, r is a Rook, and p is a Pawn).

Constraints
-->1<=t<=5
-->There are at most 4 pieces of each color on the board
-->Each player has exactly one King and the given position on the board is a valid chess position assuming that it's White's move
-->It is guaranteed that White has exactly one Pawn in the 7th rank that can be promoted in a single move
 *
 *
 Sample Input 0

2
########
#k#P####
########
########
########
########
#K######
########
########
######P#
####k###
########
########
########
####K###
########
Sample Output 0

1
2

Explanation 0

In the sample input, there are two cases to solve.

In the first of them, if White promotes the Pawn to a Knight, he gives a check to the Black King. Any other promotion, i.e. to neither a Queen
 nor to a Rook nor to a Bishop doesn't result in a check.
 
In the second case, if White can promote either to a Queen or to a Bishop in order to give a check to the Black King across a diagonal.

 */
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class WaysToGiveACheck {

	static class King{
		int i;
		int j;
		public King(int i,int j) {
			this.i=i;
			this.j=j;
		}
	}
	
	static class Pawn{
		int i;
		int j;
		public Pawn(int i,int j) {
			this.i=i;
			this.j=j;
		}
	}
	static int waysToGiveACheck(char[][] board,King king,Pawn pawn,int queenCount,int bishopCount,int rookCount,int knightCount ) {
        // Complete this function
		//boolean bishop=false;
		int waysCount=0;
		
		if(king.j==pawn.j||king.i==pawn.i) {
			//only queen and nook
			//System.out.println("queen and nook");
			waysCount= 2-queenCount;
		}
		//left sid emove only
		if(king.j<pawn.j) {
			//bishop move
			int i=pawn.i+1;
			int j=pawn.j-1;
			
			while(bishopCount<2&&i<=7&&j>=0) {
				if(king.i==i&&king.j==j) {
					//System.out.println("bishop");
					waysCount+= 2;
				}
				i++;
				j--;
			}
			
			//knight move
			if(knightCount<2&&pawn.i+2<=2&&pawn.i+2==king.i&&pawn.j-1>=0&&pawn.j-1==king.j) {
				//System.out.println("knight");
				waysCount+=1;
			}
			if(knightCount<2&&pawn.j-2>=0&&pawn.j-2==king.j&&pawn.i+1<=7&&pawn.i+1==king.i) {
				//System.out.println("knight");
				waysCount+= 1;
			}
		}
		if(king.j>pawn.j) {
			//bishop move
			int i=pawn.i+1;
			int j=pawn.j+1;
			
			while(bishopCount<2&&i<=7&&j<=7) {
				if(king.i==i&&king.j==j) {
					waysCount+=2;
				}
				i++;
				j++;
			}
			
			//knight move
			if(knightCount<2&&pawn.i+2<=7&&pawn.i+2==king.i&&pawn.j+1<=7&&pawn.j+1==king.j) {
				waysCount+= 1;
			}
			if(knightCount<2&&pawn.j+2<=7&&pawn.j+2==king.j&&pawn.i+1>=0&&pawn.i+1==king.i) {
				waysCount+= 1;
			}
		}
		return waysCount;
    }
	
	public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            char[][] board = new char[8][8];  
            King king = null;
            Pawn pawn=null;
            int queenCount=0;
            int knightCount=0;
            int bishopCount=0;
            int rookCount=0;
            for(int board_i = 0; board_i < 8; board_i++){            		
            		String line= in.readLine();            		
                for(int board_j = 0; board_j < 8; board_j++){
                    board[board_i][board_j] = line.charAt(board_j);
                    if(line.charAt(board_j)=='k') {
                    		//System.out.println("k "+board_i+ board_j);
                    		king= new King(board_i, board_j);
                    }
                    if(board_i==1&&line.charAt(board_j)=='P') {
                    //	System.out.println("P "+board_j);
                    		pawn= new Pawn(0,board_j);
                    }
                    
                    if(line.charAt(board_j)=='Q') {
                		//System.out.println("k "+board_i+ board_j);
                    	queenCount++;
                    }
                    if(line.charAt(board_j)=='N') {
                		//System.out.println("k "+board_i+ board_j);
                    	knightCount++;
                    }
                    if(line.charAt(board_j)=='B') {
                		//System.out.println("k "+board_i+ board_j);
                    	bishopCount++;
                    }
                    if(line.charAt(board_j)=='R') {
                		//System.out.println("k "+board_i+ board_j);
                    	rookCount++;
                    }
                }
            }
           // System.out.println(king.i+" "+king.j+" "+pawn.i+" "+pawn.j);
            int result = waysToGiveACheck(board,king,pawn,queenCount,bishopCount,rookCount,knightCount);
            System.out.println(result);
        }
        in.close();
    }
	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
}
