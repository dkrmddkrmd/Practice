import java.util.*;
import java.io.*;

class Tomato{
    int row;
    int col;
    int day;

    public Tomato(int row, int col, int day) {
        this.row = row;
        this.col = col;
        this.day = day;
    }
}

public class Main{
    static int badTomatos;
    static int[][] ground;
    static Deque<Tomato> goodTomatos;
    static int N, M;
    static int day = 0;

    //상 우 하 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static void dfs(){
        while (!goodTomatos.isEmpty()){
            Tomato now = goodTomatos.pollFirst();

            for(int i = 0; i < 4; i++){
                int nextRow = now.row + dr[i];
                int nextCol = now.col + dc[i];
                int nextDay = now.day + 1;

                if(check(nextRow, nextCol)){
                    if(ground[nextRow][nextCol] == 0){
                        ground[nextRow][nextCol] = 1;
                        goodTomatos.offerLast(new Tomato(nextRow, nextCol, nextDay));
                        badTomatos--;
                        day = Math.max(day, nextDay);
                    }
                }
            }
        }
    }

    static boolean check(int row, int col){
        return row >= 0 && row < N && col >= 0 && col < M;
    }

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        ground = new int[N][M];
        badTomatos = 0;
        goodTomatos = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int tomato = Integer.parseInt(st.nextToken());
                ground[i][j] = tomato;
                if(tomato == 0)
                    badTomatos++;
                else if(tomato == 1){
                    goodTomatos.offerLast(new Tomato(i, j, 0));
                }
            }
        }

        if(badTomatos == 0){
            System.out.println(0);
            return;
        }

        dfs();

        if(badTomatos == 0)
            System.out.println(day);
        else{
            System.out.println(-1);
        }
    }
}