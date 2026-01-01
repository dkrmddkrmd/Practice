import java.util.*;
import java.io.*;

public class Main{
    static int N, M;

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder ans = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] lastRank = new int[N+1];

            for(int i = 1; i <= N; i++){
                lastRank[i] = Integer.parseInt(st.nextToken());
            }

            int[] indegree = new int[N+1];
            boolean[][] isNext = new boolean[N+1][N+1];

            for(int i = 1; i < N; i++){
                for(int j = i + 1; j <= N; j++){
                    isNext[lastRank[i]][lastRank[j]] = true;
                    indegree[lastRank[j]]++;
                }
            }

            M = Integer.parseInt(br.readLine());
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                if(isNext[A][B]){
                    isNext[A][B] = false;
                    isNext[B][A] = true;
                    indegree[B]--;
                    indegree[A]++;
                }
                else{
                    isNext[A][B] = true;
                    isNext[B][A] = false;
                    indegree[B]++;
                    indegree[A]--;
                }
            }
            ans.append(ans(indegree, isNext));
        }
        System.out.println(ans);
    }

    static String ans(int[] indegree, boolean[][] isNext){
        StringBuilder sb = new StringBuilder();
        int val = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0){
                dq.offerLast(i);
                val++;
            }
        }

        while (!dq.isEmpty()){
            if(dq.size() >= 2)
                return "?\n";

            int now = dq.pollFirst();
            sb.append(now).append(" ");
            for(int i = 1; i <= N; i++){
                if(isNext[now][i]){
                    indegree[i]--;
                    if(indegree[i] == 0){
                        dq.offerLast(i);
                        val++;
                    }
                }
            }
        }

        if(val != N)
            return "IMPOSSIBLE\n";

        sb.append("\n");
        return sb.toString();
    }
}