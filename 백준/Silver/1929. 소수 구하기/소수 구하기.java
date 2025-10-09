import java.util.*;
import java.io.*;

public class Main{
    static boolean isPrime(int n){
        if(n <= 1)
            return false;

        if(n == 2 || n == 3)
            return true;

        if(n % 2 == 0)
            return false;

        for(int i = 3; i * i <= n; i+=2){
            if(n % i == 0)
                return false;
        }

        return true;
    }

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = N; i <= M; i++){
            if(isPrime(i))
                stringBuilder.append(i).append("\n");
        }

        System.out.println(stringBuilder);
    }
}