package codingTest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
// import java.util.Arrays;

public class main019 {

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
        // Arrays.sort(arr);
        System.out.println(arr[K-1]);
    }

    private static void quickSort(int[] arr, int start, int end, int K) {
        if (start < end) {
            int pivot = getPivot(arr, start, end);
            if (pivot == K)
                return ;
            else if (K < pivot)
                quickSort(arr, start, pivot-1, K);
            else
                quickSort(arr, pivot+1, end, K);
        }
    }

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
            while (pivot < arr[j] && j > 0)
                j--;
            while (pivot > arr[i] && i < arr.length-1)
                i++;
            if (i <= j)
                swap(arr, i++, j--);
        }
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
