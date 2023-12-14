package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 16-10 2346
public class balloon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            list.add(new Node(n, i + 1));
        }
        
        int n = 0;
        while(!list.isEmpty()) {
            int diff = list.get(n).n;
            sb.append((list.get(n).idx) + " ");
            list.remove(n);
            if (diff > 0)
                n--;
            while (diff > 0) {
                if (n == list.size() - 1) 
                    n = 0;
                else
                    n++;
                diff--;
            }
            while (diff < 0) {
                if (n == 0)
                    n = list.size() - 1;
                else
                    n--;
                diff++;
            }
        }
        System.out.println(sb.toString());
     }
    static class Node {
        int n;
        int idx;

        Node(int n, int idx) {
            this.n = n;
            this.idx = idx;
        }
    }
}
