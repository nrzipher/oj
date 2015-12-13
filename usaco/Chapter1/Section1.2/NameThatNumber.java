/*
ID: nrziphe1
LANG: JAVA
TASK: namenum
*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


//2: A,B,C     5: J,K,L    8: T,U,V
//3: D,E,F     6: M,N,O    9: W,X,Y
//4: G,H,I     7: P,R,S
class namenum {
    static ArrayList<String> names = new ArrayList<String>();

    public static void mv(int k, char x, char y, char z) {
        for (int i = names.size() - 1; i >= 0; i--) {
            if ((names.get(i).charAt(k) != x) && (names.get(i).charAt(k) != y) && (names.get(i).charAt(k) != z))
                names.remove(i);
        }
    }
    public static void mv(int k) {
        for (int i = names.size() - 1; i >= 0; i--) {
            if (names.get(i).length()!=k)
                names.remove(i);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        String in1 = f.readLine();

        BufferedReader f1 = new BufferedReader(new FileReader("dict.txt"));

        String in2 = f1.readLine();
        while (in2 != null) {
            names.add(in2);
            in2 = f1.readLine();
        }
        mv(in1.length());
        for (int i = 0; i < in1.length(); i++) {
            switch (in1.charAt(i)) {
                case '2':
                    mv(i, 'A', 'B', 'C');
                    continue;
                case '3':
                    mv(i, 'D', 'E', 'F');
                    continue;
                case '4':
                    mv(i, 'G', 'H', 'I');
                    continue;
                case '5':
                    mv(i, 'J', 'K', 'L');
                    continue;
                case '6':
                    mv(i, 'M', 'N', 'O');
                    continue;
                case '7':
                    mv(i, 'P', 'R', 'S');
                    continue;
                case '8':
                    mv(i, 'T', 'U', 'V');
                    continue;
                case '9':
                    mv(i, 'W', 'X', 'Y');
                    continue;
            }
        }
        for (int i = 0; i < names.size(); i++)
            out.println(names.get(i));
        if (names.size()==0) out.println("NONE");
        out.close();
    }
}
