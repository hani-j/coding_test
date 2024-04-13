package programmers;

import java.util.HashSet;
import java.util.Set;

public class phone {
	static public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int mid = nums.length / 2;
        if (mid >= set.size())
            answer = set.size();
        else if (mid < set.size())
            answer = mid;
        return answer;
    }

	public static void main(String[] args) {
		int[] nums = {3, 1, 2, 3};
		System.out.println(solution(nums));
	}
}
