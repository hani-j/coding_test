package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class main033 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }
        int sum = 0;
        while (queue.size() > 1) {
            int num1 = queue.poll();
            int num2 = queue.poll();
            sum += num1 + num2;
            queue.add(num1 + num2);
        }
        System.out.println(sum);
    }
}