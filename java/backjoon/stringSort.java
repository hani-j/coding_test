package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// 13-9 1181
public class stringSort {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // List<Node> arr = new ArrayList<>();
        Set<String> arr = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            arr.add(word);
        }
        List<String> sortedList = arr.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() == b.length()) {
                    return a.compareTo(b);
                }
                return a.length() > b.length() ? 1 : -1;
            }
        }).collect(Collectors.toList());
        sortedList.stream().forEach(c -> System.out.println(c));
    }
}
