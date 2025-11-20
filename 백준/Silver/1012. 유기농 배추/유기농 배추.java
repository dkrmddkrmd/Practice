import java.util.*;
import java.io.*;

class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main{
    static int M, N, K;
    static int earthworm = 0;

    // 상 우 하 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void dfs(int[][] ground, int y, int x){
        Deque<Node> nodes = new ArrayDeque<>();
        earthworm++;
        nodes.offerLast(new Node(x, y));

        while (!nodes.isEmpty()){
            Node now = nodes.pollFirst();
            for(int i = 0; i < 4; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(check(ground, nextY, nextX)){
                    nodes.offerLast(new Node(nextX, nextY));
                    ground[nextY][nextX] = 2;
                }
            }
        }
    }

    static boolean check(int[][] ground, int y, int x){
        return y >= 0 && y < N && x >= 0 && x < M && ground[y][x] == 1;
    }

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            earthworm = 0;

            int[][] ground = new int[N][M];

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                ground[Y][X] = 1;
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(ground[i][j] == 1){
                        dfs(ground, i, j);
                    }
                }
            }

            sb.append(earthworm).append("\n");
        }

        System.out.println(sb);
    }
}