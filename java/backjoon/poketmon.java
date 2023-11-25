package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 14-4 1620
public class poketmon {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());        
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> nameMap = new HashMap<>();        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> numMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameMap.put(name, i);
            numMap.put(i, name);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (str.matches("\\d+"))
                bw.write(numMap.get(Integer.parseInt(str)) + "\n");
            else
                bw.write(nameMap.get(str) + "\n");
        }
        bw.flush();
    }
}
