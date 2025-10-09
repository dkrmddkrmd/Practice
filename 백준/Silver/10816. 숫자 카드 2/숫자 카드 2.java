import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> myMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        while(N-->0){
            int now = Integer.parseInt(st.nextToken());
            if(myMap.containsKey(now))
                myMap.compute(now, (k, v) -> v+1);
            else{
                myMap.put(now, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        while (M-->0){
            int now = Integer.parseInt(st.nextToken());
            if(myMap.containsKey(now))
                stringBuilder.append(myMap.get(now)).append(" ");
            else
                stringBuilder.append("0 ");
        }

        System.out.println(stringBuilder);
    }
}