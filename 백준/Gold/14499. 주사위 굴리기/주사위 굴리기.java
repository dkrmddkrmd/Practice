import java.util.*;
import java.io.*;

class Dice{
    int up;
    int down;
    int left;
    int right;
    int front;
    int back;
    int row;
    int col;

    // 주사위 x,y 위치 & 바닥에는 6, 위는 1, 동쪽 3
    public Dice(int row, int col){
        this.up = 0;
        this.down = 0;
        this.left = 0;
        this.right = 0;
        this.front = 0;
        this.back = 0;
        this.row = row;
        this.col = col;
    }

    public void rollRight(){
        int temp = right;
        right = up;
        up = left;
        left = down;
        down = temp;
    }

    public void rollLeft(){
        int temp = left;
        left = up;
        up = right;
        right = down;
        down = temp;
    }

    public void rollFront(){
        int temp = front;
        front = up;
        up = back;
        back = down;
        down = temp;
    }

    public void rollBack(){
        int temp = back;
        back = up;
        up = front;
        front = down;
        down = temp;
    }
}

public class Main {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] roll;

    //동 서 북 남 - 1 2 3 4
    static int[] dirR = {0, 0, -1, 1};
    static int[] dirC = {1, -1, 0, 0};

    static Dice dice;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        roll = new int[K];
        dice = new Dice(x, y);

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            roll[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = play();

        System.out.println(sb);
    }

    static StringBuilder play(){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < K; i++){
            int dirRoll = roll[i];

            if(dirRoll == 1){ // 동
                //바깥 이동 명령인지 확인
                if(dice.col == M-1){
                    continue;
                }

                //주사위 이동
                dice.col++;
                dice.rollRight();

                print();

                sb.append(dice.up).append("\n");
            }
            else if(dirRoll == 2){ // 서
                //바깥 이동 명령인지 확인
                if(dice.col == 0){
                    continue;
                }

                //주사위 이동
                dice.col--;
                dice.rollLeft();

                print();

                sb.append(dice.up).append("\n");
            }
            else if(dirRoll == 3){ // 북
                //바깥 이동 명령인지 확인
                if(dice.row == 0){
                    continue;
                }

                //주사위 이동
                dice.row--;
                dice.rollFront();

                print();

                sb.append(dice.up).append("\n");
            }
            else{ // 남
                //바깥 이동 명령인지 확인
                if(dice.row == N-1){
                    continue;
                }

                //주사위 이동
                dice.row++;
                dice.rollBack();

                print();

                sb.append(dice.up).append("\n");
            }
        }

        return sb;
    }

    static void print(){
        if(map[dice.row][dice.col] == 0){
            map[dice.row][dice.col] = dice.down;
        }
        else{
            dice.down = map[dice.row][dice.col];
            map[dice.row][dice.col] = 0;
        }
    }

}