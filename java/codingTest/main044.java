package codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// re
public class main044 {
    static ArrayList<cNode>[] A;
    static long lcm;
    static boolean visited[];
    static long D[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        lcm = 1;

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<cNode>();
        }
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            A[a].add(new cNode(b, p, q));
            A[b].add(new cNode(a, p, q));
            lcm *= (p * q / gcd(p, q)); // 최소 공배수는 두 수의 곱을 최대 공약수로 나눈 것
        }

        D[0] = lcm;
        DFS(0);
        long mgcd = D[0];
        for (int i = 1; i < N; i++) {
            mgcd = gcd(mgcd, D[i]);
        }
        for (int i = 0; i < N; i++) {
            bw.write(D[i] / mgcd + " ");
        }
        bw.write("\n");
        bw.flush();
    }

    // 최대 공약수 함수
    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static void DFS(int Node) {
        visited[Node] = true;
        for (cNode i : A[Node]) {
            int next = i.getB();
            if (!visited[next]) {
                D[next] = D[Node] * i.getQ() / i.getP();
                DFS(next);
            }
        }
    }

    static class cNode {
        int b;
        int p;
        int q;

        public cNode(int b, int p, int q) {
            super();
            this.b = b;
            this.p = p;
            this.q = q;
        }

        public int getB() {
            return b;
        }
        public int getP() {
            return p;
        }
        public int getQ() {
            return q;
        }
    }
}
