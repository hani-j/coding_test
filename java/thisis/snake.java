package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.Query;

// implementation 11
public class snake {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[][] board = new int[N + 1][N + 1];
		board[1][1] = 1;
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x][y] = 2;
		}
		int L = Integer.parseInt(br.readLine());
		Queue<Node> count = new LinkedList<>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			count.add(new Node(Integer.parseInt(st.nextToken()), st.nextToken()));
		}

		int time = 0;
		int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int d = 0;
		int x = 1, y = 1;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{1, 1});
		for (int i = 0; i < 10000; i++) {
			time++;
			if (count.peek().x == i) {
				if (count.peek().d.equals("L"))
					d = d - 1 < 0 ? 3 : d - 1;
				else
					d = d + 1 > 3 ? 0 : d + 1;
			}
			x += dir[d][0];
			y += dir[d][1];
			System.out.println("time : " + time + " x : " + x + " y : " + y + " d : " + d);
			if (x < 1 || y < 1 || x > N || y > N)
				break;
			if (board[x][y] == 0) {
				board[x][y] = 1;
				int[] tmp = q.poll();
				board[tmp[0]][tmp[1]] = 0;
			} else if (board[x][y] == 1) {
				break;
			} else {
				board[x][y] = 1;
			}
			q.add(new int[]{x, y});
		}
		System.out.println(time);
	}

	static class Node{
		int x;
		String d;

		Node(int x, String d) {
			this.x = x;
			this.d = d;
		}
	}
}
