package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 14-1 10815
// HashSet.contains 시간복잡도 O(1)

public class numberCard {
    static List<Integer> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            list.add(n);
        }

        Collections.sort(list);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (binarySearch(0, list.size()-1, n)) {
                bw. write("1");
            } else {
                bw.write("0");
            }
            bw.write(" ");
        }
        bw.write("\n");
        bw.flush();
    }

    static public boolean binarySearch(int s, int e, int n) {
        while (s <= e) {
            int mid = (s + e) / 2;
            int mValue = list.get(mid);

            if (mValue > n) {
                e = mid-1;
            } else if (mValue < n) {
                s = mid+1;
            } else {
                return true;
            }
        }
        return false;
    }
}
