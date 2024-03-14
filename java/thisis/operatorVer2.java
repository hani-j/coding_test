package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class operatorVer2 {
	static int N;
    static int[] arr;
    static int[] op;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }
    private static void dfs(int d, int num){
        if (d == N-1){
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }

        for (int i=0;i<4;i++){
            if (op[i] > 0){
                op[i]--;
                dfs(d + 1, calc(i, num, arr[d + 1]));
                op[i]++;
            }
        }
    }

    private static int calc(int op, int a, int b){
        switch (op){
            case 0:
                a += b;
                break;
            case 1:
                a -= b;
                break;
            case 2:
                a *= b;
                break;
            case 3:
                a /= b;
                break;
        }
        return a;
    }
}
