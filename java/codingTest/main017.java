package codingTest;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class main017 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        Integer[] iarr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            iarr[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(iarr, Collections.reverseOrder());
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

        // for (int i = 0; i < iarr.length; i++) {
        //     int max = iarr[i];
        //     int idx = i;
        //     for (int j = i + 1; j < iarr.length; j++) {
        //         if (max < iarr[j]) {
        //             max = iarr[j];
        //             idx = j;
        //         }
        //     }
        //     int tmp = iarr[i];
        //     iarr[i] = iarr[idx];
        //     iarr[idx] = tmp;
        // }