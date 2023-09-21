package codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class mergeSort {
    public static int[] arr, tmp;
    public static long result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        tmp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        sort(1, N);
        for (int i = 1; i <= N; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    // 병합 정렬
    public static void sort(int s, int e) {
        if(e - s < 1)
            return ;
        int m = s + (e - s) / 2;
        // 왼쪽 그룹 정렬
        sort(s, m);
        // 오른쪽 그룹 정렬
        sort(m+1, e);
        for (int i = s; i <= e; i++) {
            tmp[i] = arr[i];
        }
        int k = s;
        int idx1 = s;
        int idx2 = m + 1;
        // 두 그룹을 병합
        while (idx1 <= m && idx2 <= e) {
            // 가장 앞의 값을 비교해 더 작은 수를 배열에 저장
            if (tmp[idx1] > tmp[idx2]) {
                arr[k] = tmp[idx2];
                k++;
                idx2++;
            } else {
                arr[k] = tmp[idx1];
                k++;
                idx1++;
            }
        }
        // 남아 있는 값 정리
        while (idx1 <= m) {
            arr[k] = tmp[idx1];
            k++;
            idx1++;
        }
        while (idx2 <= e) {
            arr[k] = tmp[idx2];
            k++;
            idx2++;
        }
    }
}
