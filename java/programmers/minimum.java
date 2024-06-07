package programmers;

import java.util.Arrays;

public class minimum {
	static public int solution(int[] arr) {
        int answer = 1;
        
        int n = 2;
        while (true) {
			int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % n == 0)
                    count++;
            }
            if (count > 0) {
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] % n == 0)
						arr[i] /= n;
				}
				answer *= n;
                n = 2;
				Arrays.sort(arr);
            } else
                n++;
			if (n > arr[arr.length - 1])
				break;
        }

		for (int i = 0; i < arr.length; i++) {
			answer *= arr[i];
		}
        return answer;
    }
	
	// public static int gcd(int a, int b) {
    //     if(b == 0) 
	// 		return a;
    //     return gcd(b, a%b);
    // }

	public static void main(String[] args) {
		int[] arr = {2, 6, 8, 14};
		int[] arr2 = {1, 2, 3};
		int[] arr3 = {2, 7, 14};

		System.out.println(solution(arr));
		System.out.println(solution(arr2));
		System.out.println(solution(arr3));
	}
}
