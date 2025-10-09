import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            deque.offer(i);
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!deque.isEmpty()){
            int num = deque.pollFirst();
            stringBuilder.append(num).append(" ");
            int change = arr[num];
            if(change > 0){
                //오른쪽으로
                change--;
                while(change-->0){
                    if(!deque.isEmpty()){
                        int nowNum = deque.pollFirst();
                        deque.offerLast(nowNum);
                    }
                }
            }
            else{
                while ((change++) != 0){
                    if (!deque.isEmpty()){
                        int nowNum = deque.pollLast();
                        deque.offerFirst(nowNum);
                    }
                }
            }
        }

        System.out.println(stringBuilder);
    }
}