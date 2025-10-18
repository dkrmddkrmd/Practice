import java.util.*;
import java.io.*;

public class Main{
    // 상 우 하 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int clean = 0;

    static int[][] ground;

    static void cleaning(int row, int col, int dir){
        // 현재 칸 청소
        if(ground[row][col] == 0){
            clean++;
            // 청소한 구역
            ground[row][col] = 2;
        }

        while (true){
            // 주변 4칸 확인해보고
            int[] next = check(row, col, dir);

            // 주변에 없음
            if(next[0] == -1){
                dir -= 2;
                if(dir < 0)
                    dir += 4;

                // 후진
                int backRow = row + dr[dir];
                int backCol = col + dc[dir];

                if(ground[backRow][backCol] == 1)
                    return;
                else{
                    // 후진해서 다시 check
                    row = backRow;
                    col = backCol;
                    dir -= 2;
                    if(dir < 0)
                        dir += 4;
                }
            }
            else{
                //주변에 있으면 이동 후 청소
                row = next[0];
                col = next[1];
                dir = next[2];

                // 현재 칸 청소
                if(ground[row][col] == 0){
                    clean++;
                    // 청소한 구역
                    ground[row][col] = 2;
                }
            }
        }
    }

    // 주변 4칸 확인
    static int[] check(int row, int col, int dir){
        boolean checkNext = false;

        for (int i = 0; i < 4; i++) {
            // 반시계 방향
            dir--;
            if (dir == -1)
                dir = 3;

            int nextRow = row + dr[dir];
            int nextCol = col + dc[dir];
            if (ground[nextRow][nextCol] == 0) {
                checkNext = true;
                row = nextRow;
                col = nextCol;
                break;
            }
        }

        if(checkNext){
            return new int[]{row, col, dir};
        }
        else{
            return new int[]{-1, -1, -1};
        }
    }

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        ground = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int num = Integer.parseInt(st.nextToken());
                ground[i][j] = num;
            }
        }

        cleaning(r, c, d);

        System.out.println(clean);
    }
}