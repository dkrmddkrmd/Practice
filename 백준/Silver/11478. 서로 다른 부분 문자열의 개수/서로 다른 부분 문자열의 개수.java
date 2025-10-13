import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<String> set = new HashSet<>();

        String s = st.nextToken();
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                String now = s.substring(i, j+1);
                set.add(now);
            }
        }

        System.out.println(set.size());
    }
}