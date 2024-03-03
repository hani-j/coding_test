package thisis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// implementation 12
public class column {
	public static void main(String[] args) {
		int n = 5;
		// int[][] build_frame = {{1,0,0,1}, {1,1,1,1}, {2,1,0,1}, {2,2,1,1}, {5,0,0,1}, {5,1,0,1}, {4,2,1,1}, {3,2,1,1}};
		int[][] build_frame = {{0,0,0,1}, {2,0,0,1}, {4,0,0,1}, {0,1,1,1}, {1,1,1,1}, {2,1,1,1}, {3,1,1,1}, {2,0,0,0}, {1,1,1,0}, {2,2,0,1}};
		int[][] arr = new int[n + 1][n + 1];

		for (int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int r = build_frame[i][2];

			if (r == 0) {
				if (build_frame[i][3] == 1 && arr[x][y] < 2) {
					if (y == 0 || arr[x - 1][y] > 0 || arr[x + 1][y - 1] > 0)
						arr[x][y] += 2;
 				} else {
					if (arr[x][y] > 1 && (y == 0 || arr[x - 1][y] > 0))
						arr[x][y] -= 2;
				}
			} else {
				if (build_frame[i][3] == 1 && (arr[x][y] == 0 || arr[x][y] == 2)) {
					if (y != 0 && (arr[x][y - 1] > 1 || arr[x + 1][y - 1] > 1 || (arr[x - 1][y] == 1 && arr[x + 1][y] == 1)))
						arr[x][y] += 1;
 				} else {
					if (y > 0 && arr[x][y] > 0 && !(arr[x][y] == 3 && (arr[x - 1][y] == 1 || arr[x][y - 1] < 2)))
						arr[x][y] -= 1;
				}
			}
			System.out.println("x : " + x + " y : " + y + " arr[x][y] : " + arr[x][y]);
		}

		List<int[]> result = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (arr[i][j] > 0) {
					if (arr[i][j] == 2 || arr[i][j] == 3) {
						result.add(new int[]{i, j, 0});
					}
					if (arr[i][j] == 1 || arr[i][j] == 3) {
						result.add(new int[]{i, j, 1});
					}
				}
			}
		}

		int[][] r = new int[result.size()][3];
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < 3; j++) {
				r[i][j] = result.get(i)[j];
				System.out.print(r[i][j]);
			}
			System.out.println();
		}
	}
}
