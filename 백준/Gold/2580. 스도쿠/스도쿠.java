import java.util.*;
import java.io.*;

class Point{
    int row;
    int col;
    int value;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Main{
    static int[][] board;
    static List<Point> points = new ArrayList<>();
    static boolean isAns = false;

    static boolean sdoku(int num){
        // 모든 빈칸을 채웠으면 성공!
        if(num == points.size()){
            return true;
        }

        Point nowPoint = points.get(num);
        int row = nowPoint.row;
        int col = nowPoint.col;

        for (int value = 1; value <= 9; value++) {

            // 1. "만약 (row, col)에 'value'를 놓아도 괜찮을까?" 라고 먼저 물어본다.
            //    이때 board[row][col]는 아직 0인 상태.
            if (isPossible(row, col, value)) {

                // 2. "괜찮다"는 허락을 받으면, 그제서야 숫자를 놓는다.
                board[row][col] = value;

                // 3. 다음 빈칸으로 넘어간다.
                if (sdoku(num + 1)) {
                    return true; // 성공!
                }

                // 4. (실패하고 돌아왔을 때) 놓았던 숫자를 다시 지운다 (백트래킹).
                board[row][col] = 0;
            }
        }

        // 4. 되돌리기 (Undo)
        // 1부터 9까지 모든 시도가 실패했다는 의미이므로,
        // 이 칸을 다시 0으로 만들고, 이전 단계로 실패 신호를 전달.
        board[row][col] = 0;
        return false;
    }

    // 유효성 검사 함수를 하나로 합치는 것이 더 효율적입니다.
    static boolean isPossible(int row, int col, int value) {
        // 가로, 세로 검사
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) return false;
            if (board[i][col] == value) return false;
        }
        // 3x3 사각형 검사
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == value) return false;
            }
        }
        return true;
    }

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        board = new int[9][9];

        for(int i = 0; i < 9; i++){
            board[0][i] = Integer.parseInt(st.nextToken());
            if(board[0][i] == 0)
                points.add(new Point(0, i));
        }

        for(int i = 1; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0)
                    points.add(new Point(i, j));
            }
        }

        sdoku(0);

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                stringBuilder.append(board[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }
}