import java.util.*;
import java.io.*;

class Home{
    int row;
    int col;

    public Home(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Main{
    static int[][] board;
    static int N;

    static List<Integer> homes = new ArrayList<>();
    static int seq = 0;

    static boolean[][] visited;

    //상 우 하 좌
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    static void check(){

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if(board[i][j] == 1 && !visited[i][j]){
                    bfs(i, j);
                    seq++;
                }
            }
        }
    }

    static void bfs(int row, int col){
        // 집 하나 추가
        homes.add(1);
        // 방문 표시
        visited[row][col] = true;

        Deque<Home> queue = new ArrayDeque<>();
        queue.offerLast(new Home(row, col));

        while (!queue.isEmpty()){
            Home nowHome = queue.pollFirst();
            //상 우 하 좌 검색 후, 있으면 homes[seq]++ 및 visited = true
            for(int i = 0; i < 4; i++){
                int nowRow = nowHome.row + dr[i];
                int nowCol = nowHome.col + dc[i];

                if(nowRow >= 0 && nowRow < N && nowCol >= 0 && nowCol < N && !visited[nowRow][nowCol] && board[nowRow][nowCol] == 1){
                    queue.offerLast(new Home(nowRow,nowCol));
                    homes.set(seq, homes.get(seq) + 1);
                    visited[nowRow][nowCol] = true;
                }
            }
        }
    }

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for(int i = 0; i < N; i++){
            String nums = br.readLine();
            for(int j = 0; j < N; j++){
                board[i][j] = nums.charAt(j) - '0';
            }
        }

        visited = new boolean[N][N];

        check();

        Collections.sort(homes);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(homes.size()).append("\n");
        for(int i = 0; i < homes.size(); i++){
            stringBuilder.append(homes.get(i)).append("\n");
        }

        System.out.println(stringBuilder);
    }
}