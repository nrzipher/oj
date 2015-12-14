/*
ID: nrziphe1
LANG: JAVA
TASK: dualpal
*/

import java.io.*;
import java.util.StringTokenizer;

class dualpal {
    public static String ch(int base, int k) {
        String tmp = "";
        while (k > 0) {
            int x = k % base;
            String x1 = "";
            tmp = x + tmp;
            k = k / base;
        }
        return tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        StringTokenizer in1 = new StringTokenizer(f.readLine());
        int x1 = Integer.parseInt(in1.nextToken());
        int x2 = Integer.parseInt(in1.nextToken());
        int ok = 0;
        for (int i = x2 + 1; ok < x1; i++) {
            int k = 0;
            for (int x = 2; x <= 10; x++) {
                String tmp = ch(x, i);
                if (tmp.equals(new StringBuffer(tmp).reverse().toString())) k++;
            }
            if (k >= 2) {
                out.println(i);
                ok++;
            }
        }
        out.close();
    }
}