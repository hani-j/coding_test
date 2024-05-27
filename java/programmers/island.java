package programmers;

import java.util.Arrays;

public class island {
	static public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int visited = 0;
        
        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];
            
            if (find_parent(parent, a) != find_parent(parent, b)) {
                union_parent(parent, a, b);
                answer += c;
                visited++;
                
                if (visited == n - 1)
                    break;
            }
        }
        return answer;
    }
    
    static public int find_parent(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find_parent(parent, parent[x]);
        return parent[x];
    }
    
    static public void union_parent(int[] parent, int a, int b) {
        a = find_parent(parent, a);
        b = find_parent(parent, b);
        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }

	public static void main(String[] args) {
		int n = 4;
		int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
		System.out.println(solution(n, costs));
	}
}
