import java.util.*;
import java.io.*;

class Point{
    int row;
    int col;

    public Point(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Main{
    static int N, M;
    static int[][] ground;
    // 상 우 하 좌
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ground = new int[N+1][M+1];

        for(int i = 1; i <= N; i++){
            String s = br.readLine();
            for(int j = 1; j <= M; j++){
                ground[i][j] = s.charAt(j-1) - '0';
            }
        }

        bfs(1, 1);

        System.out.println(ground[N][M] - 1);
    }

    static void bfs(int r, int c){
        Deque<Point> dq = new ArrayDeque<>();
        dq.offerLast(new Point(r, c));
        ground[r][c] = 2;

        while (!dq.isEmpty()){
            Point now = dq.pollFirst();

            for(int i = 0; i < 4; i++){
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];

                if(!check(nextRow, nextCol))
                    continue;

                if(ground[nextRow][nextCol] != 1)
                    continue;

                dq.offerLast(new Point(nextRow, nextCol));
                ground[nextRow][nextCol] = ground[now.row][now.col] + 1;
                if(nextRow == N && nextCol == M)
                    return;
            }
        }
    }

    static boolean check(int r, int c){
        return (r >= 1 && r <= N && c >= 1 && c <= M);
    }
}