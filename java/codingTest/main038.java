package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main038 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long[] array = new long[10000001];

        for (int i = 2; i <= 10000000; i++) {
            array[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(10000001); i++) {
            if (array[i] > 0) {
                for (int j = i*2; j < 10000001; j += i) {
                    array[j] = 0;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < 10000001; i++) {
            if (array[i] != 0) {
                long tmp = array[i];
                while ((double)array[i] <= (double)B/(double)tmp) {
                    if ((double)array[i] >= (double)A/(double)tmp) {
                        count++;
                    }
                    tmp *= array[i];
                }
            }
        }
        System.out.println(count);
    }
}