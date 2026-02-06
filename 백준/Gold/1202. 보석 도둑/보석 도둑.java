import java.util.*;
import java.io.*;

class Jewel implements Comparable<Jewel>{
    int weight;
    int value;

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int compareTo(Jewel o){
        return this.weight - o.weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewels[i] = new Jewel(w, v);
        }

        Arrays.sort(jewels);

        PriorityQueue<Integer> jewelValues = new PriorityQueue<>(Comparator.reverseOrder());

        int[] bags = new int[K];

        for(int i = 0; i < K; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);

        int jewelInd = 0;
        long ans = 0;

        for(int i = 0; i < K; i++){
            while (jewelInd < N && bags[i] >= jewels[jewelInd].weight){
                jewelValues.offer(jewels[jewelInd].value);
                jewelInd++;
            }

            if (!jewelValues.isEmpty()) {
                ans += jewelValues.poll();
            }
        }

        System.out.println(ans);
    }
}