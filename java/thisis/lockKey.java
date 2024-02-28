package thisis;

// implementation 10
public class lockKey {

	public static boolean checkKey(int[][] lock, int[][] key, int x, int y) {
		for (int i = x, a = 0; i < lock.length; i++, a++) {
			for (int j = y, b = 0; j < lock.length; j++, b++) {
				if (a < key.length && b < key.length && lock[i][j] == key[a][b])
					return false;
			}
		}
		return true;
	}

	public static boolean checkKeyLeft(int[][] lock, int[][] key, int x, int y) {
		for (int i = x, a = 0; i < key.length; i++, a++) {
			for (int j = y, b = 0; j < key.length; j++, b++) {
				if (lock[a][b] == key[i][j])
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] key = {{0,0,0}, {1,0,0}, {0,1,1}};
		int[][] lock = {{1,1,1}, {1,1,0}, {1,0,1}};

		int[][] k2 = new int[key.length][key.length];
		int[][] k3 = new int[key.length][key.length];
		int[][] k4 = new int[key.length][key.length];

		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				k2[j][key.length-1 - i] = key[i][j];
				k3[j][i] = key[i][j];
				k4[key.length-1 - j][i] = key[i][j];
			}
		}
		boolean answer = false;
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
				if (checkKey(lock, key, i, j))
					answer = true;
				if (checkKey(lock, k2, i, j))
					answer = true;
				if (checkKey(lock, k3, i, j))
					answer = true;
				if (checkKey(lock, k4, i, j))
					answer = true;
			}
        }
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				if (checkKeyLeft(lock, key, i, j))
					answer = true;
				if (checkKeyLeft(lock, k2, i, j))
					answer = true;
				if (checkKeyLeft(lock, k3, i, j))
					answer = true;
				if (checkKeyLeft(lock, k4, i, j))
					answer = true;
			}
		}
		System.out.println(answer);
	}
}
