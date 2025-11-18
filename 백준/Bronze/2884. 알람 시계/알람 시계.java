import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        M -= 45;
        if(M < 0){
            M += 60;
            N -= 1;
            if(N < 0)
                N += 24;
        }
        System.out.println(N + " " + M);
    }
}