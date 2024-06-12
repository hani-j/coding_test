package programmers;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class tangerine {
	static public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        List<Integer> list = new ArrayList<>();
        
        int tmp = tangerine[0];
        int count = 1;
        for (int i = 1; i < tangerine.length; i++) {
            if (tmp == tangerine[i])
                count++;
            else {
                list.add(count);
                tmp = tangerine[i];
                count = 1;
            }
        }
        list.add(count);
        
        list.sort(Collections.reverseOrder());
        int sum = 0;
        for (Integer n : list) {
            sum += n;
            answer++;
            if (sum >= k)
                break;
        }
        return answer;
    }

	public static void main(String[] args) {
		int k = 6;
		int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

		System.out.println(solution(k, tangerine));
	}
}
