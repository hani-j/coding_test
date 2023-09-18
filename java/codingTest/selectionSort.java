package codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class selectionSort {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        Integer[] iarr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            iarr[i] = Integer.parseInt(arr[i]);
        }
        // 선택 정렬 (최솟값을 찾아 가장 앞의 데이터와 swap)
        for (int i = 0; i < iarr.length; i++) {
            int max = iarr[i];
            int idx = i;
            // 최댓값 찾아서 swap 하기 (내림차순이기 때문)
            for (int j = i + 1; j < iarr.length; j++) {
                if (max < iarr[j]) {
                    max = iarr[j];
                    idx = j;
                }
            }
            int tmp = iarr[i];
            iarr[i] = iarr[idx];
            iarr[idx] = tmp;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i =0; i < iarr.length; i++) {
            bw.write(iarr[i]+"");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
