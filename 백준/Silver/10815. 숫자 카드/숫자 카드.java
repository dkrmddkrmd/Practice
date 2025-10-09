import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;
        Set<Integer> mySet = new HashSet<>();

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while(n-- > 0){
            int nowNum = Integer.parseInt(st.nextToken());
            mySet.add(nowNum);
        }

        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (n-->0){
            boolean nowAns = mySet.contains(Integer.parseInt(st.nextToken()));
            if(nowAns){
                sb.append("1 ");
            }
            else{
                sb.append("0 ");
            }
        }

        System.out.println(sb);
    }
}