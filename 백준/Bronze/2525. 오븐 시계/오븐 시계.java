import java.util.*;
import  java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int now = Integer.parseInt(br.readLine());

        m += now;

        if(m >= 60){
            h += (m / 60);
            m %= 60;
        }

        System.out.println((h%24) + " " + m);
    }
}