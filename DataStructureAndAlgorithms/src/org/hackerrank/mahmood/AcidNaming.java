package org.hackerrank.mahmood;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Conditions for naming an acid:

If the given input starts with hydro and ends with ic then it is a non-metal acid.
If the input only ends with ic then it is a polyatomic acid.
If it does not have either case, then output not an acid.
For example, for the input,hydroclhloric , the correct output is - non-metalic acid as the input begins with hydro and ends withic.

Complete the function acidNaming which takes a string input with the name of the acid, and return a string describing the appropriate type of acid.

Input Format

The first line will contain an integer q. 
The next q lines will contain a single word s .
 */
public class AcidNaming {

	public static final String acidPattern="^(hydro)?.*(ic)$";
	static String acidNamingMethod(String acid_name) {
        Pattern pat= Pattern.compile(acidPattern);
        Matcher  match = pat.matcher(acid_name);
        String output="not an acid";
        if(match.matches()) {
        		String group1=match.group(1);
        		String group2= match.group(2);
        		System.out.println(group1+" "+group2);
        		if(group1!=null&&group2!=null&&group1.length()>0 &&group2.length()>0) {
        			output="non-metalic acid";
        		}else if(group2!=null &&group2.length()>0) {
        			output="polyatomic acid";
        		}
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
    	Reader in = new Reader();
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String acid_name = in.readLine();
            String result = acidNamingMethod(acid_name);
            System.out.println(result);
        }
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
