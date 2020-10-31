/**

Link : https://www.hackerrank.com/challenges/simple-text-editor/problem

In this challenge, you must implement a simple text editor. Initially, your editor contains an empty string, . You must perform  operations of the following  types:

append - Append string  to the end of .
delete - Delete the last  characters of .
print - Print the  character of .
undo - Undo the last (not previously undone) operation of type  or , reverting  to the state it was in prior to that operation.

Input Format

The first line contains an integer, , denoting the number of operations.
Each line  of the  subsequent lines (where ) defines an operation to be performed. Each operation starts with a single integer,  (where ), denoting a type of operation as defined in the Problem Statement above. If the operation requires an argument,  is followed by its space-separated argument. For example, if  and , line  will be 1 abcd.

Constraints

The sum of the lengths of all  in the input .
The sum of  over all delete operations .
All input characters are lowercase English letters.
It is guaranteed that the sequence of operations given as input is possible to perform.
Output Format

Each operation of type  must print the  character on a new line.

Sample Input

8
1 abc
3 3
2 3
1 xy
3 2
4 
4 
3 1
Sample Output

c
y
a

**/




import java.util.*;
import java.io.*;


public class Solution {
    public static void main(String[] args) throws Exception {
        IO sc = new IO();
        int n = sc.nextInt();

        String s = "";
        Stack<String> stack = new Stack<String>();
        stack.push(s);

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if (t == 1) {
                s = s + sc.next();
                stack.push(s);
            } else if (t == 2) {
                s = s.substring(0, s.length() - sc.nextInt());
                stack.push(s);
            } else if (t == 3) {
                System.out.println(s.charAt(sc.nextInt() - 1));
            } else {
                stack.pop();
                s = stack.peek();
            }
        }
    }
}

class IO {
    private byte[] buf;
    private InputStream in;
    private PrintWriter pw;
    private int total, index;

    public IO() {
        buf = new byte[1024];
        in = System.in;
        pw = new PrintWriter(System.out);
    }

    public int next() throws IOException {
        if (total < 0)
            throw new InputMismatchException();
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0)
                return -1;
        }
        return buf[index++];
    }

    public int nextInt() throws IOException {
        int n = next(), integer = 0;
        while (isWhiteSpace(n))
            n = next();
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = next();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                integer *= 10;
                integer += n - '0';
                n = next();
            } else
                throw new InputMismatchException();
        }
        return neg * integer;
    }

    public int[] nextIntArray(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextInt();
        return arr;
    }

    public long nextLong() throws IOException {
        long integer = 0l;
        int n = next();
        while (isWhiteSpace(n))
            n = next();
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = next();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                integer *= 10;
                integer += n - '0';
                n = next();
            } else
                throw new InputMismatchException();
        }
        return neg * integer;
    }

    public double nextDouble() throws IOException {
        double doub = 0;
        int n = next();
        while (isWhiteSpace(n))
            n = next();
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = next();
        }
        while (!isWhiteSpace(n) && n != '.') {
            if (n >= '0' && n <= '9') {
                doub *= 10;
                doub += n - '0';
                n = next();
            } else
                throw new InputMismatchException();
        }
        if (n == '.') {
            n = next();
            double temp = 1;
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    temp /= 10;
                    doub += (n - '0') * temp;
                    n = next();
                } else
                    throw new InputMismatchException();
            }
        }
        return doub * neg;
    }

    public String nextString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = next();
        while (isWhiteSpace(n))
            n = next();
        while (!isWhiteSpace(n)) {
            sb.append((char)n);
            n = next();
        }
        return sb.toString();
    }

    public String nextLine() throws IOException {
        int n = next();
        while (isWhiteSpace(n))
            n = next();
        StringBuilder sb = new StringBuilder();
        while (!isEndOfLine(n)) {
            sb.append((char)n);
            n = next();
        }
        return sb.toString();
    }

    private boolean isWhiteSpace(int n) {
        return n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1;
    }

    private boolean isEndOfLine(int n) {
        return n == '\n' || n == '\r' || n == -1;
    }

    public void print(Object obj) {
        pw.print(obj);
    }

    public void println(Object obj) {
        pw.println(obj);
    }

    public void close() throws IOException {
        pw.close();
    }
}
