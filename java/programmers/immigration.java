package programmers;

import java.util.Arrays;

public class immigration {
	static public long solution(int n, int[] times) {
        Arrays.sort(times);
		long s = (long)times[0] * (long)n / times.length;
        long e = (long)times[times.length -1] * (long)n / times.length;
        long mid = 0;
        long answer = e;
        while (s <= e) {
            mid = (s + e) / 2;
            long count = 0;
            for (int i = 0; i < times.length; i++) {
                long t = (long)mid / (long)times[i];
                count += t;
            }
            if (count < n)
                s = mid + 1;
            else {
				if (mid < answer)
                    answer = mid;
                e = mid - 1;
			}
        }
        return answer;
    }

	public static void main(String[] args) {
		int n = 6;
		int[] times = {7, 10};
		System.out.println(solution(n, times));
	}
}
