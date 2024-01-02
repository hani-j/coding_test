package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 21-3 25501
public class recursion {
	static int sum = 0;
	public static int re(String s, int l, int r){
		sum++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return re(s, l+1, r-1);
    }

    public static int isPalindrome(String s){
		sum = 0;
        return re(s, 0, s.length()-1);
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			bw.write(isPalindrome(str) + " " + sum + "\n");
		}
		bw.flush();
		bw.close();
	}
}