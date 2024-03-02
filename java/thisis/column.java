package thisis;

import java.util.Arrays;

// implementation 12
public class column {
	public static void main(String[] args) {
		int n = 5;
		int[][] build_frame = {{1,0,0,1}, {1,1,1,1}, {2,1,0,1}, {2,2,1,1}, {5,0,0,1}, {5,1,0,1}, {4,2,1,1}, {3,2,1,1}};
		int[][] arr = new int[n + 1][n + 1];

		for (int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int r = build_frame[i][2];

			if (r == 0) {
				if (build_frame[i][3] == 1) {
					if (x == 0 || arr[x][y - 1] == 1)
						arr[x][y] = 1;
 				} else {
					if (y > 0 && (arr[x][y - 1] == 1 || arr[x][y - 1] == 3))
						arr[x][y] = 1;
				}
			} else {
				if (build_frame[i][3] == 1) {
					if (y != 0 && arr[x - 1][y] == 1 || (arr[x - 1][y] == 2 && arr[x + 1][y] == 2))
						arr[x][y] = 1;
 				} else {
					if (y > 0 && (arr[x][y - 1] == 1 || arr[x][y - 1] == 3))
						arr[x][y] = 1;
				}
			}

		}
	}
}
