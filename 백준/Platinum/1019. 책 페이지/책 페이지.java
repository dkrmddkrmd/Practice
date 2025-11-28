import java.util.*;
import java.io.*;

public class Main{
    static long[] arr = new long[10];

    static void calc(int num, int place){
        String str = Integer.toString(num);
        for(int i = 0; i < str.length(); i++){
            int nowNum = str.charAt(i) - '0';
            arr[nowNum] += place;
        }
    }

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int start = 1;
        int end = N;
        int place = 1;

        while (start <= end){
            while (start % 10 != 0 && start <= end){
                calc(start, place);
                start++;
            }

            while (end % 10 != 9 && start <= end){
                calc(end, place);
                end--;
            }

            if(start > end)
                break;

            long count = (end / 10 - start / 10 + 1);
            for(int i = 0; i < 10; i++){
                arr[i] += count * place;
            }

            start /= 10;
            end /= 10;
            place *= 10;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 10; i++){
            stringBuilder.append(arr[i]).append(" ");
        }

        System.out.println(stringBuilder);
    }
}