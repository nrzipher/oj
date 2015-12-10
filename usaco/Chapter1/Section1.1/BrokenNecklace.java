/*
ID: nrziphe1
LANG: JAVA
TASK: beads
*/

import java.io.*;

class beads {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        String in1 = f.readLine();
        String necklace = f.readLine();
        int x1 = Integer.parseInt(in1);
        necklace = necklace + necklace;
        int max = 0;
        for (int i = 0; i < necklace.length() - 1; i++) {
            int m = 0;
            int j = i;
            char x = necklace.charAt(j);
            while (j > 0 && (x == 'w' || necklace.charAt(j) == x || necklace.charAt(j) == 'w')) {
                if (x == 'w' && necklace.charAt(j) != 'w') x = necklace.charAt(j);
                m++;
                j--;

            }
            j = i + 1;
            x = necklace.charAt(j);
            while (j < necklace.length() && (x == 'w' || necklace.charAt(j) == x || necklace.charAt(j) == 'w')) {
                if (x == 'w' && necklace.charAt(j) != 'w') x = necklace.charAt(j);
                m++;
                j++;

            }

            if (m > necklace.length() / 2) m = necklace.length() / 2;
            if (max < m) max = m;
        }
        out.println(max);
        out.close();

    }
}
