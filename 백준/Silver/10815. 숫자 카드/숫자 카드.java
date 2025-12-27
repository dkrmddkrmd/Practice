import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Set<Integer> s = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            s.add(num);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            if(s.contains(num)){
                sb.append("1 ");
            }
            else
                sb.append("0 ");
        }

        System.out.println(sb);
    }
}