package programmers;

public class base {
	static public int solution(int n, int[] stations, int w) {
        int answer = 0;
		int s = 1;
		int len = 0;
        for (int i = 0; i < stations.length; i++) {
			int e = Math.max(stations[i] - w, 1);
            len = e - s;
            if (len > 0)
				answer += (int)Math.ceil((double)len / (w * 2 + 1));
			s = stations[i] + w + 1;
        }
		len = n - s + 1;
		if (len > 0)
			answer += (int)Math.ceil((double)len / (w * 2 + 1));

        return answer;
    }

	// public int solution(int n, int[] stations, int w) {
    //     int answer = 0;
    //     int[] apt = new int[n + 1];
    //     for (int i = 0; i < stations.length; i++) {
    //         int s = Math.max(stations[i] - w, 1);;
    //         int e = stations[i] + w;
    //         while (s <= e && s <= n) {
    //             apt[s++] = 1;
    //         }
    //     }
        
    //     int x = 0;
    //     for (int i = 1; i <= n; i++) {
    //         if (apt[i] == 0) {
    //             x++;
    //         } else if (apt[i] == 1 && x > 0) {
    //             answer += (int)Math.ceil((double)x / (w * 2 + 1));
    //             x = 0;
    //         }
    //     }
	// 	if (x > 0)
	// 		answer += (int)Math.ceil((double)x / (w * 2 + 1));

    //     return answer;
    // }

	public static void main(String[] args) {
		int N1 = 11;
		int[] stations1 = {4, 11};
		int W1 = 1;
		System.out.println(solution(N1, stations1, W1));
		
		int N2 = 16;
		int[] stations2 = {9};
		int W2 = 2;
		System.out.println(solution(N2, stations2, W2));
	}
}
