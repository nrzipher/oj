/*
ID: nrziphe1
LANG: JAVA
TASK: palsquare
*/

import java.io.*;
import java.util.StringTokenizer;

class palsquare {
    public static String ch(int base, int k) {
        String tmp = "";
        while (k > 0) {
            int x = k % base;
            String x1="";

            if (x < 10) tmp = x + tmp;
            else tmp = Character.toString((char) ('A' + x - 10)) + tmp;

            k = k / base;
        }
        return tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        String in1 = f.readLine();
        int x1 = Integer.parseInt(in1);
        for (int i = 1; i <= 300; i++) {
            String tmp = ch(x1, i * i);
            if (tmp.equals(new StringBuffer(tmp).reverse().toString())) out.println(ch(x1, i) + " " + tmp);
        }
        out.close();
    }
}