package thisis;

import java.util.Arrays;
import java.util.Collections;

// implementation 14
public class checkWall {
	public static int solution(int n, int[] weak, int[] dist) {
        Integer[] d = new Integer[dist.length];
        for (int i = 0; i < dist.length; i++) {
            d[i] = dist[i];
        }
        Arrays.sort(d, Collections.reverseOrder());
        
		int min = 100;
		for (int i = 0; i < weak.length; i++) {
			System.out.println("====== getcount : ");
			min = Math.min(min, getCount(weak, d, i, n));
		}

		if (min == 100)
			return -1;
        return min;
    }

	public static int getCount(int[] weak, Integer[] dist, int i, int n) {
		int di = 0;
		int d = dist[di];
		int end;
		int weakDis;
		for (int j = 0; j < weak.length; j++) {
			end = i + 1 >= weak.length ? 0 : i + 1;
			System.out.println("end : " + end + " weak[i] " + weak[i] + " weak[0] " + weak[0]);
			if (end == 0 && weak[i] > n / 2)
				weakDis = n - weak[i] + weak[0];
			else
				weakDis = Math.abs(weak[end] - weak[i]);
			if (di == dist.length || dist[di] < weakDis)
				return 100;
			d = dist[di];
			System.out.println("i : " + i + " d : " + d + " weakDis : " + weakDis);
			while (d >= weakDis) {
				System.out.println("if i : " + i + " di : " + di + " d : " + d + " weakDistance : " + weakDis);
				d -= weakDis;
				i = i + 1 >= weak.length ? 0 : i + 1; 
				end = i + 1 >= weak.length ? 0 : i + 1;
				if (end == 0 && weak[i] > n / 2)
					weakDis = n - weak[i] + weak[0];
				else
					weakDis = Math.abs(weak[end] - weak[i]);
				j++;
				if (j >= weak.length)
					break;
			}
			di++;
			i = i + 1 >= weak.length ? 0 : i + 1;
			j++;
		}
		return di;
	}

	public static void main(String[] args) {
		// int n = 12;
		// int[] weak = {1, 5, 6, 10};
		// int[] dist = {1, 2, 3, 4};

		// int n = 12;
		// int[] weak = {1, 3, 4, 9, 10};
		// int[] dist = {3, 5, 7};

		// int n = 50;
		// int[] weak = {1};
		// int[] dist = {6};

		int n = 30;
		int[] weak = {0, 3, 11, 21};
		int[] dist = {10, 4};

		System.out.println(solution(n, weak, dist));
	}
}
