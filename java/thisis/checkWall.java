package thisis;

import java.util.Arrays;
import java.util.Collections;

public class checkWall {
	public static int solution(int n, int[] weak, int[] dist) {
        Integer[] d = new Integer[dist.length];
        for (int i = 0; i < dist.length; i++) {
            d[i] = dist[i];
        }
        Arrays.sort(d, Collections.reverseOrder());
        
		int min = 100;
		for (int i = 0; i < weak.length; i++) {
			System.out.println("====== getcount : " + getCount(weak, d, i));
			min = Math.min(min, getCount(weak, d, i));
		}

		if (min == 100)
			return -1;
        return min;
    }

	public static int getCount(int[] weak, Integer[] dist, int i) {
		int di = 0;
		int d = dist[di];
		int count = 0;
		int end;
		int weakDis;
		for (int j = 0; j < weak.length; j++) {
			end = i + 1 == weak.length ? 0 : i + 1; 
			weakDis = weak[end] - weak[i];
			while (d >= weakDis) {
				System.out.println("if di : " + di + " d : " + d + " weak : " + weakDis);
				d -= weakDis;
				i = i + 1 == weak.length ? 0 : i + 1;
				end = i + 1 == weak.length ? 0 : i + 1;
				weakDis = weak[end] - weak[i];
				count++;
				if (count > weak.length)
					break;
			}
			if (di + 1 >= dist.length || dist[di + 1] < weakDis)
				return 100;
			di++;
			d = dist[di];
		}
		return di;
	}

	public static void main(String[] args) {
		int n = 12;
		int[] weak = {1, 5, 6, 10};
		int[] dist = {1, 2, 3, 4};

		// int n = 12;
		// int[] weak = {1, 3, 4, 9, 10};
		// int[] dist = {3, 5, 7};

		System.out.println(solution(n, weak, dist));
	}
}
