import java.util.*;
import java.io.*;

public class Main{
    public static void  main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder stringBuilder = new StringBuilder();

        List<Integer> arrays = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            arrays.add((s.charAt(i) - '0'));
        }

        arrays.sort(Comparator.reverseOrder());

        for(int num : arrays)
            stringBuilder.append(num);

        System.out.println(stringBuilder);
    }
}