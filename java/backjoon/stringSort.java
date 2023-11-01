package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class stringSort {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Node> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            arr.add(new Node(word.length(), word));
        }
        arr.sort(new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                if (a.len == b.len) {
                    return a.word.compareTo(b.word);
                }
                return a.len > b.len ? 1 : -1;
            }
        });
        for (int i = 0; i < N; i++){
            System.out.println(arr.get(i).word);
        }
    }

    static class Node {
        int len;
        String word;

        Node(int l, String w) {
            this.len = l;
            this.word = w;
        }
    }
}
