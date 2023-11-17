package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ageSort {
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Node(age, name));
        }
        list.sort(Comparator.comparingInt(o -> o.age)); 
        for (int i = 0; i < N; i++) {
            System.out.println(list.get(i).age + " " + list.get(i).name);
        }
    }

    static class Node{
        int age;
        String name;

        Node(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
