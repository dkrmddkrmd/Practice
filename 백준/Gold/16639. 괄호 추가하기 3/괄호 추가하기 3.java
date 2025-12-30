import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static List<Integer> nums;
    static List<Character> ops;
    static int[][] maxDp;
    static int[][] minDp;

    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 초기화
        nums = new ArrayList<>();
        ops = new ArrayList<>();

        String expression = br.readLine();
        for(int i = 0; i < N; i++){
            if(i % 2 == 0){
                nums.add(expression.charAt(i) - '0');
            }
            else{
                ops.add(expression.charAt(i));
            }
        }

        int size = nums.size();
        maxDp = new int[size][size];
        minDp = new int[size][size];

        // dp 초기화
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(i == j){
                    maxDp[i][j] = minDp[i][j] = nums.get(i);
                }
                else{
                    maxDp[i][j] = Integer.MIN_VALUE;
                    minDp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int len = 1; len < size; len++){
            for(int i = 0; i < size - len; i++){
                int j = i + len;

                for(int k = i; k < j; k++){
                    char op = ops.get(k);

                    int[] vals = new int[4];

                    vals[0] = calc(maxDp[i][k], maxDp[k+1][j], op);
                    vals[1] = calc(maxDp[i][k], minDp[k+1][j], op);
                    vals[2] = calc(minDp[i][k], maxDp[k+1][j], op);
                    vals[3] = calc(minDp[i][k], minDp[k+1][j], op);

                    for(int num : vals){
                        maxDp[i][j] = Integer.max(maxDp[i][j], num);
                        minDp[i][j] = Integer.min(minDp[i][j], num);
                    }
                }
            }

        }

        System.out.println(maxDp[0][size-1]);
    }

    static int calc(int a, int b, char op){
        if(op == '+') return a + b;
        else if(op == '-') return a - b;
        else return a * b;
    }
}
