import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long answer = 0;

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        String num = stringTokenizer.nextToken();
        int base = Integer.parseInt(stringTokenizer.nextToken());

        for(int i = 0, nowPro = num.length() - 1; i < num.length(); i++, nowPro--){
            char nowNum = num.charAt(i);
            if(nowNum >= 'A' && nowNum <= 'Z'){
                long nowSum = 1;
                for(int j = 0; j < nowPro; j++){
                    nowSum *= base;
                }
                answer += ((long)(nowNum - 'A' + 10) * nowSum);
            }
            else{
                long nowSum = 1;
                for(int j = 0; j < nowPro; j++){
                    nowSum *= base;
                }
                answer += ((long)(nowNum - '0') * nowSum);
            }
        }

        System.out.println(answer);
    }
}