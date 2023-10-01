package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class binarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A[] = new int[N];
        for (int i = 0 ; i < N; i++) {
            A[i] =  Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < M; i++) {
            int target =  Integer.parseInt(st.nextToken());
            boolean find = false;
            int start = 0;
            int end = A.length - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                int midVal = A[mid];

                // 중간값과 타겟을 비교하여 왼쪽 오른쪽을 정함
                if (midVal > target) {
                    end = mid - 1;
                } else if (midVal < target) {
                    start = mid + 1;
                } else {
                    find = true;
                    break;
                }
            }
            if (find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
