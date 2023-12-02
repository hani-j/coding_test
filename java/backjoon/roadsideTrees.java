package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class roadsideTrees {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        List<Integer> diff = new ArrayList<>();

        int before = Integer.parseInt(br.readLine());
        list.add(before);
        for (int i = 1; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            list.add(n);
            diff.add(n - before);
            before = n;
        }
        int gcd = gcd(diff.get(0), diff.get(1));
        for (int i = 0; i < N - 2; i++) {
            gcd = gcd(gcd, diff.get(i + 1));
        }
        int range = list.get(list.size() - 1) - list.get(0);
        int count = range / gcd;
        System.out.println(count + 1 - list.size());
    }

    static public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
