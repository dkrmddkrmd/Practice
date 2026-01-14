import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();

        int zero = 0;

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            if(num > 0)
                plus.add(num);
            else if(num < 0)
                minus.add(num);
            else
                zero++;
        }



        int ans = 0;

        while (minus.size() >= 2){
            ans += minus.poll() * minus.poll();
        }

        if(!minus.isEmpty()){
            if(zero > 0){
                minus.poll();
            }
            else{
                ans += minus.poll();
            }
        }

        while (plus.size() >= 2){
            int num1 = plus.poll();
            int num2 = plus.poll();
            if(num1 == 1 || num2 == 1){
                ans += num1 + num2;
            }
            else
                ans += num1 * num2;
        }

        if(!plus.isEmpty()){
            ans += plus.poll();
        }

        System.out.println(ans);
    }
}