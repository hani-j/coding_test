package programmers;

public class Balloon {
	static public int solution(int[] a) {
        int answer = 0;
        int len = a.length;
        
        if (len == 1)
            return 1;
        
        int[] lMin = new int[len];
        int[] rMin = new int[len];
        
        lMin[0] = a[0];
        for (int i = 1; i < len; i++) {
            lMin[i] = Math.min(lMin[i - 1], a[i]);
        }
        
        rMin[len - 1] = a[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rMin[i] = Math.min(rMin[i + 1], a[i]);
        }
        
        for (int i = 0; i < len; i++) {
            if (a[i] <= lMin[i] || a[i] <= rMin[i])
                answer++;
        }
        
        return answer;
    }

	public static void main(String[] args) {
        int[] a1 = {9,-1,-5};
        System.out.println(solution(a1));

        int[] a2 = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        System.out.println(solution(a2));
    }
}
