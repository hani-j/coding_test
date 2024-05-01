package programmers;

import java.util.Arrays;

public class workout {
	static public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int j = 0; j < lost.length; j++) {
            for (int i = 0; i < reserve.length; i++) {
                if (lost[j] == reserve[i])  {
                    reserve[i] = -1;
                    lost[j] = 0;
                    answer++;
                    break;                   
                }
            }
        }
        for (int l : lost) {
            for (int i = 0; i < reserve.length; i++) {
                if (l != 0 && (l - 1 == reserve[i] || l + 1 == reserve[i])) {
                    answer++;
                    reserve[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }

	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {1, 3, 5};
		System.out.println(solution(n, lost, reserve));
	}
}
