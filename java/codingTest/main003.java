package codingTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main003 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int scopeNum = Integer.parseInt(st.nextToken());

        long sumArray[] = new long[num + 1];
        st = new StringTokenizer(br.readLine());
        // sumArray[0] = 0L;

        for (int i = 1; i <= num; i++) {
            sumArray[i] = sumArray[i - 1] + Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < scopeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            System.out.println(sumArray[k] - sumArray[j - 1]);
        }
    }
}
