package thisis;

public class lockKeyAns {
	public static void main(String[] args) {
		int[][] key = {{0,0,0}, {1,0,0}, {0,1,1}};
		int[][] lock = {{1,1,1}, {1,1,0}, {1,0,1}};

		int n = lock.length;
		int m = key.length;
		int[][] new_lock = new int[n * 3][n * 3];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				new_lock[i + n][j + n] = lock[i][j];
			}
		}

		boolean result = false;
		for (int lot = 0; lot < 4; lot++) {
			key = rotateDegree(key);
			for (int x = 0; x < n * 2; x++) {
				for (int y = 0; y < n * 2; y++) {
					for (int i = 0; i < m; i++) {
						for (int j = 0; j < m; j++) {
							new_lock[x + i][y + j] += key[i][j];
						}
					}
					if (check(new_lock) == true)
						result = true;
					for (int i = 0; i < m; i++) {
						for (int j = 0; j < m; j++) {
							new_lock[x + i][y + j] -= key[i][j];
						}
					}
				}
			}
		}
		System.out.println(result);
	}

	public static int[][] rotateDegree(int[][] a) {
		int n = a.length;
		int m = a[0].length;

		int[][] result = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[j][n - i - 1] = a[i][j];
			}
		}
		return result;
	}

	public static boolean check(int[][] lock) {
		int len = lock.length / 3;
		for (int i = len; i < len * 2; i++) {
			for (int j = len; j < len * 2; j++) {
				if (lock[i][j] != 1)
					return false;
			}
		}
		return true;
	}
}
