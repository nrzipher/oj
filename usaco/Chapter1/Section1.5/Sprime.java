/*
ID: nrziphe1
LANG: JAVA
TASK: sprime
*/


import java.io.*;
import java.util.StringTokenizer;

class sprime {
    static int n = 0;
    static int m = 0;
    static int num_n = 0;
    static int[] p = new int[10001];
    static int[] prime;
    static int pm;
    static PrintWriter out;

    static void find(int d, int num) {
        boolean ok = true;
        for (int i = 0; prime[i] <= Math.sqrt(num); i++) {
            if (num % prime[i] == 0) {
                ok = false;
                break;
            }
        }
        if (ok) {
            if (d == n) {
                out.println(num);
                return;
            }
            find(d + 1, num * 10 + 1);
            find(d + 1, num * 10 + 3);
            find(d + 1, num * 10 + 7);
            find(d + 1, num * 10 + 9);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= 100; i++) {
            for (int j = i * 2; j <= 10000; j = j + i)
                p[j] = 1;
        }
        pm = 0;
        for (int i = 2; i <= 10000; i++)
            if (p[i] == 0) pm++;
        prime = new int[pm];
        for (int i = 2, j = 0; i <= 10000; i++) {
            if (p[i] == 0) {
                prime[j] = i;
                j++;
            }
        }

        find(1,2);
        find(1,3);
        find(1,5);
        find(1,7);
        find(1,9);
        out.close();

    }
}