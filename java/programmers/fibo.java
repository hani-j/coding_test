package programmers;

public class fibo {
	static public int solution(int n) {
		return fibo(n);
	}
	
	static public int fibo(int n) {
		int[] fibo = new int[n + 1];
		fibo[0] = 0;
		fibo[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
		}
		return fibo[n];
	}

	public static void main(String[] args) {
		int n = 3;
		System.out.println(solution(3));
	}
}
