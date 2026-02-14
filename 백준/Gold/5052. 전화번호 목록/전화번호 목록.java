import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            boolean isConsistent = true;

            String[] phoneNumbers = new String[n];

            for(int i = 0; i < n; i++){
                phoneNumbers[i] = br.readLine();
            }

            Arrays.sort(phoneNumbers);

            for(int i = 0; i < n-1; i++){
                if(phoneNumbers[i+1].startsWith(phoneNumbers[i])){
                    isConsistent = false;
                    break;
                }
            }

            if(isConsistent)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }

        System.out.println(sb);
    }
}