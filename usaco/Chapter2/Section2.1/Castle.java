/*
ID: nrziphe1
LANG: JAVA
TASK: castle
*/


import java.io.*;
import java.util.StringTokenizer;

class castle {
    static int[][] state, color;
    static int n, m;

    public static boolean toWestNoWall(int i, int j) {
        return state[i][j] % 2 == 0;
    }

    public static boolean toNorthNoWall(int i, int j) {
        return (state[i][j] / 2) % 2 == 0;
    }

    public static boolean toEastNoWall(int i, int j) {
        return (state[i][j] / 4) % 2 == 0;
    }

    public static boolean toSouthNoWall(int i, int j) {
        return (state[i][j] / 8) % 2 == 0;
    }

    public static void paint(int i, int j, int k) {
        if (toNorthNoWall(i, j) && color[i - 1][j] == 0) {
            color[i - 1][j] = k;
            paint(i - 1, j, k);
        }
        if (toSouthNoWall(i, j) && color[i + 1][j] == 0) {
            color[i + 1][j] = k;
            paint(i + 1, j, k);
        }
        if (toWestNoWall(i, j) && color[i][j - 1] == 0) {
            color[i][j - 1] = k;
            paint(i, j - 1, k);
        }
        if (toEastNoWall(i, j) && color[i][j + 1] == 0) {
            color[i][j + 1] = k;
            paint(i, j + 1, k);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("castle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        state = new int[m][n];
        color = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < n; j++)
                state[i][j] = Integer.parseInt(st.nextToken());
        }
        int k = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (color[i][j] == 0) {
                    k++;
                    color[i][j] = k;
                    paint(i, j, k);
                }
            }

        out.println(k);
        int[] rooms = new int[k + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                rooms[color[i][j]]++;
            }
        int max = 0;
        for (int i = 1; i <= k; i++)
            if (rooms[i] > max) max = rooms[i];
        out.println(max);
        int max_ = 0;
        int i_ = 0;
        int j_ = 0;
        String w = "";
        for (int j = 0; j < n; j++)
            for (int i = m - 1; i >= 0; i--) {
                if (i > 0 && color[i][j] != color[i - 1][j] && rooms[color[i][j]] + rooms[color[i - 1][j]] > max_) {
                    i_ = i + 1;
                    j_ = j + 1;
                    w = "N";
                    max_ = rooms[color[i][j]] + rooms[color[i - 1][j]];
                }
                if (j < n - 1 && color[i][j] != color[i][j + 1] && rooms[color[i][j]] + rooms[color[i][j + 1]] > max_) {
                    i_ = i + 1;
                    j_ = j + 1;
                    w = "E";
                    max_ = rooms[color[i][j]] + rooms[color[i][j + 1]];
                }
            }
        out.println(max_);
        out.println(i_ + " " + j_ + " " + w);
        out.close();
    }
}