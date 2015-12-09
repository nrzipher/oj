/*
ID: nrziphe1
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.StringTokenizer;

class friday {
    public static boolean leap(int year) {
        return (year % 100 == 0 && year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
    }

    public static int getDays(int year, int month) {
        switch (month) {
            case 1:
                return 31;
            case 2:
                if (leap(year)) return 29;
                else return 28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;

        }
        return 31;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int np = Integer.parseInt(st.nextToken());
        int[] thirteenth = new int[]{0, 0, 0, 0, 0, 0, 0};
        int day = 1;
        int date = 1;
        int month = 1;
        int year = 1900;
        while (year < 1900 + np) {
            if (date == 13)
                thirteenth[day]++;
            day++;
            date++;
            day = day % 7;
            if (date > getDays(year, month)) {
                date = 1;
                month++;
                if (month > 12) {
                    month = 1;
                    year++;
                }
            }

        }
        out.printf("%d %d %d %d %d %d %d%n",thirteenth[6],thirteenth[0],thirteenth[1],thirteenth[2],thirteenth[3],thirteenth[4],thirteenth[5]);
        out.close();
    }
}
