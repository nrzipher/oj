/*
ID: nrziphe1
LANG: JAVA
TASK: ariprog
*/


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class ariprog {
    static int n = 0;
    static int m = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> array = new ArrayList<>();
        int[] set = new int[125001];
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= m; j++)
                set[i * i + j * j] = 1;


        int o = 0;
        for (int i = 0; i < m * m * 2; i++) {
            if (set[i] == 1) array.add(i);
        }
        ArrayList<Integer> dis = new ArrayList<>();
        int[] dset = new int[125001];
        for (int i = 0; i < array.size(); i++)
            for (int j = i + 1; j < array.size(); j++)
                dset[(array.get(j) - array.get(i))] = 1;
        for (int i = 0; i < m * m * 2; i++) {
            if (dset[i] == 1) dis.add(i);
        }
        for (int b : dis) {
            if (b > (m * m + m * m) / (n - 1)) break;
            for (int a : array) {
                if (a + b * (n - 1) > m * m * 2) break;
                boolean ok = true;
                for (int i = 0; i < n; i++) {
                    int x = a + b * i;
                    if (set[x] == 0) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    out.println(a + " " + b);
                    o++;
                }
            }
        }


        if (o == 0) out.println("NONE");
        out.close();
    }

}