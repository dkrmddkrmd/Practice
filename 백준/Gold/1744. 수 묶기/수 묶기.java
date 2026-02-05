import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long answer = 0;

        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int zero = 0;
        int one = 0;

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                zero++;
            }
            else if(num == 1){
                one++;
            }
            else if(num > 0){
                plus.offer(num);
            }
            else{
                minus.offer(num);
            }
        }

        while (plus.size() >= 2){
            int num1 = plus.poll();
            int num2 = plus.poll();
            answer += (num1 * num2);
        }

        if(!plus.isEmpty())
            answer += plus.poll();

        while (minus.size() >= 2){
            int num1 = minus.poll();
            int num2 = minus.poll();
            answer += (num1 * num2);
        }

        if(!minus.isEmpty() && zero == 0)
            answer += minus.poll();
        
        answer += one;

        System.out.println(answer);
    }
}