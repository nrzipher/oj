/*
ID: nrziphe1
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.StringTokenizer;

class milk2 {
    public static void main(String[] args) throws IOException {
        int[] a = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            a[i] = 0;
        }
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        String in1 = f.readLine();
        int x1 = Integer.parseInt(in1);
        int min = 1000000;
        int max = 0;
        for (int i = 0; i < x1; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int time_st = Integer.parseInt(st.nextToken());
            int time_end = Integer.parseInt(st.nextToken());
            if (a[time_st] < time_end) a[time_st] = time_end;
            if (time_st < min) min = time_st;
            if (max < time_end) max = time_end;
        }
        int max1 = 0;
        int max2 = 0;
        int l1 = 0;
        int l2 = 0;
        int end = min;
        for (int i = min; i < max; i++) {
            if ((a[i]) > end) end = a[i];
            if (i < end) {
                l1++;
                l2 = 0;
            } else {
                l1 = 0;
                l2++;
            }
            if (l1 > max1) max1 = l1;
            if (l2 > max2) max2 = l2;
        }
        out.println(max1 + " " + max2);
        out.close();
    }
}