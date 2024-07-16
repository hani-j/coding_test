package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Multi {
	static int[] result;

	static public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int len = enroll.length;
        result = new int[len];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(enroll[i], i);
        }

		int[] refer = new int[len];
        for (int i = 0; i < len; i++) {
            if (referral[i].equals("-"))
                refer[i] = -1;
			else
				refer[i] = map.get(referral[i]);
        }
        
        for (int i = 0; i < seller.length; i++) {
            int idx = map.get(seller[i]);
            dfs(refer, idx, amount[i] * 100);
        }
        
        return result;
    }
    
    static public void dfs(int[] r, int s, int a) {
		if ((int)(a * 0.1) == 0)
			result[s] += a;
		else
			result[s] += a - (int)(a * 0.1);

        if (r[s] > -1) {
            dfs(r, r[s], (int)(a * 0.1));
        }
    }

	public static void main(String[] args) {
		String[] enroll1 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral1 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] selle1 = {"young", "john", "tod", "emily", "mary"};
		int[] amount1 = {12, 4, 2, 5, 10};
		int[] result1 = solution(enroll1, referral1, selle1, amount1);
		System.out.println(Arrays.toString(result1));

		String[] enroll2 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral2 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] selle2 = {"sam", "emily", "jaimie", "edward"};
		int[] amount2 = {2, 3, 5, 4};
		int[] result2 = solution(enroll2, referral2, selle2, amount2);
		System.out.println(Arrays.toString(result2));
	}
}
