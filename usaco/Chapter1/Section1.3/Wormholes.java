/*
ID: nrziphe1
LANG: JAVA
TASK: wormhole
*/


import java.io.*;
import java.util.StringTokenizer;

class wormhole {
    static int n;
    static int[] p_x = new int[13];
    static int[] p_y = new int[13];
    static int[] pair = new int[13];
    static int[] next_to = new int[13];
    static int k = 0;

    public static void setPair() {
        int i = 0;
        while (i < n && pair[i] != -1) {
            i++;
        }
        if (i >= n) {
            check();
            return;
        }
        int j = i + 1;
        while (j < n) {
            if (pair[j] == -1) {
                pair[i] = j;
                pair[j] = i;
                setPair();
                pair[i] = -1;
                pair[j] = -1;
            }
            j++;
        }
    }

    public static void check() {
        for (int i = 0; i < n; i++) {
            int j = pair[i];
            int x = 0;
            while (x < n * 2) {
                if (next_to[j] == -1) break;
                j = next_to[j];
                j = pair[j];
                x++;
            }
            if (x >= n * 2) {
                k++;
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            pair[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            p_x[i] = Integer.parseInt(st.nextToken());
            p_y[i] = Integer.parseInt(st.nextToken());
            next_to[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            int min = -1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (p_y[i] == p_y[j]) {
                    if (p_x[j] > p_x[i] && (min > p_x[j] || min == -1)) {
                        next_to[i] = j;
                        min = p_x[j];
                    }
                }
            }
        }

        setPair();
        out.println(k);
        out.close();
    }
}
