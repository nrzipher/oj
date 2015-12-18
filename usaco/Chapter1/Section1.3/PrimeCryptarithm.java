/*
ID: nrziphe1
LANG: JAVA
TASK: crypt1
*/
import java.io.*;
import java.util.*;
class crypt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] num = new int[11];
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            num[p]=1;
        }
        int k=0;
        for (int c=0;c<10;c++) {
            if (num[c] == 1)
                for (int e = 0; e < 10; e++)
                    if (num[e] == 1&&num[(c*e)%10]==1)
                        for (int b=0;b<10;b++)
                             if (num[b]==1&&num[((b*10+c)*e/10)%10]==1)
                                 for (int a=0;a<10;a++){
                                     int p1=a*100+b*10+c;
                                     p1=p1*e;
                                     if (num[a]==1&&(p1/1000==0||num[p1/1000%10]==1)&&(num[p1/100%10]==1)&&(num[p1/10%10]==1)&&(num[p1%10]==1)){
                                         for (int d=0;d<10;d++){
                                             int p2=a*100+b*10+c;
                                             p2=p2*d;
                                             if (num[d]==1&&(p2/1000==0||num[p2/1000%10]==1)&&(num[p2/100%10]==1)&&(num[p2/10%10]==1)&&(num[p2%10]==1)){
                                                 int sum=p1+p2*10;
                                                 if ((sum/10000==0||num[sum/10000%10]==1)&&(num[sum/1000%10]==1)&&(num[sum/100%10]==1)&&(num[sum/10%10]==1)&&(num[sum%10]==1)) {
                                                    if (p1<1000&&p2<1000)   k++;
                                                 }
                                             }
                                         }
                                     }

                                 }

        }
        out.println(k);
        out.close();
    }
}
