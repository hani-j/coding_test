package programmers;

public class next {
	static public int solution(int n) {
        int answer = 0;
        int c = getCount(n);
    
        while (answer != c) {
            answer = getCount(++n);
            // answer = Integer.bitCount(++n);
        }
        
        return n;
    }
    
    static public int getCount(int n) {
        int num = 0;
        while (n >= 1) {
            if (n % 2 != 0)
                num++;
            n /= 2;
        }
        return num;
    }

	public static void main(String[] args) {
		int n = 78;
		System.out.println(solution(n));
	}
}
