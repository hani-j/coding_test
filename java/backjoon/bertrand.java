package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 15-7 4948
public class bertrand {
    static int N = 123456 * 2;
    static int[] prime = new int[N + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setPrime();
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;
            int c = getCount(n);
            sb.append(c + "\n");
        }
        System.out.println(sb.toString());
    }

    public static void setPrime() {
        for (int i = 2; i <= N; i++) {
            prime[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (prime[i] > 0) {
                for (int j = i * 2; j <= N; j += i) {
                    prime[j] = 0;
                }
            }
        }
    }

    public static int getCount(int number) {
        int count = 0;
        if (number == 1)
            return 1;
        for (int i = number + 1; i <= number * 2 ; i++) {
            if (prime[i] > 0) {
                count++;
            }
        }
        return count;
    }
}