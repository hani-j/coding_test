package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long Min = Long.parseLong(st.nextToken());
        long Max = Long.parseLong(st.nextToken());
        
        boolean[] check = new boolean[(int)(Max - Min + 1)];

        for (long i = 2; i * i <= Max; i++) {
            long pow = i * i;
            long start_index = Min / pow;
            if (Min % pow != 0)
                start_index++;
            for (long j = start_index; pow * j <= Max; j++) {
                check[(int)(j * pow - Min)] = true;
            }
        }
        int count = 0;
        for (int i = 0; i <= Max - Min; i++) {
            if (!check[i])
                count++;
        }
        System.out.println(count);
    }
}
