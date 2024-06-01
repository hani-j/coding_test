package programmers;

public class num {
	static public int solution(int n) {
        int answer = 1;
        
        for (int i = 1; i <= n / 2; i++) {
            int num = i;
            int next = i + 1;
            while (num < n) {
                num += next++;
            }
            if (num == n)
                answer++;
        }
        return answer;
    }

	public static void main(String[] args) {
		int n = 15;
		System.out.println(solution(n));
	}
}
