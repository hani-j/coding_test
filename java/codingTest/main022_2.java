package codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 계수정렬
public class main022_2 {
    static int N;
    static int[] arr = new int[10_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int inputNumber = Integer.parseInt(br.readLine());
            arr[inputNumber]++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1; i <= 10_000; i++){
            while(arr[i] > 0){
                bw.write(i + "\n");
                arr[i]--;
            }
        }
        bw.flush();
        bw.close();
    }
}
