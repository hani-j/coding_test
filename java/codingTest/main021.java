package codingTest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class main021 {
    public static int[] arr, tmp;
    public static long count = 0;
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tmp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sort(0, N-1);
        System.out.println(count);
    }

    public static void sort(int s, int e) {
        if (e - s < 1) {
            return;
        }
        int M = (s + e) / 2;
        sort(s, M);
        sort(M + 1, e);
        for (int i = s; i <= e; i++) {
            tmp[i] = arr[i];
        }
        int idx1 = s;
        int idx2 = M+1;
        int k = s;
        while (idx1 <= M && idx2 <= e) {
            if (tmp[idx1] > tmp[idx2]) {
                arr[k++] = tmp[idx2++];
                count += idx2 - k;
            } else {
                arr[k++] = tmp[idx1++];
            }
        }
        while (idx1 <= M) {
            arr[k++] = tmp[idx1++];
        }
        while (idx2 <= e) {
            arr[k++] = tmp[idx2++];
        }
    }

    public static void swap(int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp; 
    }
}
