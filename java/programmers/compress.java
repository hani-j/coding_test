package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class compress {
	static public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        String[] dict = new String[1001];
        for (int i = 0; i < 26; i++)
            dict[i + 1] = 'A' + i + "";
        
        String tmp = "";
		int idx = 27;
        for (int i = 0; i < msg.length(); i++) {
			tmp += msg.charAt(i);
			int n = find(dict, tmp, idx);
			
			if (n > 0)
				continue;
			else {
				dict[idx++] = tmp;
				answer.add(find(dict, tmp.substring(0, tmp.length() - 1), idx));
				tmp = tmp.substring(tmp.length() - 1, tmp.length());
			}
		}
		answer.add(find(dict, tmp, idx));

        return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	static public int find(String[] dict, String target, int idx) {
		if (target.length() == 1)
			return target.charAt(0) - 'A' + 1;
		for (int i = 27; i < idx; i++) {
			if (dict[i].equals(target))
				return i;
		}
		return -1;
	}
 
	public static void main(String[] args) {
		String msg = "KAKAO";
		int[] result = solution(msg);
		System.out.println(Arrays.toString(result));
	}
}
