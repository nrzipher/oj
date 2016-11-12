/*
ID: nrziphe1
LANG: JAVA
TASK: milk3
*/


import java.io.*;
import java.util.StringTokenizer;

class milk3 {
    static int a;
    static int b;
    static int c;
    static int[][][] x = new int[21][21][21];
    static boolean[] ok = new boolean[21];

    static void find(int i, int j, int k) {
        if (x[i][j][k] == 1) return;
        x[i][j][k] = 1;
        if (i == 0) ok[k] = true;
        //A->C
        if (i > c - k)
            find(i - (c - k), j, c);
        else find(0, j, k + i);
        //A->B
        if (i > b - j)
            find(i - (b - j), b, k);
        else find(0, i + j, k);
        //B->C
        if (j > c - k)
            find(i, j - (c - k), c);
        else find(i, 0, k + j);
        //B->A
        if (j > a - i)
            find(a, j - (a - i), k);
        else find(i + j, 0, k);
        //C->A
        if (k > a - i)
            find(a, j, k - (a - i));
        else find(i + k, j, 0);
        //C->B
        if (k > b - j)
            find(i, b, k - (b - j));
        else find(i, j + k, 0);


    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int[][][] x = new int[21][21][21];
        for (int i = 0; i <= c; i++)
            ok[i] = false;
        find(0, 0, c);
        int i;
        for (i = 0; i <= c; i++) {
            if (ok[i]) {
                out.print(i);
                break;
            }
        }
        for (i++; i <= c; i++)
            if (ok[i])
                out.print(" " + i);
        out.println();
        out.close();

    }
}