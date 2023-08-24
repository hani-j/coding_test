package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());       
        int scope = Integer.parseInt(st.nextToken());
        long[][] array = new long[num + 1][num + 1];

        for (int i = 1; i <= num; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= num; j++) {
                array[i][j] = array[i][j-1] + array[i -1][j] - array[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < scope; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());            
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            System.out.println(array[c][d] - array[c][b-1] - array[a-1][d] + array[a-1][b-1]);
        }
    }
}
