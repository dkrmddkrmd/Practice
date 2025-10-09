import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ans = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> mySet = new HashSet<>();

        while (N-->0){
            mySet.add(br.readLine());
        }

        while (M-->0){
            if(mySet.contains(br.readLine()))
                ans++;
        }

        System.out.println(ans);
    }
}