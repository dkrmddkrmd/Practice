import java.util.*;
import java.io.*;

public class Main {
    static int recursion(final String s, int l, int r){
        how++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    static int isPalindrome(final String s){
        return recursion(s, 0, s.length()-1);
    }

    static int how = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while(N-- > 0){
            String s = br.readLine();
            stringBuilder.append(isPalindrome(s)).append(" ").append(how).append("\n");
            how = 0;
        }

        System.out.println(stringBuilder);
    }
}