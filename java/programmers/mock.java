package programmers;

import java.util.ArrayList;
import java.util.List;

public class mock {
	static public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] c = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i - i / 5 * 5])
                c[0]++;
            if (answers[i] == two[i - i / 8 * 8])
                c[1]++;
            if (answers[i] == three[i - i / 10 * 10])
                c[2]++;
        }
        int max = Math.max(c[0], Math.max(c[1], c[2]));
        for (int i = 0; i < 3; i++) {
            if (c[i] == max)
                list.add(i + 1);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

	public static void main(String[] args) {
		// int[] answers = {1,2,3,4,5};
		int[] answers = {1, 3, 2, 4, 2};
		int[] re = solution(answers);
		for (int i = 0; i < re.length; i++) {
			System.out.print(re[i] + " ");
		}
	}
}
