package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main030 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] array = new int[N];

        int start = 0;
        int end = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            if (start < array[i])
                start = array[i];
            end += array[i];
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (sum + array[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += array[i];
            }
            if (sum != 0)
                count++;
            if (count > B)
                start = mid + 1;
            else    
                end = mid - 1;
        }
        System.out.println(start);
    }
}
