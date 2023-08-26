package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class main007 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int result = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        int n = 0;
        while (n < N) {
            array[n++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int start = 0;
        int end = N - 1;
        int count = 0;
        while (start < end) {
            int sum = array[start] + array[end];
            if (sum > result)
                end--;
            else if (sum < result)
                start++;
            else {
                count++;
                start++;
                end = N -1;
            }
        }
        System.out.println(count);
    }
}
