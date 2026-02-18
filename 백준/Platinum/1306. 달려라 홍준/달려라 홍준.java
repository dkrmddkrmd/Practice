import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lights = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            lights[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> out = new PriorityQueue<>(Collections.reverseOrder());

        //init
        for(int i = 1; i <= 2 * M - 1; i++){
            pq.offer(lights[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pq.peek()).append(" ");

        //시작

        for(int i = M + 1; i <= N - M + 1; i++){
            // 뺄 값이 가장 큰값일 때
            if(pq.peek() == lights[i - M]){
                pq.poll();

                // 더 뺄게 있는지 계속 확인
                while (!out.isEmpty() && pq.peek().equals(out.peek())){
                    pq.poll();
                    out.poll();
                }

                pq.offer(lights[i + M - 1]);
                sb.append(pq.peek()).append(" ");
            }
            else{
                out.offer(lights[i - M]);

                pq.offer(lights[i + M - 1]);
                sb.append(pq.peek()).append(" ");
            }
        }

        System.out.println(sb);
    }
}