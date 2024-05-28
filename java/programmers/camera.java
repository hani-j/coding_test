package programmers;

import java.util.Arrays;

public class camera {
	static public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[0], b[0]));
        int min = -30000;
        int max = 30000;
        for (int i = 0; i < routes.length; i++) {
            if (routes[i][0] >= min && routes[i][0] <= max) {
                min = routes[i][0];
                if (routes[i][1] < max)
                    max = routes[i][1];
            } else {
                answer++;
                min = routes[i][0];
                max = routes[i][1];
            }
        }
        return answer;
    }

	public static void main(String[] args) {
		int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
		System.out.println(solution(routes));
	}
}
