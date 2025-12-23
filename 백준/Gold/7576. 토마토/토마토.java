import java.util.*;
import java.io.*;

class Tomato{
    int row;
    int col;
    int day;

    public Tomato(int row, int col, int day){
        this.row = row;
        this.col = col;
        this.day = day;
    }
}

public class Main{
    static int M, N;
    static int[][] tomato;
    static Deque<Tomato> tomatoes;

    //우 하 좌 상
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomato = new int[N][M];
        tomatoes = new ArrayDeque<>();

        boolean isNotTomato = true;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int num = Integer.parseInt(st.nextToken());
                tomato[i][j] = num;
                if(num == 1){
                    tomatoes.offerLast(new Tomato(i, j, 0));
                }
                else if(num == 0 && isNotTomato){
                    isNotTomato = false;
                }
            }
        }

        if(isNotTomato){
            System.out.println(0);
            return;
        }

        dfs();

        boolean notTomato = false;
        int day = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(tomato[i][j] == 0){
                    notTomato = true;
                    break;
                }
                day = Integer.max(day, tomato[i][j]);
            }
        }

        if(notTomato){
            System.out.println(-1);
        }
        else{
            System.out.println(day);
        }
    }

    static void dfs(){
        while (!tomatoes.isEmpty()){
            Tomato nowTomato = tomatoes.pollFirst();

            for(int i = 0; i < 4; i++){
                int nextRow = nowTomato.row + dr[i];
                int nextCol = nowTomato.col + dc[i];

                if(!isTomato(nextRow, nextCol) || tomato[nextRow][nextCol] != 0)
                    continue;

                tomato[nextRow][nextCol] = nowTomato.day+1;
                tomatoes.offerLast(new Tomato(nextRow, nextCol, nowTomato.day+1));
            }
        }
    }

    static boolean isTomato(int row, int col){
        return (row >= 0 && row < N && col >= 0 && col < M);
    }
}