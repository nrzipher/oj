/*
ID: nrziphe1
LANG: JAVA
TASK: numtri
*/


import java.io.*;
import java.util.StringTokenizer;

class numtri {
    static int n = 0;
    static int[] num = new int[1001];
    static int[] k = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j <= i; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j <= i; j++) {
                if (k[j] > k[j - 1]) num[j] += k[j];
                else num[j] += k[j - 1];
            }
            num[0] += k[0];
            for (int j = 0; j <= i; j++) {
                k[j] = num[j];
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (k[i] > max) max = k[i];
        }
        out.println(max);
        out.close();
    }
}