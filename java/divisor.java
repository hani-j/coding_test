// 코딩테스트 연습 - 코딩테스트 입문
// 약수 구하기

// 문제 설명
// 정수 n이 매개변수로 주어질 때, n의 약수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ n ≤ 10,000

import java.util.List;
import java.util.ArrayList;
class Solution {
    public int[] solution(int n) {
        List<Integer> lNum = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n%i == 0)
                lNum.add(i);
        }
        return lNum.stream().mapToInt(Integer::intValue).toArray();
    }
}

return IntStream.rangeClosed(1, n).filter(i -> n % i == 0).toArray();