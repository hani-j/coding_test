package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class quickSort {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(arr, 0, arr.length-1, K-1);
        System.out.println(arr[K-1]);
    }

    // 퀵 정렬
    private static void quickSort(int[] arr, int start, int end, int K) {
        if (start < end) {
            // pivot 을 중심으로 2개의 집합으로 나누어 정렬
            int pivot = getPivot(arr, start, end);
            if (pivot == K)
                return ;
            else if (K < pivot)
                quickSort(arr, start, pivot-1, K);
            else
                quickSort(arr, pivot+1, end, K);
        }
    }

    // pivot 구하기
    private static int getPivot(int[] arr, int start, int end) {
        if (start + 1 == end) {
            if (arr[start] > arr[end])
                swap(arr, start, end);
            return end;
        }
        int M = (start + end) / 2;
        swap(arr, start, M);

        int pivot = arr[start];
        int i = start+1;
        int j = end;
        while (i <= j) {
            // pivot 보다 작은 수가 나올 때까지
            while (pivot < arr[j] && j > 0)
                j--;
            // pivot 보다 큰 수가 나올 때까지
            while (pivot > arr[i] && i < arr.length-1)
                i++;
            if (i <= j)
                swap(arr, i++, j--);
        }
        // pivot 값을 양쪽으로 분리한 가운데에 오도록 설정
        arr[start] = arr[j];
        arr[j] = pivot;
        return j;
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}