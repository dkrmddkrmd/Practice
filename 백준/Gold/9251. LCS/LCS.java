import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();;
        String str2 = br.readLine();;

        int len1 = str1.length();
        int len2 = str2.length();

        int dp[][] = new int[len1+1][len2+1];

        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }
                else{
                    dp[i+1][j+1] = Math.max(dp[i][j + 1], dp[i+1][j]);
                }
            }
        }

        System.out.println(dp[len1][len2]);
    }
}