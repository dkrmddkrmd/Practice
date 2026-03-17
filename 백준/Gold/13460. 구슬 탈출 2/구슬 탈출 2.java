import java.util.*;
import java.io.*;

class State{
    int redR;
    int redC;

    int blueR;
    int blueC;

    int count;

    public State(int redR, int redC, int blueR, int blueC, int count) {
        this.redR = redR;
        this.redC = redC;
        this.blueR = blueR;
        this.blueC = blueC;
        this.count = count;
    }
}


public class Main {
    static int N, M;
    static int redR, redC, blueR, blueC, holeR, holeC;
    static char[][] ground;

    // 우, 하, 좌, 상
    static int[] dirR = {0, 1, 0, -1};
    static int[] dirC = {1, 0, -1, 0};

    static boolean[][][][] check;
    static boolean findHole;
    static int findCount;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ground = new char[N][M];
        check = new boolean[N][M][N][M];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                char c = s.charAt(j);
                if(c == 'B'){
                    blueR = i;
                    blueC = j;
                }
                else if(c == 'R'){
                    redR = i;
                    redC = j;
                }
                else if(c == 'O'){
                    holeR = i;
                    holeC = j;
                }
                ground[i][j] = c;
            }
        }

        State state = new State(redR, redC, blueR, blueC, 0);

        bfs(state);

        if(findHole)
            System.out.println(findCount);
        else
            System.out.println(-1);
    }

    static void bfs(State state){
        Queue<State> q = new ArrayDeque<>();
        q.offer(state);

        while (!q.isEmpty() && !findHole){
            State now = q.poll();
            if(now.count >= 10) continue;

            for(int i = 0; i < 4; i++){
                State next = go(now, i);
                if(next != null && !check[next.redR][next.redC][next.blueR][next.blueC] && !findHole){
                    q.offer(next);
                    check[now.redR][now.redC][now.blueR][now.blueC] = true;

                }
            }
        }
    }

    static State go(State state, int n){
        int nextBlueR = state.blueR;
        int nextBlueC = state.blueC;
        int nextRedR = state.redR;
        int nextRedC = state.redC;

        while (true){
            nextBlueR += dirR[n];
            nextBlueC += dirC[n];

            // 만약 파란 구슬이 구멍에 빠져 버린다면 아예 끝
            if(nextBlueR == holeR && nextBlueC == holeC)
                return null;

            if(ground[nextBlueR][nextBlueC] == '#'){
                nextBlueR -= dirR[n];
                nextBlueC -= dirC[n];
                break;
            }
        }

        while (true){
            nextRedR += dirR[n];
            nextRedC += dirC[n];

            // 빨간 구슬이 구멍에 빠지면
            if(nextRedR == holeR && nextRedC == holeC){
                findHole = true;
                findCount = state.count + 1;
                return(new State(nextRedR, nextRedC, nextBlueR, nextBlueC, state.count + 1));
            }

            if(ground[nextRedR][nextRedC] == '#'){
                nextRedR -= dirR[n];
                nextRedC -= dirC[n];
                break;
            }
        }

        //만약 동일 위치
        if (nextRedR == nextBlueR && nextRedC == nextBlueC) {
            if (n == 0) { // 우
                if (state.redC > state.blueC) nextBlueC -= dirC[n];
                else nextRedC -= dirC[n];
            } else if (n == 1) { // 하
                if (state.redR > state.blueR) nextBlueR -= dirR[n];
                else nextRedR -= dirR[n];
            } else if (n == 2) { // 좌
                if (state.redC > state.blueC) nextRedC -= dirC[n];
                else nextBlueC -= dirC[n];
            } else { // 상
                if (state.redR > state.blueR) nextRedR -= dirR[n];
                else nextBlueR -= dirR[n];
            }
        }

        return new State(nextRedR, nextRedC, nextBlueR, nextBlueC, state.count+1);
    }
}