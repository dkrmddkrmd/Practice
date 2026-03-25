import java.util.*;
import java.io.*;

public class Main {
    static int N, K, L;
    static char[][] ground;
    static short count = 1;
    static int hr = 1, hc = 1, tr = 1, tc = 1;
    static boolean isDead = false;
    static Map<Short, Character> map;
    static char[] dir = {'R', 'D', 'L', 'U'};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ground = new char[N+1][N+1];

        for(int i =  1; i <= N; i++){
            Arrays.fill(ground[i], '.');
        }
        // 비어있는 땅은 '.' 표시

        ground[1][1] = 'R';

        K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            ground[row][col] = 'A';
        }
        // 사과 위치는 'A' 표시

        L = Integer.parseInt(br.readLine());

        // 자료구조 뭐가 제일 나을려나 1. 배열[10000] 2. 큐 3. 맵

        map = new HashMap<>();

        for(int i = 0; i < L; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            short s = Short.parseShort(st.nextToken());
            char c = st.nextToken().charAt(0);
            map.put(s, c);
        }

        move();

        System.out.println(count);
    }

    static void move(){
        while (true){
            boolean eatApple = moveHead();

            if(isDead){
                break;
            }

            moveTail(eatApple);

            if(map.containsKey(count)){
                char change = map.get(count);
                char current = ground[hr][hc];

                if(change == 'L'){
                    //왼쪽으로 꺽기
                    if(current == 'R')
                        ground[hr][hc] = 'U';
                    else if(current == 'D')
                        ground[hr][hc] = 'R';
                    else if(current == 'L')
                        ground[hr][hc] = 'D';
                    else
                        ground[hr][hc] = 'L';
                }
                else{
                    //오른쪽으로 꺽기
                    if(current == 'R')
                        ground[hr][hc] = 'D';
                    else if(current == 'D')
                        ground[hr][hc] = 'L';
                    else if(current == 'L')
                        ground[hr][hc] = 'U';
                    else
                        ground[hr][hc] = 'R';
                }
            }

            count++;
        }
    }

    static boolean moveHead(){
        // 사과를 먹었는지
        boolean apple = false;

        char direction = ground[hr][hc];

        if(direction == 'R'){
            // 벽 끝인지
            if(hc == N){
                isDead = true;
                return false;
            }
            hc++;
            if(ground[hr][hc] == 'A'){
                apple = true;
            }
            else if(ground[hr][hc] != '.'){
                // 자신의 몸통
                isDead = true;
                return false;
            }
            ground[hr][hc] = 'R';
            return apple;
        }
        else if(direction == 'D'){
            // 벽 끝인지
            if(hr == N){
                isDead = true;
                return false;
            }
            hr++;
            if(ground[hr][hc] == 'A'){
                apple = true;
            }
            else if(ground[hr][hc] != '.'){
                // 자신의 몸통
                isDead = true;
                return false;
            }
            ground[hr][hc] = 'D';
            return apple;
        }
        else if(direction == 'L'){
            // 벽 끝인지
            if(hc == 1){
                isDead = true;
                return false;
            }
            hc--;
            if(ground[hr][hc] == 'A'){
                apple = true;
            }
            else if(ground[hr][hc] != '.'){
                // 자신의 몸통
                isDead = true;
                return false;
            }
            ground[hr][hc] = 'L';
            return apple;
        }
        else{ // 'U'
            // 벽 끝인지
            if(hr == 1){
                isDead = true;
                return false;
            }
            hr--;
            if(ground[hr][hc] == 'A'){
                apple = true;
            }
            else if(ground[hr][hc] != '.'){
                // 자신의 몸통
                isDead = true;
                return false;
            }
            ground[hr][hc] = 'U';
            return apple;
        }
    }

    static void moveTail(boolean eatApple){
        if(eatApple){
            return;
        }

        if(ground[tr][tc] == 'R'){
            ground[tr][tc] = '.';
            tc++;
        }
        else if(ground[tr][tc] == 'D'){
            ground[tr][tc] = '.';
            tr++;
        }
        else if(ground[tr][tc] == 'L'){
            ground[tr][tc] = '.';
            tc--;
        }
        else{ // U
            ground[tr][tc] = '.';
            tr--;
        }
    }
}