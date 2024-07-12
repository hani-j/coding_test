package programmers;

public class pulse {
	static public long solution(int[] sequence) {
        int len = sequence.length;
        long[] arr1 = new long[len];
        long[] arr2 = new long[len];
        
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                arr1[i] = sequence[i];
                arr2[i] = -sequence[i];
            } else {
                arr1[i] = -sequence[i];
                arr2[i] = sequence[i];
            }
        }
        
        return Math.max(getMax(arr1), getMax(arr2));
    }
    
    static public long getMax(long[] arr) {
        long max = arr[0];
        long e = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            e = Math.max(arr[i], e + arr[i]);
            max = Math.max(max, e);
        }
        return max;
    }

	public static void main(String[] args) {
		int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};
		System.out.println(solution(sequence));
	}
}
