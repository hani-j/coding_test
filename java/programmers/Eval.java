package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Eval {
	static public int solution(int[][] scores) {
        int[] wan = scores[0];
        int wanS = wan[0] + wan[1];

        Arrays.sort(scores, (a, b) -> (a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]));

        int max = 0;
        List<Integer> sums = new ArrayList<>();

        for (int[] score : scores) {
            if (score[0] >= max) {
                max = score[0];
                sums.add(score[0] + score[1]);
                if (Arrays.equals(score, wan) && score[0] < max) {
                    return -1;
                }
            } else if (Arrays.equals(score, wan)) {
                return -1;
            }
        }

		sums.add(wanS);

        Collections.sort(sums, Collections.reverseOrder());

        int rank = 1;
        for (int sum : sums) {
            if (sum == wanS) {
                return rank;
            }
            rank++;
        }

        return -1;
    }

	public static void main(String[] args) {
		int[][] scores = {{2,2},{1,4},{3,2},{3,2},{2,1}};
		System.out.println(solution(scores));
	}
}
