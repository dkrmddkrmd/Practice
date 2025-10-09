import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String[] arr = new String[M + 1];
        Map<String, String> myMap = new HashMap<>();

        for(int i = 1; i <= M; i++){
            String poketmon = br.readLine();
            arr[i] = poketmon;
            myMap.put(poketmon, Integer.toString(i));
        }

        while (N-->0){
            st = new StringTokenizer(br.readLine());
            String now = st.nextToken();
            if(Character.isDigit(now.charAt(0))){
                System.out.println(arr[Integer.parseInt(now)]);
            }
            else{
                System.out.println(myMap.get(now));
            }
        }
    }
}