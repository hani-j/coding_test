package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 14-8 11478
public class differentString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();

        String str = br.readLine();

        for (int i = 1; i <= str.length(); i++) {
            int s = 0;
            while (s <= str.length() - i){
                set.add(str.substring(s, s+i));
                s++;
            }
        }
        System.out.println(set.size());
    }
}
