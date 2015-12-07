/*
ID: nrziphe1
LANG: JAVA
TASK: ride
*/

import java.io.*;

class ride {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String in1 = f.readLine();
        String in2 = f.readLine();
        int x1 = 1;
        int x2 = 1;
        for (int i = 0; i < in1.length(); i++) {
            x1 = x1 * (in1.charAt(i) - 'A' + 1) % 47;
        }
        for (int i = 0; i < in2.length(); i++) {
            x2 = x2 * (in2.charAt(i) - 'A' + 1) % 47;
        }
        if (x1 == x2) out.println("GO");
        else out.println("STAY");
        out.close();
    }
}
