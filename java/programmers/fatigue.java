package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class fatigue {
	static public int solution(int k, int[][] dungeons) {
        List<Integer> count = new ArrayList<>();
        boolean[] used = new boolean[dungeons.length];
        backtrack(dungeons, k, used, count, 0);
        count.sort(Comparator.reverseOrder());
        return count.get(0);
    }
    
    static public void backtrack(int[][] dungeons, int k, boolean[] used, List<Integer> count, int c) {
        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && !used[i]) {
                used[i] = true;
                k -= dungeons[i][1];
                count.add(c + 1);
                backtrack(dungeons, k, used, count, c + 1);
                k += dungeons[i][1];
                used[i] = false;
            }
        } 
    }

	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = {{80,20}, {50,40}, {30,10}};
		System.out.println(solution(k, dungeons));
	}
}
