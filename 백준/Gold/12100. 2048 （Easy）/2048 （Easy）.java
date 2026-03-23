import java.util.*;
import java.io.*;

public class Main {
    static int[][] blocks;
    static int maxVal = 0;
    static boolean[][] isCombine;

    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        blocks = new int[N][N];
        isCombine = new boolean[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                blocks[i][j] = Integer.parseInt(st.nextToken());
                maxVal = Integer.max(blocks[i][j], maxVal);
            }
        }

        if(N == 1){
            System.out.println(blocks[0][0]);
            return;
        }

        dfs(blocks, 0);

        System.out.println(maxVal);
    }

    static void dfs(int[][] blocks, int count){
        if(count == 5)
            return;

        for(int i = 0; i < 4; i++){
            combine(blocks, i, count);
        }
    }

    static void combine(int[][] blocks, int type, int count){
        int[][] nowBlocks = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                nowBlocks[i][j] = blocks[i][j];
            }
        }

        for(int i = 0; i < N; i++){
            Arrays.fill(isCombine[i], false);
        }

        if(type == 0){
            up(nowBlocks);
            dfs(nowBlocks, count + 1);
        }
        else if(type == 1){
            //오른쪽
            right(nowBlocks);
            dfs(nowBlocks, count + 1);
        }
        else if(type == 2){
            //아래
            down(nowBlocks);
            dfs(nowBlocks, count + 1);
        }
        else {
            //왼쪽
            left(nowBlocks);
            dfs(nowBlocks, count + 1);
        }
    }

    static void up(int[][] nowBlocks){
        //위
        for(int i = 1; i < N; i++){
            for(int j = 0; j < N; j++){
                // 현재 위치 [i][j], 현재 값 num
                int num = nowBlocks[i][j];
                nowBlocks[i][j] = 0;

                for(int k = i - 1; k >= 0; k--){
                    if(nowBlocks[k][j] == 0){
                        if(k == 0){
                            nowBlocks[k][j] = num;
                            break;
                        }
                        continue;
                    }
                    else{
                        //합칠 수 있는지 먼저 확인
                        if(nowBlocks[k][j] == num && !isCombine[k][j]){
                            nowBlocks[k][j] *= 2;
                            maxVal = Integer.max(maxVal, nowBlocks[k][j]);
                            isCombine[k][j] = true;
                            break;
                        }

                        nowBlocks[k+1][j] = num;
                        break;
                    }
                }
            }
        }
    }

    static void right(int[][] nowBlocks){
        //오른쪽
        for(int i = 0; i < N; i++){
            for(int j = N-2; j >= 0; j--){
                // 현재 위치 [i][j], 현재 값 num
                int num = nowBlocks[i][j];
                nowBlocks[i][j] = 0;

                for(int k = j + 1; k < N; k++){
                    if(nowBlocks[i][k] == 0){
                        if(k == N-1){
                            nowBlocks[i][k] = num;
                            break;
                        }
                        continue;
                    }
                    else{
                        //합칠 수 있는지 먼저 확인
                        if(nowBlocks[i][k] == num && !isCombine[i][k]){
                            nowBlocks[i][k] *= 2;
                            maxVal = Integer.max(maxVal, nowBlocks[i][k]);
                            isCombine[i][k] = true;
                            break;
                        }

                        nowBlocks[i][k-1] = num;
                        break;
                    }
                }
            }
        }
    }

    static void down(int[][] nowBlocks){
        //아래
        for(int i = N - 2; i >= 0; i--){
            for(int j = 0; j < N; j++){
                // 현재 위치 [i][j], 현재 값 num
                int num = nowBlocks[i][j];
                nowBlocks[i][j] = 0;

                for(int k = i + 1; k < N; k++){
                    if(nowBlocks[k][j] == 0){
                        if(k == N-1){
                            nowBlocks[k][j] = num;
                            break;
                        }
                        continue;
                    }
                    else{
                        //합칠 수 있는지 먼저 확인
                        if(nowBlocks[k][j] == num && !isCombine[k][j]){
                            nowBlocks[k][j] *= 2;
                            maxVal = Integer.max(maxVal, nowBlocks[k][j]);
                            isCombine[k][j] = true;
                            break;
                        }

                        nowBlocks[k-1][j] = num;
                        break;
                    }
                }
            }
        }
    }

    static void left(int[][] nowBlocks){
        //왼쪽
        for(int i = 0; i < N; i++){
            for(int j = 1; j < N; j++){
                // 현재 위치 [i][j], 현재 값 num
                int num = nowBlocks[i][j];
                nowBlocks[i][j] = 0;

                for(int k = j - 1; k >= 0; k--){
                    if(nowBlocks[i][k] == 0){
                        if(k == 0){
                            nowBlocks[i][k] = num;
                            break;
                        }
                        continue;
                    }
                    else{
                        //합칠 수 있는지 먼저 확인
                        if(nowBlocks[i][k] == num && !isCombine[i][k]){
                            nowBlocks[i][k] *= 2;
                            maxVal = Integer.max(maxVal, nowBlocks[i][k]);
                            isCombine[i][k] = true;
                            break;
                        }

                        nowBlocks[i][k+1] = num;
                        break;
                    }
                }
            }
        }
    }
}