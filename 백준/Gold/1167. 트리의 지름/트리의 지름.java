import java.util.*;
import java.io.*;

class Node{
    int from;
    int to;
    int weight;

    public Node(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

public class Main{
    static List<List<Node>> nodes;

    static boolean[] visited;
    static int[] dist;

    static Node farNode = null;
    static int maxDistance = 0;

    static Deque<Integer> dq = new ArrayDeque<>();

    static void findDistance() {
        while (!dq.isEmpty()){
            int now = dq.pollFirst();

            for(Node neighbor : nodes.get(now)){
                if(!visited[neighbor.to]){
                    visited[neighbor.to] = true;
                    int newDist = dist[now] + neighbor.weight;
                    dist[neighbor.to] = newDist;
                    if(newDist > maxDistance){
                        maxDistance = newDist;
                        farNode = neighbor;
                    }
                    dq.offerLast(neighbor.to);
                }
            }
        }
    }

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        nodes = new ArrayList<>();
        for(int i = 0; i <=N ; i++){
            nodes.add(new ArrayList<>());
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());

            while (true){
                int to = Integer.parseInt(st.nextToken());
                if(to == -1)
                    break;
                int weight = Integer.parseInt(st.nextToken());

                nodes.get(nodeNum).add(new Node(nodeNum, to, weight));
            }
        }
        visited = new boolean[N+1];
        dist = new int[N+1];

        visited[1] = true;
        dq.offerLast(1);

        findDistance();
        Arrays.fill(visited, false);
        Arrays.fill(dist, 0);
        maxDistance = 0;

        visited[farNode.to] = true;
        dq.offerLast(farNode.to);
        findDistance();

        System.out.println(maxDistance);
    }
}