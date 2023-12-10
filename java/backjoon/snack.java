package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

// 16-5 12789
public class snack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            list.add(n);
        }
        int n = 1;
        int i = 0;
        while (n <= N) {
            if (i < N && list.get(i) == n) {
                n++;
                i++;
            } else if (!stack.isEmpty() && stack.peek() == n) {
                stack.pop();
                n++;
            } else if (i < N && list.get(i) > n) {
                stack.push(list.get(i));
                i++;
            } else
                break;
        }

        if (i == N && stack.isEmpty())
            System.out.println("Nice");
        else
            System.out.println("Sad");
    }
}