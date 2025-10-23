import java.util.*;
import java.io.*;

class Ground{
    int row;
    int col;

    public Ground(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Main{
    static int[][] ground;

    static int M;
    static int N;

    // 상 우 하 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int worm = 0;
    static StringBuilder sb = new StringBuilder();

    static void bfs(int row, int col){
        Deque<Ground> dq = new ArrayDeque<>();
        dq.offerLast(new Ground(row, col));

        while (!dq.isEmpty()){
            Ground now = dq.pollFirst();
            for(int i = 0; i < 4; i++){
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];

                if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && ground[nextRow][nextCol] == 1){
                    ground[nextRow][nextCol] = 2;
                    dq.offerLast(new Ground(nextRow, nextCol));
                }
            }
        }
    }

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0){
            st = new StringTokenizer(br.readLine());

            // 가로길이
            M = Integer.parseInt(st.nextToken());

            // 세로 길이
            N = Integer.parseInt(st.nextToken());
            // 배추 개수
            int K = Integer.parseInt(st.nextToken());

            ground = new int[N][M];

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                ground[Y][X] = 1;
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(ground[i][j] == 1){
                        bfs(i, j);
                        worm++;
                    }
                }
            }

            sb.append(worm).append("\n");
            worm = 0;
        }

        System.out.println(sb);
    }
}