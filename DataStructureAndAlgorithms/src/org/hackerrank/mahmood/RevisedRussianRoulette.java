package org.hackerrank.mahmood;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * In the original version of Russian Roulette, there are active and inactive zones a contestant has to pass through to win, and also a trap door.

You are playing a revised version of the game, where, you have to unlock all doors in a given setting, in a given fashion, to enter the playig area.

Initially, any door is either locked or unlocked.
If a door is locked and you unlock it, then
if the next consecutive door is locked, it will automatically get unlocked.
if the next consecutive door is already unlocked, nothing will happen.
there will be no effect on any following door.
For example, if there are 10 doors as shown below, where 0 denotes an unlocked door, and 1 denotes a locked door, 
a minimum of 3 operations, will be required to unlock all doors.

0	1	1	0	1	1	1	1	0	0
Note: You are allowed to unlock the doors in any order you wish.

Complete the function revisedRussianRoulette that takes an integer array denoting LOCKED/UNLOCKED  status of 
each door in the array, and return an integer array denoting the minimum and maximum number 
of unlock operations needed to unlock all the doors.

Input Format

The first line contains a single integer N, denoting the total number of doors.

The next line contains N space separated integers, either 0 or 1 . 1 denotes a locked door and  0 denotes an unlocked door.
 */
public class RevisedRussianRoulette {

	static int[] revisedRussianRoulette(int[] doors) {
		int max=0;
		int min=0;
		int[] maxMin= new int[2];
       for(int i=0;i<doors.length;i++) {
    	   	 if(doors[i]==1) {
    	   		 max++;
    	   		 min++;
    	   		 if(i+1<doors.length&&doors[i+1]==1) {
    	   			 max++;
    	   			 i++;
    	   		 }
    	   	 }
       }
       maxMin[0]=min;
       maxMin[1]=max;
       return maxMin;
    }

    public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        int n = in.nextInt();
        int[] doors = new int[n];
        for(int doors_i = 0; doors_i < n; doors_i++){
            doors[doors_i] = in.nextInt();
        }
        int[] result = revisedRussianRoulette(doors);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
	
	static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
