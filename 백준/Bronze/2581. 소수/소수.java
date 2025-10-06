import java.util.*;
import java.io.*;

public class Main{
    static boolean isPrime(int num){
        if(num < 2)
            return false;
        
        if(num == 2 || num == 3)
            return true;
        
        if(num % 2 == 0){
            return false;
        }

        if(num % 3 == 0){
            return false;
        }

        for(int i = 5; i * i <= num; i+= 2){
            if(num % i == 0)
                return false;
        }

        return true;
    }

    public static void  main(String[] args) throws  Exception{
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int sum = 0;
        int minVal = 0;
        boolean isFirstNum = true;

        for(int i = M; i <= N; i++){
            if(isPrime(i)){
                sum += i;
                if(isFirstNum){
                    minVal = i;
                    isFirstNum = false;
                }
            }
        }

        if(sum == 0){
            System.out.println(-1);
        }
        else{
            System.out.println(sum + "\n" + minVal);
        }

    }
}