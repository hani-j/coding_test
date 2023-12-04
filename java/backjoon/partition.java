package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 15-8 17103
public class partition {
    static int[] prime = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        setPrime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(getPartitionCount(n) + "\n");
        }
        System.out.println(sb.toString());
    }

    static public void setPrime() {
        for (int i = 2; i <= 1000000; i++) {
            prime[i] = i;
        }
        for (int i = 2; i <= 1000000; i++) {
            if (prime[i] > 0) {
                for (int j = i * 2; j <= 1000000; j += 2) {
                    prime[j] = 0;
                }
            }
        }
    }

    static public int getPartitionCount(int number) {
        int count = 0;
        for (int i = 2; i <= number - 2; i++) {
            if (prime[i] > 0 && prime[number - i] > 0)
                count++;
        }
        System.out.println(count);
        return count;
    }
}
