package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main018 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            int insertIdx = i;
            int swiftIdx = i;
            int num = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] < arr[j]) {
                    insertIdx = j;
                }
            }
            for (int j = swiftIdx; j > insertIdx; j-- ) {
                arr[j] = arr[j-1];
            }
            arr[insertIdx] = num;
        }
        int[] sum = new int[N];
        sum[0] = arr[0];
        int s = sum[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + arr[i];
            s += sum[i];
        }
        System.out.println(s);
    }
}
