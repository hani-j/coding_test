package thisis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lyrics {
	public static void main(String[] args) {
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		int[] result = solution(words, queries);
		for (int i : result)
			System.out.println(i);
	}

	static public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
		int idx = 0;
		List<String>[] arr = new List[10001];
		List<String>[] r_arr = new List[10001];
		for (int i = 0; i < 10001; i++) {
			arr[i] = new ArrayList<>();
			r_arr[i] = new ArrayList<>();
		}

		for (String w : words) {
			arr[w.length()].add(w);
			String r = new StringBuilder(w).reverse().toString();
			r_arr[w.length()].add(r);			
		}

		for (int i = 0; i < 10001; i++) {
			arr[i].sort(null);
			arr[i].sort(Collections.reverseOrder());
		}

		for (String q : queries) {
			int r = 0;
			if (q.charAt(0) != '?') {
				r = count(arr[q.length()], q.replace('?', 'a'), q.replace('?', 'z'));
			} else {
				String rq = new StringBuilder(q).reverse().toString();
				r = count(r_arr[q.length()], rq.replace('?', 'a'), rq.replace('?', 'z'));
			}
			answer[idx++] = r;
		}
        return answer;
    }

	static public int count(List<String> arr, String left, String right) {
		int r = bisectRight(arr, right);
		int l = bisectLeft(arr, left);
		return r - l;
	}

	private static int bisectLeft(List<String> list, String target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int bisectRight(List<String> list, String target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).compareTo(target) <= 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
