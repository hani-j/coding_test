package codingTest;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.IOException;

public class main010 {

    static class Node {
        public int value;
        public int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arrlen = Integer.parseInt(st.nextToken());
        int window = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new LinkedList<>();
        for (int i = 0; i < arrlen; i++) {
            int n = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.getLast().value > n) {
                deque.removeLast();
            }
            deque.addLast(new Node(n, i));
            if (deque.getFirst().index < i - window + 1)
                deque.removeFirst();
            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }
}
