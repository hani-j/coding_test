package codingTest;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main008 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] arr =  new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;
            while (start < end) {
                long sum = arr[start] + arr[end];
                if (sum == arr[i]) {
                    if (start != i && end != i) {
                        count++;
                        break;
                    } else if (start == i)
                        start++;
                    else if (end == i)
                        end--;
                } else if (sum < arr[i]) {
                    start++;
                } else if (sum > arr[i]) {
                    end--;
                }
            }
        }
        System.out.println(count);
    }
}

// 참고
// 3
// 0 0 0
// 같은 숫자가 나왔을 경우를 생각 못함