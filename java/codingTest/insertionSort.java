package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class insertionSort {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 삽입 정렬
        for (int i = 1; i < N; i++) {
            int insertIdx = i;
            int swiftIdx = i;
            int num = arr[i];
            // 삽입 위치 찾기
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] < arr[j]) {
                    insertIdx = j;
                }
            }
            // 뒤에서부터 한 칸씩 밀어 저장
            for (int j = swiftIdx; j > insertIdx; j-- ) {
                arr[j] = arr[j-1];
            }
            // 삽입 위치에 데이터 삽입하기
            arr[insertIdx] = num;
        }
        int[] sum = new int[N];
        sum[0] = arr[0];
        int s = sum[0];
        // 합배열 구하기
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + arr[i];
            s += sum[i];
        }
        System.out.println(s);
    }
}