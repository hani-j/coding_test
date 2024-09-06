package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class File {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        StringBuilder sb = new StringBuilder();
        
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine().trim());
            int[] sizes = new int[K];
            StringTokenizer st = new StringTokenizer(br.readLine().trim()); // 파일 크기들
            for (int i = 0; i < K; i++) {
                sizes[i] = Integer.parseInt(st.nextToken());
            }
            
            int[][] d = new int[K][K];
            int[][] sum = new int[K][K];
            for (int i = 0; i < K; i++) {
                sum[i][i] = sizes[i];
                for (int j = i + 1; j < K; j++) {
                    sum[i][j] = sum[i][j - 1] + sizes[j];
                }
            }
            
            for (int len = 2; len <= K; len++) {
                for (int i = 0; i <= K - len; i++) {
                    int j = i + len - 1;
                    d[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k + 1][j] + sum[i][j]);
                    }
                }
            }
            sb.append(d[0][K - 1]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
