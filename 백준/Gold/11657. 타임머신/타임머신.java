import java.util.*;
import java.io.*;

// (★) '간선' 자체를 저장하는 클래스 (이름을 Edge로 바꾸는 게 명확함)
class Edge {
    int from; // 시작
    int to;   // 도착
    int cost; // 비용

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class Main{
    static long maxVal = 999_999_999L;

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // (★) '간선' M개를 저장할 1차원 배열
        Edge[] edges = new Edge[M];
        long[] dist = new long[N+1];
        Arrays.fill(dist, maxVal);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            // (★) 0번부터 M-1번까지 i 인덱스에 간선 객체를 저장
            edges[i] = new Edge(A, B, C);
        }

        dist[1] = 0;

        for(int i = 1; i < N; i++){
            for(int j = 0; j < M; j++){
                Edge edge = edges[j];

                if(dist[edge.from] != maxVal){
                    if(dist[edge.to] > dist[edge.from] + edge.cost){
                        dist[edge.to] = dist[edge.from] + edge.cost;
                    }
                }
            }
        }


        boolean isCycle = false;
        for(int j = 0; j < M; j++){
            Edge edge = edges[j];

            if(dist[edge.from] != maxVal){
                if(dist[edge.to] > dist[edge.from] + edge.cost){
                    isCycle = true;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(isCycle)
            System.out.println(-1);
        else{
            for(int i = 2; i <= N; i++){
                if(dist[i] == maxVal){
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(dist[i]).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}