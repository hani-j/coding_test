package codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class main042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int small = A > B ? B : A;
            int big = B <= A ? A : B;
            
            while (big % small != 0) {
                int tmp = small;
                small = big % small;
                big = tmp;
            }
            bw.write(A * B / small + "\n");

        }
        bw.flush();
        bw.close();
    }

    // public static int gcd(int a, int b) {
    //     if (b == 0)
    //         return a;
    //     else
    //         return gcd(b, a % b);
    // }
}
