package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class remainderSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] S = new int[N + 1];
        int[] C = new int[M];
        
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            S[i] = (S[i - 1] + Integer.parseInt(st.nextToken())) % M;
            C[S[i]]++;
        }

        long count = 0;
        for (int i = 1; i <= N; i++) {
            if (S[i] == 0)
                count++;
        }

        for (long i : C){
            count += i * (i - 1) / 2;
        }
        System.out.println(count);
    }
}
