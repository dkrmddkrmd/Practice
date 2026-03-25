import java.util.*;
import java.io.*;

public class Main {
    static int N, B, C;
    static int[] students;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        students = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            students[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long count = N;

        for(int i = 0; i < N; i++){
            if(students[i] - B <= 0){
                continue;
            }

            count += ((students[i] - B) / C);

            if((students[i]-B) % C != 0){
                count++;
            }
        }

        System.out.println(count);
    }
}