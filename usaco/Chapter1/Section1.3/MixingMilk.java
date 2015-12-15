/*
ID: nrziphe1
LANG: JAVA
TASK: milk
*/

import java.io.*;
import java.util.*;

class milk {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] price = new int[1001];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int p = Integer.parseInt(st.nextToken());
            int stock = Integer.parseInt(st.nextToken());
            price[p] += stock;
        }
        int buy = 0;
        int money = 0;
        for (int i = 0; i <= 1000 && buy < n; i++) {
            if (n - buy < price[i]) {
                money = money + i * (n - buy);
                buy = buy + (n - buy);
            } else {
                money = money + i * price[i];
                buy = buy + price[i];
            }
        }
        out.println(money);
        out.close();
    }
}
