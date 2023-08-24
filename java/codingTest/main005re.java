package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main005re {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n + 1];
        long[] rem = new long[m];
        int answer = 0;
        arr[0] = Long.parseLong(st.nextToken());
        rem[(int)arr[0] % m]++; 
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + Long.parseLong(st.nextToken());
            long remainder = arr[i] % m;
            rem[(int)remainder]++;
        }
        answer += rem[0];
        for (int i = 0; i < m; i++) {
            long c = rem[i];
            answer += c * (c - 1) / 2;
        }
        System.out.println(answer);
    }
}
