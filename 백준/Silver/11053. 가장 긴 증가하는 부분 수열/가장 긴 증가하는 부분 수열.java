import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        arr[0] = Integer.parseInt(st.nextToken());
        int len = 1;

        for(int i = 1; i < N; i++){
            int num = Integer.parseInt(st.nextToken());

            if(num > arr[len-1]){
                arr[len] = num;
                len++;
                continue;
            }

            // 값이 가장 작으면
            if(arr[0] > num){
                arr[0] = num;
                continue;
            }

            for(int j = len - 1; j >= 0; j--){
                if(arr[j] >= num)
                    continue;

                // 더 작은 값을 만나면
                arr[j+1] = num;
                break;
            }
        }

        System.out.println(len);
    }
}