package programmers;

public class primeNum {
	static public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        String s = sb.reverse().toString();
        String[] list = s.split("0");
        for (int i = 0; i < list.length; i++) {
			if (list[i].equals(""))
				continue;
            int num = Integer.parseInt(list[i]);
            if (isPrime(num))
                answer++;
        }
        
        return answer;
    }
    
    static public boolean isPrime(int n) {
		if (n == 0 || n == 1)
			return false;
        if (n == 2 || n == 3)
            return true;
        for (int i = 4; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

	public static void main(String[] args) {
		int n = 437674;
		int k = 3;
		System.out.println(solution(n, k));

		int n2 = 110011;
		int k2 = 10;
		System.out.println(solution(n2, k2));
	}
}
