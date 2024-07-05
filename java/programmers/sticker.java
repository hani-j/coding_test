package programmers;

import java.util.Arrays;

public class sticker {
	static public int solution(int sticker[]) {
		int len = sticker.length;
        if (len == 1)
            return sticker[0];
        else if (len == 2)
            return Math.max(sticker[0], sticker[1]);
        
        int[] d1 = new int[len];
        d1[0] = sticker[0];
        d1[1] = sticker[0];
        for (int i = 2; i < len - 1; i++) {
            d1[i] = Math.max(d1[i - 1], d1[i - 2] + sticker[i]);
        }

		int[] d2 = new int[len];
        d2[0] = 0;
        d2[1] = sticker[1];
        for (int i = 2; i < len; i++) {
            d2[i] = Math.max(d2[i - 1], d2[i - 2] + sticker[i]);
        }

		System.out.println(Arrays.toString(d1));
		System.out.println(Arrays.toString(d2));
		
        return Math.max(d1[len - 2], d2[len - 1]);
    }

	public static void main(String[] args) {
		int[] sticker1 = {14, 6, 5, 11, 3, 9, 2, 10};
		System.out.println(solution(sticker1));

		int[] sticker2 = {1, 3, 2, 5, 4};
		System.out.println(solution(sticker2));
	}
}
