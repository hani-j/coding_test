package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class main034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> q2 = new PriorityQueue<>();
        
        int zero = 0;
        int one = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 1)
                one++;
            else if (n < 0) {
                q2.add(n);
            } else if (n > 0) {
                q1.add(n);
            } else {
                zero++;
            }
        }
        int sum = 0;
        while (q1.size() > 1) {
            int num1 = q1.poll();
            int num2 = q1.poll();
            sum += num1 * num2;
        }
        if (!q1.isEmpty())
            sum += q1.poll();
        while (q2.size() > 1) {
            int num1 = q2.poll();
            int num2 = q2.poll();
            sum += num1 * num2;
        }
        if (!q2.isEmpty() && zero == 0)
            sum += q2.poll();
        while (one > 0) {
            sum++;
            one--;
        }
        System.out.println(sum);
    }
}
