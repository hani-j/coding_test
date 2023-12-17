package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 24-3 16139
public class humanComputer {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[S.length() + 1];

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 1; j <= S.length(); j++) {
                if (S.charAt(j - 1) == str.charAt(0)){
                    arr[j] = arr[j - 1] + 1;
                } else
                    arr[j] = arr[j - 1];
            }
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write(arr[e + 1] - arr[s] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
