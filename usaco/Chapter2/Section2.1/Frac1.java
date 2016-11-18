/*
ID: nrziphe1
LANG: JAVA
TASK: frac1
*/


import java.io.*;
import java.util.StringTokenizer;

class frac1 {
    static int[] m1, m2;
    static int n;
    static int num;

    public static int gcd(int n, int m) {
        int t;
        while (m > 0) {
            t = n % m;
            n = m;
            m = t;
        }
        return n;
    }

    public static boolean smaller(int i, int j) {
        int x = m1[i] * m2[j];
        int y = m1[j] * m2[i];
        return x < y;
    }

    public static void sort(int x, int y) {
        if (x >= y) return;
        m1[num] = m1[y];
        m2[num] = m2[y];
        int i = x;
        int j = y;
        while (i < j) {
            while (smaller(i, num) && i < j) {
                i++;
            }
            m1[j] = m1[i];
            m2[j] = m2[i];
            while (smaller(num, j) && i < j) {
                j--;
            }
            m1[i] = m1[j];
            m2[i] = m2[j];
        }
        m1[j] = m1[num];
        m2[j] = m2[num];
        sort(x, j - 1);
        sort(j + 1, y);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        n = n + 1;
        m1 = new int[n * n];
        m2 = new int[n * n];
        int k = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                if (gcd(i, j) == 1) {
                    m1[k] = i;
                    m2[k] = j;
                    k++;
                }
            }
        num = k;
        sort(0, k - 1);
        for (int i = 0; i < num; i++) {
            out.println(m1[i] + "/" + m2[i]);
        }
        out.println(1 + "/" + 1);
        out.close();
    }
}