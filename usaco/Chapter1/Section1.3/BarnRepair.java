/*
ID: nrziphe1
LANG: JAVA
TASK: barn1
*/

import java.io.*;
import java.util.*;

class barn1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] stall = new int[201];
        int[] barn = new int[201];
        int max = 0, min = 200;
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(f.readLine());
            int p = Integer.parseInt(st.nextToken());
            stall[p] = 1;
            if (p > max) max = p;
            if (p < min) min = p;
        }
        for (int i = min; i <= max; i++) {
            barn[i] = 1;
        }
        for (int i = m - 1; i > 0; i--) {
            int k = 0, p = 0;
            int maxk = 0,maxp=0;
            for (int j = min; j <= max; j++) {
                if (stall[j] == 0 && barn[j] == 1) {
                    k++;
                    p = j;
                    if (k>maxk) {maxk=k;maxp=p;}
                } else {
                    k=0;
                }
            }
            for (int j=maxp;stall[j]==0&&j>=min;j--)
                barn[j]=0;
        }
        int l=0;
        for (int i = min; i <= max; i++)
            l+=barn[i];

        out.println(l);
        out.close();
    }
}
