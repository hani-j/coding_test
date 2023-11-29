package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

// 13-1 18870
public class coordinateCompression {
    static List<Integer> list;
    static List<Integer> sortList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Set<Integer> set = new HashSet<>(list);
        sortList = new ArrayList<>(set);
        Collections.sort(sortList);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(binarySearch(list.get(i)) + " ");
        }
        System.out.println(sb.toString());
    }

    static public int binarySearch(int n) {
        int s = 0;
        int e = sortList.size()-1;
        int mid = 0;
        while (s <= e) {
            mid = (s + e) / 2;
            int value = sortList.get(mid);
            if (value > n) {
                e = mid - 1;
            } else if (value < n) {
                s = mid + 1;
            } else {
                return mid;
            }
        }
        return mid;
    } 
}

/*  
    Map<Integer,Integer> map = new HashMap<>();
    int rank = 0;
    for (int i = 0; i < arr.length; i++) {
        if(!map.containsKey(arr[i])){
            map.put(arr[i],rank++);
        }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < result.length; i++) {
        sb.append(map.get(result[i])).append(" ");
    }
 */