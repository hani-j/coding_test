// 코딩테스트 연습 - 코딩테스트 입문
// 7의 개수

// 문제 설명
// 머쓱이는 행운의 숫자 7을 가장 좋아합니다. 정수 배열 array가 매개변수로 주어질 때, 7이 총 몇 개 있는지 return 하도록 solution 함수를 완성해보세요.

// 제한사항
// 1 ≤ array의 길이 ≤ 100
// 0 ≤ array의 원소 ≤ 100,000

import java.util.Arrays;
class Solution {
    public int solution(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count += Arrays.stream(String.valueOf(array[i]).split("")).filter(n -> n.equals("7")).count();
        }
        return count;
    }
}