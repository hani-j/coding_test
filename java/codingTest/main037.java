package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] array = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            array[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (array[i] > 0) {
                for (int j = i * 2; j <= N; j += i) {
                    array[j] = 0;
                }
            }
        }
        for (int i = M; i <= N; i++) {
            if (array[i] != 0)
                System.out.println(array[i]);
        }
    }
}
