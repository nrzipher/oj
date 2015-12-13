/*
ID: nrziphe1
LANG: JAVA
TASK: transform
*/

import java.io.*;
import java.util.StringTokenizer;

class transform {
    public static int x1=0;

    public static boolean check(int[][] x,int[][] y){
        for (int i=0;i<x1;i++){
            for (int j=0;j<x1;j++){
                if (x[i][j]!=y[i][j]) return false;
            }
        }
        return true;
    }

    public static  int[][] in(BufferedReader f) throws IOException{
        int[][] x=new int[x1][x1];
        for (int i=0;i<x1;i++){
            String in1=f.readLine();
            for (int j=0;j<x1;j++){
                if (in1.charAt(j)=='@') x[i][j]=0;
                else x[i][j]=1;
            }
        }
        return x;
    }

    public static int[][] t90(int[][] x){
        int[][] n=new int[x1][x1];
        for (int i=0;i<x1;i++){
            for (int j=0;j<x1;j++){
                n[i][j]=x[x1-j-1][i];
            }
        }
        return n;
    }
    public static int[][] v(int[][] x){
        int[][] n=new int[x1][x1];
        for (int i=0;i<x1;i++){
            for (int j=0;j<x1;j++){
                n[i][j]=x[i][x1-j-1];
            }
        }
        return n;
    }
    //123
    //456
    //789
    //741  1,0 2,1
    //852
    //963
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        String in1 = f.readLine();
        x1 = Integer.parseInt(in1);
        int[][] x=new int[x1][x1];
        int[][] y=new int[x1][x1];
        x=in(f);
        y=in(f);

        if (check(t90(x),y)) out.println(1);
        else if (check(t90(t90(x)),y)) out.println(2);
        else if (check(t90(t90(t90(x))),y)) out.println(3);
        else if (check(v(x),y)) out.println(4);
        else if (check(t90(v(x)),y)) out.println(5);
        else if (check(t90(t90(v(x))),y)) out.println(5);
        else if (check(t90(t90(t90(v(x)))),y)) out.println(5);
        else if (check(x,y)) out.println(6);
        else out.println(7);


        out.close();
    }
}