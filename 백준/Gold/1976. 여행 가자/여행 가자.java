import java.nio.IntBuffer;
import java.util.*;
import java.io.*;

public class Main{
    static int N, M;

    static int[] parent;

    static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            parent[rootY] = rootX;
        }
    }

    static int find(int x){
        if(x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];

        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        StringTokenizer st;
        int num;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int parentNum = find(Integer.parseInt(st.nextToken()));
        boolean isAnswer = true;
        for(int i = 0; i < M-1; i++){
            if(parentNum != find(Integer.parseInt(st.nextToken()))){
                isAnswer = false;
            }
        }

        if(isAnswer){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}