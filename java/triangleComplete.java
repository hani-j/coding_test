// 코딩테스트 연습 - 코딩테스트 입문
// 삼각형의 완성조건 (1)

// 문제 설명
// 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.

// 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
// 삼각형의 세 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다. 세 변으로 삼각형을 만들 수 있다면 1, 만들 수 없다면 2를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// sides의 원소는 자연수입니다.
// sides의 길이는 3입니다.
// 1 ≤ sides의 원소 ≤ 1,000

import java.util.Arrays;

class Solution {
    public int solution(int[] sides) {
        Arrays.stream(sides).sorted();
        int[] sort = Arrays.stream(sides).sorted().toArray();
        return sort[2] < sides[0] + sort[1] ? 1 : 2;
    }
}

// Arrays.sort()