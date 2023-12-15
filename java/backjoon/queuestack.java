package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 16-11 24511
public class queuestack { // 2 1 4
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();
 
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(st1.nextToken()) == 0)
                queue.addFirst(Integer.parseInt(st2.nextToken()));
            else
                st2.nextToken();
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st1 = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < M; i++) {
            queue.add(Integer.parseInt(st1.nextToken()));
            sb.append(queue.poll() + " ");
        }
        System.out.println(sb.toString());
    }
}
