import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true){
            st = new StringTokenizer(br.readLine());
            int a, c;
            String b;

            a = Integer.parseInt(st.nextToken());
            b = st.nextToken();
            c = Integer.parseInt(st.nextToken());

            if(a == 0 && Objects.equals(b, "W") && c == 0)
                break;

            if(Objects.equals(b, "W")){
                int num = a - c;
                if(num < -200){
                    sb.append("Not allowed\n");
                }
                else{
                    sb.append(num).append("\n");
                }
            }
            else{
                int num = a + c;
                if(num < -200){
                    sb.append("Not allowed\n");
                }
                else{
                    sb.append(num).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}