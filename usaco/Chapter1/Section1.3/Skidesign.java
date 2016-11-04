/*
ID: nrziphe1
LANG: JAVA
TASK: skidesign
*/


import java.io.*;
import java.util.StringTokenizer;

class skidesign {
    static int n = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        int[] hill = new int[101];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            int k = Integer.parseInt(st.nextToken());
            hill[k]++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 100 - 17; i++) {
            int k = 0;
            for (int j = 0; j <= 100; j++) {
                if (j < i) k = k + (i - j) * (i - j) * hill[j];
                if (j > i + 17) k = k + (j - i - 17) * (j - i - 17) * hill[j];
            }
            if (k < min) min = k;
        }

        out.println(min);
        out.close();
    }

}