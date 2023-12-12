package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 16-8 11866
public class josephus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++){
            list.add(i);
        }
        int n = K - 1;
        sb.append("<");
        for(int i = 0; i < N; i++) {
            sb.append(list.get(n));
            if (i < N - 1)
                sb.append(", ");
            list.remove(n);
            n = n > 0 ? n - 1 : list.size() - 1;
            int num = K;
            while (num > 0) {
                n = n >= list.size() - 1 ? 0 : n + 1;
                num--;
            }
        }
        sb.append(">");
        System.out.println(sb.toString());
     }
}
