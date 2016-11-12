/*
ID: nrziphe1
LANG: JAVA
TASK: pprime
*/


import java.io.*;
import java.util.StringTokenizer;

class pprime {
    static int n = 0;
    static int m = 0;
    static int num_n = 0;
    static int[] num = new int[11];
    static int[] p = new int[10001];

    static int num() {
        int ls = 0;
        for (int i = num_n / 2 + num_n % 2 - 1; i >= num_n % 2; i--) {
            ls = ls * 10 + num[i];
        }
        for (int i = 0; i < num_n / 2 + num_n % 2; i++) {
            ls = ls * 10 + num[i];
        }
        return ls;
    }

    static void inc_num() {
        num[0]++;
        int i = 0;
        while (num[i] > 9) {
            num[i] = 0;
            num[i + 1]++;
            i++;
        }

        if (i >= num_n / 2 + num_n % 2) {
            num_n++;
            num = new int[11];
            num[0] = 1;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= 100; i++) {
            for (int j = i * 2; j <= 10000; j = j + i)
                p[j] = 1;
        }
        int pm = 0;
        for (int i = 2; i <= 10000; i++)
            if (p[i] == 0) pm++;
        int[] prime = new int[pm];
        for (int i = 2, j = 0; i <= 10000; i++) {
            if (p[i] == 0) {
                prime[j] = i;
                j++;
            }
        }

        int k = 0;
        while (n > 0) {
            num[k] = n % 10;
            n = n / 10;
            k++;
        }
        num_n = k;
        //131 1331 13431
        for (int i = 0; i < k / 2 + k % 2; i++) {
            num[i] = num[i + k / 2];
        }
        for (int i = k / 2 + k % 2; i < 11; i++)
            num[i] = 0;

        while (num() < n) {
            inc_num();
        }
        int x;
        while ((x = num()) <= m) {
            boolean ok = true;
            for (int i = 0; prime[i] <= Math.sqrt(x) + .1; i++) {
                if (x % prime[i] == 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) out.println(x);
            inc_num();
        }
        out.close();

    }
}