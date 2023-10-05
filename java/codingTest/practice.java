package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class practice {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boolean find = false;
            int start = 0;
            int end = array.length - 1;
            int target = Integer.parseInt(st.nextToken());
            while (start <= end) {
                int mid = (start + end) / 2;
                int midVal = array[mid];
                if (midVal < target) {
                    start = mid + 1;
                } else if (midVal > target) {
                    end = mid - 1;
                } else {
                    find = true;
                    break;
                }
            }
            if (find == true)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
