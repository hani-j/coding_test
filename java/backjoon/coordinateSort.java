package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

// 11650
public class coordinateSort {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Node> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            arr.add(new Node(f, s));
        }
        arr.sort(new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                if (a.first == b.first)
                    return a.second > b.second ? 1 : -1;
                return a.first > b.first ? 1 : -1;
            }
        });

        // Arrays.sort(arr, new Comparator<int[]>() {
        //     public int compare(int[] o1, int[] o2) {
        //         if(o1[0] != o2[0]) {
        //             return o1[0] - o2[0];
        //         } else {
        //             return o1[1] - o2[1];
        //         }
        //     }
        // });

        for (int i = 0; i < N; i++) {
            arr.get(i).print();
            System.out.println();
        }
    }
    static class Node{

        int first;
        int second;

        public Node(int f, int s) {
            this.first = f;
            this.second = s;
        }

        public void print() {
            System.out.print(first + " " + second);
        }
    }
}
