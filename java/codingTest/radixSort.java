package codingTest;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class radixSort {
    public static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        radix_sort(5);
        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    // 기수 정렬
    public static void radix_sort(int max_size) {
        int[] output = new int[arr.length];
        int jarisu = 1; // 1, 10, 100 ..
        int count = 0; 
        // 자리 수(max_size) 만큼 반복
        while (count != max_size) {
            int[] bucket = new int[10];
            // 1의 자리(부터) 0~9 까지 개수 저장
            for (int i = 0; i < arr.length; i++) {
                bucket[(arr[i] / jarisu) % 10]++;    
            }
            // 합배열 구하기
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i-1];
            }
            // 뒤에서부터 조회하며 output 배열에 bucket index 에 저장하고 1감소
            for (int i = arr.length - 1; i >= 0; i--) {
                output[bucket[(arr[i] / jarisu % 10)] - 1] = arr[i];
                bucket[(arr[i] / jarisu) % 10]--;
            }
            // arr 업데이트
            for (int i = 0; i < arr.length; i++) {
                arr[i] = output[i];
            }
            jarisu = jarisu * 10;
            count++;
        }
    }
}
