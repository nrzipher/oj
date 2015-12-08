/*
ID: nrziphe1
LANG: JAVA
TASK: gift1
*/

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class gift1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int np = Integer.parseInt(st.nextToken());
        List<String> l = new ArrayList<String>();
        Map<String, Integer> gift = new HashMap<String, Integer>();
        for (int i = 0; i < np; i++) {
            String name = f.readLine();
            l.add(name);
            gift.put(name, 0);
        }
        for (int i = 0; i < np; i++) {
            String name = f.readLine();
            StringTokenizer st1 = new StringTokenizer(f.readLine());
            int out_m = Integer.parseInt(st1.nextToken());
            int num = Integer.parseInt(st1.nextToken());
            if (num != 0) gift.put(name, gift.get(name) - (out_m / num) * num);
            for (int j = 0; j < num; j++) {
                String tmp = f.readLine();
                gift.put(tmp, gift.get(tmp) + (out_m / num));
            }

        }
        for (int i = 0; i < l.size(); i++) {
            out.println(l.get(i) + " " + gift.get(l.get(i)));
        }
        out.close();
    }
}
