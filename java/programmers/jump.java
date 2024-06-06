package programmers;

public class jump {
	static public int solution(int n) {
        int ans = 0;
        
        while (0 < n) {
            if (n % 2 == 0)
                n /= 2;
            else {
                n--;
                ans++;
            }
        }

        return ans;
    }

	public static void main(String[] args) {
		int N = 5;
		int N2 = 6;
		int N3 = 5000;
		
		System.out.println(solution(N));
		System.out.println(solution(N2));
		System.out.println(solution(N3));
	}
}
