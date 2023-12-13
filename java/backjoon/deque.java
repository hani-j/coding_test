package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 16-9 28279
public class deque {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            switch (n) { // 3 8
                case 1:
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    if (!deque.isEmpty()) {
                        sb.append(deque.pollFirst() + "\n");
                    } else
                        sb.append("-1\n");
                    break;
                case 4:
                    if (!deque.isEmpty()) {
                        sb.append(deque.pollLast() + "\n");
                    } else
                        sb.append("-1\n");
                    break;
                case 5:
                    sb.append(deque.size() + "\n");
                    break;
                case 6:
                    if (deque.isEmpty())
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case 7:
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekFirst() + "\n");
                    } else
                        sb.append("-1\n");
                    break;
                case 8:
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekLast() + "\n");
                    } else
                        sb.append("-1\n");
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
