package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

// 14-6 1764
public class unheard {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        HashSet<String> hashSet = new HashSet<>();
        List<String> contain = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            hashSet.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (hashSet.contains(name))
                contain.add(name);
        }
        
        contain.sort((a, b) -> a.compareTo(b));
        sb.append(contain.size() + "\n");
        for (int i = 0; i < contain.size(); i++) {
            sb.append(contain.get(i));
            if (i != contain.size() - 1)
                sb.append("\n");
        }
        System.out.println(sb);
    }
}
