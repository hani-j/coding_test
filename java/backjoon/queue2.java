package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 16-6 18258
public class queue2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<Integer>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (st.hasMoreTokens()) {
                String s = st.nextToken();
                queue.add(Integer.parseInt(s));
                continue;
            }

            switch (str) {
                case "pop":
                    if (queue.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(queue.pollFirst() + "\n");
                    break;

                case "size":
                    sb.append(queue.size() + "\n");
                    break;

                case "empty":
                    if (queue.isEmpty())
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;

                case "front":
                    if (queue.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(queue.peekFirst() + "\n");
                    break;

                case "back":
                    if (queue.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(queue.peekLast() + "\n");
                    break;
            
                default:
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
