import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            int num = scanner.nextInt();
            arr[i] = num;
        }

        Arrays.sort(arr);

        for(int i = 0; i < n; i++)
            System.out.println(arr[i]);
    }
}